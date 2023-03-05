public class Doctor {
	
	private String Nombre;
	private int Edad;
	private String Documento;
	private String Especialidad;
	
	public Doctor (String Nombre, String Documento, String Especialidad) {
		this.Nombre=Nombre;
		this.Documento=Documento;
		this.Especialidad=Especialidad;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getEdad() {
		return Edad;
	}

	public void setEdad(int edad) {
		Edad = edad;
	}

	public String getDocumento() {
		return Documento;
	}

	public void setDocumento(String documento) {
		Documento = documento;
	}

	public String getEspecialidad() {
		return Especialidad;
	}

	public void setEspecialidad(String especialidad) {
		Especialidad = especialidad;
	}

	
	
	

}
