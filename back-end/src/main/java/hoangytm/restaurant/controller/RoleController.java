package hoangytm.restaurant.controller;

import hoangytm.restaurant.constants.CommonConstants;
import hoangytm.restaurant.entity.ApiResponse;
import hoangytm.restaurant.entity.Role;
import hoangytm.restaurant.entity.User;
import hoangytm.restaurant.service.RoleService;
import org.apache.catalina.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/findRole")
    private ApiResponse findRole(Role role) {
        List<Role> result = roleService.findRole(role);
        return ApiResponse.builder().code(CommonConstants.RESPONSE_STATUS.SUCCESS)
                .message("thanh cong")
                .data(result)
                .build();
    }
    @PutMapping("/updateRole")
    private ApiResponse updateRole(@RequestBody Role role) {
        Role result = roleService.updateRole(role);
        return ApiResponse.builder().code(CommonConstants.RESPONSE_STATUS.SUCCESS)
                .message("thanh cong")
                .data(result)
                .build();
    }
}
