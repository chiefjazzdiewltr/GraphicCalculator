import java.util.HashMap;
import java.lang.Math;

/**
 * This class is the main display of the Graphics calculator function, it takes a given float hashmap and display its
 * contents as a table on the command line.
 */
public class Display {
    private HashMap<Float, Float> coords;

    /**
     * THis is the main constructer that actually retrieves the hashmap and makes it privately available
     * @param coords
     */
    public Display(HashMap<Float, Float> coords) {
        this.coords = coords;
    }

    /**
     * This method is what outputs the table to the main commandline display (it is a very messy piece of code,
     * and probably doesn't work well for fringe cases. But it will suffice
     */
    public void outputTable() {
        // Creating String builders for more readable concatenation
        StringBuilder xConstruct = new StringBuilder();
        StringBuilder yConstruct = new StringBuilder();
        // For loops for constructing the main two x and y table lines
        for(int i = 0; i < coords.size(); i++) {
            xConstruct.append(coords.keySet().toArray()[i].toString());
            xConstruct.append('-');
        }
        for(Float f : coords.values()) { // Using a for each loop because the values are floats
            yConstruct.append(f);
            yConstruct.append('-');
        }

        // X coordinates
        System.out.print('x');
        if(xConstruct.length() > yConstruct.length()){
            for(int i = 0; i < xConstruct.length(); i++) System.out.print('-');
        }
        else {
            for(int i = 0; i < yConstruct.length(); i++) System.out.print('-');
        }

        System.out.print("\n-");
        System.out.print(xConstruct);

        // This difference is needed as the x coordinate line could easily be outperformed by the y coordinate
        int diff = Math.abs(xConstruct.length() - yConstruct.length());
        for(int i = 0; i < diff; i++) System.out.print('-');
        System.out.print("\n");

        // Y coordinates
        System.out.print('y');
        if(yConstruct.length() > xConstruct.length()){
            for(int i = 0; i < yConstruct.length(); i++) System.out.print('-');
        }
        else {
            for(int i = 0; i < xConstruct.length(); i++) System.out.print('-');
        }

        System.out.print("\n-");
        System.out.print(yConstruct);

        // End of table
        System.out.print("\n");
        if(yConstruct.length() > xConstruct.length()) for(int i = 0; i < yConstruct.length() + 1; i++) System.out.print('-');
        else for(int i = 0; i < xConstruct.length() + 1; i++) System.out.print('-');
    }
}
