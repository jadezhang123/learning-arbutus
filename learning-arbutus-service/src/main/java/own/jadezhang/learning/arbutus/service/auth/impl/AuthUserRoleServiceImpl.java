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

import own.jadezhang.base.common.dao.IBaseDAO;
import own.jadezhang.base.common.service.impl.AbstractBaseService;
import own.jadezhang.learning.arbutus.dao.auth.IAuthUserRoleDAO;
import own.jadezhang.learning.arbutus.domain.auth.AuthUserRole;
import own.jadezhang.learning.arbutus.service.auth.IAuthUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* 《权限用户角色关联表》 业务逻辑服务类
* @author 张俊伟
*
*/
@Service("authUserRoleServiceImpl")
public class AuthUserRoleServiceImpl extends AbstractBaseService<IBaseDAO<AuthUserRole>, AuthUserRole> implements IAuthUserRoleService<IBaseDAO<AuthUserRole>, AuthUserRole> {
    @Autowired
    private IAuthUserRoleDAO authUserRoleDAO;

    @Override
    public IBaseDAO<AuthUserRole> getDao() {
        return authUserRoleDAO;
    }

}