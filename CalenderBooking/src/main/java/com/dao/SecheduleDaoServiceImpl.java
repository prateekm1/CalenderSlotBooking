package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.ScheduleDetails;
import com.pojo.User;

public class SecheduleDaoServiceImpl implements SecheduleDaoService {

	@Override
	public boolean insertNewSchedule(String scheduleName,String scheduleLocation,String creationDate,String startTime,String endTime,String userName) {
		Statement stmt = null;
		Connection conn = null;
		//java.sql.Date date = new java.sql.Date(currentDate.getTime());
		try {
			DBConnectionImpl dbc = new DBConnectionImpl();
			conn = dbc.getDBConnection();

			stmt = conn.createStatement();

			String sql = "INSERT INTO `scheduleBooking`.`scheduleDetails` (`scheduleName`, `scheduleLocation`, `startTime`, `endTime`, `userName`, `creationDate`) VALUES ('"+ scheduleName +"','"  + scheduleLocation +"','" + startTime +"','" + endTime +"','" + userName +"','" + creationDate  + "')";
//			System.out.println(sql);
			int primaryId = -1; 
			stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			String pri2 = "-1s";
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()){
				pri2=rs.getString(1);
			}
			primaryId = Integer.parseInt(pri2);
			Integer st = Integer.parseInt(startTime);
			Integer et = Integer.parseInt(endTime);
			while(st<et) {
				Integer startSeries = st;
				st++;
				Integer endSeries =st;
				sql = "INSERT INTO `scheduleBooking`.`scheduleTimeSeries` (`scheduleId`, `stime`, `etime`, `status`, `userName`) VALUES ('"+ primaryId +"','"  + startSeries +"','" + endSeries +"','" + "free" +"','" + userName + "')";
				stmt.executeUpdate(sql);
			}
			
			
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
	public List<ScheduleDetails> fetchScheduleBasedonDate(String date) {
		Statement stmt = null;
		Connection conn = null;
		ScheduleDetails usrDtls= null;
		List<ScheduleDetails> resultArr = new ArrayList<ScheduleDetails>();
		try {
			usrDtls= new ScheduleDetails();
			DBConnectionImpl dbc = new DBConnectionImpl();
			conn = dbc.getDBConnection();
			

			stmt = conn.createStatement();

			String sql = "SELECT scheduleId, scheduleName, scheduleLocation, startTime, endTime, userName, creationDate FROM scheduleBooking.scheduleDetails where creationDate = '" +date +"'";
//			System.out.println(sql);

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				usrDtls = new ScheduleDetails();
				usrDtls.setScheduleId(rs.getInt("scheduleId"));
				usrDtls.setScheduleName(rs.getString("scheduleName"));
				usrDtls.setScheduleLocation(rs.getString("scheduleLocation"));
				usrDtls.setStartTime(rs.getString("startTime"));
				usrDtls.setEndTime(rs.getString("endTime"));
				usrDtls.setUserName(rs.getString("userName"));
				usrDtls.setCreationDate(rs.getString("creationDate"));
				resultArr.add(usrDtls);
		    }
			return resultArr;

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
		return resultArr;
	}

	@Override
	public List<ScheduleDetails> fetchScheduleBasedonID(Integer id) {
		Statement stmt = null;
		Connection conn = null;
		ScheduleDetails usrDtls= null;
		List<ScheduleDetails> resultArr = new ArrayList<ScheduleDetails>();
		try {
			usrDtls= new ScheduleDetails();
			DBConnectionImpl dbc = new DBConnectionImpl();
			conn = dbc.getDBConnection();
			

			stmt = conn.createStatement();

			String sql = "SELECT scheduleId, scheduleName, scheduleLocation, startTime, endTime, userName, creationDate FROM scheduleBooking.scheduleDetails where scheduleId = '" +id +"'";
//			System.out.println(sql);

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				usrDtls = new ScheduleDetails();
				usrDtls.setScheduleId(rs.getInt("scheduleId"));
				usrDtls.setScheduleName(rs.getString("scheduleName"));
				usrDtls.setScheduleLocation(rs.getString("scheduleLocation"));
				usrDtls.setStartTime(rs.getString("startTime"));
				usrDtls.setEndTime(rs.getString("endTime"));
				usrDtls.setUserName(rs.getString("userName"));
				usrDtls.setCreationDate(rs.getString("creationDate"));
				resultArr.add(usrDtls);
		    }
			return resultArr;

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
		return resultArr;
	}

}
