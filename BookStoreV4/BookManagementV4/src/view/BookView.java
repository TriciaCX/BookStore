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
     * ��ӭ�û�����
     */
	 public void showWel() {
		 System.out.println("*-------��ӭʹ��������ͼ�����ϵͳ-------*");
		 System.out.println("\t\t\t1����¼ϵͳ\t2���û�ע��\t3���˳�ϵͳ");
		 System.out.println("*--------------------------------*");
		 System.out.println("��ѡ��");
		 String choice = input.next();
		 if("1".equals(choice)) {
			 //��¼
			 
		 }else if("2".equals(choice)) {
			 //�û�ע��
			 System.out.println("�ù�����δ����");
		 }else {
			 //ϵͳ�˳�
			 System.out.println("���˳�����лʹ��");
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
