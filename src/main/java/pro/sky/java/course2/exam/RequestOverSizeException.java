package pro.sky.java.course2.exam;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequestOverSizeException extends RuntimeException {

    public RequestOverSizeException(String message) {
        super(message);
    }

}
