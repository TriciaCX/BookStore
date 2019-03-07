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
//		System.out.println("\n经典版图书管理系统>>主菜单");
//		System.out.println("1、新增图书\t2、删除图书\t3、查看书库\t4、按编号查询\n5、入库 \t6、出库\t7、退出");
//		System.out.println("请选择： ");
//      改进显示
		String strMenu = "\n经典版图书管理系统>>主菜单";
		strMenu +="1、新增图书\t2、删除图书\t3、查看书库\t4、按编号查询\n5、入库 \t6、出库\t7、退出\n";
		strMenu +="请选择： ";
		String choice = JOptionPane.showInputDialog(strMenu);
		if(choice==null) {choice="7";}     //相当于退出，不加这句会返回null，报异常
		return choice;
	}
	@Override
	public void showOutStore()
	{
		// TODO 自动生成的方法存根
		
	}
	@Override
	public void showInStore()
	{
		// TODO 自动生成的方法存根
		
	}
	@Override
	public void showFindById()
	{
		// TODO 自动生成的方法存根
		
	}
	@Override
	public void showDelBookView()
	{
		// TODO 自动生成的方法存根
		
	}
	@Override
	public Book showAddNewBookView()
	{
		Book newBook = new Book();
		String bookId = null;
		String bookName = null;
		int count = -1;
		bookId = JOptionPane.showInputDialog("请输入图书编号：");
		bookName = JOptionPane.showInputDialog("图书名称：");
		count = Integer.parseInt(JOptionPane.showInputDialog("图书库存数量："));
		
		newBook.setBookId(bookId);
		newBook.setBookName(bookName);
		newBook.setCount(count);
		bookBiz.addBook(newBook);
		if(bookBiz.addBook(newBook)) {
			JOptionPane.showMessageDialog(null,"新增图书成功");
		}else {
			JOptionPane.showMessageDialog(null,"新增图书失败");
		}
		return null;
	}
	@Override
	public void showBooks(Book... bookArray)
	{
		// TODO 自动生成的方法存根
		
	}
}
