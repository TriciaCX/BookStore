package bookadminv1;

public class Main
{

	public static void main(String[] args)
	{
		new BookView();
	}
	
	public static void show() {
		BookBiz bookbiz= new BookBiz();
		if(bookbiz.getBookCount()<0) {
			System.out.println("²Ö¿âÒÑ¾­¿ÕÀ²");
			return;
		}
		for(int i=0;i<new BookBiz().getBookCount();i++) {
			System.out.println(Datas.BookStore[i].getBookId()+"\t"+Datas.BookStore[i].getBookName()+"\t"+Datas.BookStore[i].getCount());
		}
	}

}
