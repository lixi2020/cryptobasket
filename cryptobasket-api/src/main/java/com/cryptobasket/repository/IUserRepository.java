package com.cryptobasket.repository;

import com.cryptobasket.pojo.User;
import com.cryptobasket.pojo.UserStatus;

public interface IUserRepository {
	void insertUser(User user);
	void updateUserStatus(String username,UserStatus status);
	UserStatus getUserStatus(String username);
	public User getUserByUsernameOrEmail(String username, String email);
}
