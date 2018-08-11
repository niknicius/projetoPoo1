package br.ufpb.dcx;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vinnicius.santos@dce.ufpb.br
 * A classe recebe Exames e Consutas de um determinado paciente e adiciona nos respectivos arrays
 */
public class Agenda{
    
    private List<Consulta> consultas;
    private List<Exame> exames;

    /**
     * Consutrutor
     */
    
    public Agenda() {
        this.exames = new ArrayList<>();
        this.consultas = new ArrayList<>();
    }

    /**
     * 
     * @return 
     */
    public List<Consulta> getConsultas() {
        return consultas;
    }
    /**
     * 
     * @param consultas 
     */
    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
    /**
     * 
     * @return 
     */
    public List<Exame> getExames() {
        return exames;
    }
    /**
     * 
     * @param exames 
     */
    public void setExames(List<Exame> exames) {
        this.exames = exames;
    }
    /**
     * 
     * @param exame (Recebe um exame para cadastrar na agenda)
     * @throws ExameJaExisteException (Caso o exame ja tenha sido cadastrado uma exceção é lançada)
     */
    public void adicionaExame(Exame exame) throws ExameJaExisteException{
        for(Exame ex : this.getExames()){
            if(ex.getPaciente().getNome().equalsIgnoreCase(exame.getPaciente().getNome())){
                throw new ExameJaExisteException("O exame deste paciente já foi marcado!");
            }    
                
        }
        this.exames.add(exame);
    }
    /**
     * 
     * @param consulta (Recebe uma consulta para cadastrar na agenda)
     * @throws ConsultaJaExisteException (Caso a consulta ja tenha sido cadastrada uma exceção é lançada)
     */
    public void adicionaConsulta(Consulta consulta) throws ConsultaJaExisteException{
        for(Consulta cn : this.getConsultas()){
            if(cn.getPaciente().getNome().equalsIgnoreCase(consulta.getPaciente().getNome())){
                throw new ConsultaJaExisteException("A consulta deste paciente já foi marcada");
            }    
                
        }
        this.consultas.add(consulta);

    }
    /**
     * 
     * @param paciente
     * @return 
     */
    public Consulta pesquisaConsultaPaciente(Paciente paciente){
        for(Consulta cn : this.getConsultas()){
            if(cn.getPaciente().getNome().equalsIgnoreCase(paciente.getNome()) && cn.getAberta()){
                return cn;
            }
        }
        
        return null;
    }
    
    /**
     * 
     * @param paciente (Recebe um paciente e analisa se existe um exame para este)
     * @return (Retorna o exame caso exista ou nulo caso não exista)
     */
        public Exame pesquisaExamePaciente(Paciente paciente){
        for(Exame ex : this.getExames()){
            if(ex.getPaciente().getNome().equalsIgnoreCase(paciente.getNome())){
                return ex;
            }
        }
        
        return null;
    }
    
}
