/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.ads_ma4_farmacia;

import java.sql.SQLException;

/**
 *
 * @author nicol
 */
public class TesteConexao {
    public static void main(String[] args) {
        String url = "jdbc:mariadb://localhost:3306/Loja";
        
        java.sql.Connection conexao;
        try {
            //conectar, informar URL, Usuario e Senha
            conexao = java.sql.DriverManager.getConnection(url, "root", "4474");
            
            System.out.println("Conectado");
            System.out.println("Fechando...");
            conexao.close();
        } catch (SQLException ex) {
            System.out.println("Erro:" + ex.getMessage());
        }
    }
}
