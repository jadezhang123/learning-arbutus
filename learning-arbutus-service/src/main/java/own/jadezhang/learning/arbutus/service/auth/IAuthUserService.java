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

package own.jadezhang.learning.arbutus.service.auth;

import org.springframework.cache.annotation.Cacheable;
import own.jadezhang.base.common.dao.IBaseDAO;
import own.jadezhang.base.common.domain.BaseDomain;
import own.jadezhang.base.common.service.IBaseService;
import own.jadezhang.learning.arbutus.domain.auth.AuthUser;

import java.util.Set;

/**
 * 《权限用户表》 业务逻辑服务接口
 * @author 张俊伟
 */
public interface IAuthUserService<D extends IBaseDAO<T>, T extends BaseDomain> extends IBaseService<D, T> {

//    void changePassword(Long userId, String newPassword);//修改密码
//
//    void correlationRoles(Long userId, Long... roleIds); //添加用户-角色关系
//
//    void uncorrelationRoles(Long userId, Long... roleIds);// 移除用户-角色关系
//

    /**
     * 根据用户标识查找用户，若未找到则返回null
     * @param userPrincipal
     * @return
     */
    @Cacheable("diskPersistentCache")
    AuthUser findByPrincipal(String userPrincipal);

    /**
     * 根据用户标识查找其角色
     * @param userPrincipal 用户唯一标识：phone或者code
     * @return
     */
    Set<String> findRoles(String userPrincipal);

    /**
     * 根据用户标识查找其权限
     * @param userPrincipal 用户唯一标识：phone或者code
     * @return
     */
    Set<String> findPermissions(String userPrincipal);

}