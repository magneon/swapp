package br.com.mootit.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.mootit.comparators.TripulanteComparator;
import br.com.mootit.models.Tripulante;
import br.com.mootit.util.StarWarsUtil;

@SessionScoped
@ManagedBean
public class TripulacaoController extends BaseController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<Tripulante> tripulantes;
	
	private Tripulante tripulante;

	public void listaTripulacao() {
		tripulantes = new ArrayList<Tripulante>();
		StarWarsUtil.listaTripulacao(tripulantes, false);
	}

	public List<Tripulante> getTripulantes() {
		if (tripulantes != null && tripulantes.size() > 0) {
			Collections.sort(tripulantes, new TripulanteComparator());
		}
		return tripulantes;
	}

	public void setTripulantes(List<Tripulante> tripulantes) {
		this.tripulantes = tripulantes;
	}

	public Tripulante getTripulante() {
		return tripulante;
	}

	public void setTripulante(Tripulante tripulante) {
		this.tripulante = tripulante;
	}

}
