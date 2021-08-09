/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.Farmacia.bean;

/**
 *
 * @author nicol
 */
public class Remedio {
    
    private String nome;
    private int idRemedio;
    private float preco;
    private String receita;
    private String categoria;
    private int codigo;

    @Override
    public String toString() {
        return nome ;
    }

    
    
    
    
    
    
    //construtor
    public Remedio (){
        
    }

    public Remedio(String nome, int idRemedio, float preco, String receita, String categoria, int codigo) {
        this.nome = nome;
        this.idRemedio = idRemedio;
        this.preco = preco;
        this.receita = receita;
        this.categoria = categoria;
        this.codigo = codigo;
    }
    
  //equal e hashcode

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.idRemedio;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Remedio other = (Remedio) obj;
        if (this.idRemedio != other.idRemedio) {
            return false;
        }
        return true;
    }
    
    
    //get e set
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdRemedio() {
        return idRemedio;

    }

    public void setIdRemedio(int idRemedio) {
        this.idRemedio = idRemedio;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getReceita() {
        return receita;
    }

    public void setReceita(String receita) {
        this.receita = receita;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
