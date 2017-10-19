package com.cryptobasket.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.cryptobasket.pojo.CryptoMeta;
import com.cryptobasket.pojo.Ticker;

public interface CryptoMapper {
	@Insert("INSERT INTO crypto_basket.crypto_meta(nameId,name,symbol,createTime)"
			+ "VALUES(#{nameId},#{name},#{symbol},#{createTime});")
	void insertCryptoMeta(CryptoMeta meta);

	@Select("SELECT * FROM crypto_basket.crypto_meta WHERE nameId=#{nameId};")
	@Results({ @Result(property = "id", column = "cryptoId") })
	CryptoMeta getCryptoMetaByNameId(String nameId);

	@Delete("DELETE FROM crypto_basket.crypto_ticker_latest;")
	void clearTickerLatest();

	@Insert("INSERT INTO crypto_basket.crypto_ticker_latest"
			+ "(`nameId`,`rank`,`priceUSD`,`priceBTC`,`volume24hUSD`,`marketCapUSD`,`availableSupply`,`totalSupply`"
			+ ",`percentChange1h`,`percentChange24h`,`percentChange7d`,`lastUpdateTime`) "
			+ "VALUES(#{nameId},#{rank},#{priceUSD},#{priceBTC},#{volume24hUSD},#{marketCapUSD},#{availableSupply},#{totalSupply},"
			+ "#{percentChange1h},#{percentChange24h},#{percentChange7d},#{lastUpdateTime});")
	void insertTickerLatest(Ticker ticker);

	@Select("SELECT * FROM crypto_basket.crypto_ticker_latest limit #{pageOffset},#{pageSize};")
	List<Ticker> getLatestTickers(@Param("pageOffset") int pageOffset, @Param("pageSize") int pageSize);

	@Insert("INSERT INTO crypto_basket.crypto_ticker_history_min"
			+ "(`nameId`,`rank`,`priceUSD`,`priceBTC`,`volume24hUSD`,`marketCapUSD`,`availableSupply`,`totalSupply`"
			+ ",`percentChange1h`,`percentChange24h`,`percentChange7d`,`lastUpdateTime`) "
			+ "VALUES(#{nameId},#{rank},#{priceUSD},#{priceBTC},#{volume24hUSD},#{marketCapUSD},#{availableSupply},#{totalSupply},"
			+ "#{percentChange1h},#{percentChange24h},#{percentChange7d},#{lastUpdateTime});")
	void insertTickerByMin(Ticker ticker);

	@Insert("INSERT INTO crypto_basket.crypto_ticker_history_hour"
			+ "(`nameId`,`rank`,`priceUSD`,`priceBTC`,`volume24hUSD`,`marketCapUSD`,`availableSupply`,`totalSupply`"
			+ ",`percentChange1h`,`percentChange24h`,`percentChange7d`,`lastUpdateTime`) "
			+ "VALUES(#{nameId},#{rank},#{priceUSD},#{priceBTC},#{volume24hUSD},#{marketCapUSD},#{availableSupply},#{totalSupply},"
			+ "#{percentChange1h},#{percentChange24h},#{percentChange7d},#{lastUpdateTime});")
	void insertTickerByHour(Ticker ticker);

	@Insert("INSERT INTO crypto_basket.crypto_ticker_history_day"
			+ "(`nameId`,`rank`,`priceUSD`,`priceBTC`,`volume24hUSD`,`marketCapUSD`,`availableSupply`,`totalSupply`"
			+ ",`percentChange1h`,`percentChange24h`,`percentChange7d`,`lastUpdateTime`) "
			+ "VALUES(#{nameId},#{rank},#{priceUSD},#{priceBTC},#{volume24hUSD},#{marketCapUSD},#{availableSupply},#{totalSupply},"
			+ "#{percentChange1h},#{percentChange24h},#{percentChange7d},#{lastUpdateTime});")
	void insertTickerByDay(Ticker ticker);

	@Insert("INSERT INTO crypto_basket.crypto_ticker_history_month"
			+ "(`nameId`,`rank`,`priceUSD`,`priceBTC`,`volume24hUSD`,`marketCapUSD`,`availableSupply`,`totalSupply`"
			+ ",`percentChange1h`,`percentChange24h`,`percentChange7d`,`lastUpdateTime`) "
			+ "VALUES(#{nameId},#{rank},#{priceUSD},#{priceBTC},#{volume24hUSD},#{marketCapUSD},#{availableSupply},#{totalSupply},"
			+ "#{percentChange1h},#{percentChange24h},#{percentChange7d},#{lastUpdateTime});")
	void insertTickerByMonth(Ticker ticker);
}