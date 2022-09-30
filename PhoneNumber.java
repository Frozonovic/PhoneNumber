// Import used for string conversions
import java.lang.StringBuilder;
import java.util.ArrayList;


/**
 * Models a phone number structured like a phone numpad. Does not support alphabetical characters.
 *
 * @author blee20@georgefox.edu
 */
public class PhoneNumber implements Comparable<PhoneNumber>
{
    // Constants
    private final int LESS_THAN = -1;
    private final int EQUIVALENT = 0;
    private final int GREATER_THAN = 1;


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
     * @throws IllegalArgumentException Thrown when phone number is in invalid format
     */
    public PhoneNumber(String areaCode, String prefix, String lineNumber)
            throws IllegalArgumentException
    {
        // Verifies that the given arguments can create be a proper a phone number
        if (isValidPhoneNumber(areaCode, prefix, lineNumber))
        {
            _areaCode = areaCode;
            _prefix = prefix;
            _lineNumber = lineNumber;
        }
        else
        {
            throw new IllegalArgumentException("Error: Must be a valid phone number");
        }
    }


    // Methods
    /**
     * Accesses the area code from stored areaCode
     *
     * @return The current area code assigned to _areaCode
     */
    public String getAreaCode()
    {
        return _areaCode;
    }


    /**
     * Accesses the prefix from stored prefix
     *
     * @return The current prefix assigned to _prefix
     */
    public String getPrefix()
    {
        return _prefix;
    }


    /**
     * Accesses the line number from stored lineNumber
     *
     * @return The current prefix assigned to _lineNumber
     */
    public String getLineNumber()
    {
        return _lineNumber;
    }


    /**
     * Creates a numerical phone number from stored variables
     *
     * @return String containing only numerals
     */
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


    /**
     * Compares two PhoneNumber instances together to sort lexically
     *
     * @param o The object to be compared
     * @return The value -1 if parameter is lexically greater than current phone number, 0 if
     * parameter is lexically equivalent to current phone number, or 1 if parameter is lexically
     * less than current phone number
     */
    public int compareTo(PhoneNumber o)
    {
        try
        {
            int returnValue = EQUIVALENT;

            if (getDigits().compareTo(o.getDigits()) < EQUIVALENT) {
                returnValue = LESS_THAN;
            }

            if (getDigits().compareTo(o.getDigits()) > EQUIVALENT) {
                returnValue = GREATER_THAN;
            }

            return returnValue;
        }
        catch (NullPointerException e)
        {
            throw new IllegalArgumentException("Error: Must be a valid phone number");
        }
    }


    /**
     * Takes 3 arguments and checks to see if they would create a valid PhoneNumber
     *
     * @param areaCode The area code (first 3 digits) of PhoneNumber to verify
     * @param prefix The prefix (middle 3 digits) of PhoneNumber to verify
     * @param lineNumber The line number (last 4 digits) of PhoneNumber to verify
     * @return Boolean value appropriate to verification result (returnValue)
     */
    public static boolean isValidPhoneNumber(String areaCode, String prefix, String lineNumber)
    {
        boolean returnValue = true;
        ArrayList<String> numArray = new ArrayList<>();

        // Check that all values are not null values
        if ((areaCode != null && areaCode.length() == 3) && (prefix != null && prefix.length() == 3)
                && (lineNumber != null && lineNumber.length() == 4))
        {
            // Sets up ArrayList for String comparison
            for (int i = 0; i < 10; i++)
            {
                numArray.add(String.valueOf(i));
            }

            // Iterates through each character of the areaCode and compares to String array contents
            for (int i = 0; i < areaCode.length(); i++)
            {
                String s = String.valueOf(areaCode.charAt(i));

                if ((s.equals("0") && i == 0) || (s.equals("1") && i == 0) || !(numArray.contains(s)))
                {
                    returnValue = false;
                    break;
                }
            }

            // Iterates through each character of the prefix and compares to String array contents
            for (int i = 0; i < prefix.length(); i++)
            {
                String s = String.valueOf(prefix.charAt(i));

                if (!(numArray.contains(s)))
                {
                    returnValue = false;
                    break;
                }
            }

            // Iterates through each character of the lineNumber and compares to String array contents
            for (int i = 0; i < lineNumber.length(); i++)
            {
                String s = String.valueOf(lineNumber.charAt(i));

                if (!(numArray.contains(s)))
                {
                    returnValue = false;
                    break;
                }
            }
        }

        else
        {
            returnValue = false;
        }

        return returnValue;
    }


    /**
     * Splits a phone number into separate chunks to check each for valid content
     *
     * @param phoneNumber A given PhoneNumber instance for checking validity
     * @return Completed and valid phone number
     * @throws IllegalArgumentException Thrown when phone number is in invalid format
     */
    public static PhoneNumber parsePhoneNumber(String phoneNumber) throws IllegalArgumentException
    {
        try
        {
            String areaCode = phoneNumber.split("-")[0];
            String prefix = phoneNumber.split("-")[1];
            String lineNumber = phoneNumber.split("-")[2];

            if (isValidPhoneNumber(areaCode, prefix, lineNumber))
            {
                return new PhoneNumber(areaCode, prefix, lineNumber);
            }

            else
            {
                throw new IllegalArgumentException("Error: Must be a valid phone number");
            }
        }
        catch (NullPointerException e)
        {
            throw new IllegalArgumentException("Error: Must be a valid phone number");
        }
    }
}