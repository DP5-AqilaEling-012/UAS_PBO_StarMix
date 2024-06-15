/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tokostarmix;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author balqis
 */
public class Register extends javax.swing.JFrame {

    /**
     * Creates new form Register
     */
    public Register() {
        setIcon();
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

        txtUsername_register = new javax.swing.JTextField();
        txtNamaToko_register = new javax.swing.JTextField();
        txtPassword2_register = new javax.swing.JPasswordField();
        txtPassword_register = new javax.swing.JPasswordField();
        btnRegister = new javax.swing.JButton();
        btnLinkLogin = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("APLIKASI TOKO STARMIX");
        setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().setLayout(null);

        txtUsername_register.setBackground(new java.awt.Color(0, 0, 0));
        txtUsername_register.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtUsername_register.setForeground(new java.awt.Color(255, 255, 255));
        txtUsername_register.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsername_register.setBorder(null);
        txtUsername_register.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(txtUsername_register);
        txtUsername_register.setBounds(140, 380, 320, 40);

        txtNamaToko_register.setBackground(new java.awt.Color(0, 0, 0));
        txtNamaToko_register.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtNamaToko_register.setForeground(new java.awt.Color(255, 255, 255));
        txtNamaToko_register.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNamaToko_register.setBorder(null);
        txtNamaToko_register.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(txtNamaToko_register);
        txtNamaToko_register.setBounds(140, 280, 320, 40);

        txtPassword2_register.setBackground(new java.awt.Color(0, 0, 0));
        txtPassword2_register.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtPassword2_register.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword2_register.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPassword2_register.setBorder(null);
        getContentPane().add(txtPassword2_register);
        txtPassword2_register.setBounds(140, 590, 320, 40);

        txtPassword_register.setBackground(new java.awt.Color(0, 0, 0));
        txtPassword_register.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtPassword_register.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword_register.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPassword_register.setBorder(null);
        getContentPane().add(txtPassword_register);
        txtPassword_register.setBounds(140, 490, 320, 30);

        btnRegister.setBackground(new java.awt.Color(0, 0, 0));
        btnRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn-register.png"))); // NOI18N
        btnRegister.setBorder(null);
        btnRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegister);
        btnRegister.setBounds(180, 700, 250, 40);

        btnLinkLogin.setBackground(new java.awt.Color(0, 0, 0));
        btnLinkLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn-linkLogin.png"))); // NOI18N
        btnLinkLogin.setBorder(null);
        btnLinkLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLinkLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLinkLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLinkLogin);
        btnLinkLogin.setBounds(470, 20, 90, 30);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/bg-register.png"))); // NOI18N
        getContentPane().add(bg);
        bg.setBounds(0, 0, 600, 832);

        setSize(new java.awt.Dimension(616, 858));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
        String namaToko = txtNamaToko_register.getText();
        String username = txtUsername_register.getText();
        String password = txtPassword_register.getText();
        String password2 = txtPassword2_register.getText();
        
        if(!namaToko.isEmpty() && !namaToko.isBlank() && !username.isEmpty() && !username.isBlank() && !password.isEmpty() && !password.isBlank() && !password2.isEmpty() && !password2.isBlank()){
            if(namaToko.length() >= 4){
                if(username.length() >= 4){
                    if(password.length() >= 4){
                        if(password2.equals(password)){
                            try {
                                Connection conn = Koneksi.ConnectDB();
                                String query = "SELECT * FROM tb_users WHERE username='"+username+"'";
                                Statement st = conn.createStatement();
                                ResultSet rs = st.executeQuery(query);
                                int count = 0;
                                while(rs.next()){
                                    count++;
                                }
                                if(count == 0){
                                    String insrt = "INSERT INTO `tb_users`(`nama_toko`, `username`, `password`) VALUES ('"+namaToko+"','"+username+"','"+password+"')";
                                    PreparedStatement preStmt = conn.prepareStatement(insrt);
                                    preStmt.execute();
                                    JOptionPane.showMessageDialog(rootPane, "Berhasil.. \nSelamat, register anda berhasil!", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
                                    txtNamaToko_register.setText("");
                                    txtUsername_register.setText("");
                                    txtPassword_register.setText("");
                                    txtPassword2_register.setText("");
                                    Login login = new Login();
                                    this.setVisible(false);
                                    login.setVisible(true);
                                    
                                }else{
                                    JOptionPane.showMessageDialog(rootPane, "Oopss...\nMaaf, username sudah terpakai!", "Gagal", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (SQLException e) {
                                JOptionPane.showMessageDialog(rootPane, "Oopss...\nData ditolak!", "Gagal", JOptionPane.ERROR_MESSAGE);
                                System.out.println(e);
                            }
                        }else{
                            JOptionPane.showMessageDialog(rootPane, "Oopss...\nKonfirmasi Password harus sama!", "Gagal", JOptionPane.ERROR_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "Oopss...\nPassword min.4 karakter!", "Gagal", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Oopss...\nUsername min.4 karakter!", "Gagal", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Oopss...\nNama Toko min.4 karakter!", "Gagal", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Oopss...\nData harus diisi dengan benar!", "Gagal", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnLinkLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLinkLoginActionPerformed
        // TODO add your handling code here:
        Login login = new Login();
         this.setVisible(false);
         login.setVisible(true);
    }//GEN-LAST:event_btnLinkLoginActionPerformed

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton btnLinkLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JTextField txtNamaToko_register;
    private javax.swing.JPasswordField txtPassword2_register;
    private javax.swing.JPasswordField txtPassword_register;
    private javax.swing.JTextField txtUsername_register;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../assets/icon-apk.png")));
    }
}

