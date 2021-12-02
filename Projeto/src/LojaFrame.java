/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import javax.swing.JDialog;

public class LojaFrame extends javax.swing.JFrame {


    public LojaFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        menuCadastroProduto = new javax.swing.JMenuItem();
        menuCadastroCliente = new javax.swing.JMenuItem();
        menuLista = new javax.swing.JMenu();
        menuListaProdutos = new javax.swing.JMenuItem();
        menuListaClientes = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Produto");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 90, 107, 29);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Cliente");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 29, 84, 29);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Quantidade");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 140, 130, 29);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(150, 90, 143, 29);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(150, 30, 143, 29);

        jButton1.setText("Inserir");
        getContentPane().add(jButton1);
        jButton1.setBounds(10, 212, 286, 32);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(150, 140, 146, 35);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(340, 50, 179, 153);

        jButton2.setText("Finalizar Compra");
        getContentPane().add(jButton2);
        jButton2.setBounds(339, 212, 179, 32);

        jLabel4.setText("Produtos selecionados:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(340, 30, 170, 14);

        menuCadastro.setText("Cadastros");

        menuCadastroProduto.setText("Produto");
        menuCadastroProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroProdutoActionPerformed(evt);
            }
        });
        menuCadastro.add(menuCadastroProduto);

        menuCadastroCliente.setText("Cliente");
        menuCadastro.add(menuCadastroCliente);

        jMenuBar1.add(menuCadastro);

        menuLista.setText("Dados");
        menuLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListaActionPerformed(evt);
            }
        });

        menuListaProdutos.setText("Listar Produtos");
        menuListaProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListaProdutosActionPerformed(evt);
            }
        });
        menuLista.add(menuListaProdutos);

        menuListaClientes.setText("Listar Clientes");
        menuListaClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListaClientesActionPerformed(evt);
            }
        });
        menuLista.add(menuListaClientes);

        jMenuBar1.add(menuLista);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuCadastroProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroProdutoActionPerformed
        
    }//GEN-LAST:event_menuCadastroProdutoActionPerformed

    private void menuListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuListaActionPerformed

    private void menuListaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListaClientesActionPerformed
        ClienteListaPanel panel = new ClienteListaPanel();
        JDialog form = new JDialog(this, true);
        form.setContentPane(panel);
        form.setSize(430, 350);
        form.setVisible(true);
    }//GEN-LAST:event_menuListaClientesActionPerformed

    private void menuListaProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListaProdutosActionPerformed
        ProdutoListaPanel panel = new ProdutoListaPanel();
        JDialog form = new JDialog(this, true);
        form.setContentPane(panel);
        form.setSize(430, 350);
        form.setVisible(true);
    }//GEN-LAST:event_menuListaProdutosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LojaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LojaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LojaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LojaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LojaFrame loja = new LojaFrame();
                loja.setSize(550, 350);
                loja.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenuItem menuCadastroCliente;
    private javax.swing.JMenuItem menuCadastroProduto;
    private javax.swing.JMenu menuLista;
    private javax.swing.JMenuItem menuListaClientes;
    private javax.swing.JMenuItem menuListaProdutos;
    // End of variables declaration//GEN-END:variables
}
