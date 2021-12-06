package models;

import java.util.Calendar;
import java.util.Objects;
import java.util.Random;

public class Cliente {
    Random gerador = new Random();
    private long id;
    private String nome;
    private String cpf;
    private String endereco;
    private String bairro;

    public Cliente() {
        this.id = gerador.nextInt(1000) + (Calendar.getInstance().getTimeInMillis());
    }

    public Cliente(String nome, String cpf, String endereco, String bairro) {
        this.id = gerador.nextInt(1000) + (Calendar.getInstance().getTimeInMillis());
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.bairro = bairro;
    }   

    public Cliente(long id, String nome, String cpf, String endereco, String bairro) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.bairro = bairro;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (int) this.id;
        hash = 31 * hash + Objects.hashCode(this.cpf);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id + ", Nome: " + nome + ", CPF: " + cpf + ", Endereco: " + endereco + ", " + bairro;
    }

}
