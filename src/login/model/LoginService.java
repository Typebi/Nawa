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
				throw new EmailException("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			}
		}else throw new EmailException("�������� �ʴ� �̸���(���̵�)�Դϴ�.");
	}
}