package gui;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;

import seginfo.gerenciadorSenhas.GerenciadorSenhas;
import seginfo.gerenciadorSenhas.Usuario;
import seginfo.gerenciadorSenhas.UsuarioDAO;

public class UICadastro extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtNome;
    private JTextField txtEmail;
	private JPasswordField txtSenha;
	private JButton btnCadastrar;

    private UsuarioDAO usuarioDAO;

    public UICadastro (){
        this.usuarioDAO = new UsuarioDAO();
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 320, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5,5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewJLabel = new JLabel("Nome");
        lblNewJLabel.setBounds(110, 20, 100, 30);
        contentPane.add(lblNewJLabel);

        txtNome = new JTextField();
        txtNome.setBounds(100, 20, 90, 30);
        contentPane.add(txtNome);

		JLabel lblNewLabel1 = new JLabel("Email");
		lblNewLabel1.setBounds(110, 60, 100, 30);
		contentPane.add(lblNewLabel1);

		txtEmail = new JTextField();
		txtEmail.setBounds(100, 60, 90, 30);
		contentPane.add(txtEmail);

		JLabel lblNewLabel3 = new JLabel("Senha");
		lblNewLabel3.setBounds(110, 100, 100, 30);
		contentPane.add(lblNewLabel3);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(100, 100, 90, 30);
		contentPane.add(txtSenha);

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Usuario usuario = realizarCadastro(txtNome.getText(), txtEmail.getText(), new String(txtSenha.getPassword()));
                if (usuario!=null){
                    JOptionPane.showMessageDialog(contentPane,"Sucesso","Sucesso ao cadastrar usuário!",JOptionPane.INFORMATION_MESSAGE);
					dispose();
                } else {
                    JOptionPane.showMessageDialog(contentPane,"Erro","Erro ao cadastrar usuário!",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnCadastrar.setBounds(100, 200, 100, 30);
		contentPane.add(btnCadastrar);
    }


    private Usuario realizarCadastro(String nome, String email, String senha){
        String hash = GerenciadorSenhas.codificar(senha);

        Usuario usuario = new Usuario(0, nome, email, hash);
        return usuarioDAO.salvar(usuario);
    }

}
