package own.jadezhang.learning.arbutus.controller.oauth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Zhang Junwei on 2017/5/26.
 */
@Controller
@RequestMapping("/oauth2.0")
public class OAuthController {
    @ResponseBody
    @RequestMapping(value = "/authorize")
    public void authorize(@RequestParam(required = true) String response_type,
                          @RequestParam(required = true)String client_id,
                          @RequestParam(required = true)String redirect_uri,
                          @RequestParam(required = true)String state,
                          String scope, HttpServletResponse response) {

        if (!"code".equals(response_type)){
            this.responseForError(response, "参数错误");
        }

        //生成授权码，10分钟有效，由client_id和redirect_uri确定唯一性
        String code = "";

        try {
            //重定向到redirect_uri，并跟上Authorization Code和state原值返回
            response.sendRedirect(redirect_uri + "?code="+ code+"state="+state);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @ResponseBody
    @RequestMapping(value = "/token")
    public void token() {

    }

    private void responseForError(HttpServletResponse response, String errorMsg){

    }
}
