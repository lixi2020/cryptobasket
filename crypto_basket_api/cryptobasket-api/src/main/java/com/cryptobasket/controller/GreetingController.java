package com.cryptobasket.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cryptobasket.pojo.CryptoMeta;
import com.cryptobasket.pojo.Greeting;
import com.cryptobasket.repository.mapper.CryptoMapper;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private CryptoMapper cryptoMapper;

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@RequestMapping("/bye")
	public Greeting bye() {
		CryptoMeta testMeta = cryptoMapper.getCryptoMetaByNameId("Mr-Eko");
		return new Greeting(counter.incrementAndGet(), String.format(template, testMeta.getName()));
	}

}
