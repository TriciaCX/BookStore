package biz;

import biz.impl.BookInfoBizImplV1;

/**
 * 业务工厂类
 * 工厂模式：来料加工，传给BizFactory类一个字符串，根据字符串返回相应的子类实现
 * @author Tricia
 * @version 4
 */
public class BizFactory
{
	/**
	 * 根据业务类的名称，获得相应业务类的实现
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
