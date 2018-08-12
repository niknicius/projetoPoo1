package br.ufpb.dcx.sisclinica;

import java.util.List;
import java.util.ArrayList;

public class Paciente {
	private String nome;
	private int idade;
	private String dataNascimento;
	private String cpf;
	private List<String> sintomas;
	private Prontuario prontuario;

	
	public Paciente (){
	}
	
	public Paciente (String nome, int idade, String dataNascimento, String cpf, ArrayList<String> sintomas, Prontuario prontuario) {
	this.nome = nome;
	this.idade = idade;
	this.dataNascimento = dataNascimento;
	this.cpf = cpf;
	this.sintomas = sintomas;
	this.prontuario = prontuario;
	}
	
	public String getNome() {
            return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getIdade() {
		return this.idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String dataNascimento() {
		return this.dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public List<String> getSintomas(){
		return this.sintomas;
	}
	
	public void setSintomas(ArrayList<String> sintomas) {
		this.sintomas = sintomas;
	}
	
	public Prontuario getProntuario() {
		return this.prontuario;
	}
	
	public void setProntuario(Prontuario prontuario) {
		this.prontuario = prontuario;
	}
}