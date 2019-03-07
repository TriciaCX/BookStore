package biz;

import java.util.Map;

/**
 * 所有业务类的父接口
 * 增删改查
 * @author Tricia
 * @version 4
 */
public interface Biz<T>//不同业务需要是想不同的方法功能---使用泛型，而不是方法重载
{ /**通用的添加方法*/
   public boolean add(T t);
   /**通用的删除方法*/
   public boolean del(T t);
   /**通用的修改方法*/
   public T update(T t);
   /**通用的查询方法*/
   public T fingById(String id);
   public Map<String,T> findAll();
}
