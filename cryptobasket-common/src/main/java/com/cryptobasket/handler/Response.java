package com.cryptobasket.handler;

import java.util.List;

import com.cryptobasket.external.datacontract.ValidationError;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
public class Response {
	private List<ValidationError> erros;

	public List<ValidationError> getErros() {
		return erros;
	}

	public void setErros(List<ValidationError> erros) {
		this.erros = erros;
	}

}
