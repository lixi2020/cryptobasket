package com.cryptobasket.external.datacontract;

public class ValidationErrorHelper {
	public static boolean isContainAnyError(Response response) {
		if (response != null) {
			if (response.getErros() != null && response.getErros().size() > 0) {
				return true;
			}
		}
		return false;
	}
}
