/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecadastrologin.model;

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

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Cliente getHospede() {
        return hospede;
    }

    public void setHospede(Cliente hospede) {
        this.hospede = hospede;
    }

    public int getDias() {
        return dias;
    }

    public double getValorTotal() {
        return dias * quarto.getPreco();
    }

    @Override
    public String toString() {
        return "Quarto: " + quarto + "\nHospede: " + hospede + "\nDias: " + dias + "\nPreço: " + calcularpreco() + "\n";
    }
    
    
}

