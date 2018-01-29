package crm.entity;

import java.util.List;

public class PageBean<T> {
	private int pc;// ��ǰҳ��,servlet����
//	private int tp;// ��ҳ��
	private int tr;// �ܼ�¼����dao��ѯ��service��װ
	private int ps;// ÿҳ��¼����service����
	private List<T> beanList;// ҳ�����ݣ�dao����ʹ��limt�Ӿ�,service��װ
	private String url;//����url���������Servlet����---/��Ŀ��/Servlet·��?�����ַ���
	
	public int getPc() {
		return pc;
	}

	public void setPc(int pc) {
		this.pc = pc;
	}

	public int getTp() {
		int tp = tr / ps;
		tp= (tr%ps == 0 ? tp : tp + 1);
		return tp;
	}

	public int getTr() {
		return tr;
	}

	public void setTr(int tr) {
		this.tr = tr;
	}

	public int getPs() {
		return ps;
	}

	public void setPs(int ps) {
		this.ps = ps;
	}

	public List<T> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
