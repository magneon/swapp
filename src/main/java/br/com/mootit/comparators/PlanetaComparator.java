package br.com.mootit.comparators;

import java.util.Comparator;

import br.com.mootit.models.Planeta;

public class PlanetaComparator implements Comparator<Planeta> {

	public int compare(Planeta o1, Planeta o2) {
		return o1.getNome().compareTo(o2.getNome());
	}

}
