package br.com.egerton.connection;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author egerton.maciel
 */
public class ConexaoLocal extends Conexao {

    public ConexaoLocal() {
        USUARIO = "root";
        SENHA = "";
        URL = "jdbc:mysql://localhost:3307/teste";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoLocal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
