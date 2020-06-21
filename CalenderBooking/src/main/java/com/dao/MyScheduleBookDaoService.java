package com.dao;

import java.util.List;

import com.pojo.MyScheduleBook;

public interface MyScheduleBookDaoService {
	
	public boolean insertMyScheduleBook(Integer scheduleId,Integer timeScheduleId,Integer startTime,Integer endTime,String userName);
	public List<MyScheduleBook> featchMyScheduleBookByUserID(String userID);
}
