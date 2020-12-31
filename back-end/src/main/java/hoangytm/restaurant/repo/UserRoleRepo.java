package hoangytm.restaurant.repo;

import hoangytm.restaurant.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author PhanHoang
 * 12/23/2020
 */
@Repository
public interface UserRoleRepo extends JpaRepository<UserRole, String>{
    List<UserRole> findAllByUserId(String userId);

    List<UserRole> deleteAllByUserId(String userId);
}
