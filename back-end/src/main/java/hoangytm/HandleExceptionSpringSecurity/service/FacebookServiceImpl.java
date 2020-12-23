package hoangytm.HandleExceptionSpringSecurity.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Service;

@Service
public class FacebookServiceImpl implements FacebookService {

    private String accessToken;
    @Value("${spring.social.facebook.app-id}")
    private String facebookId;
    @Value("${spring.social.facebook.app-secret}")
    private String facebookSecret;

    private FacebookConnectionFactory createConnection() {
        return new FacebookConnectionFactory(facebookId, facebookSecret);
    }

    @Override
    public String facebookGenerateUrl() {
        OAuth2Parameters parameters = new OAuth2Parameters();
        parameters.setRedirectUri("http://localhost:8080/fb/facebook");
        parameters.setScope("email");

        return createConnection().getOAuthOperations().buildAuthorizeUrl(parameters);
    }

    @Override
    public String generateFacebookAccessToken(String code) {
        accessToken = createConnection().getOAuthOperations()
                .exchangeForAccess(code, "http://localhost:8080/fb/facebook", null)
                .getAccessToken();
        return accessToken;
    }

    @Override
    public String getUserData(String accessToken) {
        Facebook facebook = new FacebookTemplate(accessToken);
        String[] fields = {"id", "first_name", "name", "email", "birthday", "gender", "age_range"
                , "hometown", "inspirational_people"};
        return facebook.fetchObject("me", String.class, fields);
    }
}
