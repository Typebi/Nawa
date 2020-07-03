package userManagement.domain;

import userManagement.exceptions.PwdException;

public class Pwd {
	private String pwd;

	public Pwd(String pwd1) {  // ������
		if(pwd1.matches("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,15}$")){
			pwd = pwd1;
		}else {
			throw new PwdException("�߸��� ��й�ȣ �����Դϴ�.");
		}
	}
	public Pwd(String pwd1, String pwd2) {  // ������
		if(pwd1.matches("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,15}$")&&pwd2.matches("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,15}$")){
			pwd = pwd1;
		}else {
			throw new PwdException("�߸��� ��й�ȣ �����Դϴ�.");
		}
	}
	public String getPwd() {
		return pwd;
	}
}
