package br.com.mootit.converters;

import java.text.DecimalFormat;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("diametroConverter")
public class DiametroConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value.contains("unknown")) {
			return "Diâmetro Desconhecido";
		}
		return value;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value.toString().contains("unknown")) {
			return "Diâmetro Desconhecido";
		}
		return new DecimalFormat("#,###.##").format(Double.parseDouble(value.toString()));
	}

}
