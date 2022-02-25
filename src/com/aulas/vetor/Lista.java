package com.aulas.vetor;

//usando o generics vamos passar o tipo da classe que queremos na declaracao da Classe

import java.lang.reflect.Array;

public class Lista <T>{

    private T[] elementos;
    private int tamanho;

   /** public Lista(int capacidade) {
        this.elementos = new Object[capacidade];
        this.tamanho = 0;
    }

    //segunda opcao de vetor generico através do reflection
    public Lista(int capacidade, Class<T> tipoClasse) {
        this.elementos = (T[]) Array.newInstance(tipoClasse, capacidade);
        this.tamanho = 0;
    } **/

    // terceira forma - forma mais elegante, solucao do livro Effeticve Java:
    public Lista(int capacidade)  {
        this.elementos = (T[]) new Object[capacidade];
        this.tamanho = 0;
    }


    public boolean adiciona(T elemento) {
        this.aumentaCapacidade();
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento; // add elemento no nosso vetor
            this.tamanho++;
            return true;
        }
        return false;
    }

    public boolean adiciona(int posicao, T elemento) throws IllegalAccessException {
        if (!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalAccessException("Posicao inválida");
        }

        this.aumentaCapacidade();

        for (int i = tamanho - 1; i >= posicao; i--) {
            this.elementos[i + 1] = this.elementos[i];
        }
        this.elementos[posicao] = elemento;
        this.tamanho++; //

        return true;
    }

    private void aumentaCapacidade() {
        if (this.tamanho == this.elementos.length) {
            T[] elementosNovos = (T[]) new Object[this.elementos.length * 2]; // melhor forma de dobrar a capacidade do vetor
            for (int i = 0; i < this.elementos.length; i++) {
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }

    public int tamanho() {
        return this.tamanho;
    }

    public String toString() {

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

    public Object busca(int posicao) throws IllegalAccessException {
        if (!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalAccessException("Posicao inválida");
        }
        return this.elementos[posicao];

    }

    public int busca(Object elemento) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elementos[i].equals(elemento)) {
                return i;
            }
            ;
        }
        return -1; // -1 nao existe no meu vetor;
    }

    public void remove(int posicao) throws IllegalAccessException {
        if (!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalAccessException("Posicao inválida");
        }
        for (int i = posicao; i<this.tamanho-1; i++ ){
            this.elementos[i] = this.elementos[i+1];
        }
        this.tamanho--;
    }

}
