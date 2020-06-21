package com.service;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.RegisterUserDaoServiceImpl;
import com.dao.SecheduleDaoServiceImpl;
import com.pojo.LoginRequest;
import com.pojo.LoginResponse;

@Path("/createSchedule")
public class CreateNewSchedule {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> createNewSchedule(@FormParam("scheduleName") String scheduleName, @FormParam("scheduleLocation") String scheduleLocation,
			@FormParam("creationDate") String creationDate,@FormParam("startTime") String startTime, @FormParam("endTime") String endTime,
			@FormParam("userName") String userName) {
		
		List<String> loginResponse = new ArrayList<String>();
		SecheduleDaoServiceImpl sds = new SecheduleDaoServiceImpl();
		boolean status =false;
		try {
			status = sds.insertNewSchedule(scheduleName, scheduleLocation, creationDate, startTime, endTime, userName);
			if(status) {
				
				loginResponse.add("Schedule Sucessfully created");
				return loginResponse;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		loginResponse.add("Schedule Creation fail");
		return loginResponse;
	
	}
}
