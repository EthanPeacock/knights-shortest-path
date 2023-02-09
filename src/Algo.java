import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main algorithm.
 *
 * Requires {@link Queue} in project to run.
 */
public class Algo {
    /**
     * An array of 2 integer values, representing the x and y coordinates of the target.
     * This is an input by the user.
     * @see Algo#getInput()
     */
    static int[] target;

    /**
     * The method called when the program is run, using private methods to get the target coordinates and run both the brute force method of applying
     * BFS and the improved. There is console logging for the number of moves, and fairly accurate execution time of each method.
     * @see Algo#getInput()
     * @see Algo#bruteBFS()
     * @see Algo#BFS()
     * @param args Default
     */
    public static void main(String[] args) {
        getInput();

        try {
            System.out.println("\n--  Brute-force BFS:  --");
            Instant start = Instant.now();
            int moves = bruteBFS();
            Instant end = Instant.now();
            long elapsed = Duration.between(start, end).toMillis();
            System.out.println("Execution Time: " + elapsed + "ms");
            System.out.println("Required Moves: " + moves + "\n");
        } catch (OutOfMemoryError e) {
            System.out.println("Brute BFS failed - Out of Memory\n");
        }

        try {
            System.out.println("--  Improved BFS:  --");
            Instant start2 = Instant.now();
            int moves2 = BFS();
            Instant end2 = Instant.now();
            long elapsed2 = Duration.between(start2, end2).toMillis();
            System.out.println("Execution Time: " + elapsed2 + "ms");
            System.out.println("Required Moves: " + moves2);
        } catch (OutOfMemoryError e) {
            System.out.println("Improved BFS failed - Out Of Memory");
        }
    }

    /**
     * Gets the users input for both the x and y of the target destination, error checking to make sure they are both integers and valid.
     */
    private static void getInput() {
        boolean valid = false;

        while (!valid) {
            try {
                System.out.println("Input the target locations x value:");
                Scanner xInput = new Scanner(System.in);
                int xPos = xInput.nextInt();

                System.out.println("Input the target locations y value:");
                Scanner yInput = new Scanner(System.in);
                int yPos = yInput.nextInt();

                valid = true;
                target = new int[]{xPos, yPos};
            } catch (InputMismatchException e) {
                System.out.println("Please input a valid integer.\n");
            }
        }
    }

    /**
     * This method applies a more generic BFS implementation to find the target location, starting from (0,0). An explanation on how
     * the logic works is in the report.
     * @return The number of moves taken to reach the target destination
     */
    private static int bruteBFS() {
        int moves = 0;
        int targetX = target[0];
        int targetY = target[1];
        int[] xMoves = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] yMoves = {-1, 1, -2, 2, -2, 2, -1, 1};
        Queue q = new Queue();
        q.enqueue(new int[]{0, 0});

        while (!q.isEmpty()) {
            int queueSize = q.size();
            for (int i = 0; i < queueSize; i++) {
                int[] currentPosition = q.dequeue();
                if (currentPosition[0] == targetX && currentPosition[1] == targetY) {
                    return moves;
                }
                for (int j = 0; j < xMoves.length; j++) {
                    int newX = currentPosition[0] + xMoves[j];
                    int newY = currentPosition[1] + yMoves[j];
                    q.enqueue(new int[]{newX, newY});
                }
            }
            moves++;
        }

        System.out.println("Error trying to find target.");
        return -1;
    }

    /**
     * This method applies a more advanced BFS implementation to find the target location, starting from (0,0), using the mathematical
     * absolute value function. An explanation on how the logic works is in the report.
     * @return The number of moves taken to reach the target destination
     */
    private static int BFS() {
        int moves = 0;
        int targetX = Math.abs(target[0]);
        int targetY = Math.abs(target[1]);
        int[] xMoves = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] yMoves = {-1, 1, -2, 2, -2, 2, -1, 1};
        Queue q = new Queue();
        q.enqueue(new int[]{0, 0});
        //ArrayList<int[]> visited = new ArrayList<int[]>(); the previous method, storing visited coords as a sublist
        ArrayList<String> visited = new ArrayList<String>();

        while (!q.isEmpty()) {
            int queueSize = q.size();
            for (int i = 0; i < queueSize; i++) {
                int[] currentPosition = q.dequeue();
                if (currentPosition[0] == targetX && currentPosition[1] == targetY) {
                    return moves;
                }
                for (int j = 0; j < xMoves.length; j++) {
                    int newX = currentPosition[0] + xMoves[j];
                    int newY = currentPosition[1] + yMoves[j];
                    //int[] coords = {newX, newY}; linked to the old method of storing visited coords, seen above.
                    String coords = newX + "," + newY;

                    if (!visited.contains(coords) && newX >= -2 && newY >= -2) {
                        q.enqueue(new int[]{newX, newY});
                        visited.add(coords);
                    }
                }
            }
            moves++;
        }

        System.out.println("Error trying to find target.");
        return -1;
    }
}
