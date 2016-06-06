package Fibonacci;

/**
 * Created by pletsch on 6/5/16.
 */
public class FibonacciGoodSmell {
    public boolean pertenceASerie(int i){
        int primeiroTermo = 0;
        int segundoTermo = 1;
        int terceiroTermo = 0;

        while(terceiroTermo < i){
            terceiroTermo = primeiroTermo + segundoTermo;
            primeiroTermo = segundoTermo;
            segundoTermo = terceiroTermo;
        }

        if(terceiroTermo == i){
            return true;
        }else{
            return false;
        }
    }
}
