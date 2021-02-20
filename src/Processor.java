import java.util.*;

public class Processor {
    String function;
    public Processor( String function) {
        this.function = function;
    }

    private List<String> tokenizer() {
        return Arrays.asList(function.split(" "));
    }

    public HashMap<Float, Float> process() {
        List<String> tokens = tokenizer();
        float[] xs = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        float[] ys = new float[xs.length];
        boolean negate = false;
        // Assuming layout is 2x^2 + 1 or something similar
        if(function.contains("x")) {
            for (String token : tokens) {
                if (token.equals("-")) negate = !negate;
                else {
                    if(token.contains("x")) {
                        int zeroP = token.indexOf("x");
                        System.out.println(zeroP);
                        int power = 0;
                        int coefficient = 0;
                        if(token.charAt(zeroP + 1) == '^'){
                            System.out.println(token.substring(zeroP + 2));
                            try {
                                power = Integer.parseInt(token.substring(zeroP + 2));
                            }
                            catch(NumberFormatException e) {
                                power = 0;
                            }
                        }
                        if(Character.isDigit(token.charAt(zeroP - 1))) {
                            try{
                                coefficient = Integer.parseInt(token.substring(0, zeroP - 1));
                            }
                            catch(NumberFormatException e) {
                                coefficient = 0;
                            }
                        }

                        for(int i = 0; i < xs.length; i++) {
                            double piece = Math.pow(xs[i], power);
                            if(negate) piece = -1 * piece * coefficient;
                            else piece = piece * coefficient;
                            ys[i] += (float) piece;
                        }
                        System.out.println("Power: " + power + " Coefficient: " + coefficient);
                    }
                }
            }
        }
        HashMap<Float, Float> coordinates = new HashMap<>();
        for(int i = 0; i < xs.length; i++) {
            coordinates.put(xs[i], ys[i]);
            System.out.println(xs[i] + ": " + ys[i]);
        }
        return coordinates;
    }
}
