import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Paciente {
	private String Nombre;
	private int Edad;
	private String CC;
	private int Estatura;
	private String Eps;
	private String Antecedentes;
	private String enfCronicas;


	public Paciente(String nombre, int edad, String CC, int estatura, String eps, String antecedentes, String enfCronicas) {
		super();
		Nombre = nombre;
		Edad = edad;
		this.CC = CC;
		Estatura = estatura;
		Eps = eps;
		Antecedentes = antecedentes;
		this.enfCronicas = enfCronicas;
	}

	public Paciente (String Nombre, int Edad, String CC) {
		this.Nombre = Nombre;
		this.CC = CC;
		this.Edad = Edad;
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
	public String getCC() {
		return CC;
	}
	public void setCC(String CC) {
		this.CC = CC;
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
	public String toString() {
		return "Paciente [Nombre=" + Nombre + ", CC=" + CC + ", Edad=" + Edad + "]";
	}
	public void writeObjeto(String adress) throws IOException {
		FileOutputStream f = new FileOutputStream(adress);
		ObjectOutputStream o = new ObjectOutputStream(f);
		o.writeObject(this);
		o.close();
		f.close();
	}

	public void readObjeto(String adress) throws IOException, ClassNotFoundException {
		FileInputStream in = new FileInputStream(adress);
		ObjectInputStream o = new ObjectInputStream(in);
		Paciente paciente = (Paciente) o.readObject();
		this.CC = paciente.CC;
		this.Nombre = paciente.Nombre;
		this.Edad = paciente.Edad;
		o.close();
		in.close();
	}



}
