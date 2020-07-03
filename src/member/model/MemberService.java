package member.model;

import java.util.ArrayList;
import domain.Member;

public class MemberService {
	private MemberDAO dao;
	private static final MemberService instance=new MemberService();
	
	private MemberService() {
		dao=new MemberDAO();
	}
	public static MemberService getInstance() {
		return instance;
	}

	public Member mypageS(String email ){
		return dao.mypage(email);
	}
	public void updateS(Member member) {
		dao.update(member);
		
	}
	public void deleteS(String email) {
		dao.delete(email);
		
	}
}
