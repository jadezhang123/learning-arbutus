package own.jadezhang.learning.arbutus.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhang Junwei on 2017/5/14.
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/login")
    public String login(HttpServletResponse response, @RequestParam("username") String username, @RequestParam("password") String password) throws IOException {

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            SecurityUtils.getSubject().login(token);
        } catch (AuthenticationException e) {
            logger.debug("Error authenticating.", e.getMessage());
            response.sendRedirect("/login.html");
        }
        return "success";
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE})
    public boolean delete(){
        logger.info("delete in UserController#delete()");
        return true;
    }

    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public List<String > list(){
        List<String> list = new ArrayList<String>();
        list.add("aaaa");
        logger.info("list in UserController#delete()");
        return list;
    }


}
