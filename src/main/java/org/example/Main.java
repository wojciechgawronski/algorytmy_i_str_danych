package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        /**
         * PREPARE SET OF NUMBERS
         */
        int[] amountOfNumbersToCompare = { 100, 500, 10000, 50000, 100000, 500000, 1000000};
//        amountOfNumbersToCompare = new int[] { 100, 500, 10000, 50000};
//         int[] amountOfNumbersToCompare = { 2, 4};

        for (int i = 0; i <amountOfNumbersToCompare.length; i++) {
            int[] randomNumbers = new int[amountOfNumbersToCompare[i]];
            for (int j = 0; j < randomNumbers.length; j++){
                Random rand = new Random();
                randomNumbers[j] = rand.nextInt();
            }

            Runtime runtime = Runtime.getRuntime();
            runtime.gc();  // Run the garbage collector to get a more accurate measurement

            /**
             * MEASURE TIME AND MEMORY
             */
            // heapSort
            long startMemory = runtime.totalMemory() - runtime.freeMemory();
            long timeStart = System.currentTimeMillis();
            String METHOD_NAME = heapSort(randomNumbers); // sorting
            long timeEnd = System.currentTimeMillis();
            long timeMS = timeEnd-timeStart;
            long endMemory = runtime.totalMemory() - runtime.freeMemory();
            long memoryUsedB = endMemory - startMemory;
            saveToFile(METHOD_NAME, amountOfNumbersToCompare[i], memoryUsedB, timeMS);
            printStatsCLI(METHOD_NAME, randomNumbers.length, memoryUsedB, timeMS);

            // sortBySortedPriorityQueue
            timeStart = System.currentTimeMillis();
            startMemory = runtime.totalMemory() - runtime.freeMemory();
            METHOD_NAME = sortBySortedPriorityQueue(randomNumbers);
            timeEnd = System.currentTimeMillis();
            endMemory = runtime.totalMemory() - runtime.freeMemory();
            memoryUsedB = endMemory - startMemory;
            timeMS = timeEnd-timeStart;
            saveToFile(METHOD_NAME, amountOfNumbersToCompare[i], memoryUsedB, timeMS);
            printStatsCLI(METHOD_NAME, randomNumbers.length, memoryUsedB, timeMS);

            // sortByUnsortedPriorityQueue
            timeStart = System.currentTimeMillis();
            startMemory = runtime.totalMemory() - runtime.freeMemory();
            METHOD_NAME = sortByUnsortedPriorityQueue(randomNumbers);
            timeEnd = System.currentTimeMillis();
            endMemory = runtime.totalMemory() - runtime.freeMemory();
            memoryUsedB = endMemory - startMemory;
            timeMS = timeEnd-timeStart;
            saveToFile(METHOD_NAME, amountOfNumbersToCompare[i], memoryUsedB, timeMS);
            printStatsCLI(METHOD_NAME, randomNumbers.length, memoryUsedB, timeMS);
        }
    }

    public  static void  printStatsCLI(String METHOD_NAME, int numbersToCompare, long memoryUsedB, long timeMS)
    {
        System.out.println("Numbers of elements: " + numbersToCompare);
        double memoryUsedKB = Math.round(memoryUsedB/(1024));
        double memUsedMB = memoryUsedKB/1024.0;
        long memUsedMB_round = Math.round(memUsedMB);
        System.out.println("Memory used for "+METHOD_NAME+", "+ memoryUsedB+" [B], "+memoryUsedKB+" [kB]; rounded to: "+memUsedMB_round+" [MB]");
        System.out.println("Sorting time: " + timeMS + " [ms], "+ Math.round(timeMS/1000)+" [s].\n");
    }

    public static void saveToFile(String method, int numbersToCompare, long memoryUsedB, long timeMS)
    {
        String output = "Method: " + method +"\n";
        output += "Numbers to compare: " + numbersToCompare +".\n";
        double memoryUsedKB = Math.round(memoryUsedB/(1024));
        double memUsedMB = memoryUsedKB/1024.0;
        long memUsedMB_round = Math.round(memUsedMB);
        output += "Time taken for "+method+": " + timeMS + " [ms], "+ Math.round(timeMS/1000)+ " [s]. \n";
        output += "Memory used for "+method+": "+memoryUsedB+" [B], "+memoryUsedKB+" [KB], rounded to "+memUsedMB_round+" [MB]. \n";

        try (PrintStream out = new PrintStream(new FileOutputStream(new File("sorting_stats.txt"), true))) {
            out.println(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  static String heapSort(int[] randomNumbers){
        // System.out.println(Arrays.toString(randomNumbers));
        HeapPQ heapPQ = new HeapPQ();
        for (int i=0; i < randomNumbers.length; i++) {
            //  System.out.println(randomNumbers[i]);
            heapPQ.insert(randomNumbers[i], "some string value");
        }

          // see the queue, ASC
        while (!heapPQ.isEmpty()) {
            int sorted = (int) heapPQ.removeMin().getKey();
            // System.out.println(sorted);
            // System.out.println(heapPQ.min().getValue()+ ": "+ heapPQ.removeMin().getKey());
        }
        // System.out.println(heapPQ.size());

        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String methodName = stackTraceElements[1].getMethodName();
        return methodName;
    }
    public  static String sortBySortedPriorityQueue(int[] randomNumbers){
        // System.out.println("sortBySortedPriorityQueue");
        // sortowanie przez wstawianie (kolejka posortowana),
        SortedPQ sortedPQ = new SortedPQ();
        for (int i=0; i < randomNumbers.length; i++) {
            sortedPQ.insert(randomNumbers[i], "some sting value");
        }
        // see the data structure:
        while (!sortedPQ.isEmpty()) {
            // System.out.println("v: " +sortedPQ.min().getValue() +" " + sortedPQ.removeMin().getKey());
            int sorted = (int) sortedPQ.removeMin().getKey();
            // System.out.println(sorted);
        }
        // System.out.println(sortedPQ.size());

        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String methodName = stackTraceElements[1].getMethodName();
        return methodName;
    }

    public  static String sortByUnsortedPriorityQueue(int[] randomNumbers){
        UnsortedPQ unsortedPQ = new UnsortedPQ();
        for (int i=0; i < randomNumbers.length; i++) {
            unsortedPQ.insert(randomNumbers[i], "some string value");
        }

        while (!unsortedPQ.isEmpty()) {
            // System.out.println("KEY: " +unsortedPQ.min().getKey() +"; VALUE: " + unsortedPQ.removeMin().getValue());
            int sorted = (int) unsortedPQ.removeMin().getKey();
            // System.out.println(sorted);
        }
        // System.out.println(unsortedPQ.size());

        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String methodName = stackTraceElements[1].getMethodName();
        return methodName;
    }
}