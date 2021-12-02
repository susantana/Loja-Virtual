/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

public class ProdutoCadastroPanel extends javax.swing.JPanel {

    Produto produto;

    public ProdutoCadastroPanel() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        textFieldName = new javax.swing.JTextField();
        textFieldPreco = new javax.swing.JTextField();
        textFieldQuantidade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaDescricao = new javax.swing.JTextArea();

        setLayout(null);

        jLabel2.setText("Preço");
        add(jLabel2);
        jLabel2.setBounds(90, 110, 60, 14);

        jLabel3.setText("Quantidade em estoque");
        add(jLabel3);
        jLabel3.setBounds(270, 110, 120, 20);

        jLabel4.setText("Descrição");
        add(jLabel4);
        jLabel4.setBounds(90, 170, 60, 14);

        jLabel1.setText("Nome");
        add(jLabel1);
        jLabel1.setBounds(90, 50, 70, 14);
        add(textFieldName);
        textFieldName.setBounds(90, 70, 340, 30);
        add(textFieldPreco);
        textFieldPreco.setBounds(90, 130, 160, 30);
        add(textFieldQuantidade);
        textFieldQuantidade.setBounds(270, 130, 160, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Cadastro de Produto");
        add(jLabel5);
        jLabel5.setBounds(170, 10, 200, 40);

        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(140, 250, 240, 40);

        textAreaDescricao.setColumns(20);
        textAreaDescricao.setRows(5);
        jScrollPane1.setViewportView(textAreaDescricao);

        add(jScrollPane1);
        jScrollPane1.setBounds(90, 190, 340, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nome = textFieldName.getText();
        double preco = Double.parseDouble(textFieldPreco.getText());
        int quantidade = Integer.parseInt(textFieldQuantidade.getText());
        String descricao = textAreaDescricao.getText();
        
        produto = new Produto(nome, preco, quantidade, descricao);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textAreaDescricao;
    private javax.swing.JTextField textFieldName;
    private javax.swing.JTextField textFieldPreco;
    private javax.swing.JTextField textFieldQuantidade;
    // End of variables declaration//GEN-END:variables
}
