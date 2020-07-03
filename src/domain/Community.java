package domain;

import java.sql.Date;

public class Community {
	private int c_seq;
	private String subject;
	private String content;
	private String email;
	private Date rdate;
	private Long hits;
	private String fname;
	private String ofname;
	private String nick_name;
	
	public Community() {
	}
	
	public Community(int c_seq, String subject, String content, String email, Date rdate, Long hits, String fname,
			String ofname, String nick_name) {
		this.c_seq = c_seq;
		this.subject = subject;
		this.content = content;
		this.email = email;
		this.rdate = rdate;
		this.hits = hits;
		this.fname = fname;
		this.ofname = ofname;
		this.nick_name = nick_name;
	}
	public Community(int c_seq, String subject, String content, String email, Date rdate, Long hits, String fname,
			String ofname) {
		this.c_seq = c_seq;
		this.subject = subject;
		this.content = content;
		this.email = email;
		this.rdate = rdate;
		this.hits = hits;
		this.fname = fname;
		this.ofname = ofname;
	}
	public Community(int c_seq, String subject, String content, String email, Date rdate, Long hits, String nick_name) {
		super();
		this.c_seq = c_seq;
		this.subject = subject;
		this.nick_name = nick_name;
		this.content = content;
		this.email = email;
		this.rdate = rdate;
		this.hits = hits;
	}

	public Community(int c_seq, String subject, String content, String email, Date rdate, Long hits) {
		this.c_seq = c_seq;
		this.subject = subject;
		this.content = content;
		this.email = email;
		this.rdate = rdate;
		this.hits = hits;
	}
	public Community(int c_seq, String subject, String content, Date rdate, Long hits, String nick_name) {
		this.c_seq = c_seq;
		this.subject = subject;
		this.content = content;
		this.nick_name = nick_name;
		this.rdate = rdate;
		this.hits = hits;
	}

	public int getC_seq() {
		return c_seq;
	}

	public void setC_seq(int c_seq) {
		this.c_seq = c_seq;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRdate() {
		return rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}

	public Long getHits() {
		return hits;
	}

	public void setHits(Long hits) {
		this.hits = hits;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getOfname() {
		return ofname;
	}

	public void setOfname(String ofname) {
		this.ofname = ofname;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	
}
