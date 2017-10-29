package com.cryptobasket;

import java.util.TimeZone;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = "com.cryptobasket")
@MapperScan("com.cryptobasket.repository.mapper")
@EnableScheduling
@EnableCaching
public class CryptobasketAPIApplicationConfig {
	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		SpringApplication.run(CryptobasketAPIApplicationConfig.class, args);
	}
}
