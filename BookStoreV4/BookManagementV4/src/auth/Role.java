package auth;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import biz.BizFactory;
import biz.BookInfoBiz;
import biz.impl.BookInfoBizImplV1;
import exception.NoAuthException;

/**
 * 角色类
 * @author Tricia
 * @version 4
 */
public class Role implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -9083125437896281812L;
	private String name;  // 角色名称，显示给系统用户看
    private String key;   // 对应权限配置文件中的权限
    private List<String> permissions; //权限集合--保存在配置文件中：Role_Permissions.properties
    private BookInfoBiz bookInfoBiz; 
    
    public Role() {
    	setName("默认角色");
    	setKey("default");
    	//bookInfoBiz = new BookInfoBizImplV1();     //硬编码实现--可以改成工厂模式来获得子类实现。接下来用工厂模式实现。
    	createPermissions(key);
    	bookInfoBiz = (BookInfoBiz)BizFactory.getBiz("BookInfoBiz");
    }
    
    /**
     * 创建给定角色名和权限key的角色
     * 权限key对应一个字符串(参见Role_Permissons.properties)，将该字符串分割成数组，逐个赋值给permissions集合
     * @param name
     * @param key
     */
    public Role(String name,String key) {
    	setName(name);
    	setKey(key);
    	createPermissions(key);
    	bookInfoBiz = (BookInfoBiz)BizFactory.getBiz("BookInfoBiz");
    	
    }

	private void createPermissions(String key)
	{
		Properties props = new Properties();
    	try
		{
			props.load(Role.class.getResourceAsStream("Role_Permissions.properties"));
		} catch (IOException e)
    	{
			e.printStackTrace();
		}
    	//通过权限key拿到的对应的权限字符串（以逗号分隔）
    	//左边是权限key，右边是对应的权限字符串
    	String strPermission = props.getProperty(key);  //administrator=bookinfobiz.*,userbiz.*
    	if(permissions == null) permissions = new ArrayList<>();
    	permissions.clear();
    	String[] permissionArray = strPermission.split(","); //以逗号分隔成数组
    	for(String permission :permissionArray) {
    		if("".equals(permission)) continue;
    		permissions.add(permission.trim());
    	}
	}
	/**
	 * 验证当前的角色是否有权限进行入库操作
	 * @param optName
	 * @return
	 */
	private boolean checkPermission(String optName) {
		if(permissions == null||permissions.size()==0) {
			return false;
		}
		for(String permission:permissions) {
			System.out.println(permission);
			if(optName.equals(permission)) {
				return true;
			}
			if(permission.equals("bookinfobiz.*") && optName.startsWith("bookinfobiz")) {
				return true;
			}
			if(permission.equalsIgnoreCase("userbiz.*")&& optName.startsWith("userbiz")) {
				return true;
			}
			//可以扩展其他条件
		}
		return false;
	}
	
	
	public boolean inStore(String isbn,int inCount) {
		//验证当前的角色是否有权限进行入库操作
		if(checkPermission("bookinfobiz.instore")) {
			bookInfoBiz.inStore(isbn, inCount);
			return true;
		}else {
			//我们写的是runtimException，不需要手动捕获异常
			throw new NoAuthException(name+"没有操作<bookinfobiz.instore>的权限");
		}
	}
	
	public boolean outStore(String isbn,int outCount) {
		//验证当前的角色是否有权限进行入库操作
		if(checkPermission("bookinfobiz.outstore")) {
			bookInfoBiz.outStore(isbn, outCount);
			return true;
		}else {
			//我们写的是runtimException，不需要手动捕获异常
			throw new NoAuthException(name+"没有操作<bookinfobiz.outstore>的权限");
		}
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
