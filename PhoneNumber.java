// Imports
import java.lang.StringBuilder;


/**
 * Models a phone number structured like a phone numpad. Does not support alphabetical characters.
 *
 * @author blee20@georgefox.edu
 */
public class PhoneNumber implements Comparable<PhoneNumber> {
    // Internal State
    private final String _areaCode;
    private final String _prefix;
    private final String _lineNumber;


    // Constructor
    /**
     * Initializes an instance of the PhoneNumber class
     *
     * @param areaCode The original area code inputted (first three digits)
     * @param prefix The original prefix inputted (middle three digits)
     * @param lineNumber The original line number inputted (last four digits)
     * @throws IllegalArgumentException Thrown when phone number is in invalid format
     */
    public PhoneNumber(String areaCode, String prefix, String lineNumber) {
        // Verifies that the given arguments can create be a proper a phone number
        if (!(isValidPhoneNumber(areaCode, prefix, lineNumber))) {
            throw new IllegalArgumentException("Error: Must be a valid phone number");
        } else {
            _areaCode = areaCode;
            _prefix = prefix;
            _lineNumber = lineNumber;
        }
    }


    // Methods
    /**
     * Accesses the area code from stored areaCode
     *
     * @return The current area code assigned to _areaCode
     */
    public String getAreaCode() {
        return _areaCode;
    }


    /**
     * Accesses the prefix from stored prefix
     *
     * @return The current prefix assigned to _prefix
     */
    public String getPrefix() {
        return _prefix;
    }


    /**
     * Accesses the line number from stored lineNumber
     *
     * @return The current prefix assigned to _lineNumber
     */
    public String getLineNumber() {
        return _lineNumber;
    }


    /**
     * Creates a numerical phone number from stored variables
     *
     * @return String containing only numerals
     */
    public String getDigits() {
        StringBuilder sb = new StringBuilder();

        sb.append(_areaCode);
        sb.append(_prefix);
        sb.append(_lineNumber);

        return sb.toString();
    }


    /**
     * Accesses both versions of the phone number stored and builds a string for them
     *
     * @return The string created using a StringBuilder (sb)
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(_areaCode).append('-');
        sb.append(_prefix).append('-');
        sb.append(_lineNumber);

        return sb.toString();
    }


    /**
     * Compares two PhoneNumber instances together to sort lexically
     *
     * @param o The object to be compared
     * @return The value -1 if passed string is lexically less than current string, the value 0 if
     * passed string is lexically equal to current string, and the value 1 if passed string is
     * lexically greater than current string
     */
    public int compareTo(PhoneNumber o) {
        int result = 0;

        if (Long.parseLong(o.getDigits()) < Long.parseLong(getDigits())) {
            result = -1;
        }

        if (Long.parseLong(o.getDigits()) > Long.parseLong(getDigits())) {
            result = 1;
        }

        return result;
    }


    /**
     * Takes 3 arguments and checks to see if they would create a valid PhoneNumber
     *
     * @param areaCode The area code (first 3 digits) of PhoneNumber to verify
     * @param prefix The prefix (middle 3 digits) of PhoneNumber to verify
     * @param lineNumber The line number (last 4 digits) of PhoneNumber to verify
     * @return Boolean value appropriate to verification result (returnValue)
     */
    public static boolean isValidPhoneNumber(String areaCode, String prefix, String lineNumber) {
        boolean checkAreaCode = areaCode.matches("[2-9]\\d{2}");
        boolean checkPrefix = prefix.matches("[2-9]\\d{2}");
        boolean checkLineNumber = lineNumber.matches("\\d{4}");

        return checkAreaCode && checkPrefix && checkLineNumber;
    }


    /**
     * Splits a phone number into separate chunks to check each for valid content
     *
     * @param phoneNumber A given PhoneNumber instance for checking validity
     * @return Completed and valid phone number
     * @throws IllegalArgumentException Thrown when phone number is in invalid format
     */
    public static PhoneNumber parsePhoneNumber(String phoneNumber) {
        String areaCode = phoneNumber.split("-")[0];
        String prefix = phoneNumber.split("-")[1];
        String lineNumber = phoneNumber.split("-")[2];

        return new PhoneNumber(areaCode, prefix, lineNumber);
    }
}