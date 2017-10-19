package com.cryptobasket.web.crawler;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.cryptobasket.adapter.datacontract.ExternalTicker;
import com.cryptobasket.pojo.CryptoMeta;
import com.cryptobasket.repository.mapper.CryptoMapper;

@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CrawCoinMeta {

	@Autowired
	private CryptoMapper cryptoMapper;

	@Test
	public void insertCoinMeta() {
		RestTemplate restTemplate = new RestTemplate();
		ExternalTicker[] tickers = restTemplate.getForObject("https://api.coinmarketcap.com/v1/ticker/", ExternalTicker[].class);

		for (ExternalTicker ticker : tickers) {
			CryptoMeta testMeta = new CryptoMeta();
			testMeta.setName(ticker.getName());
			testMeta.setSymbol(ticker.getSymbol());
			testMeta.setNameId(ticker.getId());
			testMeta.setCreateTime(new Timestamp(new Date().getTime()));
			cryptoMapper.insertCryptoMeta(testMeta);
		}

		System.out.println("Total Coins Added:" + tickers.length);

	}

}
