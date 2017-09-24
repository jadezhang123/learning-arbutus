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

package own.jadezhang.learning.arbutus.domain.auth;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import own.jadezhang.base.common.domain.BaseDomain;

import java.util.*;

/**
 * 《权限访问控制表》 实体
 * @author 张俊伟
 *
 */
public class AuthAccessControl extends BaseDomain<Long> {
	private static final long serialVersionUID = 1L;
	
	private String roleCode; //角色code
	private String permissionCode; //权限实体code
	private Boolean state; //启用状态
    
	/**
	 *默认空构造函数
	 */
	public AuthAccessControl() {
		super();
	}
	 
	/**
	 * @return roleCode 角色code
	 */
	public String getRoleCode(){
		return this.roleCode;
	}
	/**
	 * @param roleCode 角色code
	 */
	public void setRoleCode(String roleCode){
		this.roleCode = roleCode;
	}
	/**
	 * @return permissionCode 权限实体code
	 */
	public String getPermissionCode(){
		return this.permissionCode;
	}
	/**
	 * @param permissionCode 权限实体code
	 */
	public void setPermissionCode(String permissionCode){
		this.permissionCode = permissionCode;
	}
	/**
	 * @return state 启用状态
	 */
	public Boolean getState(){
		return this.state;
	}
	/**
	 * @param state 启用状态
	 */
	public void setState(Boolean state){
		this.state = state;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("roleCode",getRoleCode())
			.append("permissionCode",getPermissionCode())
			.append("state",getState())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getRoleCode())
			.append(getPermissionCode())
			.append(getState())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AuthAccessControl == false) return false;
		if(this == obj) return true;
		AuthAccessControl other = (AuthAccessControl)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}
