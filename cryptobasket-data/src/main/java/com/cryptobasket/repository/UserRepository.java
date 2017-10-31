package com.cryptobasket.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cryptobasket.constant.StringTool;
import com.cryptobasket.pojo.User;
import com.cryptobasket.pojo.UserStatus;
import com.cryptobasket.repository.mapper.UserMapper;

@Repository
public class UserRepository implements IUserRepository {
	@Autowired
	private UserMapper userMapper;

	@Override
	public UserStatus getUserStatus(String username) {
		String userStatus = userMapper.getUserStatus(username);
		if (!StringTool.isStringEmptyOrWhiteSpace(userStatus)) {
			return UserStatus.valueOf(userStatus);
		}
		return UserStatus.BLOCKED;
	}

	@Override
	public void insertUser(User user) {
		userMapper.insertUser(user);
	}

	@Override
	public void updateUserStatus(String username, UserStatus status) {
		userMapper.updateUserStatus(username, status.toString());
	}

	@Override
	public User getUserByUsername(String username) {
		return userMapper.getUserByUserName(username);
	}

}
