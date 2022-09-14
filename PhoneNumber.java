// Import used for string conversions
import java.lang.StringBuilder;


/**
 * Models a phone number structured like a phone numpad
 *
 * @author blee20@georgefox.edu
 */
public class PhoneNumber implements Comparable<PhoneNumber>
{
    // Variables
    private final String _areaCode;
    private final String _prefix;
    private final String _lineNumber;


    //Constructor
    /**
     * Initializes an instance of the PhoneNumber class
     *
     * @param areaCode The original area code inputted (first three digits)
     * @param prefix The original prefix inputted (middle three digits)
     * @param lineNumber The original line number inputted (last four digits)
     */
    public PhoneNumber(String areaCode, String prefix, String lineNumber)
    {
        _areaCode = areaCode;
        _prefix = prefix;
        _lineNumber = lineNumber;
    }


    // Methods
    /**
     * Accesses the area code from stored convertedNumber
     *
     * @return The current area code assigned to _areaCode
     */
    public String getAreaCode()
    {
        return _areaCode;
    }


    public String getPrefix()
    {
        return _prefix;
    }


    public String getLineNumber()
    {
        return _lineNumber;
    }


    public String getDigits()
    {
        return _areaCode + _prefix + _lineNumber;
    }


    /**
     * Accesses both versions of the phone number stored and builds a string for them
     *
     * @return The string created using a StringBuilder (sb)
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append(_areaCode).append('-');
        sb.append(_prefix).append('-');
        sb.append(_lineNumber);

        return sb.toString();
    }


    public int compareTo(PhoneNumber o)
    {
        return 1;
    }


    public static boolean isValidPhoneNumber(String areaCode, String prefix, String lineNumber)
    {
        return true;
    }


    public static PhoneNumber parsePhoneNumber(String phoneNumber)
    {
        return new PhoneNumber("1", "2", "3");
    }
}

