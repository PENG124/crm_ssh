package crm.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import crm.entity.Customer;
import crm.entity.PageBean;
import crm.entity.User;
import crm.entity.Visit;
import crm.service.CustomerService;
import crm.service.UserService;
import crm.service.VisitService;

@SuppressWarnings("serial")
public class VisitAction extends ActionSupport implements ModelDriven<Visit> {
	@Autowired
	private VisitService visitService;
	@Autowired
	private UserService userService;
	@Autowired
	private CustomerService customerService;
	//ͨ��ģ����������װ������ 
	private Visit form=new Visit();
	//ͨ�����Է�װ����װ����
	//��ǰҳ��
	int pc;
	//��ʼ����
	Date startDate;
	//��������
	Date endDate;
	@Override
	public Visit getModel() {
		// TODO Auto-generated method stub
		return form;
	}
	
	//��ת�����ҳ��
	public String  toAdd() {
		//��ѯ�����û�
		List<User> listUser=userService.findAll();
		//��ѯ���пͻ�
		List<Customer> listCustomer=customerService.findAll();
		//���浽request��
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("listCustomer", listCustomer);
		request.setAttribute("listUser", listUser);
		return "toAdd";
	}
	//��Ӱݷü�¼
	public String add() {
		//�����û�id���ҵ��û���Ϣ
		User user=userService.findById(form.getUser().getUid());
		//���ݿͻ�id���ҵ��ͻ���Ϣ
		Customer customer=customerService.findById(form.getCustomer().getCid());
		//���û���ͻ���Ϣ�浽�ݷü�¼��
		form.setUser(user);
		form.setCustomer(customer);
		//����ݷü�¼
		visitService.add(form);
		return "addSuccess"; 
	}
	//�ͻ��ݷ��б���������
	public String list() {
		HttpServletRequest request=ServletActionContext.getRequest();
		//������Ŀ·��+����·��
		String url=request.getRequestURI()+"?";
		//���ûָ����ǰҳ�棬Ĭ��Ϊ��һҳ
		if (pc==0) {
			pc=1;
		}
		//����ҳ��
		PageBean<Visit> pb=visitService.list(pc);
		pb.setUrl(url);
		pb.setPc(pc);
		request.setAttribute("pb", pb);
		return "list";
	}
	//��ת��������ѯҳ��
	public String toSelect() {
		//��ѯ�����û�
		List<User> listUser=userService.findAll();
		//��ѯ���пͻ�
		List<Customer> listCustomer=customerService.findAll();
		//���浽request��
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("listCustomer", listCustomer);
		request.setAttribute("listUser", listUser);		
		return "toSelect";
	}
	//������ѯ 
	public String select() {
		HttpServletRequest request=ServletActionContext.getRequest();
		//����ҳ��
		List<Visit> list=visitService.findByMoreCondition(form,startDate,endDate);
		request.setAttribute("list", list);
		return "selectList";
	}
	public int getPc() {
		return pc;
	}

	public void setPc(int pc) {
		this.pc = pc;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}	
	
}
