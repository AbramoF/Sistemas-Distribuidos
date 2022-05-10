package cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class login extends JDialog{

    private JPasswordField senha;
    private JTextField usuario;
    private JPanel panel1;
    private JButton button1;
    private JFrame tela;

public login(JFrame parent){
    super(parent);
    setTitle("ola");
    setContentPane(panel1);
    setMinimumSize(new Dimension(450,474));
    setModal(true);
    setLocationRelativeTo(parent);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setVisible(true);
    button1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String user = usuario.getText();
            String password = String.valueOf(senha.getPassword());

        }
    });
}



    public static void main(String[] args) {
    login oi=new login(null);


    }
}




