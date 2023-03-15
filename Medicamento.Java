import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;

public class Medicamento {
	private String nombre;
	private int cantidadMg;
	private String tipo;
	private LocalDateTime fechaVencimiento;
	private String CUM;
	
	public Medicamento(String codigo, String nombre, int cantidadMg, String tipo, LocalDateTime fechaVencimiento, String cUM) throws ENoExiste{
		super();
		this.nombre = nombre;
		this.cantidadMg = cantidadMg;
		this.tipo = tipo;
		setFechaVencimiento(fechaVencimiento);
		CUM = cUM;
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

	public LocalDateTime getFechaVencimiento() {
		return fechaVencimiento;
	}

	public String getCUM() {
		return CUM;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCantidadMg(int cantidadMg) throws ENoExiste{
		if (cantidadMg < 1) {
			throw new ENoExiste("Cantidad de Miligramos invalida");
		}
		this.cantidadMg = cantidadMg;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setFechaVencimiento(LocalDateTime fechaVencimiento) throws ENoExiste{
		if (fechaVencimiento.getYear() < 1900 ||  fechaVencimiento.getMonthValue() < 0 || fechaVencimiento.getDayOfMonth() > 31 || 
		fechaVencimiento.getDayOfMonth() < 0 || fechaVencimiento.getHour() > 24 || fechaVencimiento.getHour() < 0 || fechaVencimiento.getMinute() < 0 ||
		fechaVencimiento.getMinute() > 60) {
			throw new ENoExiste("Fecha de vencimiento invalida");
		}
		this.fechaVencimiento = fechaVencimiento;
	}

	public void setCUM(String cUM) {
		CUM = cUM;
	}
	
	public void writeObjeto(String adress) throws IOException {
		FileOutputStream f = new FileOutputStream(adress);
		ObjectOutputStream o = new ObjectOutputStream(f);
		o.writeObject(this);
		o.close();
		f.close();
	}
	// Deberia de ser File
	public void readObjeto(String adress) throws IOException, ClassNotFoundException {
		FileInputStream in = new FileInputStream(adress);
		ObjectInputStream o = new ObjectInputStream(in);
		Medicamento medicamento = (Medicamento) o.readObject();
		this.nombre = medicamento.nombre;
		this.cantidadMg = medicamento.cantidadMg;
		this.tipo = medicamento.tipo;
		this.fechaVencimiento = medicamento.fechaVencimiento;
		this.CUM = medicamento.CUM;
		o.close();
		in.close();
	}
}

