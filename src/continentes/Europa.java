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

public class Europa extends Continente {

	/**
	 * @param paises
	 *            ArrayList com seu respectivo id
	 * 
	 *            Método contrutor para retorno dos países do continente
	 */

	public Europa(ArrayList<Pais> paises) {
		this.setNome("Europa");
		this.adicionaPaises(paises.get(8));
		this.adicionaPaises(paises.get(9));
		this.adicionaPaises(paises.get(10));
		this.adicionaPaises(paises.get(11));
	}

}
