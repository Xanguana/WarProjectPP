package principal;

/**
 * @author aline
 * @author leandro
 * @version 1.0 Classe utilizada especificamente para dar nome as cores
 *          pré-definidas no jogo
 */

public class Cor {

	private String nome_cor;
	private boolean usado;

	/**
	 * Método construtor
	 * 
	 * @param nome
	 *            nome das cores que o jogo possui
	 * @param usado
	 *            variável definida para verificar se uma cor já foi usada ou
	 *            não
	 * 
	 */

	public Cor(String nome, boolean usado) {
		this.nome_cor = nome;
		this.usado = usado;
	}

	// gets e sets

	public String getNome_cor() {
		return nome_cor;
	}

	public void setNome_cor(String nome_cor) {
		this.nome_cor = nome_cor;
	}

	public boolean isUsado() {
		return usado;
	}

	public void setUsado(boolean usado) {
		this.usado = usado;
	}
}
