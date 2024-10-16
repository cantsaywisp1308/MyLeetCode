package trial;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class DeadlockDetection {

    public static void main(String[] args) {
        // Scanner for reading user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path to the input file: ");
        // Read the file path from user input
        String filePath = scanner.nextLine();
        // Close the scanner to prevent resource leak
        scanner.close();

        try {
            // Try to open and read the file
            Scanner fileScanner = new Scanner(new File(filePath));
            // Read the number of processes from the file
            int numProcesses = fileScanner.nextInt();
            // Read the number of resource types from the file
            int numResourceTypes = fileScanner.nextInt();

            // Array to hold the available instances of each resource type
            int[] available = new int[numResourceTypes];
            for (int i = 0; i < numResourceTypes; i++) {
                available[i] = fileScanner.nextInt();
            }

            // Matrix to hold the allocation of resources to each process
            int[][] allocation = new int[numProcesses][numResourceTypes];
            // Matrix to hold the request of resources from each process
            int[][] request = new int[numProcesses][numResourceTypes];

            // Read the allocation matrix from the file
            for (int i = 0; i < numProcesses; i++) {
                for (int j = 0; j < numResourceTypes; j++) {
                    allocation[i][j] = fileScanner.nextInt();
                }
            }

            // Read the request matrix from the file
            for (int i = 0; i < numProcesses; i++) {
                for (int j = 0; j < numResourceTypes; j++) {
                    request[i][j] = fileScanner.nextInt();
                }
            }
            // Close the file scanner
            fileScanner.close();

            // Variable to keep track of deadlock status
            boolean deadlock = false;
            // Array to keep track of finished processes
            boolean[] finish = new boolean[numProcesses];
            // Work vector to keep track of available resources
            int[] work = available.clone();
            // Flag to keep track of progress in the algorithm
            boolean progress = true;

            // Continue until no further progress can be made
            while (progress) {
                progress = false;
                for (int i = 0; i < numProcesses; i++) {
                    // If the process is not finished and the request can be satisfied
                    if (!finish[i] && checkAvailable(request[i], work)) {
                        // Grant the request and update the work vector
                        for (int j = 0; j < numResourceTypes; j++) {
                            work[j] += allocation[i][j];
                        }
                        // Mark the process as finished
                        finish[i] = true;
                        // We made progress, so continue the loop
                        progress = true;
                    }
                }
            }

            // Check if there are any processes that are not finished
            for (boolean b : finish) {
                if (!b) {
                    deadlock = true;
                    break;
                }
            }

            // Print the result of the deadlock detection
            if (deadlock) {
                System.out.println("There is a deadlock involving the following processes:");
                for (int i = 0; i < finish.length; i++) {
                    if (!finish[i]) {
                        // Print the process number that is part of the deadlock
                        System.out.println("Process " + i);
                    }
                }
            } else {
                // If no deadlock, print this message
                System.out.println("There is no deadlock.");
            }
        } catch (FileNotFoundException e) {
            // If the file is not found, print the stack trace
            e.printStackTrace();
        }
    }

    // Helper method to check if the request can be satisfied
    private static boolean checkAvailable(int[] request, int[] work) {
        for (int i = 0; i < work.length; i++) {
            // If the request is greater than available work, return false
            if (request[i] > work[i]) {
                return false;
            }
        }
        // If all requests can be satisfied, return true
        return true;
    }
}
