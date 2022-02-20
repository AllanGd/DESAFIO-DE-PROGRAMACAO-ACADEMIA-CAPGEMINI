package br.com.capgemini.desafio;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Classe onde estão todos os métodos referente as 3 questões no desafio de
 * programação da academia capgemini.
 * 
 * @author Allan Gedeão
 */
public class Desafios {
	/**
	 * Questão 1 Criar uma escada feita de *.
	 * 
	 * @param n - Valor inteiro de referencia que será utilizado como base para a
	 *          altura da escada de caracteres.
	 */
	public void questao1(int n) {

		String resultado = "";
		int falta = 0;

		// Geretidor que irá montar a resposta.
		for (int i = 0; i < n; i++) {
			// Construtor que insere os espaços na resposta.
			for (int l = 1; l < n - i; l++) {
				resultado = resultado + " ";
			}
			// Construtor que insere os espaços na resposta.
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
	 * Questão 2 verificar se uma senha atende aos requisitos.
	 * 
	 * @param senha - String que será análisada pelo algoritmo.
	 */
	public void questao2(String senha) {
		final int MIN_CARACTERES = 6; // O mínimo de caracteres que a senha pode ter.
		char[] senhaArr = senha.toCharArray();
		// Criação da lista de array que terá todas as frases de retorno caso a senha
		// não atenda ao requisitos.
		ArrayList<String> validador = new ArrayList<>();
		validador.add("A senha tem que ter no mínimo 6 caracteres.");
		validador.add("A senha deve conter no minimo 1 digito.");
		validador.add("A senha deve conter no minimo 1 letra em minúsculo.");
		validador.add("A senha deve conter no minimo 1 letra em maiúsculo.");
		validador.add("A senha deve conter no minimo 1 caractere especial. Os caracteres especiais são: !@#$%^&*()-+");
		int caracteres = senha.length(); // Variavel com o numero de caracteres da senha.
		// Verificação de o numero de caracteres da senha atende a quantidade mínima
		// exigida.
		if (caracteres > MIN_CARACTERES) {
			validador.set(0, null);
		} else {
			validador.set(0,
					"A senha tem que ter nó mínimo 6 caracteres, insira mais " + (6 - caracteres) + " caracteres.");
		}
		// Repetidor que irá fazer a verificação de cada caracteres da senha.
		for (int i = 0; i < senha.length(); i++) {
			// Verifica se o caractere é num numero.
			if (Character.isDigit(senhaArr[i])) {
				validador.set(1, null);
			}
			// Verifica se o caractere é uma letra.
			if (Character.isAlphabetic(senhaArr[i])) {
				// Verifica se a letra é maiúscula.
				if (!Character.isUpperCase(senhaArr[i])) {
					validador.set(2, null); // Ação tomada caso a letra seja minúscila.
				} else {
					validador.set(3, null); // Ação tomada caso a letra seja maiúscula.
				}
			} else {
				// Verifica se o caractere é um dos caracteres especiais do conjunto
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
		// Verificar se a senha é forte
		if (cont == validador.size()) {
			System.out.println("Senha Forte."); // Se a quantidade de null for igual a quantidade de caracteres da senha
												// então a senha atende a todos os requisitos.
		} else {
			for (String va : validador) { // Se a senha não atendeu a todos os requisitos o for ira enviar todas as
											// frases de cada requisito não atendido.
				if (va != null) {
					System.out.println(va);
				}
			}
		}
	}

	/**
	 * Questão 3 Verificar quantos anagramas existe dentro de uma palavra.
	 * 
	 * @param palavra - String que será análisado a fim de encontrar quantos
	 *                anagramas existe dentro dela.
	 */
	public void questao3(String palavra) {
		int count = 0; // Contador que irá receber a quantidade de anagrama encontrado.

		for (int i = 0; i < palavra.length() - 1; i++) { // coleta o primeiro caractere que será análisado.
			for (int j = i; j < palavra.length(); j++) { // coleta o segundo caractere que será análisado.
				if (palavra.charAt(i) == palavra.charAt(j) && i != j) { // Verifica se são iguais mas que não seja o
																		// mesmo caractere da string.
					count++; // Se for um anagrama soma +1 ao contador.
					if (i + 1 != j) {
						char[] subString1 = palavra.substring(i, j).toCharArray(); // Coleta a subtring de i á J.
						char[] subString2 = palavra.substring(i + 1, j + 1).toCharArray(); // Coleta a proxima
																							// substring.
						Arrays.sort(subString1); // Organiza a subString1.
						Arrays.sort(subString2); // Organiza a subString2.
						if (Arrays.equals(subString1, subString2)) { // Verifica se as duas substring são anagramas..
							count++; // Se for um anagrama soma +1 ao contador.
						}
					}
				}
			}
		}
		System.out.println(count); // retorna a quantidade de anagramas encontrada.
	}
}
