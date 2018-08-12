/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.dcx.sisclinica;

import br.ufpb.dcx.sisclinica.Exceptions.MedicoJaExisteException;
import br.ufpb.dcx.sisclinica.Exceptions.PacienteJaExisteException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nikni
 */
public class Clinica {
    
    String nome;
    List<Medico>medicos;
    List<Paciente> pacientes;
    
    public Clinica(String nome){
        this.nome = nome;
        this.medicos = new ArrayList<>();
        this.pacientes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
    
    public void adicionarMedico(Medico medico) throws MedicoJaExisteException{
        for(Medico m : this.getMedicos()){
            if(m.getNome().equalsIgnoreCase(medico.getNome()) && m.getCpf().equalsIgnoreCase(medico.getCpf())){
                throw new MedicoJaExisteException("Médico já existe no sistema!");
            }
        }
        this.medicos.add(medico);
    }
    
    public void adicionarPaciente(Paciente paciente) throws PacienteJaExisteException{
        for(Paciente p : this.getPacientes()){
            if(p.getNome().equalsIgnoreCase(paciente.getNome()) && p.getCpf().equalsIgnoreCase(paciente.getCpf())){
                throw new PacienteJaExisteException("Paciente já existe no sistema!");
            }
        }
        this.pacientes.add(paciente);
    }
}