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

public class Africa extends Continente {

	/**
	 * @param paises
	 *            ArrayList com seu respectivo id
	 * 
	 *            Método contrutor para retorno dos países do continente
	 */

	public Africa(ArrayList<Pais> paises) {
		this.setNome("Africa");
		this.adicionaPaises(paises.get(12));
		this.adicionaPaises(paises.get(13));
		this.adicionaPaises(paises.get(14));
		this.adicionaPaises(paises.get(15));
	}

}
