package eu.leadconsult.scholars.exception.code;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Getter
public enum ErrorCode {

    RESOURCE_NOT_FOUND(NOT_FOUND),
    RUNTIME_EXCEPTION(BAD_REQUEST);

    private final HttpStatus httpStatus;

    ErrorCode(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

}
