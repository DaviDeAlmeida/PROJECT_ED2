package com.company;

public class Sort {

    private int numberComparisionsKey;
    private int numberCopies;
    private long estimatedTime;

    public <T extends Comparable<T>> void InsertionSort(T vet[]){

        numberComparisionsKey = 0;
        numberCopies = 0;
        long startTime = System.nanoTime();

        for (int i = 1; i < vet.length; i++){
            T pivot = vet[i];
            int j = i - 1;

            numberCopies += 2;
            numberComparisionsKey++;

            while(j >= 0 && vet[j].compareTo(pivot) > 0){
                numberComparisionsKey++;
                vet[j + 1] = vet[j];
                j--;
                numberCopies++;
            }
            vet[j + 1] = pivot;
            numberCopies++;
        }
        estimatedTime = System.nanoTime() - startTime;
    }

    public void MergeSort(int vet[]){
        AuxMergeSort(vet,0,vet.length - 1);
    }


    private void AuxMergeSort(int vet[], int start, int end){
        int middle;

        if(start < end){
            middle = (start + end)/2;
            AuxMergeSort(vet,start,middle);
            AuxMergeSort(vet,middle + 1,end);
            intercala(vet,start,middle,end);
        }
    }

    private void intercala(int vet[], int index_start, int index_middle, int index_end){
        int indice_inicio;
        int indice_meio;
        int indice_aux;
        int[] vetor_aux;
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
