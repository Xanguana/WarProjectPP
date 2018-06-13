package militares;

/**
 * @author aline
 * @author leandro
 * @version 1.0
 * 
 *          Classe utilizada para definir quais os nomes, pontos e a quantidade
 *          dos militares no jogo
 *
 */

public class Militar {

	private String tipo;
	private int pontos;
	private int quantidade;

	/**
	 * 
	 * @param tipo
	 *            tipo de militar
	 * @param pts
	 *            quantidade de ponto que o militar possui
	 * @param quantidade
	 *            valor total de cada militar
	 * 
	 *            Método construtor para acesso ao tipo, pontos e quantidade dos
	 *            militares
	 */

	public Militar(String tipo, int pts, int quantidade) {
		this.tipo = tipo;
		this.pontos = pts;
		this.quantidade = quantidade;
	}

	public void adicionaQuantidade(int qtd) {
		this.quantidade += qtd;
	}

	// gets e sets

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade += quantidade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
}
