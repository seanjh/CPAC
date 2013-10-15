import java.util.Random;

public class CarSimulator {
    public static void main(String[] args) {

    }
}

public class Car {
    private char color;
    private boolean ignition;
    private Position coordinates;
    public static int totalCars;

    Car() {
        color = randomColor();
        ignition = false;
        coordinates = new Position();
        totalCars++;
    }

    public static char randomColor() {
        char[] allColors = {'R', 'G', 'B', 'W', 'S'};
        Random r = new Random();
        return allColors[r.nextInt(5)];
    }

    private void switchIgnition() {
        ignition = !ignition;
    }

    public boolean isIgnitionOn() {
        return ignition;
    }

    public int[] getPosition() {
        return coordinates.getCoordinates();
    }

    public char getColor() {
        return color;
    }

    public printIgnitionStatus() {
        if (ignition) {
            System.out.print("On")
        } else {
            System.out.print("Off")
        }
    }

    public void printColor() {
        String fullColor;
        
        // Determine the corresponding full color output String for char color.
        if (color == 'R')
          fullColor = "Red";
        else if (color == 'G')
          fullColor = "Green";
        else if (color == 'B')
          fullColor = "Blue";
        else if (color == 'W')
          fullColor = "White";
        else if (color == 'S')
          fullColor = "Silver";
        else
          fullColor = "ERROR!";

        System.out.print(fullColor);
    }

    public void printStatus() {
        System.out.println("Car Information");
        System.out.println("Color: " + printColor();
        System.out.println("Ignition: " + printIgnitionStatus();
    }
}

public class Position {
    private int x;
    private int y;
    private int range;

    Position() {
        // Populate
        range = 20;

        Random r = new Random();
        x = r.nextInt(range) + 1;
        y = r.nextInt(range) + 1;
    }

    Position(int maximum) {
        range = maximum;

        Random r = new Random();
        x = r.nextInt(maximum) + 1;
        y = r.nextInt(maximum) + 1;
    }

    Position(int inputX, int inputY) {
        x = inputX;
        y = inputY;
    }

    Position(int[] coordinates) {
        setCoordinates(coordinates);
    }

    public int[] getCoordinates() {
        return {x, y};
    }

    public int getRange() {
        return range;
    }

    public void setRange(int maximum) {
        range = maximum;
    }

    public void setCoordinates(int[] coordinates) {
        x = coordinates[0];
        y = coordinates[0];
    }
}