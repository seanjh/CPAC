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

        // Fill the edges of the array with empty values ('.')
        emptyEdges(world);
        

        // Fill the body of the array with the input data
        for (int i = 1; i <= M; i++)
        {
            String line = fileReader.nextLine();
            System.out.println(line);
            char[] lineCharacters = line.toCharArray();
            for (int j = 1; j <= N; j++) {
                world[i][j] = lineCharacters[j - 1];
            }
        }

        // event loop
        System.out.print("Enter Q to Quit, or Enter another character to see the next Generation. ");
        String input = consoleReader.next();

        char[][] oldWorld;

        int generation = 0;

        while(!input.toLowerCase().equals("q")) {
            generation++;

            oldWorld = world;
            world = new char[oldWorld.length][oldWorld[0].length];
            emptyEdges(world);

            int neighbors;
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
                            break;
                    }

                }
            }

            // Display the generation
            System.out.printf("Generation #%d\n", generation);
            printWorld(world);

            //
            System.out.print("Enter Q to Quit, or Enter another character to see the next Generation. ");
            input = consoleReader.next();
        }
        
    } // end main

    public static void printWorld(char[][] world) {
        for (int i = 1; i <= GameOfLife.M; i++) {
            for (int j = 1; j <= GameOfLife.N; j++) {
                System.out.print(world[i][j]);
            }
            System.out.println();
        }
    }

    public static void emptyEdges(char[][] world) {
        int lastColumn = world[0].length - 1;
        for (int i = 0; i < world.length; i++) {
            if (i == 0 || i == lastColumn) { // top and bottom row
                for (int j = 0; j < world[0].length; j++) {
                    world[i][j] = '.';
                }

            } else {
                world[i][0] = '.'; // first column of each row
                world[i][lastColumn] = '.'; // last column of each row
            }
        }
    }

    public static int numberOfNeighbors(char[][] world, int x, int y) {
        int neighbors;
        if (world[x][y] == 'X')
            neighbors = -1; // exclude self
        else
            neighbors = 0;

        // Check in array from world[x-1][y-1] through world[x+1][y+1]
        for (int i = (x - 1); i <= 1; i++ ) {
            for (int j = (y - 1); j <= 1; j++) {
                if (world[i][j] == 'X')
                    neighbors++;
            }
        }

        return neighbors;
    }

    public static boolean isEmpty(char[][] world) {
        for (int i = 1; i <= GameOfLife.M; i++) {
            for (int j = 1; j <= GameOfLife.N; j++) {
                if (world[i][j] == 'X')
                    return false; // Found life, array is not empty
            }
        }

        return true; // Did not find life
    }

}