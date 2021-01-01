package hoangytm.restaurant.repo;

import hoangytm.restaurant.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author PhanHoang
 * 2/6/2020
 */
@Repository
public interface UserRepo extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {

    void deleteUserByEmail(String email);

    User findUserById(String id);

    User findUserByUsername(String username);
}
