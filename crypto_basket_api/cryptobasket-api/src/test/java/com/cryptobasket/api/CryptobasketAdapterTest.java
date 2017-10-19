package com.cryptobasket.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.cryptobasket.adapter.datacontract.ExternalTicker;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CryptobasketAdapterTest {

	@Test
	public void exampleTest() {
		RestTemplate restTemplate = new RestTemplate();
		ExternalTicker[] tickers = restTemplate.getForObject("https://api.coinmarketcap.com/v1/ticker/?limit=10",
				ExternalTicker[].class);
		System.out.println(tickers[0].toString());
	}

}