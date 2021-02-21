import java.util.TreeMap;

/**
 * This class handles all the displaying of all the table information in a nice easy to read format.
 */
public class Display {
    private final TreeMap<Float, Float> coords;

    /**
     * This constructor is nothing more than getting the hashmap from the processor and storing it as a reference
     * in the class
     * @param coords The hashmap storing all the X-Y coordinate information (possibly more than x and y but that is a
     *               future problem)
     */
    public Display(TreeMap<Float, Float> coords) {
        this.coords = coords;
    }

    /**
     * This function displays the table in an easy to read format using the formatter class.
     */
    public void outputTable() {
        // The format for the dynamically added lines
        String leftAlignFormat = "| %-13s | %-13s |%n";

        System.out.format("+---------------+---------------+%n");
        System.out.format("|X-coords       |Y-coords       |%n");
        System.out.format("+---------------+---------------+%n");
        // The for loop that dynamically adds values from the treemap into the table
        for(int i = 0; i < coords.keySet().toArray().length; i++) {
            String xcoord = String.format("X: %.2f", coords.keySet().toArray()[i]);
            String ycoord = String.format("Y: %.2f", coords.values().toArray()[i]);
            System.out.format(leftAlignFormat, xcoord, ycoord);
        }
        System.out.format("+---------------+---------------+%n");
    }
}
