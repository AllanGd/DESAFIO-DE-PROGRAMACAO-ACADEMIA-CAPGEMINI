package br.com.capgemini.desafio;

/**
 * Classe principal que ser� responsavel por chamar os m�todos da quest�es do
 * desafio de programa��o.
 * 
 * @author Allan Gede�o
 * @version 1.0.0
 * @since 1.0.0 (Release)
 */
public class Main {
	/**
	 * Utilize o m�todo Main para instanciar a classe desafio e ter acesso aos
	 * m�todos referente as quest�es.
	 * 
	 * @param args - Parametro de entrada da m�todo main.
	 */
	public static void main(String[] args) {
		Desafios desafio = new Desafios(); // Instanciado a classe Desafio.

		desafio.questao1(6); // Invocando o m�todo questao1 (escada de *)
		desafio.questao2("e3"); // Invocando o m�todo questao2 (valida��o de senha)
		desafio.questao3("ovo"); // Invocando o m�todo questao3 (verifica��o de anagrama)

	}

}
