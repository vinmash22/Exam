package pro.sky.java.course2.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.HashSet;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    @Autowired
    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (questionService.getAll().size() < amount) {
            throw new RequestOverSizeException("Запрошено большее количество вопросов, чем хранится в сервисе");
        }
        Set<Question> questionSet = new HashSet<>(amount);
        while (questionSet.size() < amount) {
            Question question = questionService.getRandomQuestion();
            questionSet.add(question);

        }
        return questionSet;
    }
}
