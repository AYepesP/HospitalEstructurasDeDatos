import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.Date;

enum Status {AGENDADA, CANCELADA, TERMINADA};

public class Cita {
    private LocalDateTime fecha;
    private Doctor doctor;
    private Paciente paciente;
    private String sintomas;
    private String diagnostico;
    private Status estado;
    private boolean recordada;
    private String seguro;
    private String notasAdicionales;

    public Cita (Paciente paciente, Doctor doc, LocalDateTime fecha) throws ENoExiste{
        setFecha(fecha.getYear(), fecha.getMonthValue(), fecha.getDayOfMonth(), fecha.getHour(), fecha.getMinute());
        this.doctor = doc;
        this.paciente = paciente;
        this.estado = Status.AGENDADA;
        this.recordada = false;
    }


    public LocalDateTime getFecha() {
        return this.fecha;
    }
    
    public void setFecha(int año, int mes, int dia, int hora, int min) throws ENoExiste{
        if(año<1900 || mes > 12 || mes<1 || dia<1 || dia>31 || hora<0 || hora> 24 || min <0 || min>60){
            throw new ENoExiste("Fecha Invalida");
        }
        this.fecha = LocalDateTime.of(año, mes, dia, hora, min, min);
    }

    public Doctor getDoctor() {
        return this.doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Paciente getPaciente() {
        return this.paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getSintomas() {
        return this.sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getDiagnostico() {
        return this.diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Status getEstado() {
        return this.estado;
    }

    public void setEstado(Status estado) {
        this.estado = estado;
    }

    public boolean getRecordada() {
        return this.recordada;
    }

    public void setRecordada(boolean recordada) {
        this.recordada = recordada;
    }

    public String getSeguro() {
        return this.seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public String getNotasAdicionales() {
        return this.notasAdicionales;
    }

    public void setNotasAdicionales(String notasAdicionales) {
        this.notasAdicionales = notasAdicionales;
    }

    public void writeObjeto(String adress) throws IOException{
        FileOutputStream f = new FileOutputStream(adress);
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(this);
        o.close();
        f.close();
    }

    public void readObjeto(String adress) throws IOException, ClassNotFoundException{
        FileInputStream in = new FileInputStream(adress);
        ObjectInputStream o = new ObjectInputStream(in);
        Cita citas = (Cita)o.readObject();
        this.doctor = citas.doctor;
        this.paciente = citas.paciente;
        this.estado = citas.estado;
        this.recordada = citas.recordada;
        this.fecha=citas.fecha;
        this.sintomas=citas.sintomas;
        this.seguro=citas.seguro;
        this.diagnostico=citas.diagnostico;
        this.notasAdicionales=citas.notasAdicionales;
        o.close();
        in.close();
    }
}
