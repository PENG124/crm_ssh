package crm.action;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import crm.action.verfiy.VerfiyCode;
import crm.entity.User;
import crm.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserService userService;
	//ģ��������װ������
	private User form = new User();
	//���Է�װ��ʽ��װ��֤��
	private String verfiyCode;
	public String login() {
		User user = userService.login(form);
		HttpServletRequest request = ServletActionContext.getRequest();
		//��֤��У��
		if(!verfiyCode.equalsIgnoreCase((String)request.getSession().getAttribute("verfiyCode"))) {
			request.setAttribute("error", "��֤�����");
			request.setAttribute("user", form);
			return "login";
		}
		if (user != null) {
			request.getSession().setAttribute("user", user);
			return "loginSuccess";
		} else {
			request.setAttribute("error", "�û��������������");
			request.setAttribute("user", form);
			return "login";
		}
	}
	//��֤��
	public String verfiy() throws IOException {
		VerfiyCode vc = new VerfiyCode();
		BufferedImage image = vc.getImage();
		ServletActionContext.getRequest().getSession().setAttribute("verfiyCode", vc.getText());
		VerfiyCode.output(image, ServletActionContext.getResponse().getOutputStream());
		return NONE;
	}
	//��ת���޸�����
	public String toEdit() {
		return "toEdit";
	}
	//�����޸�
	public String edit() {
		User user=(User) ServletActionContext.getRequest().getSession().getAttribute("user");
		String password=user.getPassword();
		if (form.getPassword().equals(password)) {
			ServletActionContext.getRequest().setAttribute("error", "��������ԭ����һ�£��������޸�");
			return "editPswFail";
		}
		userService.update(form);
		ServletActionContext.getRequest().getSession().setAttribute("user", form);
		return "editPswSuccess";
	}
	//��ѯ����
	public String list() {
		List<User> list=userService.findAll();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "list";
	}
	//ɾ���û�
	public String delete() {
		User user=userService.findById(form.getUid());
		if (user!=null) {
			userService.delete(user);
		}
		return "deleteSuccess";
	}
	//��ʼ���û�
	public String userInitialize() {
		User user=userService.findById(form.getUid());
		if (user!=null) {
			user.setPassword("1234");
			userService.update(user);
		}
		return "initialize";
	}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return form;
	}

	public String getVerfiyCode() {
		return verfiyCode;
	}

	public void setVerfiyCode(String verfiyCode) {
		this.verfiyCode = verfiyCode;
	}
}
