package bookadminv3;

import java.util.Scanner;

/**
 * ͼ��ϵͳ�������̨ʵ����
 * @author Tricia
 * @version 1.0
 */
public class BookViewConsole extends AbstractBookView
{
	private Scanner input = null;
	private BookBiz bookBiz = null;
	public BookViewConsole() {
		input = new Scanner(System.in);
		bookBiz =new BookBiz();

		System.out.println("*------------------------------------*");
		System.out.println("\t���ã���ӭʹ�þ����ͼ�����ϵͳ");
		System.out.println("\t1���û���¼\t\t2���˳�ϵͳ");
		System.out.println("*------------------------------------*");
		System.out.println("��ѡ��");
		String choice = input.next();
		if("1".equals(choice)) {
			//��¼
			//�����¼�ɹ�����ʾ���˵�
			System.out.println("��Ŀǰ����ֱ��ʹ�ã���¼������δ���ߣ������ڴ���\n");
			//while( showMainView()) { }
			//showMainView();
			doMainView();
		}
		System.out.println("�˳�ϵͳ");
	}
	
	
	@Override
	public String showMainView()
	{
		System.out.println("\n�����ͼ�����ϵͳ>>���˵�");
		System.out.println("1������ͼ��\t2��ɾ��ͼ��\t3���鿴���\t4������Ų�ѯ\n5����� \t6������\t7���˳�");
		System.out.println("��ѡ�� ");
		String choice=input.next();
		return choice;
	}

	@Override
	public void showOutStore()
	{
		 System.out.println("\n�����ͼ�����ϵͳ>>����");
		   System.out.print("������Ҫ�����ͼ����:");
		   String bookId=input.next();
		   System.out.print("������Ҫ�����ͼ������:");
		   int bookCount = input.nextInt();
		   if(bookBiz.inStore(bookId, bookCount)) {
			   System.out.println("����ɹ�");
			   showBooks(null);
		   }else {
			   System.out.println("����ʧ��");
		   } 

	}

	@Override
	public void showInStore()
	{
		System.out.println("\n�����ͼ�����ϵͳ>>���");
		   System.out.print("������Ҫ����ͼ����:");
		   String bookId=input.next();
		   System.out.print("������Ҫ����ͼ������:");
		   int bookCount = input.nextInt();
		   if(bookBiz.inStore(bookId, bookCount)) {
			   System.out.println("���ɹ�");
			   showBooks(null);
		   }else {
			   System.out.println("���ʧ��");
		   }

	}

	@Override
	public void showFindById()
	{
		 System.out.println("\n�����ͼ�����ϵͳ>>����Ų�ѯ");
		   System.out.print("������Ҫ��ѯ��ͼ����:");
		   String bookId = input.next();
		   Book book=bookBiz.findById(bookId);
		   if(book==null) {
			   System.out.println("û���ҵ�����ҵ�ͼ��!");
			   return;
		   }
		   showBooks(book);

	}

	@Override
	public void showDelBookView()
	{
		System.out.println("\n�����ͼ�����ϵͳ>>ɾ��ͼ��");	
		//��ʱֻʵ�ָ���ͼ����ɾ��
		System.out.print("������Ҫɾ����ͼ����:");
		String delId = input.next();
		Book delBook=new Book();
		delBook.setBookId(delId);
		if(bookBiz.delBook(delBook)) {
			//���ɾ���ɹ�
			System.out.println("ɾ���ɹ���");
			showBooks();
		}

	}

	@Override
	public Book showAddNewBookView()
	{
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

	@Override
	public void showBooks(Book... bookArray)
	{
		 System.out.println("���\t����\t���");
		   //������������Ϊ�գ���Ĭ�ϴ�ӡ���е�ͼ��ֿ�
		   if(bookArray==null) {
			   bookArray=Datas.BookStore;
		   }
		   int bookCount = bookBiz.getBookCount(bookArray);
		   for(int i=0;i<bookCount;i++) {
			   System.out.printf("%s\t%s\t%d\n",
					   bookArray[i].getBookId(),bookArray[i].getBookName(),bookArray[i].getCount());
		   }

	}

}
