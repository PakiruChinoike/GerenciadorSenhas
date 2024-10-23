package gui;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;

public class UIPrincipal extends JFrame{

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel txtInicio;
    private JButton btnLogin;
    private JButton btnCadastro;

    public UIPrincipal(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 490, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        setContentPane(contentPane);
        contentPane.setLayout(null);

        txtInicio = new JLabel("Ínicio");
        txtInicio.setBounds(225, 120, 150, 50);
        contentPane.add(txtInicio);

        btnCadastro = new JButton("Cadastro");
        btnCadastro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UICadastro uiCad = new UICadastro();
                uiCad.setVisible(true);
            }
        });
        btnCadastro.setBounds(190, 185, 100, 30);
        contentPane.add(btnCadastro);

        btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        UILogin uiLog = new UILogin();
        uiLog.setVisible(true);
        dispose();
        }
        });

        btnLogin.setBounds(190, 225, 100, 30);
        contentPane.add(btnLogin);
    }
}
