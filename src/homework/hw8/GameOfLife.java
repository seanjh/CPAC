/**
 * Author:  Sean Herman
 * Date:    11/24/2013
 * HW#:     8
 * File:    GameOfLife.java
 * Summary: This program simulates life in a simple 2-dimensional world. Life in
 *  this world is displayed as an "X".
 *
 * Assumptions: Except for the 2 methods specified in the assignment, I left all
 *  my functionality in main. Ideally, I think it would be best to move distinct
 *  functionality into separate methods. Given complete freedom, I also probably
 *  would have preferred an object-oriented approach that would allow me to override
 *  the equals() method from Object, but my reading of the instructions lead me to
 *  believe that we should only be using plain char[][] arrays for the 2 worlds.
 *
 *  An objet oriented approach would also allow some additional attributes to be 
 *  easily preserved for the 2 worlds, which would eliminate the need to continually
 *  re-scan the whole 2D array for the loop-continuation-conditions.
 *
 *  I also intentionally derive the next generation before the user even asks to see
 *  it, because the instructions say to do so. This felt a little wasteful, but alas.
 *
 */

import java.util.Scanner;
import java.io.File;

public class GameOfLife {
        public static final int M = 25; // rows
        public static final int N = 75; // columns

    public static void main(String args[]) {
        // Create 2-dimensional array with edges on top, bottom, left, and right
        char[][] world = new char[M + 2][N + 2];

        Scanner consoleReader = new Scanner(System.in);
        System.out.print ("Which file do you want to open? ");
        
        String filename = consoleReader.next();
        File file = new File(filename);
        Scanner fileReader = null;

        // Open a data file
        try
        {
            fileReader = new Scanner(file);        
        } 
        catch (Exception e) 
        {
            System.out.print("file " + file + " does not exist.\n");
            System.exit(0);
        }

        // Fill the body of the array with the input data
        for (int i = 1; i <= M; i++)
        {
            String line = fileReader.nextLine();
            //System.out.println(line);
            char[] lineCharacters = line.toCharArray();
            for (int j = 1; j <= N; j++) {
                world[i][j] = lineCharacters[j - 1];
            }
        }

        int generation = 0;
        char[][] oldWorld = new char[2][2]; // dummy defaults
        String input = "";

        while(!input.toLowerCase().equals("q") && !isEmpty(world) && isChanged(oldWorld, world)) {
            // Display the most recent generation
            System.out.printf("\nGeneration #%d\n", generation);
            printWorld(world);

            // Derive the next generation
            generation++;

            oldWorld = world; // point my alternate world at the existing world array
            world = new char[oldWorld.length][oldWorld[0].length]; // point world at a new, empty world

            int neighbors;
            // Iterate through the oldWorld. 
            // For each x,y coordinate, determine if life belongs in that place.
            for (int i = 1; i <= GameOfLife.M; i++) {
                for (int j = 1; j <= GameOfLife.N; j++) {
                    neighbors = numberOfNeighbors(oldWorld, i, j);

                    switch(oldWorld[i][j]) {
                        case ('X'):
                            if (neighbors == 2 || neighbors == 3)
                                world[i][j] = 'X'; // organism survives
                            else
                                world[i][j] = '.'; // organism dies
                            break;
                        case ('.'):
                            if (neighbors == 3)
                                world[i][j] = 'X'; // new organism
                            else
                                world[i][j] = '.'; // nothing becomes nothing
                            break;
                    }
                }
            }

            System.out.print("\nEnter Q to quit. Enter any other key to see the next generation. >> ");
            input = consoleReader.next();
        }
        
    } // end main

    public static void printWorld(char[][] world) {

        for (int i = 1; i <= GameOfLife.M; i++) {
            StringBuffer line = new StringBuffer("");
            for (int j = 1; j <= GameOfLife.N; j++) {
                if (world[i][j] == '.') {
                    line.append(' '); // output . as empty space
                } else {
                    //System.out.print(world[i][j]);
                    //line += ("" + world[i][j]);
                    line.append(world[i][j]);
                }
            }
            line.append("\n");
            System.out.print(line);
        }
    }

    public static int numberOfNeighbors(char[][] world, int x, int y) {
        int neighbors;
        if (world[x][y] == 'X')
            neighbors = -1; // exclude self
        else
            neighbors = 0;

        // Check in array from world[x+-1][y+-1] through world[x+1][y+1]
        for (int i = -1; i <= 1; i++ ) {
            for (int j = -1; j <= 1; j++) {
                if (world[x + i][y + j] == 'X')
                    neighbors++;
            }
        }

        return neighbors;
    }

    public static boolean isChanged(char[][] oldWorld, char[][] world) {
        for (int i = 1; i <= GameOfLife.M; i++) {
            for (int j = 1; j <= GameOfLife.N; j++) {
                if (oldWorld[i][j] != world[i][j]) {
                    return true; // found mismatched elements
                }
            }
        }
        
        System.out.println("\nLife in this world has stagnated. " +
            "This Game of Life has ended.\n");
        return false; // all elements matched
    }

    public static boolean isEmpty(char[][] world) {
        for (int i = 1; i <= GameOfLife.M; i++) {
            for (int j = 1; j <= GameOfLife.N; j++) {
                if (world[i][j] == 'X')
                    return false; // Found life, array is not empty
            }
        }

        System.out.println("\nThis world is devoid of life. " +
            "This Game of Life has ended.\n");
        return true; // Did not find life
    }
}
