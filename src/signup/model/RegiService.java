package signup.model;

import org.mindrot.jbcrypt.BCrypt;

import userManagement.domain.*;
import userManagement.interfaces.*;

public class RegiService implements Service{
	private DB DB;
	   
	private RegiService() {
		DB = new DbSignUp();
	}
	public static RegiService getInstance() {
	   return LazyHolder.instance;
	}
	private static class LazyHolder{
	   private static final RegiService instance = new RegiService();
	}
	public boolean isMember(Email e) {
		String email = e.getAddress();
		Member m = DB.excuteQuery(email);
		if(m!=null)
			if(m.getEmail().equals(email))
				return true;
		return false;
	}
	public int insertMember(Email email, Pwd pwd, Nick nick) {
		return DB.excuteUpdate("signup", email.getAddress(), BCrypt.hashpw(pwd.getPwd(), BCrypt.gensalt()), nick.getNick());
	}
	public Member getMember(Email email) {
		return DB.excuteQuery(email.getAddress());
	}
}
