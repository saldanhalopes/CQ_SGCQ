/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prati_sgcq.view;

import prati_sgcq.dao.UsuarioDAO;
import prati_sgcq.model.Usuario;
import prati_sgcq.util.Cript;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author rafael.lopes
 */
public class FrmAlterarSenha extends javax.swing.JDialog {

    private int userId;
    private Frame jframe;

    /**
     * Creates new form frmAlterarSenha
     *
     * @param parent
     * @param modal
     * @param user
     */
    public FrmAlterarSenha(java.awt.Frame parent, boolean modal, Usuario user) {
        super(parent, modal);
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Alteração de Senha");
        userId = user.getId();
        jframe = parent;
        btnFechar.setVisible(false);
    }

    public FrmAlterarSenha(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Alteração de Senha");
        userId = Integer.valueOf(System.getProperty("user_id"));
        btnFechar.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtConfirmarNovaSenha = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNovaSenha = new javax.swing.JPasswordField();
        btnSalvar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtConfirmarNovaSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConfirmarNovaSenhaKeyReleased(evt);
            }
        });

        jLabel1.setText("Nova Senha:");

        jLabel2.setText("Confirmar Nova Senha:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNovaSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(txtConfirmarNovaSenha))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtConfirmarNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        btnSalvar.setText("Ok");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnFechar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        salvar();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            salvar();
        }
    }//GEN-LAST:event_formKeyPressed

    private void txtConfirmarNovaSenhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConfirmarNovaSenhaKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            salvar();
        }
    }//GEN-LAST:event_txtConfirmarNovaSenhaKeyReleased

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | 
                IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAlterarSenha.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmAlterarSenha dialog = new FrmAlterarSenha(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtConfirmarNovaSenha;
    private javax.swing.JPasswordField txtNovaSenha;
    // End of variables declaration//GEN-END:variables

    private void salvar() {
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        Usuario u = new Usuario();
        UsuarioDAO userDAO = new UsuarioDAO();
        String NovaSenha = new String(txtNovaSenha.getPassword());
        String ConfirmaSenha = new String(txtConfirmarNovaSenha.getPassword());
        if (!NovaSenha.isEmpty()) {
            if (!ConfirmaSenha.equals(NovaSenha)) {
                JOptionPane.showMessageDialog(null, "Senhas não conferem!");
                txtNovaSenha.setText(null);
                txtConfirmarNovaSenha.setText(null);
            } else {
                u.setId(userId);
                u.setPass(Cript.SHA(NovaSenha));
                userDAO.atualizarTrocaSenha(u);
                JOptionPane.showMessageDialog(null, "Senha Alterada com Sucesso");
                new FrmMenu().setVisible(true);
                try {
                    jframe.dispose();
                } catch (Exception e) {

                }
                dispose();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Senha inválida!");
            txtNovaSenha.setText(null);
            txtConfirmarNovaSenha.setText(null);
        }
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

}
