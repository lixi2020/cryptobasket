package com.cryptobasket.schedule;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cryptobasket.adapter.IMarketDataAdapter;
import com.cryptobasket.helper.DateUtil;
import com.cryptobasket.pojo.Ticker;
import com.cryptobasket.repository.ICryptobasketRepository;

@Component
public class CryptoBasketScheduledTask {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Autowired
	private IMarketDataAdapter marketDataAdapter;
	@Autowired
	private ICryptobasketRepository cryptobasketRepository;

	// @Scheduled(cron = "0 0/1 * * * * ?")
	@Scheduled(cron = "0 0/5 * * * ?")
	public void pullTicker() {
		List<Ticker> tickers = marketDataAdapter.getTickers();

		if (tickers != null) {
			cryptobasketRepository.clearTickerLatest();

			for (Ticker ticker : tickers) {
				cryptobasketRepository.saveTickerLatest(ticker);
			}
		}
		// refresh ticker cache
		cryptobasketRepository.clearTickerCache();
		System.out.println("Ticker Pulled by 5 Mins. " + dateFormat.format(new Date()));
	}

	@Scheduled(cron = "0 0/15 * * * ?")
	public void pullTickerByMin() {
		List<Ticker> tickers = marketDataAdapter.getTickers();

		if (tickers != null) {
			for (Ticker ticker : tickers) {
				cryptobasketRepository.saveTickerByMin(ticker);
			}
		}
		// refresh ticker cache
		cryptobasketRepository.clearTickerCache();
		System.out.println("Ticker Pulled by 15 Mins. " + dateFormat.format(new Date()));
	}

	@Scheduled(cron = "0 0 * * * ?")
	public void pullTickerByHour() {
		List<Ticker> tickers = marketDataAdapter.getTickers();

		if (tickers != null) {
			for (Ticker ticker : tickers) {
				cryptobasketRepository.saveTickerByHour(ticker);
			}
		}
		// refresh ticker cache
		cryptobasketRepository.clearTickerCache();
		System.out.println("Ticker Pulled by 1 Hour." + dateFormat.format(new Date()));
	}

	@Scheduled(cron = "0 0 0 * * ?")
	public void pullTickerByDay() {
		List<Ticker> tickers = marketDataAdapter.getTickers();

		if (tickers != null) {
			for (Ticker ticker : tickers) {
				cryptobasketRepository.saveTickerByDay(ticker);
			}
		}
		// refresh ticker cache
		cryptobasketRepository.clearTickerCache();
		System.out.println("Ticker Pulled by 1 Day." + dateFormat.format(new Date()));
	}

	@Scheduled(cron = "0 3 0 * * ?")
	//@Scheduled(cron = "0 0/2 * * * ?")
	public void updateLast7daysPrice() {
		Date currentDate = new Date(Calendar.getInstance().getTime().getTime());
		List<Ticker> tickers = cryptobasketRepository.getTickersByTimeRange(DateUtil.addDays(currentDate, -7),
				currentDate);
		if (tickers == null || tickers.size() == 0) {
			return;
		}
		// bitcoin: 6000,6500,7500,7000,......,9000
		HashMap<String, String> pricesMap = new HashMap<String, String>();
		for (Ticker ticker : tickers) {
			if (pricesMap.containsKey(ticker.getNameId())) {
				String price = pricesMap.get(ticker.getNameId());
				price += "," + ticker.getPriceUSD();
				pricesMap.put(ticker.getNameId(), price);
			} else {
				pricesMap.put(ticker.getNameId(), ticker.getPriceUSD() + "");
			}
		}
		// save last 7days price into db
		pricesMap.forEach((k, v) -> {
			cryptobasketRepository.update7DayPrice(k, v);
		});

		// refresh ticker cache
		cryptobasketRepository.clearTickerCache();
		System.out.println("ReFresh Last 7 Days Price." + dateFormat.format(new Date()));
	}

	@Scheduled(cron = "0 0 0 1 * ?")
	public void pullTickerByMonth() {
		List<Ticker> tickers = marketDataAdapter.getTickers();

		if (tickers != null) {
			for (Ticker ticker : tickers) {
				cryptobasketRepository.saveTickerByMonth(ticker);
			}
		}
		// refresh ticker cache
		cryptobasketRepository.clearTickerCache();
		System.out.println("Ticker Pulled by 1 Month." + dateFormat.format(new Date()));
	}

}
