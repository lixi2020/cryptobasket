package com.cryptobasket.handler;

import java.util.List;

import com.cryptobasket.external.datacontract.ValidationError;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
public class Response {
	private List<ValidationError> errors;

	public List<ValidationError> getErrors() {
		return errors;
	}

	public void setErrors(List<ValidationError> errors) {
		this.errors = errors;
	}


}
