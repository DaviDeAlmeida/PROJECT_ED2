package br.ufjf;

import br.ufjf.Model.Deputado;
import br.ufjf.Model.Recibo;
import br.ufjf.Services.Arquivo;
import br.ufjf.Services.Leitura;

import java.io.IOException;
import java.util.ArrayList;

public class Main
{
    public static int COLUNAS = 10;

    public static void main(String[] args) throws IOException
    {
        Leitura leitura = new Leitura(new Arquivo());
        ArrayList<Deputado> deputados = leitura.getDeputityInfos();

        for(Deputado deputado : deputados){
            System.out.println("Nome: " + deputado.getDeputyName());
            for(Recibo recibo : deputado.getReceipt())
            {
                System.out.println(recibo.getEstablishmentName());
                System.out.println(recibo.getReceiptValue());
                System.out.println(recibo.getReceiptDescription());
            }
            System.out.println();
        }
    }
}
