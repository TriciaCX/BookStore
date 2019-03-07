package auth;

import java.io.Serializable;
import java.util.List;

import biz.BookInfoBiz;
import biz.impl.BookInfoBizImplV1;

/**
 * 角色类
 * @author Tricia
 * @version 4
 */
public class Role implements Serializable
{
    private String name;  // 角色名称，显示给系统用户看
    private String key;   // 对应权限配置文件中的权限
    private List<String> permissions; //权限集合--保存在配置文件中：Role_Permissions.properties
    private BookInfoBiz bookInfoBiz; 
    
    public Role() {
    	setName("默认角色");
    	setKey("default");
    	//bookInfoBiz = new BookInfoBizImplV1();     //硬编码实现--可以改成工厂模式来获得子类实现。接下来用工厂模式实现。
    	
    }
    
    
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getKey()
	{
		return key;
	}
	public void setKey(String key)
	{
		this.key = key;
	}
	public List<String> getPermissions()
	{
		return permissions;
	}
	public void setPermissions(List<String> permissions)
	{
		this.permissions = permissions;
	}
	public BookInfoBiz getBookInfoBiz()
	{
		return bookInfoBiz;
	}
	public void setBookInfoBiz(BookInfoBiz bookInfoBiz)
	{
		this.bookInfoBiz = bookInfoBiz;
	}
    
    
}
