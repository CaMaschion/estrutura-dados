package com.teste;

import java.util.Objects;

public class Contato {

    private String nome;
    private String telefone;
    private String email;

    public Contato(String nome, String telefone, String email) {
        super();
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setEmail(String email) {
        this.email = nome;
    }

    public String getEmail() {
        return email;
    }

    //método para sobrescrever o que estava no object
    @Override
    public String toString() {
        return "Contato{" +
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


    //esse método compara a referência de memória, compara atributo por atributo
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        Contato other = (Contato) object;
        if (email == null){
            if (other.email != null) {
                return false;
            }
        } else if (!email.equals(other.email)){
            return false;
        }
        if (nome == null){
            if (other.nome != null) {
                return false;
            }
        } else if (!nome.equals(other.nome)){
            return false;
        }
        if (telefone == null){
            if (other.telefone != null) {
                return false;
            }
        } else if (!telefone.equals(other.telefone)){
            return false;
        }

        return true;
    }

}
