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
                                    System.out.println("Passou");
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

                            case "2":
                                String cpfLogar = mostraInput("Digite seu CPF:", "Login Médico",3);
                                try{
                                    Funcionario medicoLogar = clinica.procurarMedico(cpfLogar);
                                    mostraMensagem("Bem vindo, " + medicoLogar.getNome() , "Login Médico", 1);
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
                                mostraMensagem("Bem vindo, " + atendenteLogar.getNome() , "Login Atendente", 1);
                                }
                                catch(FuncionarioNaoExisteException ex){
                                    mostraMensagem(ex.getMessage(),"Erro!",0);
                                }
                                String opcaoAtendenteLogado = mostraInput("Selecione a opção desejada:\n"
                                        + "1 - Criar lista de pacientes\n"
                                        + "2 - Adicionar paciente na fila\n", "Menu Atendente Logado",3);
                                while(opcaoAtendenteLogado != null){
                                	switch(opcaoAtendenteLogado){
                                		case "1":
                                			String nomeP = mostraInput("Digite o nome do paciente:", "Criando lista de pacientes", 3);
                                			String racaP = mostraInput("Digite a raça do paciente:", "Criando lista de pacientes", 3);
                                			String dataNascimentoP = mostraInput("Digite a data de nascimento do paciente:", "Criando lista de pacientes", 3);
                                			String cpfP = mostraInput("Digite o CPF completo do paciente:", "Criando lista de pacientes", 3);
                                			String rgP = mostraInput("Digite o RG completo do paciente:", "Criando lista de pacientes", 3);
                                			String sexoP = mostraInput("Digite o sexo do paciente:", "Criando lista de pacientes", 3);
                                			String nacionalidadeP = mostraInput("Digite a nacionalidade do paciente:", "Criando lista de pacientes", 3);
                                			String cepP = mostraInput("Digite o CEP do endereço do paciente:", "Criando lista de pacientes", 3);
                                			String ufP = mostraInput("Digite a UF correspondente ao endereço do paciente:", "Criando lista de pacientes", 3);
                                			String tipoConsultaP = mostraInput("Digite o tipo de exame que o paciente irá realizar:", "Criando lista de pacientes", 3);
                                			Paciente paciente1 = new Paciente (nomeP, racaP, dataNascimentoP, cpfP, rgP, sexoP, nacionalidadeP, cepP, ufP, tipoConsultaP);
                                			try{
                                				clinica.adicionarPaciente(paciente1);
                                				mostraMensagem("Paciente cadastrado com sucesso!", "Cadastro de paciente", 1);
                                			}
                                			catch(PacienteJaExisteException ex){
                                				mostraMensagem(ex.getMessage(), "Erro!", 0);
                                			}
                                			break;
                                	case "2":
                                		String nomeAdd = mostraInput("Digite o nome do paciente que deseja adicionar na fila:", "Adicionado paciente na fila", 3);
                                		String cpfAdd = mostraInput("Digite o cpf do paciente que deseja adicionar na fila:", "Adicionado paciente na fila", 3);
                                		try{
                                			Paciente pacienteAdd = clinica.procurarPaciente(nomeAdd, cpfAdd);
                                			try{
                                				clinica.adicionarPacienteFila(pacienteAdd);
                                				mostraMensagem("Paciente adicionado com sucesso!", "Adição do Paciente Na Fila", 1);
                                			}
                                			catch(PacienteJaExisteException ex){
                                				mostraMensagem(ex.getMessage(), "Erro!", 0);
                                			}
                                		}
                                		catch(PacienteNaoExisteException ex){
                                			mostraMensagem(ex.getMessage(), "Erro!", 0);
                                		}
                                		break;
                                	default:
                                		opcaoAtendenteLogado = null;
                                	}
                                }
                            default:
                                opcaoAtendente = null;
                        }
                        opcaoAtendente = mostraInput("Selecione a opção desejada:\n"
                            + "1 - Cadastrar\n"
                            + "2 - Entrar\n","Menu Atendente",3);
                    }
                default:
                    mostraMensagem("Opção Inválida!","Erro",0);
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