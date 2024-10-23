package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

import seginfo.gerenciadorSenhas.GerenciadorSenhas;
import seginfo.gerenciadorSenhas.Usuario;
import seginfo.gerenciadorSenhas.UsuarioDAO;

import javax.swing.*;

public class UILogin extends JFrame{

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtEmail;
    private JPasswordField txtSenha;
    private JButton btnLogin;
    private UsuarioDAO usuarioDAO;

    public UILogin (){
        this.usuarioDAO = new UsuarioDAO();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

        JLabel lblNewLabel1 = new JLabel("Email");
		lblNewLabel1.setBounds(170, 60, 100, 30);
		contentPane.add(lblNewLabel1);

		txtEmail = new JTextField();
		txtEmail.setBounds(160, 60, 100, 30);
		contentPane.add(txtEmail);

		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setBounds(170, 100, 100, 30);
		contentPane.add(lblNewLabel_1);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(160, 100, 100, 30);
		contentPane.add(txtSenha);

        btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Usuario u = usuarioDAO.buscar(txtEmail.getText());

                boolean b = realizarLogin(u, new String(txtSenha.getPassword()));
                if (b){
                    JOptionPane.showMessageDialog(contentPane,"Sucesso Hash: " + u.getSenha(),"Sucesso ao autenticar usuário!",JOptionPane.INFORMATION_MESSAGE);
					dispose();
                } else {
                    JOptionPane.showMessageDialog(contentPane,"Erro","Erro ao autenticar usuário!",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnLogin.setBounds(160, 200, 100, 30);
		contentPane.add(btnLogin);
    }


    private boolean realizarLogin(Usuario u, String senha) {
		String hashSenhaOriginal = u.getSenha();

		if (GerenciadorSenhas.autenticar(senha, hashSenhaOriginal)) {
            return true;
		}
		else {
			return false;
		}
    }
}
