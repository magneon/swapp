package br.com.mootit.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.mootit.comparators.PlanetaComparator;
import br.com.mootit.models.Planeta;
import br.com.mootit.util.StarWarsUtil;

@ManagedBean
@SessionScoped
public class PlanetaController extends BaseController implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private List<Planeta> planetas;
	
	private Planeta planeta;
	
	public void listaPlanetas() {
		planetas = new ArrayList<Planeta>();
		StarWarsUtil.listaPlanetas(planetas, false);
	}

	public List<Planeta> getPlanetas() {
		if (planetas != null && planetas.size() > 0) {
			Collections.sort(planetas, new PlanetaComparator());
		}
		return planetas;
	}

	public void setPlanetas(List<Planeta> planetas) {
		this.planetas = planetas;
	}

	public Planeta getPlaneta() {
		return planeta;
	}

	public void setPlaneta(Planeta planeta) {
		this.planeta = planeta;
	}

}
