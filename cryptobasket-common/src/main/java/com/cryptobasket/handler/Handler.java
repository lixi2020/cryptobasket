package com.cryptobasket.handler;

import com.cryptobasket.external.datacontract.Request;
import com.cryptobasket.external.datacontract.Response;
import com.cryptobasket.external.datacontract.ValidationErrorHelper;

public abstract class Handler<Req extends Request, Res extends Response> {
	private void authenticateReuqet(Req request, Res response) {
		// check if this role has access to requested resources
	}

	abstract void semanticValidation(Req request, Res response);

	abstract void dataValidation(Req request, Res response);

	abstract void processRequest(Req request, Res response);

	public Res excute(Req request) throws Exception {
		Res response = (Res) new Response();
		if (ValidationErrorHelper.isContainAnyError(response)) {
			return response;
		}
		authenticateReuqet(request, response);
		if (ValidationErrorHelper.isContainAnyError(response)) {
			return response;
		}

		semanticValidation(request, response);
		if (ValidationErrorHelper.isContainAnyError(response)) {
			return response;
		}

		dataValidation(request, response);
		if (ValidationErrorHelper.isContainAnyError(response)) {
			return response;
		}

		processRequest(request, response);
		return response;
	}
}
