package login.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import userManagement.domain.Member;
import userManagement.interfaces.DB;

class DbLogin implements DB{
	private DataSource ds;
	DbLogin() {
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {
		}
	}
	public Member excuteQuery(String email) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			st = con.prepareStatement("select * from MEMBER where EMAIL=?");
			st.setString(1, email);
			rs = st.executeQuery();
			rs.next();
			return new Member(rs.getString("EMAIL"), rs.getString("PWD"), rs.getString("NICK_NAME"), rs.getDate("RDATE"));
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(st != null) st.close();
				if(con != null) con.close();
			}catch(SQLException se) { se.printStackTrace(); }
		}
		return null;
	}
	public int excuteUpdate(String key, String email, String pwd, String nick) {
		return 0;
	}
}
