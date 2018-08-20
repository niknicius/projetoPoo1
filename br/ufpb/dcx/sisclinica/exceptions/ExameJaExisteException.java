/*
 */
package br.ufpb.dcx.sisclinica.exceptions;

/**
 *
 * @author nikni
 */
public class ExameJaExisteException extends Exception{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExameJaExisteException(String msg){
        super(msg);
    }
    
}
