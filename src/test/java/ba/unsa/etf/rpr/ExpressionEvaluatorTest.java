package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExpressionEvaluatorTest {

    @Test
    public void Test1() throws Exception {
        ExpressionEvaluator ee = new ExpressionEvaluator();
        Assertions.assertEquals(101.0, ee.evaluate("( 1 + ( 5 * 20 ) )"));
    }

    @Test
    public void Test2() throws Exception {
        ExpressionEvaluator ee = new ExpressionEvaluator();
        Assertions.assertEquals(101.0, ee.evaluate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) "));
    }

    @Test
    public void Test3() throws Exception {
        ExpressionEvaluator ee = new ExpressionEvaluator();
        Assertions.assertEquals(0.25, ee.evaluate("( ( 8 - 3 ) / ( ( 4 * 3 ) + ( 64 sqrt ) ) )"));
    }

    @Test
    public void Test4(){
        ExpressionEvaluator ee = new ExpressionEvaluator();
        Assertions.assertThrows(RuntimeException.class,
                ()->{ee.evaluate("( 1 + ( (  2 + 3 ) * ( 4 * 5 ) ) )");});
    }

    @Test
    public void Test5(){
        ExpressionEvaluator ee = new ExpressionEvaluator();
        Assertions.assertThrows(RuntimeException.class,
                ()->{ee.evaluate("( 1 + ( (2 + 3 ) * ( 4 * 5 ) ) )");});
    }

    @Test
    public void Test6(){
        ExpressionEvaluator ee = new ExpressionEvaluator();
        Assertions.assertThrows(RuntimeException.class,
                ()->{ee.evaluate("( 1 + ( ( 2 + 3 ) * ( 4kp * 5 ) ) )");});
    }

    @Test void Test7() throws Exception {
        ExpressionEvaluator ee = new ExpressionEvaluator();
        Assertions.assertEquals(0.25, ee.evaluate("    ( ( 8.72 - 3.22 ) / ( ( 7.8 * 1.25 ) + ( 150.0625 sqrt ) ) )  "));
    }

    @Test
    public void Test8(){
        ExpressionEvaluator ee = new ExpressionEvaluator();
        Assertions.assertThrows(RuntimeException.class,
                ()->{ee.evaluate("( 1 + ( ( 2 + 3.s8 ) * ( 4kp.3 * 5 ) ) )");});
    }

    @Test
    public void Test9(){
        ExpressionEvaluator ee = new ExpressionEvaluator();
        Assertions.assertThrows(RuntimeException.class,
                ()->{ee.evaluate("( 1 + 2 + 3 )");});
    }

    @Test
    public void Test10(){
        ExpressionEvaluator ee = new ExpressionEvaluator();
        Assertions.assertThrows(RuntimeException.class,
                ()->{ee.evaluate("( 1 + ( 1 + 2 ) / ( 2 * 3 ) )");});
    }

}