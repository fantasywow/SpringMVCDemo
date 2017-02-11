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

@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    UserDao userDao;

    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/world")
    public String hello(Model model) {
        String email = "sam@balabala.com";
        String name = userDao.queryUserNameByEmail(email);
        User user = userDao.queryUserInfoByEmail(email);

        logger.debug("you have been here !");
        model.addAttribute("hello", "您好! " + name);
        model.addAttribute("world", "everything is " + user.getUserId());
        return "hello";
    }

    @RequestMapping("/test")
    public String test(Model model){
        logger.debug(">>>>>>>>我就测试下日志 debug  <<<<<<<<<");
        logger.info(">>>>>>>> 我就测试下日志 info   <<<<<<<<<");
        model.addAttribute("hello", "您好! test");
        model.addAttribute("world", "everything is id");
        return "hello";
    }
}