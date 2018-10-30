package br.ufjf.Hash;

public class THash
{
    int[] hashVector = new int[5];
    int[] valores = {8, 1, 1, 2, 5};
    int n = 5;

    public THash()
    {
        for(int i = 0; i < this.hashVector.length; i++)
            this.hashVector[i] = -1;
    }

    public void insert()
    {
        int k = 0;
        int colisoes = 0;
        for(int i = 0; i < n; i++)
        {
            k = hash(valores[i]);

            if(this.hashVector[k] == -1)
                this.hashVector[k] = valores[i];
            else
                this.hashVector[sondagemLinear(k)] = valores[i];
        }
    }

    private int hash(int value)
    {
        return value % this.n;
    }

    public int getValueInHashVector(int value)
    {
        return hash(value);
    }

    private int sondagemLinear(int k)
    {
        if(this.hashVector[k + 1] == -1)
            return k + 1;
        else
            return sondagemLinear(k + 1);

    }
}
