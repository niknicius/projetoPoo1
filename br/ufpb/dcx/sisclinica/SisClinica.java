/*
 */
package br.ufpb.dcx.sisclinica;

import br.ufpb.dcx.sisclinica.exceptions.FilaVaziaException;
import br.ufpb.dcx.sisclinica.exceptions.FuncionarioJaExisteException;
import br.ufpb.dcx.sisclinica.exceptions.FuncionarioNaoExisteException;
import br.ufpb.dcx.sisclinica.exceptions.MedicamentoJaExisteException;
import br.ufpb.dcx.sisclinica.exceptions.MedicoNaoExisteException;
import br.ufpb.dcx.sisclinica.exceptions.PacienteJaEstaNaFilaException;
import br.ufpb.dcx.sisclinica.exceptions.PacienteJaExisteException;
import br.ufpb.dcx.sisclinica.exceptions.PacienteNaoExisteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author nikni
 */
public class SisClinica {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        
        Clinica clinica;
        try {
            clinica = (Clinica) SalvarDados.recuperarDados();
        } catch (Exception ex) {
            clinica = new Clinica("Clinex");
        }
        
        mostraMensagem("Bem Vindo ao SisClinica!","Bem Vindo(a)",1);
        Date dataAtual = new Date();
        
        String cargo = JOptionPane.showInputDialog("Digite a opção que descreve seu cargo:\n"
                + "1 - Médico\n"
                + "2 - Atendente");
        while(cargo != null){
            switch(cargo){
                case "1":
                    String opcaoMedico = mostraInput("Digite o numero da opção desejada:\n"
                            + "1 - Cadastrar\n"
                            + "2 - Entrar\n"
                            + "3 - Voltar", "Menu médico",3);
                    
                    while(opcaoMedico != null){
                        switch(opcaoMedico){
                            case "1":
                                String nomeMedicoCadastrar = mostraInput("Digite seu nome completo","Cadastrando novo médico",3);
                                String especialidadeMedicoCadastrar = mostraInput("Digite sua especialidade","Cadastrando novo médico",3);
                                String crmMedicoCadastrar = mostraInput("Digite seu CRM completo","Cadastrando novo médico",3);
                                String cpfMedicoCadastrar = mostraInput("Digite seu CPF completo","Cadastrando novo médico",3);
                                boolean salaValida = false;
                                int salaAtendimentoMedicoCadastrar = 0;
                                while(!salaValida)
                                try{
                                    salaAtendimentoMedicoCadastrar = Integer.parseInt(mostraInput("Digite a sala onde deseja realizar os atendimentos","Cadastrando novo médico",3));
                                    salaValida = true;
                                }
                                catch(NumberFormatException ex){
                                    mostraMensagem("Sala Inválida!","Erro",0);
                                }
                                Funcionario medico = new Medico(nomeMedicoCadastrar,especialidadeMedicoCadastrar,crmMedicoCadastrar,cpfMedicoCadastrar,salaAtendimentoMedicoCadastrar,1000.0,false);
                                try{
                                    clinica.adicionarFuncionario(medico);
                                    mostraMensagem("Médico cadastrado com sucesso!", "Cadastro de médico", 1);
                                }
                                catch(FuncionarioJaExisteException ex){
                                    mostraMensagem(ex.getMessage(), "Erro!", 0);
                                }
                                break;
                            
                            // Login Médico    
                            case "2":
                                String cpfLogar = mostraInput("Digite seu CPF:", "Login Médico",3);
                                try{
                                    Funcionario medicoLogar = clinica.procurarMedico(cpfLogar);
                                    if(medicoLogar.getNivelDeAcesso() != 1){
                                    mostraMensagem("Area restrita", "Erro", 0);
                                    break;
                                }
                                    mostraMensagem("Bem vindo, " + medicoLogar.getNome() , "Login Médico", 1);
                                    String cpfPaciente = mostraInput("Digite o CPF do paciente que deseja realizar o atendimento:","Acessar paciente",3);
                                    try{
                                        Paciente pacienteConsulta = clinica.procurarPaciente(cpfPaciente);
                                        Prontuario prontuarioPacienteConsulta = pacienteConsulta.getProntuario();
                                        System.out.println(prontuarioPacienteConsulta.getDiagnostico());
                                        
                                        // Cast de Funcionario para Medico e Atualização do médico atual do prontuario
                                        Medico medicoAtualProntuario = (Medico) medicoLogar;
                                        prontuarioPacienteConsulta.setMedicoAtual(medicoAtualProntuario);
                                        
                                        String opcaoMedicoPaciente = mostraInput("Digite o número da opção desejada: \n"
                                                + "1 - Mostrar Prontuario\n"
                                                + "2 - Requisitar Exame\n"
                                                + "3 - Cadastrar Receita\n"
                                                + "4 - Atualizar diagnóstico", "Menu Médico -> Paciente", 3);
                                        
                                        while(opcaoMedicoPaciente != null){
                                        
                                            switch(opcaoMedicoPaciente){
                                                    case "1":
                                                        mostraMensagem("Prontuario de " + pacienteConsulta.getNome() + "\n" + prontuarioPacienteConsulta.toString(),"Prontuário de paciente",1);
                                                        break;
                                                    case "2":
                                                        boolean cadastrarNovoExamePacienteConsulta = true;
                                                        while(cadastrarNovoExamePacienteConsulta){
                                                            String novoExamePacienteConsulta = mostraInput("Digite o nome do exame que deseja adicionar ao prontuário:", "Prontuário de paciente",1);
                                                            if(novoExamePacienteConsulta != null){                                         
                                                                prontuarioPacienteConsulta.novoExame(novoExamePacienteConsulta);
                                                                System.out.println("Exame");
                                                            }
                                                            else{
                                                                cadastrarNovoExamePacienteConsulta = false;
                                                            }
                                                        }
                                                        
                                                        break;
                                                    case "3":
                                                        Receita receitaPaciente = new Receita((Medico) medicoLogar,pacienteConsulta,dataAtual.toString());
                                                        boolean medicamentoValido = false;
                                                        while(!medicamentoValido){
                                                            String nomeMedicamentoReceitaPaciente = mostraInput("Digite o nome do medicamento:","Cadastro de medicamento",3);
                                                            String miligramaMedicamentoReceitaPaciente = mostraInput("Digite a miligrama do medicamento " + nomeMedicamentoReceitaPaciente, "Cadastro de Medicamento",3);
                                                            if(nomeMedicamentoReceitaPaciente != null && miligramaMedicamentoReceitaPaciente != null){
                                                                Medicamento medicamentoReceitaPaciente = new Medicamento(nomeMedicamentoReceitaPaciente, miligramaMedicamentoReceitaPaciente);
                                                                try{
                                                                    receitaPaciente.cadastraMedicamento(medicamentoReceitaPaciente);
                                                                }
                                                                catch(MedicamentoJaExisteException ex){
                                                                    mostraMensagem(ex.getMessage(),"Erro!",0);
                                                                }
                                                            }
                                                            else{
                                                                medicamentoValido = false;
                                                            }
                                                        }
                                                        break;
                                                    case "4":
                                                        String novoDiagnosticoPaciente = mostraInput("Qual o novo diagnóstico?", "Atualizar Diagnóstico",3);
                                                        prontuarioPacienteConsulta.setDiagnostico(novoDiagnosticoPaciente);
                                                        mostraMensagem("Diagnóstico atualizado com sucesso!", "Atualizar Diagnóstico",1);
                                                        break;
                                                    
                                                    default:
                                                        mostraMensagem("Opção Inválida!","Erro!",0);
                                                    
                                                        
                                            }       
                                            
                                            opcaoMedicoPaciente = mostraInput("Digite o número da opção desejada: \n"
                                                + "1 - Mostrar Prontuario\n"
                                                + "2 - Requisitar Exame\n"
                                                + "3 - Cadastrar Receita\n"
                                                + "4 - Atualizar diagnóstico", "Menu Médico -> Paciente", 3);
                                        }
                                        
                                    }
                                    catch(PacienteNaoExisteException ex){
                                        mostraMensagem(ex.getMessage(),"Erro!",0);
                                    }
                                    
                                }
                                catch(MedicoNaoExisteException ex){
                                    mostraMensagem(ex.getMessage(),"Erro!",0);
                                }
                                break;
                            default:
                                opcaoMedico = null;
                        }
                        opcaoMedico = mostraInput("Digite o numero da opção desejada:\n"
                            + "1 - Cadastrar\n"
                            + "2 - Entrar\n"
                            + "3 - Voltar", "Menu médico",3);
                    }
                    
                    break;
                case "2":
                    String opcaoAtendente = mostraInput("Selecione a opção desejada:\n"
                            + "1 - Cadastrar\n"
                            + "2 - Entrar\n", "Menu Atendente",3);
                    while(opcaoAtendente != null){
                        switch(opcaoAtendente){
                            case "1":
                                String nomeAtendenteCadastrar = mostraInput("Digite o nome completo:","Cadastro Atendente",3);  
                                String cpfAtendenteCadastrar = mostraInput("Digite o cpf completo:","Cadastro Atendente",3); 
                                Atendente novoAtendente = new Atendente(nomeAtendenteCadastrar,cpfAtendenteCadastrar,980.00);
                                try{
                                    clinica.adicionarFuncionario(novoAtendente);
                                    mostraMensagem("Atendente cadastrado com sucesso!", "Cadastro Atendente", 1);
                                }
                                catch(FuncionarioJaExisteException ex){
                                    mostraMensagem(ex.getMessage(), "Erro", 0);
                                }
                                break;
                            case "2":
                                String cpfAtendenteLogar = mostraInput("Digite seu CPF completo:", "Login Atendente", 3);
                                try{
                                Funcionario atendenteLogar = clinica.procurarFuncionario(cpfAtendenteLogar);
                                if(atendenteLogar.getNivelDeAcesso() != 2){
                                    mostraMensagem("Area restrita", "Erro", 0);
                                    break;
                                }
                                mostraMensagem("Bem vindo, " + atendenteLogar.getNome() , "Login Atendente", 1);
                                }
                                catch(FuncionarioNaoExisteException ex){
                                    mostraMensagem(ex.getMessage(),"Erro!",0);
                                    break;
                                }
                                String opcaoAtendenteLogado = mostraInput("Selecione a opção desejada:\n"
                                        + "1 - Cadastrar paciente\n"
                                        + "2 - Adicionar paciente na fila\n"
                                        + "3 - Proximo da fila\n"
                                        + "4 - Verificar proxima consulta ou exame do paciente\n"
                                        + "5 - Marcar Exame"
                                        + "6 - Marcar consulta", "Menu Atendente Logado",3);
                                while(opcaoAtendenteLogado != null){
                                	switch(opcaoAtendenteLogado){
                                		case "1":
                                                        // Dados paciente
                                			String nomePacienteCadastrar = mostraInput("Digite o nome do paciente:", "Cadastrar paciente", 3);
                                			String racaPacienteCadastrar = mostraInput("Digite a raça do paciente:", "Cadastrar paciente", 3);
                                			String dataNascimentoPacienteCadastrar = mostraInput("Digite a data de nascimento do paciente:", "Cadastrar paciente", 3);
                                			String cpfPacienteCadastrar = mostraInput("Digite o CPF completo do paciente:", "Cadastrar paciente", 3);
                                			String rgPacienteCadastrar = mostraInput("Digite o RG completo do paciente:", "Cadastrar paciente", 3);
                                			String sexoPacienteCadastrar = mostraInput("Digite o sexo do paciente:", "Cadastrar paciente", 3);
                                			String nacionalidadePacienteCadastrar = mostraInput("Digite a nacionalidade do paciente:", "Cadastrar paciente", 3);
                                			String cepPacienteCadastrar = mostraInput("Digite o CEP do endereço do paciente:", "Cadastrar paciente", 3);
                                			String ufPacienteCadastrar = mostraInput("Digite a UF correspondente ao endereço do paciente:", "Cadastrar paciente", 3);
                                			String tipoConsultaPacienteCadastrar = mostraInput("Digite o tipo de exame que o paciente irá realizar:", "Cadastrar paciente", 3);
                                			
                                                        // Dados prontuario
                                                        String dataProntuarioPacienteCadastrar = dataAtual.toString();
                                                        String sintomasProntuarioPacienteCadastrar = mostraInput("Quais os sintomas do paciente?", "Cadastrar paciente",3);
                                                        List<String> listaSintomasProntuarioPacienteCadastrar = new ArrayList<>();
                                                        listaSintomasProntuarioPacienteCadastrar.add(sintomasProntuarioPacienteCadastrar);
                         
                                                        
                                                        Prontuario prontuarioPacienteCadastrar = new Prontuario(dataProntuarioPacienteCadastrar,null,null,null,listaSintomasProntuarioPacienteCadastrar);
                                                        // Cadastro Paciente
                                                        Paciente paciente1 = new Paciente (nomePacienteCadastrar, racaPacienteCadastrar, dataNascimentoPacienteCadastrar, cpfPacienteCadastrar, rgPacienteCadastrar, sexoPacienteCadastrar, nacionalidadePacienteCadastrar, cepPacienteCadastrar, ufPacienteCadastrar, tipoConsultaPacienteCadastrar,prontuarioPacienteCadastrar);
                                			try{
                                				clinica.adicionarPaciente(paciente1);
                                				mostraMensagem("Paciente cadastrado com sucesso!", "Cadastro de paciente", 1);
                                			}
                                			catch(PacienteJaExisteException ex){
                                				mostraMensagem(ex.getMessage(), "Erro!", 0);
                                			}
                                			break;
                                	case "2":
                                		String cpfAdd = mostraInput("Digite o cpf do paciente que deseja adicionar na fila:", "Adicionado paciente na fila", 3);
                                		try{
                                			Paciente pacienteAdd = clinica.procurarPaciente(cpfAdd);
                                			try{
                                				clinica.adicionarPacienteFila(pacienteAdd);
                                				mostraMensagem("Paciente adicionado com sucesso!", "Adição do Paciente Na Fila", 1);
                                			}
                                			catch(PacienteJaEstaNaFilaException ex){
                                				mostraMensagem(ex.getMessage(), "Erro!", 0);
                                			}
                                		}
                                		catch(PacienteNaoExisteException ex){
                                			mostraMensagem(ex.getMessage(), "Erro!", 0);
                                		}
                                		break;
                                        case "3":
                                            try{
                                                Paciente proximoDaFila = clinica.removePrimeiroDaFila();
                                                mostraMensagem("O próximo paciente a ser atendido é " + proximoDaFila.getNome(), "Próximo da Fila",3);
                                            }
                                            catch(FilaVaziaException ex){
                                                mostraMensagem(ex.getMessage(),"Erro",0);
                                            }
                                            
                                            break;
                                        // Verifica consultas e exames marcados para o paciente x    
                                        case "4":
                                            String cpfVerificarConsultas = mostraInput("Digite o cpf do paciente que verificar as proximas consultas e exames:", "Verificando agenda", 3);
                                        {
                                            try {
                                                Paciente pacienteVerificarConsultas = clinica.procurarPaciente(cpfVerificarConsultas);
                                                Consulta consultaVerificarConsultas = clinica.getAgenda().pesquisaConsultaPaciente(pacienteVerificarConsultas);
                                                Exame exameVerificarConsultas = clinica.getAgenda().pesquisaExamePaciente(pacienteVerificarConsultas);
                                                
                                                if(consultaVerificarConsultas == null){
                                                    mostraInput("A proxima consulta do paciente está programada para a data:" + consultaVerificarConsultas.getDataConsulta(),"Verificando agenda",1);
                                                }
                                                else{
                                                    mostraMensagem("O paciente não tem consultas previstas", "Erro!", 0);
                                                }
                                                if(consultaVerificarConsultas == null){
                                                    mostraInput("O proximo exame do paciente esta programado para :" + exameVerificarConsultas.getDataExame(),"Verificando agenda",1);
                                                }
                                                else{
                                                    mostraMensagem("O paciente não tem exames previstas", "Erro!", 0);
                                                }
                                                    
                                            } catch (PacienteNaoExisteException ex) {
                                                Logger.getLogger(SisClinica.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                            
                                            break;
                                        
                                        // Marca uma consulta na agenda
                                        case "5":
                                            
                                            String cpfPacienteMarcarConsulta = mostraInput("Digite o cpf do paciente que deseja marcar a consulta", "Marcar consulta", 3);
                                            try{
                                                Paciente pacienteMarcarConsulta = clinica.procurarPaciente(cpfPacienteMarcarConsulta);
                                                String cpfMedicoMarcarConsulta = mostraInput("Digite o cpf do médico que irá realizar a consulta", "Marcar consulta", 3);
                                                Funcionario medicoMarcarConsulta = clinica.procurarMedico(cpfMedicoMarcarConsulta);
                                                String dataDaConsultaMarcarConsulta = mostraInput("Digite a data da consulta", "Marcar consulta", 3);
                                                String dataDoRetornoMarcarConsulta = mostraInput("Digite a data do retorno da consulta", "Marcar consulta", 3);
                                                Consulta consulta = new Consulta(pacienteMarcarConsulta,(Medico) medicoMarcarConsulta, dataDaConsultaMarcarConsulta, dataDoRetornoMarcarConsulta, true);
                                            }
                                            catch (MedicoNaoExisteException | PacienteNaoExisteException ex) {
                                                mostraMensagem(ex.getMessage(), "Erro!", 0);
                                            }                                                
                                            break;
                                        
                                        // Marca um exame na agenda
                                        case "6":
                                            break;
                                            
                                	default:
                                		opcaoAtendenteLogado = null;
                                	}
                                        
                                        opcaoAtendenteLogado = mostraInput("Selecione a opção desejada:\n"
                                        + "1 - Cadastrar paciente\n"
                                        + "2 - Adicionar paciente na fila\n"
                                        + "3 - Proximo da fila\n"
                                        + "4 - Verificar proxima consulta ou exame do paciente\n"
                                        + "5 - Marcar Exame"
                                        + "6 - Marcar consulta", "Menu Atendente Logado",3);
                                }
                            default:
                                opcaoAtendente = null;
                                
                                
                        }
                        opcaoAtendente = mostraInput("Selecione a opção desejada:\n"
                            + "1 - Cadastrar\n"
                            + "2 - Entrar\n","Menu Atendente",3);
                    }
                    break;
                default:
                    mostraMensagem("Opção Inválida x2!","Erro",0);
                    if(cargo == null){
                        SalvarDados.salvarDados(clinica);
                    }
                    break;
            }
            cargo = JOptionPane.showInputDialog("Digite a opção que descreve seu cargo:\n"
                + "1 - Médico\n"
                + "2 - Atendente");
        }
    }
    
    public static void mostraMensagem(String msg,String titulo, int icon){
        JOptionPane.showMessageDialog(null,msg,titulo,icon);
    }
    
    public static String mostraInput(String msg, String titulo, int icon){
        return JOptionPane.showInputDialog(null,msg,titulo,icon);
    }
    
    public static int mostraDialogo(String msg, String titulo){
        return JOptionPane.showConfirmDialog(null,msg,titulo,JOptionPane.YES_NO_OPTION);
    }
}