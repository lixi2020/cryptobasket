package com.cryptobasket.repository;

import java.util.List;

import com.cryptobasket.pojo.CryptoMeta;
import com.cryptobasket.pojo.Ticker;

public interface ICryptobasketRepository {

	public void saveCryptoMeta(CryptoMeta cryptoMeta);

	public void getCryptoMetaByNameId(String nameId);

	public void clearTickerLatest();
	
	public void saveTickerLatest(Ticker ticker);

	public void saveTickerByMin(Ticker ticker);

	public void saveTickerByHour(Ticker ticker);

	public void saveTickerByDay(Ticker ticker);

	public void saveTickerByMonth(Ticker ticker);
	
	public List<Ticker> getTickers(int pageOffset, int pageSize);
}
