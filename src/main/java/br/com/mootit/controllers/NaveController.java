package br.com.mootit.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.mootit.comparators.NaveComparator;
import br.com.mootit.models.Nave;
import br.com.mootit.util.StarWarsUtil;

@SessionScoped
@ManagedBean
public class NaveController extends BaseController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<Nave> naves;
	
	private Nave nave;

	public void listaNaves() {
		naves = new ArrayList<Nave>();
		StarWarsUtil.listaNaves(naves, false);
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

}
