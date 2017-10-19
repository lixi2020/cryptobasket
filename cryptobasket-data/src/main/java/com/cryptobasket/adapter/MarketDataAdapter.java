package com.cryptobasket.adapter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cryptobasket.adapter.datacontract.ExternalTicker;
import com.cryptobasket.constant.CryptoConstant;
import com.cryptobasket.pojo.Ticker;

@Component
public class MarketDataAdapter implements IMarketDataAdapter {

	@Override
	public List<Ticker> getTickers() {
		RestTemplate restTemplate = new RestTemplate();
		ExternalTicker[] externalTickers = restTemplate.getForObject(CryptoConstant.COINMARKETCAP_TICKER_URL,
				ExternalTicker[].class);
		List<Ticker> tickers = null;
		if (externalTickers != null) {
			tickers = new ArrayList<>();
			for (ExternalTicker externalTicker : externalTickers) {
				tickers.add(mapExternalTickerToInternalTicker(externalTicker));
			}
		}

		return tickers;
	}

	private Ticker mapExternalTickerToInternalTicker(ExternalTicker externalTicker) {
		Ticker ticker = new Ticker();
		ticker.setCreateTime(externalTicker.getLast_updated());
		ticker.setAvailableSupply(externalTicker.getAvailable_supply());
		ticker.setMarketCapUSD(externalTicker.getMarket_cap_usd());
		ticker.setNameId(externalTicker.getId());
		ticker.setPercentChange1h(externalTicker.getPercent_change_1h());
		ticker.setPercentChange24h(externalTicker.getPercent_change_24h());
		ticker.setPercentChange7d(externalTicker.getPercent_change_7d());
		ticker.setPriceBTC(externalTicker.getPrice_btc());
		ticker.setPriceUSD(externalTicker.getPrice_usd());
		ticker.setRank(externalTicker.getRank());
		ticker.setTotalSupply(externalTicker.getAvailable_supply());
		ticker.setVolume24hUSD(externalTicker.get_24h_volume_usd());
		return ticker;
	}

}
