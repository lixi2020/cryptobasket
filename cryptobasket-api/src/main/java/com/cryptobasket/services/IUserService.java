package com.cryptobasket.services;

import com.cryptobasket.external.datacontract.RegisterRequest;
import com.cryptobasket.external.datacontract.RegisterResponse;

public interface IUserService {
	RegisterResponse register(RegisterRequest request);

}
