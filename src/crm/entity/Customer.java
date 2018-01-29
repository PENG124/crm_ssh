package crm.entity;

import java.util.HashSet;
import java.util.Set;

import crm.entity.LinkMan;

public class Customer {

	private Integer cid;// �ͻ�id
	private String custName;// �ͻ�����
	private DictCustLevel dictCustLevel;// �ͻ�����
	private DictCustSource dictCustSource; // �ͻ���Դ
	private String custPhone; // �ͻ��绰
	private String custMobile;// �ͻ��ֻ�
	//�����ϵ��
	private Set<LinkMan> linkMans=new HashSet<LinkMan>();
	//�����ݷü�¼
	private Set<Visit> visits=new HashSet<Visit>();
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	public String getCustMobile() {
		return custMobile;
	}
	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}
	public Set<LinkMan> getLinkMans() {
		return linkMans;
	}
	public void setLinkMans(Set<LinkMan> linkMans) {
		this.linkMans = linkMans;
	}
	public Set<Visit> getVisits() {
		return visits;
	}
	public void setVisits(Set<Visit> visits) {
		this.visits = visits;
	}
	public DictCustLevel getDictCustLevel() {
		return dictCustLevel;
	}
	public void setDictCustLevel(DictCustLevel dictCustLevel) {
		this.dictCustLevel = dictCustLevel;
	}
	public DictCustSource getDictCustSource() {
		return dictCustSource;
	}
	public void setDictCustSource(DictCustSource dictCustSource) {
		this.dictCustSource = dictCustSource;
	}
}
