package continentes;

import java.util.ArrayList;
import principal.Pais;

/**
 * @author aline
 * @author leandro
 * @versin 1.0
 * 
 *         Classe utilizada para definir os continentes e sua lista de países
 *         que o compoẽ
 *
 */
public class Continente {

	private String nome;
	private ArrayList<Pais> paises = new ArrayList<>();

	public void ganhaMilitares() {}

	// gets e sets

	public void adicionaPaises(Pais pais) {
		this.paises.add(pais);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Pais> getPaises() {
		return paises;
	}

	public void setPaises(ArrayList<Pais> paises) {
		this.paises = paises;
	}
}
