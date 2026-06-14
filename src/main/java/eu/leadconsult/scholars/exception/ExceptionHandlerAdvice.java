package eu.leadconsult.scholars.exception;

import eu.leadconsult.scholars.exception.code.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
@AllArgsConstructor
public class ExceptionHandlerAdvice {

    private final MessageSource messageSource;

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ApiError> handleRuntimeException(RuntimeException ex) {
        ApiError apiError = createApiError(ex, ErrorCode.RUNTIME_EXCEPTION);
        return new ResponseEntity<>(apiError, apiError.getErrorCode().getHttpStatus());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        ApiError apiError = createApiError(ex, ErrorCode.METHOD_ARGUMENT_NOT_VALID);
        return new ResponseEntity<>(apiError, apiError.getErrorCode().getHttpStatus());
    }

    @ExceptionHandler({ScholarException.class})
    public ResponseEntity<ApiError> handleScholarException(ScholarException ex) {
        ApiError apiError = createApiError(ex, ex.getErrorCode());
        return new ResponseEntity<>(apiError, apiError.getErrorCode().getHttpStatus());
    }

    private ApiError createApiError(Throwable ex, ErrorCode errorCode) {
        log.error("Error occurred: {}", ex.getMessage(), ex);
        String message = messageSource
                .getMessage(errorCode.name(), null, LocaleContextHolder.getLocale());
        return new ApiError(message, errorCode);
    }
}
