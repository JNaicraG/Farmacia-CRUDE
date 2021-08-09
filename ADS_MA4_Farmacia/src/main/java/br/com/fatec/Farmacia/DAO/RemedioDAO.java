/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.Farmacia.DAO;
import br.com.fatec.Farmacia.bean.Cliente;
import br.com.fatec.Farmacia.bean.Remedio;
import br.com.fatec.Farmacia.persistencia.Banco;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
/**
 *
 * @author nicol
 */
public class RemedioDAO implements DAO<Remedio>{

     //variaveis auxiliares
    //permite o uso de comandos DML (select, insert, delete e update) para
    //acessar nosso SGBD
    private java.sql.PreparedStatement pst;
    
    //permite armazenar um conjunto de dados vindo do SGBD para ser
    //manipulado
    private java.sql.ResultSet rs;
    
    //representar os dados do  meu negócio
    Remedio remedio;
    
    @Override
    public boolean insere(Remedio obj) throws SQLException {
         String sql = "INSERT INTO Remedios (Nome, Categoria, Receita, Codigo, Preco) " +
                " VALUES (?, ?, ?, ?, ?)"; //a ? indica parametros
        
        //abre a conexao com o banco
        Banco.conectar();
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Proprietario com o comando INSERT
        pst.setString(1, obj.getNome());
        pst.setString(2, obj.getCategoria());
        pst.setString(3, obj.getReceita());
        pst.setInt(4, obj.getCodigo());
        pst.setFloat(5,obj.getPreco());
        
        //executar o comando
        int res = pst.executeUpdate(); //esse método serve para Insert, delete e update
        
        //fecha a conexao
        Banco.desconectar();
        
        //devolve se funcionoou ou nao
        return res != 0;
    }

    @Override
    public boolean remove(Remedio obj) throws SQLException {
        String sql = "DELETE FROM Remedios WHERE IDRemedio = ?"; //a ? indica parametros
        
        //abre a conexao com o banco
        Banco.conectar();
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Proprietario com o comando DELETE
        pst.setInt(1, obj.getIdRemedio());
        
        //executar o comando
        int res = pst.executeUpdate(); //esse método serve para Insert, delete e update
        
        //fecha a conexao
        Banco.desconectar();
        
        //devolve se funcionoou ou nao
        return res != 0;
    }

    @Override
    public boolean altera(Remedio obj) throws SQLException {
    String sql = "UPDATE Remedios SET Nome = ?,  Categoria = ?,  Receita = ?, "
                + " Codigo = ?,  Preco = ?"
                + "WHERE IDRemedio = ?"; //a ? indica parametros
        
        //abre a conexao com o banco
        Banco.conectar();
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Proprietario com o comando UPDATE
        pst.setInt(6, obj.getIdRemedio());
        pst.setString(1, obj.getNome());
        pst.setString(2, obj.getCategoria());
        pst.setString(3, obj.getReceita());
        pst.setInt(4, obj.getCodigo());
        pst.setFloat(5,obj.getPreco());
        
        //executar o comando
        int res = pst.executeUpdate(); //esse método serve para Insert, delete e update
        
        //fecha a conexao
        Banco.desconectar();
        
        //devolve se funcionoou ou nao
        return res != 0;
    }

    @Override
    public Remedio buscaID(Remedio obj) throws SQLException {
     String sql = "SELECT * FROM Remedios where Codigo = ? ";
        
        //abre a conexao com o banco
        Banco.conectar();
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Proprietario com o comando UPDATE
        pst.setInt(1, obj.getCodigo());

        //executar o comando
        rs = pst.executeQuery(); //esse método serve para SELECT
        
        //verificar se trouxe algum registro
        //rs.next() faz a leitura do próximo registro, se existir devolve true
        //se nao devolve false
        if (rs.next()){
            remedio = new Remedio();
            remedio.setIdRemedio(rs.getInt("IDRemedio"));
            remedio.setNome(rs.getString("Nome"));
            remedio.setCategoria(rs.getString("Categoria"));
            remedio.setReceita(rs.getString("Receita"));
            remedio.setCodigo(rs.getInt("Codigo"));
            remedio.setPreco(rs.getFloat("Preco"));
        } else
            remedio = null;
        
        //desconectar
        Banco.desconectar();
        
        //retorna obj
        return remedio;
    }

    @Override
    public Collection<Remedio> lista(String criterio) throws SQLException {
    //cria uma lista para armazenar os dados vindos do banco
        ArrayList<Remedio> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM Remedios ";

        //precisa fazer filtro para listagem
        if(criterio != null && criterio.length() > 0) {
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
        while(rs.next()) {
            //criar o objeto
            remedio = new Remedio();
            remedio.setIdRemedio(rs.getInt("IDRemedio"));
            remedio.setNome(rs.getString("Nome"));
            remedio.setCategoria(rs.getString("Categoria"));
            remedio.setReceita(rs.getString("Receita"));
            remedio.setCodigo(rs.getInt("Codigo"));
            remedio.setPreco(rs.getFloat("Preco"));
            //move o objeto para a coleção
            lista.add(remedio);
        }
                
        //fecha a conexao
        Banco.desconectar();
   
        //devolve o objeto proprietario
        return lista;
    }
    
}
