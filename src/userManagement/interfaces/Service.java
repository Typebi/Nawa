package userManagement.interfaces;

import userManagement.domain.Email;
import userManagement.domain.Member;
import userManagement.domain.Nick;
import userManagement.domain.Pwd;

public interface Service {
	public boolean isMember(Email e);
	public int insertMember(Email email, Pwd pwd, Nick nick);
	public Member getMember(Email email);
}
