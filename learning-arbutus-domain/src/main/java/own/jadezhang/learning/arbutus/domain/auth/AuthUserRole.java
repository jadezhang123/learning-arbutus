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
 * 《权限用户角色关联表》 实体
 * @author 张俊伟
 *
 */
public class AuthUserRole extends BaseDomain<Long> {
	private static final long serialVersionUID = 1L;
	
	private String roleCode; //角色code
	private String userCode; //用户code
    
	/**
	 *默认空构造函数
	 */
	public AuthUserRole() {
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
	 * @return userCode 用户code
	 */
	public String getUserCode(){
		return this.userCode;
	}
	/**
	 * @param userCode 用户code
	 */
	public void setUserCode(String userCode){
		this.userCode = userCode;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("roleCode",getRoleCode())
			.append("userCode",getUserCode())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getRoleCode())
			.append(getUserCode())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AuthUserRole == false) return false;
		if(this == obj) return true;
		AuthUserRole other = (AuthUserRole)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}
