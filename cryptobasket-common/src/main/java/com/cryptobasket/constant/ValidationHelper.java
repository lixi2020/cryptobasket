package com.cryptobasket.constant;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cryptobasket.external.datacontract.ValidationError;
import com.cryptobasket.handler.Response;

public class ValidationHelper {
	public static boolean isMatched(String pattern, String str) {
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(str);
		return m.matches();
	}

	public static void addValidationError(Response resp, String errorCode, String errorMsg) {
		if (resp.getErrors() == null) {
			resp.setErrors(new ArrayList<ValidationError>());
		}
		ValidationError validationError = new ValidationError(errorCode, errorMsg);
		resp.getErrors().add(validationError);
	}
}
