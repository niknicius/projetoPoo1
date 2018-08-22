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
        this.listaExame = new ArrayList<>();
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
        
        if(this.getSintomas() == null || this.getSintomas().isEmpty()){
            stringSintomas = "Sintomas não cadastrados";
        }
        else{
            stringSintomas = this.getSintomas().stream().map((s) -> s + " \n").reduce(stringSintomas, String::concat);
        }
        String stringDiagnostico = "";
        if(this.getDiagnostico() == null || this.getDiagnostico().length() == 0){
          stringDiagnostico = "Não diagnosticado";
        }
        else{
            stringDiagnostico = this.getDiagnostico();
        }
        
        
        String stringExames = "";
        if(this.getListaExame() == null || this.getListaExame().isEmpty()){
           stringDiagnostico = "Sem exames realizados";
        }
        else{
          stringExames = this.getListaExame().stream().map((s) -> s + " \n").reduce(stringExames, String::concat);
        }
        
        String stringReceita = "";
        if(this.getReceita() == null){;
            stringReceita = "Sem receita cadastrada";
        }
        else{
            stringReceita = this.getReceita().toString();
        }
        return "Diagnostico :" + stringDiagnostico + "\nSintomas: " + stringSintomas + "\nExames: " + stringExames + "\nReceita:" + stringReceita;
    }

}
