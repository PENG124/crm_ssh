package crm.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import crm.dao.UserDao;
import crm.entity.User;

public class UserDaoImpl implements UserDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@SuppressWarnings("all")
	@Override
	public User login(User form) {
		String hql="from User where username=? and password=?";
		List<User> list=(List<User>) hibernateTemplate.find(hql, form.getUsername(),form.getPassword());
		if (list!=null&&list.size()!=0) {
			User user=list.get(0);
			return user;
		}
		return  null;
	}
	//��ѯ�����û�
	@Override
	public List<User> findAll() {
		@SuppressWarnings("unchecked")
		List<User> list=(List<User>) hibernateTemplate.find("from User");
		if (list!=null&&list.size()!=0) {
			return list;
		}
		return null;
	}
	//����id��ѯ�û���Ϣ
	@Override
	public User findById(Integer uid) {
		return hibernateTemplate.get(User.class, uid);
	}
	//�޸�����
	@Override
	public void update(User form) {
		hibernateTemplate.update(form);
	}
	//ɾ���û�
	@Override
	public void delete(User user) {
		hibernateTemplate.delete(user);
	}
	
}
