import java.util.Random;

public class SortingComparison {

    public static void main(String[] args) {
        // Define test array sizes and number of runs for averaging
        int[] sizes = { 1000, 5000, 10000, 20000 };
        int numRuns = 5;

        // Print comparison heading
        System.out.println("Sorting Algorithm Comparison\n");

        // Loop through each test array size
        for (int size : sizes) {
            System.out.println("Array Size: " + size);
            System.out.printf("%-15s%-15s\n", "Algorithm", "Avg. Time (ms)"); // Format table headers

            // Initialize variables to store total execution times
            long bubbleTotal = 0;
            long selectionTotal = 0;
            long insertionTotal = 0;

            // Run the sorting comparison multiple times for averaging
            for (int i = 0; i < numRuns; i++) {
                // Generate a random array of the specified size
                int[] array = generateRandomArray(size);

                // Create copies of the array for each sorting algorithm
                int[] bubbleArray = array.clone();
                int[] selectionArray = array.clone();
                int[] insertionArray = array.clone();

                // Measure and accumulate execution times for each sort
                bubbleTotal += timeSort(() -> bubbleSort(bubbleArray));
                selectionTotal += timeSort(() -> selectionSort(selectionArray));
                insertionTotal += timeSort(() -> insertionSort(insertionArray));

                // Optional check for sorting correctness (useful for debugging)
                if (!isSorted(bubbleArray) || !isSorted(selectionArray) || !isSorted(insertionArray)) {
                    System.err.println("Sorting failed for size " + size);
                    return; // Stop if sorting failed
                }
            }

            // Calculate and print average execution times with formatting
            System.out.printf("%-15s%-15.2f\n", "Bubble Sort", (double) bubbleTotal / numRuns);
            System.out.printf("%-15s%-15.2f\n", "Selection Sort", (double) selectionTotal / numRuns);
            System.out.printf("%-15s%-15.2f\n", "Insertion Sort", (double) insertionTotal / numRuns);
            System.out.println(); // Print newline for better readability
        }
    }

    // Method to measure and return execution time
    public static long timeSort(Runnable sortFunction) {
        long startTime = System.nanoTime(); // Record the start time
        sortFunction.run(); // Execute the sorting algorithm
        long endTime = System.nanoTime(); // Record the end time
        return (endTime - startTime) / 1_000_000; // Convert to milliseconds
    }

    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size * 10); // Generate numbers within a reasonable range
        }
        return array;
    }

    public static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
}
