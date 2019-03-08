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
		//����ͼ��ʵ����Ķ���();
		//����ͼ��ҵ����();
		//����ͼ������ͳ���();
		//���Խ�ɫ();
		�����û���();
	}
	
	public static void �����û���() {
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
	
	public static void ���Խ�ɫ() {
		Role role1 = new Role();
		System.out.println(role1.getName()+":"+role1.getKey());
		System.out.println("Ȩ�޼���"+role1.getPermissions());
		System.out.println(role1.inStore("123", 3));
		Role role2 = new Role("����Ա","administrator");
		System.out.println(role2.getName()+":"+role2.getKey());
		System.out.println("Ȩ�޼��ϣ�"+role2.getPermissions());
		System.out.println(role2.inStore("123", 3));
	}
	
	public static void ����ͼ������ͳ���() {
		Scanner input = new Scanner(System.in);
		BookInfoBiz bookInfoBiz = new BookInfoBizImplV1();
		//�������5���鼮
		BookInfo bookInfo = new BookInfo();
		bookInfo.setIsbn("123-456");
		bookInfo.setName("���Գ����");
		Book book= new Book();
	    book.setIsbn("123-456"); //ͬ���鼮�ĳ����һ��
		bookInfo.addBook(book);
		Map<String,BookInfo> infoMap = new HashMap<>();
		//�򼯺������һ���鼮
		 infoMap.put(bookInfo.getIsbn(), bookInfo);
		//��ͼ��д�뵽�ļ���
		FileUtil.SaveBookInfoMap(infoMap);
		
		BookInfo currBookInfo1 = bookInfoBiz.findByIsbn("123-456");
		System.out.println("��ǰ��棺"+currBookInfo1.getInStoreCount());
		
		//���
		System.out.println("ɨ�������ͼ�����ţ�");   //ģ��ɨ��ISBN�Ĳ���
		String isbn = input.next();
		//System.out.println("ɨ�������ͼ��������");
		//Integer inCount = input.nextInt();
		boolean isInStoreSuccess = bookInfoBiz.inStore(isbn, 2);
		System.out.println("����Ƿ�ɹ���"+isInStoreSuccess);
	    currBookInfo1 = bookInfoBiz.findByIsbn(isbn);
		System.out.println("��ǰ��棺"+currBookInfo1.getInStoreCount());
		
		boolean isOutStoreSuccess = bookInfoBiz.outStore(isbn, 10);
		currBookInfo1 = bookInfoBiz.findByIsbn(isbn);
		System.out.println("����Ƿ�ɹ���"+isOutStoreSuccess);
		System.out.println("��ǰ��棺"+currBookInfo1.getInStoreCount());
	}
	
	public static void ����ͼ��ҵ����() {
		BookInfoBiz bookInfoBiz = new BookInfoBizImplV1();
		bookInfoBiz.fingById("sbc");
		}

	public static void ����ͼ��ʵ����Ķ���() {
		BookInfo bookInfo = new BookInfo();
		bookInfo.setIsbn("123-456");
		bookInfo.setName("����ͼ��ʵ����Ķ���");
		Book book = new Book();
		book.setIsbn("123-456"); //�൱��ɨ��ͼ���ISBN����ȷ��ͼ����ϸ��Ϣ
		bookInfo.addBook(book);
		Map<String,BookInfo> infoMap = new HashMap<>();
		infoMap.put(bookInfo.getIsbn(), bookInfo);
		FileUtil.SaveBookInfoMap(infoMap);
		System.out.println(book.getBookInfo().getName());
		infoMap =  FileUtil.ReadBookInfoMap();
		System.out.println("���ļ��ж�ȡͼ����Ϣ...");
		for(String isbn : infoMap.keySet()) {
			System.out.println(isbn);
		}
		
	}
}
