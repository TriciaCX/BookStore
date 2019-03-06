package bookadminv1;
import java.util.Scanner;
/**
 * ͼ��ϵͳ����ͼ
 * MVC-V 
 * @author Tricia
 * @version 1.0
 */


public abstract class AbstractBookView{


	public AbstractBookView() {
		//doMainView();
	}

	/**
	 * �����߼�
	 */
	public void doMainView() {
		String choice = showMainView();
		switch(choice) {
		case "1"://����ͼ��
			showAddNewBookView();
			showBooks(Datas.BookStore);
			break;
		case "2"://ɾ��ͼ��
			showDelBookView();
			break;
		case "3"://�鿴���
			showBooks(null);
			break;
		case "4"://����Ų�ѯ
			showFindById();
			break;
		case "5"://���
			showInStore();
			break;
		case "6"://����
			showOutStore();
			break;
		case "7":
			//System.exit(0);//�˳�ϵͳ
			//return false;
			return;
		default:
			break;
		}
		doMainView();
		//return true;
	}

	/**
	 * ��ʾ���˵�
	 * @return �����û�ѡ��Ĳ˵���
	 */
	public abstract String showMainView();

	/**
	 * ����
	 * ע��㣺ֻ�ܶԿ���㹻���鼮ִ�г������
	 */
	public abstract void showOutStore() ;

	/**
	 * ���
	 * ע��㣺ֻ����������ͼ��Ŀ�� 
	 */
	public abstract void showInStore() ;

	/**
	 * ����Ų�ѯ
	 */
	public abstract void showFindById() ;

	/**
	 * ɾ��ͼ��
	 * 
	 */
	public abstract void showDelBookView() ;

	/**
	 * ����ͼ��
	 * @return
	 */
	public abstract Book showAddNewBookView();
	/**
	 * ��ʾ���е�ͼ����Ϣ
	 * ����������null����Ĭ����ʾͼ��ֿ��е����飬Datas.BookStore
	 * @param bookArray
	 */
	public abstract void showBooks(Book ... bookArray);

}
