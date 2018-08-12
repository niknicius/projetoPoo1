/*
 */
package br.ufpb.dcx.sisclinica;

import br.ufpb.dcx.sisclinica.Exceptions.MedicoJaExisteException;
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
                            String nome = mostraInput("Digite seu nome completo","Cadastrando novo médico",3);
                            String especialidade = mostraInput("Digite sua especialidade","Cadastrando novo médico",3);
                            String crm = mostraInput("Digite seu CRM completo","Cadastrando novo médico",3);
                            String cpf = mostraInput("Digite seu CPF completo","Cadastrando novo médico",3);
                            boolean salaValida = false;
                            int salaAtendimento = 0;
                            while(!salaValida)
                            try{
                                salaAtendimento = Integer.parseInt(mostraInput("Digite a sala onde deseka realizar os atendimentos","Cadastrando novo médico",3));
                                salaValida = true;
                                System.out.println("Passou");
                            }
                            catch(NumberFormatException ex){
                                mostraMensagem("Sala Inválida!","Erro",0);
                            }
                            Medico medico = new Medico(nome,especialidade,crm,cpf,salaAtendimento,1000.0,false);
                            try{
                                clinica.adicionarMedico(medico);
                                mostraMensagem("Médico cadastrado com sucesso!", "Cadastro de médico", 1);
                            }
                            catch(MedicoJaExisteException ex){
                                mostraMensagem("Médico já cadastrado! Logue-se ou procure o RH", "Erro", 0);
                            }
                            break;
                    }
                    break;
                case "2":
                    String opcaoAtendente = mostraInput("Selecione a opção desejada:\n"
                            + "1 - Entrar\n"
                            + "2 - Cadastrar\n"
                            + "3 - Voltar","Menu Atendente",3);       
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