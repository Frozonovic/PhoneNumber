// Imports
import java.util.ArrayList;


/**
 * A command-line utility class that lexically sorts given phone numbers (###-###-####)
 *
 * @author blee20@georgefox.edu
 */
public class PhoneNumberSorter {
    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                // Ensure that at least one phone number is given as an argument
                System.err.println("No arguments given");
                System.exit(1);
            }

            // Initiate array to store phone numbers
            ArrayList<PhoneNumber> a = new ArrayList<>(args.length);

            for (String s : args) {
                // Populate the array with given numbers
                a.add(PhoneNumber.parsePhoneNumber(s));
            }

            // Logic to compare each phone number (p) to each other phone number (n)
            for (int i = 0; i < a.size(); i++) {
                PhoneNumber p = a.get(i);

                for (int j = i; j < a.size(); j++) {
                    PhoneNumber n = a.get(j);

                    if (p.compareTo(n) < 0) {
                        // If a number with a smaller value is found, p is replaced
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
            // Catches any improperly formatted phone numbers
            System.err.println("Error: Must be a valid phone number");
            System.exit(2);
        }
    }
}
