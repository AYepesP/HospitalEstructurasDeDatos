import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Hospital {

	private Paciente[] Pacientes;
	private Doctor[] Doctores;
	private ArrayList<Cita> Citas;
	private Medicamento[] Medicamentos;

	private String file= "C:\\Users\\user\\Desktop\\EIA\\Sistemas\\HospitalFichero";
	public Hospital() {
		Pacientes =new Paciente[0];
		Doctores = new Doctor[0];
		Citas = new ArrayList<Cita>();
		try {
			readCitasObj(file);
			readDoctoresObj(file);
			readMedicamentosObj(file);
			readPacientesObj(file);
		} catch (ClassNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public void addPaciente(String Nombre, int Edad, String CC) {
		Paciente p = new Paciente(Nombre, Edad, CC);
		Pacientes = Arrays.copyOf(Pacientes, Pacientes.length + 1);
		Pacientes[Pacientes.length - 1] = p;
			try {
				writePacientesObj(file);
			} catch (FileNotFoundException e) {
				e.getMessage();
			} catch (IOException e) {
				e.getMessage();
			}
	}

	public void addDoctor(String Nombre, String CC, int Edad, String Especialidad) {
		Doctor p = new Doctor(Nombre, CC, Edad, Especialidad);
		Doctores = Arrays.copyOf(Doctores, Doctores.length + 1);
		Doctores[Doctores.length - 1] = p;
		try {
			writeDoctoresObj(file);
		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
		
	}
	
	public Doctor[] getDoctores() {
		return Doctores;
	}
	
	public Paciente[] getPacientes() {
		return Pacientes;
	}
	
	public String Imprimir() {
		String D = null;
	for (int i = 0; i < Doctores.length; i++) {
		System.out.println(Doctores[i].getNombre());
		return D+=Doctores[i].getNombre();
	}
	return "";
	}
	
	public void addCita(Paciente paciente, Doctor doctor, LocalDateTime fecha) throws ENoExiste {
		Cita p = new Cita(paciente, doctor, fecha);
		if (Citas.size() == 0) {
			Citas.add(p);
		} else if (Citas.get(Citas.size() - 1).getFecha().isAfter(fecha)) {
			Citas.add(p);
		} else if (Citas.get(0).getFecha().isBefore(fecha)) {
			Citas.add(0, p);
		} else {
			int inicio = 0;
			int fin = Citas.size();
			int mitad = (fin + inicio) / 2;

			while (fin - inicio > 1) {
				if (Citas.get(mitad).getDoctor().equals(doctor) && Citas.get(mitad).getFecha().isEqual(fecha)) {
					throw new ENoExiste("Doctor ocupado a esta hora.  Porfavor intente otra hora");
				} else if (Citas.get(mitad).getFecha().isAfter(fecha)) {
					inicio = mitad;
					mitad = (fin + inicio) / 2;
				} else if (Citas.get(mitad).getFecha().isBefore(fecha)) {
					fin = mitad;
					mitad = (fin + inicio) / 2;
				}
			}
			Citas.add(mitad + 1, p);
		}
		try {
			writeCitasObj(file);
		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public Cita buscarCita(Doctor doc, LocalDateTime fecha) throws Exception {
		System.out.println(Citas.get(0).getFecha().isAfter(fecha));
		if (doc == null) {
			throw new Exception("El doctor no existe");
		} else if (Citas.get(Citas.size() - 1).getFecha().isAfter(fecha)) {
			throw new Exception("El doctor esta disponible a esta hora.  La cita no existe");
		} else if (Citas.get(0).getFecha().isBefore(fecha)) {
			throw new Exception("El doctor esta disponible a esta hora.  La cita no existe");
		}
		int fin = Citas.size();
		int inicio = 0;
		int mitad = (fin + inicio) / 2;

		while (fin - inicio > 1) {
			if (Citas.get(mitad).getDoctor().equals(doc) && Citas.get(mitad).getFecha().isEqual(fecha)) {
				return Citas.get(mitad);
			} else if (Citas.get(mitad).getFecha().isAfter(fecha)) {
				inicio = mitad;
				mitad = (fin + inicio) / 2;
			} else if (Citas.get(mitad).getFecha().isBefore(fecha)) {
				fin = mitad;
				mitad = (fin + inicio) / 2;
			}
		}
		throw new Exception("El doctor esta disponible a esta hora.  La cita no existe");
	}

	public Cita buscarCita (Paciente paciente, LocalDateTime fecha) throws Exception{
		// Se evita que el paciente sea null
		if (paciente == null) {
            throw new Exception("El Paciente no existe");
        }
		// Se revisa la ultima posición
        else if(Citas.get(Citas.size()-1).getFecha().isAfter(fecha)) {
			throw new Exception("El paciente esta disponible a esta hora.  La cita no existe");
		}
		// Se revisa la primera posción
		else if(Citas.get(0).getFecha().isBefore(fecha)) {
			throw new Exception("El paciente esta disponible a esta hora.  La cita no existe");
		}
		// Se crean las variables a usar en la busqueda
		int fin = Citas.size();
        int inicio = 0;
        int mitad = (fin + inicio)/2;
		// Cuando la diferencia sea menos que 1, se sabe si existe o no.
		while(fin - inicio > 1) {
			//Si el paciente es igual y la hora es igual, el paciente tiene cita
			if (Citas.get(mitad).getPaciente().equals(paciente) && Citas.get(mitad).getFecha().isEqual(fecha)) {
				return Citas.get(mitad);
			}
			// de lo contrario uso las horas para saber si buscar mas adelante o atras
			else if (Citas.get(mitad).getFecha().isAfter(fecha)) {
				inicio = mitad;
				mitad = (fin + inicio)/2;
			}
			else if(Citas.get(mitad).getFecha().isBefore(fecha)) {
				fin = mitad;
				mitad = (fin + inicio)/2;
			}
		}
		// Si al final no encontre la cita, es por que no existe.
		throw new Exception("El paciente esta disponible a esta hora.  La cita no existe");		
	}
	public void addMedicamento(String codigo, String nombre, int cantidadMg, String tipo, LocalDateTime fechaVen) {
		Medicamento p = new Medicamento(codigo, nombre, cantidadMg, tipo, fechaVen, codigo);
		Medicamentos = Arrays.copyOf(Medicamentos, Medicamentos.length + 1);
		Medicamentos[Medicamentos.length - 1] = p;
	}

	public Paciente buscarPaciente(String CC) throws ENoExiste {
		int i = 0;
		while (i < Pacientes.length && !Pacientes[i++].getCC().equals(CC))
			;
		if (i <= Pacientes.length) {
			return Pacientes[i - 1];
		} else {
			throw new ENoExiste("El Paciente no Existe");
		}
	}

	public Doctor buscarDoctor(String CC) throws ENoExiste {
		int i = 0;
		while (i < Doctores.length && !Doctores[i++].getCC().equals(CC));
		if (i <= Doctores.length) {
			return Doctores[i-1];
		} else {
			throw new ENoExiste("El Doctor no Existe");
		}
	}

	public Medicamento buscarMedicamento(String Codigo) throws ENoExiste {
		int i = 0;
		while (i < Medicamentos.length && !Medicamentos[i++].getCUM().equals(Codigo))
			;
		if (i <= Medicamentos.length) {
			return Medicamentos[i - 1];
		} else {
			throw new ENoExiste("El Medicamento no Existe");
		}
	}
	public Medicamento buscarMedicamento(String nombre, int cantMg) throws ENoExiste {
		int i =0;
		while(i<Medicamentos.length && !Medicamentos[i].getNombre().equals(nombre) && Medicamentos[i].getCantidadMg()!=cantMg) {
			i++;
		}
		if(i<Medicamentos.length) {
			return Medicamentos[i];
		}
		throw new ENoExiste("El medicamento no se encuentra");
	}

	public void writePacientesObj(String file) throws FileNotFoundException, IOException {
		for (int i = 0; i < Pacientes.length; i++) {
			Pacientes[i].writeObjeto(file+"\\"+i+".paciente");
		}
	}
	
	public void readPacientesObj(String address) throws IOException, ClassNotFoundException {
		File f = new File(address);
		File[] listaF = f.listFiles(new Filtro(".paciente"));
		if(listaF !=null) {
			Pacientes = new Paciente[listaF.length];
		for (int i = 0; i < listaF.length; i++) {
			FileInputStream in = new FileInputStream(listaF[i]);
			ObjectInputStream ois = new ObjectInputStream(in);
			Pacientes[i] = (Paciente)ois.readObject();
			ois.close();
			in.close();
		}
		}
	}
	public void writeDoctoresObj(String file) throws FileNotFoundException, IOException {
		for (int i = 0; i < Doctores.length; i++) {
			Doctores[i].writeObjeto(file+"\\"+i+".doctor");
		}
	}
	
	public void readDoctoresObj(String address) throws IOException, ClassNotFoundException {
		File f = new File(address);
		File[] listaF = f.listFiles(new Filtro(".doctor"));
			Doctores = new Doctor[listaF.length];
		for (int i = 0; i < listaF.length; i++) {
			FileInputStream in = new FileInputStream(listaF[i]);
			ObjectInputStream ois = new ObjectInputStream(in);
			Doctores[i] = (Doctor)ois.readObject();
			ois.close();
			in.close();
		
		}
 	}
	
	public void writeCitasObj(String file) throws FileNotFoundException, IOException {
		for (int i = 0; i < Citas.size(); i++) {
			Citas.get(i).writeObjeto(file+"\\"+i+".cita");
		}
		
	}
	
	public void readCitasObj(String address) throws IOException, ClassNotFoundException {
		File f = new File(address);
		File[] listaF = f.listFiles(new Filtro(".cita"));
		Citas = new ArrayList<Cita>();
		if(listaF!=null) {
		for (int i = 0; i < listaF.length; i++) {
			FileInputStream in = new FileInputStream(listaF[i]);
			ObjectInputStream ois = new ObjectInputStream(in);
			Citas.add(i, (Cita)ois.readObject()); 
			ois.close();
			in.close();
		}
		}
 	}
	
	public void writeMedicamentosObj(String file) throws FileNotFoundException, IOException {
		for (int i = 0; i < Medicamentos.length; i++) {
			Medicamentos[i].writeObjeto(file+"\\"+i+".medic");
		}
		
	}
	
	public void readMedicamentosObj(String address) throws IOException, ClassNotFoundException {
		File f = new File(address);
		File[] listaF = f.listFiles(new Filtro(".medic"));
		if(listaF!=null) {
		Medicamentos = new Medicamento[listaF.length];
		for (int i = 0; i < listaF.length; i++) {
			FileInputStream in = new FileInputStream(listaF[i]);
			ObjectInputStream ois = new ObjectInputStream(in);
			Medicamentos[i] = (Medicamento)ois.readObject();
			ois.close();
			in.close();
		}
		}
 	}
}




class Filtro implements FilenameFilter{
	private String extension;
	public Filtro(String extension) {
		super();
		this.extension=extension;	
	}
	public boolean accept(File ruta, String file) {
		return file.endsWith(extension);
	}
}