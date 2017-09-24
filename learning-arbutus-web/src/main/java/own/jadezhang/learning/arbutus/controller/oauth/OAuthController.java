package own.jadezhang.learning.arbutus.controller.oauth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Zhang Junwei on 2017/5/26.
 */
@Controller
@RequestMapping("/oauth2")
public class OAuthController {
    /**
     * @param response_type 授权类型，此值固定为“code”
     * @param client_id     分配给应用的appid
     * @param redirect_uri  成功授权后的回调地址，必须是注册appid时填写的主域名下的地址
     * @param state         client端的状态值。用于第三方应用防止CSRF攻击，成功授权后回调时会原样带回
     * @param scope
     * @param response
     */
    @RequestMapping(value = "/authorize")
    public void authorize(@RequestParam String response_type, @RequestParam String client_id,
                          @RequestParam String redirect_uri, @RequestParam String state,
                          @RequestParam String scope, HttpServletResponse response) {

        if (!"code".equals(response_type)) {
            this.responseForError(response, "参数错误");
        }

        //生成授权码，10分钟有效，由client_id和redirect_uri确定唯一性
        String code = "";

        try {
            //重定向到redirect_uri，并跟上Authorization Code和state原值返回
            response.sendRedirect(redirect_uri + "?code=" + code + "state=" + state);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * @param grant_type    授权类型，此值为“authorization_code”
     * @param client_id     分配给应用的appid
     * @param client_secret 分配给网站的appkey
     * @param code          authorize返回的 authorization code。
     * @param redirect_uri  与authorize中传入的redirect_uri保持一致
     */
    @RequestMapping(value = "/token")
    public void token(@RequestParam String grant_type, @RequestParam String client_id,
                      @RequestParam String client_secret, @RequestParam String code,
                      @RequestParam String redirect_uri, HttpServletResponse response) {


    }

    private void responseForError(HttpServletResponse response, String errorMsg) {

    }
}
