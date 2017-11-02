package com.cryptobasket.external.datacontract;

import com.cryptobasket.handler.Response;

public class ValidationErrorHelper {
	public static boolean isContainAnyError(Response response) {
		if (response != null) {
			if (response.getErrors() != null && response.getErrors().size() > 0) {
				return true;
			}
		}
		return false;
	}
}
