package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ͼ����Ϣ�ࣺ��ͼ���ISBNΪΨһ��־
 * (ISBN��ͬ����������ͬһ����)
 * ISBN��������������ߡ������硢�����������ʱ�䡢����
 * @author Tricia
 * @version 4
 */
public class BookInfo implements Serializable   //���л�
{
	private String isbn;     //ISBN
	private String name;     //����
	private String type;     //���
	private String author;   //����
	private String publisher;//������
	private int inStoreCount;//�����
	private Date publishDate;//����ʱ��
	private double price;    //����
	// BookInfo��Book��֮��Ĺ�ϵ��һ�Զࡪ���ü���
	private List<Book> bookList;
	
	
	//���幹�췽������дtoString��equals�Ȳ���
	/**
	 * ��ISBN����ͼ����Ϣ�������ʵ��ͼ�����
	 * @param book
	 */
	public void addBook(Book book) {
		if(bookList == null) {
			bookList = new ArrayList<>();
		}
		if(book == null) return;
		if(!isbn.equals(book.getIsbn())) return;//��Book����������д��equals����
		//�����ͬһ���飬�Ͳ���Ҫ�ظ������
		if(bookList.contains(book)) return;
		//����ӵ�ͼ���������ͼ����Ϣ
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
