package com.cryptobasket.repository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.cryptobasket.pojo.CryptoMeta;
import com.cryptobasket.pojo.Ticker;
import com.cryptobasket.repository.mapper.CryptoMapper;

@Repository
public class CryptobasketRepository implements ICryptobasketRepository {
	@Autowired
	private CryptoMapper cryptoMapper;

	@Override
	public void saveCryptoMeta(CryptoMeta cryptoMeta) {
		cryptoMapper.insertCryptoMeta(cryptoMeta);
	}

	@Override
	public void getCryptoMetaByNameId(String nameId) {
		cryptoMapper.getCryptoMetaByNameId(nameId);
	}

	@Override
	public void saveTickerLatest(Ticker ticker) {
		cryptoMapper.insertTickerLatest(ticker);
	}

	@Override
	public void saveTickerByMin(Ticker ticker) {
		cryptoMapper.insertTickerByMin(ticker);
	}

	@Override
	public void saveTickerByHour(Ticker ticker) {
		cryptoMapper.insertTickerByHour(ticker);
	}

	@Override
	public void saveTickerByDay(Ticker ticker) {
		cryptoMapper.insertTickerByDay(ticker);
	}

	@Override
	public void saveTickerByMonth(Ticker ticker) {
		cryptoMapper.insertTickerByMonth(ticker);
	}

	@Override
	public void clearTickerLatest() {
		cryptoMapper.clearTickerLatest();
	}

	@CacheEvict(cacheNames = "Ticker", allEntries = true)
	public void clearTickerCache() {
	}

	@Override
	@Cacheable("Ticker")
	public List<Ticker> getTickers(int pageOffset, int pageSize) {
		return cryptoMapper.getLatestTickers(pageOffset, pageSize);
	}

	@Override
	public List<Ticker> getTickersByTimeRange(Date startDate, Date endDate) {
		return cryptoMapper.getTickersByTimeRange(startDate, endDate);
	}

	@Override
	public void update7DayPrice(String nameId, String last7dayPrice) {
		cryptoMapper.updateLast7daysPrice(nameId, last7dayPrice);
	}

}
