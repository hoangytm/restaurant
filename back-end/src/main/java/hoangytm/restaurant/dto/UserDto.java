package hoangytm.restaurant.dto;

import hoangytm.restaurant.entity.Role;
import hoangytm.restaurant.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author PhanHoang
 * 2/6/2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private User user;
    private List<Role> roles;

}
