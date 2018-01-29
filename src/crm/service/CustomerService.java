package crm.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import crm.dao.CustomerDao;
import crm.entity.Customer;
import crm.entity.DictCustLevel;
import crm.entity.DictCustSource;
import crm.entity.PageBean;

@Transactional
public class CustomerService {
	@Resource(name = "customerDao")
	private CustomerDao customerDao;

	// ��ӿͻ�
	public void add(Customer form) {
		customerDao.add(form);
	}

	// ��ҳ��ѯ����
	public PageBean<Customer> list(int pc) {
		PageBean<Customer> pb = new PageBean<Customer>();
		// ��ѯ����װ�ܼ�¼��
		pb.setTr(customerDao.findCount());
		// ����ÿҳ��¼��
		int ps = 3;
		// ��ѯ����װÿҳ��¼���Լ��ͻ���Ϣ����
		pb.setBeanList(customerDao.findByPage(pc, ps));
		pb.setPs(ps);
		return pb;
	}

	// ����id��ѯ�ͻ�
	public Customer findById(Integer cid) {
		// TODO Auto-generated method stub
		return customerDao.get(cid);
	}

	// ɾ���ͻ�
	public void delete(Customer customer) {
		customerDao.delete(customer);
	}

	// �����޸ģ����¿ͻ���Ϣ
	public void update(Customer form) {
		customerDao.update(form);
	}

	// �����������У���ҳ��ѯ
	public PageBean<Customer> listCriteria(Customer customer, int pc) {
		PageBean<Customer> pb = new PageBean<Customer>();
		// ��ѯ����װ�ܼ�¼��
		pb.setTr(customerDao.findCountByCriteria(customer));
		// ����ÿҳ��¼��
		int ps = 10;
		// ��ѯ����װÿҳ��¼���Լ��ͻ���Ϣ����
		pb.setBeanList(customerDao.findByPageAndCriteria(customer, pc, ps));
		pb.setPs(ps);
		return pb;
	}
	//��ѯ�����û�
	public List<Customer> findAll() {
		return customerDao.findAll();
	}
	//�ۺ�������ѯ
	public List<Customer> findByMoreCondition(Customer form) {
		return customerDao.findByMoreCondition(form);
	}
	//���ҿͻ����������ֵ�
	public List<DictCustLevel> findAllLevel() {
		// TODO Auto-generated method stub
		return customerDao.findAllLevel();
	}
	//���ҿͻ���Դ�����ֵ�
	public List<DictCustSource> findAllSource() {
		// TODO Auto-generated method stub
		return customerDao.findAllSource();
	}
	//���ݿͻ�����ͳ��
	public List<Map<String, Object>> countLevel() {
		// TODO Auto-generated method stub
		return customerDao.countLevel();
	}
	//���ݿͻ���Դͳ��
	public List<Map<String, Object>> countSource() {
		// TODO Auto-generated method stub
		return customerDao.countSource();
	}


}
