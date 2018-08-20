/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.dcx.sisclinica.exceptions;

/**
 *
 * @author nikni
 */
public class MedicoNaoExisteException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Creates a new instance of <code>MedicoNaoExisteException</code> without
     * detail message.
     */
    public MedicoNaoExisteException() {
    }

    /**
     * Constructs an instance of <code>MedicoNaoExisteException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public MedicoNaoExisteException(String msg) {
        super(msg);
    }
}
