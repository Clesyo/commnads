package br.com.command.client.seeders;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import br.com.command.client.models.City;
import br.com.command.client.models.State;
import br.com.command.client.repository.CityRepository;
import br.com.command.client.repository.StateRepository;

@Service
public class DefaultSeeder {

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private CityRepository cityRepository;

	private List<State> allStates;

	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultSeeder.class);

	public void seedStatesAndCities() {

		if (stateRepository.count() > 0)
			return;

		try {
			Resource statesResource = new ClassPathResource("seeders/states.json");
			statesResource.getInputStream();
			File statesFile = statesResource.getFile();

			JsonArray states = JsonParser.parseReader(new FileReader(statesFile)).getAsJsonArray();

			allStates = new ArrayList<State>();

			states.forEach(st -> {
				State state = new State(st.getAsJsonObject().get("nome").getAsString(),
						st.getAsJsonObject().get("uf").getAsString(), st.getAsJsonObject().get("codigo_uf").getAsInt());

				allStates.add(state);

			});

			stateRepository.saveAll(allStates);

			allStates = stateRepository.findAll();

			HashMap<Integer, State> statesMap = new HashMap<Integer, State>();

			for (State state : allStates) {
				statesMap.put(state.getCode(), state);
			}

			Resource citiesResource = new ClassPathResource("seeders/cities.json");
			citiesResource.getInputStream();
			File citiesFile = citiesResource.getFile();

			JsonArray cities = JsonParser.parseReader(new FileReader(citiesFile)).getAsJsonArray();

			List<City> allCities = new ArrayList<City>();

			cities.forEach(ct -> {
				City city = new City(ct.getAsJsonObject().get("nome").getAsString(),
						ct.getAsJsonObject().get("codigo_ibge").getAsInt(),
						statesMap.get(ct.getAsJsonObject().get("codigo_uf").getAsInt()));

				allCities.add(city);
				if (allCities.size() % 100 == 0) {
					String message = "Cidades adicionadas até o momento: " + allCities.size();
					LOGGER.info(message);
				}

			});

			cityRepository.saveAll(allCities);

		} catch (Exception e) {
			LOGGER.info(">>>>>>>>>>>>>> ERRO AO CRIAR ESTADOS E CIDADES >>>>>>>>>>>>>>");
			e.printStackTrace();
		}
	}

}
