// Imports
import java.lang.StringBuilder;


/**
 * A phone number class adhering to the North American Numbering Plan specifications
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
     * Fetches the current object's area code
     *
     * @return Area code string
     */
    public String getAreaCode() {
        return _areaCode;
    }


    /**
     * Fetches the current object's prefix
     *
     * @return Prefix string
     */
    public String getPrefix() {
        return _prefix;
    }


    /**
     * Fetches the current object's line number
     *
     * @return Line number string
     */
    public String getLineNumber() {
        return _lineNumber;
    }


    /**
     * Creates a numerical phone number from stored variables
     *
     * @return Numerical string
     */
    public String getDigits() {
        StringBuilder sb = new StringBuilder();

        sb.append(_areaCode);
        sb.append(_prefix);
        sb.append(_lineNumber);

        return sb.toString();
    }


    /**
     * Creates a string of the current phone number
     *
     * @return Phone number string (###-###-####)
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(_areaCode).append('-');
        sb.append(_prefix).append('-');
        sb.append(_lineNumber);

        return sb.toString();
    }


    /**
     * Compares two PhoneNumber instances together
     *
     * @param o The object to be compared
     * @return The value -1 if passed PhoneNumber is lexically less than the current PhoneNumber, the value 0 if
     * passed PhoneNumber is lexically equal to the current PhoneNumber, and the value 1 if passed PhoneNumber is
     * lexically greater than the current PhoneNumber
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
     * @param areaCode An area code string
     * @param prefix A prefix string
     * @param lineNumber A line number string
     * @return True if each part adheres to the North American Numbering Plan, else false
     */
    public static boolean isValidPhoneNumber(String areaCode, String prefix, String lineNumber) {
        boolean checkAreaCode = areaCode.matches("[2-9]\\d{2}");
        boolean checkPrefix = prefix.matches("[2-9]\\d{2}");
        boolean checkLineNumber = lineNumber.matches("\\d{4}");

        return checkAreaCode && checkPrefix && checkLineNumber;
    }


    /**
     * Parses a given phone number string
     *
     * @param phoneNumber A parseable phone number string (###-###-###)
     * @return New object instance
     */
    public static PhoneNumber parsePhoneNumber(String phoneNumber) {
        String areaCode = phoneNumber.split("-")[0];
        String prefix = phoneNumber.split("-")[1];
        String lineNumber = phoneNumber.split("-")[2];

        return new PhoneNumber(areaCode, prefix, lineNumber);
    }
}