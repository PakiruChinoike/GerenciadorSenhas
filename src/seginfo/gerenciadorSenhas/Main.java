package seginfo.gerenciadorSenhas;

import java.util.Scanner;

import gui.UIPrincipal;

public class Main {

	private static UsuarioDAO dao;

	public static void main(String[] args) {
		
		UIPrincipal ui = new UIPrincipal();
		ui.setVisible(true);

		dao = new UsuarioDAO();
		Scanner teclado = new Scanner(System.in);
		
		while (true) {
			System.out.println();
			System.out.println("1) Cadastrar um usuário");
			System.out.println("2) Autenticar um usuário");
			System.out.println("3) Encerrar");
			System.out.print("Escolha uma opção: ");
			int escolha = teclado.nextInt();
			teclado.nextLine();

			if (escolha == 1) {
				cadastrarUsuario(teclado);
			}
			else if (escolha == 2) {
				autenticarUsuario(teclado);
			}
			else {
				break;
			}
		}
		System.out.println("Ok, tenha um bom dia!");
		teclado.close();
	}

	private static void cadastrarUsuario(Scanner teclado) {
		System.out.print("Digite o nome a ser cadastrado: ");
		String nome = teclado.nextLine();

		System.out.print("Digite o email a ser cadastrado: ");
		String email = teclado.nextLine();

		System.out.print("Digite a senha a ser cadastrada: ");
		String senha = teclado.nextLine();
		String hash = GerenciadorSenhas.codificar(senha);

		Usuario u = new Usuario(0, nome, email, hash);
		dao.salvar(u);

		System.out.println("Email do usuário: " + email);
		System.out.println("Hash da senha: " + hash);
	}

	private static void autenticarUsuario(Scanner teclado) {
		System.out.print("Digite o email do usuário: ");
		String email = teclado.nextLine();
		
		Usuario u = dao.buscar(email);
		String hashSenhaOriginal = u.getSenha();

		System.out.print("Digite a senha do usuário: ");
		String senha = teclado.nextLine();

		if (GerenciadorSenhas.autenticar(senha, hashSenhaOriginal)) {
			System.out.println("A senha está correta!");
		}
		else {
			System.out.println("A senha está incorreta. :(");
		}
	}

}
