package br.com.egerton.connection;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author egerton.maciel
 */
public class ConexaoRadius extends Conexao {

    public ConexaoRadius() {
        USUARIO = "remoto";
        SENHA = "";
        URL = "jdbc:mysql://IPSERVIDOR:3306/Syslog";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoRadius.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
