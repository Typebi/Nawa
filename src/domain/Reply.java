package domain;

import java.sql.Date;

public class Reply {
	int COMM_SEQ;
	String COMM_CONTENT;
	Date RDATE;
	int RE_SEQ;
	String EMAIL;
	String NICK;
	public Reply(int cOMM_SEQ, String cOMM_CONTENT, Date rDATE, int rE_SEQ, String nICK) {
		super();
		this.COMM_SEQ = cOMM_SEQ;
		this.COMM_CONTENT = cOMM_CONTENT;
		this.RDATE = rDATE;
		this.RE_SEQ = rE_SEQ;
		this.NICK = nICK;
	}
	public Reply(int cOMM_SEQ, String cOMM_CONTENT, Date rDATE, int rE_SEQ,String email, String nICK) {
		super();
		this.COMM_SEQ = cOMM_SEQ;
		this.COMM_CONTENT = cOMM_CONTENT;
		this.RDATE = rDATE;
		this.RE_SEQ = rE_SEQ;
		this.EMAIL=email;
		this.NICK = nICK;
	}
	public int getCOMM_SEQ() {
		return COMM_SEQ;
	}
	public void setCOMM_SEQ(int cOMM_SEQ) {
		this.COMM_SEQ = cOMM_SEQ;
	}
	public String getCOMM_CONTENT() {
		return COMM_CONTENT;
	}
	public void setCOMM_CONTENT(String cOMM_CONTENT) {
		this.COMM_CONTENT = cOMM_CONTENT;
	}
	public Date getRDATE() {
		return RDATE;
	}
	public void setRDATE(Date rDATE) {
		this.RDATE = rDATE;
	}
	public int getRE_SEQ() {
		return RE_SEQ;
	}
	public void setRE_SEQ(int rE_SEQ) {
		this.RE_SEQ = rE_SEQ;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		this.EMAIL = eMAIL;
	}
	public String getNICK() {
		return NICK;
	}
	public void setNICK(String nICK) {
		this.NICK = nICK;
	}
}
