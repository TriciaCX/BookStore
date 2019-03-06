package bookadminv1;
import java.util.Scanner;

/**
 * 图书系统的视图
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
	   System.out.println("\t您好，欢迎使用经典版图书管理系统");
	   System.out.println("\t1、用户登录\t\t\t2、退出系统");
	   System.out.println("*--------------------------------*");
	   System.out.println("请选择：");
	   String choice = input.next();
	   if("1".equals(choice)) {
		   //登录
		   //如果登录成功，显示主菜单
		   System.out.println("您目前可以直接使用，登录功能暂未上线，敬请期待。\n");
		   showMainView();
	   }
	   System.out.println("退出系统");

   }
   
   public void showMainView() {
	   System.out.println("\n经典版图书管理系统>>主菜单");
	   System.out.println("1、新增图书\t2、删除图书\t3、查看书库\t4、按编号查询\t5、入库\t6、出库\t7、退出");
	   System.out.println("请选择： ");
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
    * 新增图书
    * @return
    */
   public Book showAddNewBookView() {
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
   
   public void showBooks(Book ... bookArray) {//可以打印一个数组，也可以打印一本书
	   System.out.println("编号\t名称\t库存");
	   int bookCount = bookBiz.getBookCount(bookArray);
	   for(int i=0;i<bookCount;i++) {
		   System.out.printf("%s\t%s\t%d\n",
				   bookArray[i].getBookId(),bookArray[i].getBookName(),bookArray[i].getCount());
	   }
   }
}

