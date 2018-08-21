package br.ufpb.dcx.sisclinica;

import br.ufpb.dcx.sisclinica.exceptions.ConsultaJaExisteException;
import br.ufpb.dcx.sisclinica.exceptions.ExameJaExisteException;

public class Atendente implements Funcionario {

    private String nome;
    private String cpf;
    private double salario;
    private final int nivelDeAcesso;

    public Atendente(String nome, String cpf, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.nivelDeAcesso = 2;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public int getNivelDeAcesso() {
        return nivelDeAcesso;
    }

}
