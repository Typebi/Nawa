package attr.model;

class AttrSQL {
	static final String LIST="select * from attr order by attr_seq desc";
	static final String LIST1="select * from attr where area_no = ? order by attr_seq desc";
	static final String INSERT = "insert into attr values(ATTR_SEQ.nextval,?,?,?,?,0,?)";
	static final String DEL = "delete from attr where attr_seq=?";
	final static String LIST_PAGE=
		    "select * from (select ROWNUM rnum , aa.* from (select * from ATTR order by ATTR_SEQ desc) aa) where rnum>? and rnum<=?";
	static final String COUNT = "select count(ATTR_SEQ) from ATTR";
	static final String SEARCH_COUNT = "select count(ATTR_SEQ ) from ATTR  where attr_name like ? order by ATTR_SEQ desc";
	final static String SELECT=
			"select * from (select ROWNUM rnum , aa.* from (select * from attr where attr_name like ? order by ATTR_SEQ desc) aa)"+ "where rnum>? and rnum<=?";

}
