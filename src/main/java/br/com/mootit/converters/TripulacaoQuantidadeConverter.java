package br.com.mootit.converters;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("tripulacaoConverter")
public class TripulacaoQuantidadeConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(Pattern.compile("^[0-9]+$").matcher(value).matches()) {
			return new Integer(value);
		} else {
			throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Valor não permitido"));
		}
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return value.toString();
	}

}
