/*
{*****************************************************************************
{  dubbo示例 v1.0													
{  版权信息 (c) 2005-2017 http://git.oschina.net/htengen
{  创建人：  张俊伟
{  审查人：
{  模块：											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2017-05-21  张俊伟        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{  注：本模块代码由codgen代码生成工具辅助生成 http://www.oschina.net/p/codgen	
{*****************************************************************************	
*/
package own.jadezhang.learning.arbutus.service.auth.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import own.jadezhang.base.common.dao.IBaseDAO;
import own.jadezhang.base.common.service.impl.AbstractBaseService;
import own.jadezhang.learning.arbutus.common.utils.RegexUtil;
import own.jadezhang.learning.arbutus.dao.auth.IAuthUserDAO;
import own.jadezhang.learning.arbutus.domain.auth.AuthPermission;
import own.jadezhang.learning.arbutus.domain.auth.AuthRole;
import own.jadezhang.learning.arbutus.domain.auth.AuthUser;
import own.jadezhang.learning.arbutus.param.auth.AuthUserParam;
import own.jadezhang.learning.arbutus.service.auth.IAuthUserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 《权限用户表》 业务逻辑服务类
 * @author 张俊伟
 */
@Service("authUserServiceImpl")
public class AuthUserServiceImpl extends AbstractBaseService<IBaseDAO<AuthUser>, AuthUser> implements IAuthUserService<IBaseDAO<AuthUser>, AuthUser> {
    @Autowired
    private IAuthUserDAO authUserDAO;

    @Override
    public IBaseDAO<AuthUser> getDao() {
        return authUserDAO;
    }


    @Override
    public AuthUser findByPrincipal(String userPrincipal) {
        System.out.println("not hit cache ....");
        String queryKey;
        if (RegexUtil.isPhone(userPrincipal)) {
            queryKey = AuthUserParam.F_Phone;
        } else {
            queryKey = AuthUserParam.F_Code;
        }
        return authUserDAO.findOne(queryKey, userPrincipal, null, null);
    }

    @Override
    public Set<String> findRoles(String userPrincipal) {
        Set<String> result = new HashSet<String>();
        AuthUser user = findByPrincipal(userPrincipal);
        if (user != null) {
            List<AuthRole> roles = authUserDAO.getRoles(user.getCode());
            for (AuthRole role : roles) {
                result.add(role.getName());
            }
        }
        return result;
    }

    @Override
    public Set<String> findPermissions(String userPrincipal) {
        Set<String> result = new HashSet<String>();
        AuthUser user = findByPrincipal(userPrincipal);
        if (user != null) {
            List<AuthPermission> permissions = authUserDAO.getPermissions(user.getCode());
            for (AuthPermission permission : permissions) {
                result.add(permission.getPermission());
            }
        }
        return result;
    }

}