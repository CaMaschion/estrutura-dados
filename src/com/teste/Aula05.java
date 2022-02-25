package com.teste;

import com.aulas.vetor.Vetor;

public class Aula05 {

    public static void main(String[] args) throws IllegalAccessException {
        Vetor vetor = new Vetor(10);

        vetor.adiciona("elemento 1");
        vetor.adiciona("elemento 2");
        vetor.adiciona("elemento 3");

        System.out.println(vetor.busca(15));
        System.out.println(vetor.busca(0));
    }
}
