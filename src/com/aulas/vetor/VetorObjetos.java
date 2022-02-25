package com.aulas.vetor;
//criamos uma classe de vetor porem generalizada, para que ela funcione qualquer tipo: string, boolean, int, ou até mesmo uma classe, como uma classe Cliente, classe Conta, classe Contato..
//no Java a classe mae ou pai de todas as classes do java é a classe Object, entao a maneira mais simples é trocar a String pelo Object, no caso do do nosso exemplo.

public class VetorObjetos {

    private Object[] elementos;
    private int tamanho;

    public VetorObjetos(int capacidade) {
        this.elementos = new Object[capacidade];
        this.tamanho = 0;
    }

    public boolean adiciona(Object elemento) {
        this.aumentaCapacidade();
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento; // add elemento no nosso vetor
            this.tamanho++;
            return true;
        }
        return false;
    }

    public boolean adiciona(int posicao, Object elemento) throws IllegalAccessException {
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
            Object[] elementosNovos = new Object[this.elementos.length * 2]; // melhor forma de dobrar a capacidade do vetor
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

// o vetor/array tem que ser do mesmo tipo, entao fazer um Object nnao faz muito sentido já que sao varios tipos dentros do array