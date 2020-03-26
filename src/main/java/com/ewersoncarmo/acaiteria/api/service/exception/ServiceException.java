package com.ewersoncarmo.acaiteria.api.service.exception;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 2595931725568242058L;

	private String codigoErro;
	private Object[] parametros;

	public ServiceException(String codigoErro, Object... parametros) {
		this.codigoErro = codigoErro;
		this.parametros = parametros;
	}

	public String getCodigoErro() {
		return codigoErro;
	}

	public Object[] getParametros() {
		return parametros;
	}

}
