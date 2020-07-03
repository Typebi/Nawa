package userManagement.domain;

import userManagement.exceptions.PwdException;

public class Pwd {
	private String pwd;

	public Pwd(String pwd1) {  // 생성자
		if(pwd1.matches("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,15}$")){
			pwd = pwd1;
		}else {
			throw new PwdException("잘못된 비밀번호 형식입니다.");
		}
	}
	public Pwd(String pwd1, String pwd2) {  // 생성자
		if(pwd1.matches("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,15}$")&&pwd2.matches("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,15}$")){
			pwd = pwd1;
		}else {
			throw new PwdException("잘못된 비밀번호 형식입니다.");
		}
	}
	public String getPwd() {
		return pwd;
	}
}
