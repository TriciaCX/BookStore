package entity;

import java.io.Serializable;
import java.sql.Date;

import auth.Role;

public class User implements Serializable
{

	/**
	 * 串行版本标志
	 */
	private static final long serialVersionUID = -3363120264501521428L;
    private String userName;
    private String password;
    private Role role;
    private Date LastloginTime;
     
    public User() {
    	role = new Role();   //系统分配的默认角色
    }
    
    public User(Role role) {
    	if(role == null) {
    		role = new Role();
    	}
    	setRole(role);
    }
    
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public Role getRole()
	{
		return role;
	}
	public void setRole(Role role)
	{
		this.role = role;
	}
	public Date getLastloginTime()
	{
		return LastloginTime;
	}
	public void setLastloginTime(Date lastloginTime)
	{
		LastloginTime = lastloginTime;
	}
	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}
	
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj == null) return false;
		if(!(obj instanceof User)) return false;
		User user = (User)obj;
		return userName.equals(user.getUserName())&& password.equals(user.getPassword());
	}
}
