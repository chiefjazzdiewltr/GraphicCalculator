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
        double result = 0;
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
                        if(token.charAt(zeroP + 1) == '^') power = Integer.parseInt(String.valueOf(token.charAt(zeroP + 2)));
                        if(Character.isDigit(token.charAt(zeroP - 1))) coefficient = Integer.parseInt(String.valueOf(token.charAt(zeroP - 1)));

                        for(int i = 0; i < xs.length; i++) {
                            double piece = Math.pow(xs[i], power);
                            piece = piece * coefficient;
                            result += piece;
                            ys[i] = (float) piece;
                        }
                        System.out.println("Power: " + power + " Coefficient: " + coefficient);
                    }
                }

                //negate = !negate;
                //for(int i = 0; i < xs.length; i++) ys[i] = (float) result;
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
