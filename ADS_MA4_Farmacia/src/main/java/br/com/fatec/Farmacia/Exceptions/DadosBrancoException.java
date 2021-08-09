/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.Farmacia.Exceptions;

import java.io.IOException;

/**
 *
 * @author nicol
 */
public class DadosBrancoException extends IOException{

    public DadosBrancoException() {
        super();
    }
    
    public DadosBrancoException(String msg){
        super(msg);
    }
}
