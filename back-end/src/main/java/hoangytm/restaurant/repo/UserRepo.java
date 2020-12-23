package hoangytm.restaurant.repo;

import hoangytm.restaurant.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author PhanHoang
 * 2/6/2020
 */
@Repository
public interface UserRepo extends JpaRepository<User, String> {
    User findUserByEmail(String email);

    void deleteUserByEmail(String email);

    User findUserById(Long id);


}