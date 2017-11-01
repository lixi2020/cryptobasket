package com.cryptobasket.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cryptobasket.constant.StringTool;
import com.cryptobasket.constant.ValidationConstant;
import com.cryptobasket.constant.ValidationErrorConstant;
import com.cryptobasket.constant.ValidationHelper;
import com.cryptobasket.external.datacontract.RegisterRequest;
import com.cryptobasket.external.datacontract.RegisterResponse;
import com.cryptobasket.pojo.User;
import com.cryptobasket.repository.IUserRepository;

@Component
public class RegisterHandler extends Handler<RegisterRequest, RegisterResponse, OperationData> {

	@Autowired
	private IUserRepository userRepository;

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
		User user = userRepository.getUserByUsernameOrEmail(request.getUsername(), request.getEmail());
		if (user != null) {
			if (user.getUsername().equals(request.getUsername())) {
				ValidationHelper.addValidationError(response, ValidationErrorConstant.USERNAME_ALREADY_IN_USE_CODE,
						ValidationErrorConstant.USERNAME_ALREADY_IN_USE_MESSAGE);
			}
			if (user.getEmail().equals(request.getEmail())) {
				ValidationHelper.addValidationError(response, ValidationErrorConstant.EMAIL_ALREADY_IN_USE_CODE,
						ValidationErrorConstant.EMAIL_ALREADY_IN_USE_MESSAGE);
			}
		}
	}

	@Override
	void processRequest(RegisterRequest request, RegisterResponse response) {
		// Save User into DB
		User user = new User();
		user.setUsername(request.getUsername());
		user.setPassword(request.getPassword());
		user.setEmail(request.getEmail());
		userRepository.insertUser(user);
		// Send Email Address Verification
		response.setSucceed(true);
	}

}
