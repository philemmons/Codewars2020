import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;
import java.math.BigInteger;

public class SolutionTest {
    @Test
    public void testSomething()
    {
        assertEquals(BigInteger.ZERO, Fusc.fusc(BigInteger.ZERO));
        assertEquals(BigInteger.ONE, Fusc.fusc(BigInteger.ONE));
        assertEquals(BigInteger.valueOf(3), Fusc.fusc(BigInteger.valueOf(5)));
        assertEquals(BigInteger.valueOf(8), Fusc.fusc(BigInteger.valueOf(21)));
        assertEquals(BigInteger.valueOf(53), Fusc.fusc(BigInteger.valueOf(9007199254740991L)));
        
        // You need to pass these tests very quickly
        BigInteger twoPThous = BigInteger.valueOf(2).pow(1000);
        assertEquals(BigInteger.valueOf(1001), Fusc.fusc(twoPThous.add(BigInteger.ONE)));
        assertEquals(BigInteger.valueOf(1000), Fusc.fusc(twoPThous.subtract(BigInteger.ONE)));
        assertEquals(BigInteger.valueOf(2996), Fusc.fusc(twoPThous.add(BigInteger.valueOf(5))));
        assertEquals(BigInteger.valueOf(7973), Fusc.fusc(twoPThous.add(BigInteger.valueOf(21))));
        assertEquals(BigInteger.valueOf(50245), Fusc.fusc(twoPThous.add(BigInteger.valueOf(9007199254740991L))));
     }
}
