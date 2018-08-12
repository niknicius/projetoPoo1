package br.ufpb.dcx.sisclinica;

import br.ufpb.dcx.sisclinica.Exceptions.ConsultaJaExisteException;
import br.ufpb.dcx.sisclinica.Exceptions.ExameJaExisteException;

public class Atendente {
	
	private String nome;
	private double salario;
        private Agenda agenda;
	
	public Atendente(String nome, double salario) {
		this.nome = nome;
		this.salario = salario;
                this.agenda = new Agenda();
	}
	
	public void marcaConsulta(Paciente paciente, Medico medico, String dataConsulta, String dataRetorno) throws ConsultaJaExisteException {
		Consulta c = new Consulta(paciente, medico, dataConsulta, dataRetorno, false);
		this.agenda.adicionaConsulta(c);
	}
	
	public void marcaExame(Paciente paciente, String dataExame, double valor, String dataRetorno) throws ExameJaExisteException {
		Exame e = new Exame(paciente, dataExame, valor, dataRetorno);
                this.agenda.adicionaExame(e);
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

}
