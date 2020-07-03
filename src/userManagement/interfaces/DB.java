package userManagement.interfaces;

import userManagement.domain.Member;

public interface DB {
	Member excuteQuery(String email);
	int excuteUpdate(String key, String email, String pwd, String nick);
}
