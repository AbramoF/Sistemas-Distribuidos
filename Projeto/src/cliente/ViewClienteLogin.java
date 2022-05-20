/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cliente;

import DTOs.requests.LoginRequestDTO;
import DTOs.requests.RegisterRequestDTO;
import DTOs.responses.DefaultResponse;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ViewClienteLogin extends javax.swing.JFrame {

    public ViewClienteLogin() {
        initComponents();
        botaoLogin.setEnabled(false);
        botaoRegistro.setEnabled(false);
    }

    String cUsername;
     
    private ViewHome home;
    Socket echoSocket = null;
    PrintWriter out = null;
    BufferedReader in = null;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        senhaField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        botaoLogin = new javax.swing.JButton();
        ipField = new javax.swing.JTextField();
        portField = new javax.swing.JTextField();
        carregarButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        botaoRegistro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Cliente");

        jLabel9.setText("Username:");

        jLabel10.setText("Senha:");

        jLabel5.setText("Cliente");

        senhaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaFieldActionPerformed(evt);
            }
        });

        jLabel7.setText("Porta:");

        botaoLogin.setText("Login");
        botaoLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLoginActionPerformed(evt);
            }
        });

        ipField.setText("127.0.0.1");
        ipField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipFieldActionPerformed(evt);
            }
        });

        portField.setText("20000");

        carregarButton.setText("Conectar");
        carregarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carregarButtonActionPerformed(evt);
            }
        });

        jLabel8.setText("Login");

        jLabel1.setText("IP:");

        botaoRegistro.setText("Registrar");
        botaoRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(portField))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ipField, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(carregarButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(senhaField)
                            .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(botaoRegistro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoLogin))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ipField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(carregarButton)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(senhaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoLogin)
                    .addComponent(botaoRegistro))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void senhaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senhaFieldActionPerformed

    private void botaoLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLoginActionPerformed
        try {
            String username = usernameField.getText();
            cUsername = usernameField.getText();
            String password = senhaField.getText();
            Gson gson = new Gson();
            LoginRequestDTO loginRequest = new LoginRequestDTO();
            loginRequest.setOp(100);
            loginRequest.setUsername(username);
            loginRequest.setPassword(password);
            System.out.printf("\n\nMensagem Enviada para o Server : " + gson.toJson(loginRequest) + "\n\n");
            out.println(gson.toJson(loginRequest));
            String resposta = in.readLine();
            System.out.println("Servidor respondeu : " + resposta);
            DefaultResponse respostaJson = gson.fromJson(resposta, DefaultResponse.class);
            if (respostaJson.getStatus() == 101) {
                this.setVisible(false); // Desaparece tela login
                home = new ViewHome(cUsername, this, out, in);
                home.setVisible(true);
                JOptionPane.showMessageDialog(null, "Sucesso, " + resposta, "Login", 1);
            } else if (respostaJson.getStatus() == 102) {
                JOptionPane.showMessageDialog(null, "Falha, " + resposta, "Login", 1);
            }
        } catch (IOException ex) {
            Logger.getLogger(ViewClienteLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_botaoLoginActionPerformed

    private void ipFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ipFieldActionPerformed

    private void carregarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carregarButtonActionPerformed
        if (!ipField.getText().equals("") & !portField.getText().equals("")) {
            String serverHostname = ipField.getText();
            int port = Integer.parseInt(portField.getText());
            try {

                echoSocket = new Socket(serverHostname, port);
                out = new PrintWriter(echoSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(
                        echoSocket.getInputStream()));
                this.ipField.setEditable(false);
                this.portField.setEditable(false);
                this.carregarButton.setEnabled(false);
                this.botaoRegistro.setEnabled(true);
                this.botaoLogin.setEnabled(true);
                System.out.println("Cliente conectado com servidor no IP " + serverHostname + ", na porta " + port);
                JOptionPane.showMessageDialog(null, "Conectado com o servidor", "Conecção", 1);
            } catch (UnknownHostException e) {
                System.err.println("Don't know about host: " + serverHostname);
                JOptionPane.showMessageDialog(null, "Don't know about host: " + serverHostname, "Erro ", JOptionPane.ERROR_MESSAGE);

            } catch (IOException e) {
                System.err.println("Couldn't get I/O for "
                        + "the connection to: " + serverHostname);
                JOptionPane.showMessageDialog(null, "Couldn't get I/O for "
                        + "the connection to: " + serverHostname, "Erro ", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Informe o IP e Porta: ", "Erro ", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_carregarButtonActionPerformed

    private void botaoRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRegistroActionPerformed
        try {
            String username = usernameField.getText();
            String password = senhaField.getText();
            Gson gson = new Gson();
            RegisterRequestDTO registerRequest = new RegisterRequestDTO();
            registerRequest.setOp(300);
            registerRequest.setUsername(username);
            registerRequest.setPassword(password);
            System.out.printf("\n\nMensagem Enviada para o Server : " + gson.toJson(registerRequest) + "\n\n");
            out.println(gson.toJson(registerRequest));
            String resposta = in.readLine();
            System.out.println("Servidor respondeu : " + resposta);
            DefaultResponse respostaJson = gson.fromJson(resposta, DefaultResponse.class);
            if (respostaJson.getStatus() == 301) { // Sucesso
                JOptionPane.showMessageDialog(null, "Sucesso, " + resposta, "Registro", 1);
            } else if (respostaJson.getStatus() == 302) { // Usuario ja existe
                JOptionPane.showMessageDialog(null, "Falha, " + resposta, "Registro", 1);
            } else if (respostaJson.getStatus() == 303) { // Campo vazio
                JOptionPane.showMessageDialog(null, "Falha, " + resposta, "Registro", 1);
            } 
        } catch (IOException ex) {
            Logger.getLogger(ViewClienteLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_botaoRegistroActionPerformed

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
            java.util.logging.Logger.getLogger(ViewClienteLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewClienteLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewClienteLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewClienteLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewClienteLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoLogin;
    private javax.swing.JButton botaoRegistro;
    private javax.swing.JButton carregarButton;
    private javax.swing.JTextField ipField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField portField;
    private javax.swing.JTextField senhaField;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
