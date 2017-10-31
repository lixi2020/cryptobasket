package com.cryptobasket.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cryptobasket.external.datacontract.RegisterRequest;
import com.cryptobasket.external.datacontract.RegisterResponse;
import com.cryptobasket.handler.RegisterHandler;

@Service
public class UserService implements IUserService {

	@Autowired
	private RegisterHandler registerHandler;

	@Override
	public RegisterResponse register(RegisterRequest request) {
		RegisterResponse resp = null;
		try {
			registerHandler.excute(request, null);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resp;
	}

}
