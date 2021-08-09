/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.Farmacia.view;

import br.com.fatec.Farmacia.DAO.RemedioDAO;
import br.com.fatec.Farmacia.Exceptions.DadosBrancoException;
import br.com.fatec.Farmacia.bean.Remedio;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author nicol
 */
public class RemedioView extends javax.swing.JFrame {

    private RemedioDAO dao = new RemedioDAO();
    private Remedio remedioBean = new Remedio();

    /**
     * Creates new form RemedioView
     */
    public RemedioView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPreco = new javax.swing.JTextField();
        txtCategoria = new javax.swing.JTextField();
        lblCategoria = new javax.swing.JLabel();
        btnInserir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtReceita = new javax.swing.JTextField();
        lblReceita = new javax.swing.JLabel();
        lblPreco = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lblCodigo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblCategoria.setText("Categoria");

        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        lblID.setBackground(new java.awt.Color(255, 0, 255));
        lblID.setText("ID");

        txtID.setEditable(false);
        txtID.setBackground(new java.awt.Color(153, 153, 153));
        txtID.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setText("Nome");

        lblReceita.setText("Receita");

        lblPreco.setText("Preço");

        lblCodigo.setText("Codigo");

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Remedios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 8, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblID)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNome)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnPesquisar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblCodigo)
                                            .addComponent(lblCategoria))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtCategoria)
                                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(lblReceita)
                                                .addGap(18, 18, 18))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblPreco)
                                                .addGap(27, 27, 27)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtPreco)
                                            .addComponent(txtReceita, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(152, 152, 152)
                                .addComponent(btnInserir)
                                .addGap(18, 18, 18)
                                .addComponent(btnAlterar)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluir)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblID)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCategoria)
                            .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodigo)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblReceita)
                            .addComponent(txtReceita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPreco)
                            .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInserir)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir)
                    .addComponent(btnCancelar))
                .addGap(26, 26, 26))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        // TODO add your handling code here:
        try {
            moveTelaParaBean();
            if (dao.insere(remedioBean)) {
                mensagem("Dados incluidos com sucesso!");
                limpaCampos();
                txtNome.requestFocus();
            }
        } catch (DadosBrancoException ex) {
            erro(ex.getMessage());
        } catch (SQLException ex) {
            erro(ex.getMessage());
        }
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
        try {
            moveTelaParaBean();
            if (dao.altera(remedioBean)) {
                mensagem("Dados alterados com sucesso!");
                limpaCampos();
                txtNome.requestFocus();
            } else {
                erro("Alteração não foi bem sucedida");
            }
        } catch (SQLException ex) {
            erro(ex.getMessage());
        } catch (DadosBrancoException ex) {
            erro(ex.getMessage());
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            moveTelaParaBean();
            int resp = JOptionPane.showConfirmDialog(rootPane, "Tem certeza que deseja excluir os dados"
                    + " do cliente " + remedioBean.getNome() + " ?",
                    "Confirmar Exclusão",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (resp == JOptionPane.NO_OPTION) {
                return;
            }
            if (dao.remove(remedioBean)) {
                mensagem("Dados excluídos com sucesso!");
                limpaCampos();
                txtNome.requestFocus();
            } else {
                erro("Dados não foram excluídos com sucesso");
            }
        } catch (SQLException ex) {
            erro(ex.getMessage());
        } catch (DadosBrancoException ex) {
            erro(ex.getMessage());
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // TODO add your handling code here:
        try {
            moveTelaParaBeanPesquisa();
            remedioBean = dao.buscaID(remedioBean);
            if (remedioBean == null) {
                erro("Dados não encontrados!");
            } else {
                moveBeanParaTela();
            }
        } catch (DadosBrancoException ex) {
            erro(ex.getMessage());
        } catch (SQLException ex) {
            erro(ex.getMessage());

        }
    }//GEN-LAST:event_btnPesquisarActionPerformed
    private void limpaCampos() {
        txtID.setText("");
        txtReceita.setText("");
        txtNome.setText("");
        txtPreco.setText("");
        txtCodigo.setText("");
        txtCategoria.setText("");
    }

    /**
     * mensagem ao usuario
     *
     * @param texto
     */
    private void mensagem(String texto) {
        JOptionPane.showMessageDialog(rootPane,
                texto,
                "Informação ao Usuário",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Mostra uma mensagem de erro na tela
     *
     * @param erro
     */
    private void erro(String erro) {
        JOptionPane.showMessageDialog(rootPane,
                erro,
                "Informação ao Usuário",
                JOptionPane.ERROR_MESSAGE);

    }

    //metodos auxiliares
    private void moveBeanParaTela() {
        txtCategoria.setText(remedioBean.getCategoria());
        txtCodigo.setText(Integer.toString(remedioBean.getCodigo()));
        txtID.setText(Integer.toString(remedioBean.getIdRemedio()));
        txtNome.setText(remedioBean.getNome());
        txtPreco.setText(Float.toString(remedioBean.getPreco()));
        txtReceita.setText(remedioBean.getReceita()); //sim, não, não informado
    }

    /**
     * evento int - 1 para pesquisa e 0 para outros eventos
     *
     * @param evento
     * @throws DadosBrancoException
     *///int evento
    private void moveTelaParaBean() throws DadosBrancoException {
        if (validarDados()) {//&& evento == 0
            remedioBean.setCategoria(txtCategoria.getText());
            if (txtID.getText().isEmpty()) {
                remedioBean.setIdRemedio(0); //autoincremento
            } else {
                remedioBean.setIdRemedio(Integer.parseInt(txtID.getText()));
            }
            remedioBean.setNome(txtNome.getText());
            remedioBean.setPreco(Float.parseFloat(txtPreco.getText()));
            remedioBean.setReceita(txtReceita.getText());
            remedioBean.setCodigo(Integer.parseInt(txtCodigo.getText()));

        } else {
            throw new DadosBrancoException("Preencha todos os dados");
        }
    }

    private void moveTelaParaBeanPesquisa() throws DadosBrancoException {
        if (!txtCodigo.getText().isEmpty()) { // && evento == 1
            mensagem("Antes da Categoria");
            if (txtID.getText().isEmpty()) {
                remedioBean.setCategoria(txtCategoria.getText());
            } else {
                remedioBean.setCategoria("a");
            }
            mensagem("Depois de categoria: " + remedioBean.getCategoria());
            if (txtID.getText().isEmpty()) {
                remedioBean.setIdRemedio(0); //autoincremento
            } else {
                remedioBean.setIdRemedio(Integer.parseInt(txtID.getText()));
            }
            remedioBean.setNome(txtNome.getText());
            if (txtPreco.getText().isEmpty()) {
                remedioBean.setPreco(0.0f);
            } else {
                remedioBean.setPreco(Float.parseFloat(txtPreco.getText()));
            }
            remedioBean.setReceita(txtReceita.getText());

            remedioBean.setCodigo(Integer.parseInt(txtCodigo.getText()));

        } else {
            throw new DadosBrancoException("Preencha o Código do Remédio");
        }
    }

    private boolean validarDados() {
        return !txtID.getText().isEmpty() || !txtCategoria.getText().isEmpty()
                || !txtNome.getText().isEmpty() || !txtCodigo.getText().isEmpty() || !txtPreco.getText().isEmpty()
                || !txtPreco.getText().isEmpty();
    }

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
            java.util.logging.Logger.getLogger(RemedioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RemedioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RemedioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RemedioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RemedioView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblReceita;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtReceita;
    // End of variables declaration//GEN-END:variables
}
