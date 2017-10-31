package com.cryptobasket.handler;

import java.util.List;

import com.cryptobasket.external.datacontract.ValidationError;

public class Response {
	private List<ValidationError> erros;

	public List<ValidationError> getErros() {
		return erros;
	}

	public void setErros(List<ValidationError> erros) {
		this.erros = erros;
	}

}
