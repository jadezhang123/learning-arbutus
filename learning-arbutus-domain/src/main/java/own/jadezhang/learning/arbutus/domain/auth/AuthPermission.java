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
 * 《权限实体表》 实体
 * @author 张俊伟
 *
 */
public class AuthPermission extends BaseDomain<Long> {
	private static final long serialVersionUID = 1L;
	
	private String code; //权限实体code
	private String permission; //权限标识符
	private String desc; //权限描述
	private Boolean available; //是否可用
    
	/**
	 *默认空构造函数
	 */
	public AuthPermission() {
		super();
	}
	 
	/**
	 * @return code 权限实体code
	 */
	public String getCode(){
		return this.code;
	}
	/**
	 * @param code 权限实体code
	 */
	public void setCode(String code){
		this.code = code;
	}
	/**
	 * @return permission 权限标识符
	 */
	public String getPermission(){
		return this.permission;
	}
	/**
	 * @param permission 权限标识符
	 */
	public void setPermission(String permission){
		this.permission = permission;
	}
	/**
	 * @return desc 权限描述
	 */
	public String getDesc(){
		return this.desc;
	}
	/**
	 * @param desc 权限描述
	 */
	public void setDesc(String desc){
		this.desc = desc;
	}
	/**
	 * @return available 是否可用
	 */
	public Boolean getAvailable(){
		return this.available;
	}
	/**
	 * @param available 是否可用
	 */
	public void setAvailable(Boolean available){
		this.available = available;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("code",getCode())
			.append("permission",getPermission())
			.append("desc",getDesc())
			.append("available",getAvailable())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getCode())
			.append(getPermission())
			.append(getDesc())
			.append(getAvailable())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AuthPermission == false) return false;
		if(this == obj) return true;
		AuthPermission other = (AuthPermission)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}
