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

package own.jadezhang.learning.arbutus.param.auth;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import own.jadezhang.base.common.param.BaseParam;

/**
 * 《权限角色表》 查询参数实体
 * @author 张俊伟
 *
 */
public class AuthRoleParam extends BaseParam<Long> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——角色代码
	*/
	public static final String F_Code="code";
	/**
	*字段常量——角色名称
	*/
	public static final String F_Name="name";
	/**
	*字段常量——角色启用状态；0：停用，1启用
	*/
	public static final String F_Available="available";
	/**
	*字段常量——
	*/
	public static final String F_Desc="desc";
	
	private String code; //角色代码
	private String name; //角色名称
	private Boolean available; //角色启用状态；0：停用，1启用
	private String desc; //
    
	/**
	 *默认空构造函数
	 */
	public AuthRoleParam() {
		super();
	}
	 
	/**
	 * @return code 角色代码
	 */
	public String getCode(){
		return this.code;
	}
	/**
	 * @param code 角色代码
	 */
	public void setCode(String code){
		this.code = code;
	}
	/**
	 * @return name 角色名称
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * @param name 角色名称
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * @return available 角色启用状态；0：停用，1启用
	 */
	public Boolean getAvailable(){
		return this.available;
	}
	/**
	 * @param available 角色启用状态；0：停用，1启用
	 */
	public void setAvailable(Boolean available){
		this.available = available;
	}
	/**
	 * @return desc 
	 */
	public String getDesc(){
		return this.desc;
	}
	/**
	 * @param desc 
	 */
	public void setDesc(String desc){
		this.desc = desc;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("code",getCode())
			.append("name",getName())
			.append("available",getAvailable())
			.append("desc",getDesc())
			.toString();
	}
	
}
