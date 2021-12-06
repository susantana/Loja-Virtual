package models;

import exceptions.ClienteExistente;
import exceptions.ClienteInexistente;
import exceptions.ProdutoExistente;
import exceptions.ProdutoInexistente;

public interface Sistema {
    
    public void cadastrar(Produto p) throws ProdutoExistente;
    
    public void cadastrar(Cliente c) throws ClienteExistente;
    
    public void cadastrar(Venda v);
    
    public Produto pesquisarProduto(String nome);
    
    public Cliente pesquisarCliente(String nome);
    
    public Produto pesquisarProduto(long codigo);
    
    public Cliente pesquisarCliente(long id);
    
    public void removerProduto(String nome) throws ProdutoInexistente;
    
    public void removerCliente(String nome) throws ClienteInexistente;
    
    public void editarProduto(String nomeAnterior, String novoNome) throws ProdutoInexistente;
    
    public void editarCliente(String nomeAnterior, String novoNome) throws ClienteInexistente;
    
}
