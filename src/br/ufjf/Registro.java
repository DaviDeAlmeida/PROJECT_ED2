package com.company;

import java.util.ArrayList;

public class Registro
{
    private static ArrayList<Deputado> deputities = new ArrayList<Deputado>();
    private static int lastId;
    private static int lastIndex = 0;

    Registro() { }

    Registro(String[] columns, int id)
    {
        registerDeputities(columns, id);
    }

    private void registerDeputities(String[] columns, int id)
    {
        if(!this.verifyDeputity(id))
        {
            Deputado deputity = new Deputado(columns[5], columns[3], columns[4], Integer.parseInt(columns[2]), Integer.parseInt(columns[0]), this.getRecepit(columns));

            deputities.add(deputity);
            this.lastIndex++;
        }
        else
            deputities.get(this.lastIndex - 1).setReceipt(this.getRecepit(columns));
    }

    private Recibo getRecepit(String[] columns)
    {
        return new Recibo(columns[1], columns[6], columns[8], columns[7], Integer.parseInt(columns[9]));
    }

    private boolean verifyDeputity(int id)
    {
            if(this.lastId == id)
                return true;
            else
                this.lastId = id;
            return false;
    }

    public ArrayList<Deputado> getDeputities()
    {
        return deputities;
    }
}
