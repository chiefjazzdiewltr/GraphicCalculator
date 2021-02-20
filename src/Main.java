import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // My main HashMap which acts as a "bridge between" the processor and display
        String line= "";

        // Getting the input and storing it in the line
        System.out.print("What is your function? ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Creating the display and processor classes and passing in their
        // respective paramaters
        Processor processor = new Processor(line);
        HashMap<Float, Float> coords = processor.process();
        Display display = new Display(coords);
        display.outputTable();
    }
}
