/*
 * - Esta classe trata exclusivamente da relação entre um quarto e um cliente durante um período (dias).
 * - Todos os atributos e métodos têm propósito claro e relacionado à reserva em si.
 * - Métodos como `calcularpreco()` e `getValorTotal()` são exemplos de comportamentos internos coesos,
 *   pois operam apenas sobre os dados da própria reserva.
 */

package com.mycompany.sistemadecadastrohotel.model;

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
        double preco = dias * quarto.getPreco();
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
        return "Quarto: " + quarto + 
               "\nHospede: " + hospede + 
               "\nDias: " + dias + 
               "\nPreço: " + calcularpreco() + "\n";
    }
}
