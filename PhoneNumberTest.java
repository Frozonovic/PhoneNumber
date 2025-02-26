import static org.hamcrest.Matchers.*;
import org.junit.*;
import org.junit.rules.*;
import static org.junit.Assert.*;

/**
 * JUnit unit tests for the PhoneNumber class.
 *
 * @author blee20@georgefox.edu
 */
public class PhoneNumberTest {
    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void test_PhoneNumber_ctor_allValid() {
        // Pre: Try to construct
        // Pre: Given valid parameters
        PhoneNumber num = new PhoneNumber("503", "538", "8383");
        // Post: Constructed, no exceptions thrown
    }

    @Test
    public void test_PhoneNumber_ctor_nullAreaCode() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to construct
        // Pre: Given one null parameter
        PhoneNumber num = new PhoneNumber(null, "538", "8383");
        // Post: Not constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_ctor_nullAreaCodeAndPrefix() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to construct
        // Pre: Given two null parameters
        PhoneNumber num = new PhoneNumber(null, null, "8383");
        // Post: Not constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_ctor_nullAreaCodeAndLineNumber() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to construct
        // Pre: Given two null parameters
        PhoneNumber num = new PhoneNumber(null, "503", null);
        // Post: Not constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_ctor_nullPrefix() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to construct
        // Pre: Given one null parameter
        PhoneNumber num = new PhoneNumber("503", null, "8383");
        // Post: Not constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_ctor_nullPrefixAndLineNumber() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to construct
        // Pre: Given two null parameters
        PhoneNumber num = new PhoneNumber("503", null, null);
        // Post: Not constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_ctor_nullLineNumber() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to construct
        // Pre: Given one null parameter
        PhoneNumber num = new PhoneNumber("503", "538", null);
        // Post: Not constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_ctor_allNull() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to construct
        // Pre: Given three null parameters
        PhoneNumber num = new PhoneNumber(null, null, null);
        // Post: Not constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_ctor_invalidAreaCode_tooFewDigits() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to construct
        // Pre: Given "50" instead of "503"
        PhoneNumber num = new PhoneNumber("50", "538", "8383");
        // Post: Not constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_ctor_invalidAreaCodeAndPrefix_tooFewDigits() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to construct
        // Pre: Given "50" and "53" instead of "503" and "538"
        PhoneNumber num = new PhoneNumber("50", "53", "8383");
        // Post: Not constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_ctor_invalidAreaCodeAndLineNumber_tooFewDigits() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to construct
        // Pre: Given "50" and "838" instead of "503" and "8383"
        PhoneNumber num = new PhoneNumber("503", "538", "838");
        // Post: Not constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_ctor_invalidPrefix_tooFewDigits() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to construct
        // Pre: Given "53" instead of "538"
        PhoneNumber num = new PhoneNumber("503", "53", "8383");
        // Post: Not constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_ctor_invalidPrefixAndLineNumber_tooFewDigits() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to construct
        // Pre: Given "53" and '838" instead of "538" and "8383"
        PhoneNumber num = new PhoneNumber("503", "53", "838");
        // Post: Not constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_ctor_invalidLineNumber_tooFewDigits() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to construct
        // Pre: Given "838" instead of "8383"
        PhoneNumber num = new PhoneNumber("503", "538", "838");
        // Post: Not constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_ctor_allInvalid_tooFewDigits() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to construct
        // Pre: Given "50", "53", and "838" instead of "503", "538" and "8383"
        PhoneNumber num = new PhoneNumber("50", "53", "838");
        // Post: Not constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_ctor_invalidAreaCode_tooManyDigits() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to construct
        // Pre: Given "5033" instead of "503"
        PhoneNumber num = new PhoneNumber("5033", "538", "8383");
        // Post: Not constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_ctor_invalidAreaCodeAndPrefix_tooManyDigits() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to construct
        // Pre: Given "5033" and "5388" instead of "503" and "538"
        PhoneNumber num = new PhoneNumber("5033", "5388", "8383");
        // Post: Not constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_ctor_invalidAreaCodeAndLineNumber_TooManyDigits() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to construct
        // Pre: Given "5033" and "83833" instead of "503" and "8383"
        PhoneNumber num = new PhoneNumber("5033", "538", "83833");
        // Post: Not constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_ctor_invalidPrefix_tooManyDigits() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to construct
        // Pre: Given "5388" instead of "538"
        PhoneNumber num = new PhoneNumber("503", "5388", "8383");
        // Post: Not constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_ctor_invalidPrefixAndLineNumber_tooManyDigits() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to construct
        // Pre: Given "5388" and "83833" instead of "538" and "8383"
        PhoneNumber num = new PhoneNumber("503", "5388", "83833");
        // Post: Not constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_ctor_invalidLineNumber_tooManyDigits() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to construct
        // Pre: Given "83833" instead of "8383"
        PhoneNumber num = new PhoneNumber("503", "538", "83833");
        // Post: Not constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_ctor_allInvalid_tooManyDigits() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to construct
        // Pre: Given "5033", "5388", and "83833" instead of "503", "538" and "8383"
        PhoneNumber num = new PhoneNumber("5033", "5388", "83833");
        // Post: Not constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_ctor_invalidAreaCode_startsWithZero() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to construct
        // Pre: Given area code starting with invalid character
        PhoneNumber num = new PhoneNumber("003", "538", "8383");
        // Post: Not constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_ctor_invalidAreaCode_startsWithOne() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to construct
        // Pre: Given area code starting with invalid character
        PhoneNumber num = new PhoneNumber("103", "538", "8383");
        // Post: Not constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_getAreaCode() {
        // Pre: Must have a PhoneNumber instance
        PhoneNumber num = new PhoneNumber("503", "538", "8383");
        // Post: Returns the area code for the instance
        assertThat(num.getAreaCode(), equalTo("503"));
    }

    @Test
    public void test_PhoneNumber_getPrefix() {
        // Pre: Must have a PhoneNumber instance
        PhoneNumber num = new PhoneNumber("503", "538", "8383");
        // Post: Returns the prefix for the instance
        assertThat(num.getPrefix(), equalTo("538"));
    }

    @Test
    public void test_PhoneNumber_getLineNumber() {
        // Pre: Must have a PhoneNumber instance
        PhoneNumber num = new PhoneNumber("503", "538", "8383");
        // Post: Returns the line number for the instance
        assertThat(num.getLineNumber(), equalTo("8383"));
    }

    @Test
    public void test_PhoneNumber_getDigits() {
        // Pre: Must have a PhoneNumber instance
        PhoneNumber num = new PhoneNumber("503", "538", "8383");
        // Post: Returns the phone number in digit-only form
        assertThat(num.getDigits(), equalTo("5035388383"));
    }

    @Test
    public void test_PhoneNumber_toString() {
        // Pre: Must have a PhoneNumber instance
        PhoneNumber num = new PhoneNumber("503", "538", "8383");
        // Post: Returns the phone number in delimited form (###-###-####)
        assertThat(num.toString(), equalTo("503-538-8383"));
    }

    @Test
    public void test_PhoneNumber_compareTo_lessThan() {
        // Pre: Must have 2 PhoneNumber instances
        PhoneNumber num1 = new PhoneNumber("503", "538", "8383");
        PhoneNumber num2 = new PhoneNumber("403", "538", "8383");
        // Post: Returns -1 because current object is lexically less than the passed object
        assertThat(num1.compareTo(num2), equalTo(1));
    }

    @Test
    public void test_PhoneNumber_compareTo_equivalent() {
        // Pre: Must have 2 PhoneNumber instances
        PhoneNumber num1 = new PhoneNumber("503", "538", "8383");
        PhoneNumber num2 = new PhoneNumber("503", "538", "8383");
        // Post: Returns -1 because current object is lexically equivalent to the passed object
        assertThat(num1.compareTo(num2), equalTo(0));
    }

    @Test
    public void test_PhoneNumber_compareTo_greaterThan() {
        // Pre: Must have 2 PhoneNumber instances
        PhoneNumber num1 = new PhoneNumber("503", "538", "8383");
        PhoneNumber num2 = new PhoneNumber("603", "537", "8383");
        // Post: Returns 1 because current object is lexically greater than the passed object
        assertThat(num1.compareTo(num2), equalTo(-1));
    }

    @Test
    public void test_PhoneNumber_compareTo_null() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(NullPointerException.class);
        // Pre: Must have 1 PhoneNumber instance
        PhoneNumber num = new PhoneNumber("503", "538", "8383");
        // Post: Cannot be compared, throws NullPointerException
        num.compareTo(null);

    }

    @Test
    public void test_PhoneNumber_isValidPhoneNumber_allValid() {
        // Pre: Try to verify validity, given all valid parameters
        assertThat(PhoneNumber.isValidPhoneNumber("503", "538", "8383"), equalTo(true));
        // Post: Verifies phone number and deems valid, returns true
    }

    @Test
    public void test_PhoneNumber_isValidPhoneNumber_nullAreaCode() {
        // Pre: Try to verify validity
        // Pre: Given null area code parameter
        assertThat(PhoneNumber.isValidPhoneNumber(null, "538", "8383"), equalTo(false));
        // Post: Verifies phone number and deems invalid, returns false
    }

    @Test
    public void test_PhoneNumber_isValidPhoneNumber_nullAreaCodeAndPrefix() {
        // Pre: Try to verify validity
        // Pre: Given null area code and prefix parameter
        assertThat(PhoneNumber.isValidPhoneNumber(null, null, "8383"), equalTo(false));
        // Post: Verifies phone number and deems invalid, returns false
    }

    @Test
    public void test_PhoneNumber_isValidPhoneNumber_nullAreaCodeAndLineNumber() {
        // Pre: Try to verify validity
        // Pre: Given null area code and line number parameter
        assertThat(PhoneNumber.isValidPhoneNumber(null, "538", null), equalTo(false));
        // Post: Verifies phone number and deems invalid, returns false
    }

    @Test
    public void test_PhoneNumber_isValidPhoneNumber_nullPrefix() {
        // Pre: Try to verify validity
        // Pre: Given null prefix parameter
        assertThat(PhoneNumber.isValidPhoneNumber("503", null, "8383"), equalTo(false));
        // Post: Verifies phone number and deems invalid, returns false
    }

    @Test
    public void test_PhoneNumber_isValidPhoneNumber_nullPrefixAndLineNumber() {
        // Pre: Try to verify validity
        // Pre: Given null area code parameter
        assertThat(PhoneNumber.isValidPhoneNumber("538", null, null), equalTo(false));
        // Post: Verifies phone number and deems invalid, returns false
    }

    @Test
    public void test_PhoneNumber_isValidPhoneNumber_nullLineNumber() {
        // Pre: Try to verify validity
        // Pre: Given null prefix parameter
        assertThat(PhoneNumber.isValidPhoneNumber("503", "538", null), equalTo(false));
        // Post: Verifies phone number and deems invalid, returns false
    }

    @Test
    public void test_PhoneNumber_isValidPhoneNumber_allNull() {
        // Pre: Try to verify validity
        // Pre: Given null area code parameter
        assertThat(PhoneNumber.isValidPhoneNumber(null, null, null), equalTo(false));
        // Post: Verifies phone number and deems invalid, returns false
    }

    @Test
    public void test_PhoneNumber_isValidPhoneNumber_invalidAreaCode_tooFewDigits() {
        // Pre: Try to verify validity
        // Pre: Given "50" instead of "503"
        assertThat(PhoneNumber.isValidPhoneNumber("50", "538", "8383"), equalTo(false));
        // Post: Verifies phone number and deems invalid, returns false
    }

    @Test
    public void test_PhoneNumber_isValidPhoneNumber_invalidAreaCodeAndPrefix_tooFewDigits() {
        // Pre: Try to verify validity
        // Pre: Given "50" and "53" instead of "503" and "538"
        assertThat(PhoneNumber.isValidPhoneNumber("50", "53", "8383"), equalTo(false));
        // Post: Verifies phone number and deems invalid, returns false
    }

    @Test
    public void test_PhoneNumber_isValidPhoneNumber_invalidAreaCodeAndLineNumber_tooFewDigits()
    {
        // Pre: Try to verify validity
        // Pre: Given "50" and "838" instead of "503" and "8383"
        assertThat(PhoneNumber.isValidPhoneNumber("50", "538", "838"), equalTo(false));
        // Post: Verifies phone number and deems invalid, returns false
    }

    @Test
    public void test_PhoneNumber_isValidPhoneNumber_invalidPrefix_tooFewDigits() {
        // Pre: Try to verify validity
        // Pre: Given "53" instead of "538"
        assertThat(PhoneNumber.isValidPhoneNumber("503", "53", "8383"), equalTo(false));
        // Post: Verifies phone number and deems invalid, returns false
    }

    @Test
    public void test_PhoneNumber_isValidPhoneNumber_invalidPrefixAndLineNumber_tooFewDigits() {
        // Pre: Try to verify validity
        // Pre: Given "53" and "838" instead of "538" and "8383"
        assertThat(PhoneNumber.isValidPhoneNumber("503", "53", "838"), equalTo(false));
        // Post: Verifies phone number and deems invalid, returns false
    }

    @Test
    public void test_PhoneNumber_isValidPhoneNumber_invalidLineNumber_tooFewDigits() {
        // Pre: Try to verify validity
        // Pre: Given "838" instead of "8383"
        assertThat(PhoneNumber.isValidPhoneNumber("503", "538", "838"), equalTo(false));
        // Post: Verifies phone number and deems invalid, returns false
    }

    @Test
    public void test_PhoneNumber_isValidPhoneNumber_allInvalid_tooFewDigits() {
        // Pre: Try to verify validity
        // Pre: Given "50" instead of "503"
        assertThat(PhoneNumber.isValidPhoneNumber("50", "53", "838"), equalTo(false));
        // Post: Verifies phone number and deems invalid, returns false
    }

    @Test
    public void test_PhoneNumber_isValidPhoneNumber_invalidAreaCode_tooManyDigits() {
        // Pre: Try to verify validity
        // Pre: Given "5033" instead of "503"
        assertThat(PhoneNumber.isValidPhoneNumber("5033", "538", "8383"), equalTo(false));
        // Post: Verifies phone number and deems invalid, returns false
    }

    @Test
    public void test_PhoneNumber_isValidPhoneNumber_invalidAreaCodeAndPrefix_tooManyDigits() {
        // Pre: Try to verify validity
        // Pre: Given "5033" and "5388" instead of "503" and "538"
        assertThat(PhoneNumber.isValidPhoneNumber("5033", "5388", "8383"), equalTo(false));
        // Post: Verifies phone number and deems invalid, returns false
    }

    @Test
    public void test_PhoneNumber_isValidPhoneNumber_invalidAreaCodeAndLineNumber_tooManyDigits() {
        // Pre: Try to verify validity
        // Pre: Given "5033" and "83833" instead of "503" and "8383"
        assertThat(PhoneNumber.isValidPhoneNumber("5033", "538", "83833"), equalTo(false));
        // Post: Verifies phone number and deems invalid, returns false
    }

    @Test
    public void test_PhoneNumber_isValidPhoneNumber_invalidPrefix_tooManyDigits() {
        // Pre: Try to verify validity
        // Pre: Given "5388" instead of "538"
        assertThat(PhoneNumber.isValidPhoneNumber("503", "5388", "8383"), equalTo(false));
        // Post: Verifies phone number and deems invalid, returns false
    }

    @Test
    public void test_PhoneNumber_isValidPhoneNumber_invalidPrefixAndLineNumber_tooManyDigits() {
        // Pre: Try to verify validity
        // Pre: Given "5388" and "83833" instead of "538" and "8383"
        assertThat(PhoneNumber.isValidPhoneNumber("503", "5388", "83833"), equalTo(false));
        // Post: Verifies phone number and deems invalid, returns false
    }

    @Test
    public void test_PhoneNumber_isValidPhoneNumber_invalidLineNumber_tooManyDigits() {
        // Pre: Try to verify validity
        // Pre: Given "83833" instead of "8383"
        assertThat(PhoneNumber.isValidPhoneNumber("503", "538", "83833"), equalTo(false));
        // Post: Verifies phone number and deems invalid, returns false
    }

    @Test
    public void test_PhoneNumber_isValidPhoneNumber_allInvalid_tooManyDigits() {
        // Pre: Try to verify validity
        // Pre: Given "5033", "5388" and "83833" instead of "503", "538", and "8383"
        assertThat(PhoneNumber.isValidPhoneNumber("5033", "5388", "83833"), equalTo(false));
        // Post: Verifies phone number and deems invalid, returns false
    }

    @Test
    public void test_PhoneNumber_isValidPhoneNumber_invalidAreaCode_startsWithZero() {
        // Pre: Try to verify validity
        // Pre: Given area code starting with invalid character (0)
        assertThat(PhoneNumber.isValidPhoneNumber("003", "538", "8383"), equalTo(false));
        // Post: Verifies phone number and deems invalid, returns false
    }

    @Test
    public void test_PhoneNumber_isValidPhoneNumber_invalidAreaCode_startsWithOne() {
        // Pre: Try to verify validity
        // Pre: Given area code starting with invalid character (1)
        assertThat(PhoneNumber.isValidPhoneNumber("103", "538", "8383"), equalTo(false));
        // Post: Verifies phone number and deems invalid, returns false
    }

    @Test
    public void test_PhoneNumber_parsePhoneNumber_allValid() {
        // Pre: Try to parse phone number and construct
        // Pre: Given all valid parameter
        PhoneNumber.parsePhoneNumber("503-538-8383");
        // Post: Parsed correctly and constructed, no exceptions thrown
    }

    @Test
    public void test_PhoneNumber_parsePhoneNumber_nullParameter() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to parse phone number and construct
        // Pre: Given null parameter
        PhoneNumber.parsePhoneNumber(null);
        // Post: Cannot be parsed or constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_parsePhoneNumber_invalidAreaCode_tooFewDigits() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to parse phone number and construct
        // Pre: Given "50-538-8383" instead of "503-538-8383"
        PhoneNumber.parsePhoneNumber("50-538-8383");
        // Post: Cannot be constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_parsePhoneNumber_invalidAreaCodeAndPrefix_tooFewDigits() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to parse phone number and construct
        // Pre: Given "50-53-8383" instead of "503-538-8383"
        PhoneNumber.parsePhoneNumber("50-53-8383");
        // Post: Cannot be constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_parsePhoneNumber_invalidAreaCodeAndLineNumber_tooFewDigits() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to parse phone number and construct
        // Pre: Given "50-538-838" instead of "503-538-8383"
        PhoneNumber.parsePhoneNumber("50-538-838");
        // Post: Cannot be constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_parsePhoneNumber_invalidPrefix_tooFewDigits() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to parse phone number and construct
        // Pre: Given "503-53-8383" instead of "503-538-8383"
        PhoneNumber.parsePhoneNumber("503-53-8383");
        // Post: Cannot be constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_parsePhoneNumber_invalidPrefixAndLineNumber_tooFewDigits() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to parse phone number and construct
        // Pre: Given "503-53-838" instead of "503-538-8383"
        PhoneNumber.parsePhoneNumber("503-53-838");
        // Post: Cannot be constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_parsePhoneNumber_invalidLineNumber_tooFewDigits() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to parse phone number and construct
        // Pre: Given "503-538-838" instead of "503-538-8383"
        PhoneNumber.parsePhoneNumber("503-538-838");
        // Post: Cannot be constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_parsePhoneNumber_allInvalid_tooFewDigits() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to parse phone number and construct
        // Pre: Given "50-53-838" instead of "503-538-8383"
        PhoneNumber.parsePhoneNumber("50-53-838");
        // Post: Cannot be constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_parsePhoneNumber_invalidAreaCode_tooManyDigits() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to parse phone number and construct
        // Pre: Given "5033-538-8383" instead of "503-538-8383"
        PhoneNumber.parsePhoneNumber("5033-538-8383");
        // Post: Cannot be constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_parsePhoneNumber_invalidAreaCodeAndPrefix_tooManyDigits() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to parse phone number and construct
        // Pre: Given "5033-5388-8383" instead of "503-538-8383"
        PhoneNumber.parsePhoneNumber("5033-5388-8383");
        // Post: Cannot be constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_parsePhoneNumber_invalidAreaCodeAndLineNumber_tooManyDigits() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to parse phone number and construct
        // Pre: Given "5033-538-83833" instead of "503-538-8383"
        PhoneNumber.parsePhoneNumber("5033-538-83833");
        // Post: Cannot be constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_parsePhoneNumber_invalidPrefix_tooManyDigits() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to parse phone number and construct
        // Pre: Given "503-5388-8383" instead of "503-538-8383"
        PhoneNumber.parsePhoneNumber("503-5388-8383");
        // Post: Cannot be constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_parsePhoneNumber_invalidPrefixAndLineNumber_tooManyDigits() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to parse phone number and construct
        // Pre: Given "503-5388-83833" instead of "503-538-8383"
        PhoneNumber.parsePhoneNumber("503-5388-83833");
        // Post: Cannot be constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_parsePhoneNumber_invalidLineNumber_tooManyDigits() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to parse phone number and construct
        // Pre: Given "503-538-8383" instead of "503-538-83833"
        PhoneNumber.parsePhoneNumber("503-538-83833");
        // Post: Cannot be constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PHoneNumber_parsePhoneNumber_allInvalid_tooManyDigits() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to parse phone number and construct
        // Pre: Given "5033-538-8383" instead of "503-538-8383"
        PhoneNumber.parsePhoneNumber("5033-5388-83833");
        // Post: Cannot be constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_parsePhoneNumber_invalidAreaCode_startsWithZero() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to parse phone number and construct
        // Given phone number starting with invalid character (0)
        PhoneNumber.parsePhoneNumber("003-538-8383");
        // Post: Cannot be constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_parsePhoneNumber_invalidAreaCode_startsWithOne() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to parse phone number and construct
        // Pre: Given phone number starting with invalid character (1)
        PhoneNumber.parsePhoneNumber("103-538-8383");
        // Post: Cannot be constructed, throws IllegalArgumentException
    }

    @Test
    public void test_PhoneNumber_parsePhoneNumber_invalidFormat_noDashes() {
        // Only let this test pass if this specific exception is thrown before the end
        thrown.expect(IllegalArgumentException.class);
        // Pre: Try to parse phone number and construct
        // Pre: Given improperly formatted phone number
        PhoneNumber.parsePhoneNumber("5035388383");
        // Post: Cannot be constructed, throws IllegalArgumentException
    }
}