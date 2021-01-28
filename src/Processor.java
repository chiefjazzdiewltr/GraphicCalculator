import java.util.*;

public class Processor {
    HashMap<Float, Float> coords;
    String function;
    public Processor(HashMap<Float, Float> coords, String function) {
        this.coords = coords;
        this.function = function;
    }

    private List<String> tokenizer() {
        List<String> tokens = Arrays.asList(function.split(" "));
        return tokens;
    }

    private HashMap<Float, Float> processor() {

        return new HashMap<Float, Float>();
    }
}
