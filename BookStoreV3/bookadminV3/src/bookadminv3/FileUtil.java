package bookadminv3;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * �ļ�������
 * @author TriciaCX
 * @version 3.0
 */
public class FileUtil{
  /**
   * ���ڽ��ж�д������ͼ����Ϣ�ļ�·��
   * �ļ����� Bookinfo.dat
   */
   private static final String BookFile= "Bookinfo.dat";
   /**
    * �ָ����ԣ�Ĭ��Ӣ�Ķ���
    */
   private static final String separateAttr = ",";
   /**
    * �ָ���
    */
   private static final String separateLine = System.getProperty("line.separator"); 
   /**
    * �������ͼ���������д�뵽�ļ���(ȫ����д-����)
    * @param bookArray
    */
   public static void SaveBooks(Book...bookArray) {
	   if(bookArray==null||bookArray.length==0) return;
	   BookBiz bookBiz = new BookBiz();
	   File bookFile = new File(BookFile);
	   //��������ļ������ڣ��½�һ���ļ�
	   if(!bookFile.exists())
		   try {
			   bookFile.createNewFile();
		   }catch(IOException e) {
			   e.printStackTrace();
		   }
	   try(FileWriter fOut = new FileWriter(bookFile,false); //��׷�ӻḲ�ǵ�ǰ�ļ�
			   BufferedWriter out = new BufferedWriter(fOut);
			   ){
		       StringBuffer content = new StringBuffer();
		       int bookCount = bookBiz.getBookCount(bookArray); //��ô���ͼ�������ʵ��ͼ�������������ÿ�ΰ����������㣬����
               for(int i=0;i<bookCount;i++) {//ʵ�ּ򵥵�����ƴ�ӣ�����ϣ����ӡ���ַ����Ƿ��е�
            	   content.append(bookArray[i].getBookId()); content.append(separateAttr);
            	   content.append(bookArray[i].getBookName()); content.append(separateAttr);
            	   content.append(bookArray[i].getCount()); content.append(separateLine); 
            	    }  
               //���ַ���д�뵽�ļ�
              // out.write(content.toString().getBytes());
               out.write(content.toString());
	   }catch (FileNotFoundException e) {
		   e.printStackTrace();
	   }catch (IOException e) {
		   e.printStackTrace();
	   }
   }
   /**
    * ���ļ��ж�ȡ���ݣ����������в�⣬�������ϳɶ������鲢����
    * @return
    */
   public static Book[] loadBooks() {
	  File bookFile = new File(BookFile);
	  if(!bookFile.exists()) {
		  return null;
	  }
	  Book[] bookArray = new Book[999]; //ע�⣺��ȡ��ʱ�����ֻ�ܶ�ȡ999��ͼ�����
	  try(FileReader fReader =  new FileReader(bookFile);
			BufferedReader reader = new BufferedReader(fReader);  ){
		  String line = null;
		  int count = 0;
		  while((line = reader.readLine())!=null) {//��ȡ�ļ�
			  Book currBook =new Book();
			  String[] attrs = line.split(separateAttr); //����ȡ����һ�������Էָ����ָ��������طָ�����ַ���
			  currBook.setBookId(attrs[0].trim());
			  currBook.setBookName(attrs[1].trim());
			  currBook.setCount(Integer.parseInt(attrs[2].trim()));
			  //�������ɹ���ͼ�������ӵ�ͼ��������
			  bookArray[count++] = currBook;
		  }
	  } catch (FileNotFoundException e)
	{
	
		e.printStackTrace();
	} catch (IOException e)
	{
		
		e.printStackTrace();
	}
	  return bookArray;
   }

}
