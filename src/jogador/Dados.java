package jogador;

import java.util.Random;

/**
 * @author aline
 * @author leandro
 * @version 1.0
 * 
 *          Classe utilizada para jogar o dado, neste caso define aleatoriamente
 *          as faces
 */

public class Dados {

	Random gerador = new Random();

	public int jogar_dado() {
		return gerador.nextInt(6);
	}
}
