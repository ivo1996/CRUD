package com.ivo.pkg;
import java.sql.*;
import java.util.ArrayList;
//import java.util.ArrayList;


public class UserDAO {
	static Connection conn;
	static PreparedStatement pst;
	static ResultSet rs;
	
	public static ArrayList<UserBean> getUsers() {
		ArrayList<UserBean> people = new ArrayList<UserBean>();
		
		try {
			conn=ConnectionProvider.getCon();
			pst=conn.prepareStatement("select * from \"People\" ");
			rs=pst.executeQuery();
			while(rs.next()) {
				UserBean u = new UserBean();
				
				u.setId(rs.getInt(1));
				u.setFirstName(rs.getString(2));
				u.setLastName(rs.getString(3));
				u.setBirthDate(rs.getString(4));
				u.setPhone(rs.getString(5));
				u.setEmail(rs.getString(6));
				
				people.add(u);
			}
			conn.close();
			}catch(Exception ex) {
				System.out.println(ex);
			
			}
		return people;
	}
	
	
	public static int insertUser(UserBean u) {
		int status=0;
		try {
		conn=ConnectionProvider.getCon();
		pst=conn.prepareStatement("Insert into \"People\"(\"FirstName\",\"LastName\",\"BirthDate\",\"Phone\",\"Email\") values(?,?,?,?,?)");
		pst.setString(1,u.getFirstName());
		pst.setString(2,u.getLastName());
		java.sql.Date sqlDate=toSQL.convert(u.getBirthDate());
		pst.setDate(3, sqlDate);
		pst.setString(4,u.getPhone());
		pst.setString(5,u.getEmail());
		status=pst.executeUpdate();
		conn.close();
		
		}catch(Exception ex) {
			System.out.println(ex);
		
		}
		return status;
	}
	
	public static int updateRecord(UserBean u, String id) {
		int status=0;
		try {
		int intID=Integer.parseInt(id);
		conn=ConnectionProvider.getCon();
		pst=conn.prepareStatement("UPDATE \"People\" SET \"FirstName\" = ?, \"LastName\" = ?,\"BirthDate\" = ?,\"Phone\" = ?,\"Email\" = ? WHERE \"Id\" = ? ");
		pst.setString(1,u.getFirstName());
		pst.setString(2,u.getLastName());
		java.sql.Date sqlDate=toSQL.convert(u.getBirthDate());
		pst.setDate(3, sqlDate);
		pst.setString(4,u.getPhone());
		pst.setString(5,u.getEmail());
		pst.setInt(6, intID);
		status=pst.executeUpdate();
		conn.close();
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return status;
	}
	
	public static int deleteRecord(String usrID) {
		int status=0;
		int intID=Integer.parseInt(usrID);
		try {
			
			conn=ConnectionProvider.getCon();
			pst=conn.prepareStatement("delete from \"People\" where \"Id\" = ?");
			pst.setInt(1, intID);
			status=pst.executeUpdate();
			conn.close();
			}catch(Exception ex) {
				System.out.println(ex);
			}
		return status;
	}
	
	public static UserBean getUser(String id) {
		UserBean u = new UserBean();
		int intId=Integer.parseInt(id);		
		try {
			conn=ConnectionProvider.getCon();
			pst=conn.prepareStatement("select * from \"People\" Where \"Id\"="+intId);
			rs=pst.executeQuery();
			while(rs.next()) {
				
				u.setId(rs.getInt(1));
				u.setFirstName(rs.getString(2));
				u.setLastName(rs.getString(3));
				u.setBirthDate(rs.getString(4));
				u.setPhone(rs.getString(5));
				u.setEmail(rs.getString(6));
			
			}
			conn.close();
			}catch(Exception ex) {
				System.out.println(ex);
			
			}
		return u;
	}
}
