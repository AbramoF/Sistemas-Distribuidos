package cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BotaoActionLogin implements ActionListener {

    private JTextField login, senha;
    
    
    public BotaoActionLogin(JTextField login, JTextField senha) {
        this.login = login;
        this.senha = senha;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String loginText = login.getText();
        String senhaText = senha.getText();
        JOptionPane.showMessageDialog(null, "Login: " + loginText + "\nSenha: " + senhaText);
    }
    
}
