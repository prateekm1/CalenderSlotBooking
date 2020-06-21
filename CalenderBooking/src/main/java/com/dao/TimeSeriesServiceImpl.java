package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.ScheduleDetails;
import com.pojo.ScheduleTimeSeries;

public class TimeSeriesServiceImpl implements TimeSeriesService {

	@Override
	public List<ScheduleTimeSeries> loadTimeSeriesDatById(Integer id) {
		Statement stmt = null;
		Connection conn = null;
		ScheduleTimeSeries timeSeries =null;
		List<ScheduleTimeSeries> resultArr = new ArrayList<ScheduleTimeSeries>();
		try {
			
			DBConnectionImpl dbc = new DBConnectionImpl();
			conn = dbc.getDBConnection();
			

			stmt = conn.createStatement();
			String sql = "SELECT id,scheduleId, stime, etime, status, userName FROM scheduleBooking.scheduleTimeSeries where scheduleId = '" +id +"'";
//			System.out.println(sql);

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				timeSeries = new ScheduleTimeSeries();
				timeSeries.setId(rs.getInt("id"));
				timeSeries.setScheduleId(rs.getInt("scheduleId"));
				timeSeries.setStime(rs.getString("stime"));
				timeSeries.setEtime(rs.getString("etime"));
				timeSeries.setStatus(rs.getString("status"));
				timeSeries.setUserName(rs.getString("userName"));				
				resultArr.add(timeSeries);
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
