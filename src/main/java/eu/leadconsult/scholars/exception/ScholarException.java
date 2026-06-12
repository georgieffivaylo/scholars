package eu.leadconsult.scholars.exception;

import eu.leadconsult.scholars.exception.code.ErrorCode;
import lombok.Getter;

@Getter
public class ScholarException extends RuntimeException {

    private final ErrorCode errorCode;

    public ScholarException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
