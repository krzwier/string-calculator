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

    /**
     * Kata step 2
     * Test arbitrary number of entries as input
     */
    @Test
    public void Add_ArbitraryNumArguments_ReturnSum(){
        assertAdding(55,"1,2,3,4,5,6,7,8,9,10");
    }

    /**
     * Kata step 3
     * Allow add method to handle new lines between numbers
     */
    @Test
    public void Add_NewLinesBetweenNumbers_ReturnSum(){
        assertAdding(6,"1\n2,3");
    }

    /** 
     * Kata step 4
     * Support different delimiters
     */
    @Test
    public void Add_ChangeDelimiterToSemicolon_ReturnSum(){
        assertAdding(3,"//;\n1;2");
    }

}
