import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Hospital {

	private Paciente[] Pacientes;
	private Doctor[] Doctores;
	private ArrayList<Cita> Citas;
	private Medicamento[] Medicamentos;

	public Hospital() {
		Pacientes = new Paciente[0];
		Doctores = new Doctor[0];
		Citas = new ArrayList<Cita>();
	}
	
	public Hospital(Paciente[] pacientes, Doctor[] doctores) {
		Pacientes = pacientes;
		Doctores = doctores;
		Citas = new ArrayList<Cita>();
	}

	public void addPaciente(String Nombre, int Edad, String CC) {
		Paciente p = new Paciente(Nombre, Edad, CC);
		Pacientes = Arrays.copyOf(Pacientes, Pacientes.length + 1);
		Pacientes[Pacientes.length - 1] = p;
	}

	public void addDoctor(String Nombre, int Edad, String CC, String Especialidad) {
		Doctor p = new Doctor(Nombre, CC, Edad, Especialidad);
		Doctores = Arrays.copyOf(Doctores, Doctores.length + 1);
		Doctores[Doctores.length - 1] = p;
	}

	public void addCita(Paciente paciente, Doctor doctor, LocalDateTime fecha) throws ENoExiste{
		// Se crea la cita para agregar a la LinkedList
		Cita p = new Cita(paciente, doctor, fecha);
		//Se revisan casos extremos - Citas es vacio
		if (Citas.size() == 0) {
			Citas.add(p);
		}
		// La fecha nueva es después de la ultima fecha en la lista ordenada
		else if(Citas.get(Citas.size()-1).getFecha().isAfter(fecha)) {
			Citas.add(p);
		}
		// La fecha nueva es antes de la primera fecha en la lista
		else if (Citas.get(0).getFecha().isBefore(fecha)) {
			Citas.add(0, p);
		}
		// De otro caso, tiene que ir un un lugar en la mitad

		// Se utiliza el metodo de binary Search para encontrar el lugar donde debe de ir
		// Se busca en la mitad, si la fecha es despues, entonces se busca en la mitad de la
		// mitad posterior, si es antes, se busca en la primera mitad

		// Asi sucesivamente haste encontrar el lugar optimo
		else {
			// Se declaran las variables inicio, fin, y mitad
			int inicio = 0;
			int fin = Citas.size();
			int mitad = (fin + inicio) /2;
			// Código se repite mientras que fin y inicio tengan al menos una cita en la
			// mitad.  Cuando la diferencia sea 1 o menor, se sabe ya donde va la cita
			while (fin - inicio > 1) {
				// Si el doctor esta ocupado entonces no se puede angendar una cita
				if (Citas.get(mitad).getDoctor().equals(doctor) && Citas.get(mitad).getFecha().isEqual(fecha)) {
					throw new ENoExiste("Doctor ocupado a esta hora.  Porfavor intente otra hora");
				}
				// Si la cita esta despues de la cita en la mitad de la LL
				// busco solo en la segunda mitad
				else if(Citas.get(mitad).getFecha().isAfter(fecha)) {
					inicio = mitad;
					mitad = (fin + inicio)/2;
				}
				// De lo contrario buco en la primera mitad
				else if(Citas.get(mitad).getFecha().isBefore(fecha)) {
					fin = mitad;
					mitad = (fin + inicio)/2;
				}
			}
			// Se agrega en la posición que nos dio.
			Citas.add(mitad +1, p);
		}
	}
	public Cita buscarCita (Doctor doc, LocalDateTime fecha) throws Exception{
		// Se evita que el doctor sea null
		if (doc == null) {
            throw new Exception("El doctor no existe");
        }
		// Se revisa la ultima posición
        else if(Citas.get(Citas.size()-1).getFecha().isAfter(fecha)) {
			throw new Exception("El doctor esta disponible a esta hora.  La cita no existe");
		}
		// Se revisa la primera posción
		else if(Citas.get(0).getFecha().isBefore(fecha)) {
			throw new Exception("El doctor esta disponible a esta hora.  La cita no existe");
		}
		// Se crean las variables a usar en la busqueda
		int fin = Citas.size();
        int inicio = 0;
        int mitad = (fin + inicio)/2;
		// Cuando la diferencia sea menos que 1, se sabe si existe o no.
		while(fin - inicio > 1) {
			//Si el doctor es igual y la hora es igual, el doctor esta ocupado
			if (Citas.get(mitad).getDoctor().equals(doc) && Citas.get(mitad).getFecha().isEqual(fecha)) {
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
	public void addMedicamento(String codigo, String nombre, int cantidadMg, String tipo, Date fechaVen) {
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
		while (i < Doctores.length && !Doctores[i++].getCC().equals(CC))
			;
		if (i <= Doctores.length) {
			return Doctores[i - 1];
		} else {
			throw new ENoExiste("El Doctor no Existe");
		}
	}

	public Medicamento buscarMedicamento(String Codigo) throws ENoExiste {
		int i = 0;
		while (i < Medicamentos.length && !Medicamentos[i++].getCodigo().equals(Codigo))
			;
		if (i <= Medicamentos.length) {
			return Medicamentos[i - 1];
		} else {
			throw new ENoExiste("El Medicamento no Existe");
		}
	}
}
