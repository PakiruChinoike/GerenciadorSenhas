package seginfo.gerenciadorSenhas;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
	private MessageDigest gerador;
	
	public Hash(String algoritmo) {
		try {
			gerador = MessageDigest.getInstance(algoritmo);
		} catch (NoSuchAlgorithmException e) {
			System.err.printf("O algoritmo %s não é suportado, encerrando!",
				algoritmo);
			System.exit(1);
		}
	}

	public String codificar(String s, String sal) {
		String cod = sal+s;

        byte[] bString = gerador.digest(cod.getBytes());
		String hexString = "";
		for (byte b: bString) {
			hexString += String.format("%02x", b);
		}

		return sal + "$" + hexString;
	}
}
