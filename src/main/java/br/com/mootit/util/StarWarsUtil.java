package br.com.mootit.util;

import java.util.List;

import com.swapi.models.People;
import com.swapi.models.Planet;
import com.swapi.models.SWModelList;
import com.swapi.models.Starship;
import com.swapi.sw.StarWars;
import com.swapi.sw.StarWarsApi;

import br.com.mootit.models.Nave;
import br.com.mootit.models.Planeta;
import br.com.mootit.models.Tripulante;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class StarWarsUtil {
	
	public static final void listaNaves(final List<Nave> naves, boolean wait) {
		StarWarsApi.init();
		StarWars swapi = StarWarsApi.getApi();
		
		int i = 0;
		while(i < 5) {
			swapi.getAllStarships(i, new Callback<SWModelList<Starship>>() {

				public void success(SWModelList<Starship> result, Response response) {
					List<Starship> starships = result.results;
					for (Starship starship : starships) {
						Nave nave = new Nave();
						nave.setNome(starship.name);
						nave.setModelo(starship.model);
						nave.setPassageiros(starship.passengers);
						
						naves.add(nave);
					}
				}

				public void failure(RetrofitError error) {}
				
			});
			i++;
		}
		
		if (wait) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static final void listaPlanetas(final List<Planeta> planetas, boolean wait) {
		StarWarsApi.init();
		StarWars swapi = StarWarsApi.getApi();
		
		int i = 0;
		while (i < 5) {
			swapi.getAllPlanets(i, new Callback<SWModelList<Planet>>() {
				
				public void success(SWModelList<Planet> result, Response response) {
					List<Planet> planets = result.results;
					for (Planet planet : planets) {
						Planeta planeta = new Planeta();
						planeta.setNome(planet.name);
						planeta.setDiametro(planet.diameter);
						planeta.setClima(planet.climate);
						planeta.setTerreno(planet.terrain);
						planeta.setPopulacao(planet.population);
						planetas.add(planeta);
					}
				}
				
				public void failure(RetrofitError error) {}
			});
			i++;
		}
		
		if (wait) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static final void listaTripulacao(final List<Tripulante> tripulantes, boolean wait) {
		StarWarsApi.init();
		StarWars swapi = StarWarsApi.getApi();
		
		int i = 0;
		while(i < 5) {
			swapi.getAllPeople(i, new Callback<SWModelList<People>>() {

				public void success(SWModelList<People> result, Response response) {
					List<People> people = result.results;
					for (People person : people) {
						Tripulante tripulante = new Tripulante();
						tripulante.setNome(person.name);
						tripulante.setSexo(person.gender);
						
						tripulantes.add(tripulante);
					}
				}

				public void failure(RetrofitError error) {}
				
			});
			i++;
		}
		
		if (wait) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
