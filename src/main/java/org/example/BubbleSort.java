package org.example;

public class BubbleSort implements BubbleSortInterface{

    public static int[] sort(int[] array)
    {
        int stepCounter = 0; // to count of steps
        int swapCounter = 0;
        int loopCounter = 0;

        int temp = 0; // temp element for swaping

        for (int i = 0; i < array.length; i++)
        {
            loopCounter++;
            for (int j = 0; j < array.length-1; j++)
            {
                if (array[j] > array[j+1])
                {
                    temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                    swapCounter++;
                }
            }
            stepCounter++;
        }

        System.out.println("BUBBLE SORT: Non optimizing. stepCounter: "+ stepCounter +", swapCounter: "+ swapCounter+ ", loopCounter: "+loopCounter);
        return array;
    }

    public static int[] sortOptimising(int[] array)
    {
        int stepCounter = 0;
        int swapCounter = 0;
        int loopCounter = 0;
        int temp = 0; // temp element for swapping

        for (int i = 0; i < array.length; i++)
        {
            boolean isSwapped = false;

            // -i : po 1 przejściu największy elem. będzie na końcu
            for (int j = 0; j < array.length-1-i; j++)
            {
                loopCounter++;
                if (array[j] > array[j+1])
                {
                    temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                    swapCounter++;
                    isSwapped = true;
                }
            }
            // jeśli nie ma zamianay kończymy...
            if (!isSwapped) {
                break;
            }
            stepCounter++;
        }

        System.out.println("BUBBLE SORT OPT: stepCounter: "+ stepCounter +", swapCounter: "+ swapCounter+", loopCounter: "+ loopCounter);
        return array;
    }
}
