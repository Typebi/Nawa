package userManagement.domain;

import userManagement.exceptions.EmailException;

public class Email {
	private String address;

	public Email(String value) {  // ������
		if (value.matches("^[a-zA-Z0-9]++@+[a-zA-Z0-9]++.+[a-zA-Z]+$")){
			address = value;
		}else {
			throw new EmailException("�߸��� �̸��� �����Դϴ�.");
		}
	}
	public String getAddress() {
		return address;
	}
}
