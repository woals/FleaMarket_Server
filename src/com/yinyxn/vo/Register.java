package com.yinyxn.vo;

public class Register {

	private int id;
	private String name;
	private String password;
	private String phone;
	private String time;
	
	public Register() {
	}

	public Register(String name, String password, String phone,
			String time) {
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}
