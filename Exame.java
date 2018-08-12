
public class Exame {
	private Paciente paciente;
	private String dataExame;
	private double valor;
	private String dataResultado;
	
	public Exame(Paciente paciente, String dataExame, double valor, String dataResultado) {
		this.paciente = paciente;
		this.dataExame = dataExame;
		this.valor = valor;
		this.dataResultado = dataResultado;
	}
	
	public Paciente getPaciente() {
		return this.paciente;
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public String getDataExame() {
		return this.dataExame;
	}
	
	public void setDataExame(String dataExame) {
		this.dataExame = dataExame;
	}
	
	public double getValor() {
		return this.valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public String getDataResultado() {
		return this.dataResultado;
	}
	
	public void setDataResultado(String dataResultado) {
		this.dataResultado = dataResultado;
	}

}
