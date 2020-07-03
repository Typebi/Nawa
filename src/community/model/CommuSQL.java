package community.model;

public class CommuSQL {
	final static String LIST = "select C.*, M.NICK_NAME from COMMUNITY C, MEMBER M where C.EMAIL = M.EMAIL order by C_SEQ desc";
	final static String LIST_PAGE = "select * from (select ROWNUM rnum, aa.* from "
			+ "(select C.*, M.NICK_NAME from COMMUNITY C, MEMBER M where C.EMAIL = M.EMAIL order by C_SEQ desc) aa) where rnum>? and rnum<=?";
	
	final static String CONTENT = "select C.*, M.NICK_NAME from COMMUNITY C, MEMBER M where C.EMAIL = M.EMAIL and C_SEQ=?";
	final static String INSERT = "insert into COMMUNITY values(C_SEQ.nextval, ?, ?, ?, SYSDATE, 0, ?, ?)";
	final static String UPDATE = "update COMMUNITY set SUBJECT=?, CONTENT=?, FNAME=?, OFNAME=? where C_SEQ=?";
	final static String DEL = "delete from COMMUNITY where C_SEQ=?";
	final static String COUNT = "select count(C_SEQ) from COMMUNITY";
	final static String SEARCH_COUNT = "select count(C_SEQ) from COMMUNITY where SUBJECT like ? order by C_SEQ desc";
	final static String SELECT = "select * from (select ROWNUM rnum, aa.* from "
			+ "(select C.*, M.NICK_NAME from COMMUNITY C, MEMBER M where C.EMAIL = M.EMAIL and C.SUBJECT like ? order by C_SEQ desc) aa) where rnum>? and rnum<=?";
	final static String HITS = "update community set HITS=HITS+1 where C_SEQ=?";
}
