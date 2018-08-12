package br.ufpb.dcx.sisclinica;

import java.util.ArrayList;

public class Fila {
	private ArrayList<Paciente> pacientes;
	
	public Fila() {
		this.pacientes = new ArrayList<>();
		
	}
	
	public ArrayList<Paciente> getPacientes(){
		return this.pacientes;
	}
	
	public void setPacientes(ArrayList<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	
	public void addPacienteNaFila(Paciente paciente) {
		for(Paciente p: this.pacientes) {
			if(p.getNome().equalsIgnoreCase(paciente.getNome())) {
				this.pacientes.add(paciente);
			}
		}
	}
	
	public void removerPacienteDaFila(Paciente paciente) {
		for(Paciente p: this.pacientes) {
			if(p.getNome().equalsIgnoreCase(paciente.getNome())) {
				this.pacientes.remove(paciente);
			}
		}
	}
}
