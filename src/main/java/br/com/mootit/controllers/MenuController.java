package br.com.mootit.controllers;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean(name = "menu")
public class MenuController extends BaseController implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public String listaNaves() {
		return "/pages/naves/naves.xhtml";
	}
	
	public String listaPlanetas() {
		return "/pages/planetas/planetas.xhtml";
	}
	
	public String listaTripulacao() {
		return "/pages/tripulacao/tripulacao.xhtml";
	}
	
	public String novoPlanoDeVoo() {
		return "/pages/plano/plano-novo.xhtml";
	}

}
