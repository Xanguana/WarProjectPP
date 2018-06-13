package principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import africa.Angola;
import africa.Camaroes;
import africa.CostaMarfim;
import africa.Egito;
import america_do_norte.Canada;
import america_do_norte.Dinamarca;
import america_do_norte.EstadosUnidos;
import america_do_norte.Mexico;
import america_do_sul.Argentina;
import america_do_sul.Bolivia;
import america_do_sul.Brasil;
import america_do_sul.Venezuela;
import asia.Afeganistao;
import asia.China;
import asia.CoreiaSul;
import asia.India;
import continentes.Africa;
import continentes.America_do_norte;
import continentes.America_do_sul;
import continentes.Asia;
import continentes.Continente;
import continentes.Europa;
import continentes.Oceania;
import europa.Espanha;
import europa.Inglaterra;
import europa.Italia;
import europa.Russia;
import jogador.Jogador;
import oceania.Australia;
import oceania.Fiji;
import oceania.Indonesia;
import oceania.NovaZelandia;

/**
 * @author aline
 * @author leandro
 * @version 1.0
 * 
 *          Classe utilizada para controle total do tabuleiro. Nela se encontra
 *          as principais responsabilidades para determinar o tabuleiro em sua
 *          forma para inicio do jogo.
 *
 */

public class Tabuleiro {

	/**
	 * Construtor
	 */

	public Tabuleiro() {
	}

	private ArrayList<Objetivos> obj;
	private ArrayList<Cor> cores;
	private ArrayList<Jogador> jogadores;
	private ArrayList<Pais> paises;
	private int quantidadeTerritorios = 0;
	private int nro_players = 0;
	private Scanner inputint = new Scanner(System.in);
	public Random rand = new Random();
	public Scanner inputString = new Scanner(System.in);
	private boolean gameOver = false;

	/**
	 * 
	 * @param jogadores
	 * @param paises
	 * 
	 *            Método que define para cada jogador seus territórios sendo 24
	 *            o total de territorios no qual por pré-requisito é feito a
	 *            divisão de 24 / pelo numero de jogadores. Todo o processo é
	 *            feito de forma aleatoria então nunca se sabe quem vai ficar
	 *            com tal territorio. Os paises sao controlados por id, entao no
	 *            if já é definido que um determinado pais já está ocupado e o
	 *            total de territorios que o jogador possui, ou seja na medida
	 *            que ele vai conquistanto mais territorios vai sendo verificado
	 */

	public void define_territorio(ArrayList<Jogador> jogadores, ArrayList<Pais> paises) {
		int territoriosTotal = 24;
		int id;
		Random rand = new Random();
		quantidadeTerritorios = territoriosTotal / jogadores.size();
		for (int i = 0; i < jogadores.size(); i++) {
			for (int j = 0; j < quantidadeTerritorios;) {
				id = rand.nextInt(24);
				if (paises.get(id).isOcupado() == false) {
					jogadores.get(i).addPaises(paises.get(id));
					jogadores.get(i).setQuantidade_territorios(1);
					paises.get(id).setOcupado(true);
					paises.get(id).setJogador(jogadores.get(i));
					jogadores.get(i).setQuantidade_territorios(1);
					j++;
				}
			}
		}
	}

	/**
	 * @see Continente()
	 * @see America_do_norte(), America_do_sul(), Asia(), Europa(), Oceania()
	 * 
	 *      Instância de todos os continentes para construir o tabuleiro, todos
	 *      já referenciados em um ArrayList. Para cada instancia já é definido
	 *      nas classes quais paises fazem parte de tal continente, pois é fixo,
	 *      nunca vai mudar
	 */

	public void carregaMundo() {
		Continente americaSul = new America_do_sul(paises);
		Continente americaNort = new America_do_norte(paises);
		Continente asia = new Asia(paises);
		Continente africa = new Africa(paises);
		Continente oceania = new Oceania(paises);
		Continente europa = new Europa(paises);

	}

	/**
	 * Método utilizado para determinar para o tabuleiro quais são os paises que
	 * o formam e seus indices
	 */

