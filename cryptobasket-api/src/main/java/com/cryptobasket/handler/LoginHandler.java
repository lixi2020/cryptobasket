package com.cryptobasket.handler;

import org.springframework.stereotype.Component;

import com.cryptobasket.constant.StringTool;
import com.cryptobasket.constant.ValidationConstant;
import com.cryptobasket.constant.ValidationErrorConstant;
import com.cryptobasket.constant.ValidationHelper;
import com.cryptobasket.external.datacontract.LoginRequest;
import com.cryptobasket.external.datacontract.LoginResponse;

@Component
public class LoginHandler extends Handler<LoginRequest, LoginResponse, OperationData> {

	@Override
	void sanitizeRequest(LoginRequest request, LoginResponse response) {
		if (StringTool.isStringEmptyOrWhiteSpace(request.getPassword())
				|| !ValidationHelper.isMatched(ValidationConstant.passwordReg, request.getPassword())) {
			ValidationHelper.addValidationError(response, ValidationErrorConstant.INVALID_PASSWORD_ERROR_CODE,
					ValidationErrorConstant.INVALID_PASSWORD_ERROR_MESSAGE);
		}

		if (StringTool.isStringEmptyOrWhiteSpace(request.getEmail())
				|| !ValidationHelper.isMatched(ValidationConstant.emailReg, request.getEmail())) {
			ValidationHelper.addValidationError(response, ValidationErrorConstant.INVALID_EMAIL_ERROR_CODE,
					ValidationErrorConstant.INVALID_EMAIL_ERROR_MESSAGE);
		}
	}

	@Override
	void validateRequest(LoginRequest request, LoginResponse response) {
		// TODO Auto-generated method stub
	}

	@Override
	void processRequest(LoginRequest request, LoginResponse response) {
		response.setSucceed(true);
	}

}
