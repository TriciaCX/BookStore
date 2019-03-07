package biz;

import biz.impl.BookInfoBizImplV1;

/**
 * ҵ�񹤳���
 * ����ģʽ�����ϼӹ�������BizFactory��һ���ַ����������ַ���������Ӧ������ʵ��
 * @author Tricia
 * @version 4
 */
public class BizFactory
{
	/**
	 * ����ҵ��������ƣ������Ӧҵ�����ʵ��
	 * 
	 * @param bizName
	 * @return
	 */
     public static Biz getBiz(String bizName) {
    	 switch(bizName.toLowerCase()) {
    	 case "bookinfobiz":
    		 return new BookInfoBizImplV1();
    	 case "userbiz":
    		// return new UserBizImplV1();
         default:
        	 return null;
    	 }
     }
}
