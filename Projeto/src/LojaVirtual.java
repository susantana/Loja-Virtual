package projeto;

import java.util.ArrayList;
import java.util.List;

public class LojaVirtual implements Sistema {

    private List<Produto> produtos;

    public LojaVirtual() {
        produtos = new ArrayList();
    }    
        
    @Override
    public void cadastrar(Produto p) throws ProdutoExistente {
        if (p != null && this.pesquisar(p.getId()) == null) {
            this.produtos.add(p);
        } else {
            throw new ProdutoExistente("O produto j� est� cadastrado na loja.");
        } 
    }

    @Override
    public Produto pesquisar(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome)) {
                return produto;
            }
        }
        return null;
    }

    @Override
    public Produto pesquisar(int codigo) {
        for (Produto produto : produtos) {
            if (produto.getId() == codigo) {
                return produto;
            }
        }
        return null;
    }
    
    @Override
    public void editar(String nomeAnterior, String novoNome) throws ProdutoInexistente {
        Produto p = this.pesquisar(nomeAnterior);
        if (p != null) {
            p.setNome(novoNome);
        } else {
             throw new ProdutoInexistente("O produto a ser editado n�o existe.");
        }
              
    }

    @Override
    public void remover(String nome) throws ProdutoInexistente {
        Produto prod = this.pesquisar(nome);
        if (prod != null) {
            this.produtos.remove(prod);
        } else {
            throw new ProdutoInexistente("O produto a ser removido n�o existe.");
        }
    }
    
    public String listarProdutos() {
        String ps = "";
        for (Object produto : produtos) {
            ps += produto + "\n";
        }
        return ps;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }    
    
}
