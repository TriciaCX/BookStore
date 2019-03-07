package auth;

import java.io.Serializable;
import java.util.List;

import biz.BookInfoBiz;
import biz.impl.BookInfoBizImplV1;

/**
 * ��ɫ��
 * @author Tricia
 * @version 4
 */
public class Role implements Serializable
{
    private String name;  // ��ɫ���ƣ���ʾ��ϵͳ�û���
    private String key;   // ��ӦȨ�������ļ��е�Ȩ��
    private List<String> permissions; //Ȩ�޼���--�����������ļ��У�Role_Permissions.properties
    private BookInfoBiz bookInfoBiz; 
    
    public Role() {
    	setName("Ĭ�Ͻ�ɫ");
    	setKey("default");
    	//bookInfoBiz = new BookInfoBizImplV1();     //Ӳ����ʵ��--���Ըĳɹ���ģʽ���������ʵ�֡��������ù���ģʽʵ�֡�
    	
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
