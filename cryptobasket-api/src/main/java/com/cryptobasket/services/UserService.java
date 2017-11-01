package com.cryptobasket.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cryptobasket.external.datacontract.LoginRequest;
import com.cryptobasket.external.datacontract.LoginResponse;
import com.cryptobasket.external.datacontract.RegisterRequest;
import com.cryptobasket.external.datacontract.RegisterResponse;
import com.cryptobasket.handler.LoginHandler;
import com.cryptobasket.handler.RegisterHandler;

@Service
public class UserService implements IUserService {

	@Autowired
	private RegisterHandler registerHandler;
	
	@Autowired
	private LoginHandler loginHandler;

	@Override
	public RegisterResponse register(RegisterRequest request) {
		RegisterResponse resp = null;
		try {
			resp=registerHandler.excute(request, null);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resp;
	}

	@Override
	public LoginResponse login(LoginRequest request) {
		LoginResponse resp=null;
		try {
			resp=loginHandler.excute(request, null);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resp;
	}
	
	

}
