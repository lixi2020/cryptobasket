package com.cryptobasket.adapter;

import java.util.List;

import com.cryptobasket.pojo.Ticker;

public interface IMarketDataAdapter {
	List<Ticker> getTickers();
}
