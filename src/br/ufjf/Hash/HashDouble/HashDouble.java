package com.company.Hash.HashDouble;

public class HashDouble
{
    HashDouble(int size):Hash(size, true){
    elementCounter = 0;
    //4 contador de elementos, 10% de size para o espaço extra

};
    int elementCounter;

    public void insert(int value)
    {
        if (elementCounter < size) {
            int key = keyFunction(value);
            if (hashTable[key] == 0)
                hashTable[key] = value;
            else {
                int i = 1;
                int secKeyConst = secondaryFunction(value);
                int secKey = secKeyConst;
                while (hashTable[(key + secKey) % size] != 0) {
                    secKey = i * secKeyConst;
                    ++i;
                }
                hashTable[(key + secKey) % size] = value;
                ++collisionCounter;
            }
            ++elementCounter;
        } else
            cout << "Hash cheio, nao foi possivel inserir " << value << endl;
    }

    public void find(int value)
    {
        ++comparsionCounter;
        ++numberOfComparsions;
        int key = keyFunction(value);
        if (hashTable[key] == value)
            return;
        else
        {
            int i = 1;
            int secKeyConst = secondaryFunction(value);
            int secKey = secKeyConst;
            ++numberOfComparsions;
            while (hashTable[(key + secKey) % size] != value) {
                secKey = i * secKeyConst;
                ++i;
                ++numberOfComparsions;
            }
        }
    }

    public int secondaryFunction(int value)
    {
        long key = 0;
        String str = to_string(value);
        char c;
        int i = 0;
        while (c = str.size()) {
            c = (char)str.at(i);
            key = c + (key << 6) + (key << 16) - key;
        }
        while (key%size == 0)
            ++key;
        return key;
    }

}
