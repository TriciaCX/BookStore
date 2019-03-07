package bookadminv3;
/**
 * 图书业务类
 * 含有对图书以及图书数组的基本操作
 * MVC-C
 * @author Tricia
 * @version 1.0
 */
public class BookBiz
{
   //基本业务方法：增加图书、出库、入库、查询、排序
   /**
    * 获得图书仓库中Datas.BookStore数组中图书对象的个数
    * @return
    */
    public int getBookCount() {
    	int count=0;
    	for(Book book:Datas.BookStore) {
    		if(book == null) break;
    		count++;
    	}
    	return count;
    }
    
    public int getBookCount(Book...books) {
    	int count=0;
    	for(Book book:books) {
    		if(book == null) break;
    		count++;
    	}
    	return count;
    }
    
	/**
	 * 将输入的图书对象放置到图书仓库（数组）中去
	 * @param book
	 * @return 返回图书是否放置成功，如果图书仓库已满，放回false，表示不能再放入图书
	 */
    public boolean addBook(Book book) {
    	int bookCount=getBookCount();
    	if(Datas.BookStore.length == bookCount) {
    		return false;
    	}
    	//如果图书仓库没满，就将传入的图书对象放置进数组
    	Datas.BookStore[bookCount]=book;
    	return true;
    }
    
    /**
     * 删除输入的图书对象
     * @param book
     * @return 是否删除成功
     */
    public boolean delBook(Book book) {
         int bookCount = getBookCount();
         int delIndex=-1; //要删除的元素
         for(int i=0;i<bookCount;i++) {
        	 if(book.equals(Datas.BookStore[i])) {
        		 delIndex =i;
        		 break;
        	 }
         }
         //如果没有找到要删除的元素，无法执行删除，return false
         if(delIndex==-1) {
        	 return false;
         }
         //删除数组
         for(int i=delIndex;i<bookCount-1;i++) {
        	 Datas.BookStore[i]=Datas.BookStore[i+1]; 	 
         }
         //将最后一个元素置为null
         Datas.BookStore[bookCount-1]=null;
         return true;
    }
    
    /**
     * 通过图书id查找对应的图书对象
     * @param bookId
     * @return 如果查找到了相应的图书，返回查找得到的图书对象；否则返回null
     */
    public Book findById(String bookId) {
    	int bookCount=getBookCount();
    	for(int i=0;i<bookCount;i++)
    	{
    		if(bookId.equals(Datas.BookStore[i].getBookId())) {
    			return Datas.BookStore[i];
    		}
    	}
    	return null;
    }
    
    /**
     * 入库：给书库中已有的图书增加库存
     * @param bookId 要入库的图书id
     * @param count 入库的数量
     * @return 如果入库（要增加数量）的图书不存在，入库失败
     */
    public boolean inStore(String bookId,int count) {
    	Book book= findById(bookId);
    	//如果入库的书不存在，返回false
    	if(null==book) {
    		return false;
    	}
    	//找到了对于的bookId,增加库存
    	book.setCount(book.getCount()+count);
    	return true;
    }
    
    /**
     * 出库：给书库中已有的图书减少库存
     * @param bookId
     * @param count
     * @return 如果出库（要减少）的图书超出了原有的库存，或者图书不存在，出库失败
     */
    public boolean outStore(String bookId,int count) {
    	Book book= findById(bookId);
    	if(null==book) {
    		return false;
    	}
    	if(book.getCount()<count) {
    		return false;
    	}
    	book.setCount(book.getCount()-count);
    	return true;
    }
}
