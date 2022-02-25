package com.teste;

import com.aulas.vetor.VetorObjetos;

public class Aula10 {

    public static void main(String[] args) {

        VetorObjetos vetor = new VetorObjetos(3);

        /*vetor.adiciona("3");
        vetor.adiciona("4");
        vetor.adiciona("5"); */

        Contato c1 = new Contato("Contato 1", "1234-5678", "contatoc1@gmail.com");
        Contato c2 = new Contato("Contato 2", "5678-9910", "contatoc2@gmail.com");
        Contato c3 = new Contato("Contato 3", "2234-5678", "contatoc3@gmail.com");
        Contato c4 = new Contato("Contato 4", "2884-5678", "contatoc4@gmail.com");

        vetor.adiciona(c1);
        vetor.adiciona(c2);
        vetor.adiciona(c3);

        System.out.println("Tamanho = " + vetor.tamanho());

        int pos = vetor.busca(c4);
        if (pos > -1) {
            System.out.println("elemento existe no vetor");
        } else {
            System.out.println("elemento nao existe no vetor");
        }

        System.out.println(vetor);
    }
}
