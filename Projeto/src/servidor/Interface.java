package servidor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import repositories.Repositorio;
import static servidor.TCPServer.port;

public class Interface {

    JFrame f;
    Repositorio repositorio;

    Interface(Repositorio repositorio) {
        this.repositorio = repositorio;

        f = new JFrame("Servidor");

        // PAINEL 1
        JPanel panel_1 = new JPanel();
        //panel_1.setBounds(0, 0, 400, 300); //x,y,width,heigth
        panel_1.setBackground(Color.red);

        JLabel titulo = new JLabel("Interface Servidor");
        JLabel portLabel = new JLabel("Porta:");
        JTextPane portBox = new JTextPane();
        JButton botaoPort = new JButton("Escolher");

        titulo.setBounds(50, 50, 200, 75);
        portLabel.setBounds(60, 55, 75, 25);
        portBox.setBounds(110, 55, 75, 25);
        botaoPort.setBounds(100, 140, 100, 40);
        botaoPort.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String porta = portBox.getText();
                port = Integer.parseInt(porta);
                System.out.println("Porta escolhida: " + porta);

            }
        });

//        panel_1.add(titulo);
//        panel_1.add(portLabel);
//        panel_1.add(portBox);
//        panel_1.add(botaoPort);
        f.add(panel_1, BorderLayout.PAGE_START);

        // PAINEL 2
        JPanel panel_2 = new JPanel();
        //panel_2.setBounds(0, 300, 400, 300); //x,y,width,heigth
        panel_1.setBackground(Color.blue);

        JTable jt = new JTable(repositorio.data, repositorio.column);
        jt.setBounds(30, 400, 200, 300);
        JScrollPane sp = new JScrollPane(jt);
        panel_2.add(sp);
        f.add(panel_2, BorderLayout.PAGE_END);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600, 400);
        f.setVisible(true);
    }

    public static void main(String[] args, Repositorio repositorio) {
        new Interface(repositorio);
    }
}
