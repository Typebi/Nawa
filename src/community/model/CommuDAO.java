package community.model;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import domain.Community;

class CommuDAO {
	private DataSource ds;
	CommuDAO(){
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {
		}
	}
	ArrayList<Community> list(){
		ArrayList<Community> list = new ArrayList<Community>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = CommuSQL.LIST;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) { 
				
				int c_seq = rs.getInt("c_seq");
				String subject = rs.getString("subject");
				//String content = rs.getString(3);
				Date rdate = rs.getDate("rdate");
				Long hits = rs.getLong("hits");
				//String nick_name = rs.getString(6);
				String nick_name = rs.getString("nick_name");

				Community cm = new Community(c_seq, subject, null, null, rdate, hits, null, null, nick_name);
				list.add(cm);
			}
			return list;
		}catch(SQLException se) {
			System.out.println("se1: "+se);
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}catch(SQLException sse) {}
		}
	}
	ArrayList<Community> list(int currentPage, int pageSize){
		ArrayList<Community> list = new ArrayList<Community>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = CommuSQL.LIST_PAGE;
		
		int startRow = (currentPage-1)*pageSize;
		int endRow = currentPage*pageSize;
		try {
			con=ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,startRow);
			pstmt.setInt(2,endRow);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				//int rnum = rs.getInt("rnum");
				int c_seq = rs.getInt("c_seq"); 
				//String email=rs.getString("email");
				String subject = rs.getString("subject");
				Date rdate = rs.getDate("rdate");
				Long hits = rs.getLong("hits");
				String nick_name = rs.getString("nick_name");

				Community cm = new Community(c_seq, subject, null, null, rdate, hits, null, null, nick_name);

				list.add(cm);
			}
			return list;
		}catch(SQLException se) {
			System.out.println("see1004: "+se);
			return null;
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException sse) {}
		}
	}
	long getTotalCount() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = CommuSQL.COUNT;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				long count = rs.getLong(1);
				return count;
			}else {
				return -1L;
			}
		}catch(SQLException se) {
			System.out.println("seTotal: "+se);
			return -1L;
		}finally {
			try {
				if(rs != null ) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {
			}
		}
	}
	long getTotalSearchCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = CommuSQL.SEARCH_COUNT;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				long count = rs.getLong(1);
				return count;
			}else {
				return -1L;
			}
		}catch(SQLException se) {
			System.out.println("se1214: " + se);
			return -1L;
		}finally {
			try {
				if(rs != null ) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	public ArrayList<Community> search(int currentPage,int pageSize,String subject) {
    	ArrayList<Community> list = new ArrayList<Community>();
    	Connection con = null;
    	PreparedStatement pstmt = null;
    	String sql = CommuSQL.SELECT;
    	ResultSet rs = null;
		int startRow = (currentPage-1)*pageSize;
		int endRow = currentPage*pageSize;
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,"%"+subject+"%");
			pstmt.setInt(2,startRow);
			pstmt.setInt(3,endRow);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int c_seq =rs.getInt("c_seq");
				//String email =rs.getString("email");
				subject =rs.getString("subject");
				//String content =rs.getString("content");
				Long hits =rs.getLong("hits");     
				Date rdate =rs.getDate("rdate");
				String nick_name = rs.getString("nick_name");
				Community cm = new Community(c_seq, subject, null, null, rdate, hits, null, null, nick_name);
				list.add(cm);
			}		
			return list;
		}catch(SQLException se1) {
			System.out.println("se1:"+ se1);
			return null;
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}
    }
	void insert(Community community) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = CommuSQL.INSERT;
		
		try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, community.getSubject());
			pstmt.setString(2, community.getContent());
			pstmt.setString(3, community.getEmail());
			pstmt.setString(4, community.getFname());
			pstmt.setString(5, community.getOfname());
			
			pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println("se2: "+se);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException sse) {}
		}
	}
	Community getBoard(int c_seq) {
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		String sql = CommuSQL.CONTENT;
		String sql2 = CommuSQL.HITS;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt2 = con.prepareStatement(sql2);
			pstmt.setInt( 1, c_seq );
			pstmt2.setInt( 1, c_seq );
			rs = pstmt.executeQuery();
			pstmt2.executeUpdate();
			if(rs.next()) {
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				Date rdate = rs.getDate("rdate");
				Long hits = rs.getLong("hits");
				String fname = rs.getString("fname");
				System.out.println("fname :" +fname);
				String ofname = rs.getString(8);
				String nick_name = rs.getString(9);

				Community cm = new Community(c_seq, subject, content, null, rdate, hits, fname, ofname, nick_name);
				return cm;
			}else {
				System.out.println("아");
				return null;
			}
		}catch(SQLException se) {
			System.out.println("se3 : " + se);
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}catch(SQLException sse) {}
		}
	}
	void del(int c_seq) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = CommuSQL.DEL;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, c_seq);
			pstmt.executeUpdate();
		}catch(SQLException se) {
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	void update(Community community) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = CommuSQL.UPDATE;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, community.getSubject());
			pstmt.setString(2, community.getContent());
			pstmt.setString(3, community.getFname());
			pstmt.setString(4, community.getOfname());
			pstmt.setInt(5, community.getC_seq());
			System.out.println("업데이트3");
			pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println("se4 : " + se);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException sse) {}
		}
	}
	
}
