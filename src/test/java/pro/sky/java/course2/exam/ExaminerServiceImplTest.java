package pro.sky.java.course2.exam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ExaminerServiceImplTest {

    @Mock
    JavaQuestionService javaQuestionServiceMock;
    ExaminerServiceImpl service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        service = new ExaminerServiceImpl(javaQuestionServiceMock);
    }

    @Test
    void requestOverSizeExceptionTest() {
        List<Question> questions = List.of(

                new Question("1", "1"),
                new Question("2", "2"));
        when(javaQuestionServiceMock.getAll()).thenReturn(questions);
        assertThrows(RequestOverSizeException.class, () -> service.getQuestions(3));
    }

    @Test
    void getQuestionsTest() {
        Question expected = new Question("Вопрос1", "Ответ1");
        Question actual = new Question("Вопрос1", "Ответ1");
        when(javaQuestionServiceMock.getRandomQuestion()).thenReturn(actual);
        assertEquals(expected, actual);

    }

    @Test
    void getQuestionsTest1() {
        List<Question> questions = List.of(

                new Question("1", "1"),
                new Question("2", "2"));
        when(javaQuestionServiceMock.getAll()).thenReturn(questions);
        Collection<Question> questionSet = service.getQuestions(2);
        assertEquals(2, questionSet.size());

    }

    @Test
    void getQuestionsTest2() {
        List<Question> questions = List.of(
                new Question("1", "1"),
                new Question("2", "2"));
        when(javaQuestionServiceMock.getAll()).thenReturn(questions);
        when(javaQuestionServiceMock.getRandomQuestion()).thenReturn(new Question("1", "1"), new Question("2", "2"));
        var actual = service.getQuestions(2);
        assertEquals(2, actual.size());

    }


}