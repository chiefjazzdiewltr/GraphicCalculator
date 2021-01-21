import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Float, Float> coords = new HashMap<>();
        coords.put(0f, 0f);
        coords.put(1f, 1f);
        coords.put(2f, 4f);
        coords.put(3f, 9f);
        coords.put(4f, 16f);
        coords.put(5f, 25f);
        Display display = new Display(coords);
        display.outputTable();
    }
}
