package cliente;

import DTOs.requests.LogoutRequestDTO;
import DTOs.responses.DefaultResponse;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ViewHome extends javax.swing.JFrame {

    public ViewHome(String cUsername, ViewClienteLogin viewClienteLogin, PrintWriter out, BufferedReader in) {
        initComponents();
        this.cUsername = cUsername;
        this.viewClienteLogin = viewClienteLogin;
        this.in = in;
        this.out = out;
    }

    ViewClienteLogin viewClienteLogin;
    String cUsername;
    PrintWriter out;
    BufferedReader in;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotaoSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BotaoSair.setText("Sair");
        BotaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(667, Short.MAX_VALUE)
                .addComponent(BotaoSair)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BotaoSair)
                .addContainerGap(436, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSairActionPerformed
        try {
            Gson gson = new Gson();
            LogoutRequestDTO logoutRequest = new LogoutRequestDTO();
            logoutRequest.setOp(200);
            logoutRequest.setUsername(cUsername);
            System.out.printf("\n\nMensagem Enviada para o Server : " + gson.toJson(logoutRequest) + "\n\n");
            out.println(gson.toJson(logoutRequest));
            String resposta = in.readLine();
            System.out.println("Servidor respondeu : " + resposta);
            DefaultResponse respostaJson = gson.fromJson(resposta, DefaultResponse.class);
            if (respostaJson.getStatus() == 201) {
                this.setVisible(false); // Desaparece tela login
                viewClienteLogin.setVisible(true);
                JOptionPane.showMessageDialog(null, "Sucesso, " + resposta, "Logout", 1);
            }
        } catch (IOException ex) {
            Logger.getLogger(ViewHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotaoSairActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoSair;
    // End of variables declaration//GEN-END:variables
}
