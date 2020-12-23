package hoangytm.restaurant.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

/**
 * @author PhanHoang
 * 12/23/2020
 */

public class ApiException {
    public final String message;
    //    public final Throwable throwable;
    public final HttpStatus status;
    public final int code = HttpStatus.BAD_REQUEST.value();
    public final ZonedDateTime timestamp;

    public ApiException(String message, HttpStatus status, ZonedDateTime timestamp) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
    }
}
