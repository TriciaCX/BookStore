package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 图书信息类：以图书的ISBN为唯一标志
 * (ISBN相同并不代表是同一本书)
 * ISBN、书名、类别、作者、出版社、库存量、出版时间、单价
 * @author Tricia
 * @version 4
 */
public class BookInfo implements Serializable   //序列化
{
	private String isbn;     //ISBN
	private String name;     //书名
	private String type;     //类别
	private String author;   //作者
	private String publisher;//出版社
	private int inStoreCount;//库存量
	private Date publishDate;//出版时间
	private double price;    //单价
	// BookInfo和Book类之间的关系是一对多——用集合
	private List<Book> bookList;
	
	
	//定义构造方法、重写toString、equals等操作
	/**
	 * 往ISBN类别的图书信息中添加真实的图书对象
	 * @param book
	 */
	public void addBook(Book book) {
		if(bookList == null) {
			bookList = new ArrayList<>();
		}
		if(book == null) return;
		if(!isbn.equals(book.getIsbn())) return;//在Book类中我们重写了equals方法
		//如果是同一本书，就不需要重复添加了
		if(bookList.contains(book)) return;
		//给添加的图书对象设置图书信息
		book.setBookInfo(this);
		bookList.add(book);
		
	}
	
	public String getIsbn()
	{
		return isbn;
	}
	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	public String getAuthor()
	{
		return author;
	}
	public void setAuthor(String author)
	{
		this.author = author;
	}
	public String getPublisher()
	{
		return publisher;
	}
	public void setPublisher(String publisher)
	{
		this.publisher = publisher;
	}
	public int getInStoreCount()
	{
		return inStoreCount;
	}
	public void setInStoreCount(int inStoreCount)
	{
		this.inStoreCount = inStoreCount;
	}
	public Date getPublishDate()
	{
		return publishDate;
	}
	public void setPublishDate(Date publishDate)
	{
		this.publishDate = publishDate;
	}
	public double getPrice()
	{
		return price;
	}
	public void setPrice(double price)
	{
		this.price = price;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<Book> getBookList()
	{
		return bookList;
	}

	public void setBookList(List<Book> bookList)
	{
		this.bookList = bookList;
	}


}
