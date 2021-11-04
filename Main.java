import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        LojaDados ld = new LojaDados();
        
        List<Produto> produtos = null;
        
        try {
            produtos = ld.recuperaProdutosDeArquivo();
        } catch (Exception e) {
            produtos = new ArrayList();
        } 
        
        LojaVirtual lv = new LojaVirtual();
        
        lv.setProdutos(produtos);
        
        String menu = "Escolha uma opção abaixo:\n" + "1 - Cadastrar novo produto\n" 
                + "2 - Pesquisar produto por nome\n" + "3 - Pesquisar produto por id\n" + "4 - Excluir produto\n" + "5 - Editar produto\n" + "6 - Listar\n" + "7 - Sair"; 
        
        int opcao = 0;
        
        do {
        
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "Menu", JOptionPane.QUESTION_MESSAGE));

            switch(opcao) {
                case 1:
                    String nome = JOptionPane.showInputDialog(null, "Informe o nome do produto:", "Nome", JOptionPane.QUESTION_MESSAGE);
                    double preco = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o preço do produto:", "Preço", JOptionPane.QUESTION_MESSAGE));
                    int estoque = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o estoque do produto:", "Quantidade estoque", JOptionPane.QUESTION_MESSAGE));
                    String descricao = JOptionPane.showInputDialog(null, "Informe a descrição do produto:", "Descrição", JOptionPane.QUESTION_MESSAGE);
                    Produto p = new Produto(nome, preco, estoque, descricao);
                    System.out.println(p.getId());
                {
                    try {
                        lv.cadastrar(p);
                        JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "Ok", JOptionPane.INFORMATION_MESSAGE);
                    } catch (ProdutoExistente ex) {
                        JOptionPane.showMessageDialog(null, "Produto já cadastrado", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
                    break;

                case 2:
                    String nomePesquisa = JOptionPane.showInputDialog(null, "Informe o nome do produto:", "Nome", JOptionPane.QUESTION_MESSAGE);
                    Produto prod1 = lv.pesquisar(nomePesquisa);
                    if (prod1 != null) {
                        JOptionPane.showMessageDialog(null, prod1, "Informações", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Produto não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
                    }                    
                    break;
                case 3:
                    int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o código do produto:", "Código", JOptionPane.QUESTION_MESSAGE));
                    Produto prod2 = lv.pesquisar(codigo);
                    if (prod2 != null) {
                        JOptionPane.showMessageDialog(null, prod2, "Informações", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Produto não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
                    }   
                    break;
                case 4:
                    String nomeRemover = JOptionPane.showInputDialog(null, "Informe o nome do produto:", "Nome", JOptionPane.QUESTION_MESSAGE);
                {
                    try {
                        lv.remover(nomeRemover);
                        JOptionPane.showMessageDialog(null, "Produto removido com sucesso!", "Ok", JOptionPane.INFORMATION_MESSAGE);
                    } catch (ProdutoInexistente ex) {
                        JOptionPane.showMessageDialog(null, "Produto não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
                    break;

                case 5:
                    String nomeEditar = JOptionPane.showInputDialog(null, "Informe o nome do produto a ser editado:", "Nome", JOptionPane.QUESTION_MESSAGE);
                    String nomeNovo = JOptionPane.showInputDialog(null, "Informe o novo nome do produto:", "Nome", JOptionPane.QUESTION_MESSAGE);
                {
                    try {
                        lv.editar(nomeEditar, nomeNovo);
                        JOptionPane.showMessageDialog(null, "Produto editado com sucesso!", "Ok", JOptionPane.INFORMATION_MESSAGE);
                    } catch (ProdutoInexistente ex) {
                        JOptionPane.showMessageDialog(null, "Produto não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
                    break;

                case 6:
                    String lista = lv.listarProdutos();
                    JOptionPane.showConfirmDialog(null, "Lista de produtos:\n" + lista, "Lista de produtos", JOptionPane.OK_CANCEL_OPTION);
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "Encerrando o sistema", "Saindo", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida", "Erro", JOptionPane.ERROR_MESSAGE);
            }

            try {          
                ld.gravaProdutosEmArquivo(produtos);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        
        } while(opcao != 7);
    }
    
}
