package biz;

import entity.BookInfo;

/**
 * ͼ��ҵ����ĸ��ӿ�
 * ��ɾ�Ĳ�
 * @author Tricia
 * @version 4
 */
public interface BookInfoBiz extends Biz<BookInfo>
{
	public BookInfo findByIsbn(String isbn); 
	/**
	 * ����--ͼ��ҵ������е�
	 * @param isbn
	 * @param outCount
	 * @return �Ƿ����ɹ�
	 */
   public boolean outStore(String isbn,int outCount);
   /**
    * ���--ͼ��ҵ������е�
    * @param isbn
    * @param inCount
    * @return �Ƿ����ɹ�
    */
   public boolean inStore(String isbn,int inCount);
   
}
