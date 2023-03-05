public class Paciente {
private String Nombre;
private int Edad;
private String Documento;
private int Estatura;
private String Eps;
private String Antecedentes;
private String enfCronicas;


public Paciente(String nombre, int edad, String documento, int estatura, String eps, String antecedentes,
		String enfCronicas) {
	super();
	Nombre = nombre;
	Edad = edad;
	Documento = documento;
	Estatura = estatura;
	Eps = eps;
	Antecedentes = antecedentes;
	this.enfCronicas = enfCronicas;
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
public int getEstatura() {
	return Estatura;
}
public void setEstatura(int estatura) {
	Estatura = estatura;
}
public String getEps() {
	return Eps;
}
public void setEps(String eps) {
	Eps = eps;
}
public String getAntecedentes() {
	return Antecedentes;
}
public void setAntecedentes(String antecedentes) {
	Antecedentes = antecedentes;
}
public String getEnfCronicas() {
	return enfCronicas;
}
public void setEnfCronicas(String enfCronicas) {
	this.enfCronicas = enfCronicas;
}



}
