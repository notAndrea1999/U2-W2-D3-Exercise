package andreademasi.U2W2D3Exercise.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST) // 400
    public ErrorsPayload handleBadRequest(BadRequestException e) {

        return new ErrorsPayload(e.getMessage(), new Date());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)  // 404
    public ErrorsPayload handleNotFound(NotFoundException e) {
        return new ErrorsPayload(e.getMessage(), new Date());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)  // 500
    public ErrorsPayload handleGeneric(Exception e) {
        e.printStackTrace();
        return new ErrorsPayload("Problema lato server...giuro che lo risolveremo presto", new Date());
    }
}
