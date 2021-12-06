package models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class Venda {
    Random gerador = new Random();
    private long id;
    private Cliente cliente;
    private List<Produto> produtos;
    private double total_pagar;

    public Venda() {
        this.id = gerador.nextInt(1000) + (Calendar.getInstance().getTimeInMillis());
        cliente = new Cliente();
        produtos = new ArrayList();
    }

    public Venda(Cliente cliente) {
        this.id = gerador.nextInt(1000) + (Calendar.getInstance().getTimeInMillis());
        this.cliente = cliente;
        produtos = new ArrayList();
    }

    public Venda(long id, Cliente cliente, List<Produto> produtos, double total_pagar) {
        this.id = id;
        this.cliente = cliente;
        this.produtos = produtos;
        this.total_pagar = total_pagar;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public double getTotal_pagar() {
        return total_pagar;
    }

    public void setTotal_pagar(double total_pagar) {
        this.total_pagar = total_pagar;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) this.id;
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
        final Venda other = (Venda) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id=" + id + ", cliente=" + cliente + ", produtos=" + produtos + ", total_pagar=" + total_pagar;
    }
    
}
