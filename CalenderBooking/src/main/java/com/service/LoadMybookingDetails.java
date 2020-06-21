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

import com.dao.MyScheduleBookDaoService;
import com.dao.MyScheduleBookDaoServiceImpl;
import com.dao.RegisterUserDaoServiceImpl;
import com.dao.SecheduleDaoServiceImpl;
import com.pojo.LoginRequest;
import com.pojo.LoginResponse;
import com.pojo.MyScheduleBook;
import com.pojo.ScheduleDetails;

@Path("/loadMyBookingDetails")
public class LoadMybookingDetails {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public List<MyScheduleBook> loadScheduleByDate(@FormParam("userID") String userID) {
		
		List<MyScheduleBook> result =null;
		MyScheduleBookDaoServiceImpl sdsi = new MyScheduleBookDaoServiceImpl();
		try {
			
			result = sdsi.featchMyScheduleBookByUserID(userID);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
