package hoangytm.HandleExceptionSpringSecurity.utils;

import hoangytm.HandleExceptionSpringSecurity.entity.User;

import hoangytm.HandleExceptionSpringSecurity.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PhanHoang
 * 2/29/2020
 */
public class CreateData {
    @Autowired
    UserRepo userRepo;

    // fake 1000 user then save into database
    public String fakeData() {
        List<User> userList = new ArrayList<>();
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 1000; i++) {
            User user = factory.manufacturePojo(User.class);
            userList.add(user);
        }
        userRepo.saveAll(userList);
        return "success";
    }
}
