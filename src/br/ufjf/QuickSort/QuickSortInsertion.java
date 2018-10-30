package com.company.QuickSort;

import java.util.Arrays;

public class QuickSortInsertion <T extends Comparable<T>>{

    private int numberComparisionsKey;
    private int numberCopies;
    private long estimatedTime;

    private void swap(T[] vet, int dex1, int dex2)
    {
        T temp;
        temp = vet[dex1];
        vet[dex1] = vet[dex2];
        vet[dex2] = temp;
        numberCopies += 3;
    }

    public void quickSort(int[] list)
    {
        quickSort(list, 0, list.length - 1);
    }

    private void quickSort(int[] list, int first, int last)
    {
        int size = (last +1) - first;

        if (first < last)
        {
            if (last < 11)
            { // insertion sort if 10 or smaller
                insertionSort(list, first, size);
            }
            else // quicksort if large
            {
                int pivotIndex = partitionIt(list, first, last);
                quickSort(list, first, pivotIndex - 1);
                quickSort(list, pivotIndex + 1, last);
            }
        }
    }

    public static void insertionSort(int[] list, int first, int size)
    {
        for (int i = first+1; i < size; i++)
        {
            int currentElement = list[i];
            int k;
            for (k = i - 1; k >= 0 && list[k] > currentElement; k--)
            {
                list[k + 1] = list[k];
            }

            // Insert the current element into list[k+1]
            list[k + 1] = currentElement;
        }
    }

    private int partitionIt(T vet[], int left, int right, T pivot) {
        int leftPtr = left - 1;
        numberCopies++;
        int rightPtr = right;
        numberCopies++;

        while (true) {
            while (pivot.compareTo(vet[++leftPtr]) > 0){
                numberComparisionsKey++;
            }
            while (rightPtr > 0 && (vet[--rightPtr].compareTo(pivot) > 0)){
                numberComparisionsKey++;
            }

            if (leftPtr >= rightPtr) {
                numberComparisionsKey++;
                break;
            }
            else
                swap(vet,leftPtr, rightPtr);
        }
        swap(vet,leftPtr,right);

        return leftPtr;
    }


    public int getNumberComparisionsKey() {
        return numberComparisionsKey;
    }

    public int getNumberCopies() {
        return numberCopies;
    }

    public long getEstimatedTime() {
        return estimatedTime;
    }
}