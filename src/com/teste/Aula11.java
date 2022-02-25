package com.teste;

import com.aulas.vetor.Lista;
import com.aulas.vetor.VetorObjetos;

public class Aula11 {

    public static void main(String[] args) {
      //  VetorObjetos vetor = new VetorObjetos(2);

        /*vetor.adiciona(1);
        vetor.adiciona("Elemento do tipo String");

        System.out.println(vetor);*/

        Lista<String> vetor = new Lista(1);

        vetor.adiciona("elemento");
    }
}
