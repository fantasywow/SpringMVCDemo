package liu.hello;

import liu.dao.UserDao;
import liu.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liu_t on 2017/5/12.
 */
@RestController
public class RestfulController {

    @Autowired
    UserDao userDao;

    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable("id")String id){
        User user = userDao.queryUserInfoById(id);
        return user;
    }

}
