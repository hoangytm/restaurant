package hoangytm.restaurant.controller;

import hoangytm.restaurant.constants.CommonConstants;
import hoangytm.restaurant.entity.ApiResponse;
import hoangytm.restaurant.entity.User;
import hoangytm.restaurant.i18n.Translator;
import hoangytm.restaurant.repo.RoleRepo;
import hoangytm.restaurant.repo.UserRepo;
import hoangytm.restaurant.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.cache.annotation.CacheResult;
import java.util.List;

/**
 * @author PhanHoang
 * 2/8/2020
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private Translator translator;
    @Autowired
    private UserService userService;
    @Autowired
    private JavaMailSender javaMailSender;

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

    @PostMapping("/register")
    public ApiResponse register(@RequestBody User user) {
        User result = userService.  registerUser(user);
        return ApiResponse.builder().code(CommonConstants.RESPONSE_STATUS.SUCCESS)
                .message("thanh cong")
                .data(result)
                .build();
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody User user) {
        User result = userService.  registerUser(user);
        return ApiResponse.builder().code(CommonConstants.RESPONSE_STATUS.SUCCESS)
                .message(translator.toLocale("label.success"))
                .data(result)
                .build();
    }
    @GetMapping("/findUser")
    @PreAuthorize("permitAll()")
    public ApiResponse findUser( User user) {
        List<User> result = userService.findUser(user);
        return ApiResponse.builder().code(CommonConstants.RESPONSE_STATUS.SUCCESS)
                .message(translator.toLocale("label.success"))
                .data(result)
                .build();
    }
}
