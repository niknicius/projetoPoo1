import java.util.List;

public class Receita {
	
	private Medico medico;
	private Paciente paciente;
	private String data;
	private Medicamento medicamento;
	private String dosagem;
	private List<Medicamento> medicamentos;
	
	public Receita(Medico medico, Paciente paciente, String data, String medicamento, String dosagem) {
		this.medico = medico;
		this.paciente = paciente;
		this.data = data;
		this.medicamento = medicamento;
		this.dosagem = dosagem;
	}
	
	public void cadastraMedicamento(Medicamento medicamento) throws MedicamentoJaExisteException {
		for(Medicamento med: medicamentos)
			if(medicamento.getNome().equals(med.getNome())) {
				if(medicamento.getMiligrama().equals(med.getMiligrama())) {
					throw new MedicamentoJaExisteException("O medicamento de nome"+medicamento.getNome()+ " e miligrama"+medicamento.getMiligrama()+" já existe");
				}
			}else {
				medicamentos.add(medicamento);
		}
	}
	
	public String imprimeReceita() {
		return "Medico "+this.Medico.getNome()+"\n"
				+"Paciente "+this.paciente.getNome()+"\n"
				+"Data "+this.data+"\n"
				+"Medicamento "+this.medicamento.getNome()+this.medicamento.getMiligrama()+"\n"
				+"Dosagem "+this.dosagem;
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

	public Medicamento getMedicamentos() {
		return medicamento;
	}

	public void setMedicamentos(Medicamento medicamento) {
		this.medicamento = medicamento;
	}
	
	public String getNomeMedicamento() {
		return this.medicamento.getNome();
	}


	
	

}
