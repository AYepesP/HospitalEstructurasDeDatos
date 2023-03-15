import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.time.LocalDateTime;

public class Medicamento {
	private String nombre;
	private int cantidadMg;
	private String tipo;
	private LocalDateTime fechaVencimiento;
	private String CUM;
	
	public Medicamento(String codigo, String nombre, int cantidadMg, String tipo, LocalDateTime fechaVencimiento, String cUM) {
		super();
		this.nombre = nombre;
		this.cantidadMg = cantidadMg;
		this.tipo = tipo;
		this.fechaVencimiento = fechaVencimiento;
		CUM = cUM;
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
		Medicamento medicamento = (Medicamento) o.readObject();
		this.nombre = medicamento.nombre;
		this.cantidadMg = medicamento.cantidadMg;
		this.tipo = medicamento.tipo;
		this.fechaVencimiento = medicamento.fechaVencimiento;
		this.CUM = medicamento.CUM;
		o.close();
		in.close();
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

	public void setCantidadMg(int cantidadMg) {
		this.cantidadMg = cantidadMg;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setFechaVencimiento(LocalDateTime fechaVencimiento) {
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

