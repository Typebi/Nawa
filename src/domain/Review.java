package domain;

import java.util.ArrayList;
import java.util.Date;

public class Review {
	
	int re_seq; 
	int attr_seq;
	String email;
	String re_subject; 
	String re_content;  
	int rate; 
	int recommend;  
	Date rdate;
	String nick;
	ArrayList<Reply> replys;
	
	public ArrayList<Reply> getReplys() {
		return replys;
	}
	public void setReplys(ArrayList<Reply> replys) {
		this.replys = replys;
	}
	public Review(int re_seq, int attr_seq, String email, String re_subject, String re_content, int rate, int recommend,
			Date rdate, String nick, ArrayList<Reply> replys) {
		this.re_seq = re_seq;
		this.attr_seq = attr_seq;
		this.email = email;
		this.re_subject = re_subject;
		this.re_content = re_content;
		this.rate = rate;
		this.recommend = recommend;
		this.rdate = rdate;
		this.nick = nick;
		this.replys=replys;
	}
	public Review(int re_seq, int attr_seq, String email, String re_subject, String re_content, int rate, int recommend,
			Date rdate) {
		this.re_seq = re_seq;
		this.attr_seq = attr_seq;
		this.email = email;
		this.re_subject = re_subject;
		this.re_content = re_content;
		this.rate = rate;
		this.recommend = recommend;
		this.rdate = rdate;
	}
	public Review(int re_seq,String re_subject,int rate, String re_content) {
		this.re_seq = re_seq;
		this.re_subject = re_subject;
		this.re_content = re_content;
		this.rate = rate;
	}
	
	public Review(int re_seq) {
		this.re_seq = re_seq;
	}
	public int getRe_seq() {
		return re_seq;
	}
	public void setRe_seq(int re_seq) {
		this.re_seq = re_seq;
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
	public String getRe_subject() {
		return re_subject;
	}
	public void setRe_subject(String re_subject) {
		this.re_subject = re_subject;
	}
	public String getRe_content() {
		return re_content;
	}
	public void setRe_content(String re_content) {
		this.re_content = re_content;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}   
	
}
