package br.com.mootit.comparators;

import java.util.Comparator;

import br.com.mootit.models.Nave;

public class NaveComparator implements Comparator<Nave> {

	public int compare(Nave o1, Nave o2) {
		return o1.getNome().compareTo(o2.getNome());
	}


}
