package produtoTest;

import controllers.LojaVirtual;
import exceptions.ProdutoExistente;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Produto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


  /*
        Essa classe Faz o teste tentando cadastrar o produto, retorna verdadeiro  caso sucesso ou false se der uma exception
        
        */




public class TestaCadastro {
    
    public TestaCadastro() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testCadastraProduto() {
        
      
        
        LojaVirtual loja = new LojaVirtual();
        Produto p = new Produto("Caneta", 1.59, 20, "Cor Azul");
        try {
            loja.cadastrar(p);
            assertTrue(true);
        } catch (ProdutoExistente ex) {
            assertTrue(false);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
