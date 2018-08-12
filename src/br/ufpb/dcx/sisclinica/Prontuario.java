package br.ufpb.dcx.sisclinica;



public class Prontuario {
	
	private Paciente paciente;
	private String dataProntuario;
	private String pressaoArterial;
	private String medicaoAtual;
	
	public Prontuario (Paciente paciente, String dataProntuario, String pressaoArterial,  String medicaoAtual) {
		this.paciente = paciente;
		this.dataProntuario = dataProntuario;
		this.pressaoArterial = pressaoArterial;
		this.medicaoAtual = medicaoAtual;
		}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getDataProntuario() {
		return dataProntuario;
	}

	public void setDataProntuario(String dataProntuario) {
		this.dataProntuario = dataProntuario;
	}

	public String getPressaoArterial() {
		return pressaoArterial;
	}

	public void setPressaoArterial(String pressaoArterial) {
		this.pressaoArterial = pressaoArterial;
	}

	public String getMedicaoAtual() {
		return medicaoAtual;
	}

	public void setMedicaoAtual(String medicaoAtual) {
		this.medicaoAtual = medicaoAtual;
	}
	
	
}
