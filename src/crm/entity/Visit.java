package crm.entity;

import java.util.Date;

public class Visit {
	private Integer vid;//�ݷü�¼id
	private Date visitDate;//�ݷ�ʱ��
	private String visitAddress;//�ݷõ�ַ
	private	String visitContent;//�ݷ�����
	private User user;//����λ�û��ݷ�
	private Customer customer;//�ݷ���λ�ͻ�
	public Integer getVid() {
		return vid;
	}
	public void setVid(Integer vid) {
		this.vid = vid;
	}
	public String getVisitAddress() {
		return visitAddress;
	}
	public void setVisitAddress(String visitAddress) {
		this.visitAddress = visitAddress;
	}
	public String getVisitContent() {
		return visitContent;
	}
	public void setVisitContent(String visitContent) {
		this.visitContent = visitContent;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Date getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	
	
}
