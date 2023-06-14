package pro.sky.java.course2.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

    @RestController
    public class ExamController {

        private final ExaminerService service;

        @Autowired
        public ExamController(ExaminerService service) {
            this.service = service;
        }

        @GetMapping(path = "/exam/get/{amount}")
        public Collection<Question> getQuestions(@PathVariable int amount) {
            return service.getQuestions(amount);
        }
}
