/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.sistemadecadastrohotel.view;

import com.mycompany.sistemadecadastrohotel.control.Controler;

/**
 *
 * @author gustavo
 * 
 * Agora no main onde tudo é executado
 */
public class SistemaDeCadastroHotel {

    public static void main(String[] args) {
        Controler con = new Controler();
        System.out.println("HOTEL JAVA");
        System.out.println("SEJA BEM VINDO AO HOTEL JAVA");

        con.CadastrarCliente("Ana Silva", "12345678900", "99999-9999");
        con.CadastrarCliente("Carlos Souza", "98765432100", "88888-8888"); //Adicionando os clientes 
        con.CadastrarCliente("Mariana Lima", "11122233344", "97777-7777");
        
        System.out.println("");

        con.CadastrarQuarto(101, "Simples", 150.0);
        con.CadastrarQuarto(102, "Luxo", 200.0); // Adicionando os quartos 
        con.CadastrarQuarto(103, "Suite Master", 300);

        con.FazerReserva(101, "12345678900", 5);
        con.FazerReserva(102, "98765432100", 3);
        con.FazerReserva(103, "11122233344", 3); // Fazendo as reservas 
        con.FazerReserva(103, "12345678900", 2); // testando a reserva em quartos já ocupados 

        con.FazerCheckout(101);
        con.FazerCheckout(102); // fazendo Checkouts
        con.FazerCheckout(103);

        con.FazerReserva(101, "12345678900", 5); // realizando uma reserva em um quarto liberado
    }
}
