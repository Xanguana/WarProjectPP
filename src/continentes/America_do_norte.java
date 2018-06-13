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

public class America_do_norte extends Continente {

	/**
	 * @param paises
	 *            ArrayList com seu respectivo id
	 * 
	 *            Método contrutor para retorno dos países do continente
	 */

	public America_do_norte(ArrayList<Pais> paises) {
		this.setNome("America do Norte");
		this.adicionaPaises(paises.get(4));
		this.adicionaPaises(paises.get(5));
		this.adicionaPaises(paises.get(6));
		this.adicionaPaises(paises.get(7));
	}

}
