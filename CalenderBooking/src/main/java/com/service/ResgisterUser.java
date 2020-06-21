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

@Path("/registerUser")
public class ResgisterUser {
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> registerNewUser(@FormParam("userName") String userName, @FormParam("eamil") String eamil,
			@FormParam("address") String address, @FormParam("name") String name,
			@FormParam("password") String password, @FormParam("usrType") String usrType) {
		List<String> loginResponse = new ArrayList<String>();
		Integer userRecord = 0;
		try {

			LoginResponse lr = new LoginResponse();
			System.out.println("Reguser call");
			RegisterUserDaoServiceImpl obj = new RegisterUserDaoServiceImpl();
			userRecord = obj.checkUseIsExistsbyUserName(userName);
			if (userRecord == 0) {

				boolean status = obj.registerNewUser(userName, eamil, address, name, password, usrType);
				if (status) {
					loginResponse.add("User sucessfully created");
					return loginResponse;
				}
				{
					loginResponse.add("User Creation fail");
					return loginResponse;
				}
			} else {
				loginResponse.add("User Name Already Exists");
				return loginResponse;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		loginResponse.add("User Creation fail");
		return loginResponse;
	}

}
