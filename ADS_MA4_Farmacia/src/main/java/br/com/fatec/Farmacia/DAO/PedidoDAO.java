/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.Farmacia.DAO;

import br.com.fatec.Farmacia.bean.Cliente;
import br.com.fatec.Farmacia.bean.Pedido;
import br.com.fatec.Farmacia.bean.Remedio;
import br.com.fatec.Farmacia.persistencia.Banco;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author nicol
 */
public class PedidoDAO implements DAO<Pedido>{
    //variaveis auxiliares
    //permite o uso de comandos DML (select, insert, delete e update) para
    //acessar nosso SGBD
    private java.sql.PreparedStatement pst;
    
    //permite armazenar um conjunto de dados vindo do SGBD para ser
    //manipulado
    private java.sql.ResultSet rs; 
    
    //representar os dados do  meu negócio
    private Pedido pedido;
    private Remedio remedio;
    private Cliente cliente;
    
    
    
    @Override
    public boolean insere(Pedido obj) throws SQLException {
        String sql = "INSERT INTO Pedido (IDCliente, IDRemedio, Quantidade, Preco) " +
                " VALUES (?, ?, ?, ?)"; //a ? indica parametros
        
        //abre a conexao com o banco
        Banco.conectar();
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Proprietario com o comando INSERT
        pst.setInt(1, obj.getCliente().getIdCliente());
        //obtem os dados via composição
        pst.setInt(2, obj.getRemedio().getIdRemedio()); //FK
        pst.setInt(3, obj.getQuantidade());
        pst.setFloat(4, obj.getPreco());
        
        //executar o comando
        int res = pst.executeUpdate(); //esse método serve para Insert, delete e update
        
        //fecha a conexao
        Banco.desconectar();
        
        //devolve se funcionoou ou nao
        return res != 0;
    }

    @Override
    public boolean remove(Pedido obj) throws SQLException {
        String sql = "DELETE FROM Pedido WHERE IDPedido = ?"; //a ? indica parametros

        //abre a conexao com o banco
        Banco.conectar();
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);

        //associar os dados do objeto Proprietario com o comando DELETE
        pst.setInt(1, obj.getIdPedido());

        //executar o comando
        int res = pst.executeUpdate(); //esse método serve para Insert, delete e update

        //fecha a conexao
        Banco.desconectar();

        //devolve se funcionoou ou nao
        return res != 0;
    }

    @Override
    public boolean altera(Pedido obj) throws SQLException {
     String sql = "UPDATE Cliente SET IDCliente = ?,  IDRemedio = ?, Quantidade = ?,  "
                + "Preco = ?"
                + "WHERE IDPedido = ?"; //a ? indica parametros

        //abre a conexao com o banco
        Banco.conectar();
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);

        //associar os dados do objeto Proprietario com o comando UPDATE
        pst.setInt(5, obj.getIdPedido());
        pst.setInt(1, obj.getCliente().getIdCliente());
        pst.setInt(2, obj.getRemedio().getIdRemedio());
        pst.setInt(3, obj.getQuantidade());
        pst.setFloat(4, obj.getPreco());
            
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
    public Pedido buscaID(Pedido obj) throws SQLException {
     String sql = "SELECT * FROM Pedido "
                + "WHERE IDPedido = ?"; //a ? indica parametros
        
        //abre a conexao com o banco
        Banco.conectar();
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Proprietario com o comando SELECT
        pst.setInt(1, obj.getIdPedido());
        
        //executar o comando
        rs = pst.executeQuery(); //esse método serve para SELECT
        
        //verificar se trouxe algum registro
        //rs.next() faz a leitura do próximo registro, se existir devolve true
        //se nao devolve false
        if(rs.next()) {
            //buscar dados do cliente
            ClienteDAO cliDAO = new ClienteDAO();
            //cria um objeto cliente
            cliente = new Cliente();
            //coloca o IDCliente do banco para buscar os outros dados
            cliente.setIdCliente(rs.getInt("IDCliente"));
            //busca no banco os dados completos do cliente
            //cliente = cliDAO.buscaID(cliente);
            
            //buscar dados do cliente
            RemedioDAO remDAO = new RemedioDAO();
            //cria um objeto cliente
            remedio = new Remedio();
            //coloca o IDCliente do banco para buscar os outros dados
            remedio.setIdRemedio(rs.getInt("IDRemedio"));
            //busca no banco os dados completos do cliente
            //remedio = remDAO.buscaID(remedio);
            
            //mover os dados do resultSet para o objeto proprietário
            pedido = new Pedido(cliente,remedio);
            pedido.setQuantidade(rs.getInt("Quantidade"));
            pedido.setPreco(rs.getFloat("Preco"));
        }
        else {
            //não encontrou o registro solicitado
            pedido = null;
        }
                
        //fecha a conexao
        Banco.desconectar();
        
        //devolve o objeto proprietario
        return pedido;

    }

    @Override
    public Collection<Pedido> lista(String criterio) throws SQLException {
         //cria uma lista para armazenar os dados vindos do banco
        ArrayList<Pedido> lista = new ArrayList<>();

        String sql = "SELECT * FROM Pedido ";

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
            pedido = new Pedido();
            cliente = new Cliente();
            remedio = new Remedio();
            pedido.setCliente(cliente);
            //mover os dados do resultSet para o obj
            pedido.setIdPedido((rs.getInt("IDPedido")));
            cliente.setIdCliente(rs.getInt("IDCliente"));
            remedio.setIdRemedio(rs.getInt("IDRemedio"));
            pedido.setQuantidade(rs.getInt("Quantidade"));
            pedido.setPreco(rs.getFloat("Preco"));
            
            //pega cliente
            pedido.setCliente(cliente);
            //pega remedio
            pedido.setRemedio(remedio);
            
            /*//no banco de dados o telefone e cel estão como int(11) e int(10)
            pedido.set(Integer.toString(rs.getInt("Telefone")));
            pedido.set(Integer.toString(rs.getInt("Celular"))); */
            //move o objeto para a coleção
            lista.add(pedido);
        }

        //fecha a conexao
        Banco.desconectar();

        //devolve o objeto proprietario
        return lista;
    }

    
}
