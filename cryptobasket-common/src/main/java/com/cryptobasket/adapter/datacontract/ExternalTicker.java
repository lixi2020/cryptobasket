package com.cryptobasket.adapter.datacontract;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalTicker {
	private String id;
	private String name;
	private String symbol;
	private int rank;
	private java.math.BigDecimal price_usd;
	private java.math.BigDecimal price_btc;
	@JsonProperty("24h_volume_usd")
	private java.math.BigDecimal _24h_volume_usd;
	private java.math.BigDecimal market_cap_usd;
	private java.math.BigDecimal available_supply;
	private java.math.BigDecimal total_supply;
	private java.math.BigDecimal percent_change_1h;
	private java.math.BigDecimal percent_change_24h;
	private java.math.BigDecimal percent_change_7d;
	private Timestamp last_updated;

	
	
	@Override
	public String toString() {
		return "Ticker [id=" + id + ", name=" + name + ", symbol=" + symbol + ", rank=" + rank + ", price_usd="
				+ price_usd + ", price_btc=" + price_btc + ", _24h_volume_usd=" + _24h_volume_usd + ", market_cap_usd="
				+ market_cap_usd + ", available_supply=" + available_supply + ", total_supply=" + total_supply
				+ ", percent_change_1h=" + percent_change_1h + ", percent_change_24h=" + percent_change_24h
				+ ", percent_change_7d=" + percent_change_7d + ", last_updated=" + last_updated+ "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public java.math.BigDecimal getPrice_usd() {
		return price_usd;
	}

	public void setPrice_usd(java.math.BigDecimal price_usd) {
		this.price_usd = price_usd;
	}

	public java.math.BigDecimal getPrice_btc() {
		return price_btc;
	}

	public void setPrice_btc(java.math.BigDecimal price_btc) {
		this.price_btc = price_btc;
	}

	public java.math.BigDecimal get_24h_volume_usd() {
		return _24h_volume_usd;
	}

	public void set_24h_volume_usd(java.math.BigDecimal _24h_volume_usd) {
		this._24h_volume_usd = _24h_volume_usd;
	}

	public java.math.BigDecimal getMarket_cap_usd() {
		return market_cap_usd;
	}

	public void setMarket_cap_usd(java.math.BigDecimal market_cap_usd) {
		this.market_cap_usd = market_cap_usd;
	}

	public java.math.BigDecimal getAvailable_supply() {
		return available_supply;
	}

	public void setAvailable_supply(java.math.BigDecimal available_supply) {
		this.available_supply = available_supply;
	}

	public java.math.BigDecimal getTotal_supply() {
		return total_supply;
	}

	public void setTotal_supply(java.math.BigDecimal total_supply) {
		this.total_supply = total_supply;
	}

	public java.math.BigDecimal getPercent_change_1h() {
		return percent_change_1h;
	}

	public void setPercent_change_1h(java.math.BigDecimal percent_change_1h) {
		this.percent_change_1h = percent_change_1h;
	}

	public java.math.BigDecimal getPercent_change_24h() {
		return percent_change_24h;
	}

	public void setPercent_change_24h(java.math.BigDecimal percent_change_24h) {
		this.percent_change_24h = percent_change_24h;
	}

	public java.math.BigDecimal getPercent_change_7d() {
		return percent_change_7d;
	}

	public void setPercent_change_7d(java.math.BigDecimal percent_change_7d) {
		this.percent_change_7d = percent_change_7d;
	}

	public Timestamp getLast_updated() {
		return last_updated;
	}

	public void setLast_updated(long last_updated) {
		this.last_updated =  new Timestamp((long)last_updated*1000);
	}

}
// "id": "bitcoin",
// "name": "Bitcoin",
// "symbol": "BTC",
// "rank": "1",
// "price_usd": "573.137",
// "price_btc": "1.0",
// "24h_volume_usd": "72855700.0",
// "market_cap_usd": "9080883500.0",
// "available_supply": "15844176.0",
// "total_supply": "15844176.0",
// "percent_change_1h": "0.04",
// "percent_change_24h": "-0.3",
// "percent_change_7d": "-0.57",
// "last_updated": "1472762067"