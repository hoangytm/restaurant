package hoangytm.restaurant.utils;

import hoangytm.restaurant.entity.User;
import hoangytm.restaurant.exception.BusinessException;

/**
 * @author PhanHoang
 * 12/23/2020
 */
public class CommonValidate {
    public static boolean validateUser(User user) {
        if (user == null) throw new BusinessException("user null");
        else {
            if (user.getUsername() == null || user.getUsername().isEmpty())
                throw new BusinessException("user name problem");
            if (user.getEmail() == null || user.getEmail().isEmpty()) throw new BusinessException("password problem");
        }
        return true;
    }
}
