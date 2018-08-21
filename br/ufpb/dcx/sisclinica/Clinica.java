/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.dcx.sisclinica;

import br.ufpb.dcx.sisclinica.exceptions.ConsultaJaExisteException;
import br.ufpb.dcx.sisclinica.exceptions.ExameJaExisteException;
import br.ufpb.dcx.sisclinica.exceptions.FilaVaziaException;
import br.ufpb.dcx.sisclinica.exceptions.FuncionarioJaExisteException;
import br.ufpb.dcx.sisclinica.exceptions.FuncionarioNaoExisteException;
import br.ufpb.dcx.sisclinica.exceptions.MedicoNaoExisteException;
import br.ufpb.dcx.sisclinica.exceptions.PacienteJaEstaNaFilaException;
import br.ufpb.dcx.sisclinica.exceptions.PacienteJaExisteException;
import br.ufpb.dcx.sisclinica.exceptions.PacienteNaoExisteException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nikni
 */
public class Clinica {
    
    private String nome;
    private List<Paciente> pacientes;
    private List<Funcionario> funcionarios;
    private Fila fila;
    private Agenda agenda;
    
    public Clinica(String nome){
        this.nome = nome;
        this.pacientes = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        this.fila = new Fila();
        this.agenda = new Agenda();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    public void adicionarFuncionario(Funcionario funcionario) throws FuncionarioJaExisteException{
        for(Funcionario f : this.getFuncionarios()){
            if(f.getNome().equalsIgnoreCase(funcionario.getNome()) && f.getCpf().equalsIgnoreCase(funcionario.getCpf())){
                throw new FuncionarioJaExisteException("Funcionario já existe no sistema!");
            }
        }
        this.funcionarios.add(funcionario);
    }
    
    public void adicionarPaciente(Paciente paciente) throws PacienteJaExisteException{
        for(Paciente p : this.getPacientes()){
            if(p.getNome().equalsIgnoreCase(paciente.getNome()) && p.getCpf().equalsIgnoreCase(paciente.getCpf())){
                throw new PacienteJaExisteException("Paciente já existe no sistema!");
            }
        }
        this.pacientes.add(paciente);
    }
    
    public Funcionario procurarMedico(String cpf) throws MedicoNaoExisteException{
        for(Funcionario f : this.getFuncionarios()){
            if(f.getCpf().equalsIgnoreCase(cpf) && f instanceof Medico){
                return f;
            }
        }
        throw new MedicoNaoExisteException("Médico não encontrado! Por favor procurar o RH");
    }
    
    public Funcionario procurarFuncionario(String cpf) throws FuncionarioNaoExisteException{
        for(Funcionario f : this.getFuncionarios()){
            if(f.getCpf().equalsIgnoreCase(cpf)){
                return f;
            }
        }
        throw new FuncionarioNaoExisteException("Funcionario não encontrado! Por favor procurar o RH");
    }
    
    public Paciente procurarPaciente(String cpf) throws PacienteNaoExisteException{
        for(Paciente p : this.getPacientes()){
            if(p.getCpf().equalsIgnoreCase(cpf)){
                return p;
            }
        }
        throw new PacienteNaoExisteException("Paciente não encontrado!");
    }
    
    public void adicionarPacienteFila(Paciente paciente) throws PacienteJaEstaNaFilaException{
        
        for(Paciente p : this.getFila().getPacientes()){
            if(p.getCpf().equalsIgnoreCase(paciente.getCpf())){
                throw new PacienteJaEstaNaFilaException("Paciente já está na fila!");
            }
        }
        
        this.fila.addPacienteNaFila(paciente);
    }
    
    public Paciente removePrimeiroDaFila() throws FilaVaziaException{
        return this.getFila().removerProximoDaFila();
    }
    
    public void marcarConsulta(Consulta con) throws ConsultaJaExisteException{
        for(Consulta c : this.getAgenda().getConsultas()){
            if(c.getPaciente().getNome().equalsIgnoreCase(con.getPaciente().getNome())){
                throw new ConsultaJaExisteException("Consulta já marcada na agenda");
            }
        }
        this.agenda.adicionaConsulta(con);
    }
    
    public void marcarExame(Exame exame) throws ExameJaExisteException{
        for(Exame e : this.getAgenda().getExames()){
            if(e.getPaciente().getNome().equalsIgnoreCase(exame.getPaciente().getNome())){
                throw new ExameJaExisteException("Exame já marcado na agenda");
            }
        }
        this.agenda.adicionaExame(exame);
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }
    
    

    public Fila getFila() {
        return fila;
    }

    public void setFila(Fila fila) {
        this.fila = fila;
    }
    
    
}