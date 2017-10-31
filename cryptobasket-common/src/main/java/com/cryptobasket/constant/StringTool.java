package com.cryptobasket.constant;

public class StringTool {
	public static boolean isStringEmptyOrWhiteSpace(String str) {
		if (str == null || str.isEmpty() || str.equals("")) {
			return true;
		}
		return false;
	}
}
