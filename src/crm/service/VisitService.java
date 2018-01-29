package crm.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import crm.dao.VisitDao;
import crm.entity.Customer;
import crm.entity.PageBean;
import crm.entity.Visit;

@Transactional
public class VisitService {
	@Resource(name="visitDao")
	private VisitDao visitDao;
	// ��Ӱݷü�¼
	public void add(Visit form) {
		visitDao.add(form);
	}	
	// ��ҳ��ѯ����
	public PageBean<Visit> list(int pc) {
		PageBean<Visit> pb = new PageBean<Visit>();
		// ��ѯ����װ�ܼ�¼��
		pb.setTr(visitDao.findCount());
		// ����ÿҳ��¼��
		int ps = 10;
		// ��ѯ����װÿҳ��¼���Լ��ͻ���Ϣ����
		pb.setBeanList(visitDao.findByPage(pc, ps));
		pb.setPs(ps);
		return pb;
	}
	//�ۺϲ�ѯ
	public List<Visit> findByMoreCondition(Visit form, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return visitDao.findByMoreCondition(form,startDate,endDate);
	}	
}
