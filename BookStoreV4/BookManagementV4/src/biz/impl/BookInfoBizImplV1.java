package biz.impl;

import java.util.Map;

import biz.BookInfoBiz;
import entity.BookInfo;
import util.FileUtil;

/**
 * 图书业务类的实现类V1
 * @author Tricia
 * @version 4
 */
public class BookInfoBizImplV1 implements BookInfoBiz
{

	@Override
	public boolean add(BookInfo bookInfo)
	{
		//1、获得所有的BookInfoMap
		//2、向map中添加bookInfo对象
		//3、将map对象重新写入文件
		if(bookInfo==null) return false;
		Map<String, BookInfo> bookInfoMap = findAll();
		if(bookInfoMap==null) return false;
		if(bookInfoMap.containsKey(bookInfo.getIsbn())) {//不能添加已有的isbn（isbn唯一）
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
		if(bookInfoMap.containsKey(bookInfo.getIsbn())) {//不能添加已有的isbn（isbn唯一）
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
		//方法在该子类没有意义，抛出异常，并提示调用findByIsbn(String isbn)方法
		throw new UnsupportedOperationException("BookInfoBiz中不支持根据ID的查询操作");
	}

	@Override
	public Map<String, BookInfo> findAll()
	{
		return  FileUtil.ReadBookInfoMap();
	}

	@Override
	public boolean outStore(String isbn, int outCount)
	{
		//取出要出库的书籍信息
		BookInfo bookInfo = findByIsbn(isbn);
		if(bookInfo == null) return false;    //没有找到要出库的书籍
		// 获得文件中所有的书籍信息
		Map<String,BookInfo> bookInfoMap = findAll();
		if(bookInfoMap == null) return false;
	    if(outCount>bookInfo.getInStoreCount()) {//如果要出库的数量大于当前的库存量，返回false
	    	return false;
	    }
	    //如果能顺利实现出库
	    bookInfo.setInStoreCount(bookInfo.getInStoreCount()-outCount);
	    //将更改过的书籍信息放回到集合中
	    bookInfoMap.put(isbn,bookInfo);
	    //在文件中更新所有的书籍信息
	    FileUtil.SaveBookInfoMap(bookInfoMap);
		return true;
	}

	@Override
	public boolean inStore(String isbn, int inCount)
	{
		Map<String,BookInfo> bookInfoMap = findAll();
		if(bookInfoMap == null) return false;
		//入库操作：只能增加已有图书的数量，不能直接对没有记录的书籍进行入库操作（需要首先进行新增图书操作）
		if(!(bookInfoMap.containsKey(isbn))) return false;
		//根据出版号，获得集合中相应的书籍对象
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
