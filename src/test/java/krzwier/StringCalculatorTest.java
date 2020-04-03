package krzwier;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test suit for String Calculator App.
 */
public class StringCalculatorTest 
{
    /**
     * Helper method to be called by any test that needs a string calculator
     * @return StringCalculator
     */
    private StringCalculator makeCalc() {
        return new StringCalculator();
    }

    /**
     * Helper method to be called by any test of add function
     * @param int expected
     * @param String inputString
     */
    private void assertAdding(int expected, String inputString){
        StringCalculator calc = makeCalc();

        int result = calc.Add(inputString);

        assertEquals(expected, result);
    }

    /**
     * Kata step 1
     * Test empty string as input
     */
    @Test
    public void Add_EmptyString_ReturnsDefaultValue()
    {
        assertAdding(0, "");
    }

    /** 
     * Kata step 1
     * Test one number as input
     */
    @Test
    public void Add_OneNumber_ReturnsSameNumber()
    {
        assertAdding(1, "1");
    }

    /**
     * Kata step 1
     * Test two numbers as input
     */
    @Test
    public void Add_TwoNumbers_ReturnSum()
    {
        assertAdding(3, "1,2");
    }


}
