package v2.button.panic;

public class CosmicFinalExam {

    /**
     * You must scream "Fanta" n times.
     */
    public static void welcome(int n) {
        // TODO: Implement method to print "Fanta" n times
        for ( int i = 0 ; i < n ; i++ ) System.out.println( "Fanta" );
    }

    /**
     * You tag into the Drakoris Dragon Transport Network.
     * This immediately deducts 12 orglings.
     */
    public static double tagIn(double balance) {
        // TODO: Implement tagIn fare deduction logic
        return balance - 12;
    }

    /**
     * You transfer from one dragon to another, costing 2 more orglings.
     */
    public static double transfer(double balance) {
        // TODO: Implement transfer fare deduction logic
        return balance - 2;
    }

    /**
     * You tag out when reaching your destination.
     * Destinations:
     *   Zenthros  - 20
     *   Kryndor   - 22
     *   Bryxaria  - 27
     * Unknown    - 0 (only the initial 12 was deducted)
     */
    public static double tagOut(String destination, double balance) throws IllegalArgumentException {
        // TODO: Implement tagOut fare deduction logic based on destination
        return ( destination.equalsIgnoreCase( "Zenthros" ) ) ?
                balance - 8 :
                ( destination.equalsIgnoreCase( "Zenthros" ) ) ?
                balance - 10 :
                ( destination.equalsIgnoreCase( "Zenthros" ) ) ?
                balance - 25 :
                throw new IllegalArgumentException( "Balance must not be negative!!" );
    }

    /**
     * Compute the gravitational force between origin and destination planets.
     * Formula: F = G * (m1 * m2) / (r * r)
     * G (in java) = 6.67430e-11;
     */
    public static double lawOfGravity(double m1, double m2, double r) {
        // TODO: Implement gravitational force calculation
        return 0;
    }

    /**
     * Compute the velocity of a spacecraft.
     * Formula: v = d / t
     */
    public static double velocity(double distance, double time) {
        // TODO: Implement velocity calculation
        return 0;
    }

    /**
     * Caesar Cipher implementation with a given shift.
     */
    public static String caesarCipher(String input, int shift) {
        // TODO: Implement Caesar Cipher encryption
        return "";
    }

    /**
     * Draw a Mario-style pyramid of height n.
     */
    public static void drawPyramid(int height) {
        // TODO: Implement pyramid drawing using console output
    }

    /**
     * Bughar's code — Refactor this mess.
     * You may not change logic, only clarity and structure.
     */
    public static boolean isPrime(int number) {
        // TODO: Refactor the provided isPrime method
        return false;
    }

    /**
     * Earn orglings from choices made. ESCAPE if total >= 50.
     */
    public static String getOut(String[] decisions) {
        // TODO: Implement orgling total calculation and return "ESCAPE" or "TRAPPED"
        return "";
    }
}
