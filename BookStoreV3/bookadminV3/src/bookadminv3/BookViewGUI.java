package bookadminv3;

import javax.swing.JOptionPane;

public class BookViewGUI extends AbstractBookView
{
    private BookBiz bookBiz = null;
    public BookViewGUI() {
    	bookBiz = new BookBiz();
    }
	@Override
	public String showMainView()
	{
//		System.out.println("\n�����ͼ�����ϵͳ>>���˵�");
//		System.out.println("1������ͼ��\t2��ɾ��ͼ��\t3���鿴���\t4������Ų�ѯ\n5����� \t6������\t7���˳�");
//		System.out.println("��ѡ�� ");
//      �Ľ���ʾ
		String strMenu = "\n�����ͼ�����ϵͳ>>���˵�";
		strMenu +="1������ͼ��\t2��ɾ��ͼ��\t3���鿴���\t4������Ų�ѯ\n5����� \t6������\t7���˳�\n";
		strMenu +="��ѡ�� ";
		String choice = JOptionPane.showInputDialog(strMenu);
		if(choice==null) {choice="7";}     //�൱���˳����������᷵��null�����쳣
		return choice;
	}
	@Override
	public void showOutStore()
	{
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public void showInStore()
	{
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public void showFindById()
	{
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public void showDelBookView()
	{
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public Book showAddNewBookView()
	{
		Book newBook = new Book();
		String bookId = null;
		String bookName = null;
		int count = -1;
		bookId = JOptionPane.showInputDialog("������ͼ���ţ�");
		bookName = JOptionPane.showInputDialog("ͼ�����ƣ�");
		count = Integer.parseInt(JOptionPane.showInputDialog("ͼ����������"));
		
		newBook.setBookId(bookId);
		newBook.setBookName(bookName);
		newBook.setCount(count);
		bookBiz.addBook(newBook);
		if(bookBiz.addBook(newBook)) {
			JOptionPane.showMessageDialog(null,"����ͼ��ɹ�");
		}else {
			JOptionPane.showMessageDialog(null,"����ͼ��ʧ��");
		}
		return null;
	}
	@Override
	public void showBooks(Book... bookArray)
	{
		// TODO �Զ����ɵķ������
		
	}
}
