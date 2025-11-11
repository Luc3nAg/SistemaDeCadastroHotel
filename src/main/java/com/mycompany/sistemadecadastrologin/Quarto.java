/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecadastrologin;

/**
 *
 * @author gustavo
 */
public class Quarto {
    private int numero;
    private String tipo;
    private boolean ocupado;
    private double preco;

    public Quarto() {
    }
    
    

    public Quarto(int numero, String tipo, double preco) {
        this.numero = numero;
        this.tipo = tipo;
        this.ocupado = false;
        this.preco = preco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    @Override
    public String toString() {
        return "Quarto " + numero + " (" + tipo + ") - R$" + preco + " | " +
               (ocupado ? "Disponível" : "Ocupado");
    }
    
}
