package projeto;

public interface Sistema {
    
    public void cadastrar(Produto p) throws ProdutoExistente;
    
    public Produto pesquisar(String nome);
    
    public Produto pesquisar(int codigo);
    
    public void remover(String nome) throws ProdutoInexistente;
    
    public void editar(String nomeAnterior, String novoNome) throws ProdutoInexistente;
    
}
