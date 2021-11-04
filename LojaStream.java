import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class LojaStream {

    ObjectOutputStream oos;
    ObjectInputStream ois;
    FileInputStream fis;
    FileOutputStream fos;
    String arquivo;

    public LojaStream(String arquivo) {
        this.arquivo = arquivo;
    }

    public List<Produto> lerDados() {
        try {
            fis = new FileInputStream(arquivo);
            ois = new ObjectInputStream(fis);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        List<Produto> produtos = new ArrayList();
        while (true) {
            try {
                Produto p = (Produto) ois.readObject();
                produtos.add(p);
            } catch (EOFException eof) {
                break;
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        }
        try {
            ois.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return produtos;
    }
    
    public void salvarDados(ArrayList produtos) {
        try {
            fos = new FileOutputStream(arquivo);
            oos = new ObjectOutputStream(fos);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }        
        
        for (Object produto : produtos) {
            try {
                oos.writeObject(produto);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        try {
            oos.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
