package br.com.capgemini.desafio;

/**
 * Classe principal que será responsavel por chamar os métodos da questões do
 * desafio de programação.
 * 
 * @author Allan Gedeão
 * @version 1.0.0
 * @since 1.0.0 (Release)
 */
public class Main {
	/**
	 * Utilize o método Main para instanciar a classe desafio e ter acesso aos
	 * métodos referente as questões.
	 * 
	 * @param args - Parametro de entrada da método main.
	 */
	public static void main(String[] args) {
		Desafios desafio = new Desafios(); // Instanciado a classe Desafio.

		desafio.questao1(6); // Invocando o método questao1 (escada de *)
		desafio.questao2("e3"); // Invocando o método questao2 (validação de senha)
		desafio.questao3("ovo"); // Invocando o método questao3 (verificação de anagrama)

	}

}
