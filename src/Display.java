import java.util.HashMap;
import java.lang.Math;

public class Display {
    private HashMap<Float, Float> coords;
    public Display(HashMap<Float, Float> coords) {
        this.coords = coords;
    }

    public void outputTable() {
        // Processing length of string
        StringBuilder xConstruct = new StringBuilder();
        StringBuilder yConstruct = new StringBuilder();

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
