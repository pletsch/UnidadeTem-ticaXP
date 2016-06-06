package Fibonacci;

/**
 * Created by pletsch on 6/5/16.
 */
public class FibonacciBadSmell {

    public String fibonacci(int i){
        if( (i == 0) ||
            (i == 1) ||
            (i == 2) ||
            (i == 3) ||
            (i == 5) ||
            (i == 8) ||
            (i == 13) ||
            (i == 21) ||
            (i == 34) ||
            (i == 55) ||
            (i == 89) ||
            (i == 144) ){
           return "Pertence a sequencia de Fiboncci";
        }else{
            return "Nao pertence a sequencia de Fiboncci";
        }
    }
}
