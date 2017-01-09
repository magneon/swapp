package br.com.mootit.models;

public class PlanoVoo {

	private Planeta planeta;
	private Nave nave;
	private Integer tripulacaoTotal;

	public PlanoVoo(Planeta planeta, Nave nave, Integer tripulacaoTotal) {
		this.planeta = planeta;
		this.nave = nave;
		this.tripulacaoTotal = tripulacaoTotal;
	}

	public Planeta getPlaneta() {
		return planeta;
	}

	public void setPlaneta(Planeta planeta) {
		this.planeta = planeta;
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
	
	

}
