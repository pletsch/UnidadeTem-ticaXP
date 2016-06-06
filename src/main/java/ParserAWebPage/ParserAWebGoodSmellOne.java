package ParserAWebPage;

import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by pletsch on 6/5/16.
 */
public class ParserAWebGoodSmellOne {
    final private static String url = "http://www.al.rs.gov.br/deputados/ListadeDeputados.aspx";
    private static URL site = null;
    private static URLConnection conexao = null;
    private static ArrayList<String> listaDosDeputados;

    public static void main(String[] args) {
        procuraPeloSiteDaAssembleiaLegislativa();
        abreConexaoComOSiteDaAssembleiaLegislativa();
        listaDosDeputados = obtemAListaDeDeputados(obtemOCodigoDoSiteDaAssembleiaLegislativa());
        imprimeAListaDosDeputados(listaDosDeputados);
    }

    private static void imprimeAListaDosDeputados(ArrayList<String> listaDosDeputados) {
        for (int i = 0; i < listaDosDeputados.size(); i++){
            System.out.println(listaDosDeputados.get(i));
        }
    }

    private static Scanner obtemOCodigoDoSiteDaAssembleiaLegislativa() {
        Scanner codigoDoSite = null;
        try {
            codigoDoSite = obtemOCodigoDoSite(conexao);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return codigoDoSite;
    }

    private static void abreConexaoComOSiteDaAssembleiaLegislativa() {
        try {
            conexao = site.openConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void procuraPeloSiteDaAssembleiaLegislativa() {
        try {
            site = new URL(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Scanner obtemOCodigoDoSite(URLConnection conexao) {
        Scanner codigoDoSite = null;
        try {
            codigoDoSite = new Scanner(new InputStreamReader(conexao.getInputStream()));
        }catch (Exception e){
            e.printStackTrace();
        }
        return codigoDoSite;
    }

    private static ArrayList<String> obtemAListaDeDeputados(Scanner in) {
        ArrayList<String> listaDeDeputados = new ArrayList<String>();
        String deputado = "";
        String primeiroNome = "";
        String sobrenome = "";
        while (in.hasNext()) {
            deputado = in.next();
            if(deputado.contains("href=\"http://ww1.al.rs.gov.br/")){
                deputado = deputado + in.next();
                if(deputado.contains("</a>")){
                    deputado = deputado.substring(deputado.indexOf("\">")+2,deputado.indexOf("</a"));
                    for(int i = 1; i < deputado.length(); i++){
                       if(Character.isUpperCase(deputado.charAt(i))){
                           primeiroNome = deputado.substring(0,(i));
                           sobrenome = deputado.substring(i);
                       }
                    }
                    listaDeDeputados.add(primeiroNome + " " + sobrenome);
                }
            }
        }
        return listaDeDeputados;
    }
}

