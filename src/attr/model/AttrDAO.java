package attr.model;

import java.util.ArrayList;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import domain.Attr;


class AttrDAO {
	private DataSource ds;
	AttrDAO(){
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {}
	}
	public ArrayList<Attr> list() {
		ArrayList<Attr> attrList = new ArrayList<Attr>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = AttrSQL.LIST;
		try {
			con=ds.getConnection();
			stmt = con.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				int attr_seq = rs.getInt(1);
				String email = rs.getString(2);
				String attr_name = rs.getString(3);
				String attr_addr = rs.getString(4);
				String attr_info = rs.getString(5);
				int avg_rec= rs.getInt(6);
				int area_no = rs.getInt(7);
				attrList.add(new Attr(attr_seq,email,attr_name, attr_addr, attr_info, avg_rec,area_no));
				
			}
			return attrList;
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
	public ArrayList<Attr> list(int area_no) {
		ArrayList<Attr> attrList = new ArrayList<Attr>();
		Connection con = null;
		PreparedStatement pstmt = null;
 		ResultSet rs = null;
		String sql = AttrSQL.LIST1;
		try {
			con=ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, area_no);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int attr_seq = rs.getInt(1);
				String email = rs.getString(2);
				String attr_name = rs.getString(3);
				String attr_addr = rs.getString(4);
				String attr_info = rs.getString(5);
				int avg_rec= rs.getInt(6);
				attrList.add(new Attr(attr_seq,email,attr_name, attr_addr, attr_info, avg_rec,area_no));
				
			}
			return attrList;
		}catch(SQLException se) {
			System.out.println("se :" + se);
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
	public ArrayList<Attr> list(int currentPage,int pageSize) {
		ArrayList<Attr> attrList = new ArrayList<Attr>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = AttrSQL.LIST_PAGE;
		int startRow = (currentPage-1)*pageSize;
		int endRow = currentPage*pageSize;
		try {
			con=ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,startRow);
			pstmt.setInt(2,endRow);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int attr_seq = rs.getInt("attr_seq");
				String email = rs.getString("email");
				String attr_name = rs.getString("attr_name");
				String attr_addr = rs.getString("attr_addr");
				String attr_info = rs.getString("attr_info");
				int avg_rec= rs.getInt("avg_rec");
				int area_no = rs.getInt("area_no");
				attrList.add(new Attr(attr_seq,email,attr_name, attr_addr, attr_info, avg_rec,area_no));
			}
			return attrList;
		}catch(SQLException se) {
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
		String sql = AttrSQL.COUNT;
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
	void insert(Attr dto) {
		Connection con = null;
	    PreparedStatement pstmt = null;
	    String sql = AttrSQL.INSERT;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getEmail());
			pstmt.setString(2, dto.getAttr_name());
			pstmt.setString(3, dto.getAttr_addr());
			pstmt.setString(4, dto.getAttr_info());
			pstmt.setInt(5, dto.getArea_no());
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
	boolean del(int attr_seq) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = AttrSQL.DEL;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, attr_seq);
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
	long getTotalSearchCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = AttrSQL.SEARCH_COUNT;
		try {
			con=ds.getConnection();
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
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
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	public ArrayList<Attr> search(int currentPage,int pageSize,String subject) {
		ArrayList<Attr> attrList=new ArrayList<Attr>();
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = AttrSQL.SELECT;
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
				int attr_seq = rs.getInt("attr_seq");
				String email = rs.getString("email");
				String attr_name = rs.getString("attr_name");
				String attr_addr = rs.getString("attr_addr");
				String attr_info = rs.getString("attr_info");
				int avg_rec= rs.getInt("avg_rec");
				int area_no = rs.getInt("area_no");
				attrList.add(new Attr(attr_seq,email,attr_name, attr_addr, attr_info, avg_rec,area_no));
			}		
			return attrList;
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

}
