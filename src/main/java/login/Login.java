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
		String token = obtenerToken(legajo);
		System.out.print(token);
		String jsonResponse = ClienteHTTP.getInstance().traerEstudiantePorToken(token);
		System.out.print(jsonResponse);
		return json.JsonParser.deserializarEstudiante(jsonResponse);
				
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
