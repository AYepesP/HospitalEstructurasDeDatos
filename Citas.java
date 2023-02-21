import java.util.Date;
enum Status {AGENDADA, CANCELADA, TERMINADA};
public class Citas {
    private Date fecha;
    private Doctor doctor;
    private Paciente paciente;
    private String sintomas;
    private String diagnostico;
    private Status estado;
    private boolean recordada;
    private String seguro;
    private String notasAdicionales;

    public Cita (Date fecha, Doctor doc, Paciente paciente) {
        this.fecha = fecha;
        this.doctor = doc;
        this.paciente = paciente;
        this.estado = Status.AGENDADA;
        this.recordada = false;
    }

}
