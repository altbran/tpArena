package model.tarea;

public class Tarea {
	

	

	private String nombre;
	private boolean notaTipoNumerica;
	private String descripcion;
	
	public Tarea() {
		
	}
	
	public Tarea(String nombre) {
		this.nombre = nombre;
	}

	public String nombre() {
		return nombre;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//TODO ver esto
	/*public void validarTipoNota(Nota nota) {
		nota.esValidaPara(notaTipoNumerica);
		throw new NotaInvalidaException();
	}*/
	
}
