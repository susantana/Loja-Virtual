package projeto;

import java.util.ArrayList;
import java.util.List;

public class Venda {
    private static int codigo = 0;
    private int id;
    private Cliente cliente;
    private List<Produto> produtos;
    private double total_pagar;

    public Venda() {
        this.id = codigo++;
        cliente = new Cliente();
        produtos = new ArrayList();
    }

    public Venda(Cliente cliente) {
        this.id = codigo++;
        this.cliente = cliente;
        produtos = new ArrayList();
    }

    public Venda(int id, Cliente cliente, List<Produto> produtos, double total_pagar) {
        this.id = id;
        this.cliente = cliente;
        this.produtos = produtos;
        this.total_pagar = total_pagar;
    }

    public static int getCodigo() {
        return codigo;
    }

    public static void setCodigo(int codigo) {
        Venda.codigo = codigo;
    }

    public int getId() {
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
        hash = 67 * hash + this.id;
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
    
    
}
