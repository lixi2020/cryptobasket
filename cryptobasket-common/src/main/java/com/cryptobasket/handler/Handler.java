package com.cryptobasket.handler;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.cryptobasket.external.datacontract.ValidationErrorHelper;

public abstract class Handler<TRequest extends Request, TResponse extends Response, TOperationData extends OperationData> {

	private void authenticateReuqet(TRequest request, TResponse response) {
		// check if this role has access to requested resources
	}

	abstract void sanitizeRequest(TRequest request, TResponse response);

	abstract void validateRequest(TRequest request, TResponse response);

	abstract void processRequest(TRequest request, TResponse response);

	public TResponse excute(TRequest request, TOperationData operationData) throws Exception {

		TResponse response = initResponseAndOperationData(operationData);

		authenticateReuqet(request, response);
		if (ValidationErrorHelper.isContainAnyError(response)) {
			return response;
		}

		sanitizeRequest(request, response);
		if (ValidationErrorHelper.isContainAnyError(response)) {
			return response;
		}

		validateRequest(request, response);
		if (ValidationErrorHelper.isContainAnyError(response)) {
			return response;
		}

		processRequest(request, response);
		return response;
	}

	@SuppressWarnings("unchecked")
	private TResponse initResponseAndOperationData(TOperationData operationData)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		TResponse response = null;
		if (operationData == null) {
			AnnotatedType annotatedType = this.getClass().getAnnotatedSuperclass();

			Type type = annotatedType.getType();

			Type[] types = ((ParameterizedType) type).getActualTypeArguments();

			Class<?> data = Class.forName(types[2].getTypeName());
			operationData = (TOperationData) data.newInstance();

			Class<?> temp = Class.forName(types[1].getTypeName());
			response = (TResponse) temp.newInstance();
		}
		return response;
	}
}
