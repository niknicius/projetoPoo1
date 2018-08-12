/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.dcx.sisclinica.Exceptions;

/**
 *
 * @author nikni
 */
public class MedicoJaExisteException extends Exception {

    /**
     * Creates a new instance of <code>MedicoJaExisteException</code> without
     * detail message.
     */
    public MedicoJaExisteException() {
    }

    /**
     * Constructs an instance of <code>MedicoJaExisteException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public MedicoJaExisteException(String msg) {
        super(msg);
    }
}
