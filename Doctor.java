import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Doctor {
	
	private String Nombre;
	private int Edad;
	private String CC;
	private String Especialidad;
	
	public Doctor (String Nombre, String CC, int Edad, String Especialidad) {
		this.Nombre=Nombre;
		this.CC=CC;
		this.Especialidad=Especialidad;
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

	public void setEdad(int edad) throws ENoExiste{
		if (edad > 0 && edad < 150) {
			Edad = edad;
		}
		else {
			throw new ENoExiste("Edad invalida");
		}
		
	}

	public String getCC() {
		return CC;
	}

	public void setCC(String CC) {
		this.CC = CC;
	}

	public String getEspecialidad() {
		return Especialidad;
	}

	public void setEspecialidad(String especialidad) {
		Especialidad = especialidad;
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
		Doctor doctor = (Doctor) o.readObject();
		this.CC = doctor.CC;
		this.Nombre = doctor.Nombre;
		this.Edad = doctor.Edad;
		this.Especialidad = doctor.Especialidad;
		o.close();
		in.close();
	}
	
	
	

}
