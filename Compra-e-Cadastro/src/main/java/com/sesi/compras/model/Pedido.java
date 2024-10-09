package com.sesi.compras.model;

import java.time.LocalDate;
import java.util.List; 

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity     
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany
    @JoinTable(name = "PRODUTO_PEDIDO", 
               joinColumns = @JoinColumn(name = "pedido_id"), 
               inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private List<Produto> produto; // Alterado para List

    private int quantidade;
    private LocalDate data;
    private double valor;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Pedido() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Produto> getProduto() { 
        return produto;
    }

    public void setProduto(List<Produto> produto) { 
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
