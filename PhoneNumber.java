import java.lang.StringBuilder;

public class PhoneNumber
{
    private final String _originalNumber;
    private final String convertedNumber;


    public PhoneNumber(String phoneNumber)
    {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < phoneNumber.length(); i++)
        {
            char c = phoneNumber.charAt(i);

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
        convertedNumber = sb.toString();

    }

    public String getAreaCode()
    {
        String returnValue;
        StringBuilder sb = new StringBuilder();

        if (convertedNumber.startsWith("1800"))
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

    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("java.PhoneNumber\n");
        sb.append(_originalNumber).append('\n');
        sb.append(convertedNumber);
        return sb.toString();
    }
    public static void main(String[] args)
    {
        PhoneNumber f = new PhoneNumber("360-957-8562");
        System.out.println(f);
        System.out.println(f.getAreaCode());
    }
}
