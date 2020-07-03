package login.model;

public class SqlPack {
	final static String checkMember(String email){
		return "select * from MEMBER where EMAIL=?";
	}
}
