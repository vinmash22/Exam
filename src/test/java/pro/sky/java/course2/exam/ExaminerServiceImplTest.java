package pro.sky.java.course2.exam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collection;
import java.util.List;

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
                new Question("1", "1"));
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


}