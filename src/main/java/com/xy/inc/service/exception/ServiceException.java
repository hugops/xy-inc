/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xy.inc.service.exception;

/**
 *
 * @author Hugo
 */
public class ServiceException extends Exception {

    private static final long serialVersionUID = 4261578270104470888L;

    /**
     * Construtor padrão da exceção.
     */
    public ServiceException() {
    }

    /**
     * Construtor que a inicializa a exceção com uma mensagem.
     *
     * @param message A mensagem.
     */
    public ServiceException(String message) {
        super(message);
    }

    /**
     * Construtor que a inicializa a exceção com uma mensagem e uma causa.
     *
     * @param message A mensagem.
     * @param cause A causa.
     */
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Construtor que a inicializa a exceção com uma causa.
     *
     * @param cause A causa.
     */
    public ServiceException(Throwable cause) {
        super(cause);
    }
}
