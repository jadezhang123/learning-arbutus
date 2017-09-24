package own.jadezhang.learning.arbutus.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.JdbcUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Zhang Junwei on 2017/5/14.
 */
public class UserAuthenticatingRealm extends AuthenticatingRealm {

    private static final Logger logger = LoggerFactory.getLogger(UserAuthenticatingRealm.class);

    private static final String AuthenticationQuery_Phone = "SELECT password from user WHERE phone = ? ";

    @Autowired
    private DataSource dataSource;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;

        String username = upToken.getUsername();

        Connection conn = null;
        AuthenticationInfo info = null;
        try {
            conn = dataSource.getConnection();

            String password = getPasswordForUser(conn, username);

            if (password == null) {
                throw new UnknownAccountException("No account found for user [" + username + "]");
            }

            SimpleAuthenticationInfo saInfo = new SimpleAuthenticationInfo(username, password, getName());

            //使用uuid作为盐值
            //ByteSource salt = ByteSource.Util.bytes(CommonUtil.makeUUID());
            ByteSource salt = ByteSource.Util.bytes(username);
            saInfo.setCredentialsSalt(salt);

            info = saInfo;

        } catch (SQLException e) {
            final String message = "There was a SQL error while authenticating user [" + username + "]";
            logger.error(message, e);
            throw new AuthenticationException(message, e);
        } finally {
            JdbcUtils.closeConnection(conn);
        }

        return info;
    }

    private String getPasswordForUser(Connection conn, String username) throws SQLException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        String password = null;
        try {
            ps = conn.prepareStatement(AuthenticationQuery_Phone);
            ps.setString(1, username);

            rs = ps.executeQuery();

            boolean foundResult = false;
            while (rs.next()) {

                if (foundResult) {
                    throw new AuthenticationException("More than one user row found for user [" + username + "]. Usernames must be unique.");
                }

                password = rs.getString(1);

                foundResult = true;
            }
        } finally {
            JdbcUtils.closeResultSet(rs);
            JdbcUtils.closeStatement(ps);
        }

        return password;
    }
}
