/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemadecadastrologin;

/**
 *
 * @author gustavo
 */
public class SistemaDeCadastroLogin {

    public static void main(String[] args) {
        Controler con = new Controler();
        System.out.println("HOTEL JAVA");
        System.out.println("SEJA BEM VINDO AO HOTEL JAVA");
        
        con.CadastrarCliente("Ana Silva", "12345678900", "99999-9999");
        con.CadastrarCliente("Carlos Souza", "98765432100", "88888-8888");
        con.CadastrarCliente("Mariana Lima", "11122233344", "97777-7777");
        
        con.CadastrarQuarto(101, "Simples", 150.0);
        con.CadastrarQuarto(102, "Luxo", 200.0);
        con.CadastrarQuarto(103, "Suite Master", 300);
        
        con.FazerReserva(101, "12345678900", 5);
        con.FazerReserva(102, "98765432100", 3);
        con.FazerReserva(103, "11122233344", 3);
        con.FazerReserva(103, "12345678900", 2);
        
    }
}
