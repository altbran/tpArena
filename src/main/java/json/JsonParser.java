package json;

import java.io.IOException;

import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.estudiante.Estudiante;

public class JsonParser {

	
	
	
	public static Estudiante deserializarEstudiante(String responseJson) {
		ObjectMapper objectMapper = new ObjectMapper();
		Estudiante estudiante = null;
		try {
			estudiante = objectMapper.readValue(responseJson,Estudiante.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return estudiante;
	}
	
	public static List<Tarea> deserializarAsignaciones(String responseJson) {
		ObjectMapper objectMapper = new ObjectMapper();
		//List<Car> listCar = objectMapper.readValue(jsonCarArray, new TypeReference<List<Car>>(){});
		List<Tarea> estudiante = null;
		try {
			estudiante = objectMapper.readValue(responseJson,Estudiante.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return estudiante;
	}
	
}
