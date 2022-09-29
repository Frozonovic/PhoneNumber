import static org.hamcrest.Matchers.*;
import org.junit.*;
import org.junit.rules.*;
import static org.junit.Assert.*;

/**
 * JUnit unit tests for the PhoneNumber class.
 *
 * @author blee20@georgefox.edu
 */
public class PhoneNumberTest
{
    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void test_PhoneNumber_ctor_allValidParams()
    {
        // Pre: Try to construct, given valid params
        PhoneNumber num = new PhoneNumber("503", "538", "8383");
        // Post: Constructed, no exceptions thrown
    }

    @Test
    public void test_PhoneNumber_ctor_nullAreaCode()
    {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to construct, given one null parameter
        PhoneNumber num = new PhoneNumber(null, "538", "8383");
        // Post: Not constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_ctor_nullPrefix()
    {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to construct, given one null parameter
        PhoneNumber num = new PhoneNumber("503", null, "8383");
        // Post: Not constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_ctor_nullLineNumber()
    {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to construct, given one null parameter
        PhoneNumber num = new PhoneNumber("503", "538", null);
        // Post: Not constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_ctor_invalidAreaCode_tooFewDigits()
    {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to construct, given "50" instead of "503"
        PhoneNumber num = new PhoneNumber("50", "538", "8383");
        // Post: Not constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_ctor_invalidPrefix_tooFewDigits()
    {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to construct, given "53" instead of "538"
        PhoneNumber num = new PhoneNumber("503", "53", "8383");
        // Post: Not constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_ctor_invalidLineNumber_tooFewDigits()
    {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to construct, given "838" instead of "8383"
        PhoneNumber num = new PhoneNumber("503", "538", "838");
        // Post: Not constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_ctor_invalidAreaCode_tooManyDigits()
    {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to construct, given "5033" instead of "503"
        PhoneNumber num = new PhoneNumber("5033", "538", "8383");
        // Post: Not constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_ctor_invalidPrefix_tooManyDigits()
    {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to construct, given "5388" instead of "538"
        PhoneNumber num = new PhoneNumber("503", "5388", "8383");
        // Post: Not constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_ctor_invalidLineNumber_tooManyDigits()
    {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to construct, given "83833" instead of "8383"
        PhoneNumber num = new PhoneNumber("503", "538", "83833");
        // Post: Not constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_getAreaCode()
    {
        // Pre: Must have a PhoneNumber instance
        PhoneNumber num = new PhoneNumber("503", "538", "8383");
        // Post: Returns the area code for the instance
        assertThat(num.getAreaCode(), equalTo("503"));
    }

    @Test
    public void test_PhoneNumber_getPrefix()
    {
        // Pre: Must have a PhoneNumber instance
        PhoneNumber num = new PhoneNumber("503", "538", "8383");
        // Post: Returns the prefix for the instance
        assertThat(num.getPrefix(), equalTo("538"));
    }

    @Test
    public void test_PhoneNumber_getLineNumber()
    {
        // Pre: Must have a PhoneNumber instance
        PhoneNumber num = new PhoneNumber("503", "538", "8383");
        // Post: Returns the line number for the instance
        assertThat(num.getLineNumber(), equalTo("8383"));
    }
}
