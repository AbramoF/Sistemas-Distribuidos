package cliente;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPage {
    public static void main(String[] args) {
        
        JFrame f = new JFrame();
        f.setTitle("Janela");
        f.setSize(500, 200);
        f.setLocation(500, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel p = new JPanel();
        
        JLabel labelLogin = new JLabel("Login:");
        p.add(labelLogin);
        JTextField loginField = new JTextField(10);
        p.add(loginField);
        JLabel labelSenha = new JLabel("Senha:");
        p.add(labelSenha);
        JTextField senhaField = new JTextField(10);
        p.add(senhaField);
        
        JButton b = new JButton("Ok");
        BotaoActionLogin action = new BotaoActionLogin(loginField, senhaField);
        b.addActionListener(action);
        p.add(b);
        
        
        f.add(p);
        f.setVisible(true);
    }
}
