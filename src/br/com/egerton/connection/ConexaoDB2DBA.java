package br.com.egerton.connection;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author egerton.maciel
 */
public class ConexaoDB2DBA extends Conexao {

    public ConexaoDB2DBA() {
        USUARIO = "db2dba";
        SENHA = "";
        URL = "jdbc:db2://IPSERVIDOR:50000/BDPROD";
        try {
            Class.forName("com.ibm.db2.jcc.DB2Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoDB2DBA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
