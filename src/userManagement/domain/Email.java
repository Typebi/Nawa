package userManagement.domain;

import userManagement.exceptions.EmailException;

public class Email {
	private String address;

	public Email(String value) {  // 생성자
		if (value.matches("^[a-zA-Z0-9]++@+[a-zA-Z0-9]++.+[a-zA-Z]+$")){
			address = value;
		}else {
			throw new EmailException("잘못된 이메일 형식입니다.");
		}
	}
	public String getAddress() {
		return address;
	}
}
