import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LojaDados {
    public static final String ARQUIVO_USUARIOS = "produtos.txt";
	
	public List<Produto> recuperaProdutosDeArquivo() throws IOException {
		List<Produto> listaProdutos = new ArrayList<>();
		List<String> textoProdutos = this.recuperaTextoDeArquivo(ARQUIVO_USUARIOS);
		for (String linha: textoProdutos) {
			String [] dadosLinha = linha.split("#");
			Produto p = new Produto(Integer.parseInt(dadosLinha[0]), dadosLinha[1], Double.parseDouble(dadosLinha[2]),Integer.parseInt(dadosLinha[3]), dadosLinha[4]);
			listaProdutos.add(p);	
		}
		return listaProdutos;
	}
	
	public void gravaProdutosEmArquivo(List<Produto> produtos) throws IOException {
		List<String> produtosTxt = new ArrayList<>();
		for (Produto p: produtos) {
			String linha = p.getId() + "#" + p.getNome() + "#" + 
                                p.getPreco() + "#" + p.getQtdEstoque() + "#" + p.getDescricao();
			produtosTxt.add(linha);
		}
		this.gravaTextoEmArquivo(produtosTxt, ARQUIVO_USUARIOS);
	}
	
	
	private List<String> recuperaTextoDeArquivo(String nomeArquivo) throws IOException {
		
		BufferedReader leitor = null;
		List<String> textoLido = new ArrayList<>();
		try {
			leitor = new BufferedReader(new FileReader(nomeArquivo));
			String texto = null;
			do {
				texto = leitor.readLine();
				if (texto!=null) {
					textoLido.add(texto);
				}
			} while (texto!=null);
		} finally {
			if (leitor!=null) {
				leitor.close();
			}
		}
		return textoLido;
		
	}
	
	private void gravaTextoEmArquivo(List<String> texto, String nomeArquivo)
		throws IOException{
		
		BufferedWriter gravador = null;
		try {
			gravador = new BufferedWriter(new FileWriter(nomeArquivo));
			for (String s: texto) {
				gravador.write(s+"\n");
			}
		} finally {
			if (gravador!=null) {
				gravador.close();
			}
		}
	}
}
