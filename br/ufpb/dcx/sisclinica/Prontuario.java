package br.ufpb.dcx.sisclinica;
import java.util.List;
import java.util.ArrayList;

public class Prontuario {
	
	private Paciente paciente;
	private String dataProntuario;
	private List<Exame> listaExame;
	private String diagnostico;
	private Medico medicoAtual;
	private List<String> sintomas;
	
	public Prontuario (Paciente paciente, String dataProntuario, ArrayList<Exame> exame, String diagnostico, Medico medicoAtual, ArrayList<String> sintomas) {
		this.paciente = paciente;
		this.dataProntuario = dataProntuario;
		this.listaExame = exame;
		this.diagnostico = diagnostico;
		this.medicoAtual = medicoAtual;
		this.sintomas = sintomas;
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

	public List<Exame> getExame() {
		return this.listaExame;
	}

	public void setExame(ArrayList<Exame> exame) {
		this.listaExame = exame;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public Medico getMedicoAtual() {
		return medicoAtual;
	}

	public void setMedicoAtual(Medico medicoAtual) {
		this.medicoAtual = medicoAtual;
	}

	public List<String> getSintomas() {
		return sintomas;
	}

	public void setSintomas(ArrayList<String> sintomas) {
		this.sintomas = sintomas;
	}
	
	public void novoSintoma(String sintomaNovo) {
		this.sintomas.add(sintomaNovo);
	}
	
	public void novoDiagnostico(String diagnosticoNovo) {
		this.diagnostico = diagnosticoNovo;
	}
	
	public void novoExame(Exame exameNovo) {
		this.listaExame.add(exameNovo);
	}
}
