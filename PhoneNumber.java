import java.util.ArrayList;
import java.lang.StringBuilder;

public class PhoneNumber
{
    private final String _originalNumber;
    private String convertedNumber;


    public PhoneNumber(String phoneNumber)
    {
        StringBuilder build1 = new StringBuilder();
        StringBuilder build2 = new StringBuilder();


        for (int i = 0; i < phoneNumber.length(); i++)
        {
            char c = phoneNumber.charAt(i);

            if (c != '-')
            {
                build1.append(c);
            }

            switch (c)
            {
                case 'a', 'b', 'c', 'A', 'B', 'C':
                    build2.append('2');
                    break;
                case 'd', 'e', 'f', 'D', 'E', 'F':
                    build2.append('3');
                    break;
                case 'g', 'h', 'i', 'G', 'H', 'I':
                    build2.append('4');
                    break;
                case 'j', 'k', 'l', 'J', 'K', 'L':
                    build2.append('5');
                    break;
                case 'm', 'n', 'o', 'M', 'N', 'O':
                    build2.append('6');
                    break;
                case 'p', 'q', 'r', 's', 'P', 'Q', 'R', 'S':
                    build2.append('7');
                    break;
                case 't', 'u', 'v', 'T', 'U', 'V':
                    build2.append('8');
                    break;
                case 'w', 'x', 'y', 'z', 'W', 'X', 'Y', 'Z':
                    build2.append('9');
                    break;
                case '-':
                    break;
                default:
                    build2.append(c);
            }
        }

        _originalNumber = phoneNumber;
        convertedNumber = build2.toString();

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
        PhoneNumber f = new PhoneNumber("1-800-FLOWERS");
        System.out.print(f);
    }
}
