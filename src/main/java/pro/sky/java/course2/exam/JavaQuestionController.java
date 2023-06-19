package pro.sky.java.course2.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

    @RestController
    @RequestMapping(path = "/exam/java")
    public class JavaQuestionController {

        private final QuestionService service;

        @Autowired
        public JavaQuestionController(QuestionService service) {
            this.service = service;
        }

        @GetMapping()
        public Collection<Question> getQuestions() {
            return service.getAll();
        }

        @GetMapping(path = "/add")
        public Question addQuestion(@RequestParam(name = "question") String question,
                                    @RequestParam(name = "answer") String answer
        ) {
            return service.add(question, answer);
        }
        @GetMapping(path = "/remove")
        public Question removeQuestion(@RequestParam(name = "question") String question,
                                       @RequestParam(name = "answer") String answer
        ) {
            return service.remove(new Question(question, answer));
        }

    }
