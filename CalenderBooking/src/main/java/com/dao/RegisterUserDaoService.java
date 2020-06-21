package com.dao;

import java.util.HashMap;

import com.pojo.User;

public interface RegisterUserDaoService {

	public boolean registerNewUser(String userName,String eamil,String address, String name,String password, String usrType);
	public User fetchUserDetailsByUserIdPassword(String userName, String pass);
	public Integer checkUseIsExistsbyUserName(String userName);
}
