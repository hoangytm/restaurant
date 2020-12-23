package hoangytm.HandleExceptionSpringSecurity.controller;

import hoangytm.HandleExceptionSpringSecurity.constants.CommonConstants;
import hoangytm.HandleExceptionSpringSecurity.entity.ApiResponse;
import hoangytm.HandleExceptionSpringSecurity.entity.User;
import hoangytm.HandleExceptionSpringSecurity.i18n.Translator;
import hoangytm.HandleExceptionSpringSecurity.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.*;

import javax.cache.annotation.CacheResult;

/**
 * @author PhanHoang
 * 2/8/2020
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    Translator translator;
    @Autowired
    UserService userService;
    @Autowired
    private JavaMailSender javaMailSender;

    @GetMapping("/test")
    @ApiOperation(value = "test api", response = User.class)
    public ResponseEntity<?> testApi() {
        User user = new User();
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage(translator.toLocale("label.password"));
        apiResponse.setData(user);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("test-cache")
    @ApiOperation(value = "test cache", authorizations = {@Authorization(value = "Bearer")}, response = ApiResponse.class)
    @CacheResult(cacheName = "people")
    public ResponseEntity<?> testCache() throws InterruptedException {
        ApiResponse apiResponse = new ApiResponse();
        Thread.sleep(5000);
        apiResponse.setCode(200);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/rollback")
    public ResponseEntity<?> rollBack() {
        userService.deleteUser();
        ApiResponse apiResponse = new ApiResponse();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/activation/{id}")
    public ApiResponse sendEmail(@PathVariable Long id) {

        SimpleMailMessage message = new SimpleMailMessage();

        User user = userService.findUserById(id);
        message.setTo(user.getEmail());
        message.setSubject("ACTIVE YOU ACOUNT");
        message.setText("Please access this URL for activating your account  " +
                CommonConstants.URL_ACTIVE_USER + user.getId().toString());
        javaMailSender.send(message);
        return new ApiResponse(200, "send email success");
    }

    @GetMapping("/activation/check/{id}")
    public ApiResponse activeUser(@PathVariable Long id) {

        User user = userService.findUserById(id);
        user.setActive(1);
        userService.updateUser(user);
        return new ApiResponse(200, "your account is activated");
    }

}
