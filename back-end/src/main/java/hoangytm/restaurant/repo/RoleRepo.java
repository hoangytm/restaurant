package hoangytm.restaurant.repo;

import hoangytm.restaurant.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author PhanHoang
 * 2/6/2020
 */
@Repository
public interface RoleRepo extends JpaRepository<Role, String>, JpaSpecificationExecutor<Role> {
    Optional<Role> findById(String id);
}
