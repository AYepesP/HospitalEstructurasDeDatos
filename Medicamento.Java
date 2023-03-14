import java.util.Arrays;
import java.util.Date;

public class Medicamento {
	private String codigo;
	private String nombre;
	private int cantidadMg;
	private String tipo;
	private Date fechaVencimiento;
	private String CUM;
	
	public Medicamento(String codigo, String nombre, int cantidadMg, String tipo, Date fechaVencimiento, String cUM) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantidadMg = cantidadMg;
		this.tipo = tipo;
		this.fechaVencimiento = fechaVencimiento;
		CUM = cUM;
	}
	public String getCodigo () {
		return this.codigo;
	}
	public void setCodigo (String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}

	public int getCantidadMg() {
		return cantidadMg;
	}

	public String getTipo() {
		return tipo;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public String getCUM() {
		return CUM;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCantidadMg(int cantidadMg) {
		this.cantidadMg = cantidadMg;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public void setCUM(String cUM) {
		CUM = cUM;
	}
	
	
}
class EHospital extends Exception{
	public EHospital(String s){
		super(s);
	}
}
class Hospital {
	private Doctor[] doctores;
	private Paciente [] pacientes;
	private Medicamento [] medicamentos;
	private Cita[] citas;
	
	
	public Hospital() {
		super();
		this.doctores = new Doctor[0];
		this.pacientes = new Paciente[0];
		this.medicamentos = new Medicamento[0];
		this.citas = new Cita[0];
	}


	public 	void addMedicamento(String codigo, String nombre, int cantidadMg, String tipo, Date fechaVencimiento, String cUM) {
		Medicamento newMed = new Medicamento(codigo, nombre, cantidadMg, tipo, fechaVencimiento, cUM);
		medicamentos=Arrays.copyOf(medicamentos, medicamentos.length+1);
		medicamentos[medicamentos.length-1]=newMed;
		
	}
	
	public Medicamento buscarMedIndex(String nombre, int cantMg) throws EHospital {
		int i =0;
		while(i<medicamentos.length && !medicamentos[i].getNombre().equals(nombre) && medicamentos[i].getCantidadMg()!=cantMg) {
			i++;
		}
		if(i<medicamentos.length) {
			return medicamentos[i];
		}
		throw new EHospital("El medicamento no se encuentra");
	}
	
}
