package bookadminv3;
/**
 * ͼ��ҵ����
 * ���ж�ͼ���Լ�ͼ������Ļ�������
 * MVC-C
 * @author Tricia
 * @version 1.0
 */
public class BookBiz
{
   //����ҵ�񷽷�������ͼ�顢���⡢��⡢��ѯ������
   /**
    * ���ͼ��ֿ���Datas.BookStore������ͼ�����ĸ���
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
	 * �������ͼ�������õ�ͼ��ֿ⣨���飩��ȥ
	 * @param book
	 * @return ����ͼ���Ƿ���óɹ������ͼ��ֿ��������Ż�false����ʾ�����ٷ���ͼ��
	 */
    public boolean addBook(Book book) {
    	int bookCount=getBookCount();
    	if(Datas.BookStore.length == bookCount) {
    		return false;
    	}
    	//���ͼ��ֿ�û�����ͽ������ͼ�������ý�����
    	Datas.BookStore[bookCount]=book;
    	return true;
    }
    
    /**
     * ɾ�������ͼ�����
     * @param book
     * @return �Ƿ�ɾ���ɹ�
     */
    public boolean delBook(Book book) {
         int bookCount = getBookCount();
         int delIndex=-1; //Ҫɾ����Ԫ��
         for(int i=0;i<bookCount;i++) {
        	 if(book.equals(Datas.BookStore[i])) {
        		 delIndex =i;
        		 break;
        	 }
         }
         //���û���ҵ�Ҫɾ����Ԫ�أ��޷�ִ��ɾ����return false
         if(delIndex==-1) {
        	 return false;
         }
         //ɾ������
         for(int i=delIndex;i<bookCount-1;i++) {
        	 Datas.BookStore[i]=Datas.BookStore[i+1]; 	 
         }
         //�����һ��Ԫ����Ϊnull
         Datas.BookStore[bookCount-1]=null;
         return true;
    }
    
    /**
     * ͨ��ͼ��id���Ҷ�Ӧ��ͼ�����
     * @param bookId
     * @return ������ҵ�����Ӧ��ͼ�飬���ز��ҵõ���ͼ����󣻷��򷵻�null
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
     * ��⣺����������е�ͼ�����ӿ��
     * @param bookId Ҫ����ͼ��id
     * @param count ��������
     * @return �����⣨Ҫ������������ͼ�鲻���ڣ����ʧ��
     */
    public boolean inStore(String bookId,int count) {
    	Book book= findById(bookId);
    	//��������鲻���ڣ�����false
    	if(null==book) {
    		return false;
    	}
    	//�ҵ��˶��ڵ�bookId,���ӿ��
    	book.setCount(book.getCount()+count);
    	return true;
    }
    
    /**
     * ���⣺����������е�ͼ����ٿ��
     * @param bookId
     * @param count
     * @return ������⣨Ҫ���٣���ͼ�鳬����ԭ�еĿ�棬����ͼ�鲻���ڣ�����ʧ��
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
