package continentes;

import java.util.ArrayList;

import principal.Pais;

/**
 * @author aline
 * @author leandro
 * @version 1.0
 * 
 *          Classe utilizada para definir em cada continentes os paises que lhe
 *          pertence
 */

public class Oceania extends Continente {

	/**
	 * @param paises
	 *            ArrayList com seu respectivo id
	 * 
	 *            Método contrutor para retorno dos países do continente
	 */

	public Oceania(ArrayList<Pais> paises) {
		this.setNome("Oceania");
		this.adicionaPaises(paises.get(20));
		this.adicionaPaises(paises.get(21));
		this.adicionaPaises(paises.get(22));
		this.adicionaPaises(paises.get(23));
	}

}
