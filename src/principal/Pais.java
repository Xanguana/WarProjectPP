package principal;

import java.util.ArrayList;

import jogador.Jogador;
import militares.Cabo;
import militares.Militar;
import militares.Sargento;
import militares.Soldado;
import militares.Tenente;

/**
 * 
 * @author aline
 * @author leandro
 * @version 1.0
 * 
 *          Classe utilizada para definir os países que define um continente
 *          para consequentemente fomar o tabuleiro
 */

public class Pais {

	private int id;
	private String nome;
	private ArrayList<Pais> visinhos = new ArrayList<Pais>();
	private ArrayList<Militar> exercito = new ArrayList<Militar>();
	private Jogador jogador;
	private boolean ocupado = false;

	/**
	 * Construtor
	 */

	public Pais() {
	}

	/**
	 * 
	 * @param nome
	 *            para definir o nome do pais que forma determinado continente
	 * @param id
	 *            para controle dos paises
	 * 
	 *            Método contrutor que retorna para cada pais diferentes tipos
	 *            de exercitos
	 */

	public Pais(String nome, int id) {
		this.nome = nome;
		this.id = id;
		Soldado sld = new Soldado();
		Cabo cabo = new Cabo();
		Sargento sgt = new Sargento();
		Tenente tnt = new Tenente();
		exercito.add(sld);
		exercito.add(cabo);
		exercito.add(sgt);
		exercito.add(tnt);
	}

	/**
	 * @param paises
	 *            ArrayList para definir os vizinhos dos países
	 * 
	 *            Método para definir os vizinhos de cada país separadamente,
	 *            sendo possível garantir que o ataque seja realizado somente em
	 *            paises vizinhos e marítmos conforme regra do jogo. Foi
	 *            definido os vizinhos para todos os 24 países.
	 */

