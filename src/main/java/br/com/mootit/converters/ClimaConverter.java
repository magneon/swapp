package br.com.mootit.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("climaConverter")
public class ClimaConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value.contains("unknown")) {
			return "Clima Desconhecido";
		}
		return value;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value.toString().contains("unknown")) {
			return "Clima Desconhecido";
		}
		
		StringBuilder climateFormatted = new StringBuilder();
		
		String[] climates = value.toString().split(",");
		for (int i = 0 ; i < climates.length ; i++) {
			String climate = climates[i].trim();
			
			climates[i] = climate.substring(0, 1).toUpperCase().concat(climate.substring(1));
			if (i == (climates.length - 1)) {
				climateFormatted = climateFormatted.append(climates[i]);
			} else {
				climateFormatted = climateFormatted.append(climates[i]).append(", ");
			}
			
		}
		
		return climateFormatted.toString();
	}

}
