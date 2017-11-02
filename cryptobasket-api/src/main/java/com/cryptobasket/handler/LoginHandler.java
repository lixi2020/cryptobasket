package com.cryptobasket.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cryptobasket.constant.StringTool;
import com.cryptobasket.constant.ValidationConstant;
import com.cryptobasket.constant.ValidationErrorConstant;
import com.cryptobasket.constant.ValidationHelper;
import com.cryptobasket.external.datacontract.LoginRequest;
import com.cryptobasket.external.datacontract.LoginResponse;
import com.cryptobasket.pojo.User;
import com.cryptobasket.repository.IUserRepository;

@Component
public class LoginHandler extends Handler<LoginRequest, LoginResponse, OperationData> {
	@Autowired
	private IUserRepository userRepository;

	@Override
	void sanitizeRequest(LoginRequest request, LoginResponse response) {
		if (StringTool.isStringEmptyOrWhiteSpace(request.getPassword())
				|| !ValidationHelper.isMatched(ValidationConstant.passwordReg, request.getPassword())) {
			ValidationHelper.addValidationError(response, ValidationErrorConstant.NO_USER_FOUND_CODE,
					ValidationErrorConstant.NO_USER_FOUND_MESSAGE);
			return;
		}

		if (StringTool.isStringEmptyOrWhiteSpace(request.getEmail())
				|| !ValidationHelper.isMatched(ValidationConstant.emailReg, request.getEmail())) {
			ValidationHelper.addValidationError(response, ValidationErrorConstant.NO_USER_FOUND_CODE,
					ValidationErrorConstant.NO_USER_FOUND_MESSAGE);
			return;
		}
	}

	@Override
	void validateRequest(LoginRequest request, LoginResponse response) {
		User user = userRepository.getUserByUsernameOrEmail(null, request.getEmail());
		if (user == null || !user.getPassword().equals(request.getPassword())) {
			ValidationHelper.addValidationError(response, ValidationErrorConstant.NO_USER_FOUND_CODE,
					ValidationErrorConstant.NO_USER_FOUND_MESSAGE);
		}
	}

	@Override
	void processRequest(LoginRequest request, LoginResponse response) {
		// log login time stamp?
		response.setSucceed(true);
	}

}
