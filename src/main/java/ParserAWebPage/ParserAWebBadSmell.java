package ParserAWebPage;

import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * Created by pletsch on 6/5/16.
 */
public class ParserAWebBadSmell {
    private static String deputado = "";
    private static String primeiroNome = "";
    private static String sobrenome = "";
    public static void main(String[] args) {
        try {
            URL mySite = new URL("http://www.al.rs.gov.br/deputados/ListadeDeputados.aspx");
            URLConnection yc = mySite.openConnection();
            Scanner in = new Scanner(new InputStreamReader(yc.getInputStream()));

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
                        System.out.println(primeiroNome + " " + sobrenome);
                    }
                }
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}