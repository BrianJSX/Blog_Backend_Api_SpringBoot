package com.javamaster.springsecurityjwt.controller;

import lombok.Data;

@Data
public class AuthRequest {
    public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String login;
    private String password;
}
