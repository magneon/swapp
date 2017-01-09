package br.com.mootit.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.mootit.comparators.NaveComparator;
import br.com.mootit.comparators.PlanetaComparator;
import br.com.mootit.models.Nave;
import br.com.mootit.models.Planeta;
import br.com.mootit.models.PlanoVoo;
import br.com.mootit.util.StarWarsUtil;

@SessionScoped
@ManagedBean(name = "planoVooController")
public class PlanoVooController extends BaseController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Planeta> planetas;
	private List<Nave> naves;
	private List<PlanoVoo> planos;
	
	private Planeta planeta;
	private Nave nave;
	private PlanoVoo last;
	
	private Integer tripulacaoTotal;
	
	@PostConstruct
	public void init() {
		planetas = new ArrayList<Planeta>();
		naves = new ArrayList<Nave>();
		planos = new ArrayList<PlanoVoo>();
		StarWarsUtil.listaPlanetas(planetas, true);
		StarWarsUtil.listaNaves(naves, true);
	}
	
	public void criar() {
		if(planIsPopulated()) {
		
			if (tripulacaoGreaterThanCapacity()) {
				addErrorMessage("Tripulantes > Capacidade da Nave");
				return;
			}
			
			PlanoVoo planoVoo = new PlanoVoo(planeta, nave, tripulacaoTotal);
			
			if (planoVooIsPopulate(planoVoo) && planoVooIsNotThe(last, planoVoo)) {
				last = planoVoo;
				planos.add(planoVoo);
				addInfoMessage("Plano de Vôo cadastrado com sucesso!");
				clearFields();
			}
			
		}
	}

	private boolean planIsPopulated() {
		boolean isPopulated = true;
		
		if (planeta == null) {
			addErrorMessage("O planeta deve ser selecionado!");
			isPopulated = false;
		} else if (nave == null) {
			addErrorMessage("A nave deve ser selecionada!");
			isPopulated = false;
		} else if (tripulacaoTotal == null) {
			addErrorMessage("A tripulação deve ser informada!");
			isPopulated = false;
		}
		
		return isPopulated;
	}

	private boolean tripulacaoGreaterThanCapacity() {
		if (nave.getPassageiros() == null || nave.getPassageiros().contains("unknown")) {
			return true;
		} else {
			return tripulacaoTotal.intValue() > Integer.valueOf(nave.getPassageiros()); 
		}
	}

	private void clearFields() {
		planeta = null;
		nave = null;
		tripulacaoTotal = null;
	}

	private boolean planoVooIsNotThe(PlanoVoo last, PlanoVoo planoVoo) {
		boolean isNew = true;
		
		if(last != null && last.getPlaneta().getNome().equals(planoVoo.getPlaneta().getNome())) {
			addErrorMessage("Planeta Destino não pode ser igual ao último.");
			isNew = false;
		}
		
		return isNew;
	}

	private boolean planoVooIsPopulate(PlanoVoo planoVoo) {
		return planoVoo.getPlaneta() != null && planoVoo.getNave() != null && planoVoo.getTripulacaoTotal() != null;
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

	public List<Nave> getNaves() {
		if (naves != null && naves.size() > 0) {
			Collections.sort(naves, new NaveComparator());
		}
		return naves;
	}

	public void setNaves(List<Nave> naves) {
		this.naves = naves;
	}

	public Nave getNave() {
		return nave;
	}

	public void setNave(Nave nave) {
		this.nave = nave;
	}
	
	public Integer getTripulacaoTotal() {
		return tripulacaoTotal;
	}
	
	public void setTripulacaoTotal(Integer tripulacaoTotal) {
		this.tripulacaoTotal = tripulacaoTotal;
	}
	
	public List<PlanoVoo> getPlanos() {
		return planos;
	}
	
	public void setPlanos(List<PlanoVoo> planos) {
		this.planos = planos;
	}
	
}
