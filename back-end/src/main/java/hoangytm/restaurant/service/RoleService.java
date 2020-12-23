package hoangytm.restaurant.service;

/**
 * @author PhanHoang
 * 12/23/2020
 */

import hoangytm.restaurant.entity.Role;
import hoangytm.restaurant.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepo roleRepo;

    public Role createRole(Role role) {
        return roleRepo.save(role);
    }

}
