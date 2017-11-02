package com.cryptobasket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cryptobasket.external.datacontract.LoginRequest;
import com.cryptobasket.external.datacontract.LoginResponse;
import com.cryptobasket.external.datacontract.RegisterRequest;
import com.cryptobasket.external.datacontract.RegisterResponse;
import com.cryptobasket.services.IUserService;

@RestController
public class UserController {
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public RegisterResponse register(@RequestBody RegisterRequest request) {
		System.out.println(request.toString());
		return userService.register(request);
	}

	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public LoginResponse login(@RequestBody LoginRequest request) {
		System.out.println(request.toString());
		return userService.login(request);
	}
}
