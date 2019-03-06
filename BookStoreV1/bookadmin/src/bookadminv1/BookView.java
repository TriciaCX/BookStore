package bookadminv1;
import java.util.Scanner;

/**
 * ͼ��ϵͳ����ͼ
 * MVC-V
 * @author Tricia
 * @version 1.0
 */


public class BookView
{
   private Scanner input = null;
   private BookBiz bookBiz = null;
   
   public BookView() {
	   input = new Scanner(System.in);
	   bookBiz = new BookBiz();
	   
	   System.out.println("*--------------------------------*");
	   System.out.println("\t���ã���ӭʹ�þ����ͼ�����ϵͳ");
	   System.out.println("\t1���û���¼\t\t\t2���˳�ϵͳ");
	   System.out.println("*--------------------------------*");
	   System.out.println("��ѡ��");
	   String choice = input.next();
	   if("1".equals(choice)) {
		   //��¼
		   //�����¼�ɹ�����ʾ���˵�
		   System.out.println("��Ŀǰ����ֱ��ʹ�ã���¼������δ���ߣ������ڴ���\n");
		   showMainView();
	   }
	   System.out.println("�˳�ϵͳ");

   }
   
   public void showMainView() {
	   System.out.println("\n�����ͼ�����ϵͳ>>���˵�");
	   System.out.println("1������ͼ��\t2��ɾ��ͼ��\t3���鿴���\t4������Ų�ѯ\t5�����\t6������\t7���˳�");
	   System.out.println("��ѡ�� ");
	   String choice=input.next();
	   switch(choice) {
	   case "1":
		   showAddNewBookView();
		   showBooks(Datas.BookStore);
		   break;
	   case "2":
		   
		   break;
       case "3":
		   
		   break;
	   default:
		   break;  
	   }
	   
	 
	   }
	
   
   /**
    * ����ͼ��
    * @return
    */
   public Book showAddNewBookView() {
	   System.out.println("\n�����ͼ�����ϵͳ>>����ͼ��");
	   System.out.println("��ţ�");
	   String bookId = input.next();
	   //��֤�û�����ı���Ƿ��Ѿ��������
	   Book newBook=bookBiz.findById(bookId);
	   if(newBook==null) {
		   //��������ͼ��
		   newBook=new Book();
		   newBook.setBookId(bookId);
		   System.out.println("���ƣ�");
		   newBook.setBookName(input.next());
		   System.out.println("��棺");
		   newBook.setCount(input.nextInt());
		   //......
		   bookBiz.addBook(newBook);//��������ͼ�������ӵ������
	   }else {
		   //ͼ���Ѿ�����
		   System.out.println("�������ͼ���Ѵ��ڣ�����������");
		   newBook=showAddNewBookView();//���û��ٴ����룬�ݹ����showAddNewBookView()����
	   }
	   return newBook; 
   }
   
   public void showBooks(Book ... bookArray) {//���Դ�ӡһ�����飬Ҳ���Դ�ӡһ����
	   System.out.println("���\t����\t���");
	   int bookCount = bookBiz.getBookCount(bookArray);
	   for(int i=0;i<bookCount;i++) {
		   System.out.printf("%s\t%s\t%d\n",
				   bookArray[i].getBookId(),bookArray[i].getBookName(),bookArray[i].getCount());
	   }
   }
}

