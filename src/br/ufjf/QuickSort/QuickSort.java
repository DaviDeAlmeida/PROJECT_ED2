package com.company.QuickSort;

public class QuickSort <T extends Comparable<T>>{

    private int numberComparisionsKey;
    private int numberCopies;
    private long estimatedTime;

    private void swap(T[] vet, int dex1, int dex2) {
        T temp;
        temp = vet[dex1];
        vet[dex1] = vet[dex2];
        vet[dex2] = temp;
        numberCopies += 3;
    }

    private void recQuickSort(T[] vet, int left, int right){

        if(right - left <= 0)
        {
            numberComparisionsKey++;
            return;
        }
        else
            {
            T pivot = vet[right];
            numberCopies++;

            int partition = partitionIt(vet,left, right, pivot);
            recQuickSort(vet,left, partition - 1);
            recQuickSort(vet,partition + 1, right);
        }
    }

    public void quickSort(T[] vet)
    {
        numberComparisionsKey = 0;
        numberCopies = 0;
        long startTime = System.nanoTime();
        recQuickSort(vet, 0, vet.length - 1);
        estimatedTime = System.nanoTime() - startTime;
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