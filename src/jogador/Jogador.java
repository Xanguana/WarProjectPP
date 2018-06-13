package jogador;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import principal.Objetivos;
import principal.Pais;

public class Jogador {

	private String cor;
	private String nome;
	private Objetivos obj;
	private int escolhaMenu;
	private Vector<Integer> dadoATK;
	private Vector<Integer> dadoDEF;
	private Dados dados = new Dados();
	private int quantidade_territorios = 0;
	private ArrayList<Pais> paises = new ArrayList<>();
	Scanner scan = new Scanner(System.in);

	public Jogador(int id) {
		menuInicial(id);
	}

	public void definirExercito(int nro_soldados) {
		int opcao;
		int qtdsoldado;
		if (nro_soldados == 0) {
			return;
		}
		System.out.println("\n" + this.nome + " voce ainda tem " + nro_soldados + " soldados disponiveis.");
		System.out.println("Seus territorios e quantidades de soldados presentes: ");
		System.out.println("Pais    [Sdo.]");
		for (int i = 0; i < paises.size(); i++) {
			System.out.println((i + 1) + ")" + paises.get(i).getNome() + "["
					+ paises.get(i).getExercito().get(0).getQuantidade() + "] ");
		}
		System.out.println("\nEscolha um territorio e quantos soldados para cada ele:");
		opcao = scan.nextInt();
		qtdsoldado = scan.nextInt();
		if (qtdsoldado <= 0 || qtdsoldado > nro_soldados || opcao > paises.size()) {
			definirExercito(nro_soldados);
		} else {
			paises.get(opcao - 1).getExercito().get(0).adicionaQuantidade(qtdsoldado);
			nro_soldados -= qtdsoldado;
			if (nro_soldados > 0) {
				definirExercito(nro_soldados);
			}
		}
	}

	public void verTerritorios() {
		System.out.println("Seus territorios e exercitos: \n");
		System.out.println("Pais   [Sdo.][Cab.][Sgt][Ten]");
		for (int i = 0; i < paises.size(); i++) {
			System.out.println(
					(i + 1) + ")" + paises.get(i).getNome() + "[" + paises.get(i).getExercito().get(0).getQuantidade()
							+ "]" + "[" + paises.get(i).getExercito().get(1).getQuantidade() + "]" + "["
							+ paises.get(i).getExercito().get(2).getQuantidade() + "]" + "["
							+ paises.get(i).getExercito().get(3).getQuantidade() + "]");
		}
		System.out.println();
	}

	/**
	 * 
	 */

	public void ataque() {
		verTerritorios();
		System.out.println("Escolha uma região atacante: ");
		int atacante = scan.nextInt();
		atacante -= 1;
		System.out.println("Escolha um alvo entre os abaixos: ");
		for (int j = 0; j < paises.get(atacante).getVisinhos().size(); j++) {
			if (paises.get(atacante).getVisinhos().get(j).getJogador().getNome() != paises.get(atacante).getJogador()
					.getNome()) {
				System.out.println(j + ")" + paises.get(atacante).getVisinhos().get(j).getNome());
			}
		}
		int alvo = scan.nextInt();
		System.out.println("Com qual exercito pretende atacar: ");
		for (int k = 0; k < paises.get(atacante).getExercito().size(); k++) {
			System.out.println((k + 1) + ")" + paises.get(atacante).getExercito().get(k).getTipo() + "["
					+ paises.get(atacante).getExercito().get(k).getQuantidade() + "]");
		}
		int opcaoExercito = scan.nextInt();
		opcaoExercito -= 1;
		System.out.println(
				"Com quantos " + paises.get(atacante).getExercito().get(opcaoExercito).getTipo() + " pretende atacar:");
		int soldadosAtacantes = scan.nextInt();
		if (soldadosAtacantes > paises.get(atacante).getExercito().get(opcaoExercito).getQuantidade()) {
			System.out.println(
					"Voce não tem essa força de ataque, tente outra vez com um numero menor que o total dos seus soldados");
			ataque();
		} else {
			Pais paisAlvo = paises.get(atacante).getVisinhos().get(alvo);
			combate(soldadosAtacantes, paisAlvo, paises.get(atacante), opcaoExercito);
		}
	}

	public void combate(int numero_dados, Pais alvo, Pais atacante, int opcaoatk) {
		dadoATK = new Vector<>();
		dadoDEF = new Vector<>();
		for (int i = 0; i < numero_dados; i++) {
			dadoATK.add(dados.jogar_dado());
		}
		for (int i = 0; i < numero_dados; i++) {
			dadoDEF.add(dados.jogar_dado());
		}
		dadoATK.sort(null);
		dadoDEF.sort(null);
		System.out.println("ATK " + dadoATK + " x " + dadoDEF + " DEF");
		for (int r = 0; r < numero_dados || alvo.getExercito().get(0).getQuantidade() > 0; r++) {
			if (dadoATK.get(r) <= dadoDEF.get(r)) {
				atacante.getExercito().get(opcaoatk).setQuantidade(-1);
			} else {
				alvo.getExercito().get(0).setQuantidade(-1);
			}
		}
		if (alvo.getExercito().get(0).getQuantidade() <= 0) {
			System.out.println("Pais atacante vencedor, " + alvo.getNome() + " sera adicionado aos seus territorios.");
			this.paises.add(alvo);
			this.quantidade_territorios = this.quantidade_territorios + 1;
			removePais(alvo);
			atacante.getExercito().get(opcaoatk).setQuantidade(-1);
			alvo.getExercito().get(0).setQuantidade(1);

		} else {
			System.out.println("Pais " + alvo.getNome() + " sobreviveu ao ataque");
			removePais(atacante);
		}
		menuIndividual();
	}

	public void removePais(Pais remover) {
		Jogador joga = remover.getJogador();
		remover.getJogador().quantidade_territorios -= 1;
		System.out.println("Perdedor: " + remover.getJogador().getNome().toString());
		for (int i = 0; i < joga.getPaises().size(); i++) {
			if (joga.getPaises().get(i).getNome() == remover.getNome()) {
				joga.getPaises().remove(i);
			}
		}
	}

	public void menuIndividual() {
		this.getObj().objetivoAlcançado(this, this.paises);
		System.out.println("\nJogador " + this.getNome() + " faça sua escolha:\n" + "1) Ver Territorios.\n"
				+ "2) Atacar.\n" + "3) Passar a vez.\n");
		escolhaMenu = scan.nextInt();
		switch (escolhaMenu) {
		case 1:
			this.verTerritorios();
			this.menuIndividual();
			break;
		case 2:
			this.ataque();
			break;
		case 3:
			return;
		default:
			System.out.println("Numero inválido !");
			this.menuIndividual();
			break;
		}
	}

	public void menuInicial(int id) {
		System.out.println("Favor digitar o nome do jogador " + id + ": ");
		this.nome = scan.nextLine();
	}

	// Getters ands Seters
	public int getQuantidade_territorios() {
		return quantidade_territorios;
	}

	public void setQuantidade_territorios(int quantidade_territorios) {
		this.quantidade_territorios += quantidade_territorios;
	}

	public void setPaises(ArrayList<Pais> paises) {
		this.paises = paises;
	}

	public ArrayList<Pais> getPaises() {
		return paises;
	}

	public void addPaises(Pais pais) {
		this.paises.add(pais);
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Objetivos getObj() {
		return obj;
	}

	public void setObj(Objetivos obj) {
		this.obj = obj;
	}

}
