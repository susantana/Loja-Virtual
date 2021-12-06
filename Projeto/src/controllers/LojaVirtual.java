package controllers;

import exceptions.ClienteExistente;
import exceptions.ProdutoInexistente;
import exceptions.ProdutoExistente;
import exceptions.ClienteInexistente;
import models.Venda;
import models.Cliente;
import models.Produto;
import models.Sistema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class LojaVirtual implements Sistema {

    private LojaDados dados;
    private List<Cliente> clientes;
    private List<Produto> produtos; 
    private List<Venda> vendas; 

    public LojaVirtual() {
        dados = new LojaDados();
        try {
            produtos = dados.recuperaProdutosDeArquivo();
            clientes = dados.recuperaClientesDeArquivo();
            vendas = dados.recuperaVendasDeArquivo();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao ler a lista!", JOptionPane.ERROR_MESSAGE);
            clientes = new ArrayList();
            vendas = new ArrayList();
            produtos = new ArrayList();
        }       
    }

    public void salvar() {
        try {
            dados.gravaClientesEmArquivo(clientes);
            dados.gravaProdutosEmArquivo(produtos);
            dados.gravaVendasEmArquivo(vendas);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao gravar as listas!", JOptionPane.ERROR_MESSAGE);
        }
    }
        
    @Override
    public void cadastrar(Produto p) throws ProdutoExistente {
        //vberifica se o produto não é nullo e se ele já não existe no sistema
        if (p != null && this.pesquisarProduto(p.getId()) == null) {
            //insere o produto na lista
            this.produtos.add(p);
        } else {
            throw new ProdutoExistente("O produto já está cadastrado na loja.");
        } 
    }

    @Override
    public Produto pesquisarProduto(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome)) {
                return produto;
            }
        }
        return null;
    }

    @Override
    public Produto pesquisarProduto(long codigo) {
        for (Produto produto : produtos) {
            if (produto.getId() == codigo) {
                return produto;
            }
        }
        return null;
    }
    
    @Override
    public void editarProduto(String nomeAnterior, String novoNome) throws ProdutoInexistente {
        Produto p = this.pesquisarProduto(nomeAnterior);
        if (p != null) {
            p.setNome(novoNome);
        } else {
             throw new ProdutoInexistente("O produto a ser editado não existe.");
        }
              
    }

    @Override
    public void removerProduto(String nome) throws ProdutoInexistente {
        Produto prod = this.pesquisarProduto(nome);
        if (prod != null) {
            this.produtos.remove(prod);
        } else {
            throw new ProdutoInexistente("O produto a ser removido não existe.");
        }
    }
    
    @Override
    public void cadastrar(Cliente c) throws ClienteExistente {
        if (c != null && c.getNome().trim() != null) {
            this.clientes.add(c);
        } else {
            throw new ClienteExistente("O cliente já está cadastrado na loja.");
        } 
    }
    
    @Override
    public void cadastrar(Venda v) {
        if (v != null) {
            this.vendas.add(v);
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar a venda!", "Erro", JOptionPane.ERROR_MESSAGE);
        } 
    }

    @Override
    public Cliente pesquisarCliente(String nome) {
        for (Cliente c : clientes) {
            if (c.getNome().equals(nome)) {
                return c;
            }
        }
        return null;
    }
    
    @Override
    public Cliente pesquisarCliente(long id) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void removerCliente(String nome) throws ClienteInexistente {
        Cliente c = this.pesquisarCliente(nome);
        if (c != null) {
            this.clientes.remove(c);
        } else {
            throw new ClienteInexistente("O cliente a ser removido não existe.");
        }
    }

    @Override
    public void editarCliente(String nomeAnterior, String novoNome) throws ClienteInexistente {
        Cliente c = this.pesquisarCliente(nomeAnterior);
        if (c != null) {
            c.setNome(novoNome);
        } else {
             throw new ClienteInexistente("O cliente a ser editado não existe.");
        }
    }
    
    public Venda pesquisarVenda(long id) {
        for (Venda v : vendas) {
            if (v.getId() == id) {
                return v;
            }
        }
        return null;
    }
    
    public void removerVenda(long id) throws ClienteInexistente {
        Venda v = this.pesquisarVenda(id);
        if (v != null) {
            this.vendas.remove(v);
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível remover a venda!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public String listarProdutos() {
        String ps = "";
        for (Object produto : produtos) {
            ps += produto + "\n";
        }
        return ps;
    }
    
    public String[] lerProdutos() {
        String[] listaProdutos;
        
        listaProdutos = new String[produtos.size()];
        
        for (int i = 0; i < produtos.size(); i++) {
            listaProdutos[i] = produtos.get(i).toString();            
        }
        
        return listaProdutos;
    }
    
    public String[] lerClientes() {
        String[] listaClientes;
        
        listaClientes = new String[clientes.size()];
        
        for (int i = 0; i < clientes.size(); i++) {
            listaClientes[i] = clientes.get(i).toString();            
        }
        
        return listaClientes;
    }
    
    public String[] lerVendas() {
        String[] listaVendas;
        
        listaVendas = new String[vendas.size()];
        
        for (int i = 0; i < vendas.size(); i++) {
            listaVendas[i] = vendas.get(i).toString();            
        }
        
        return listaVendas;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }    

    public LojaDados getDados() {
        return dados;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }   
    
}
