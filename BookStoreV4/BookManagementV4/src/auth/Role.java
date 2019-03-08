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
 * ��ɫ��
 * @author Tricia
 * @version 4
 */
public class Role implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -9083125437896281812L;
	private String name;  // ��ɫ���ƣ���ʾ��ϵͳ�û���
    private String key;   // ��ӦȨ�������ļ��е�Ȩ��
    private List<String> permissions; //Ȩ�޼���--�����������ļ��У�Role_Permissions.properties
    private BookInfoBiz bookInfoBiz; 
    
    public Role() {
    	setName("Ĭ�Ͻ�ɫ");
    	setKey("default");
    	//bookInfoBiz = new BookInfoBizImplV1();     //Ӳ����ʵ��--���Ըĳɹ���ģʽ���������ʵ�֡��������ù���ģʽʵ�֡�
    	createPermissions(key);
    	bookInfoBiz = (BookInfoBiz)BizFactory.getBiz("BookInfoBiz");
    }
    
    /**
     * ����������ɫ����Ȩ��key�Ľ�ɫ
     * Ȩ��key��Ӧһ���ַ���(�μ�Role_Permissons.properties)�������ַ����ָ�����飬�����ֵ��permissions����
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
    	//ͨ��Ȩ��key�õ��Ķ�Ӧ��Ȩ���ַ������Զ��ŷָ���
    	//�����Ȩ��key���ұ��Ƕ�Ӧ��Ȩ���ַ���
    	String strPermission = props.getProperty(key);  //administrator=bookinfobiz.*,userbiz.*
    	if(permissions == null) permissions = new ArrayList<>();
    	permissions.clear();
    	String[] permissionArray = strPermission.split(","); //�Զ��ŷָ�������
    	for(String permission :permissionArray) {
    		if("".equals(permission)) continue;
    		permissions.add(permission.trim());
    	}
	}
	/**
	 * ��֤��ǰ�Ľ�ɫ�Ƿ���Ȩ�޽���������
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
			//������չ��������
		}
		return false;
	}
	
	
	public boolean inStore(String isbn,int inCount) {
		//��֤��ǰ�Ľ�ɫ�Ƿ���Ȩ�޽���������
		if(checkPermission("bookinfobiz.instore")) {
			bookInfoBiz.inStore(isbn, inCount);
			return true;
		}else {
			//����д����runtimException������Ҫ�ֶ������쳣
			throw new NoAuthException(name+"û�в���<bookinfobiz.instore>��Ȩ��");
		}
	}
	
	public boolean outStore(String isbn,int outCount) {
		//��֤��ǰ�Ľ�ɫ�Ƿ���Ȩ�޽���������
		if(checkPermission("bookinfobiz.outstore")) {
			bookInfoBiz.outStore(isbn, outCount);
			return true;
		}else {
			//����д����runtimException������Ҫ�ֶ������쳣
			throw new NoAuthException(name+"û�в���<bookinfobiz.outstore>��Ȩ��");
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
