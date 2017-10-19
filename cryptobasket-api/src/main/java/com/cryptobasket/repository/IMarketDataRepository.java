package com.cryptobasket.repository;

import java.util.List;

import com.cryptobasket.pojo.CryptoMeta;
import com.cryptobasket.pojo.Ticker;

public interface IMarketDataRepository {
	public void getCryptoMetaByNameId(String nameId);

	public List<Ticker> getTickers(int pageOffset, int pageSize);
}
