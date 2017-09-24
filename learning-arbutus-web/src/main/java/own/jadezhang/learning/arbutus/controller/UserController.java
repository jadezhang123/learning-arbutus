package own.jadezhang.learning.arbutus.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import own.jadezhang.learning.arbutus.domain.auth.AuthUser;

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
    public void login(HttpServletResponse response, @RequestParam("username") String username, @RequestParam("password") String password) throws IOException {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            SecurityUtils.getSubject().login(token);
            response.sendRedirect("/index.html");
        } catch (AuthenticationException e) {
            logger.debug("Error authenticating.", e.getMessage());
            response.sendRedirect("/login.html");
        }
    }
    
    @ResponseBody
    @RequestMapping(value = "/register")
    public String  register(AuthUser user) {

        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/list" , method = {RequestMethod.GET})
    @RequiresPermissions({"eval:record:*"})
    public List list() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("有权限");
        return arrayList;
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE})
    public boolean delete(){
        logger.info("delete in UserController#delete()");
        return true;
    }

}
