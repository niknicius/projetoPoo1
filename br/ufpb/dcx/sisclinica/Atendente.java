package br.ufpb.dcx.sisclinica;


public class Atendente implements Funcionario{
	
	private String nome;
        private String cpf;
	private double salario;
	
	public Atendente(String nome,String cpf, double salario) {
		this.nome = nome;
                this.cpf = cpf;
		this.salario = salario;
	}
	
	public void marcaConsulta(Paciente paciente, Medico medico, String dataConsulta, String dataRetorno) {
		Consulta c = new Consulta(paciente, medico, dataConsulta, dataRetorno, false);
		
	}
	
	public void marcaExame(Paciente paciente, String dataExame, double valor, String dataRetorno) {
		Exame e = new Exame(paciente, dataExame, valor, dataRetorno);
		
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
