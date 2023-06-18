package pro.sky.java.course2.exam;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    JavaQuestionService service = new JavaQuestionService();

    @Test
    void addTest() {
        Question expected = new Question("Вопрос1", "Ответ1");
        Question actual = service.add("Вопрос1", "Ответ1");
        assertEquals(expected, actual);
    }

    @Test
    void testAdd() {
        Question expected = new Question("Вопрос1", "Ответ1");
        Question actual = service.add(new Question("Вопрос1", "Ответ1"));
        assertEquals(expected, actual);
    }

    @Test
    void removeTest() {
        Question expected = new Question("Вопрос1", "Ответ1");
        service.add("Вопрос1", "Ответ1");
        assertEquals(1, service.getAll().size());
        assertEquals(expected, service.getAll().iterator().next());

        service.remove(new Question("Вопрос1", "Ответ1"));
        assertEquals(0, service.getAll().size());
    }

    @Test
    void getAllTest() {
        service.add("Вопрос1", "Ответ1");
        service.add("Вопрос2", "Ответ2");
        Collection<Question> questions = service.getAll();
        assertEquals(2, questions.size());

        List<Question> expected = List.of(

                new Question("Вопрос1", "Ответ1"),
                new Question("Вопрос2", "Ответ2"));

        assertIterableEquals(expected, questions);
    }

    @Test
    void getRandomQuestionTest() {
        service.add("Вопрос1", "Ответ1");
        service.add("Вопрос2", "Ответ2");
        Collection<Question> questions = service.getAll();
        Question random = service.getRandomQuestion();
        assertTrue(questions.contains(random));
    }
}