package userManagement.domain;

import java.sql.Date;

public class Member {
	private String email;
	private String pwd;
	private String name;
	private Date rdate;
	public Member(String email, String pwd, String name, Date rdate) {
		this.email = email;
		this.pwd = pwd;
		this.name = name;
		this.rdate = rdate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	
}
