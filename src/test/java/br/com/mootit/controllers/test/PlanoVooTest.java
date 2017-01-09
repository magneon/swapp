package br.com.mootit.controllers.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.mootit.controllers.PlanoVooController;
import br.com.mootit.models.Nave;
import br.com.mootit.models.Planeta;
import br.com.mootit.models.PlanoVoo;
import br.com.mootit.util.StarWarsUtil;

public class PlanoVooTest {

	@Test
	public void testQuantidadeTripulantesPermitido() {
		List<Nave> naves = new ArrayList<Nave>();
		
		StarWarsUtil.listaNaves(naves, true);
		
		Nave nave = null;
		Integer tripulacaoRandom = null;
		
		boolean continua = true;
		while(continua) {
			Integer indiceRandom = (int)(Math.random() * (naves.size() - 1));
			
			nave = naves.get(indiceRandom);
			String passageiros = nave.getPassageiros();
			
			if (!passageiros.contains("unk")) {
				tripulacaoRandom = (int)(Math.random() * Integer.valueOf(passageiros));
				if (tripulacaoRandom < Integer.valueOf(passageiros)) {
					continua = false;
				}
			}
			
		}
		
		PlanoVooController controller = new PlanoVooController();
		controller.setNave(nave);
		controller.setTripulacaoTotal(tripulacaoRandom);
		controller.setPlaneta(new Planeta());
		controller.setPlanos(new ArrayList<PlanoVoo>());
		
		controller.criar();
		
		assertNotNull(controller);
		
		for (PlanoVoo plano : controller.getPlanos()) {
			assertNotNull(plano);
			assertNotNull(plano.getPlaneta());
			assertNotNull(plano.getNave());
			assertNotNull(plano.getTripulacaoTotal());
			
			assertEquals(tripulacaoRandom, plano.getTripulacaoTotal());
		}

	}
	
	@Test
	public void testQuantidadeTripulantesNaoPermitido() {
		List<Nave> naves = new ArrayList<Nave>();
		
		StarWarsUtil.listaNaves(naves, true);
		
		Nave nave = null;
		Integer tripulacaoRandom = null;
		
		boolean continua = true;
		while(continua) {
			Integer indiceRandom = (int)(Math.random() * (naves.size() - 1));
			
			nave = naves.get(indiceRandom);
			String passageiros = nave.getPassageiros();
			
			if (!passageiros.contains("unk")) {
				tripulacaoRandom = ((int)(Math.random() * Integer.valueOf(passageiros)) * 10);
				if (tripulacaoRandom > Integer.valueOf(passageiros)) {
					continua = false;
				}
			}
			
		}
		
		PlanoVooController controller = new PlanoVooController();
		controller.setNave(nave);
		controller.setTripulacaoTotal(tripulacaoRandom);
		controller.setPlaneta(new Planeta());
		controller.setPlanos(new ArrayList<PlanoVoo>());
		
		controller.criar();
		
		assertNotNull(controller);
		assertEquals(0, controller.getPlanos().size());
	}
	
	@Test
	public void testPlanoDeVooNovo() {
		PlanoVooController controller = new PlanoVooController();
		controller.setPlanos(new ArrayList<PlanoVoo>());

		List<Nave> naves = new ArrayList<Nave>();
		StarWarsUtil.listaNaves(naves, true);
		
		List<Planeta> planetas = new ArrayList<Planeta>();
		StarWarsUtil.listaPlanetas(planetas, true);
		
		Nave nave = null;
		Planeta planeta = null;
		PlanoVoo last = null;
		
		int count = 0;
		while(count < 2) {
			Integer indicePlanetaRandom = (int)(Math.random() * (planetas.size() - 1));
			Integer indiceNaveRandom = (int)(Math.random() * (naves.size() - 1));
			
			nave = naves.get(indiceNaveRandom);
			planeta = planetas.get(indicePlanetaRandom);
			
			controller.setNave(nave);
			controller.setTripulacaoTotal(1);
			controller.setPlaneta(planeta);
			
			if (nave.getPassageiros().contains("unk") || Integer.valueOf(nave.getPassageiros()) == 0) {
				continue;
			}
			
			controller.criar();
			count++;
		}
		
		assertNotNull(controller);
		assertEquals(2, controller.getPlanos().size());
		
		for (PlanoVoo plano : controller.getPlanos()) {
			assertNotNull(plano);
			assertNotNull(plano.getPlaneta());
			assertNotNull(plano.getNave());
			assertNotNull(plano.getTripulacaoTotal());

			if (last == null) {
				last = plano;
			} else {
				assertNotEquals(last, plano);
			}
		}
		
	}
	
	@Test
	public void testPlanoDeVooExistente() {
		PlanoVooController controller = new PlanoVooController();
		controller.setPlanos(new ArrayList<PlanoVoo>());
		
		List<Nave> naves = new ArrayList<Nave>();
		StarWarsUtil.listaNaves(naves, true);
		
		List<Planeta> planetas = new ArrayList<Planeta>();
		StarWarsUtil.listaPlanetas(planetas, true);
		
		Nave nave = null;
		Planeta planeta = null;
		Integer indicePlanetaRandom = null;
		Integer indiceNaveRandom = null;
		int count = 0;
		while(count < 2) {
			if (indicePlanetaRandom == null || indiceNaveRandom == null) {
				indicePlanetaRandom = (int)(Math.random() * (planetas.size() - 1));
				indiceNaveRandom = (int)(Math.random() * (naves.size() - 1));
			}
			
			nave = naves.get(indiceNaveRandom);
			planeta = planetas.get(indicePlanetaRandom);
			
			controller.setNave(nave);
			controller.setTripulacaoTotal(1);
			controller.setPlaneta(planeta);
			
			if (nave.getPassageiros().contains("unknown") || Integer.valueOf(nave.getPassageiros()) == 0) {
				indicePlanetaRandom = null;
				continue;
			}
			
			controller.criar();
			count++;
		}
		
		assertNotNull(controller);
		assertEquals(1, controller.getPlanos().size());
		
		for (PlanoVoo plano : controller.getPlanos()) {
			assertNotNull(plano);
			assertNotNull(plano.getPlaneta());
			assertNotNull(plano.getNave());
			assertNotNull(plano.getTripulacaoTotal());
		}
		
	}
	
}
