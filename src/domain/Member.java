package domain;

import java.sql.Date;

public class Member {
	
	private String email;
	private String pwd;
	private String nick_name;
	private int grade;
	private Date rdate;
	
	public Member() {

	}

	public Member(String email, String pwd, String nick_name, int grade,Date rdate) {
		super();
		this.email = email;
		this.pwd = pwd;
		this.nick_name = nick_name;
		this.grade = grade;
		this.rdate = rdate;
	}

	public Date getRdate() {
		return rdate;
	}

	public void setRdate(Date rdate) {
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

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
}
