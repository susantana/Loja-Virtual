package controllers;

import models.Venda;
import models.Cliente;
import models.Produto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LojaDados {

    public static final String ARQUIVO_PRODUTOS = "produtos.txt";
    public static final String ARQUIVO_CLIENTES = "clientes.txt";
    public static final String ARQUIVO_VENDAS = "vendas.txt";
    
    /*
    Recuperação: lê uma string de um arquivo utilizando o recuperaTextoDeArquivo
    Depois, para cada linha, separa-se os atributos no símbolo # e monta o objeto adequado inserindo-o numa lista
    
    */
    public List<Produto> recuperaProdutosDeArquivo() throws IOException {
        List<Produto> listaProdutos = new ArrayList<>();
        List<String> textoProdutos = this.recuperaTextoDeArquivo(ARQUIVO_PRODUTOS);
        for (String linha : textoProdutos) {
            String[] dadosLinha = linha.split("#");
            Produto p = new Produto(Long.parseLong(dadosLinha[0]), dadosLinha[1], Double.parseDouble(dadosLinha[2]), Integer.parseInt(dadosLinha[3]), dadosLinha[4]);
            listaProdutos.add(p);
        }
        return listaProdutos;
    }
    
    public List<Cliente> recuperaClientesDeArquivo() throws IOException {
        List<Cliente> listaClientes = new ArrayList<>();
        List<String> textoClientes = this.recuperaTextoDeArquivo(ARQUIVO_CLIENTES);
        for (String linha : textoClientes) {
            String[] dadosLinha = linha.split("#");
            Cliente c = new Cliente(Long.parseLong(dadosLinha[0]), dadosLinha[1],dadosLinha[2], dadosLinha[3], dadosLinha[4]);
            listaClientes.add(c);
        }
        return listaClientes;
    }
    
    public List<Venda> recuperaVendasDeArquivo() throws IOException {
        List<Cliente> listaClientes = this.recuperaClientesDeArquivo();
        List<Produto> listaProdutos = this.recuperaProdutosDeArquivo();
        
        Cliente cliente = null;
        List<Produto> listaProdutosCadastrados = new ArrayList<>();
        
        List<Venda> listaVendas = new ArrayList<>();
        List<String> textoVendas = this.recuperaTextoDeArquivo(ARQUIVO_VENDAS);
        
        for (String linha : textoVendas) {
            String[] dadosLinha = linha.split("#");
            
            //procura cliente
            for (Cliente c : listaClientes) {
                if (c.getId() == Long.parseLong(dadosLinha[1])) {
                    cliente = c;
                }
            }
            
            if (dadosLinha.length >= 3) {
                String[] dadosProdutos = dadosLinha[3].split(";");
                //procura produtos
                for (int i = 0; i < dadosProdutos.length; i++) {
                    for (Produto p : listaProdutos) {
                        if (Long.parseLong(dadosProdutos[i]) == p.getId()) {
                            listaProdutosCadastrados.add(p);
                        }
                    }                
                }
                
                Venda v = new Venda(Long.parseLong(dadosLinha[0]), cliente, listaProdutosCadastrados, Double.parseDouble(dadosLinha[2]));
                listaVendas.add(v);
            }    
        }
        return listaVendas;
    }
    
    private List<String> recuperaTextoDeArquivo(String nomeArquivo) throws IOException {

        BufferedReader leitor = null;
        List<String> textoLido = new ArrayList<>();
        try {
            leitor = new BufferedReader(new FileReader(nomeArquivo));
            String texto = null;
            do {
                texto = leitor.readLine();
                if (texto != null) {
                    textoLido.add(texto);
                }
            } while (texto != null);
        } finally {
            if (leitor != null) {
                leitor.close();
            }
        }
        return textoLido;

    }

    /*
     Grava��es: recebe uma lista (produto/cliente/venda) para cada item, é transformado em uma string separando os atributos por #
     para salvar a string no arquivo, chama-se o método gravaTextoEmArquivo
    */
    
    public void gravaProdutosEmArquivo(List<Produto> produtos) throws IOException {
        List<String> produtosTxt = new ArrayList<>();
        for (Produto p : produtos) {
            String linha = p.getId() + "#" + p.getNome() + "#"
                    + p.getPreco() + "#" + p.getQtdEstoque() + "#" + p.getDescricao();
            produtosTxt.add(linha);
        }
        this.gravaTextoEmArquivo(produtosTxt, ARQUIVO_PRODUTOS);
    }

    public void gravaClientesEmArquivo(List<Cliente> clientes) throws IOException {
        List<String> clientesTxt = new ArrayList<>();
        for (Cliente c : clientes) {
            String linha = c.getId() + "#" + c.getNome() + "#"
                    + c.getCpf() + "#" + c.getEndereco() + "#" + c.getBairro();
            clientesTxt.add(linha);
        }
        this.gravaTextoEmArquivo(clientesTxt, ARQUIVO_CLIENTES);
    }

    public void gravaVendasEmArquivo(List<Venda> vendas) throws IOException {
        List<String> vendasTxt = new ArrayList<>();
        for (Venda v : vendas) {
            String linha = v.getId() + "#" + v.getCliente().getId() + "#"
                    + v.getTotal_pagar() + "#";
            
            for (Produto produto : v.getProdutos()) {
                linha += produto.getId() + ";";
            }
            
            vendasTxt.add(linha);
        }
        this.gravaTextoEmArquivo(vendasTxt, ARQUIVO_VENDAS);
    }
    
    private void gravaTextoEmArquivo(List<String> texto, String nomeArquivo)
            throws IOException {

        BufferedWriter gravador = null;
        try {
            gravador = new BufferedWriter(new FileWriter(nomeArquivo));
            for (String s : texto) {
                gravador.write(s + "\n");
            }
        } finally {
            if (gravador != null) {
                gravador.close();
            }
        }
    }
}
