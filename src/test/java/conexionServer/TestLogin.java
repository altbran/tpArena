package conexionServer;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import fixture.Fixture;
import login.Login;
import model.estudiante.ClienteHTTP;

public class TestLogin extends Fixture {
	
	
	@Test
	public void alBuscarUnEstudianteConTokenPruebaSeObtieneUnaRespuestaConPrimerNombre() {
		String jsonResponse = ClienteHTTP.getInstance().traerEstudiantePorToken(tokenPrueba);
		Assert.assertTrue(jsonResponse.contains("first_name"));
	}
	@Test
	public void alBuscarUnEstudianteConLegajoDePruebaSeObtieneUnEstudianteCon2Asignaciones() {
		Login.getInstance().intentarLogearEstudiantePorLegajo(legajoPrueba);
		assertEquals(2,Login.getInstance().intentarLogearEstudiantePorLegajo(legajoPrueba).getAsignaciones().size());
	}
	
	@Test (expected = model.repositorios.LegajoInexistenteException.class)
	public void ElLegajo12345TiraErrorSiIntentoTraerEstudiante() {
		Login.getInstance().intentarLogearEstudiantePorLegajo(12345);
	}
}
