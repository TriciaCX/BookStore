package entity;

import java.io.Serializable;

/**
 * ͼ�����
 * Book�������BookInfo����
 * @author Tricia
 * @version 4
 */
public class Book implements Serializable
{
	private String isbn;
	private String bookId;
	private BookState state;
	private BookInfo  bookInfo;
	
	@Override
	public boolean equals(Object obj)
	{
		// ��֤�����obj�����ǲ��Ǻͱ�������ͬһ����
		// ͬһ������жϱ�׼������������ڲ����bookId�Ƿ���ͬ
		if(obj==null)return false;
		if(!(obj instanceof Book)) return false;
		Book book =(Book)obj;
		return bookId.equals(book.getBookId());
	}
	
	public String getIsbn()
	{
		return isbn;
	}
	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}
	public String getBookId()
	{
		return bookId;
	}
	public void setBookId(String bookId)
	{
		this.bookId = bookId;
	}
	public BookState getState()
	{
		return state;
	}
	public void setState(BookState state)
	{
		this.state = state;
	}
	public BookInfo getBookInfo()
	{
		return bookInfo;
	}
	public void setBookInfo(BookInfo bookInfo)
	{
		this.bookInfo = bookInfo;
	}



}
/**
 * ͼ��״̬ö��
 * ͼ��״̬���ɽ衢���ɽ衢ȱ����
 * @author Tricia
 * @version 4
 */
enum BookState{
	�ɽ�,���ɽ�,ȱ��,�ȴ��ϼ�
}
