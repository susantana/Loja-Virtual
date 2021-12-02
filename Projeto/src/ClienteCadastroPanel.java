/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

public class ClienteCadastroPanel extends javax.swing.JPanel {

    Cliente cliente;

    public ClienteCadastroPanel() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textFieldBairro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        textFieldNome = new javax.swing.JTextField();
        textFieldCPF = new javax.swing.JTextField();
        textFieldEndereco = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setLayout(null);
        add(textFieldBairro);
        textFieldBairro.setBounds(130, 190, 260, 30);

        jLabel2.setText("CPF");
        add(jLabel2);
        jLabel2.setBounds(30, 110, 60, 14);

        jLabel3.setText("Endereço");
        add(jLabel3);
        jLabel3.setBounds(30, 150, 60, 14);

        jLabel4.setText("Bairro");
        add(jLabel4);
        jLabel4.setBounds(30, 190, 60, 14);

        jLabel1.setText("Nome");
        add(jLabel1);
        jLabel1.setBounds(30, 70, 70, 14);
        add(textFieldNome);
        textFieldNome.setBounds(130, 70, 260, 30);
        add(textFieldCPF);
        textFieldCPF.setBounds(130, 110, 260, 30);
        add(textFieldEndereco);
        textFieldEndereco.setBounds(130, 150, 260, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Cadastro de Cliente");
        add(jLabel5);
        jLabel5.setBounds(170, 10, 200, 40);

        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(130, 250, 260, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nome = textFieldNome.getText();
        String cpf = textFieldCPF.getText();
        String endereco = textFieldEndereco.getText();
        String bairro = textFieldBairro.getText();
        
        cliente = new Cliente(nome, cpf, endereco, bairro);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField textFieldBairro;
    private javax.swing.JTextField textFieldCPF;
    private javax.swing.JTextField textFieldEndereco;
    private javax.swing.JTextField textFieldNome;
    // End of variables declaration//GEN-END:variables
}
