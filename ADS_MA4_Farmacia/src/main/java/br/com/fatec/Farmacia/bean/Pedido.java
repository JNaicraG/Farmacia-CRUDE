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
public class Pedido {
    private int idPedido;
    private Cliente cliente;
    private Remedio remedio;
    private float preco;
    private int quantidade;

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + '}';
    }

    
    
    
    //Construtor
    public Pedido(){
        
    }
    
    public Pedido(Cliente cliente, Remedio remedio){
        this.cliente = cliente;
        this.remedio = remedio;
    }
    
    public Pedido(int idPedido, Cliente cliente, Remedio remedio, float preco, int quantidade) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.remedio = remedio;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    
    //euqlas e hashcode

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.idPedido;
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
        final Pedido other = (Pedido) obj;
        if (this.idPedido != other.idPedido) {
            return false;
        }
        return true;
    }
    
    

    //get e set
    
    public int getIdPedido() {
        return idPedido;
    }
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Remedio getRemedio() {
        return remedio;
    }

    public void setRemedio(Remedio remedio) {
        this.remedio = remedio;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
