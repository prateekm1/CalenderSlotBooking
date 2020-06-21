package com.pojo;

public class LoginResponse {
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	private String token;
	private String status;
	private String data;
	private String usrNsame;
	private String userType;
	private Integer userSyatemId;
	private String userName;
	public Integer getUserSyatemId() {
		return userSyatemId;
	}
	public void setUserSyatemId(Integer userSyatemId) {
		this.userSyatemId = userSyatemId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUsrNsame() {
		return usrNsame;
	}
	public void setUsrNsame(String usrNsame) {
		this.usrNsame = usrNsame;
	}

}
