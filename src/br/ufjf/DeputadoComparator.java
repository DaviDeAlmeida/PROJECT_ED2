package com.company;
import java.util.Comparator;

public class DeputadoComparator implements Comparator<Deputado> {

    public int compare(Deputado x, Deputado y){
        return x.getDeputyId() - y.getDeputyId();
    }
}
