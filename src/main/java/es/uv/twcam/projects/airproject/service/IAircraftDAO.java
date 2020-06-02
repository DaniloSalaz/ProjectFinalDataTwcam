package es.uv.twcam.projects.airproject.service;

import java.util.List;

import es.uv.twcam.projects.airproject.entity.Aircraft;

public interface IAircraftDAO {

	public List<Aircraft> getAircrafts();

	public Aircraft getAircraft(int id);

	public void createAircraft(Aircraft aircraft);

	public void updateAircraft(Aircraft aircraft);

	public void deleteAircraft(Aircraft aircraft);

	public void deteleById(int id);

	public Aircraft findAircraftByName(String name);


}