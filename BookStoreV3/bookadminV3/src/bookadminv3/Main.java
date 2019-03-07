package bookadminv3;

public class Main
{

	public static void main(String[] args)
	{
		//new BookView();
		//AbstractBookView bookView = new BookViewConsole();  //使用控制台
//		AbstractBookView bookView = new BookViewGUI();       //使用对话框
//		bookView.doMainView();
		
		FileUtil.SaveBooks((Datas.BookStore));
		Book[] bookArray = FileUtil.loadBooks();
		for(int i=0;i<bookArray.length;i++) {
			if(bookArray[i]==null) break;
			System.out.println(bookArray[i].getBookId() + "--"+bookArray[i].getBookName());
		}
	}
	
//	public static void show() {
//		BookBiz bookbiz= new BookBiz();
//		if(bookbiz.getBookCount()<0) {
//			System.out.println("仓库已经空啦");
//			return;
//		}
//		for(int i=0;i<new BookBiz().getBookCount();i++) {
//			System.out.println(Datas.BookStore[i].getBookId()+"\t"+Datas.BookStore[i].getBookName()+"\t"+Datas.BookStore[i].getCount());
//		}
//	}

}
