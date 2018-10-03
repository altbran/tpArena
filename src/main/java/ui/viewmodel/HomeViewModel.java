package ui.viewmodel;

import org.uqbar.commons.model.annotations.Observable;

import login.Login;
import model.estudiante.Estudiante;
import model.repositorios.RepoEstudiantes;

@Observable
public class HomeViewModel {
	private int legajo;

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	
	public Estudiante obtenerEstudiante() {
		return Login.getInstance().intentarLogearEstudiantePorLegajo(legajo);
		
	}
}
