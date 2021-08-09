/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.Farmacia.DAO;

import br.com.fatec.Farmacia.bean.Cliente;
import br.com.fatec.Farmacia.persistencia.Banco;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author nicol
 */
public class ClienteDAO implements DAO<Cliente> {

    //variaveis auxiliares
    //permite o uso de comandos DML (select, insert, delete e update) para
    //acessar nosso SGBD
    private java.sql.PreparedStatement pst;

    //permite armazenar um conjunto de dados vindo do SGBD para ser
    //manipulado
    private java.sql.ResultSet rs;

    //representar os dados do  meu negócio
    private Cliente cliente;

    @Override
    public boolean insere(Cliente obj) throws SQLException {
        String sql = "INSERT INTO Cliente (Nome, CPF, Email, Telefone, Celular) "
                + " VALUES (?, ?, ?, ?, ?)"; //a ? indica parametros

        //abre a conexao com o banco
        Banco.conectar();
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);

        //associar os dados do objeto Proprietario com o comando INSERT
        if (!obj.getTelefone().isEmpty() && !obj.getTelefone().isEmpty()) {
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getCpf());
            pst.setString(3, obj.getEmail());
            //no banco de dados o telefone e cel estão como int(11) e int(10)
            pst.setString(4, obj.getTelefone());
            pst.setString(5, obj.getCelular());
            /*
            pst.setInt(4, Integer.parseInt(obj.getTelefone()));
            pst.setInt(5, Integer.parseInt(obj.getCelular())); */
        }
        //executar o comando
        int res = pst.executeUpdate(); //esse método serve para Insert, delete e update

        //fecha a conexao
        Banco.desconectar();

        //devolve se funcionoou ou nao
        return res != 0;
    }

    @Override
    public boolean remove(Cliente obj) throws SQLException {
        String sql = "DELETE FROM Cliente WHERE IDCliente = ?"; //a ? indica parametros

        //abre a conexao com o banco
        Banco.conectar();
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);

        //associar os dados do objeto Proprietario com o comando DELETE
        pst.setInt(1, obj.getIdCliente());

        //executar o comando
        int res = pst.executeUpdate(); //esse método serve para Insert, delete e update

        //fecha a conexao
        Banco.desconectar();

        //devolve se funcionoou ou nao
        return res != 0;
    }

    @Override
    public boolean altera(Cliente obj) throws SQLException {
        String sql = "UPDATE Cliente SET Nome = ?,  CPF = ?, Email = ?,  "
                + "Telefone = ?, Celular = ?"
                + "WHERE IDCliente = ?"; //a ? indica parametros

        //abre a conexao com o banco
        Banco.conectar();
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);

        //associar os dados do objeto Proprietario com o comando UPDATE
        pst.setInt(6, obj.getIdCliente());
        pst.setString(1, obj.getNome());
        pst.setString(2, obj.getCpf());
        pst.setString(3, obj.getEmail());
        pst.setString(4, obj.getTelefone());
        pst.setString(5, obj.getCelular());
            
        /*
        //no banco de dados o telefone e cel estão como int(11) e int(10)
        pst.setInt(4, Integer.parseInt(obj.getTelefone()));
        pst.setInt(5, Integer.parseInt(obj.getCelular()));*/

        //executar o comando
        int res = pst.executeUpdate(); //esse método serve para Insert, delete e update

        //fecha a conexao
        Banco.desconectar();

        //devolve se funcionoou ou nao
        return res != 0;
    }

    @Override
    public Cliente buscaID(Cliente obj) throws SQLException {
        String sql = "SELECT * FROM Cliente WHERE CPF = ?";

        //abre a conexao com o banco
        Banco.conectar();
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);

        //associar os dados do objeto Proprietario com o comando UPDATE
        pst.setString(1, obj.getCpf());

        //executar o comando
        rs = pst.executeQuery(); //esse método serve para SELECT

        //verificar se trouxe algum registro
        //rs.next() faz a leitura do próximo registro, se existir devolve true
        //se nao devolve false
        if (rs.next()) {
            cliente = new Cliente();
            cliente.setIdCliente(rs.getInt("IDCliente"));
            cliente.setNome(rs.getString("Nome"));
            cliente.setCpf(rs.getString("CPF"));
            cliente.setEmail(rs.getString("Email"));
            //no banco de dados o telefone e cel estão como int(11) e int(10)/*
            cliente.setTelefone(Integer.toString(rs.getInt("Telefone")));
            cliente.setCelular(Integer.toString(rs.getInt("Celular")));
        } else {
            cliente = null;
        }

        //desconectar
        Banco.desconectar();

        //retorna obj
        return cliente;
    }

    @Override
    public Collection<Cliente> lista(String criterio) throws SQLException {
        //cria uma lista para armazenar os dados vindos do banco
        ArrayList<Cliente> lista = new ArrayList<>();

        String sql = "SELECT * FROM Cliente ";

        //precisa fazer filtro para listagem
        if (criterio != null && criterio.length() > 0) {
            sql += " WHERE " + criterio;
        }

        //abre a conexao com o banco
        Banco.conectar();
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);

        //executar o comando
        rs = pst.executeQuery(); //esse método serve para SELECT

        //Varre todo o resultado da consulta e coloca cada registro dentro
        //de um objeto e coloca o objeto dentro da coleção
        while (rs.next()) {
            //criar o objeto
            cliente = new Cliente();
            //mover os dados do resultSet para o objeto proprietário
            cliente.setIdCliente(rs.getInt("IDCliente"));
            cliente.setNome(rs.getString("Nome"));
            cliente.setCpf(rs.getString("CPF"));
            cliente.setEmail(rs.getString("Email"));
            //no banco de dados o telefone e cel estão como int(11) e int(10)
            cliente.setTelefone(Integer.toString(rs.getInt("Telefone")));
            cliente.setCelular(Integer.toString(rs.getInt("Celular")));
            //move o objeto para a coleção
            lista.add(cliente);
        }

        //fecha a conexao
        Banco.desconectar();

        //devolve o objeto proprietario
        return lista;
    }

}
