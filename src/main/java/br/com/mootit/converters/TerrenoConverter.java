package br.com.mootit.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("terrenoConverter")
public class TerrenoConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value.contains("unknown")) {
			return "Terreno Desconhecido";
		}
		return value;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value.toString().contains("unknown")) {
			return "Terreno Desconhecido";
		}
		
		StringBuilder terrainFormatted = new StringBuilder();
		
		String[] terrains = value.toString().split(",");
		for (int i = 0 ; i < terrains.length ; i++) {
			String terrain = terrains[i].trim();
			
			terrains[i] = terrain.substring(0, 1).toUpperCase().concat(terrain.substring(1));
			if (i == (terrains.length - 1)) {
				terrainFormatted = terrainFormatted.append(terrains[i]);
			} else {
				terrainFormatted = terrainFormatted.append(terrains[i]).append(", ");
			}
			
		}
		
		return terrainFormatted.toString();
	}

}
