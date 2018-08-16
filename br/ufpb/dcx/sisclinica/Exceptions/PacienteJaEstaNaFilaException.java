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
public class PacienteJaEstaNaFilaException extends Exception {

    /**
     * Creates a new instance of <code>PacienteJaEstaNaFilaException</code>
     * without detail message.
     */
    public PacienteJaEstaNaFilaException() {
    }

    /**
     * Constructs an instance of <code>PacienteJaEstaNaFilaException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public PacienteJaEstaNaFilaException(String msg) {
        super(msg);
    }
}
