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
     * @param phoneNumber User-inputted string
     */
    public PhoneNumber(String phoneNumber) {
        StringBuilder sb = new StringBuilder();

        if (phoneNumber == null) {
            System.out.print("Error: Must provide a number");
            System.exit(1);
        }

        // Logic to convert letter values to proper number values
        for (int i = 0; i < phoneNumber.length(); i++) {

            char c = phoneNumber.charAt(i);

            // Cases for each letter variant mapped to a specific number
            switch (c) {
                case 'a', 'b', 'c', 'A', 'B', 'C' -> sb.append('2');
                case 'd', 'e', 'f', 'D', 'E', 'F' -> sb.append('3');
                case 'g', 'h', 'i', 'G', 'H', 'I' -> sb.append('4');
                case 'j', 'k', 'l', 'J', 'K', 'L' -> sb.append('5');
                case 'm', 'n', 'o', 'M', 'N', 'O' -> sb.append('6');
                case 'p', 'q', 'r', 's', 'P', 'Q', 'R', 'S' -> sb.append('7');
                case 't', 'u', 'v', 'T', 'U', 'V' -> sb.append('8');
                case 'w', 'x', 'y', 'z', 'W', 'X', 'Y', 'Z' -> sb.append('9');
                case '-', '(', ')' -> { }
                case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> sb.append(c);
                default -> {
                    System.out.format("Error: Input may not contain %c", c);
                    System.exit(1);
                }
            }
        }

        if (sb.length() != 10 && sb.length() != 11) {
            System.out.print("Error: Invalid phone number length");
            System.exit(1);
        }

        _originalNumber = phoneNumber;
        _convertedNumber = String.valueOf(sb);
    }


    // Methods
    /**
     * Fetches the area code for the current PhoneNumber object
     *
     * @return The area code of the current object
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
