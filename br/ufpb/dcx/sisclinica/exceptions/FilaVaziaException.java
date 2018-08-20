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
public class FilaVaziaException extends Exception {
    
    
    private static long serialVersionUID = 1L;
    
    /**
     * Creates a new instance of <code>FilaVaziaException</code> without detail
     * message.
     */
    public FilaVaziaException() {
    }

    /**
     * Constructs an instance of <code>FilaVaziaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public FilaVaziaException(String msg) {
        super(msg);
    }
}
