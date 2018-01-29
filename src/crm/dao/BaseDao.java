package crm.dao;

import java.util.List;
/**
 * ��dao�ӿڼ̳иýӿڣ�ʵ�־���ķ��Ͳ���
 * @author user
 *
 * @param <T>
 */
public interface BaseDao<T> {
	//���
	void add(T t);
	//�޸�
	void update(T t);
	//ɾ��
	void delete(T t);
	//����id��ѯ
	T get(Integer id);
	//��ѯ����
	List<T> findAll();
}
