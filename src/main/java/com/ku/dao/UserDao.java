package com.ku.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ku.dto.UserDto;
 

public class UserDao {
	
	public UserDao(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Driver loaded Successfully...");
				}
		catch(ClassNotFoundException e) {
			System.out.println("Driver Not Loaded .............................");
			return;
		}
		
		}
		 
 

	//public UserDto getInfo()
	
	public List<UserDto> getInfo() {
//		UserDto u = new UserDto();
		List <UserDto>  ud = new ArrayList<UserDto>();
		UserDto ue = new UserDto();
		Connection con = null;
		Statement stmt = null;
		try {
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kushagra","root","Manas");
			 
		     stmt = con.createStatement();	
		
		}
		catch(Exception e) {
			System.out.println("Exception in con and stmt ");
		}
		
		try {
		     
		     String sql = "SELECT * FROM test;";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				UserDto u = new UserDto();
				
   			System.out.println("id: "+rs.getString(1)+" Name: "+rs.getString(2));
				u.setId(Integer.parseInt(rs.getString(1)));
				u.setName(rs.getString(2));
				u.setRollno(rs.getString(3));
				u.setMarks(Integer.parseInt(rs.getString(4)));
				
				ud.add(u);
				
				
				 
			} 
				
			
			try {
				
				for(UserDto ude:ud) {
					System.out.println(" id:  "+ ude.getId() + " Name: " + ude.getName()+ "  Inside close");
				}
				
				con.close();
				
			}
			catch(Exception e2) {
				System.out.println("Close Exception ");
				 
			}
			
			return ud;
			
			
		}
		catch(SQLException e) {
			System.out.println("Sql Exception" + e.getMessage());
			
		}
		
		try {
			con.close();
			
		}
		catch(Exception e2) {
			System.out.println("Close Exception ");
			 
		}
		 
 		for(UserDto ude:ud) {
 			System.out.println(" id:  "+ ude.getId() + " Name: " + ude.getName()+ " Testing List ");
 	}

		return ud;
	}



}
