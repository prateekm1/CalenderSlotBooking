package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.MyScheduleBook;
import com.pojo.ScheduleDetails;
import com.pojo.ScheduleTimeSeries;

public class MyScheduleBookDaoServiceImpl implements MyScheduleBookDaoService {

	@Override
	public boolean insertMyScheduleBook(Integer scheduleId, Integer timeScheduleId, Integer startTime, Integer endTime, String userName) {
		// TODO Auto-generated method stub
		Statement stmt = null;
		Connection conn = null;
		//java.sql.Date date = new java.sql.Date(currentDate.getTime());
		try {
			SecheduleDaoServiceImpl sdsi = new SecheduleDaoServiceImpl();
			List<ScheduleDetails> lsitSchedule = sdsi.fetchScheduleBasedonID(scheduleId);
			String scheduleName = lsitSchedule.get(0).getScheduleName();
			String creationDate = lsitSchedule.get(0).getCreationDate();
			
			DBConnectionImpl dbc = new DBConnectionImpl();
			conn = dbc.getDBConnection();

			stmt = conn.createStatement();
			int bookingCount = 0;
			String sql2 = "SELECT id FROM scheduleBooking.scheduleTimeSeries where scheduleId = '" +scheduleId +"'" + "and stime = '" +startTime +"'" +"and etime = '" +endTime +"'" +"and status = '" +"book" +"'" ;
			ResultSet rs = stmt.executeQuery(sql2);
			if (rs.next()){
				bookingCount = rs.getInt("id");
			}
			
			String sql = "INSERT INTO `scheduleBooking`.`myScheduleBook` (`scheduleId`, `timeScheduleId`, `scheduleName`, `startTime`, `endTime`, `userName`, `creationDate`) VALUES ('"+ scheduleId +"','"  + timeScheduleId +"','" + scheduleName +"','" + startTime +"','" + endTime +"','" + userName +"','" + creationDate + "')";
//			System.out.println(sql);
			if(bookingCount ==0) {
				stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
				String sql3 = "UPDATE scheduleBooking.scheduleTimeSeries SET status = 'book' where id = '" +timeScheduleId +"'";
				stmt.executeUpdate(sql3, Statement.RETURN_GENERATED_KEYS);
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
	public List<MyScheduleBook> featchMyScheduleBookByUserID(String userID) {
		Statement stmt = null;
		Connection conn = null;
		MyScheduleBook scheduleBook =null;
		List<MyScheduleBook> resultArr = new ArrayList<MyScheduleBook>();
		try {
			
			DBConnectionImpl dbc = new DBConnectionImpl();
			conn = dbc.getDBConnection();
			
			
			stmt = conn.createStatement();
			String sql = "SELECT id,scheduleId, timeScheduleId,scheduleName, startTime, endTime, userName, creationDate FROM scheduleBooking.myScheduleBook where userName = '" +userID +"'";
//			System.out.println(sql);

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				scheduleBook = new MyScheduleBook();
				scheduleBook.setId(rs.getInt("id"));
				scheduleBook.setScheduleId(rs.getInt("scheduleId"));
				scheduleBook.setTimeScheduleId(rs.getInt("timeScheduleId"));
				scheduleBook.setScheduleName(rs.getString("scheduleName"));
				scheduleBook.setStartTime(rs.getInt("startTime"));
				scheduleBook.setEndTime(rs.getInt("endTime"));
				scheduleBook.setUserName(rs.getString("userName"));
				scheduleBook.setCreationDate(rs.getString("creationDate"));
							
				resultArr.add(scheduleBook);
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
