/**
 * Created by pletsch on 6/5/16.
 */
import Fibonacci.FibonacciGoodSmell;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class TestFibonnacci {
    private FibonacciGoodSmell fibonacci;
    @Before
    public void setUp(){
        fibonacci = new FibonacciGoodSmell();
    }

    @Test
    public void testeValorIgualACinco(){
        Assert.assertEquals(true,fibonacci.pertenceASerie(5));
    }

    @Test
    public void testeValorIgualASeis(){
        Assert.assertEquals(false,fibonacci.pertenceASerie(6));
    }

    @Test
    public void testeValorAltoQuePertenceASerie(){
        Assert.assertEquals(true, fibonacci.pertenceASerie(10946));
    }
}
