package com.cryptobasket.repository;

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
	private CryptoMapper CryptoMapper;

	@Override
	public void saveCryptoMeta(CryptoMeta cryptoMeta) {
		CryptoMapper.insertCryptoMeta(cryptoMeta);
	}

	@Override
	public void getCryptoMetaByNameId(String nameId) {
		CryptoMapper.getCryptoMetaByNameId(nameId);
	}

	@Override
	@CacheEvict(cacheNames = "Ticker", allEntries = true)
	public void saveTickerLatest(Ticker ticker) {
		CryptoMapper.insertTickerLatest(ticker);
	}

	@Override
	@CacheEvict(cacheNames = "Ticker", allEntries = true)
	public void saveTickerByMin(Ticker ticker) {
		CryptoMapper.insertTickerByMin(ticker);
	}

	@Override
	@CacheEvict(cacheNames = "Ticker", allEntries = true)
	public void saveTickerByHour(Ticker ticker) {
		CryptoMapper.insertTickerByHour(ticker);
	}

	@Override
	@CacheEvict(cacheNames = "Ticker", allEntries = true)
	public void saveTickerByDay(Ticker ticker) {
		CryptoMapper.insertTickerByDay(ticker);
	}

	@Override
	@CacheEvict(cacheNames = "Ticker", allEntries = true)
	public void saveTickerByMonth(Ticker ticker) {
		CryptoMapper.insertTickerByMonth(ticker);
	}

	@Override
	public void clearTickerLatest() {
		CryptoMapper.clearTickerLatest();
	}

	@Override
	@Cacheable("Ticker")
	public List<Ticker> getTickers(int pageOffset, int pageSize) {
		return CryptoMapper.getLatestTickers(pageOffset, pageSize);
	}
}
