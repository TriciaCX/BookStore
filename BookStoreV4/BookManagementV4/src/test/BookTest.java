package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import auth.Role;
import biz.BookInfoBiz;
import biz.impl.BookInfoBizImplV1;
import entity.Book;
import entity.BookInfo;
import entity.User;
import util.FileUtil;

public class BookTest
{

	public static void main(String[] args)
	{
		//测试图书实体类的定义();
		//测试图书业务类();
		//测试图书的入库和出库();
		//测试角色();
		测试用户类();
	}
	
	public static void 测试用户类() {
		User user = new User(new Role("a","operator"));
		user.setUserName("testusername");
		user.setPassword("testpassword");
		Set<User> userSet = new HashSet<>();
		userSet.add(user);
		FileUtil.SaveUser(userSet);
		
		userSet = FileUtil.ReadUser();
		for(User u:userSet) {
			System.err.println(user.getUserName()+","+user.getPassword());
		}
	}
	
	public static void 测试角色() {
		Role role1 = new Role();
		System.out.println(role1.getName()+":"+role1.getKey());
		System.out.println("权限集合"+role1.getPermissions());
		System.out.println(role1.inStore("123", 3));
		Role role2 = new Role("操作员","administrator");
		System.out.println(role2.getName()+":"+role2.getKey());
		System.out.println("权限集合："+role2.getPermissions());
		System.out.println(role2.inStore("123", 3));
	}
	
	public static void 测试图书的入库和出库() {
		Scanner input = new Scanner(System.in);
		BookInfoBiz bookInfoBiz = new BookInfoBizImplV1();
		//随机增加5本书籍
		BookInfo bookInfo = new BookInfo();
		bookInfo.setIsbn("123-456");
		bookInfo.setName("测试出入库");
		Book book= new Book();
	    book.setIsbn("123-456"); //同类书籍的出版号一致
		bookInfo.addBook(book);
		Map<String,BookInfo> infoMap = new HashMap<>();
		//向集合中添加一种书籍
		 infoMap.put(bookInfo.getIsbn(), bookInfo);
		//将图书写入到文件中
		FileUtil.SaveBookInfoMap(infoMap);
		
		BookInfo currBookInfo1 = bookInfoBiz.findByIsbn("123-456");
		System.out.println("当前库存："+currBookInfo1.getInStoreCount());
		
		//入库
		System.out.println("扫描待入库的图书出版号：");   //模拟扫描ISBN的操作
		String isbn = input.next();
		//System.out.println("扫描待入库的图书数量：");
		//Integer inCount = input.nextInt();
		boolean isInStoreSuccess = bookInfoBiz.inStore(isbn, 2);
		System.out.println("入库是否成功："+isInStoreSuccess);
	    currBookInfo1 = bookInfoBiz.findByIsbn(isbn);
		System.out.println("当前库存："+currBookInfo1.getInStoreCount());
		
		boolean isOutStoreSuccess = bookInfoBiz.outStore(isbn, 10);
		currBookInfo1 = bookInfoBiz.findByIsbn(isbn);
		System.out.println("入库是否成功："+isOutStoreSuccess);
		System.out.println("当前库存："+currBookInfo1.getInStoreCount());
	}
	
	public static void 测试图书业务类() {
		BookInfoBiz bookInfoBiz = new BookInfoBizImplV1();
		bookInfoBiz.fingById("sbc");
		}

	public static void 测试图书实体类的定义() {
		BookInfo bookInfo = new BookInfo();
		bookInfo.setIsbn("123-456");
		bookInfo.setName("测试图书实体类的定义");
		Book book = new Book();
		book.setIsbn("123-456"); //相当于扫描图书的ISBN即可确认图书详细信息
		bookInfo.addBook(book);
		Map<String,BookInfo> infoMap = new HashMap<>();
		infoMap.put(bookInfo.getIsbn(), bookInfo);
		FileUtil.SaveBookInfoMap(infoMap);
		System.out.println(book.getBookInfo().getName());
		infoMap =  FileUtil.ReadBookInfoMap();
		System.out.println("从文件中读取图书信息...");
		for(String isbn : infoMap.keySet()) {
			System.out.println(isbn);
		}
		
	}
}
