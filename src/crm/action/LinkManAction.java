package crm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import crm.entity.Customer;
import crm.entity.LinkMan;
import crm.entity.PageBean;
import crm.service.CustomerService;
import crm.service.LinkManService;

@SuppressWarnings("serial")
public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {
	@Autowired
	private LinkManService linkManService;
	@Autowired
	private CustomerService customerService;
	// ģ����������װlinkMan����
	private LinkMan form = new LinkMan();
// ͨ�����Է�װ����ȡ����
	//��ȡ��ǰҳ��
	private int pc;

	@Override
	public LinkMan getModel() {
		// TODO Auto-generated method stub
		return form;
	}

	// ��ת�����ҳ��
	public String toAdd() {
		// ͨ��customerService��ÿͻ���Ϣ�ļ��ϣ����浽�������
		List<Customer> listCustomer = customerService.findAll();
		ServletActionContext.getRequest().setAttribute("listCustomer", listCustomer);
		// ͨ��ת�������ͻ���Ϣ��ʾ�����ҳ����
		return "toAdd";
	}

	// �����ϵ��
	public String add() {
		// ͨ�������ͻ�id��ѯ�ͻ���Ϣ
		Customer customer = customerService.findById(form.getCustomer().getCid());
		// ���ͻ���Ϣ���õ���ϵ����
		form.setCustomer(customer);
		// ������ϵ����Ϣ
		linkManService.add(form);
		return "addSuccess";
	}
	//��ϵ���б���������
	public String list() {
		HttpServletRequest request=ServletActionContext.getRequest();
		//������Ŀ·��+����·��
		String url=request.getRequestURI()+"?";
		//���ûָ����ǰҳ�棬Ĭ��Ϊ��һҳ
		if (pc==0) {
			pc=1;
		}
		//����ҳ��
		PageBean<LinkMan> pb=linkManService.list(pc);
		pb.setUrl(url);
		pb.setPc(pc);
		request.setAttribute("pb", pb);
		return "list";
	}	
	//��ת���޸�ҳ�棬����Ҫ�޸ĵ���ϵ����Ϣ��ҳ����
	public String  toEdit() {
		HttpServletRequest request=ServletActionContext.getRequest();
		//�õ����еĿͻ���Ϣ�������ص��޸�ҳ��
		List<Customer> listCustomer = customerService.findAll();
		request.setAttribute("listCustomer", listCustomer);
		LinkMan linkMan=linkManService.findById(form.getLkm_id());
		request.setAttribute("linkman", linkMan);
		return "toEdit";
	}	
	
	//�����޸�
	public String edit() {
		// ���������ͻ���id��ѯ���ͻ���Ϣ
		Customer customer = customerService.findById(form.getCustomer().getCid());
		//����ͻ���Ϣ����ϵ��
		form.setCustomer(customer);
		//���²���
		linkManService.update(form);
		return "editSuccess";
	}	
	
	//ɾ����ϵ��
	public String delete() {
		//�ȸ���id��ѯ����ϵ��
		LinkMan linkMan=linkManService.findById(form.getLkm_id());
		//��ѯ�����Ϊ�գ���ִ��ɾ��
		if (linkMan!=null) {
			linkManService.delete(linkMan);
		}
		return "deleteSuccess";
	}	
	//����������ѯ
	public String listCriteria() {
		//�����ѯ������Ϊ�գ�ִ��������ѯ������ֱ�ӷ��ص��б�ҳ��
		if (form.getLkm_name()!=null&&!"".equalsIgnoreCase(form.getLkm_name().trim())) {
			HttpServletRequest request=ServletActionContext.getRequest();
			//������Ŀ·��+����·��
			String queryString=request.getQueryString();
			//���·���д���ҳ�룬��ҳ�벿��ȥ��
			if (queryString.contains("pc")) {
				queryString=queryString.substring(0,request.getQueryString().indexOf("&pc"));
			}
			String url=request.getRequestURI()+"?"+queryString+"&";
			//���ûָ����ǰҳ�棬Ĭ��Ϊ��һҳ
			if (pc==0) {
				pc=1;
			}
			//����ҳ��
			PageBean<LinkMan> pb=linkManService.listCriteria(form,pc);
			pb.setUrl(url);
			pb.setPc(pc);
			request.setAttribute("pb", pb);
		}else {
			list();
		}
		return "listCriteria";
	}	
	
	//��ת��������ѯҳ��
	public String toSelect() {
		// ͨ��customerService��ÿͻ���Ϣ�ļ��ϣ����浽�������
		List<Customer> listCustomer = customerService.findAll();
		ServletActionContext.getRequest().setAttribute("listCustomer", listCustomer);		
		return "toSelect";
	}
	//������ѯ 
	public String select() {
		HttpServletRequest request=ServletActionContext.getRequest();
		//����ҳ��
		List<LinkMan> list=linkManService.findByMoreCondition(form);
		request.setAttribute("list", list);
		return "selectList";
	}	
	public int getPc() {
		return pc;
	}

	public void setPc(int pc) {
		this.pc = pc;
	}
		
}
