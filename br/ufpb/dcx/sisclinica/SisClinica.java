/*
 */
package br.ufpb.dcx.sisclinica;

import br.ufpb.dcx.sisclinica.Exceptions.FuncionarioJaExisteException;
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
        
        String usuario = JOptionPane.showInputDialog("Digite a opção que descreve seu cargo:\n"
                + "1 - Médico\n"
                + "2 - Atendente");
        while(usuario != null){
            switch(usuario){
                case "1":
                    String opcaoMedico = mostraInput("Digite o numero da opção desejada:\n"
                            + "1 - Cadastrar\n"
                            + "2 - Entrar\n"
                            + "3 - Voltar", "Menu médico",3);
                    
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
                                salaAtendimentoMedicoCadastrar = Integer.parseInt(mostraInput("Digite a sala onde deseka realizar os atendimentos","Cadastrando novo médico",3));
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
                                mostraMensagem(ex.getMessage(), "Erro", 0);
                            }
                            break;
                        
                        case "2":
                            String cpfLogar = mostraInput("Digite seu CPF:", "Login Médico",3);
                            try{
                                Funcionario medicoLogar = clinica.procurarMedico(cpfLogar);
                                mostraMensagem("Bem vindo, " + medicoLogar.getNome() , "Login Médico", 1);
                            }
                            catch(MedicoNaoExisteException ex){
                                mostraMensagem(ex.getMessage(),"Erro",0);
                            }         
                    }
                    
                    break;
                case "2":
                    String opcaoAtendente = mostraInput("Selecione a opção desejada:\n"
                            + "1 - Cadastrar\n"
                            + "2 - Entrar\n"
                            + "3 - Voltar","Menu Atendente",3);
                    switch(opcaoAtendente){
                        case "1":
                            String nomeAtendente = mostraInput("Digite o nome completo:","Cadastro Atendente",3);  
                            String cpfAtendente = mostraInput("Digite o cpf completo:","Cadastro Atendente",3); 
                            Atendente atendente = new Atendente(nomeAtendente,cpfAtendente,980.00);
                            try{
                                clinica.adicionarFuncionario(atendente);
                                mostraMensagem("Atendente cadastrado com sucesso!", "Cadastro Atendente", 0);
                            }
                            catch(FuncionarioJaExisteException ex){
                                mostraMensagem(ex.getMessage(), "Erro", 0);
                            }
                            break;
                    }
                    break;
                default:
                    mostraMensagem("Opção Inválida!","Erro",0);
                    break;
            }
            usuario = JOptionPane.showInputDialog("Digite a opção que descreve seu cargo:\n"
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