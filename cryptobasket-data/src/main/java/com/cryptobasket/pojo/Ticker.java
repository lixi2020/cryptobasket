package com.cryptobasket.pojo;

import java.sql.Timestamp;

public class Ticker {
	private String nameId;
	private int rank;
	private java.math.BigDecimal priceUSD;
	private java.math.BigDecimal priceBTC;
	private java.math.BigDecimal volume24hUSD;
	private java.math.BigDecimal marketCapUSD;
	private java.math.BigDecimal availableSupply;
	private java.math.BigDecimal totalSupply;
	private java.math.BigDecimal percentChange1h;
	private java.math.BigDecimal percentChange24h;
	private java.math.BigDecimal percentChange7d;
	private Timestamp createTime;

	public String getNameId() {
		return nameId;
	}

	public void setNameId(String nameId) {
		this.nameId = nameId;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public java.math.BigDecimal getPriceUSD() {
		return priceUSD;
	}

	public void setPriceUSD(java.math.BigDecimal priceUSD) {
		this.priceUSD = priceUSD;
	}

	public java.math.BigDecimal getPriceBTC() {
		return priceBTC;
	}

	public void setPriceBTC(java.math.BigDecimal priceBTC) {
		this.priceBTC = priceBTC;
	}

	public java.math.BigDecimal getVolume24hUSD() {
		return volume24hUSD;
	}

	public void setVolume24hUSD(java.math.BigDecimal volume24hUSD) {
		this.volume24hUSD = volume24hUSD;
	}

	public java.math.BigDecimal getMarketCapUSD() {
		return marketCapUSD;
	}

	public void setMarketCapUSD(java.math.BigDecimal marketCapUSD) {
		this.marketCapUSD = marketCapUSD;
	}

	public java.math.BigDecimal getAvailableSupply() {
		return availableSupply;
	}

	public void setAvailableSupply(java.math.BigDecimal availableSupply) {
		this.availableSupply = availableSupply;
	}

	public java.math.BigDecimal getTotalSupply() {
		return totalSupply;
	}

	public void setTotalSupply(java.math.BigDecimal totalSupply) {
		this.totalSupply = totalSupply;
	}

	public java.math.BigDecimal getPercentChange1h() {
		return percentChange1h;
	}

	public void setPercentChange1h(java.math.BigDecimal percentChange1h) {
		this.percentChange1h = percentChange1h;
	}

	public java.math.BigDecimal getPercentChange24h() {
		return percentChange24h;
	}

	public void setPercentChange24h(java.math.BigDecimal percentChange24h) {
		this.percentChange24h = percentChange24h;
	}

	public java.math.BigDecimal getPercentChange7d() {
		return percentChange7d;
	}

	public void setPercentChange7d(java.math.BigDecimal percentChange7d) {
		this.percentChange7d = percentChange7d;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Ticker [nameId=" + nameId + ", rank=" + rank + ", priceUSD=" + priceUSD + ", priceBTC=" + priceBTC
				+ ", volume24hUSD=" + volume24hUSD + ", marketCapUSD=" + marketCapUSD + ", availableSupply="
				+ availableSupply + ", totalSupply=" + totalSupply + ", percentChange1h=" + percentChange1h
				+ ", percentChange24h=" + percentChange24h + ", percentChange7d=" + percentChange7d + ", createTime="
				+ createTime + "]";
	}

}