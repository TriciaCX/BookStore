package bookadminv1;
/**
 * ģ������ݲֿ�
 * MVC
 * @author Tricia
 * @version 1.0
 */
public class Datas
{
	//������������ͼ����Ϣ�ľ�̬���飬�൱����ͼ��ֿ�
		static Book[] BookStore = new Book[999];
    //ʹ�þ�̬������Ĭ���鼮��Ϣ��������ԣ�
		static {
			Book book1 = new Book();
			book1.setBookId("0001");
			book1.setBookName("��¥��");
			book1.setIsbn("000-001");
			book1.setCount(20);
			book1.setPrice(100);
			BookStore[0]=book1;
			
			Book book2 = new Book();
			book2.setBookId("0002");
			book2.setBookName("ˮ䰴�");
			book2.setIsbn("000-002");
			book2.setCount(10);
			book2.setPrice(88);
			BookStore[1]=book2;
			
			Book book3 = new Book();
			book3.setBookId("0003");
			book3.setBookName("���μ�");
			book3.setIsbn("000-003");
			book3.setCount(20);
			book3.setPrice(70);
			BookStore[2]=book3;
			
			Book book4 = new Book();
			book4.setBookId("0004");
			book4.setBookName("��������");
			book4.setIsbn("000-004");
			book4.setCount(50);
			book4.setPrice(59);
			BookStore[3]=book4;
			
			Book book5 = new Book();
			book5.setBookId("0005");
			book5.setBookName("ָ����");
			book5.setIsbn("000-005");
			book5.setCount(20);
			book5.setPrice(100);
			BookStore[4]=book5;
			
			//new BookView().showBooks(BookStore);
		}
}
