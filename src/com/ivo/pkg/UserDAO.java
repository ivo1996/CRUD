package com.ivo.pkg;
import java.sql.*;
import java.util.ArrayList;



public class UserDAO {
	static Connection conn;
	static PreparedStatement pst;
	static ResultSet rs;
	
	//Method that retreives all information from the Database, it uses of type ArrayList and uses a sort String argument
	//So that a proper sort is done
	public static ArrayList<UserBean> getUsers(String sort) {
		ArrayList<UserBean> people = new ArrayList<UserBean>();
		
		try {
			//Cases for the type of sorts, null means that no sort was opted for and it is the default preview - by ID.
			if(sort==null) {
			conn=ConnectionProvider.getCon();
			pst=conn.prepareStatement("select * from \"People\" order by \"Id\" ");
			rs=pst.executeQuery();
			}
			else if(sort.equals("Last Name"))
			{
			conn=ConnectionProvider.getCon();
			pst=conn.prepareStatement("select * from \"People\" order by \"LastName\" ");
			rs=pst.executeQuery();
			}
			else if(sort.equals("Birth Date"))
			{
			conn=ConnectionProvider.getCon();
			pst=conn.prepareStatement("select * from \"People\" order by \"BirthDate\" ");
			rs=pst.executeQuery();
			}
			//Loop that extracts all the data from the resultSet, fills in an object and adds it to the ArrayList.
			while(rs.next()) {
				UserBean user = new UserBean();
				
				user.setId(rs.getInt(1));
				user.setFirstName(rs.getString(2));
				user.setLastName(rs.getString(3));
				user.setBirthDate(rs.getString(4));
				user.setPhone(rs.getString(5));
				user.setEmail(rs.getString(6));
				
				people.add(user);
			}
			conn.close();
			}catch(Exception ex) {
				System.out.println(ex);
			
			}
		return people;
	}
	
	//Method to insert a new row, takes an object of type UserBean as argument.
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
	
	//Method to edit a row of information
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
	
	//Method that drops a row from the Database
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
	
	//Method used to display the information of a single desired row, used for update.jsp
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
	
	//Method used for the search bar
	public static ArrayList<UserBean> search(String key) {
		ArrayList<UserBean> people = new ArrayList<UserBean>();
		
		try {
			java.sql.Date dateKey = toSQL.convert(key);
			conn=ConnectionProvider.getCon();
			pst=conn.prepareStatement("select * from \"People\" where \"FirstName\" like '"+key+"'"
					+ " or \"LastName\" like '"+key+"'"
							+ " or \"BirthDate\" = ?"
									+ " or \"Phone\" like '"+key+"'"
											+ " or \"Email\" like '"+key+"'");
			pst.setDate(1, dateKey);
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
}
