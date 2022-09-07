// Import used for string conversions
import java.lang.StringBuilder;


/**
 * Models a phone number structured like a phone numpad
 *
 * @author blee20@georgefox.edu
 */
public class PhoneNumber
{
    // Variables
    private final String _originalNumber;
    private final String _convertedNumber;


    //Constructor
    /**
     * Initializes an instance of the PhoneNumber class
     *
     * @param phoneNumber The original phone number inputted
     */
    public PhoneNumber(String phoneNumber)
    {
        StringBuilder sb = new StringBuilder();

        // Logic to convert letter values to proper number values
        for (int i = 0; i < phoneNumber.length(); i++)
        {
            char c = phoneNumber.charAt(i);

            // Cases for each letter variant mapped to a specific number
            switch (c)
            {
                case 'a', 'b', 'c', 'A', 'B', 'C':
                    sb.append('2');
                    break;
                case 'd', 'e', 'f', 'D', 'E', 'F':
                    sb.append('3');
                    break;
                case 'g', 'h', 'i', 'G', 'H', 'I':
                    sb.append('4');
                    break;
                case 'j', 'k', 'l', 'J', 'K', 'L':
                    sb.append('5');
                    break;
                case 'm', 'n', 'o', 'M', 'N', 'O':
                    sb.append('6');
                    break;
                case 'p', 'q', 'r', 's', 'P', 'Q', 'R', 'S':
                    sb.append('7');
                    break;
                case 't', 'u', 'v', 'T', 'U', 'V':
                    sb.append('8');
                    break;
                case 'w', 'x', 'y', 'z', 'W', 'X', 'Y', 'Z':
                    sb.append('9');
                    break;
                case '-':
                    break;
                default:
                    sb.append(c);
            }
        }

        _originalNumber = phoneNumber;
        _convertedNumber = sb.toString();

    }


    // Methods
    /**
     * Accesses the area code from stored convertedNumber
     *
     * @return The area code depending on type of phone number (returnValue)
     */
    public String getAreaCode()
    {
        String returnValue;
        StringBuilder sb = new StringBuilder();

        // Logic to determine phone number type and return appropriately
        if (_convertedNumber.startsWith("1800"))
        {
            returnValue = "1800";
        }

        else
        {
            for (int i = 0; i < 3; i++)
            {
                char c = _originalNumber.charAt(i);
                sb.append(c);
            }
            returnValue = sb.toString();
        }

        return returnValue;
    }


    /**
     * Accesses both versions of the phone number stored and builds a string for them
     *
     * @return The string created using a StringBuilder (sb)
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("java.PhoneNumber\n");
        sb.append(_originalNumber).append('\n');
        sb.append(_convertedNumber);
        return sb.toString();
    }
}
