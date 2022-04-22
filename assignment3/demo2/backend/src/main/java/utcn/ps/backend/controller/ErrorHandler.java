package utcn.ps.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import utcn.ps.backend.dto.ErrorDto;

@Component
@RestControllerAdvice // is an advice that we give to RestControllers to tell them how they should handle errors
public class ErrorHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NullPointerException.class)
    public ErrorDto handleNPE(NullPointerException ex) {
        return new ErrorDto("NPE");
    }
}
