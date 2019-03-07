package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import entity.BookInfo;

/**
 * �ļ�������
 * @author Tricia
 * @version 4
 */
public class FileUtil
{
    //�������У�Ϊ�˲������㣬��ͼ����Ϣ�Զ������ķ�ʽ�����ļ���
	private static final String BookInfoFilePath = "BookInfo.dat";  //����ڱ�����Ĺ��̸�Ŀ¼
	
	/**
	 * �������BookInfo��map��Ϣ����ڶ�Ӧ���ļ���
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
	 * ͨ�õı�����󷽷�
	 * @param object Ҫ���л��Ķ���
	 * @param filePath  �ļ�·��
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
	 * ���ļ���ȡ����
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
