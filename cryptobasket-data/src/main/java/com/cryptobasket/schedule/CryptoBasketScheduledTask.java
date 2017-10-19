package com.cryptobasket.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cryptobasket.adapter.IMarketDataAdapter;
import com.cryptobasket.pojo.Ticker;
import com.cryptobasket.repository.ICryptobasketRepository;

@Component
public class CryptoBasketScheduledTask {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Autowired
	private IMarketDataAdapter marketDataAdapter;
	@Autowired
	private ICryptobasketRepository cryptobasketRepository;

	//@Scheduled(cron = "0 0/2 * * * * ?")
	@Scheduled(cron = "0 0/2 * * * ?")
	public void pullTicker() {
		List<Ticker> tickers = marketDataAdapter.getTickers();

		if (tickers != null) {
			cryptobasketRepository.clearTickerLatest();

			for (Ticker ticker : tickers) {
				cryptobasketRepository.saveTickerLatest(ticker);
			}
		}
		System.out.println("Ticker Pulled by 2 Mins. "+dateFormat.format(new Date()));
	}

	@Scheduled(cron = "0 0/15 * * * ?")
	public void pullTickerByMin() {
		List<Ticker> tickers = marketDataAdapter.getTickers();

		if (tickers != null) {
			for (Ticker ticker : tickers) {
				cryptobasketRepository.saveTickerByMin(ticker);
			}
		}
		System.out.println("Ticker Pulled by 15 Mins. "+dateFormat.format(new Date()));
	}

	@Scheduled(cron = "0 0 * * * ?")
	public void pullTickerByHour() {
		List<Ticker> tickers = marketDataAdapter.getTickers();

		if (tickers != null) {
			for (Ticker ticker : tickers) {
				cryptobasketRepository.saveTickerByHour(ticker);
			}
		}
		System.out.println("Ticker Pulled by 1 Hour."+dateFormat.format(new Date()));
	}

	@Scheduled(cron = "0 0 0 * * ?")
	public void pullTickerByDay() {
		List<Ticker> tickers = marketDataAdapter.getTickers();

		if (tickers != null) {
			for (Ticker ticker : tickers) {
				cryptobasketRepository.saveTickerByDay(ticker);
			}
		}
		System.out.println("Ticker Pulled by 1 Day."+dateFormat.format(new Date()));
	}

	@Scheduled(cron = "0 0 0 1 * ?")
	public void pullTickerByMonth() {
		List<Ticker> tickers = marketDataAdapter.getTickers();

		if (tickers != null) {
			for (Ticker ticker : tickers) {
				cryptobasketRepository.saveTickerByMonth(ticker);
			}
		}
		System.out.println("Ticker Pulled by 1 Month."+dateFormat.format(new Date()));
	}

}
