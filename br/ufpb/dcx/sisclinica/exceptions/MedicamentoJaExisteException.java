package br.ufpb.dcx.sisclinica.exceptions;


public class MedicamentoJaExisteException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MedicamentoJaExisteException() {
		super();
	}
	
	public MedicamentoJaExisteException(String msgErro) {
		super(msgErro);
	}

}
