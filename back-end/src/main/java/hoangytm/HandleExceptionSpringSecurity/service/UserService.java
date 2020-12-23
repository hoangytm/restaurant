package hoangytm.HandleExceptionSpringSecurity.service;

import hoangytm.HandleExceptionSpringSecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author PhanHoang
 * 2/10/2020
 */

public interface UserService {
void deleteUser();
User findUserByEmail(String email);
void updateUser(User user);
User findUserById(Long id);
}
