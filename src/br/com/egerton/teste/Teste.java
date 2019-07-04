package br.com.egerton.teste;

import br.com.egerton.connection.Conexao;
import br.com.egerton.connection.ConexaoLocal;
import br.com.egerton.model.RetornoSQL;
import java.util.ArrayList;

/**
 *
 * @author egerton.12871
 */
public class Teste {

    public Teste() {
        
        Conexao c = new ConexaoLocal();
        
        RetornoSQL retorno = c.select("select * from usuario");
        
        if (retorno.isSucesso()) {
                System.out.println(retorno.getRotulos());
            for (ArrayList<String> linha : retorno.getValores()) {
                System.out.println(linha);
            }
        }else{
            System.out.println("falha: " + retorno.getMensagem());
        }
        
    }
    
    
    public static void main(String[] args) {
        new Teste();
    }
}
