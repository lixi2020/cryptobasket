package com.cryptobasket.services;

import com.cryptobasket.external.datacontract.LoginRequest;
import com.cryptobasket.external.datacontract.LoginResponse;
import com.cryptobasket.external.datacontract.RegisterRequest;
import com.cryptobasket.external.datacontract.RegisterResponse;

public interface IUserService {
	RegisterResponse register(RegisterRequest request);

	LoginResponse login(LoginRequest request);

}
