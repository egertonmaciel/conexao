package br.com.egerton.util;

import br.com.egerton.model.RetornoSQL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Egerton Maciel
 */
public class CSVUtils {

    public static String gerar(RetornoSQL retorno) {
        return gerar(retorno, "", "");
    }

    public static String gerar(RetornoSQL retorno, String separador, String qualificador) {
        String csv = "";

        separador = separador.isEmpty() ? ";" : separador;
        qualificador = qualificador.isEmpty() ? "\"" : qualificador;

        for (String rotulo : retorno.getRotulos()) {
            csv += qualificador + rotulo + qualificador + separador;
        }
        csv = csv.replaceAll(separador + "$", "\n");

        for (ArrayList<String> linha : retorno.getValores()) {
            for (String coluna : linha) {
                csv += qualificador + coluna + qualificador + separador;
            }
            csv = csv.replaceAll(separador + "$", "\n");
        }
        return csv;
    }

    public static String gerar(List<List<String>> lista) {
        return gerar(lista, "", "");
    }

    public static String gerar(List<List<String>> lista, String separador, String qualificador) {
        String csv = "";

        separador = separador.isEmpty() ? ";" : separador;
        qualificador = qualificador.isEmpty() ? "\"" : qualificador;

        for (List<String> linha : lista) {
            for (String coluna : linha) {
                csv += qualificador + coluna + qualificador + separador;
            }
            csv = csv.replaceAll(separador + "$", "\n");
        }
        return csv;
    }

}
