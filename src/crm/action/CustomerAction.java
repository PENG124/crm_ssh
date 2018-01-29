package crm.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import crm.entity.Customer;
import crm.entity.DictCustLevel;
import crm.entity.DictCustSource;
import crm.entity.PageBean;
import crm.service.CustomerService;

@SuppressWarnings("serial")
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	@Autowired
	private CustomerService customerService;
	//ģ����������װ������
	private Customer form=new Customer();
	//���Է�װ����װ��ǰҳ��
	int pc;
	@Override
	public Customer getModel() {
		return form;
	}
	//��ת���ͻ����ҳ��
	public String toAdd() {
		List<DictCustLevel> listLevel=customerService.findAllLevel();
		List<DictCustSource> listSource=customerService.findAllSource();
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("listLevel", listLevel);
		request.setAttribute("listSource", listSource);
 		return "toAdd";
	}
	//��ӿͻ�
	public String  add() {
		customerService.add(form);
		return "addSuccess";
	}
	//�ͻ��б���������
	public String list() {
		HttpServletRequest request=ServletActionContext.getRequest();
		//������Ŀ·��+����·��
		String url=request.getRequestURI()+"?";
		//���ûָ����ǰҳ�棬Ĭ��Ϊ��һҳ
		if (pc==0) {
			pc=1;
		}
		//����ҳ��
		PageBean<Customer> pb=customerService.list(pc);
		pb.setUrl(url);
		pb.setPc(pc);
		request.setAttribute("pb", pb);
		return "list";
	}
	//���ݿͻ�idɾ��
	public String delete() {
		//�ȸ���ģ��������ÿͻ�id����ѯ���ͻ���Ϣ
		Customer customer=customerService.findById(form.getCid());
		//�����ѯ�����Ϊ�գ�ִ��ɾ��
		if (customer!=null) {
			customerService.delete(customer);
		}
		return "deleteSuccess";
	}
	//��ת���޸�ҳ�棬����Ҫ�޸ĵĿͻ���Ϣ��ҳ����
	public String  toEdit() {
		Customer customer=customerService.findById(form.getCid());
		List<DictCustLevel> listLevel=customerService.findAllLevel();
		List<DictCustSource> listSource=customerService.findAllSource();
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("customer", customer);
		request.setAttribute("listLevel", listLevel);
		request.setAttribute("listSource", listSource);
		return "toEdit";
	}
	//�����޸�
	public String edit() {
		customerService.update(form);
		return "editSuccess";
	}
	//����������ѯ
	public String listCriteria() {
		if (form.getCustName()!=null&&!"".equalsIgnoreCase(form.getCustName().trim())) {
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
			PageBean<Customer> pb=customerService.listCriteria(form,pc);
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
		List<DictCustLevel> listLevel=customerService.findAllLevel();
		List<DictCustSource> listSource=customerService.findAllSource();
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("listLevel", listLevel);
		request.setAttribute("listSource", listSource);
		return "toSelect";
	}
	//������ѯ 
	public String select() {
		HttpServletRequest request=ServletActionContext.getRequest();
		//����ҳ��
		List<Customer> list=customerService.findByMoreCondition(form);
		request.setAttribute("list", list);
		return "selectList";
	}
	//���ݿͻ���Դͳ��
	public String countLevel() {
		List<Map<String, Object>> list=customerService.countLevel();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "countLevel";
	}
	//���ݿͻ�����ͳ��
	public String countSource() {
		List<Map<String, Object>> list=customerService.countSource();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "countSource";
	}
	public int getPc() {
		return pc;
	}
	public void setPc(int pc) {
		this.pc = pc;
	}
}
