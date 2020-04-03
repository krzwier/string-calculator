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

    /**
     * Kata step 6
     * Numbers bigger than 1000 should be ignored
     */
    @Test
    public void Add_NumberBiggerThan1000_IgnoreForSum() throws Exception {
        assertAdding(2,"2,1001");
    }

    /**
     * Kata step 7
     * Delimiters can be of any length with the format "//[delimter]\n"
     */
    @Test
    public void Add_LongDelimiter_ReturnSum() throws Exception {
        assertAdding(6,"//[***]\n1***2***3");
    }

    /**
     * Kata step 8
     * Allow multiple delimiters inside of square brackets
     */
    @Test
    public void Add_MultipleSingleCharDelimiters_ReturnSum() throws Exception {
        assertAdding(6,"//[*][%]\n1*2*3");
    }

    /**
     * Kata step 9
     * Allow multiple long delimiters
     */
    @Test
    public void Add_MultipleLongDelimiters_ReturnSum() throws Exception {
        assertAdding(6,"//[***][%]\n1***2%3");
    }

    @Test
    public void Parse_EmptyString_ReturnsZero() {
        StringCalculator calc = makeCalc();

        int result = calc.parse("");

        assertEquals(0,result);
    }

    @Test
    public void Parse_SingleNumber_ReturnsThatNumber() {
        StringCalculator calc = makeCalc();

        int result = calc.parse("1");

        assertEquals(1,result);
    }

    @Test
    public void Parse_SingleNumber_ReturnsThatNumber2() {
        StringCalculator calc = makeCalc();

        int result = calc.parse("2");

        assertEquals(2,result);
    }

    /** 
     * Add division functionality
     */
    @Test
    public void Subtract_twoSimpleNumbers_ReturnDifference() {
        StringCalculator calc = makeCalc();

        int result = calc.Subtract(2,1);

        assertEquals(1, result);
    }
}
