package com.cryptobasket.api;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;

import com.cryptobasket.pojo.CryptoMeta;
import com.cryptobasket.pojo.Ticker;
import com.cryptobasket.repository.mapper.MarketDataMapper;

@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CryptobasketDAOTest {

	@Autowired
	private MarketDataMapper marketDataMapper;

	@Test
	public void getTickers() {
		List<Ticker> tickers = marketDataMapper.getLatestTickers(0, 100);
		assertThat(tickers.size() > 0);
	}

}
