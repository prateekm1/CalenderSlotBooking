package com.dao;

import java.sql.Date;
import java.util.List;

import javax.ws.rs.FormParam;

import com.pojo.ScheduleDetails;

public interface SecheduleDaoService {

	
	public boolean insertNewSchedule(String scheduleName,String scheduleLocation,String creationDate,String startTime,String endTime,String userName);
	public List<ScheduleDetails> fetchScheduleBasedonDate(String date);
	public List<ScheduleDetails> fetchScheduleBasedonID(Integer id);
}
