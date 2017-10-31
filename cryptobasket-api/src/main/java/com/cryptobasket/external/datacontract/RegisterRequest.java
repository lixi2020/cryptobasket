package com.cryptobasket.external.datacontract;

import com.cryptobasket.handler.Request;

public class RegisterRequest extends Request {
	private String username;
	private String password;
	private String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "RegisterRequest [username=" + username + ", password=" + password + ", email=" + email + "]";
	}

}
