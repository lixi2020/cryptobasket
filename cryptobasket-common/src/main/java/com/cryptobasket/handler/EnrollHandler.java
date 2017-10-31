package com.cryptobasket.handler;

import com.cryptobasket.external.datacontract.EnrollOperationData;
import com.cryptobasket.external.datacontract.RegisterRequest;
import com.cryptobasket.external.datacontract.RegisterResponse;

public class EnrollHandler extends Handler<RegisterRequest, RegisterResponse, EnrollOperationData> {

	@Override
	void validateRequest(RegisterRequest request, RegisterResponse response) {
		// TODO Auto-generated method stub
	}

	@Override
	void processRequest(RegisterRequest request, RegisterResponse response) {
		// TODO Auto-generated method stub
		response.setSucceed(true);
	}

	@Override
	public String toString() {
		return "EnrollHandler []";
	}

}
