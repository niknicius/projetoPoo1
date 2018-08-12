package br.ufpb.dcx.sisclinica;

public class Medico {
	private String nome;
	private String especialidade;
	private String crm;
	private String cpf;
	private int salaDeAtendimento;
	private double salario;
	private boolean plantao;
	
	public Medico(String nome, String especialidade, String crm,
			String cpf, int salaDeAtendimento, double salario, boolean plantao) {
		this.setNome(nome);
		this.setEspecialidade(especialidade);
		this.setCrm(crm);
		this.setCpf(cpf);
		this.setSalaDeAtendimento(salaDeAtendimento);
		this.setSalario(salario);
		this.setPlantao(plantao);
	}
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getSalaDeAtendimento() {
		return salaDeAtendimento;
	}

	public void setSalaDeAtendimento(int salaDeAtendimento) {
		this.salaDeAtendimento = salaDeAtendimento;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}



	public boolean getPlantao() {
		return plantao;
	}



	public void setPlantao(boolean plantao) {
		this.plantao = plantao;
	}
	
}
