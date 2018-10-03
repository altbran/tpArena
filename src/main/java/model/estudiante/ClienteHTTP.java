package model.estudiante;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

import login.Login;

public class ClienteHTTP {
	
	 private Client client;
    private static final String API_NOTAS = "http://notitas.herokuapp.com";
    private static final String PRE_TOKEN = "Bearer";
    private static final String RECURSO_ESTUDIANTE = "student";
    private static final String RECURSO_TAREAS = "assignments";
	
    
    private static ClienteHTTP instancia;
	
	public static ClienteHTTP getInstance() {
		if(instancia == null) {
			instancia = new ClienteHTTP();
		}
		return instancia;
	}
	
	  public ClienteHTTP() {
	        this.client = Client.create();        
	      
	    }
    
	public String traerEstudiantePorToken(String token) {
		  ClientResponse response = this.client.resource(API_NOTAS).path(RECURSO_ESTUDIANTE)
				  .accept(MediaType.APPLICATION_JSON)
	                 .header("Authorization", PRE_TOKEN + " " + token)
	                 .get(ClientResponse.class);
	         return response.getEntity(String.class);       
	}
	public String traerAsignacionesPorToken(String token) {
		  ClientResponse response = this.client.resource(API_NOTAS).path(RECURSO_ESTUDIANTE+'/'+RECURSO_TAREAS)
				  .accept(MediaType.APPLICATION_JSON)
	                 .header("Authorization", PRE_TOKEN + " " + token)
	                 .get(ClientResponse.class);
	         return response.getEntity(String.class);       
	}
	
}
