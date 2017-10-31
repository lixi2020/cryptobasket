package com.cryptobasket.repository.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cryptobasket.pojo.User;

public interface UserMapper {
	@Select("SELECT userId,username,password,email,phone,UPPER(status) FROM crypto_basket.crypto_user WHERE username=#{username};")
	User getUserByUserName(String username);

	@Select("SELECT status FROM crypto_basket.crypto_user WHERE username=#{username};")
	String getUserStatus(String username);

	@Insert("INSERT INTO crypto_basket.crypto_user (username,password,email,status) VALUES(#{username},#{password},#{email}),'PENDING'")
	void insertUser(User user);

	@Update("UPDATE crypto_basket.crypto_user SET status=#{status} WHERE username=#{username}")
	void updateUserStatus(String username, String status);
}
