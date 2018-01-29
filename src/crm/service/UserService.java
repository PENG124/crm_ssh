package crm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import crm.dao.UserDao;
import crm.entity.User;
@Transactional
public class UserService {
	@Resource(name="userDao")
	private UserDao userDao;

	public User login(User form) {
		return userDao.login(form);
	}
	//��ѯ�����û�
	public List<User> findAll() {
		return userDao.findAll();
	}
	//����id��ѯ�û�
	public User findById(Integer uid) {
		// TODO Auto-generated method stub
		return userDao.findById(uid);
	}
	//�޸�����
	public void update(User form) {
		userDao.update(form);
	}
	//ɾ���û�
	public void delete(User user) {
		userDao.delete(user);
	}

}
