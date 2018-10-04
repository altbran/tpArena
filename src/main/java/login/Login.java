package login;

import java.awt.print.Printable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser;

import model.estudiante.ClienteHTTP;
import model.estudiante.Estudiante;
import model.repositorios.LegajoInexistenteException;

public class Login {
	private Map<Integer, String> tokens = new HashMap<>();
	
	private static Login instancia;
	
	public static Login getInstance() {
		if(instancia == null) {
			instancia = new Login();
		}
		return instancia;
	}
	
	public Estudiante intentarLogearEstudiantePorLegajo(int legajo) {
		//Codigo para probar visualmente 
		registrarToken(111111, "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho");
		String token = obtenerToken(legajo);
		
		String jsonResponseEstudiante = ClienteHTTP.getInstance().traerEstudiantePorToken(token);
		Estudiante estudiante = json.JsonParser.deserializarEstudiante(jsonResponseEstudiante);
		String jsonResponseAsignaciones = ClienteHTTP.getInstance().traerAsignacionesPorToken(token);
		Estudiante estudianteConAsignaciones = json.JsonParser.deserializarAsignaciones(jsonResponseAsignaciones);
		estudiante.setAsignaciones(estudianteConAsignaciones.getAsignaciones());
		return estudiante;
				
	}
	
	public String obtenerToken(int legajo) {
		if(!tokens.containsKey(legajo)) {
			throw new LegajoInexistenteException();
		}
		return tokens.get(legajo);
	}
	
	public void registrarToken(int legajo,String token) {
		tokens.put(legajo, token);
	}
	
}
