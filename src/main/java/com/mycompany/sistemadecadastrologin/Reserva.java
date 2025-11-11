/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecadastrologin;

/**
 *
 * @author gustavo
 */
public class Reserva {
    private Quarto quarto;
    private Cliente hospede;
    private int dias;

    public Reserva() {
    }

    public Reserva(Quarto quarto, Cliente hospede, int dias) {
        this.quarto = quarto;
        this.hospede = hospede;
        this.dias = dias;
    }
    
    public double calcularpreco(){
        double preco = dias* quarto.getPreco();
        return preco;
    }

    @Override
    public String toString() {
        return "quarto=" + quarto + ", hospede=" + hospede + ", dias = " + dias + "Preco: " + calcularpreco();
    }
    
    
}

