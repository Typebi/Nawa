package userManagement.domain;

import userManagement.exceptions.NickException;

public class Nick {
	private String nick;

	public Nick(String value) {  // »ý¼ºÀÚ
		if (value.matches("^[°¡-ÆRa-zA-Z0-9]{2,8}$")){
			nick = value;
		}else {
			throw new NickException("Àß¸øµÈ ´Ð³×ÀÓ Çü½ÄÀÔ´Ï´Ù.");
		}
	}
	public String getNick() {
		return nick;
	}
}
