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
		Cita p = new Cita(paciente, doctor, fecha);
		if (Citas.size() == 0) {
			Citas.add(p);
		}
		else if(Citas.get(Citas.size()-1).getFecha().isAfter(fecha)) {
			Citas.add(p);
		}
		else if (Citas.get(0).getFecha().isBefore(fecha)) {
			Citas.add(0, p);
		}
		else {
			int inicio = 0;
			int fin = Citas.size();
			int mitad = (fin + inicio) /2;

			while (fin - inicio > 1) {
				if (Citas.get(mitad).getDoctor().equals(doctor) && Citas.get(mitad).getFecha().isEqual(fecha)) {
					throw new ENoExiste("Doctor ocupado a esta hora.  Porfavor intente otra hora");
				}
				else if(Citas.get(mitad).getFecha().isAfter(fecha)) {
					inicio = mitad;
					mitad = (fin + inicio)/2;
				}
				else if(Citas.get(mitad).getFecha().isBefore(fecha)) {
					fin = mitad;
					mitad = (fin + inicio)/2;
				}
			}
			Citas.add(mitad +1, p);
		}
	}
	public Cita buscarCita (Doctor doc, LocalDateTime fecha) throws Exception{
        System.out.println(Citas.get(0).getFecha().isAfter(fecha));
		if (doc == null) {
            throw new Exception("El doctor no existe");
        }
        else if(Citas.get(Citas.size()-1).getFecha().isAfter(fecha)) {
			throw new Exception("El doctor esta disponible a esta hora.  La cita no existe");
		}
		else if(Citas.get(0).getFecha().isBefore(fecha)) {
			throw new Exception("El doctor esta disponible a esta hora.  La cita no existe");
		}
		int fin = Citas.size();
        int inicio = 0;
        int mitad = (fin + inicio)/2;

		while(fin - inicio > 1) {
			if (Citas.get(mitad).getDoctor().equals(doc) && Citas.get(mitad).getFecha().isEqual(fecha)) {
				return Citas.get(mitad);
			}
			else if (Citas.get(mitad).getFecha().isAfter(fecha)) {
				inicio = mitad;
				mitad = (fin + inicio)/2;
			}
			else if(Citas.get(mitad).getFecha().isBefore(fecha)) {
				fin = mitad;
				mitad = (fin + inicio)/2;
			}
		}
		throw new Exception("El doctor esta disponible a esta hora.  La cita no existe");		
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
