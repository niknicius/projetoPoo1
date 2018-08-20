package br.ufpb.dcx.sisclinica;

import br.ufpb.dcx.sisclinica.exceptions.FilaVaziaException;
import java.util.ArrayList;

/**
 * @author amanda.pereira   
 */

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
			if(!p.getCpf().equalsIgnoreCase(paciente.getCpf()) && !p.getTipoConsulta().equalsIgnoreCase(paciente.getTipoConsulta())) {
				this.pacientes.add(paciente);
			}
		}
	}
	
        @Deprecated
	public void removerPacienteDaFila(Paciente paciente) {
		for(Paciente p: this.pacientes) {
			if(p.getNome().equalsIgnoreCase(paciente.getNome()) && p.getTipoConsulta().equalsIgnoreCase(paciente.getTipoConsulta())) {
				this.pacientes.remove(paciente);
			}
		}
	}
        
        public Paciente removerProximoDaFila() throws FilaVaziaException{
            if(this.getPacientes().isEmpty()){
                System.out.println("erro");
                throw new FilaVaziaException("A fila está vazia!");
            }
            else{
                return this.getPacientes().remove(0);
            }
        }
}
