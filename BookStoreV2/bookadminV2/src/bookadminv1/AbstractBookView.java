package bookadminv1;
import java.util.Scanner;
/**
 * 图书系统的视图
 * MVC-V 
 * @author Tricia
 * @version 1.0
 */


public abstract class AbstractBookView{


	public AbstractBookView() {
		//doMainView();
	}

	/**
	 * 程序逻辑
	 */
	public void doMainView() {
		String choice = showMainView();
		switch(choice) {
		case "1"://新增图书
			showAddNewBookView();
			showBooks(Datas.BookStore);
			break;
		case "2"://删除图书
			showDelBookView();
			break;
		case "3"://查看书库
			showBooks(null);
			break;
		case "4"://按编号查询
			showFindById();
			break;
		case "5"://入库
			showInStore();
			break;
		case "6"://出库
			showOutStore();
			break;
		case "7":
			//System.exit(0);//退出系统
			//return false;
			return;
		default:
			break;
		}
		doMainView();
		//return true;
	}

	/**
	 * 显示主菜单
	 * @return 返回用户选择的菜单项
	 */
	public abstract String showMainView();

	/**
	 * 出库
	 * 注意点：只能对库存足够的书籍执行出库操作
	 */
	public abstract void showOutStore() ;

	/**
	 * 入库
	 * 注意点：只能增加已有图书的库存 
	 */
	public abstract void showInStore() ;

	/**
	 * 按编号查询
	 */
	public abstract void showFindById() ;

	/**
	 * 删除图书
	 * 
	 */
	public abstract void showDelBookView() ;

	/**
	 * 新增图书
	 * @return
	 */
	public abstract Book showAddNewBookView();
	/**
	 * 显示所有的图书信息
	 * 如果传入的是null，则默认显示图书仓库中的数组，Datas.BookStore
	 * @param bookArray
	 */
	public abstract void showBooks(Book ... bookArray);

}
