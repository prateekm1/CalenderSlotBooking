package com.dao;

import com.pojo.LoginResponse;

public interface LoginDaoService {

	public LoginResponse loginDtls(String usr, String pass);
}