	public void carregaPaises() {
		paises = new ArrayList<Pais>();
		// America do Sul
		paises.add(new Brasil("Brasil", 0));
		paises.add(new Argentina("Argentina", 1));
		paises.add(new Bolivia("Bolivia", 2));
		paises.add(new Venezuela("Venezuela", 3));
		// America do Norte
		paises.add(new Canada("Canada", 4));
		paises.add(new Mexico("Mexico", 5));
		paises.add(new EstadosUnidos("EUA", 6));
		paises.add(new Dinamarca("Dinamarca", 7));
		// Europa
		paises.add(new Inglaterra("Inglaterra", 8));
		paises.add(new Italia("Itália", 9));
		paises.add(new Espanha("Espanha", 10));
		paises.add(new Russia("Russia", 11));
		// Africa
		paises.add(new Angola("Angola", 12));
		paises.add(new Egito("Egito", 13));
		paises.add(new Camaroes("Camarões", 14));
		paises.add(new CostaMarfim("Costa do Marfim", 15));
		// Asia
		paises.add(new China("China", 16));
		paises.add(new India("India", 17));
		paises.add(new CoreiaSul("Coreia do Sul", 18));
		paises.add(new Afeganistao("Afeganistão", 19));
		// Oceania
		paises.add(new Australia("Austrália", 20));
		paises.add(new Indonesia("Indonesia", 21));
		paises.add(new NovaZelandia("Nova Zelândia", 22));
		paises.add(new Fiji("Fiji", 23));
	}

	/**
	 * @see Objetivos()
	 * 
	 *      Instancia de todos os objetivos do jogo sendo adicionados ao
	 *      arraylist 'obj'
	 */

	public void carregaObjetivos() {
		obj = new ArrayList<Objetivos>();
		obj.add(new Objetivos(1, "Conquistar na totalidade a América do Sul e a Europa.", false));
		obj.add(new Objetivos(2, "Conquistar a Oceania e mais um continente a sua escolha.", false));
		obj.add(new Objetivos(3, "Conquistar 24 territórios.", false));
		obj.add(new Objetivos(4, "Conquistar a América do norte e a África (continente).", false));
		obj.add(new Objetivos(5, "Conquistar a Ásia e outro continente da sua escolha.", false));
		obj.add(new Objetivos(6, "Conquistar a Oceania, América do Sul e outro continente da sua escolha.", false));
		obj.add(new Objetivos(7,
				"Destruir o exército preto, se for você o exército preto ou se ele não estiver no jogo, seu objetivo passa a ser conquistar 24 territórios.",
				false));
		obj.add(new Objetivos(8,
				"Destruir o exército branco, se for você o exército branco ou se ele não estiver no jogo, seu objetivo passa a ser conquistar 24 territórios.",
				false));
		obj.add(new Objetivos(9,
				"Destruir o exército azul, se for você o exército azul ou se ele não estiver no jogo, seu objetivo passa a ser conquistar 24 territórios.",
				false));
		obj.add(new Objetivos(10,
				"Destruir o exército amarelo, se for você o exército amarelo ou se ele não estiver no jogo, seu objetivo passa a ser conquistar 24 territórios.",
				false));
	}

	/**
	 * 
	 * @param nro_jogador
	 *            quantidade total de jogadores
	 * 
	 *            Neste método é definido ao jogador sua cor e seu objetivo. A
	 *            partir daí a cor escolhida já não pode mais ser usada. Os
	 *            territorios já sao definidos e já define todos os vizinhos e
	 *            alem disso pode ser definido para cada territorio os exeritos
	 *            de acordo em como o jogador irá organiza-los.
	 */

	public void carregaJogadores(int nro_jogador) {
		jogadores = new ArrayList<Jogador>();
		for (int i = 0; i < nro_jogador; i++) {
			jogadores.add(new Jogador(i + 1));
			defineCor(jogadores.get(i));
			defineObjetivo(jogadores.get(i));
		}
		define_territorio(jogadores, paises);
		// defineVisinho();
		Pais pais = new Pais();
		pais.defineVizinho(paises);
		for (int j = 0; j < nro_jogador; j++) {
			jogadores.get(j).definirExercito(quantidadeTerritorios);
		}
		// Embaralha a ordem dos jogadores
		Collections.shuffle(jogadores);
	}

	/**
	 * @param jogador
	 * 
	 *            Define o objetivo de forma aleatoria para cada jogador
	 */

	public void defineObjetivo(Jogador jogador) {
		int valor = rand.nextInt(9);
		if (obj.get(valor).isUsando()) {
			defineObjetivo(jogador);
		} else {
			jogador.setObj(obj.get(valor));
			obj.get(valor).setUsando(true);
		}
	}

	/**
	 * Método para carregar as cores disponíveis para início do jogo no
	 * tabuleiro
	 */

	public void carregaCores() {
		cores = new ArrayList<Cor>();
		cores.add(new Cor("Preto", false));
		cores.add(new Cor("Branco", false));
		cores.add(new Cor("Azul", false));
		cores.add(new Cor("Amarelo", false));
	}

