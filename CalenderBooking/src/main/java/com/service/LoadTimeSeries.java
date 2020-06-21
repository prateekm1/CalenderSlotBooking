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
import com.dao.TimeSeriesServiceImpl;
import com.pojo.LoginRequest;
import com.pojo.LoginResponse;
import com.pojo.ScheduleTimeSeries;
import com.pojo.User;

@Path("/loadTimeSeriesById")
public class LoadTimeSeries {

	@POST
    @Produces(MediaType.APPLICATION_JSON)
	public List<ScheduleTimeSeries> getCountries(@FormParam("id") String id)
	{
		List<ScheduleTimeSeries> resultSet = null;
		TimeSeriesServiceImpl tst = new TimeSeriesServiceImpl();
		try {
			resultSet = tst.loadTimeSeriesDatById(Integer.parseInt(id));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return resultSet;
    	
		
	}

}
