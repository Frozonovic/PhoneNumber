// Imports
import java.util.ArrayList;


/**
 * Lexical sorting of phone numbers given in the form ###-###-####
 *
 * @author blee20@georgefox.edu
 */
public class PhoneNumberSorter {
    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                System.err.println("No arguments given");
                System.exit(1);
            }


            // Initiate array to store phone numbers
            ArrayList<PhoneNumber> a = new ArrayList<>(args.length);

            for (String s : args) {
                a.add(PhoneNumber.parsePhoneNumber(s));
            }

            for (int i = 0; i < a.size(); i++) {
                PhoneNumber p = a.get(i);

                for (int j = i; j < a.size(); j++) {
                    PhoneNumber n = a.get(j);

                    if (p.compareTo(n) < 0) {
                        p = n;
                    }
                }

                a.remove(p);
                a.add(i, p);
            }

            for (PhoneNumber pn : a) {
                System.out.println(pn.toString());
            }

            System.exit(0);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: Must be a valid phone number");
            System.exit(2);
        }
    }
}
