package biz;

import java.util.Map;

/**
 * ����ҵ����ĸ��ӿ�
 * ��ɾ�Ĳ�
 * @author Tricia
 * @version 4
 */
public interface Biz<T>//��ͬҵ����Ҫ���벻ͬ�ķ�������---ʹ�÷��ͣ������Ƿ�������
{ /**ͨ�õ���ӷ���*/
   public boolean add(T t);
   /**ͨ�õ�ɾ������*/
   public boolean del(T t);
   /**ͨ�õ��޸ķ���*/
   public T update(T t);
   /**ͨ�õĲ�ѯ����*/
   public T fingById(String id);
   public Map<String,T> findAll();
}
