package seginfo.gerenciadorSenhas;

import java.util.concurrent.ThreadLocalRandom;

public class GerenciadorSenhas {
	public static String codificar(String senha) {
		int sal = ThreadLocalRandom.current().nextInt();
		String s = String.format("%016x", sal);

		Hash h = new Hash("SHA-1");
		return h.codificar(senha, s);
	}
	
	public static boolean autenticar(String senha, String hash) {
		Hash h = new Hash("SHA-1");
		String[] parts = hash.split("\\$");
		String sal = parts[0];

		String tentativa = h.codificar(senha, sal);

		return hash.equals(tentativa);
	}
}
