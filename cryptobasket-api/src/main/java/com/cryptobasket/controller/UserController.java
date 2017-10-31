package com.cryptobasket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cryptobasket.external.datacontract.RegisterRequest;
import com.cryptobasket.external.datacontract.RegisterResponse;
import com.cryptobasket.services.IUserService;

@RestController
@CrossOrigin(origins = "http://localhost:8008")
public class UserController {

	@Autowired
	private IUserService userService;

	@RequestMapping("/user/register")
	public RegisterResponse register(@ModelAttribute RegisterRequest request) {
		System.out.println(request.toString());
		return null;
	}
}
