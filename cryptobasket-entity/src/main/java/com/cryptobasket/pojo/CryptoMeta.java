package com.cryptobasket.pojo;

import java.sql.Timestamp;

public class CryptoMeta {
	private int id;
	private String nameId;
	private String name;
	private String symbol;
	private Timestamp createTime;
	private Timestamp modifyTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameId() {
		return nameId;
	}

	public void setNameId(String nameId) {
		this.nameId = nameId;
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

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

	@Override
	public String toString() {
		return "CryptoMeta [id=" + id + ", nameId=" + nameId + ", name=" + name + ", symbol=" + symbol + ", createTime="
				+ createTime + ", modifyTime=" + modifyTime + "]";
	}

}