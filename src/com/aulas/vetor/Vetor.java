package com.aulas.vetor;

//Um vetor armaneza uma sequencia de valores onde todos sao do mesmo tipo

import java.lang.reflect.Array;
import java.util.Arrays;

public class Vetor {

    private String[] elementos;
    private int tamanho;

    public Vetor(int capacidade) {
        this.elementos = new String[capacidade];
        this.tamanho = 0;
    }

    ////////// adicionando um elemento no vetor ////////////

    /** public void adiciona(String elemento) {
     // modo mais simples é verificar os elementos que estao nulos. Por padrao todos comecam null, false ou 0, depende do tipo.
     // iterar o vetor, passa por todos os elementos e verficar se a posicao é nula, se for nula significa que está disponivel e add o elemento nela
     for (int i=0; i < this.elementos.length; i++) {
     if (this.elementos[i] == null){
     this.elementos[i] = elemento;
     break;
     }
     }
     }**/

    // o algortirimo anterior nao é eficiente, precisamos passar posicao por posicao até encontrar a que queremos, entao
    // abaixo tem exemplo de um algoritmo melhorado de adicao com um atributo novo para controlar o tamanho real do vetor, pq no dia a dia vamos ter que lidar com centenas informacoes

    /**
     * public void adiciona(String elemento) throws Exception {
     * // verificar se o tamanho é menor que a capacidade do vetor de elementos
     * if (this.tamanho < this.elementos.length) {
     * this.elementos[this.tamanho] = elemento; // add elemento no nosso vetor
     * this.tamanho++;
     * } else {
     * throw new Exception("Vetor já está cheio, não é possível adicionar mais elementos");
     * }
     * }
     **/

    // terceira forma sem exception
    public boolean adiciona(String elemento) {
        this.aumentaCapacidade();
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento; // add elemento no nosso vetor
            this.tamanho++;
            return true;
        }
        return false;
    }

    ///////// Adicionar elemento em qualquer posiçao do vetor ////////////

    // no desenho temos
    // 0 1 2 3 4 5 6 = tamanho é 5 e está recebendo a posicao 4
    // B C E F G     posicoes
    public boolean adiciona(int posicao, String elemento) throws IllegalAccessException {
        //primeiro preciso verificar se a posicao onde quero adicionar o elemento é válida
        if (!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalAccessException("Posicao inválida");
        }

        this.aumentaCapacidade();

        //agora a lógica que preciso para mover todos os elementos
        for (int i = tamanho - 1; i >= posicao; i--) {
            //this.elementos precisa ser maior que o i.
            this.elementos[i + 1] = this.elementos[i];
        }
        this.elementos[posicao] = elemento;
        this.tamanho++; //

        return true;
    }

    ///////// Adicionar capacidade vetor ////////////

    private void aumentaCapacidade() {
        // aumentamos o tamanho do vetor sempre que o tamanho for igual a capacidade que o vetor tem elementos.length
        if (this.tamanho == this.elementos.length) {
            String[] elementosNovos = new String[this.elementos.length * 2]; // melhor forma de dobrar a capacidade do vetor
            for (int i = 0; i < this.elementos.length; i++) {
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }


    /////// Verificar tamanho do vetor e imprimir elementos ////////////
    public int tamanho() {
        return this.tamanho;
    }

    public String toString() {

        //iterar todos os elementos do nosso vetor e add na String
        //concatenacao de string

        // forma mais simples porem nao eficiente de concatenar a string:
        /** String s = "[";

         for (int i= 0; i < this.tamanho -1; i++){
         s += this.elementos[i];
         s+= ", ";
         }

         if (this.tamanho > 0) {
         s += this.elementos[this.tamanho-1];
         }

         s += "]";

         return Arrays.toString(elementos);
         }**/

        //uma forma mais eficiente é usando a classe string builder

        StringBuilder s = new StringBuilder();
        s.append("[");

        for (int i = 0; i < this.tamanho - 1; i++) {
            s.append(this.elementos[i]);
            s.append(", ");
        }

        if (this.tamanho > 0) {
            s.append(this.elementos[this.tamanho - 1]);
        }

        s.append("]");

        return s.toString();
    }

    //////////// Obter elementos de uma posicao ////////////

    public String busca(int posicao) throws IllegalAccessException {
        if (!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalAccessException("Posicao inválida");
        }
        return this.elementos[posicao];

    }

    ///////// Verificar se o elemento existe no vetor  == Busca sequencial ////////////

    /**
     * public boolean existe(String elemento) {
     * //o algoritmo mais simple é o de busca sequencial, verificar cada elemento pra encontrar qual eu quero
     * for (int i = 0; i < this.tamanho; i++) {
     * if (this.elementos[i].equals(elemento)) {
     * return true;
     * }
     * ;
     * }
     * return false;
     * }
     **/

    // forma de busca retornando a posicao
    public int busca(String elemento) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elementos[i].equals(elemento)) {
                return i;
            }
            ;
        }
        return -1; // -1 nao existe no meu vetor;
    }

    ///////// Remover elementos ////////////


    //B G D E F -> posicao a ser removida é 1 -> letra G
    //0 1 2 3 4 -> tamanho é igual 5
    // vetor que estava na posicao 1 recebeu vetor que estava na posicao 2 -> vetor [1] = vetor [2]
    //B D D E F
    // depois o vetor [1] = vetor [2]
    //B D E E F
    // vetor [3] = vetor [4]
    // B D E F F
    // o 1 é a posicao a ser removida - coloco no FOR
    // o i vai ter que ser menor que o tamanho (5) menos a última posicao (4)
    public void remove(int posicao) throws IllegalAccessException {
        if (!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalAccessException("Posicao inválida");
        }
        for (int i = posicao; i<this.tamanho-1; i++ ){
            this.elementos[i] = this.elementos[i+1];
            // o vetor da posicao um vai receber o vetor da posicao dois
        }
        //diminuir o tamanho do vetor, já que o tamanho vai passar de 5 até 4
        this.tamanho--;
    }
}
