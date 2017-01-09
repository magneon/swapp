package br.com.mootit.comparators;

import java.util.Comparator;

import br.com.mootit.models.Tripulante;

public class TripulanteComparator implements Comparator<Tripulante> {

	public int compare(Tripulante o1, Tripulante o2) {
		return o1.getNome().compareTo(o2.getNome());
	}

}
