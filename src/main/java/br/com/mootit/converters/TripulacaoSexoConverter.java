package br.com.mootit.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("tripulacaoSexoConverter")
public class TripulacaoSexoConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value.equals("n/a")) {
			return "Não Definido";
		} else if (value.equals("male")){
			return "Masculino";
		} else if (value.equals("female")) {
			return "Feminino";
		} else if (value.equals("hermaphrodite")) {
			return "Hermafrodita";
		} else {
			return "Desconhecido";
		}
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value.toString().equals("n/a")) {
			return "Não Definido";
		} else if (value.toString().equals("male")){
			return "Masculino";
		} else if (value.toString().equals("female")) {
			return "Feminino";
		} else if (value.toString().equals("hermaphrodite")) {
			return "Hermafrodita";
		} else {
			return "Desconhecido";
		}
	}

}
