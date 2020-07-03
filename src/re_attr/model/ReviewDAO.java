package re_attr.model;

import java.util.ArrayList;
import java.util.Date;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import domain.Attr;
import domain.Reply;
import domain.Review;


class ReviewDAO {
	private DataSource ds;
	ReviewDAO(){
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {}
	}
	public ArrayList<Review> list() {
		ArrayList<Review> reviewList = new ArrayList<Review>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = ReviewSQL.LIST;
		try {
			con=ds.getConnection();
			stmt = con.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				
				//reviewList.add(new Review());
				
			}
			return reviewList;
		}catch(SQLException se) {
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null)con.close();
			}catch(SQLException se2) {
				return null;
			}
		}
	}

	public ArrayList<Review> listingReview(int currentPage,int pageSize,int attr_seq) {
		ArrayList<Review> reviewList = new ArrayList<Review>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = ReviewSQL.LIST_PAGE;
		int startRow = (currentPage-1)*pageSize;
		int endRow = currentPage*pageSize;
		try {
			con=ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			pstmt.setInt(3,attr_seq);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int re_seq = rs.getInt("re_seq");
				String email = rs.getString("email"); 
				String nick = rs.getString("nick_name");
				String re_subject = rs.getString("review_subject"); 
				String re_content = rs.getString("review_content");
				int rate = rs.getInt("rate");
				int recommend = rs.getInt("recommend");
				Date rdate = rs.getDate("rdate");
				ArrayList<Reply> replys = getReplys(re_seq);
				reviewList.add(new Review(re_seq,attr_seq,email,re_subject, re_content, rate, recommend,rdate,nick, replys));
			}
			return reviewList;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)con.close();
			}catch(SQLException se2) {
				return null;
			}
		}
	}
	long getTotalCount() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = ReviewSQL.COUNT;
		try {
			con=ds.getConnection();
			stmt = con.createStatement();
			rs=stmt.executeQuery(sql);
			if(rs.next()) {
				long count=rs.getLong(1);
				return count;
			}else {
				return -1L;
			}
		}catch(SQLException se3) {
			System.out.println("se3:"+se3);
			return -1L;
		}finally {
			try {
				if(rs != null ) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	void insert(Review dto) {
		Connection con = null;
	    PreparedStatement pstmt = null;
	    String sql = ReviewSQL.INSERT;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getAttr_seq());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getRe_subject());
			pstmt.setString(4, dto.getRe_content());
			pstmt.setInt(5, dto.getRate());
			int i = pstmt.executeUpdate();
		}catch(SQLException se){
			System.out.println("se : " + se);
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		
		}
	}
	void insertC(Reply dto) {
		Connection con = null;
	    PreparedStatement pstmt = null;
	    String sql = ReviewSQL.INSERT_C;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getCOMM_CONTENT());
			pstmt.setInt(2, dto.getRE_SEQ());
			pstmt.setString(3, dto.getNICK());
			int i = pstmt.executeUpdate();
		}catch(SQLException se){
			System.out.println("se : " + se);
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		
		}
	}
	boolean del(int re_seq) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = ReviewSQL.DEL;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, re_seq);
			int i = pstmt.executeUpdate();
			if(i > 0) return true;
			else return false;
			
		}catch(SQLException se){
			System.out.println("se : "+ se);
			return false;
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}
	}
	void recommend(Review dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = ReviewSQL.RECOMMEND;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getRe_seq());
			
			pstmt.executeUpdate();
			
		}catch(SQLException se) {
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}ArrayList<Review> content(int re_seq) {
		ArrayList<Review> dto = new ArrayList<Review>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = ReviewSQL.CONTENT;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, re_seq);
			rs=pstmt.executeQuery();
			while(rs.next()){
				String re_subject = rs.getString("review_subject");
				int rate = rs.getInt("rate");
				String re_content = rs.getString("review_content");
				dto.add(new Review(re_seq,re_subject, rate, re_content));
			}
			return dto;
		}catch(SQLException se){
			return null;
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}
	}
	boolean update(int re_seq,String review_subject,int rate,String review_content) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = ReviewSQL.UPDATE;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, review_subject);
			pstmt.setInt(2, rate);
			pstmt.setString(3, review_content);
			pstmt.setInt(4, re_seq);
			
			int i = pstmt.executeUpdate();
			if(i > 0) return true;
			else return false;
		}catch(SQLException se){
			System.out.println("Se" + se);
			return false;
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}
	}
	Attr getAttrFromDB(int seq) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Attr attr = null;
		try {
			con=ds.getConnection();
			pstmt = con.prepareStatement("select at.ATTR_NAME, at.ATTR_INFO, at.AVG_REC, ar.AREA_NAME from ATTR at, AREA ar where at.ATTR_SEQ=? and at.area_no = ar.area_no");
			pstmt.setInt(1, seq);
			rs=pstmt.executeQuery();
			rs.next();
			String attr_name = rs.getString("ATTR_NAME"); 
			String attr_info = rs.getString("ATTR_INFO");
			int rate = rs.getInt("AVG_REC");
			String area_name = rs.getString("AREA_NAME");
			attr=new Attr(seq, null, attr_name, null, attr_info, rate, -1,area_name);
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)con.close();
			}catch(SQLException se2) {
				return null;
			}
		}
		return attr;
	}
	ArrayList<Reply> getReplys(int seq) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Reply> replys = new ArrayList<Reply>();
		try {
			con=ds.getConnection();
			pstmt = con.prepareStatement("select u.*, m.nick_name from USER_COMMENT u, MEMBER m where RE_SEQ=? and u.email=m.email order by COMM_SEQ");
			pstmt.setInt(1, seq);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int COMM_SEQ = rs.getInt("COMM_SEQ");
				String COMM_CONTENT = rs.getString("COMM_CONTENT");
				java.sql.Date RDATE = rs.getDate("RDATE");
				int RE_SEQ = rs.getInt("RE_SEQ");
				String email = rs.getString("EMAIL");
				String NICK = rs.getString("NICK_NAME");
				replys.add(new Reply(COMM_SEQ, COMM_CONTENT, RDATE, RE_SEQ, email, NICK));
			}
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)con.close();
			}catch(SQLException se2) {
				return null;
			}
		}
		return replys;
	}
	boolean delC(int re_seq,int comm_seq) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = ReviewSQL.DELC;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, re_seq);
			pstmt.setInt(2, comm_seq);
			int i = pstmt.executeUpdate();
			if(i > 0) return true;
			else return false;
			
		}catch(SQLException se){
			System.out.println("se : "+ se);
			return false;
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}
	}
}
