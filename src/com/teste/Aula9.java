package com.teste;

import com.aulas.vetor.Vetor;

public class Aula9 {

    public static void main(String[] args) throws IllegalAccessException {

        Vetor vetor = new Vetor(3);
        vetor.adiciona("B");
        vetor.adiciona("G");
        vetor.adiciona("D");
        vetor.adiciona("E");
        vetor.adiciona("F");

        System.out.println(vetor);
        vetor.remove(1);

        System.out.println(vetor);

        //remover um elemento sem saber qual posicao esta

        System.out.println("Remover o elemento A");
        int pos = vetor.busca("A");
        if (pos > -1){
            vetor.remove(pos);
        } else {
            System.out.println("Elemento nao existe no vetor");
        }

        System.out.println(vetor);
    }
}
