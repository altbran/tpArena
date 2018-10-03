package fixture;

import login.Login;
import model.estudiante.ClienteHTTP;
import model.estudiante.Estudiante;
import model.repositorios.RepoEstudiantes;
import model.tarea.AsignacionTarea;
import model.tarea.EnumNotaConceptual;
import model.tarea.NotaConceptual;
import model.tarea.NotaNumerica;
import model.tarea.Tarea;

public class Fixture {
	
	static Fixture instancia = null;
	
	public int legajoPrueba = 111111;
	public String tokenPrueba = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho";
	
	public static Fixture getInstance() {
		if(instancia==null)
			return new Fixture();
		
		return instancia;
	}
	public Fixture() {
		fixture();
	}
	
	public void fixture() {
		Login.getInstance().registrarToken(legajoPrueba, tokenPrueba);
		
	}
	
}
