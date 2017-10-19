package com.cryptobasket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cryptobasket.pojo.Ticker;
import com.cryptobasket.repository.ICryptobasketRepository;

@Service
public class MarketPriceService implements IMarketPriceService {

	@Autowired
	private ICryptobasketRepository cryptobasketRepository;

	@Override
	public List<Ticker> getTickers(int pageOffset, int pageSize) {
		if (pageOffset >= 0 && pageSize > 0) {
			return cryptobasketRepository.getTickers(pageOffset, pageSize);
		}
		return null;
	}

}
