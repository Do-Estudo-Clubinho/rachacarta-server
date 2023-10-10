package com.rachacartaserver.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import java.util.Date;

@Getter
@Setter
public class ResponseException {
    // customizing timestamp serialization format
    private Date timestamp;

    private int code;

    private String status;

    private String message;

    private String stackTrace;

    private Object data;

    public ResponseException() {
        timestamp = new Date();
    }

    public ResponseException(HttpStatus httpStatus, String message) {
        this();

        this.code = httpStatus.value();
        this.status = httpStatus.name();
        this.message = message;
    }

    public ResponseException(
            HttpStatus httpStatus,
            String message,
            String stackTrace
    ) {
        this(httpStatus, message);

        this.stackTrace = stackTrace;
    }

    public ResponseException(
            HttpStatus httpStatus,
            String message,
            String stackTrace,
            Object data
    ) {
        this(httpStatus, message, stackTrace);

        this.data = data;
    }
}