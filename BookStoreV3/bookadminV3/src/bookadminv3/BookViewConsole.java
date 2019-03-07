package bookadminv3;

import java.util.Scanner;

/**
 * 图书系统界面控制台实现类
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
		System.out.println("\t您好，欢迎使用经典版图书管理系统");
		System.out.println("\t1、用户登录\t\t2、退出系统");
		System.out.println("*------------------------------------*");
		System.out.println("请选择：");
		String choice = input.next();
		if("1".equals(choice)) {
			//登录
			//如果登录成功，显示主菜单
			System.out.println("您目前可以直接使用，登录功能暂未上线，敬请期待。\n");
			//while( showMainView()) { }
			//showMainView();
			doMainView();
		}
		System.out.println("退出系统");
	}
	
	
	@Override
	public String showMainView()
	{
		System.out.println("\n经典版图书管理系统>>主菜单");
		System.out.println("1、新增图书\t2、删除图书\t3、查看书库\t4、按编号查询\n5、入库 \t6、出库\t7、退出");
		System.out.println("请选择： ");
		String choice=input.next();
		return choice;
	}

	@Override
	public void showOutStore()
	{
		 System.out.println("\n经典版图书管理系统>>出库");
		   System.out.print("请输入要出库的图书编号:");
		   String bookId=input.next();
		   System.out.print("请输入要出库的图书数量:");
		   int bookCount = input.nextInt();
		   if(bookBiz.inStore(bookId, bookCount)) {
			   System.out.println("出库成功");
			   showBooks(null);
		   }else {
			   System.out.println("出库失败");
		   } 

	}

	@Override
	public void showInStore()
	{
		System.out.println("\n经典版图书管理系统>>入库");
		   System.out.print("请输入要入库的图书编号:");
		   String bookId=input.next();
		   System.out.print("请输入要入库的图书数量:");
		   int bookCount = input.nextInt();
		   if(bookBiz.inStore(bookId, bookCount)) {
			   System.out.println("入库成功");
			   showBooks(null);
		   }else {
			   System.out.println("入库失败");
		   }

	}

	@Override
	public void showFindById()
	{
		 System.out.println("\n经典版图书管理系统>>按编号查询");
		   System.out.print("请输入要查询的图书编号:");
		   String bookId = input.next();
		   Book book=bookBiz.findById(bookId);
		   if(book==null) {
			   System.out.println("没有找到你查找的图书!");
			   return;
		   }
		   showBooks(book);

	}

	@Override
	public void showDelBookView()
	{
		System.out.println("\n经典版图书管理系统>>删除图书");	
		//暂时只实现根据图书编号删除
		System.out.print("请输入要删除的图书编号:");
		String delId = input.next();
		Book delBook=new Book();
		delBook.setBookId(delId);
		if(bookBiz.delBook(delBook)) {
			//如果删除成功
			System.out.println("删除成功！");
			showBooks();
		}

	}

	@Override
	public Book showAddNewBookView()
	{
		System.out.println("\n经典版图书管理系统>>新增图书");
		   System.out.println("编号：");
		   String bookId = input.next();
		   //验证用户输入的编号是否已经在书库中
		   Book newBook=bookBiz.findById(bookId);
		   if(newBook==null) {
			   //可以增加图书
			   newBook=new Book();
			   newBook.setBookId(bookId);
			   System.out.println("名称：");
			   newBook.setBookName(input.next());
			   System.out.println("库存：");
			   newBook.setCount(input.nextInt());
			   //......
			   bookBiz.addBook(newBook);//将新增的图书对象添加到书库中
		   }else {
			   //图书已经存在
			   System.out.println("您输入的图书已存在，请重新输入");
			   newBook=showAddNewBookView();//让用户再次输入，递归调用showAddNewBookView()即可
		   }
		   return newBook; 
	}

	@Override
	public void showBooks(Book... bookArray)
	{
		 System.out.println("编号\t名称\t库存");
		   //如果传入的数组为空，就默认打印现有的图书仓库
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