	/**
	 * @param jogador
	 *            referência a classe Jogador()
	 * 
	 *            Método utilizado para que o jogador defina a cor de sua
	 *            preferência
	 */

	public void defineCor(Jogador jogador) {
		String cor;
		System.out.println(jogador.getNome() + " - Defina sua Cor: PRETO, BRANCO, AZUL, AMARELO");
		cor = inputString.next();
		if (cores.get(0).isUsado() == false && cor.equalsIgnoreCase("Preto")) {
			jogador.setCor(cor);
			cores.get(0).setUsado(true);
			System.out.println("Jogador " + jogador.getNome() + " jogara de " + jogador.getCor());
		} else if (cores.get(1).isUsado() == false && cor.equalsIgnoreCase("Branco")) {
			jogador.setCor(cor);
			cores.get(1).setUsado(true);
			System.out.println("Jogador " + jogador.getNome() + " jogara de " + jogador.getCor());
		} else if (cores.get(2).isUsado() == false && cor.equalsIgnoreCase("Azul")) {
			jogador.setCor(cor);
			cores.get(2).setUsado(true);
			System.out.println("Jogador " + jogador.getNome() + " jogara de " + jogador.getCor());
		} else if (cores.get(3).isUsado() == false && cor.equalsIgnoreCase("Amarelo")) {
			jogador.setCor(cor);
			cores.get(3).setUsado(true);
			System.out.println("Jogador " + jogador.getNome() + " jogara de " + jogador.getCor());
		} else {
			System.out.println("Cor já utilizada ou incorreta. Escolha outra cor. ");
			defineCor(jogador);
		}
	}

	/**
	 * Metodo usado para chamar todos os outros métodos que só faz o
	 * carregamento para funcionamento do tabuleiro além de já definir a
	 * quantidade de jogadores para iniciar o jogo de acordo com a inicialização
	 */

	public void loading() {
		carregaCores();
		carregaObjetivos();
		carregaPaises();
		carregaMundo();
		carregaJogadores(this.nro_players);
	}

	/**
	 * Método define a quantidade máxima de jogadores sendo no caso 5. Para cada
	 * quantidade de jogador é feito a verificação de acordo com os métodos que
	 * o tabuleiro executa. Cada Jogador possui um menu individual para
	 * determinar suas ações no jogo. Enquanto os jogadores vão atacando e
	 * alcançando os objetivos o jogo é executado até dar o game over
	 */

	public void inicio() {
		System.out.println("JOGO INICIADO");
		System.out.print("Informe o numero de jogadores:");
		nro_players = inputint.nextInt();
		loading();
		// Continente continente = new Continente();
		// continente.carregaContinente(mundo);
		// Jogo rodando
		while (gameOver != true) {
			if (nro_players == 1) {
				jogadores.get(0).menuIndividual();
				gameOver = jogadores.get(0).getObj().objetivoAlcançado(jogadores.get(0), paises);
			} else if (nro_players == 2) {
				jogadores.get(0).menuIndividual();
				gameOver = jogadores.get(0).getObj().objetivoAlcançado(jogadores.get(0), paises);
				jogadores.get(1).menuIndividual();
				gameOver = jogadores.get(1).getObj().objetivoAlcançado(jogadores.get(1), paises);
			} else if (nro_players == 3) {
				jogadores.get(0).menuIndividual();
				gameOver = jogadores.get(0).getObj().objetivoAlcançado(jogadores.get(0), paises);
				jogadores.get(1).menuIndividual();
				gameOver = jogadores.get(1).getObj().objetivoAlcançado(jogadores.get(1), paises);
				jogadores.get(2).menuIndividual();
				;
				gameOver = jogadores.get(2).getObj().objetivoAlcançado(jogadores.get(2), paises);
			} else if (nro_players == 4) {
				jogadores.get(0).menuIndividual();
				gameOver = jogadores.get(0).getObj().objetivoAlcançado(jogadores.get(0), paises);
				jogadores.get(1).menuIndividual();
				gameOver = jogadores.get(1).getObj().objetivoAlcançado(jogadores.get(1), paises);
				jogadores.get(2).menuIndividual();
				;
				gameOver = jogadores.get(2).getObj().objetivoAlcançado(jogadores.get(2), paises);
				jogadores.get(3).menuIndividual();
				gameOver = jogadores.get(3).getObj().objetivoAlcançado(jogadores.get(3), paises);
			} else {
				System.out.println("Erro no tabuleiro");
			}
		}
	}
}
