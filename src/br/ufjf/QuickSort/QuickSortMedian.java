package com.company.QuickSort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSortMedian <T extends Comparable<T>> {
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

    private T median(T[] vet,int left, int right,int k){
        ArrayList<T> array = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(left, right + 1);
            array.add(vet[randomNum]);
        }
        //T array1[];

        return null;//array.toArray(array1);
    }

    private void recQuickSort(T[] vet, int left, int right, int k){

        if(right - left <= 0) {
            numberComparisionsKey++;
            return;
        }
        else {
            //pivot chosen here...

            T pivot = median(vet, left, right, k);
            numberCopies++;

            int partition = partitionIt(vet,left, right, pivot);
            recQuickSort(vet,left, partition - 1, k);
            recQuickSort(vet,partition + 1, right, k);
        }
    }
    public void quickSort(T[] vet, int size, int k){
        numberComparisionsKey = 0;
        numberCopies = 0;
        long startTime = System.nanoTime();
        recQuickSort(vet, 0, size - 1, k);
        estimatedTime = System.nanoTime() - startTime;
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
