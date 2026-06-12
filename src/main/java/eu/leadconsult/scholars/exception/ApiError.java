package eu.leadconsult.scholars.exception;

import eu.leadconsult.scholars.exception.code.ErrorCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class ApiError {

  private String message;

  private ErrorCode errorCode;

  private final String exceptionId;

  private final LocalDateTime timestamp;

  public ApiError(String message, ErrorCode errorCode) {
    this.message = message;
    this.errorCode = errorCode;
    timestamp = LocalDateTime.now();
    exceptionId = UUID
        .randomUUID().toString().replace("-", "");
  }
}