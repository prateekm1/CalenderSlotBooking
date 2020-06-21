package com.util;

public interface ValidateUser {

	public String loginUserRetunToken(String usr, String pass);
	public boolean validateUserName(String usr);
	public boolean validateUserPassword(String usr);
	public boolean validateUserexistance(String usr);
}
