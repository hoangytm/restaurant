package hoangytm.HandleExceptionSpringSecurity.controller;

import hoangytm.HandleExceptionSpringSecurity.service.FacebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/fb")

public class FacebookController {

    @Autowired
    FacebookService facebookService;

    @GetMapping("/facebookGenerateUrl")
    public String FacebookGenerateUrl() {
        return facebookService.facebookGenerateUrl();
    }

    @GetMapping("/welcome")
    @PreAuthorize("permitAll()")
    public List<String> welcome() {
        List<String> urls = new ArrayList<>();
        urls.add("http://localhost:8080/fb/facebookGenerateUrl");
        urls.add("http://localhost:8080/fb/getUserData");
        return urls;
    }

    @GetMapping("/facebook")
//@PreAuthorize("hasRole('ADMIN')")
    public String generateFacebookAccessToken(@RequestParam(defaultValue = "code") String code) {
        return facebookService.generateFacebookAccessToken(code);
    }

    @GetMapping("/getUserData")
    public String getUserData(@RequestParam String accessToken) {
        return facebookService.getUserData(accessToken);
    }

}
