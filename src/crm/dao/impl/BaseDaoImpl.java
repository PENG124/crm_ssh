package crm.dao.impl;

import java.lang.reflect.*;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import crm.dao.BaseDao;
/**
 * dao�ӿ�ʵ����̳и�����dao�ӿڣ���ȷ���Ͳ�����
 * ����ʹ��this.getHibernateTemplate()����
 * �ӿ�ʵ��������beanʱ������ע��sessionFactory ,��ʡȥע��hibernateTemplate
 * @author user
 *
 * @param <T>
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	@SuppressWarnings("rawtypes")
	private Class clazzType;

	//���캯��
	@SuppressWarnings("rawtypes")
	public BaseDaoImpl() {
		//1 ��ȡ��ǰ���ж����class
		//��������customerDaoʵ���࣬�õ�customerDaoʵ����class
		Class clazz = this.getClass();
		
		//2 ��ȡ������ĸ���Ĳ���������
		Type type = clazz.getGenericSuperclass();
		
		//3 ת�����ӽӿ�ParameterizedType
		ParameterizedType ptype = (ParameterizedType) type;
		
		//4 ��ȡʵ�����Ͳ���
		//���� Map<key,value>
		Type[] types = ptype.getActualTypeArguments();
		
		//5 ��Type���class
		Class clazzParameter =  (Class) types[0];
		this.clazzType = clazzParameter;
	}

	public void add(T t) {
		this.getHibernateTemplate().save(t);
	}

	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	@SuppressWarnings("unchecked")
	public T get(Integer id) {
		// TODO Auto-generated method stub
		return (T) this.getHibernateTemplate().get(clazzType, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return (List<T>) this.getHibernateTemplate().find("from "+clazzType.getSimpleName());
	}

}
