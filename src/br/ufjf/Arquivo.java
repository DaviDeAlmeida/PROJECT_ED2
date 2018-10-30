package com.company;

import java.io.*;

/**
 *
 * @author rrodri
 */
public class Arquivo {
    private File file;
    private FileWriter fw;
    private BufferedWriter bw;
    private FileReader read;
    private BufferedReader buffer;
    private String path = "C:\\GIT\\deputies_dataset.csv";

    public void Criar(String nome) throws IOException {
        this.file = new File(nome);

        if (!this.file.exists())
            this.file.createNewFile();
    }

    public void Prepare() throws IOException {
        this.fw = new FileWriter(file.getAbsoluteFile());
        this.bw = new BufferedWriter(fw);
    }

    public void Escreve(String content) throws IOException {
        this.bw.write(content);
    }

    public void Fecha() throws IOException {
        this.buffer.close();
    }

    public BufferedReader Obter() throws IOException {
        this.read = new FileReader(path); // Obtém o conteúdo do arquivo
        this.buffer = new BufferedReader(read); // Carrega o conteúdo em memória

        return this.buffer;
    }
}
