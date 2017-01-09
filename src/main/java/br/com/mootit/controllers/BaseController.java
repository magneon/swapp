package br.com.mootit.controllers;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class BaseController {
	
	public final void addErrorMessage(String mensagem) {
		FacesContext context = FacesContext.getCurrentInstance();
		if (context != null) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", mensagem));
		}
	}

	public final void addWarnMessage(String mensagem) {
		FacesContext context = FacesContext.getCurrentInstance();
		if (context != null) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Alerta", mensagem));
		}
	}
	
	public final void addInfoMessage(String mensagem) {
		FacesContext context = FacesContext.getCurrentInstance();
		if (context != null) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", mensagem));
		}
	}

}
