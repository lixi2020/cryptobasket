package com.cryptobasket;

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
public class CryptobasketDataApplicationConfig {
	public static void main(String[] args) {
		SpringApplication.run(CryptobasketDataApplicationConfig.class, args);
	}
}
