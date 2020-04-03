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
     * 
     * @param int    expected
     * @param String inputString
     * @throws Exception
     */
    private void assertAdding(int expected, String inputString) throws Exception {
        StringCalculator calc = makeCalc();

        int result = calc.Add(inputString);

        assertEquals(expected, result);
    }


    /**
     * Kata step 1 Test empty string as input
     * 
     * @throws Exception
     */
    @Test
    public void Add_EmptyString_ReturnsDefaultValue() throws Exception
    {
        assertAdding(0, "");
    
    }

    /**
     * Kata step 1 Test one number as input
     * 
     * @throws Exception
     */
    @Test
    public void Add_OneNumber_ReturnsSameNumber() throws Exception
    {
        assertAdding(1, "1");
    }

    /**
     * Kata step 1 Test two numbers as input
     * 
     * @throws Exception
     */
    @Test
    public void Add_TwoNumbers_ReturnSum() throws Exception
    {
        assertAdding(3, "1,2");
    }

    /**
     * Kata step 2 Test arbitrary number of entries as input
     * 
     * @throws Exception
     */
    @Test
    public void Add_ArbitraryNumArguments_ReturnSum() throws Exception {
        assertAdding(55,"1,2,3,4,5,6,7,8,9,10");
    }

    /**
     * Kata step 3 Allow add method to handle new lines between numbers
     * 
     * @throws Exception
     */
    @Test
    public void Add_NewLinesBetweenNumbers_ReturnSum() throws Exception {
        assertAdding(6,"1\n2,3");
    }

    /**
     * Kata step 4 Support different delimiters
     * 
     * @throws Exception
     */
    @Test
    public void Add_ChangeDelimiterToSemicolon_ReturnSum() throws Exception {
        assertAdding(3,"//;\n1;2");
    }

    /**
     * Kata step 5
     * Throw exception for negative numbers
     */
    @Test
    public void Add_OneNegativeNumber_ThrowException(){
        StringCalculator calc = makeCalc();

        Exception e = assertThrows(Exception.class, () -> {
            calc.Add("-4");
        });

        String expectedMessage = "Negatives not allowed! (-4)";
        String actualMessage = e.getMessage();
 
        assertEquals(expectedMessage, actualMessage);
    }

}
