package bookadminv3;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 文件工具类
 * @author TriciaCX
 * @version 3.0
 */
public class FileUtil{
  /**
   * 用于进行读写操作的图书信息文件路径
   * 文件名： Bookinfo.dat
   */
   private static final String BookFile= "Bookinfo.dat";
   /**
    * 分隔属性，默认英文逗号
    */
   private static final String separateAttr = ",";
   /**
    * 分隔行
    */
   private static final String separateLine = System.getProperty("line.separator"); 
   /**
    * 将传入的图书对象数组写入到文件中(全部重写-覆盖)
    * @param bookArray
    */
   public static void SaveBooks(Book...bookArray) {
	   if(bookArray==null||bookArray.length==0) return;
	   BookBiz bookBiz = new BookBiz();
	   File bookFile = new File(BookFile);
	   //如果传入文件不存在，新建一个文件
	   if(!bookFile.exists())
		   try {
			   bookFile.createNewFile();
		   }catch(IOException e) {
			   e.printStackTrace();
		   }
	   try(FileWriter fOut = new FileWriter(bookFile,false); //不追加会覆盖当前文件
			   BufferedWriter out = new BufferedWriter(fOut);
			   ){
		       StringBuffer content = new StringBuffer();
		       int bookCount = bookBiz.getBookCount(bookArray); //获得传入图书数组的实际图书数量（否则会每次按最大存入数算，报错）
               for(int i=0;i<bookCount;i++) {//实现简单的属性拼接，我们希望打印的字符串是分行的
            	   content.append(bookArray[i].getBookId()); content.append(separateAttr);
            	   content.append(bookArray[i].getBookName()); content.append(separateAttr);
            	   content.append(bookArray[i].getCount()); content.append(separateLine); 
            	    }  
               //将字符串写入到文件
              // out.write(content.toString().getBytes());
               out.write(content.toString());
	   }catch (FileNotFoundException e) {
		   e.printStackTrace();
	   }catch (IOException e) {
		   e.printStackTrace();
	   }
   }
   /**
    * 从文件中读取内容，将内容逐行拆解，重新整合成对象数组并返回
    * @return
    */
   public static Book[] loadBooks() {
	  File bookFile = new File(BookFile);
	  if(!bookFile.exists()) {
		  return null;
	  }
	  Book[] bookArray = new Book[999]; //注意：读取的时候最多只能读取999个图书对象
	  try(FileReader fReader =  new FileReader(bookFile);
			BufferedReader reader = new BufferedReader(fReader);  ){
		  String line = null;
		  int count = 0;
		  while((line = reader.readLine())!=null) {//读取文件
			  Book currBook =new Book();
			  String[] attrs = line.split(separateAttr); //将读取出的一行以属性分隔符分隔开，返回分隔后的字符串
			  currBook.setBookId(attrs[0].trim());
			  currBook.setBookName(attrs[1].trim());
			  currBook.setCount(Integer.parseInt(attrs[2].trim()));
			  //将构建成功的图书对象添加到图书数组中
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
