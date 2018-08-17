/*
 */
package br.ufpb.dcx.sisclinica;

import br.ufpb.dcx.sisclinica.Exceptions.FuncionarioJaExisteException;
import br.ufpb.dcx.sisclinica.Exceptions.FuncionarioNaoExisteException;
import br.ufpb.dcx.sisclinica.Exceptions.MedicoNaoExisteException;
import javax.swing.JOptionPane;

/**
 *
 * @author nikni
 */
public class SisClinica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Clinica clinica = new Clinica("Clinex");
        
        mostraMensagem("Bem Vindo ao SisClinica!","Bem Vindo(a)",1);
        
        String cargo = JOptionPane.showInputDialog("Digite a op��o que descreve seu cargo:\n"
                + "1 - M�dico\n"
                + "2 - Atendente");
        while(cargo != null){
            switch(cargo){
                case "1":
                    String opcaoMedico = mostraInput("Digite o numero da op��o desejada:\n"
                            + "1 - Cadastrar\n"
                            + "2 - Entrar\n"
                            + "3 - Voltar", "Menu m�dico",3);
                    
                    while(opcaoMedico != null){
                        switch(opcaoMedico){
                            case "1":
                                String nomeMedicoCadastrar = mostraInput("Digite seu nome completo","Cadastrando novo m�dico",3);
                                String especialidadeMedicoCadastrar = mostraInput("Digite sua especialidade","Cadastrando novo m�dico",3);
                                String crmMedicoCadastrar = mostraInput("Digite seu CRM completo","Cadastrando novo m�dico",3);
                                String cpfMedicoCadastrar = mostraInput("Digite seu CPF completo","Cadastrando novo m�dico",3);
                                boolean salaValida = false;
                                int salaAtendimentoMedicoCadastrar = 0;
                                while(!salaValida)
                                try{
                                    salaAtendimentoMedicoCadastrar = Integer.parseInt(mostraInput("Digite a sala onde deseka realizar os atendimentos","Cadastrando novo m�dico",3));
                                    salaValida = true;
                                    System.out.println("Passou");
                                }
                                catch(NumberFormatException ex){
                                    mostraMensagem("Sala Inv�lida!","Erro",0);
                                }
                                Funcionario medico = new Medico(nomeMedicoCadastrar,especialidadeMedicoCadastrar,crmMedicoCadastrar,cpfMedicoCadastrar,salaAtendimentoMedicoCadastrar,1000.0,false);
                                try{
                                    clinica.adicionarFuncionario(medico);
                                    mostraMensagem("M�dico cadastrado com sucesso!", "Cadastro de m�dico", 1);
                                }
                                catch(FuncionarioJaExisteException ex){
                                    mostraMensagem(ex.getMessage(), "Erro!", 0);
                                }
                                break;

                            case "2":
                                String cpfLogar = mostraInput("Digite seu CPF:", "Login M�dico",3);
                                try{
                                    Funcionario medicoLogar = clinica.procurarMedico(cpfLogar);
                                    mostraMensagem("Bem vindo, " + medicoLogar.getNome() , "Login M�dico", 1);
                                }
                                catch(MedicoNaoExisteException ex){
                                    mostraMensagem(ex.getMessage(),"Erro!",0);
                                }
                                break;
                            default:
                                opcaoMedico = null;
                        }
                        opcaoMedico = mostraInput("Digite o numero da op��o desejada:\n"
                            + "1 - Cadastrar\n"
                            + "2 - Entrar\n"
                            + "3 - Voltar", "Menu m�dico",3);
                    }
                    
                    break;
                case "2":
                    String opcaoAtendente = mostraInput("Selecione a op��o desejada:\n"
                            + "1 - Cadastrar\n"
                            + "2 - Entrar\n"
                            + "3 - Criar lista de pacientes\n"
                            + "4 - Adicionar paciente na fila\n", "Menu Atendente",3);
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
                                mostraMensagem("Bem vindo, " + atendenteLogar.getNome() , "Login Atendente", 1);
                                }
                                catch(FuncionarioNaoExisteException ex){
                                    mostraMensagem(ex.getMessage(),"Erro!",0);
                                }
                                break;
                            case "3":
                            	String nomeP = mostraInput("Digite o nome do paciente:", "Criando lista de pacientes", 3);
                            	String racaP = mostraInput("Digite a ra�a do paciente:", "Criando lista de pacientes", 3);
                            	String dataNascimentoP = mostraInput("Digite a data de nascimento do paciente:", "Criando lista de pacientes", 3);
                            	String cpfP = mostraInput("Digite o CPF completo do paciente:", "Criando lista de pacientes", 3);
                            	String rgP = mostraInput("Digite o RG completo do paciente:", "Criando lista de pacientes", 3);
                            	String sexoP = mostraInput("Digite o sexo do paciente:", "Criando lista de pacientes", 3);
                            	String nacionalidadeP = mostraInput("Digite a nacionalidade do paciente:", "Criando lista de pacientes", 3);
                            	String cepP = mostraInput("Digite o CEP do endere�o do paciente:", "Criando lista de pacientes", 3);
                            	String ufP = mostraInput("Digite a UF correspondente ao endere�o do paciente:", "Criando lista de pacientes", 3);
                            	Paciente paciente1 = new Paciente (nome1, raca1, dataNascimento1, cpf1, rg1, sexo1, nacionalidade1, cep1, uf1);
                            	try{
                                    clinica.adicionarPaciente(paciente1);
                                    mostraMensagem("Paciente cadastrado com sucesso!", "Cadastro de paciente", 1);
                                }
                                catch(PacienteJaExisteException ex){
                                    mostraMensagem(ex.getMessage(), "Erro!", 0);
                                }
                            	break;
                            default:
                                opcaoAtendente = null;
                        }
                        opcaoAtendente = mostraInput("Selecione a op��o desejada:\n"
                            + "1 - Cadastrar\n"
                            + "2 - Entrar\n","Menu Atendente",3);
                    }
                default:
                    mostraMensagem("Op��o Inv�lida!","Erro",0);
                    break;
            }
            cargo = JOptionPane.showInputDialog("Digite a op��o que descreve seu cargo:\n"
                + "1 - M�dico\n"
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