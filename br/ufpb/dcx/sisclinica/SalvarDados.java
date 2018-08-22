/*
 */
package br.ufpb.dcx.sisclinica;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.IOException;

import java.io.ObjectInputStream;

import java.io.ObjectOutputStream;


/**
 *
 * @author nikni
 */
public class SalvarDados {

    public static void salvarDados(Object obj) {

        try {
            FileOutputStream arquivoGrav = new FileOutputStream("dados.dat");
            ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);
            objGravar.writeObject(obj);

            objGravar.flush();

            objGravar.close();

            arquivoGrav.flush();

            arquivoGrav.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static Object recuperarDados() throws Exception {

        Object objRetorno = null;
        try {

            //Carrega o arquivo
            FileInputStream arquivoObj = new FileInputStream("saida.dat");

            ObjectInputStream objSalvo = new ObjectInputStream(arquivoObj);

            objRetorno = objSalvo;

            objSalvo.close();

            arquivoObj.close();

        } catch (Exception e) {

            throw new Exception("File Not Found");

        }

        return objRetorno;

    }
}
