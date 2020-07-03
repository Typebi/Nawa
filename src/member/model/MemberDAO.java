package member.model;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import domain.Member;

class MemberDAO {
	
	private DataSource ds;
	MemberDAO() {
		try {
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {			
		}
	}

	//로그인시 마이페이지
	public Member mypage(String email) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = MemberSQL.SELECT;
		try {
			con=ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,email);
			rs=pstmt.executeQuery();
			rs.next();
				email = rs.getString("EMAIL");
				String pwd = rs.getString("PWD");
				String nick_name = rs.getString("NICK_NAME");
				int grade = rs.getInt("GRADE");
				Date rdate = rs.getDate("RDATE");
	
			return new Member(email, pwd, nick_name,grade,rdate);
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

	public void update(Member member) {
		Connection con=null;
		PreparedStatement pstmt= null;
		String sql=MemberSQL.UPDATE;
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1,member.getPwd());
			pstmt.setString(2,member.getNick_name());
			pstmt.setString(3,member.getEmail());
			pstmt.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println("seUpdate: "+se);
		}finally {
			try {			
				if(pstmt != null) pstmt.close();
				if(con != null)con.close();
			}catch(SQLException se2) {				
			}
		}		
	}
	
	public void delete(String email) {
		Connection con=null;
		PreparedStatement pstmt= null;
		String sql=MemberSQL.DELETE;
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,email);
			pstmt.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println("seUpdate: "+se);
		}finally {
			try {			
				if(pstmt != null) pstmt.close();
				if(con != null)con.close();
			}catch(SQLException se2) {				
			}
		}		
	}

}
