package crm.entity;

public class LinkMan {
	private Integer lkm_id;// 联系人id
	private String lkm_name;// 联系人姓名
	private String lkm_gender;// 联系人性别
	private String lkm_phone;// 联系人办公电话
	private String lkm_mobile;// 联系人手机
	private Customer customer;//属于一个客户
	public Integer getLkm_id() {
		return lkm_id;
	}

	public void setLkm_id(Integer lkm_id) {
		this.lkm_id = lkm_id;
	}

	public String getLkm_name() {
		return lkm_name;
	}

	public void setLkm_name(String lkm_name) {
		this.lkm_name = lkm_name;
	}

	public String getLkm_gender() {
		return lkm_gender;
	}

	public void setLkm_gender(String lkm_gender) {
		this.lkm_gender = lkm_gender;
	}

	public String getLkm_phone() {
		return lkm_phone;
	}

	public void setLkm_phone(String lkm_phone) {
		this.lkm_phone = lkm_phone;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getLkm_mobile() {
		return lkm_mobile;
	}

	public void setLkm_mobile(String lkm_mobile) {
		this.lkm_mobile = lkm_mobile;
	}
}
