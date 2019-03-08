package view;

import java.util.Scanner;

public class BookView
{   
	private Scanner input = null;
	
	public BookView() {
		input = new Scanner(System.in);
		showWel();
	}
	
	/**
     * 欢迎用户界面
     */
	 public void showWel() {
		 System.out.println("*-------欢迎使用升级版图书管理系统-------*");
		 System.out.println("\t\t\t1、登录系统\t2、用户注册\t3、退出系统");
		 System.out.println("*--------------------------------*");
		 System.out.println("请选择：");
		 String choice = input.next();
		 if("1".equals(choice)) {
			 //登录
			 
		 }else if("2".equals(choice)) {
			 //用户注册
			 System.out.println("该功能暂未开放");
		 }else {
			 //系统退出
			 System.out.println("已退出，感谢使用");
		 }
	 }
	 
//	 public void showLoginView() {
//		 
//	 }
	
     public void showMainView_Adminstrator() {
    	 
     }
     
     public void showMainView_Operator() {
    	 
     }
}
