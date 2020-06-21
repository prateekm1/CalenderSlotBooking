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
import com.pojo.ScheduleDetails;

@Path("/loadScheduleByDate")
public class LoadScheduleById {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public List<ScheduleDetails> loadScheduleByDate(@FormParam("creationDate") String creationDate) {
		
		List<ScheduleDetails> result =null;
		SecheduleDaoServiceImpl sdsi = new SecheduleDaoServiceImpl();
		try {
			
			result = sdsi.fetchScheduleBasedonDate(creationDate);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	
	}
}
