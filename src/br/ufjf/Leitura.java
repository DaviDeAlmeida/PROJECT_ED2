package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Leitura <T>
{
    private Arquivo file;
    private String separator = ";";
    private BufferedReader buffer;

    public Leitura(Arquivo a) throws IOException {
        this.file = a;
        this.buffer = file.Obter();
    }

    public ArrayList<T> getDeputityInfos() throws IOException {

        Boolean header = true;
        String line;

        Registro r = new Registro();

        try
        {
            while((line = buffer.readLine()) != null)
            {
                if (header || line.trim().isEmpty())
                {
                    header = false;
                    continue;
                }

                String[] columns = line.split(separator, 10);

                if(!this.columnsLengthIsInvalid(columns.length, 10))
                {
                    int id = Integer.parseInt(columns[2]);
                    new Registro(columns, id);
                }
            }
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        finally
        {
            file.Fecha();
        }

        return (ArrayList<T>) r.getDeputities();
    }

    public Integer[] getReceiptValues() throws IOException {
        Boolean header = true;
        String line;

        ArrayList<Integer> values = new ArrayList<Integer>();

        try
        {
            while((line = buffer.readLine()) != null)
            {
                if (header || line.trim().isEmpty())
                {
                    header = false;
                    continue;
                }

                String[] columns = line.split(separator, 10);

                if(!this.columnsLengthIsInvalid(columns.length, 10))
                {
                    values.add(Integer.parseInt(columns[9]));
                }
            }
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        finally
        {
            file.Fecha();
        }

        return values.toArray(new Integer[values.size()]);
    }

    private boolean columnsLengthIsInvalid(int quantityColumns, int originalQuantityColumnsInALine)
    {
        if (quantityColumns > originalQuantityColumnsInALine)
            return true;

        else if(quantityColumns < originalQuantityColumnsInALine)
            return true;

        return false;
    }
}
