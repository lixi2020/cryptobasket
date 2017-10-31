package com.cryptobasket.external.datacontract;

import com.cryptobasket.handler.Response;

public class RegisterResponse extends Response {
	private boolean isSucceed = false;

	public boolean isSucceed() {
		return isSucceed;
	}

	public void setSucceed(boolean isSucceed) {
		this.isSucceed = isSucceed;
	}

}
