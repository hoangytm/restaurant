package hoangytm.restaurant.controller;

import hoangytm.restaurant.constants.CommonConstants;
import hoangytm.restaurant.entity.ApiResponse;
import hoangytm.restaurant.entity.Role;
import hoangytm.restaurant.entity.User;
import hoangytm.restaurant.service.RoleService;
import org.apache.catalina.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PhanHoang
 * 12/23/2020
 */
@RestController
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @PostMapping("/create")
    private ApiResponse register(@RequestBody Role role) {

        Role result = roleService.createRole(role);
        return ApiResponse.builder().code(CommonConstants.RESPONSE_STATUS.SUCCESS)
                .message("thanh cong")
                .data(result)
                .build();
    }
}
