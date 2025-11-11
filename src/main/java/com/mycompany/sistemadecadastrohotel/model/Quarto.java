/*
 * - A classe lida apenas com informações que pertencem ao quarto (número, tipo, preço, ocupado).
 * - Nenhum método aqui faz reserva, checkout ou cálculos externos — cada método atua dentro
 *   da responsabilidade de um quarto.
 * - Assim, o código é fácil de manter, testar e compreender.
 */

package com.mycompany.sistemadecadastrohotel.model;

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
        return "" + numero + 
        " (" + tipo + ") " +
        "\n" + preco +
        (ocupado ? "\nDisponível" : "\nOcupado");
    }
}
