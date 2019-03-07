package entity;

import java.io.Serializable;

/**
 * 图书对象
 * Book对象包含BookInfo对象
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
		// 验证传入的obj对象是不是和本对象是同一本书
		// 同一本书的判断标准：两个对象的内部编号bookId是否相同
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
 * 图书状态枚举
 * 图书状态：可借、不可借、缺货、
 * @author Tricia
 * @version 4
 */
enum BookState{
	可借,不可借,缺货,等待上架
}
