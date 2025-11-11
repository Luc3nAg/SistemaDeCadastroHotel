/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecadastrologin;


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
        return nome + ", CPF=" + CPF + ", Telefone=" + Telefone;
    }
    
}