package br.ufpb.dcx.sisclinica;

import br.ufpb.dcx.sisclinica.exceptions.MedicamentoJaExisteException;
import java.util.ArrayList;
import java.util.List;

public class Receita {
	
	private Medico medico;
	private Paciente paciente;
	private String data;
	private List<Medicamento> medicamentos;
	
	public Receita(Medico medico, Paciente paciente, String data){
		this.medico = medico;
		this.paciente = paciente;
		this.data = data;
                this.medicamentos = new ArrayList<>();
	}
	
	public void cadastraMedicamento(Medicamento medicamento) throws MedicamentoJaExisteException {
		for(Medicamento med: medicamentos)
			if(medicamento.getNome().equals(med.getNome())) {
				if(medicamento.getMiligrama().equals(med.getMiligrama())) {
					throw new MedicamentoJaExisteException("O medicamento de nome" + medicamento.getNome() + " e miligrama"+medicamento.getMiligrama()+" j� existe");
				}
			}else {
				medicamentos.add(medicamento);
		}
	}
	
        @Override
	public String toString() {
            
            String stringMedicamentos = "";
            for(Medicamento m : this.getMedicamentos()){
                stringMedicamentos += m.getNome();
                stringMedicamentos += " :" +m.getMiligrama() + "\n";
            }
		return "Medico: "+this.medico.getNome()+"\n"
				+"Paciente: "+this.paciente.getNome()+"\n"
				+"Data: "+this.data+"\n"
				+"Medicamentos: "+stringMedicamentos;
	}
	
	public Medico getMedico() {
		return this.medico;
	}
	
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }
        
        


	
	

}
