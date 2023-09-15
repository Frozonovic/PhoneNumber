// Imports
import java.util.ArrayList;


/**
 * A command-line utility class that lexically sorts given phone numbers (###-###-####)
 *
 * @author blee20@georgefox.edu
 */
public class PhoneNumberSorter {
    // Constants
    private static final int NO_ARGS_CODE = 1;
    private static final int INVALID_CODE = 2;
    private static final int NO_ARGS = 0;
    private static final int START_INDEX = 0;
    private static final int EQUAL = 0;


    // Main Function
    public static void main(String[] args) {
        try {
            if (args.length == NO_ARGS) {
                // Ensure that at least one phone number is given as an argument
                System.err.println("No arguments given");
                System.exit(NO_ARGS_CODE);
            }

            // Initiate array to store phone numbers
            ArrayList<PhoneNumber> a = new ArrayList<>(args.length);

            for (String s : args) {
                // Populate the array with given numbers
                a.add(PhoneNumber.parsePhoneNumber(s));
            }

            // Logic to compare each phone number (p) to each other phone number (n)
            for (int i = START_INDEX; i < a.size(); i++) {
                PhoneNumber p = a.get(i);

                for (int j = i; j < a.size(); j++) {
                    PhoneNumber n = a.get(j);

                    if (p.compareTo(n) < EQUAL) {
                        p = n;
                    }
                }

                a.remove(p);
                a.add(i, p);
            }

            for (PhoneNumber pn : a) {
                System.out.println(pn.toString());
            }
        } catch (IllegalArgumentException e) {
            // Catches any improperly formatted phone numbers
            System.err.println("Error: Phone number must be properly formatted");
            System.exit(INVALID_CODE);
        }
    }
}
