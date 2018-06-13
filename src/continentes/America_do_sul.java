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

public class America_do_sul extends Continente {

	/**
	 * @param paises
	 *            ArrayList com seu respectivo id
	 * 
	 *            Método contrutor para retorno dos países do continente
	 */

	public America_do_sul(ArrayList<Pais> paises) {

		this.setNome("America do Sul");
		this.adicionaPaises(paises.get(0));
		this.adicionaPaises(paises.get(1));
		this.adicionaPaises(paises.get(2));
		this.adicionaPaises(paises.get(3));
	}

}
