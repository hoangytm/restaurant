package hoangytm.restaurant.exception;

import lombok.Data;

/**
 * @author PhanHoang
 * 12/23/2020
 */

@Data
public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

}