	public void defineVizinho(ArrayList<Pais> paises) {
		// Visinhos Brasil
		paises.get(0).adicionaVisinhos(paises.get(1));
		paises.get(0).adicionaVisinhos(paises.get(2));
		paises.get(0).adicionaVisinhos(paises.get(3));
		paises.get(0).adicionaVisinhos(paises.get(12));
		// Visinhos Argentina
		paises.get(1).adicionaVisinhos(paises.get(0));
		paises.get(1).adicionaVisinhos(paises.get(2));
		paises.get(1).adicionaVisinhos(paises.get(3));
		// Visinhos Bolivia
		paises.get(2).adicionaVisinhos(paises.get(0));
		paises.get(2).adicionaVisinhos(paises.get(1));
		paises.get(2).adicionaVisinhos(paises.get(3));
		// Visnhos Venezuela
		paises.get(3).adicionaVisinhos(paises.get(0));
		paises.get(3).adicionaVisinhos(paises.get(1));
		paises.get(3).adicionaVisinhos(paises.get(2));
		paises.get(3).adicionaVisinhos(paises.get(5));
		// Visinhos Canada
		paises.get(4).adicionaVisinhos(paises.get(5));
		paises.get(4).adicionaVisinhos(paises.get(6));
		paises.get(4).adicionaVisinhos(paises.get(7));
		// Visinhos Mexico
		paises.get(5).adicionaVisinhos(paises.get(3));
		paises.get(5).adicionaVisinhos(paises.get(4));
		paises.get(5).adicionaVisinhos(paises.get(6));
		paises.get(5).adicionaVisinhos(paises.get(7));
		// Visinhos EUA
		paises.get(6).adicionaVisinhos(paises.get(4));
		paises.get(6).adicionaVisinhos(paises.get(5));
		paises.get(6).adicionaVisinhos(paises.get(7));
		// Visinhos Dinamarca
		paises.get(7).adicionaVisinhos(paises.get(4));
		paises.get(7).adicionaVisinhos(paises.get(5));
		paises.get(7).adicionaVisinhos(paises.get(6));
		paises.get(7).adicionaVisinhos(paises.get(8));
		// Visinhos Inglaterra
		paises.get(8).adicionaVisinhos(paises.get(7));
		paises.get(8).adicionaVisinhos(paises.get(9));
		paises.get(8).adicionaVisinhos(paises.get(10));
		paises.get(8).adicionaVisinhos(paises.get(11));
		// Visinhos Italia
		paises.get(9).adicionaVisinhos(paises.get(8));
		paises.get(9).adicionaVisinhos(paises.get(10));
		paises.get(9).adicionaVisinhos(paises.get(11));
		paises.get(9).adicionaVisinhos(paises.get(15));
		// Visinhos Espanha
		paises.get(10).adicionaVisinhos(paises.get(8));
		paises.get(10).adicionaVisinhos(paises.get(9));
		paises.get(10).adicionaVisinhos(paises.get(11));
		paises.get(10).adicionaVisinhos(paises.get(13));
		// Visinhos Russia
		paises.get(11).adicionaVisinhos(paises.get(8));
		paises.get(11).adicionaVisinhos(paises.get(9));
		paises.get(11).adicionaVisinhos(paises.get(10));
		paises.get(11).adicionaVisinhos(paises.get(18));
		// Visinhos Angola
		paises.get(12).adicionaVisinhos(paises.get(13));
		paises.get(12).adicionaVisinhos(paises.get(14));
		paises.get(12).adicionaVisinhos(paises.get(15));
		paises.get(12).adicionaVisinhos(paises.get(0));
		// Visinhos Egito
		paises.get(13).adicionaVisinhos(paises.get(12));
		paises.get(13).adicionaVisinhos(paises.get(14));
		paises.get(13).adicionaVisinhos(paises.get(15));
		paises.get(13).adicionaVisinhos(paises.get(10));
		// Visinhos Camarões
		paises.get(14).adicionaVisinhos(paises.get(12));
		paises.get(14).adicionaVisinhos(paises.get(13));
		paises.get(14).adicionaVisinhos(paises.get(15));
		paises.get(14).adicionaVisinhos(paises.get(19));
		// Visinhos Costa do Marfim
		paises.get(15).adicionaVisinhos(paises.get(9));
		paises.get(15).adicionaVisinhos(paises.get(12));
		paises.get(15).adicionaVisinhos(paises.get(13));
		paises.get(15).adicionaVisinhos(paises.get(14));
		// Visinhos China
		paises.get(16).adicionaVisinhos(paises.get(17));
		paises.get(16).adicionaVisinhos(paises.get(18));
		paises.get(16).adicionaVisinhos(paises.get(19));
		paises.get(16).adicionaVisinhos(paises.get(23));
		// Visinhos India
		paises.get(17).adicionaVisinhos(paises.get(16));
		paises.get(17).adicionaVisinhos(paises.get(18));
		paises.get(17).adicionaVisinhos(paises.get(19));
		paises.get(17).adicionaVisinhos(paises.get(21));
		// Visinhos Coreia do Sul
		paises.get(18).adicionaVisinhos(paises.get(11));
		paises.get(18).adicionaVisinhos(paises.get(16));
		paises.get(18).adicionaVisinhos(paises.get(17));
		paises.get(18).adicionaVisinhos(paises.get(19));
		// Visinhos Afeganistão
		paises.get(19).adicionaVisinhos(paises.get(14));
		paises.get(19).adicionaVisinhos(paises.get(16));
		paises.get(19).adicionaVisinhos(paises.get(17));
		paises.get(19).adicionaVisinhos(paises.get(18));
		// Visinhos Australia
		paises.get(20).adicionaVisinhos(paises.get(21));
		paises.get(20).adicionaVisinhos(paises.get(22));
		paises.get(20).adicionaVisinhos(paises.get(23));
		// Visinhos Indonesia
		paises.get(21).adicionaVisinhos(paises.get(17));
		paises.get(21).adicionaVisinhos(paises.get(20));
		paises.get(21).adicionaVisinhos(paises.get(22));
		paises.get(21).adicionaVisinhos(paises.get(23));
		// Visinhos Nova Zelandia
		paises.get(22).adicionaVisinhos(paises.get(20));
		paises.get(22).adicionaVisinhos(paises.get(21));
		paises.get(22).adicionaVisinhos(paises.get(23));
		// Visinhos Fiji
		paises.get(23).adicionaVisinhos(paises.get(16));
		paises.get(23).adicionaVisinhos(paises.get(20));
		paises.get(23).adicionaVisinhos(paises.get(21));
		paises.get(23).adicionaVisinhos(paises.get(22));
	}

	// gets e sets

	public void adicionaVisinhos(Pais pais) {
		this.visinhos.add(pais);
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Pais> getVisinhos() {
		return visinhos;
	}

	public ArrayList<Militar> getExercito() {
		return exercito;
	}

	public void setExercito(ArrayList<Militar> exercito) {
		this.exercito = exercito;
	}

}
