/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.Farmacia.DAO;

import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * @author nicol
 */
public interface DAO<BEAN> {
    public boolean insere(BEAN obj) throws SQLException;
    public boolean remove(BEAN obj) throws SQLException;
    public boolean altera(BEAN obj) throws SQLException;
    public BEAN buscaID(BEAN obj) throws SQLException;
    public Collection<BEAN> lista(String criterio) throws SQLException;
}
