package liu.hello;

/**
 * Created by wtswindows7 on 2017/2/10.
 */
import liu.dao.UserDao;
import liu.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    UserDao userDao;

    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = "/world", method = RequestMethod.GET)
    public User hello(Model model, HttpSession session) {
        logger.debug("hell begin");
        String email = "test@test.com";
        String name = userDao.queryUserNameByEmail(email);
        User user = userDao.queryUserInfoByEmail(email);

        return user;
    }

    @RequestMapping("/test")
    public String test(Model model){
        logger.debug("test debug");
        logger.info("test info");
        model.addAttribute("hello", "您好! test");
        model.addAttribute("world", "everything is id");
        return "hello";
    }
}