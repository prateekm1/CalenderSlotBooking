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
import com.pojo.LoginRequest;
import com.pojo.LoginResponse;
import com.pojo.User;

@Path("/login")
public class LoginService {
	@POST
    @Produces(MediaType.APPLICATION_JSON)
	public List<LoginResponse> getCountries(@FormParam("param1") String user,
            @FormParam("param2") String pass)
	{
		List<LoginResponse> loginResponse = new ArrayList<LoginResponse>();
		LoginResponse lr = new LoginResponse();
		
		RegisterUserDaoServiceImpl regDao = new RegisterUserDaoServiceImpl();
		User UserDtl = new User();
		
    	System.out.println(user);
    	LoginRequest logReq =  new LoginRequest();
    	
    	if(!user.equals("") && !pass.equals("") ) {
    		
    		UserDtl = regDao.fetchUserDetailsByUserIdPassword(user, pass);
    		if(UserDtl!=null && UserDtl.getName()!=null && UserDtl.getUserSyatemId() !=null) {
    			lr.setStatus("sucess");
        		lr.setToken("gjsagfgsjafgjasgfjagsfafasfa");
        		lr.setUserSyatemId(UserDtl.getUserSyatemId());
        		lr.setUserName(UserDtl.getUserName());
        		lr.setUsrNsame(UserDtl.getName());
        		lr.setUserType(UserDtl.getUsrType());
        		lr.setData("Sucessfully Login");
        		loginResponse.add(lr);
        		return loginResponse;
    			
    		}else {
    			lr.setStatus("fail");
        		lr.setData("User name and password Not Valid");
        		loginResponse.add(lr);
        		return loginResponse;
    		}
    	}else {
    		lr.setStatus("fail");
    		lr.setToken("");
    		lr.setData("User name and password should not blank");
    		loginResponse.add(lr);
    		return loginResponse;
    	}
    	
		
	}

}
