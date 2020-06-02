package es.uv.twcam.projects.airproject.service;

import java.util.List;

import es.uv.twcam.projects.airproject.entity.Aircraft;

public interface AircraftDAO {
	
	public List<Aircraft> getAircrafs();
	public Aircraft getAircraft(int id);
	public void createAircraft(Aircraft aircraft);
	public void updateAircraft(Aircraft aircraft);
	public void deleteAircraft(Aircraft aircraft);

}
