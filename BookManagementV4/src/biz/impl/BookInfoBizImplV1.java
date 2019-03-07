package biz.impl;

import java.util.Map;

import biz.BookInfoBiz;
import entity.BookInfo;
import util.FileUtil;

/**
 * ͼ��ҵ�����ʵ����V1
 * @author Tricia
 * @version 4
 */
public class BookInfoBizImplV1 implements BookInfoBiz
{

	@Override
	public boolean add(BookInfo bookInfo)
	{
		//1��������е�BookInfoMap
		//2����map�����bookInfo����
		//3����map��������д���ļ�
		if(bookInfo==null) return false;
		Map<String, BookInfo> bookInfoMap = findAll();
		if(bookInfoMap==null) return false;
		if(bookInfoMap.containsKey(bookInfo.getIsbn())) {//����������е�isbn��isbnΨһ��
			return false;
		}
		bookInfoMap.put(bookInfo.getIsbn(), bookInfo);
		FileUtil.SaveBookInfoMap(bookInfoMap);
		return true;
	}

	@Override
	public boolean del(BookInfo bookInfo)
	{
		if(bookInfo==null) return false;
		Map<String, BookInfo> bookInfoMap = findAll();
		if(bookInfoMap==null) return false;
		if(bookInfoMap.containsKey(bookInfo.getIsbn())) {//����������е�isbn��isbnΨһ��
			return false;
		}
		bookInfoMap.remove(bookInfo.getIsbn());
		FileUtil.SaveBookInfoMap(bookInfoMap);
		return true;
	}

	@Override
	public BookInfo update(BookInfo bookInfo)
	{
		if(bookInfo==null) return null;
		Map<String, BookInfo> bookInfoMap = findAll();
		if(bookInfoMap==null) return null;
		if(!bookInfoMap.containsKey(bookInfo.getIsbn())) {
		return null;
		}
		bookInfoMap.put(bookInfo.getIsbn(),bookInfo);
		FileUtil.SaveBookInfoMap(bookInfoMap);
		return bookInfo;
	}

	@Override
	public BookInfo fingById(String id)
	{
		//�����ڸ�����û�����壬�׳��쳣������ʾ����findByIsbn(String isbn)����
		throw new UnsupportedOperationException("BookInfoBiz�в�֧�ָ���ID�Ĳ�ѯ����");
	}

	@Override
	public Map<String, BookInfo> findAll()
	{
		return  FileUtil.ReadBookInfoMap();
	}

	@Override
	public boolean outStore(String isbn, int outCount)
	{
		//ȡ��Ҫ������鼮��Ϣ
		BookInfo bookInfo = findByIsbn(isbn);
		if(bookInfo == null) return false;    //û���ҵ�Ҫ������鼮
		// ����ļ������е��鼮��Ϣ
		Map<String,BookInfo> bookInfoMap = findAll();
		if(bookInfoMap == null) return false;
	    if(outCount>bookInfo.getInStoreCount()) {//���Ҫ������������ڵ�ǰ�Ŀ����������false
	    	return false;
	    }
	    //�����˳��ʵ�ֳ���
	    bookInfo.setInStoreCount(bookInfo.getInStoreCount()-outCount);
	    //�����Ĺ����鼮��Ϣ�Żص�������
	    bookInfoMap.put(isbn,bookInfo);
	    //���ļ��и������е��鼮��Ϣ
	    FileUtil.SaveBookInfoMap(bookInfoMap);
		return true;
	}

	@Override
	public boolean inStore(String isbn, int inCount)
	{
		Map<String,BookInfo> bookInfoMap = findAll();
		if(bookInfoMap == null) return false;
		//��������ֻ����������ͼ�������������ֱ�Ӷ�û�м�¼���鼮��������������Ҫ���Ƚ�������ͼ�������
		if(!(bookInfoMap.containsKey(isbn))) return false;
		//���ݳ���ţ���ü�������Ӧ���鼮����
		BookInfo bookInfo = bookInfoMap.get(isbn);
		bookInfo.setInStoreCount(bookInfo.getInStoreCount()+inCount);
		bookInfoMap.put(isbn, bookInfo);
		FileUtil.SaveBookInfoMap(bookInfoMap);
		return true;
	}

	@Override
	public BookInfo findByIsbn(String isbn)
	{
		if(isbn == null||"".equals(isbn)) return null;
		Map<String,BookInfo> bookInfoMap = findAll();
		if(bookInfoMap==null) return null;
		if(!bookInfoMap.containsKey(isbn)) return null;
		return bookInfoMap.get(isbn);
	}

}
