package domain;

public class Attr {
	private int attr_seq;
	private String email;
	private String attr_name;
	private String attr_addr;
	private String attr_info;
	private int avg_rec;
	private int area_no;
	private String area_name;
	
	public Attr() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Attr(int attr_seq, String email, String attr_name, String attr_addr, String attr_info, int avg_rec,
			int area_no, String area_name) {
		super();
		this.attr_seq = attr_seq;
		this.email = email;
		this.attr_name = attr_name;
		this.attr_addr = attr_addr;
		this.attr_info = attr_info;
		this.avg_rec = avg_rec;
		this.area_no = area_no;
		this.area_name = area_name;
	}
	public Attr(int attr_seq, String email, String attr_name, String attr_addr, String attr_info, int avg_rec,
			int area_no) {
		this.attr_seq = attr_seq;
		this.email = email;
		this.attr_name = attr_name;
		this.attr_addr = attr_addr;
		this.attr_info = attr_info;
		this.avg_rec = avg_rec;
		this.area_no = area_no;
	}
	public int getAttr_seq() {
		return attr_seq;
	}

	public void setAttr_seq(int attr_seq) {
		this.attr_seq = attr_seq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAttr_name() {
		return attr_name;
	}

	public void setAttr_name(String attr_name) {
		this.attr_name = attr_name;
	}

	public String getAttr_addr() {
		return attr_addr;
	}

	public void setAttr_addr(String attr_addr) {
		this.attr_addr = attr_addr;
	}

	public String getAttr_info() {
		return attr_info;
	}

	public void setAttr_info(String attr_info) {
		this.attr_info = attr_info;
	}

	public int getAvg_rec() {
		return avg_rec;
	}

	public void setAvg_rec(int avg_rec) {
		this.avg_rec = avg_rec;
	}

	public int getArea_no() {
		return area_no;
	}

	public void setArea_no(int area_no) {
		this.area_no = area_no;
	}

	public String getArea_name() {
		return area_name;
	}

	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	
	

	
}
