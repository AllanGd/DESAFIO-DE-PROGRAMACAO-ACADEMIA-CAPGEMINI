package br.com.capgemini.desafio;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Classe onde est�o todos os m�todos referente as 3 quest�es no desafio de
 * programa��o da academia capgemini.
 * 
 * @author Allan Gede�o
 */
public class Desafios {
	/**
	 * Quest�o 1 Criar uma escada feita de *.
	 * 
	 * @param n - Valor inteiro de referencia que ser� utilizado como base para a
	 *          altura da escada de caracteres.
	 */
	public void questao1(int n) {

		String resultado = "";
		int falta = 0;

		// Geretidor que ir� montar a resposta.
		for (int i = 0; i < n; i++) {
			// Construtor que insere os espa�os na resposta.
			for (int l = 1; l < n - i; l++) {
				resultado = resultado + " ";
			}
			// Construtor que insere os espa�os na resposta.
			falta = n - resultado.length();
			for (int j = 0; j < falta; j++) {
				resultado = resultado + "*";
			}
			// Imprime o resultado.
			System.out.println(resultado);
			resultado = "";
		}

	}

	/**
	 * Quest�o 2 verificar se uma senha atende aos requisitos.
	 * 
	 * @param senha - String que ser� an�lisada pelo algoritmo.
	 */
	public void questao2(String senha) {
		final int MIN_CARACTERES = 6; // O m�nimo de caracteres que a senha pode ter.
		char[] senhaArr = senha.toCharArray();
		// Cria��o da lista de array que ter� todas as frases de retorno caso a senha
		// n�o atenda ao requisitos.
		ArrayList<String> validador = new ArrayList<>();
		validador.add("A senha tem que ter no m�nimo 6 caracteres.");
		validador.add("A senha deve conter no minimo 1 digito.");
		validador.add("A senha deve conter no minimo 1 letra em min�sculo.");
		validador.add("A senha deve conter no minimo 1 letra em mai�sculo.");
		validador.add("A senha deve conter no minimo 1 caractere especial. Os caracteres especiais s�o: !@#$%^&*()-+");
		int caracteres = senha.length(); // Variavel com o numero de caracteres da senha.
		// Verifica��o de o numero de caracteres da senha atende a quantidade m�nima
		// exigida.
		if (caracteres > MIN_CARACTERES) {
			validador.set(0, null);
		} else {
			validador.set(0,
					"A senha tem que ter n� m�nimo 6 caracteres, insira mais " + (6 - caracteres) + " caracteres.");
		}
		// Repetidor que ir� fazer a verifica��o de cada caracteres da senha.
		for (int i = 0; i < senha.length(); i++) {
			// Verifica se o caractere � num numero.
			if (Character.isDigit(senhaArr[i])) {
				validador.set(1, null);
			}
			// Verifica se o caractere � uma letra.
			if (Character.isAlphabetic(senhaArr[i])) {
				// Verifica se a letra � mai�scula.
				if (!Character.isUpperCase(senhaArr[i])) {
					validador.set(2, null); // A��o tomada caso a letra seja min�scila.
				} else {
					validador.set(3, null); // A��o tomada caso a letra seja mai�scula.
				}
			} else {
				// Verifica se o caractere � um dos caracteres especiais do conjunto
				// !@#$%^&*()-+]*".
				if (Character.toString(senha.charAt(i)).matches("[!@#$%^&*()-+]*")) {
					validador.set(4, null);
				}
			}
		}
		int cont = 0;
		// Contabiliza quantos "null" contem no validador.
		for (String r : validador) {
			if (r == null) {
				cont++;
			}
		}
		// Verificar se a senha � forte
		if (cont == validador.size()) {
			System.out.println("Senha Forte."); // Se a quantidade de null for igual a quantidade de caracteres da senha
												// ent�o a senha atende a todos os requisitos.
		} else {
			for (String va : validador) { // Se a senha n�o atendeu a todos os requisitos o for ira enviar todas as
											// frases de cada requisito n�o atendido.
				if (va != null) {
					System.out.println(va);
				}
			}
		}
	}

	/**
	 * Quest�o 3 Verificar quantos anagramas existe dentro de uma palavra.
	 * 
	 * @param palavra - String que ser� an�lisado a fim de encontrar quantos
	 *                anagramas existe dentro dela.
	 */
	public void questao3(String palavra) {
		int count = 0; // Contador que ir� receber a quantidade de anagrama encontrado.

		for (int i = 0; i < palavra.length() - 1; i++) { // coleta o primeiro caractere que ser� an�lisado.
			for (int j = i; j < palavra.length(); j++) { // coleta o segundo caractere que ser� an�lisado.
				if (palavra.charAt(i) == palavra.charAt(j) && i != j) { // Verifica se s�o iguais mas que n�o seja o
																		// mesmo caractere da string.
					count++; // Se for um anagrama soma +1 ao contador.
					if (i + 1 != j) {
						char[] subString1 = palavra.substring(i, j).toCharArray(); // Coleta a subtring de i � J.
						char[] subString2 = palavra.substring(i + 1, j + 1).toCharArray(); // Coleta a proxima
																							// substring.
						Arrays.sort(subString1); // Organiza a subString1.
						Arrays.sort(subString2); // Organiza a subString2.
						if (Arrays.equals(subString1, subString2)) { // Verifica se as duas substring s�o anagramas..
							count++; // Se for um anagrama soma +1 ao contador.
						}
					}
				}
			}
		}
		System.out.println(count); // retorna a quantidade de anagramas encontrada.
	}
}
