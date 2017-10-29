package com.cryptobasket.external.datacontract;

import java.util.List;

public class Response {
	private List<ValidationError> erros;

	public List<ValidationError> getErros() {
		return erros;
	}

	public void setErros(List<ValidationError> erros) {
		this.erros = erros;
	}

}
