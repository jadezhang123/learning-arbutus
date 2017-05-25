package own.jadezhang.learning.arbutus.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import own.jadezhang.learning.arbutus.domain.auth.AuthUser;
import own.jadezhang.learning.arbutus.service.auth.IAuthUserService;

/**
 * Created by Zhang Junwei on 2017/5/21.
 */
public class UserAuthorizingRealm extends AuthorizingRealm {

    @Autowired
    private IAuthUserService authUserService;

    /**
     * 获取授权信息
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String principal = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(authUserService.findRoles(principal));
        authorizationInfo.setStringPermissions(authUserService.findPermissions(principal));
        return authorizationInfo;
    }

    /**
     * 获取认证信息
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String principal = upToken.getUsername();
        AuthUser user = authUserService.findByPrincipal(principal);

        if (user == null) {
            throw new UnknownAccountException("No account found for user [" + principal + "]");
        }

        SimpleAuthenticationInfo saInfo = new SimpleAuthenticationInfo(principal, user.getPassword(), this.getName());
        ByteSource salt = ByteSource.Util.bytes(user.getSalt());
        saInfo.setCredentialsSalt(salt);
        return saInfo;
    }
}
