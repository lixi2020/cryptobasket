package com.cryptobasket.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import com.cryptobasket.pojo.Ticker;
import com.cryptobasket.repository.mapper.CryptoMapper;

@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CryptobasketDAOTest {

	@Autowired
	private CryptoMapper cryptoMapper;

	@Test
	public void insertTicker() {
		Ticker ticker = new Ticker();
		ticker.setAvailableSupply(new BigDecimal(1));
		ticker.setLastUpdateTime(new Timestamp(System.currentTimeMillis()));
		ticker.setMarketCapUSD(new BigDecimal(2000));
		ticker.setNameId("test");
		ticker.setPercentChange1h(new BigDecimal(28.2));
		ticker.setPercentChange24h(new BigDecimal(22));
		ticker.setPercentChange7d(new BigDecimal(1222));
		ticker.setPriceBTC(new BigDecimal(0.00002));
		ticker.setPriceUSD(new BigDecimal(123));
		ticker.setRank(1);
		ticker.setTotalSupply(new BigDecimal(2323));
		ticker.setVolume24hUSD(new BigDecimal(232323));
		cryptoMapper.insertTickerLatest(ticker);
	}

	@Test
	public void insertTickerMin() {
		Ticker ticker = new Ticker();
		ticker.setAvailableSupply(new BigDecimal(1));
		ticker.setLastUpdateTime(new Timestamp(System.currentTimeMillis()));
		ticker.setMarketCapUSD(new BigDecimal(2000));
		ticker.setNameId("test");
		ticker.setPercentChange1h(new BigDecimal(28.2));
		ticker.setPercentChange24h(new BigDecimal(22));
		ticker.setPercentChange7d(new BigDecimal(1222));
		ticker.setPriceBTC(new BigDecimal(0.00002));
		ticker.setPriceUSD(new BigDecimal(123));
		ticker.setRank(1);
		ticker.setTotalSupply(new BigDecimal(2323));
		ticker.setVolume24hUSD(new BigDecimal(232323));
		cryptoMapper.insertTickerByMin(ticker);
	}

	@Test
	public void insertTickerHour() {
		Ticker ticker = new Ticker();
		ticker.setAvailableSupply(new BigDecimal(1));
		ticker.setLastUpdateTime(new Timestamp(System.currentTimeMillis()));
		ticker.setMarketCapUSD(new BigDecimal(2000));
		ticker.setNameId("test");
		ticker.setPercentChange1h(new BigDecimal(28.2));
		ticker.setPercentChange24h(new BigDecimal(22));
		ticker.setPercentChange7d(new BigDecimal(1222));
		ticker.setPriceBTC(new BigDecimal(0.00002));
		ticker.setPriceUSD(new BigDecimal(123));
		ticker.setRank(1);
		ticker.setTotalSupply(new BigDecimal(2323));
		ticker.setVolume24hUSD(new BigDecimal(232323));
		cryptoMapper.insertTickerByHour(ticker);
	}

	@Test
	public void insertTickerDay() {
		Ticker ticker = new Ticker();
		ticker.setAvailableSupply(new BigDecimal(1));
		ticker.setLastUpdateTime(new Timestamp(System.currentTimeMillis()));
		ticker.setMarketCapUSD(new BigDecimal(2000));
		ticker.setNameId("test");
		ticker.setPercentChange1h(new BigDecimal(28.2));
		ticker.setPercentChange24h(new BigDecimal(22));
		ticker.setPercentChange7d(new BigDecimal(1222));
		ticker.setPriceBTC(new BigDecimal(0.00002));
		ticker.setPriceUSD(new BigDecimal(123));
		ticker.setRank(1);
		ticker.setTotalSupply(new BigDecimal(2323));
		ticker.setVolume24hUSD(new BigDecimal(232323));
		cryptoMapper.insertTickerByDay(ticker);
	}

	@Test
	public void insertTickerMonth() {
		Ticker ticker = new Ticker();
		ticker.setAvailableSupply(new BigDecimal(1));
		ticker.setLastUpdateTime(new Timestamp(System.currentTimeMillis()));
		ticker.setMarketCapUSD(new BigDecimal(2000));
		ticker.setNameId("test");
		ticker.setPercentChange1h(new BigDecimal(28.2));
		ticker.setPercentChange24h(new BigDecimal(22));
		ticker.setPercentChange7d(new BigDecimal(1222));
		ticker.setPriceBTC(new BigDecimal(0.00002));
		ticker.setPriceUSD(new BigDecimal(123));
		ticker.setRank(1);
		ticker.setTotalSupply(new BigDecimal(2323));
		ticker.setVolume24hUSD(new BigDecimal(232323));
		cryptoMapper.insertTickerByMonth(ticker);
	}

}
