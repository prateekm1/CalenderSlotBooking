package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.pojo.User;

public class RegisterUserDaoServiceImpl implements RegisterUserDaoService {

	@Override
	public boolean registerNewUser(String userName, String eamil, String address, String name, String password,
			String usrType) {
		// TODO Auto-generated method stub
		Statement stmt = null;
		Connection conn = null;
		try {
			DBConnectionImpl dbc = new DBConnectionImpl();
			conn = dbc.getDBConnection();

			stmt = conn.createStatement();

			String sql = "INSERT INTO `scheduleBooking`.`user` (`userName`, `eamil`, `address`, `name`, `password`, `usrType`) VALUES ('"+ userName +"','"  + eamil +"','" + address +"','" + name +"','" + password +"','" + usrType  + "')";
//			System.out.println(sql);

			stmt.executeUpdate(sql);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		}
		return false;
	}
	
	@Override
	public User fetchUserDetailsByUserIdPassword(String userName, String pass) {
		Statement stmt = null;
		Connection conn = null;
		User usr= null;
		try {
			usr= new User();
			DBConnectionImpl dbc = new DBConnectionImpl();
			conn = dbc.getDBConnection();
			

			stmt = conn.createStatement();

			String sql = "SELECT userSyatemId, userName, eamil, address, name, password, usrType FROM scheduleBooking.user where userName = '" + userName + "' and password = '" + pass +"'";
//			System.out.println(sql);

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				usr.setUserSyatemId(rs.getInt("userSyatemId"));
				usr.setUserName(rs.getString("userName"));
				usr.setEamil(rs.getString("eamil"));
				usr.setAddress(rs.getString("address"));
				usr.setName(rs.getString("name"));
				usr.setPassword(rs.getString("password"));
				usr.setUsrType(rs.getString("usrType"));
		        
		    }
			return usr;

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		}
		return usr;
	}

	@Override
	public Integer checkUseIsExistsbyUserName(String userName) {
		Statement stmt = null;
		Connection conn = null;
		Integer resultRecord = 0;
		try {
			
			DBConnectionImpl dbc = new DBConnectionImpl();
			conn = dbc.getDBConnection();
			

			stmt = conn.createStatement();

			String sql = "SELECT userSyatemId, userName, eamil, address, name, password, usrType FROM scheduleBooking.user where userName = '" + userName + "'";
//			System.out.println(sql);

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
				resultRecord++;
		    }
			return resultRecord;

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		}
		return resultRecord;
	}

}
