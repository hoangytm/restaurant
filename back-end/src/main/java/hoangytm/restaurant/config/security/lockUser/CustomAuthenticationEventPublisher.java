package hoangytm.restaurant.config.security.lockUser;

import hoangytm.restaurant.utils.GetIP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * @author PhanHoang
 * 3/1/2020
 */
@Component
public class CustomAuthenticationEventPublisher implements AuthenticationEventPublisher {
    @Autowired
    LoginAttemptService loginAttemptService;
    @Override
    public void publishAuthenticationSuccess(Authentication authentication) {
       String ip= GetIP.getClientIP().replace(":","").replace(" ","");
       loginAttemptService.loginSucceeded(ip);

    }

    @Override
    public void publishAuthenticationFailure(AuthenticationException e, Authentication authentication) {
        String ip= GetIP.getClientIP().replace(":","").replace(" ","");
        loginAttemptService.loginFailed(ip);

    }
}
