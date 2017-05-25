package own.jadezhang.learning.arbutus.controller;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Zhang Junwei on 2017/5/24.
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value = UnauthorizedException.class)
    public void unauthorized(Exception exception, HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println(exception.getMessage());

        response.sendRedirect("/unauthorized.html");
    }

}
