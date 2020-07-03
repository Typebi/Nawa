package userManagement.domain;

import userManagement.exceptions.NickException;

public class Nick {
	private String nick;

	public Nick(String value) {  // ������
		if (value.matches("^[��-�Ra-zA-Z0-9]{2,8}$")){
			nick = value;
		}else {
			throw new NickException("�߸��� �г��� �����Դϴ�.");
		}
	}
	public String getNick() {
		return nick;
	}
}
