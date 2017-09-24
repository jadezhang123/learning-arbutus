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
import own.jadezhang.learning.arbutus.dao.auth.IAuthRoleDAO;
import own.jadezhang.learning.arbutus.domain.auth.AuthRole;
import own.jadezhang.learning.arbutus.service.auth.IAuthRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* 《权限角色表》 业务逻辑服务类
* @author 张俊伟
*
*/
@Service("authRoleServiceImpl")
public class AuthRoleServiceImpl extends AbstractBaseService<IBaseDAO<AuthRole>, AuthRole> implements IAuthRoleService<IBaseDAO<AuthRole>, AuthRole> {
    @Autowired
    private IAuthRoleDAO authRoleDAO;

    @Override
    public IBaseDAO<AuthRole> getDao() {
        return authRoleDAO;
    }

}