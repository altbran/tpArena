package conexionServer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fixture.Fixture;
import login.Login;

public class TestLogin extends Fixture {
	@Test
	public void ElLegajoDePruebaTieneDeNombreLisa() {
		assertEquals("Randall", Login.getInstance().intentarLogearEstudiantePorLegajo(legajoPrueba).nombre);
	}
	
	@Test (expected = model.repositorios.LegajoInexistenteException.class)
	public void ElLegajo12345TiraErrorSiIntentoTraerEstudiante() {
		Login.getInstance().intentarLogearEstudiantePorLegajo(12345);
	}
}
