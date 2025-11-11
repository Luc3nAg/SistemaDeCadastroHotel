/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecadastrologin.control;

import java.util.ArrayList;
import java.util.List;
import com.mycompany.sistemadecadastrologin.model.*;

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
            System.out.println("\n=== Reserva feita com sucesso ===");
            System.out.println(reserva);
        }else {
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║  ERRO: Quarto ocupado ou não existe!   ║");
            System.out.println("╚════════════════════════════════════════╝");
        }
    }

    public void FazerCheckout(int NumeroQuarto) {
        Quarto quarto = quartos.stream().filter(q -> q.getNumero() == NumeroQuarto && q.isOcupado()).findFirst().orElse(null);

        if(quarto != null) {
            Reserva reserva = reservas.stream().filter(r -> r.getQuarto().getNumero() == NumeroQuarto).findFirst().orElse(null);

            if(reserva != null) {
                quarto.setOcupado(false);
                reservas.remove(reserva);

                System.out.println("\n=== CHECKOUT REALIZADO COM SUCESSO ===");
                System.out.println("Cliente: " + reserva.getHospede().getNome());
                System.out.println("Quarto: " + reserva.getQuarto().getNumero());
                System.out.println("Tipo: " + reserva.getQuarto().getTipo());
                System.out.println("Dias hospedado: " + reserva.getDias());
                System.out.println("Valor total: R$" + reserva.getValorTotal());
            }
        } else {
            System.out.println("Não existe reserva para este quarto ou ele já está desocupado.");
        }
    }
}
