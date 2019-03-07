package biz;

import entity.BookInfo;

/**
 * 图书业务类的父接口
 * 增删改查
 * @author Tricia
 * @version 4
 */
public interface BookInfoBiz extends Biz<BookInfo>
{
	public BookInfo findByIsbn(String isbn); 
	/**
	 * 出库--图书业务类独有的
	 * @param isbn
	 * @param outCount
	 * @return 是否出库成功
	 */
   public boolean outStore(String isbn,int outCount);
   /**
    * 入库--图书业务类独有的
    * @param isbn
    * @param inCount
    * @return 是否入库成功
    */
   public boolean inStore(String isbn,int inCount);
   
}
