package com.cryptobasket.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.cryptobasket.pojo.CryptoMeta;
import com.cryptobasket.pojo.Ticker;

public interface MarketDataMapper {

	@Select("SELECT * FROM crypto_basket.crypto_meta WHERE nameId=#{nameId};")
	@Results({ @Result(property = "id", column = "cryptoId") })
	CryptoMeta getCryptoMetaByNameId(String nameId);

	@Select("SELECT * FROM crypto_basket.crypto_ticker_latest limit #{pageOffset},#{pageSize};")
	List<Ticker> getLatestTickers(@Param("pageOffset") int pageOffset, @Param("pageSize") int pageSize);

}