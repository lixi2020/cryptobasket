package com.cryptobasket.constant;

public class ValidationConstant {
	public static final String usernameReg = "^(?=.{6,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";
	public static final String passwordReg = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,30}$";
	public static final String emailReg = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
}
