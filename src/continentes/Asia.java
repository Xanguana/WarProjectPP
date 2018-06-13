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

public class Asia extends Continente {

	/**
	 * @param paises
	 *            ArrayList com seu respectivo id
	 * 
	 *            Método contrutor para retorno dos países do continente
	 */

	public Asia(ArrayList<Pais> paises) {
		this.setNome("Asia");
		this.adicionaPaises(paises.get(16));
		this.adicionaPaises(paises.get(17));
		this.adicionaPaises(paises.get(18));
		this.adicionaPaises(paises.get(19));
	}
}
