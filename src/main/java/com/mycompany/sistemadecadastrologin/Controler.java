/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecadastrologin;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gustavo
 */
public class Controler {
    private List<Cliente> clientes = new ArrayList();
    private List<Quarto> quartos = new ArrayList();
    private List<Reserva> reservas = new ArrayList();
            
    public void CadastrarCliente(String nome, String CPF, String Telefone){
        Cliente cliente = new Cliente(nome, CPF, Telefone);
        
        clientes.add(cliente);
        System.err.println("Cliente cadastrado com sucesso");
    }
    
    public void CadastrarQuarto(int numero, String tipo, double preco){
        Quarto quarto = new Quarto(numero, tipo, preco);
        
        quartos.add(quarto);
        System.out.println("Quarto cadastrado com sucesso");
    }

    public void FazerReserva(int NumeroQuarto, String CPF, int Dias){
        Cliente cliente = clientes.stream().filter(c -> c.getCPF().equals(CPF)).findFirst().orElse(null);
        
        Quarto quarto = quartos.stream().filter(q -> q.getNumero() == NumeroQuarto && !q.isOcupado()).findFirst().orElse(null);   
        
        if (cliente != null && quarto != null) {
            Reserva reserva = new Reserva(quarto, cliente, Dias);
            reservas.add(reserva);
            quarto.setOcupado(true);
            System.out.println("Reserva feita com sucesso");
            System.out.println(reserva);
        }else{System.out.println("Quarto ocupado ou n existe");}
    
    }
}
