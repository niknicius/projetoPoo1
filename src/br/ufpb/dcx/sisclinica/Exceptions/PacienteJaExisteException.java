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
public class PacienteJaExisteException extends Exception {

    /**
     * Creates a new instance of <code>PacienteJaExisteException</code> without
     * detail message.
     */
    public PacienteJaExisteException() {
    }

    /**
     * Constructs an instance of <code>PacienteJaExisteException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PacienteJaExisteException(String msg) {
        super(msg);
    }
}
