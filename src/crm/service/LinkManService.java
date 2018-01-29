package crm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import crm.dao.LinkManDao;
import crm.entity.LinkMan;
import crm.entity.PageBean;

@Transactional
public class LinkManService {
	@Resource(name="linkManDao")
	private LinkManDao linkManDao;
	
	//�����ϵ��
	public void add(LinkMan form) {
		linkManDao.add(form);
	}
	// ��ҳ��ѯ����
	public PageBean<LinkMan> list(int pc) {
		PageBean<LinkMan> pb = new PageBean<LinkMan>();
		// ��ѯ����װ�ܼ�¼��
		pb.setTr(linkManDao.findCount());
		// ����ÿҳ��¼��
		int ps = 3;
		// ��ѯ����װÿҳ��¼���Լ��ͻ���Ϣ����
		pb.setBeanList(linkManDao.findByPage(pc, ps));
		pb.setPs(ps);
		return pb;
	}
	// ����id��ѯ��ϵ��
	public LinkMan findById(Integer lkm_id) {
		// TODO Auto-generated method stub
		return linkManDao.findById(lkm_id);
	}		
	// �����޸ģ����¿ͻ���Ϣ
	public void update(LinkMan form) {
		linkManDao.update(form);
	}	
	// ɾ���ͻ�
	public void delete(LinkMan linkMan) {
		linkManDao.delete(linkMan);
	}	
	// �����������У���ҳ��ѯ
	public PageBean<LinkMan> listCriteria(LinkMan linkMan, int pc) {
		PageBean<LinkMan> pb = new PageBean<LinkMan>();
		// ��ѯ����װ�ܼ�¼��
		pb.setTr(linkManDao.findCountByCriteria(linkMan));
		// ����ÿҳ��¼��
		int ps = 10;
		// ��ѯ����װÿҳ��¼���Լ���ϵ����Ϣ����
		pb.setBeanList(linkManDao.findByPageAndCriteria(linkMan, pc, ps));
		pb.setPs(ps);
		return pb;
	}
	public List<LinkMan> findByMoreCondition(LinkMan form) {
		// TODO Auto-generated method stub
		return linkManDao.findByMoreCondition(form);
	}	
}
