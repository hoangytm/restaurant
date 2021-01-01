package hoangytm.restaurant.service;

/**
 * @author PhanHoang
 * 12/23/2020
 */

import hoangytm.restaurant.entity.Role;
import hoangytm.restaurant.repo.RoleRepo;
import hoangytm.restaurant.utils.H;
import hoangytm.restaurant.utils.QueryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepo roleRepo;

    public Role createRole(Role role) {
        return roleRepo.save(role);
    }

    public List<Role> findRole(Role role) {
        return roleRepo.findAll(buildFilterSpec(role));
    }

    private Specification<Role> buildFilterSpec(Role searchForm) {
        return (root, criteriaQuery, cb) -> QueryUtils.and(cb,
                H.isTrue(searchForm.getRoleName()) ?
                        QueryUtils.buildLikeFilter(root, cb, searchForm.getRoleName(), "roleName") : null,
                H.isTrue(searchForm.getId()) ?
                        QueryUtils.buildEqFilter(root, cb, "id", searchForm.getId()) : null
        );
    }

    public Role updateRole(Role role) {
        return roleRepo.save(role);
    }
}
