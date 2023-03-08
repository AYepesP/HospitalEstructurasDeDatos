package HospitalEstrucutraDeDatos;
import java.util.Arrays;
import java.util.Date;

public class Hospital {

	private Paciente[] Pacientes;
	private Doctor[] Doctores;
	private Cita[] Citas;
	private Medicamento[] Medicamentos;

	public Hospital(Paciente[] pacientes, Doctor[] doctores, Cita[] citas) {
		Pacientes = new Paciente[0];
		Doctores = new Doctor[0];
		Citas = new Cita[0];
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

	public void addCita(Paciente paciente, Doctor doctor, Date fecha) {
		Cita p = new Cita(paciente, doctor, fecha);
		Citas = Arrays.copyOf(Citas, Citas.length + 1);
		Citas[Citas.length - 1] = p;
	}

	public void addMedicamento(String nombre, int cantidadMg, String tipo, Date fechaVen, String codigo) {
		Medicamento p = new Medicamento(nombre, cantidadMg, tipo, fechaVen, codigo);
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
