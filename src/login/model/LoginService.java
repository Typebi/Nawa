package login.model;

import org.mindrot.jbcrypt.BCrypt;

import userManagement.domain.*;
import userManagement.exceptions.*;
import userManagement.interfaces.*;

public class LoginService{
	private DB DB;
	   
	private LoginService() {
		DB = new DbLogin();
	}
	
	public static LoginService getInstance() {
	   return LazyHolder.instance;
	}
	private static class LazyHolder{
	   private static final LoginService instance = new LoginService();
	}
	

	
	public Member isMember(Email email, Pwd pwd) {
		String address = email.getAddress();
		Member m = DB.excuteQuery(address);
		if(m!=null) {
			try {
				BCrypt.checkpw(pwd.getPwd(), m.getPwd());
				return m;
			}catch(IllegalArgumentException e) {
				throw new EmailException("비밀번호가 일치하지 않습니다.");
			}
		}else throw new EmailException("존재하지 않는 이메일(아이디)입니다.");
	}
}