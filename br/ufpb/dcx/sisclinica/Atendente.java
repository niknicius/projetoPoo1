package br.ufpb.dcx.sisclinica;

import br.ufpb.dcx.sisclinica.exceptions.ConsultaJaExisteException;
import br.ufpb.dcx.sisclinica.exceptions.ExameJaExisteException;


public class Atendente implements Funcionario{
	
	private String nome;
        private String cpf;
	private double salario;
        private Agenda agenda;
	
	public Atendente(String nome,String cpf, double salario) {
		this.nome = nome;
                this.cpf = cpf;
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

        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }

}
