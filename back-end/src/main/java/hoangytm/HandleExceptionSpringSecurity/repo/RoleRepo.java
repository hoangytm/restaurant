package hoangytm.HandleExceptionSpringSecurity.repo;

import hoangytm.HandleExceptionSpringSecurity.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author PhanHoang
 * 2/6/2020
 */
@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {
    Set<Role> findRoleByUserID(Long id);


}
