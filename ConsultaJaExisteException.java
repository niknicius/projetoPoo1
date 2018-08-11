package br.ufpb.dcx;


public class ConsultaJaExisteException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConsultaJaExisteException() {
		super();
	}
	
	public ConsultaJaExisteException(String msg) {
		super(msg);
	}
}
