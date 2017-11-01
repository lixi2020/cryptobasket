package com.cryptobasket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cryptobasket.pojo.Ticker;
import com.cryptobasket.services.IMarketPriceService;

@RestController
public class MarketController {

	@Autowired
	private IMarketPriceService marketPriceService;

	@RequestMapping("/ticker")
	public List<Ticker> getMarketTickers(@RequestParam(value = "pageOffset", defaultValue = "0") int pageOffset,
			@RequestParam(value = "pageSize", defaultValue = "100") int pageSize) {
		System.out.println("pageOffset:" + pageOffset + " pageSize:" + pageSize);
		return marketPriceService.getTickers(pageOffset, pageSize);
	}
}
