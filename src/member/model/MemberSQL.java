package member.model;

class MemberSQL {
	//select email, pwd,nick_name from Member;
	//final static String SELECT="select ?, ?,? from Member";
	//final static String SELECT="select * from Member where email='hdg@hanmail.net'";//¿¬½À¿ë
	
	final static String SELECT="select * from Member where email=?";
	final static String UPDATE="update MEMBER set PWD=?, NICK_NAME=? where EMAIL=?";
	final static String DELETE="delete from MEMBER where EMAIL=?";
}
