package com.cryptobasket.handler;

import com.cryptobasket.constant.StringTool;
import com.cryptobasket.constant.ValidationConstant;
import com.cryptobasket.constant.ValidationErrorConstant;
import com.cryptobasket.constant.ValidationHelper;
import com.cryptobasket.external.datacontract.EnrollOperationData;
import com.cryptobasket.external.datacontract.RegisterRequest;
import com.cryptobasket.external.datacontract.RegisterResponse;

public class RegisterHandler extends Handler<RegisterRequest, RegisterResponse, EnrollOperationData> {
	@Override
	void sanitizeRequest(RegisterRequest request, RegisterResponse response) {
		if (StringTool.isStringEmptyOrWhiteSpace(request.getUsername())
				|| !ValidationHelper.isMatched(ValidationConstant.usernameReg, request.getUsername())) {
			ValidationHelper.addValidationError(response, ValidationErrorConstant.INVALID_USERNAME_ERROR_CODE,
					ValidationErrorConstant.INVALID_USERNAME_ERROR_MESSAGE);
		}

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
	void validateRequest(RegisterRequest request, RegisterResponse response) {
		// Validate User Existence
	}

	@Override
	void processRequest(RegisterRequest request, RegisterResponse response) {
		// Save User into DB

		// Send Email Address Verification

		response.setSucceed(true);
	}

}
