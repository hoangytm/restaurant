package hoangytm.HandleExceptionSpringSecurity.service;

public interface FacebookService {
    String facebookGenerateUrl();

    String  generateFacebookAccessToken(String code);

    String getUserData(String accessToken);
}
