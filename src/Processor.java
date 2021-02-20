import java.util.*;

public class Processor {
    String function;
    public Processor( String function) {
        this.function = function;
    }

    /**
     * Process functions by splitting them into tokens and then processing simple polynomials
     * @return A hashmap of all the coordinates
     */
    public HashMap<Float, Float> process() {
        String[] tokens = function.split(" "); // List storing all the function components
        float[] xs = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // Float array for the x coordinates
        float[] ys = new float[xs.length]; // Float array for the y coordinates
        boolean negate = false;
        // Assuming layout is 2x^2 + 1 or something similar
        if(function.contains("x")) {
            for (String token : tokens) { // For each loop that goes through each token in the function string
                if (token.equals("-")) negate = true;
                else if (token.equals("+")) negate = false;
                else {
                    if(token.contains("x")) { // If statements that starts the whole tokenization processing system
                        int zeroP = token.indexOf("x");
                        double power;
                        double coefficient;
                        // This section is for Powers
                        if(zeroP < token.length() - 1) power = Double.parseDouble(token.substring(zeroP + 2)); // Actually gets the power
                        else power = 1;
                        // This section is for Coefficients
                        if(zeroP > 0)
                        {
                            if (token.substring(0, zeroP).equals("-")) coefficient = -1;
                            else coefficient = Double.parseDouble(token.substring(0, zeroP)); // Actually gets the coefficient
                        }
                        else coefficient = 1;

                        // For loop that actually does all the math stuff
                        for(int i = 0; i < xs.length; i++) {
                            double piece = Math.pow(xs[i], power);
                            if(negate) piece = -1 * piece * coefficient;
                            else piece = piece * coefficient;
                            ys[i] += (float) piece;
                        }
                    }
                }
            }
        }

        // Creates the hashmap and adds them to the hashmap and runs displays them in a loop
        HashMap<Float, Float> coordinates = new HashMap<>();
        for(int i = 0; i < xs.length; i++) {
            coordinates.put(xs[i], ys[i]);
            System.out.println(xs[i] + ": " + ys[i]);
        }
        return coordinates;
    }
}
