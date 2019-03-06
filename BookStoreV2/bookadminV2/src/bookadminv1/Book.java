package bookadminv1;
/**
 * ͼ��ʵ����
 * �ݲ�ʵ�ֽ��Ĺ���
 * MVC
 * @author Tricia
 * @version 1.0
 */
public class Book {
	private String bookId;    //ͼ����ڲ���ţ���ά���ɨ��֮�������Ҳ���ܳ�����string�����int��
	private String bookName;  //ͼ������
	private String isbn;      //ͼ��ĳ����
	private String type;      //ͼ�������
	private String author;    //����--��ʱ������
	private String publisher; //������--��ʱ��ʹ��
	private int count;        //��ǰ�鼮�Ŀ����--��⣨���ӿ�棩�����⣨���ٿ�棩
	private double price;     //ͼ��۸�
	
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
     * ��дͼ������equals����
     * ֮��Ƚ��Ƿ�Ϊͬһ��������� book1.equals(book2)�Ƚ�
     */

	@Override
	public boolean equals(Object obj)
	{
		//�������Ĳ���Ϊ��||����Book���ʵ��������false
		if(obj==null||!(obj instanceof Book)) {
			return false;
		}
		Book book=(Book)obj;//ǿ������ת��
		return bookId.equals(book.getBookId());
	}
	
	
	
}
