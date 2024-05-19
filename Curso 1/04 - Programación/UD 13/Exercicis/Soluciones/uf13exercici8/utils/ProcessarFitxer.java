/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uf13exercici8.utils;

import java.io.*;
import java.util.ArrayList;
import uf13exercici8.model.Producte;
import uf13exercici8.utils.DadesIncompletesExcepcio;

/**
 *
 * @author ggarrido
 */
public class ProcessadorDeFitxers {
    private BufferedReader br;
    private int numCamps;

    /**
     * Constructor de la classe ProcessadorDeFitxers
     * @param path Path del fitxer a processar
     * @param numCamps Nombre de camps que ha de tenir cada línia del fitxer
     * @throws FileNotFoundException Si el fitxer no existeix
     */
    public ProcessadorDeFitxers(String path, numCamps) throws FileNotFoundException {
        this.br = new BufferedReader(new FileReader(path));
        this.numCamps = numCamps;
    }

    /**
     * Llegeix una línia del fitxer
     * @return La línia llegida
     */
    public String llegirLinia() throws IOException {
        return this.br.readLine();
    }

    /**
     * Tanca el fitxer
     */
    public void tancar() throws IOException {
        this.br.close();
    }

    /**
     * Processa una línia del fitxer i retorna els camps en un array
     * @param linia Línia a processar
     * @return Array amb els camps de la línia
     * @throws DadesIncompletesExcepcio Si la línia no té el nombre de camps esperat
     */
    public String[] processarLinia(String linia) throws DadesIncompletesExcepcio {
        String[] camps = linia.split(",");
        if (camps.length != this.numCamps) {
            throw new DadesIncompletesExcepcio();
        }
        return camps;
    }
}
