package br.ufpb.dcx.sisclinica;

import java.util.List;
import java.util.ArrayList;

/**
 * 
 * @author tulio.jose
 */

public class Prontuario {

    private String dataProntuario;
    private List<String> listaExame;
    private String diagnostico;
    private Medico medicoAtual;
    private List<String> sintomas;
    private Receita receita;

    public Prontuario(String dataProntuario, List<String> listaExame, String diagnostico, Medico medicoAtual, List<String> sintomas) {
        this.dataProntuario = dataProntuario;
        this.listaExame = listaExame;
        this.diagnostico = diagnostico;
        this.medicoAtual = medicoAtual;
        this.sintomas = sintomas;
    }

    public String getDataProntuario() {
        return dataProntuario;
    }

    public void setDataProntuario(String dataProntuario) {
        this.dataProntuario = dataProntuario;
    }

    public List<String> getListaExame() {
        return this.listaExame;
    }

    public void setListaExame(ArrayList<String> exame) {
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

    public void novoExame(String exameNovo) {
        this.listaExame.add(exameNovo);
    }

    public Receita getReceita() {
        return receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }
    
    
    @Override
    public String toString(){
        
        String stringSintomas = "";
        
        stringSintomas = this.getSintomas().stream().map((s) -> s + " \n").reduce(stringSintomas, String::concat);
        
        String stringDiagnostico;
        if(this.getDiagnostico() == null){
            stringDiagnostico = "Não diagnosticado";
        }
        else{
            stringDiagnostico = this.getDiagnostico();
        }
        
        stringSintomas = this.getSintomas().stream().map((s) -> s + " \n").reduce(stringSintomas, String::concat);
        
        String stringExames = "";
        if(this.getListaExame().size() == 0){
            stringDiagnostico = "Sem exames realizados";
        }
        else{
            stringExames = this.getListaExame().stream().map((s) -> s + " \n").reduce(stringExames, String::concat);
        }
        
        return "Diagnostico :" + stringDiagnostico + "\n Sintomas: " + stringSintomas + "\nExames: " + stringExames + "\n Receita:" + this.getReceita().toString();
    }

}
