package com.rachacartaserver.infra.configs;

import com.rachacartaserver.exceptions.ResponseException;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.PrintWriter;
import java.io.StringWriter;

@ControllerAdvice
public class ControllerAdviceConfiguration {
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ResponseException> handleNullPointerExceptions(Exception e) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(new ResponseException(status,e.getMessage()),status);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseException> handleExceptions(Exception error) {
        String stackTrace = this.getStringStackTrace(error);
        HttpStatus status = this.getHttpStatus(error);
        String message = this.getMessage(error);

        return new ResponseEntity<>(
                new ResponseException(status, message, stackTrace),
                status
        );
    }

    private String getStringStackTrace (Exception error) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        error.printStackTrace(printWriter);
        String stackTrace = stringWriter.toString();

        return stackTrace;
    }

    private HttpStatus getHttpStatus (Exception error) {
        ResponseStatus httpAnnotation = AnnotationUtils.findAnnotation(error.getClass(), ResponseStatus.class);
        if (httpAnnotation == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return httpAnnotation.value();
    }

    private String getMessage (Exception error) {
        ResponseStatus httpAnnotation = AnnotationUtils.findAnnotation(error.getClass(), ResponseStatus.class);
        if (httpAnnotation == null) {
            return "Ocorreu um erro interno, tente novamente mais tarde";
        }

        return httpAnnotation.reason();
    }
}
