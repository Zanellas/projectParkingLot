package br.com.parking.exception;

public class VehicleException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public VehicleException (String mensagem) {
		super(mensagem);
	}
}
