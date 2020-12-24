package hoangytm.restaurant.service;

import hoangytm.restaurant.config.security.lockUser.LoginAttemptService;
import hoangytm.restaurant.entity.Role;
import hoangytm.restaurant.entity.User;
import hoangytm.restaurant.entity.UserRole;
import hoangytm.restaurant.repo.RoleRepo;
import hoangytm.restaurant.repo.UserRepo;
import hoangytm.restaurant.repo.UserRoleRepo;
import hoangytm.restaurant.utils.CommonValidate;
import hoangytm.restaurant.utils.GetIP;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @author PhanHoang
 * 2/6/2020
 */

@Service
@Primary
@Slf4j
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private LoginAttemptService loginAttemptService;

    @Autowired
    private UserRoleRepo userRoleRepo;

    @Autowired
    private BCryptPasswordEncoder bcrypt;

    @Override
    public UserDetails loadUserByUsername(String username) {

        String ip = GetIP.getClientIP().replace(":", "").replace(" ", "");
        log.info("ip : " + ip);
        if (loginAttemptService.isBlocked(ip)) {
            throw new RuntimeException("this user was blocked");
        }

        User user = userRepo.findUserByUsername(username);

        if (user == null) {
            log.error("Invalid username or password.");
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        Set<SimpleGrantedAuthority> grantedAuthorities = getAuthorities(user);

        org.springframework.security.core.userdetails.User users = new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
        return users;
    }


    private Set<SimpleGrantedAuthority> getAuthorities(User user) {
        List<UserRole> userRoles = userRoleRepo.findAllByUserId(user.getId());
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        if (userRoles != null) {
            for (UserRole userRole : userRoles) {
                Role role = roleRepo.findById(userRole.getRoleId()).orElse(null);
                authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName().toUpperCase()));
            }
        }
        return authorities;
    }


    @Transactional(rollbackOn = RuntimeException.class)
    public void deleteUser() {
        userRepo.deleteUserByEmail("hoang2");
        System.out.println("SUCCESS");
//        throw new RuntimeException();
    }

    public User findUserByEmail(String email) {
        return userRepo.findUserByEmail(email);
    }

    public void updateUser(User user) {
        userRepo.save(user);

    }

    public User findUserById(Long id) {
        User user = userRepo.findUserById(id);
        return user;
    }

    public User registerUser(User user) {
        if (CommonValidate.validateUser(user)) {
            user.setPassword(bcrypt.encode(user.getPassword()));
            return userRepo.save(user);
        }

        return null;
    }
}
