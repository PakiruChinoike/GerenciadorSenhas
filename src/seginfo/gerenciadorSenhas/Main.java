package seginfo.gerenciadorSenhas;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		while (true) {
			System.out.println();
			System.out.println("1) Codificar uma senha");
			System.out.println("2) Autenticar uma senha");
			System.out.println("3) Encerrar");
			System.out.print("Escolha uma opção: ");
			int escolha = teclado.nextInt();
			teclado.nextLine();

			if (escolha == 1) {
				System.out.print("Digite a senha a ser codificada: ");
				String senha = teclado.nextLine();
				String hash = GerenciadorSenhas.codificar(senha);
				System.out.println("Hash da senha: " + hash);
			}
			else if (escolha == 2) {
				System.out.print("Digite o hash da senha original: ");
				String hashSenhaOriginal = teclado.nextLine();
				System.out.print("Digite a senha a ser autenticada: ");
				String senha = teclado.nextLine();
				if (GerenciadorSenhas.autenticar(senha, hashSenhaOriginal)) {
					System.out.println("A senha está correta!");
				}
				else {
					System.out.println("A senha está incorreta. :(");
				}
			}
			else {
				break;
			}
		}
		System.out.println("Ok, tenha um bom dia!");
		teclado.close();
	}

}
