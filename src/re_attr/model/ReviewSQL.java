package re_attr.model;

class ReviewSQL {
	static final String LIST = "select * from review order by re_seq desc";
	static final String LIST_PAGE=
		    "select bb.*,m.nick_name from (select ROWNUM rnum , aa.* from (select * from review order by re_seq desc) aa) bb, MEMBER m where rnum>? and rnum<=? and m.email=bb.email and attr_seq = ?";
	static final String COUNT = "select count(re_seq) from review";
	static final String INSERT = "insert into review values(RE_SEQ.nextval,?,?,?,?,?,0,SYSDATE)";
	static final String DEL = "delete from review where re_seq=?";
	static final String RECOMMEND ="update review set recommend=recommend+1 where re_seq=?";
	static final String INSERT_C = "insert into USER_COMMENT values(COMM_SEQ.nextval,?,SYSDATE,?,?)";
	static final String CONTENT = "select * from review where re_seq = ?";
	static final String UPDATE = "update review set review_subject =?, rate=?, review_content=? where re_seq=?";
	static final String DELC = "delete from user_comment where re_seq=? and comm_seq=?";
}

