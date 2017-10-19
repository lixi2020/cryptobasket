package com.cryptobasket.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.cryptobasket.pojo.Ticker;
import com.cryptobasket.repository.mapper.CryptoMapper;

@Repository
public class MarketDataRepository implements IMarketDataRepository {
	@Autowired
	private CryptoMapper CryptoMapper;

	@Override
	public void getCryptoMetaByNameId(String nameId) {
		CryptoMapper.getCryptoMetaByNameId(nameId);
	}

	@Override
	@Cacheable("Ticker")
	public List<Ticker> getTickers(int pageOffset, int pageSize) {
		return CryptoMapper.getLatestTickers(pageOffset, pageSize);
	}
}
