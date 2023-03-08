import java.util.Date;
enum Status {AGENDADA, CANCELADA, TERMINADA};
public class Cita {
    private Date fecha;
    private Doctor doctor;
    private Paciente paciente;
    private String sintomas;
    private String diagnostico;
    private Status estado;
    private boolean recordada;
    private String seguro;
    private String notasAdicionales;

    public Cita (Paciente paciente, Doctor doc, Date fecha) {
        this.fecha = fecha;
        this.doctor = doc;
        this.paciente = paciente;
        this.estado = Status.AGENDADA;
        this.recordada = false;
    }


    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

}
