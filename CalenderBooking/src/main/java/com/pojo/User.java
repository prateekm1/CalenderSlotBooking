package com.pojo;

public class User {
	private Integer userSyatemId;
	private String userName;
	private String eamil;
	private String address;
	private String name;
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
	public String getEamil() {
		return eamil;
	}
	public void setEamil(String eamil) {
		this.eamil = eamil;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsrType() {
		return usrType;
	}
	public void setUsrType(String usrType) {
		this.usrType = usrType;
	}
	private String password;
	private String usrType;
}
