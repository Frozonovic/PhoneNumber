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
    public void test_PhoneNumber_ctor_allValid()
    {
        // Pre: Try to construct, given valid parameters
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
    public void test_PhoneNumber_ctor_invalidAreaCode_startsWithZero()
    {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to construct, given area code starting with invalid character
        PhoneNumber num = new PhoneNumber("003", "538", "8383");
        // Post: Not constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_ctor_invalidAreaCode_startsWithOne()
    {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to construct, given area code starting with invalid character
        PhoneNumber num = new PhoneNumber("103", "538", "8383");
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

    @Test
    public void test_PhoneNumber_getDigits()
    {
        // Pre: Must have a PhoneNumber instance
        PhoneNumber num = new PhoneNumber("503", "538", "8383");
        // Post: Returns the phone number in digit-only form
        assertThat(num.getDigits(), equalTo("5035388383"));
    }

    @Test
    public void test_PhoneNumber_toString()
    {
        // Pre: Must have a PhoneNumber instance
        PhoneNumber num = new PhoneNumber("503", "538", "8383");
        // Post: Returns the phone number in delimited form (xxx-xxx-xxxx)
        assertThat(num.toString(), equalTo("503-538-8383"));
    }

    @Test
    public void test_PhoneNumber_compareTo_lessThan()
    {
        // Pre: Must have 2 PhoneNumber instances
        PhoneNumber num1 = new PhoneNumber("503", "538", "8383");
        PhoneNumber num2 = new PhoneNumber("403", "538", "8383");
        // Post: Returns 1 because parameter is lexically less than current phone number
        assertThat(num1.compareTo(num2), equalTo(1));
    }

    @Test
    public void test_PhoneNumber_compareTo_equivalent()
    {
        // Pre: Must have 2 PhoneNumber instances
        PhoneNumber num1 = new PhoneNumber("503", "538", "8383");
        PhoneNumber num2 = new PhoneNumber("503", "538", "8383");
        // Post: Returns 0 because parameter is lexically equivalent to current phone number
        assertThat(num1.compareTo(num2), equalTo(0));
    }

    @Test
    public void test_PhoneNumber_compareTo_greaterThan()
    {
        // Pre: Must have 2 PhoneNumber instances
        PhoneNumber num1 = new PhoneNumber("503", "538", "8383");
        PhoneNumber num2 = new PhoneNumber("603", "537", "8383");
        // Post: Returns -1 because parameter is lexically greater than current phone number
        assertThat(num1.compareTo(num2), equalTo(-1));
    }

    @Test
    public void test_PhoneNumber_isValidPhoneNumber_allValid()
    {
        // Pre: Try to verify validity, given all valid parameters
        assertThat(PhoneNumber.isValidPhoneNumber("503", "538", "8383"), equalTo(true));
        // Post: Verifies phone number and deems valid, returns true
    }

    @Test
    public void test_PhoneNumber_isValidPhoneNumber_nullAreaCode()
    {
        // Pre: Try to verify validity, given null area code parameter
        assertThat(PhoneNumber.isValidPhoneNumber(null, "538", "8383"), equalTo(false));
        // Post: Verifies phone number and deems invalid, returns false
    }

    @Test
    public void test_PhoneNumber_isValidPhoneNumber_nullPrefix()
    {
        // Pre: Try to verify validity, given null prefix parameter
        assertThat(PhoneNumber.isValidPhoneNumber("503", null, "8383"), equalTo(false));
        // Post: Verifies phone number and deems invalid, returns false
    }

    @Test
    public void test_PhoneNumber_isValidPhoneNumber_nullLineNumber()
    {
        // Pre: Try to verify validity, given null prefix parameter
        assertThat(PhoneNumber.isValidPhoneNumber("503", "538", null), equalTo(false));
        // Post: Verifies phone number and deems invalid, returns false
    }

    @Test
    public void test_PhoneNumber_isValidPhoneNumber_invalidAreaCode_tooFewDigits()
    {
        // Pre: Try to verify validity, given "50" instead of "503"
        assertThat(PhoneNumber.isValidPhoneNumber("50", "538", "8383"), equalTo(false));
        // Post: Verifies phone number and deems invalid, returns false
    }

    @Test
    public void test_PhoneNumber_isValidPhoneNumber_invalidPrefix_tooFewDigits()
    {
        // Pre: Try to verify validity, given "53" instead of "538"
        assertThat(PhoneNumber.isValidPhoneNumber("503", "53", "8383"), equalTo(false));
        // Post: Verifies phone number and deems invalid, returns false
    }

    @Test
    public void test_PhoneNumber_isValidPhoneNumber_invalidLineNumber_tooFewDigits()
    {
        // Pre: Try to verify validity, given "838" instead of "8383"
        assertThat(PhoneNumber.isValidPhoneNumber("503", "538", "838"), equalTo(false));
        // Post: Verifies phone number and deems invalid, returns false
    }

    @Test
    public void test_PhoneNumber_isValidPhoneNumber_invalidAreaCode_tooManyDigits()
    {
        // Pre: Try to verify validity, given "5033" instead of "503"
        assertThat(PhoneNumber.isValidPhoneNumber("5033", "538", "8383"), equalTo(false));
        // Post: Verifies phone number and deems invalid, returns false
    }

    @Test
    public void test_PhoneNumber_isValidPhoneNumber_invalidPrefix_tooManyDigits()
    {
        // Pre: Try to verify validity, given "5388" instead of "538"
        assertThat(PhoneNumber.isValidPhoneNumber("503", "5388", "8383"), equalTo(false));
        // Post: Verifies phone number and deems invalid, returns false
    }

    @Test
    public void test_PhoneNumber_isValidPhoneNumber_invalidLineNumber_tooManyDigits()
    {
        // Pre: Try to verify validity, given "83833" instead of "8383"
        assertThat(PhoneNumber.isValidPhoneNumber("503", "538", "83833"), equalTo(false));
        // Post: Verifies phone number and deems invalid, returns false
    }

    @Test
    public void test_PhoneNumber_isValidPhoneNumber_invalidAreaCode_startsWithZero()
    {
        // Pre: Try to verify validity, given area code starting with invalid character (0)
        assertThat(PhoneNumber.isValidPhoneNumber("003", "538", "8383"), equalTo(false));
        // Post: Verifies phone number and deems invalid, returns false
    }

    @Test
    public void test_PhoneNumber_isValidPhoneNumber_invalidAreaCode_startsWithOne()
    {
        // Pre: Try to verify validity, given area code starting with invalid character (1)
        assertThat(PhoneNumber.isValidPhoneNumber("103", "538", "8383"), equalTo(false));
        // Post: Verifies phone number and deems invalid, returns false
    }

    @Test
    public void test_PhoneNumber_parsePhoneNumber_allValid()
    {
        // Pre: Try to parse phone number and construct, given valid parameter
        PhoneNumber.parsePhoneNumber("503-538-8383");
        // Post: Parsed correctly and constructed, no exceptions thrown
    }

    @Test
    public void test_PhoneNumber_parsePhoneNumber_nullParameter()
    {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to parse phone number and construct, given invalid parameter
        PhoneNumber.parsePhoneNumber(null);
        // Post: Cannot be parsed or constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_parsePhoneNumber_invalidAreaCode_tooFewDigits()
    {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to parse phone number and construct, given "50-538-8383" instead of "503-538-8383"
        PhoneNumber.parsePhoneNumber("50-538-8383");
        // Post: Cannot be constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_parsePhoneNumber_invalidPrefix_tooFewDigits()
    {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to parse phone number and construct, given "503-53-8383" instead of "503-538-8383"
        PhoneNumber.parsePhoneNumber("503-53-8383");
        // Post: Cannot be constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_parsePhoneNumber_invalidLineNumber_tooFewDigits()
    {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to parse phone number and construct, given "503-538-838" instead of "503-538-8383"
        PhoneNumber.parsePhoneNumber("503-538-838");
        // Post: Cannot be constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_parsePhoneNumber_invalidAreaCode_tooManyDigits()
    {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to parse phone number and construct, given "5033-538-8383" instead of "503-538-8383"
        PhoneNumber.parsePhoneNumber("5033-538-8383");
        // Post: Cannot be constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_parsePhoneNumber_invalidPrefix_tooManyDigits()
    {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to parse phone number and construct, given "503-5388-8383" instead of "503-538-8383"
        PhoneNumber.parsePhoneNumber("503-5388-8383");
        // Post: Cannot be constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_parsePhoneNumber_invalidLineNumber_tooManyDigits()
    {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to parse phone number and construct, given "503-538-8383" instead of "503-538-83833"
        PhoneNumber.parsePhoneNumber("503-538-83833");
        // Post: Cannot be constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_parsePhoneNumber_invalidAreaCode_startsWithZero()
    {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to parse phone number and construct, given phone number starting with invalid character (0)
        PhoneNumber.parsePhoneNumber("003-538-8383");
        // Post: Cannot be constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_parsePhoneNumber_invalidAreaCode_startsWithOne()
    {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to parse phone number and construct, given phone number starting with invalid character (1)
        PhoneNumber.parsePhoneNumber("103-538-8383");
        // Post: Cannot be constructed, throws IllegalArgumentException
    }
}
