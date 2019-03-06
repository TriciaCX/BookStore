package bookadminv1;
/**
 * 图书实体类
 * 暂不实现借阅功能
 * MVC
 * @author Tricia
 * @version 1.0
 */
public class Book {
	private String bookId;    //图书的内部编号（二维码等扫描之后的数字也许会很长，用string会好于int）
	private String bookName;  //图书名称
	private String isbn;      //图书的出版号
	private String type;      //图书的类型
	private String author;    //作者--暂时不适用
	private String publisher; //出版社--暂时不使用
	private int count;        //当前书籍的库存量--入库（增加库存）、出库（减少库存）
	private double price;     //图书价格
	
	public Book() {
		
	}
	
	
	
	
	public String getBookId()
	{
		return bookId;
	}
	public void setBookId(String bookId)
	{
		this.bookId = bookId;
	}
	public String getBookName()
	{
		return bookName;
	}
	public void setBookName(String bookName)
	{
		this.bookName = bookName;
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
	public int getCount()
	{
		return count;
	}
	public void setCount(int count)
	{
		this.count = count;
	}
	public double getPrice()
	{
		return price;
	}
	public void setPrice(double price)
	{
		this.price = price;
	}


    /**
     * 重写图书对象的equals方法
     * 之后比较是否为同一本书可以用 book1.equals(book2)比较
     */

	@Override
	public boolean equals(Object obj)
	{
		//如果传入的参数为空||不是Book类的实例，返回false
		if(obj==null||!(obj instanceof Book)) {
			return false;
		}
		Book book=(Book)obj;//强制类型转换
		return bookId.equals(book.getBookId());
	}
	
	
	
}
