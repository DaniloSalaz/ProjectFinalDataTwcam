package es.uv.twcam.projects.airproject.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;

import es.uv.twcam.projects.airproject.entity.Aircraft;
import es.uv.twcam.projects.airproject.entity.Airline;
import es.uv.twcam.projects.airproject.entity.Airport;
import es.uv.twcam.projects.airproject.entity.Flight;
import es.uv.twcam.projects.airproject.repositoryDAO.DataDAOFactory;
import es.uv.twcam.projects.airproject.repositoryDAO.DataDAOFactory.TYPE;
import es.uv.twcam.projects.airproject.service.IAircraftDAO;
import es.uv.twcam.projects.airproject.service.IAirlineDAO;
import es.uv.twcam.projects.airproject.service.IAirportDAO;
import es.uv.twcam.projects.airproject.service.IFlightDAO;
/**
*
* @author danilosalaz
*/
public class UtilsData {

	public static void main(String[] args) {
		String pathYaml ;
		String pathPackage = "src/main/java/es/uv/twcam/projects/airproject/service";
		String pathPackageRepo = "src/main/java/es/uv/twcam/projects/airproject/repositoryDAO";
		try {
			pathYaml = args[0];
		} catch (ArrayIndexOutOfBoundsException e) {
			pathYaml = "prueba.yml";
		}
		
		
//		System.out.println(air.getName());
//		List<IEntityDAO> listIEntitys = parseFileYamltoEntity(pathYaml);
//		generateCodeIEntityDAO(listIEntitys,pathPackage);
//		generateCodeEntityImplDAO(listIEntitys,pathPackage);
//		generateCodeDAOFactory(listIEntitys, pathPackageRepo);
//		fenerateCodeJPADAOFactory(listIEntitys, pathPackageRepo);
		
		
		try {
			DataDAOFactory airDAOs = DataDAOFactory.getDAOFactory(TYPE.JPA);
			File fileCSV;
			BufferedReader br ;
			
//			Aerolineas
//			fileCSV = new File("datasets-airlines.csv");
//			br = new BufferedReader(new FileReader(fileCSV));
//			insertAirlines(airDAOs, br);
			
//			Aeropuertos
//			fileCSV = new File("datasets-airports.csv");
//			br = new BufferedReader(new FileReader(fileCSV));
//			insertAirports(airDAOs, br);
			
			//Aviones
//			fileCSV = new File("datasets-flights.csv");
//			br = new BufferedReader(new FileReader(fileCSV));
//			insertAircrafts(airDAOs, br);
			
//			//Vuelos
			fileCSV = new File("datasets-flights.csv");
			br = new BufferedReader(new FileReader(fileCSV));
			insertFlights(airDAOs, br);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	   

	}
	public static void insertAirlines(DataDAOFactory airDAOs, BufferedReader br) throws IOException {
		String st;
		IAirlineDAO airlineRepo = airDAOs.getAirlineDAO();
//		List<Airline> listAirline = new ArrayList<Airline>();
		while((st = br.readLine()) != null) {
			String[] res = st.split(",");
			airlineRepo.createAirline(new Airline(res[0],res[1]));
//			listAirline.add(new Airline(res[0],res[1]));
			
		}
//		listAirline.forEach(System.out::println);
		br.close();
	}
	public static void insertAirports(DataDAOFactory airDAOs, BufferedReader br) throws IOException {
		String st;
		IAirportDAO airportRepo = airDAOs.getAirportDAO();
//		List<Airport> listAirport = new ArrayList<Airport>();
		while((st = br.readLine()) != null) {
			String[] res = st.split(",");
			airportRepo.createAirport(new Airport(res[0],res[1],res[4],res[2]));
//			listAirport.add(new Airport(res[0],res[1],res[4],res[2]));
			
		}
		airportRepo.createAirport(new Airport("VLC","Aeropuerto Internacional de Valencia","ESP","Valencia"));
//		listAirport.forEach(System.out::println);
		br.close();
	}
	
	public static void insertAircrafts(DataDAOFactory airDAOs, BufferedReader br) throws IOException {
		String st;
		IAircraftDAO aircraftRepo = airDAOs.getAircraftDAO();
//		List<Aircraft> listAircraft = new ArrayList<Aircraft>();
		Set<String> codesAircrafs = new HashSet<String>();
		
		while((st = br.readLine()) != null) {
			String[] res = st.split(",");
			String codeAircraft = res[6];
			codesAircrafs.add(codeAircraft);

			
		}
		codesAircrafs.forEach(c ->{
			aircraftRepo.createAircraft(new Aircraft(c,c));
//			listAircraft.add(new Aircraft(codeAircraft,codeAircraft));
		});
		
//		listAircraft.forEach(System.out::println);
		br.close();
	}
	
	public static void insertFlights(DataDAOFactory airDAOs, BufferedReader br) throws IOException {
		IAircraftDAO aircRepo = airDAOs.getAircraftDAO();
		IAirlineDAO airlRepo = airDAOs.getAirlineDAO();
		IAirportDAO airpRepo = airDAOs.getAirportDAO();
		IFlightDAO fligRepo = airDAOs.getFlightDAO();
		
		Airport airportOrigin, aiportDestin,airportVLC;
		Airline airline;
		Aircraft aircraft;
		
		airportVLC = airpRepo.findAirportByIATACode("VLC");
//		List<Flight> listFLights = new ArrayList<Flight>();
		br.readLine();
		
		String st = "";
		int count = 0;
		try {
			while((st = br.readLine()) != null && count < 2000) {
				String[] res = st.split(",");
				LocalDate dateRes = LocalDate.now();
//				int year = res[0] !=  null && !res[0].equals("") ? Integer.parseInt(res[0]): ;
				int month =  (int) (1 + Math.random() * (12 - 1));//res[1] != null && !res[1].equals("") ? Integer.parseInt(res[1]): 5;
				int day = month == 2 ? (int) (1 + Math.random() * (28 - 1)): (int) (1 + Math.random() * (28 - 1));//res[2] !=  null && res[2].equals("") ? Integer.parseInt(res[2]):10;
				String codeAirline = res[4];
				String codeAircraft = res[6];
				String originAirport = res[7];
				String destinationAirport = res[8];
				String boardingTime = res[10];
				String departureTime = res[13];
				int airTime = res[16] !=  null && !res[16].equals("") ? Integer.parseInt(res[16]): 0;
				float cost = (float) (50 + Math.random() * (700 - 50));
				float boggageCost = (float) (50 + Math.random() * (150 - 50));
				float priorityCost = (float) (100 + Math.random() * (200 - 100));
				
				airportOrigin = count < 1000 ? airportVLC: airpRepo.findAirportByIATACode(originAirport);
				aiportDestin = count >= 1000 ? airportVLC: airpRepo.findAirportByIATACode(destinationAirport);
				airline = airlRepo.findAirlineByIATACode(codeAirline);
				aircraft = aircRepo.findAircraftByName(codeAircraft);
				
				fligRepo.createFlight(new Flight(dateRes, 2020 ,month,day,departureTime, boardingTime,airTime, 500, cost,priorityCost,
				boggageCost, airline, aiportDestin,  airportOrigin, aircraft));
//				listFLights.add(new Flight(dateRes, 2020,month,day,departureTime, boardingTime,airTime, 0, cost,priorityCost,
//				boggageCost, State.schedule, airline, aiportDestin,  airportOrigin, aircraft));
				count++;
			}
			br.close();
			//listFLights.forEach(System.out::println);
			
		} catch (NumberFormatException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.out.println("Fallo en la fila : " + count);
			System.out.println(st.toString());
		}
		
		
	}
	public static void generateCodeIEntityDAO(List<IEntityDAO> listIEntytyDAO, String pathPackage) {
	
		System.out.println("Generando interfaces...");
		PrintWriter pw;
		int coutInterf= 0;
		
		for(IEntityDAO interf: listIEntytyDAO) {
			try {
				pw = new PrintWriter(new FileWriter(pathPackage + "/" + "I" + interf.getName() + ".java"));
				CodeGenerator.createInterfaceDao(pw,interf);
				coutInterf++;
			} catch (IOException e) {
				System.err.println("Error al crear interfaces: " + e.getMessage());
				
			}
		}
		System.out.println("Total Interfaces creadas: " + coutInterf);
		
		
		
	}
	
	public static void generateCodeEntityImplDAO(List<IEntityDAO> listIEntytyDAO, String pathPackage) {
		System.out.println("Generando implementacion de las interfaces...");
		PrintWriter pw;
		int coutInterf= 0;
		for(IEntityDAO interf: listIEntytyDAO) {
			try {
				pw = new PrintWriter(new FileWriter(pathPackage + "/" + interf.getName() + "Impl.java"));
				CodeGenerator.createEntityDaoImpl(pw, interf);
				coutInterf++;
			} catch (IOException e) {
				System.err.println("Error al crear interfaces: " + e.getMessage());
				
			}
		}
		System.out.println("Total Interfaces creadas: " + coutInterf);
	}
	
	public static void fenerateCodeJPADAOFactory(List<IEntityDAO> listIEntytyDAO, String pathPackage) {
		System.out.println("Generando JPADAOFactory...");
		PrintWriter pw;
		try {
			pw = new PrintWriter(new FileWriter(pathPackage + "/JPADAOFactory.java"));
			CodeGenerator.createJPADAOFactory(pw,listIEntytyDAO);
		} catch (IOException e) {
			System.err.println("Error al JPADAOFactory: " + e.getMessage());
			
		}
		System.out.println("JPADAOFactory creado.");
	
	}
	
	public static void generateCodeDAOFactory(List<IEntityDAO> listIEntytyDAO, String pathPackage) {
		System.out.println("Generando DAOFactory...");
		PrintWriter pw;
		try {
			pw = new PrintWriter(new FileWriter(pathPackage + "/DataDAOFactory.java"));
			CodeGenerator.createDAOFactory(pw,listIEntytyDAO);
		} catch (IOException e) {
			System.err.println("Error al DAOFactory: " + e.getMessage());
			
		}
		System.out.println("DAOFactory creado.");
		
	}
	
	public static List<IEntityDAO> parseFileYamltoEntity(String file){
		YamlReader reader;
		Object objectYaml;
		
		System.out.println("Parseando propiedades YAML a Objetos tipo Intertfaces...");
		
		try {
			reader = new YamlReader(new FileReader(file));
			objectYaml = reader.read();
			List<IEntityDAO> listIEntytyDAO = readYamlAtrributes(objectYaml);
			System.out.println("parseado compleado!");
			
			return listIEntytyDAO;
			
		} catch (YamlException e) {
			System.err.println("Error al parsear el file YAML: " + e.getStackTrace());
		}catch (FileNotFoundException e1) {
			System.err.println("Error al leer el archivo: " + e1.getStackTrace());
		}
		
		return null;
		
	}
	public static List<IEntityDAO> readYamlAtrributes(Object objectYaml) {
		Map<?,?> yamlMap = (Map<?, ?>) objectYaml;
		List<IEntityDAO> listIEntityDAO = new ArrayList<IEntityDAO>();
		yamlMap.forEach((key,value) -> {
			  listIEntityDAO.add(createIEntityDAO((String) key,(List<?>) value));
		});
		return listIEntityDAO;
	}
	public static IEntityDAO createIEntityDAO(String key, List<?> yamlMethods) {
		IEntityDAO iEntity = new IEntityDAO();
		iEntity.setName(key);
		iEntity.setMethods(createMehodsDao(yamlMethods,iEntity));
		return iEntity;
	}
	
	public static List<IEntityDAO.MethodDAO> createMehodsDao(List<?> yamlMethods, IEntityDAO entity){
		List<IEntityDAO.MethodDAO> methodsDao = new ArrayList<IEntityDAO.MethodDAO>(); 
		
		yamlMethods.forEach(m -> {
			Map<?,?> methodMap = (Map<?, ?>) m;
			IEntityDAO.MethodDAO methodDao = entity.new MethodDAO();
			if(methodMap.get("CRUD") != null)
				methodsDao.addAll(createMathodsCRUD((String) methodMap.get("CRUD"), entity));
			if(methodMap.get("name") != null)
				methodDao.setName((String) methodMap.get("name"));
			if(methodMap.get("return") != null)
				methodDao.setRetu((String) methodMap.get("return"));
			if(methodMap.get("arguments") != null)
				methodDao.setArg(getArgsMethodYaml((List<?>) methodMap.get("arguments")));
			if(methodDao.getName() != null)
				methodsDao.add(methodDao);
		});
		
		return methodsDao;
		
	}
	@SuppressWarnings("unchecked")
	public static Map<String,String> getArgsMethodYaml(List<?> argsYaml){
		Map<String, String> argsMethod = new HashMap<String, String>();
		argsYaml.forEach(item -> {
			argsMethod.putAll((Map<? extends String, ? extends String>) item);
		});
		return argsMethod;
		
	}
	public static List<IEntityDAO.MethodDAO> createMathodsCRUD(String typeEntity, IEntityDAO entity) {
		String GET = "get";
		String CREATE = "create";
		String UPDATE = "update";
		String DELETE = "delete";
		
		List<IEntityDAO.MethodDAO> methodsDao = new ArrayList<IEntityDAO.MethodDAO>(); 
		methodsDao.add(entity.new MethodDAO(GET + typeEntity + "s", null,"List<" + typeEntity + ">" ));
		methodsDao.add(entity.new MethodDAO(GET + typeEntity, Collections.singletonMap("id", "int"),typeEntity));
		methodsDao.add(entity.new MethodDAO(CREATE + typeEntity, Collections.singletonMap(typeEntity.toLowerCase(),typeEntity) ,null));
		methodsDao.add(entity.new MethodDAO(UPDATE + typeEntity, Collections.singletonMap(typeEntity.toLowerCase(),typeEntity),null));
		methodsDao.add(entity.new MethodDAO(DELETE + typeEntity, Collections.singletonMap(typeEntity.toLowerCase(),typeEntity),null));
		entity.setTypeEntity(typeEntity);
		return methodsDao;
	}

}
