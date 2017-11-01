package com.cryptobasket.external.datacontract;

import com.cryptobasket.handler.Response;

public class LoginResponse extends Response {
	private boolean isSucceed;

	public boolean isSucceed() {
		return isSucceed;
	}

	public void setSucceed(boolean isSucceed) {
		this.isSucceed = isSucceed;
	}
}
