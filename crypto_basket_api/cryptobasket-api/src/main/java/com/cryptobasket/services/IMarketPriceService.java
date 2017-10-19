package com.cryptobasket.services;

import java.util.List;

import com.cryptobasket.pojo.Ticker;

public interface IMarketPriceService {
	public List<Ticker> getTickers(int pageOffset, int pageSize);
}
