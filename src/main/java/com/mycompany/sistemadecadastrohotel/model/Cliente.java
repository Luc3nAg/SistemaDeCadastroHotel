/*
 * - A classe tem uma única responsabilidade: representar um cliente do sistema.
 * - Ela contém apenas os dados e comportamentos diretamente ligados a um cliente
 *   (nome, CPF, telefone e seus getters/setters).
 * - Isso evita que ela se torne uma classe "inchada" com responsabilidades de outras áreas,
 *   mantendo o código simples, compreensível e de fácil manutenção.
 */

package com.mycompany.sistemadecadastrohotel.model;


/**
 *
 * @author gustavo
 */
public class Cliente {
    private String nome;
    private String CPF;
    private String Telefone;

    public Cliente() {
    }

    public Cliente(String nome, String CPF, String Telefone) {
        this.nome = nome;
        this.CPF = CPF;
        this.Telefone = Telefone;        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    @Override
    public String toString() {
        return nome + " | CPF: " + CPF + " | Telefone: " + Telefone;
    }
}
