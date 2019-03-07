package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import entity.BookInfo;

/**
 * 文件工具类
 * @author Tricia
 * @version 4
 */
public class FileUtil
{
    //本程序中，为了操作方便，将图书信息以对象流的方式放在文件中
	private static final String BookInfoFilePath = "BookInfo.dat";  //相对于本程序的工程根目录
	
	/**
	 * 将传入的BookInfo的map信息存放在对应的文件中
	 * @param bookInfoMap
	 */
	public static void SaveBookInfoMap(Map<String,BookInfo> bookInfoMap) {
		SaveObject(bookInfoMap,BookInfoFilePath);
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String,BookInfo> ReadBookInfoMap(){
		Object obj = ReadObejct(BookInfoFilePath);
		if(obj==null) return null;
		return(Map<String,BookInfo>)obj;
	}
	
	
	/**
	 * 通用的保存对象方法
	 * @param object 要序列化的对象
	 * @param filePath  文件路径
	 */
	public static void SaveObject(Object object, String filePath) {
		try(
			FileOutputStream fout =  new FileOutputStream(filePath,false);	
				ObjectOutputStream out = new ObjectOutputStream(fout);
		) {
			out.writeObject(object);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 从文件读取对象
	 * @param filePath
	 * @return
	 */
	public static Object ReadObejct(String filePath) {
		try(
			FileInputStream fin = new FileInputStream(filePath);
			ObjectInputStream in = new ObjectInputStream(fin);
	    ){
			return in.readObject();
		}catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
}
