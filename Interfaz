import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;

public class Interfaz {
	boolean Doctor = true;
	boolean Paciente = true;
	boolean Guardar = true;
	private Medicamento[] Medicamentos;
	private Hospital H = new Hospital();
	private JFrame frame;
	private JFrame AñadirDoctor;
	private JFrame AñadirPaciente;
	private JFrame BuscarPaciente;
	private JFrame BuscarDoctor;
	private JFrame ProgramarCita;
	private JComboBox Opciones;
	private JTextField Cedula;
	private JLabel PacienteL;
	private JTextField txtEdad;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtEspecialidad;
	private JLabel imPantalla;
	private JTable table;
	private JButton GuardaBuscar;
	private JButton Volver;
	
	DefaultTableModel ModeloTable = new DefaultTableModel();

	public JFrame getFrame() {
		return frame;
	}

	public Interfaz() {
		initialize();
	}

	public void initialize() {

		JLabel Hospital = new JLabel("Hospital");
		Hospital.setBounds(0, 0, 784, 47);
		Hospital.setHorizontalAlignment(SwingConstants.CENTER);
		Hospital.setFont(new Font("Tahoma", Font.PLAIN, 33));

		imPantalla = new JLabel("");
		imPantalla.setBounds(60, 418, 456, 59);
		imPantalla.setHorizontalAlignment(SwingConstants.CENTER);
		imPantalla.setFont(new Font("Tahoma", Font.PLAIN, 20));

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 800, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.setTitle("HOSPITAL");
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(Hospital);
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		AñadirDoctor = new JFrame();
		AñadirDoctor.getContentPane().setBackground(new Color(255, 255, 255));
		AñadirDoctor.setBounds(100, 100, 800, 550);
		AñadirDoctor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AñadirDoctor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AñadirDoctor.setTitle("HOSPITAL");
		AñadirDoctor.getContentPane().setLayout(null);
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////
		BuscarDoctor = new JFrame();
		BuscarDoctor.getContentPane().setBackground(new Color(255, 255, 255));
		BuscarDoctor.setBounds(100, 100, 800, 550);
		BuscarDoctor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BuscarDoctor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BuscarDoctor.setTitle("HOSPITAL");
		BuscarDoctor.getContentPane().setLayout(null);
		///////////////////////////////////////////////////////////////////////////////////////////////////////
		AñadirPaciente = new JFrame();
		AñadirPaciente.getContentPane().setBackground(new Color(255, 255, 255));
		AñadirPaciente.setBounds(100, 100, 800, 550);
		AñadirPaciente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AñadirPaciente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AñadirPaciente.setTitle("HOSPITAL");
		AñadirPaciente.getContentPane().setLayout(null);
		///////////////////////////////////////////////////////////////////////////////////////////
		BuscarPaciente = new JFrame();
		BuscarPaciente.getContentPane().setBackground(new Color(255, 255, 255));
		BuscarPaciente.setBounds(100, 100, 800, 550);
		BuscarPaciente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BuscarPaciente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BuscarPaciente.setTitle("HOSPITAL");
		BuscarPaciente.getContentPane().setLayout(null);
		//////////////////////////////////////////////////////////////////////////////////////////////////////
		ProgramarCita = new JFrame();
		ProgramarCita.getContentPane().setBackground(new Color(255, 255, 255));
		ProgramarCita.setBounds(100, 100, 800, 550);
		ProgramarCita.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ProgramarCita.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ProgramarCita.setTitle("HOSPITAL");
		ProgramarCita.getContentPane().setLayout(null);
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		Cedula = new JTextField("Cedula");
		Cedula.setOpaque(true);
		txtCedula = new JTextField("Cedula");
		txtEdad = new JTextField("Edad");
		txtNombre = new JTextField("Nombre");
		txtEspecialidad = new JTextField("Especialidad");
		
		Volver = new JButton("Volver");
		Volver.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Volver.setBounds(70, 425, 130, 42);
		GuardaBuscar = new JButton("Guardar");
		GuardaBuscar.setBounds(589, 425, 130, 42);
		GuardaBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		Opciones = new JComboBox();
		Opciones.setBounds(235, 90, 313, 47);

		table = new JTable();
		table.setBounds(103, 158, 359, 108);
		frame.getContentPane().add(table);
		ModeloTable.addColumn("Doctor");
		ModeloTable.addColumn("Paciente");
		ModeloTable.addColumn("Fecha");
		ModeloTable.addColumn("Estado Cita");

		JComboBox DoctorBox = new JComboBox();
		DoctorBox.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JComboBox PacienteBox = new JComboBox();
		PacienteBox.setFont(new Font("Tahoma", Font.PLAIN, 15));

		Opciones.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (H.getDoctores() != null && H.getDoctores().length > 0 && Doctor) {
					Opciones.addItem("Buscar Doctor");
					Doctor = false;
				}
				if (H.getPacientes() != null && H.getPacientes().length > 0 && Paciente) {
					Opciones.addItem("Buscar Paciente");
					Paciente = false;
				}
				if (Opciones.getSelectedItem().equals("")) {
					

				}
				if (Opciones.getSelectedItem().equals("Buscar Paciente")) {
					
					frame.setVisible(false);
					BuscarPaciente.setVisible(true);
					
					BuscarPaciente.getContentPane().add(imPantalla);
					Cedula.setBounds(45, 185, 313, 47);
					BuscarPaciente.getContentPane().add(Cedula);
					Cedula.setText("Cedula");
					BuscarPaciente.getContentPane().add(GuardaBuscar);
					BuscarPaciente.getContentPane().add(Volver);
					BuscarPaciente.getContentPane().add(imPantalla);
					Cedula.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							Cedula.setText("");
						}
					});
					GuardaBuscar.setText("Buscar");
					GuardaBuscar.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							if (Cedula.getText() != "" && Guardar) {
								try {
									imPantalla.setText(H.buscarPaciente(Cedula.getText()).toString());
								} catch (ENoExiste e1) {
									e1.getMessage();
								}
							}
						}
					});

					PacienteL = new JLabel("");
					PacienteL.setFont(new Font("Tahoma", Font.PLAIN, 17));
					PacienteL.setBounds(45, 307, 323, 47);
					frame.getContentPane().add(PacienteL);

					PacienteL.setText("");
				}
				if (Opciones.getSelectedItem().equals("Buscar Doctor")) {
					
					frame.setVisible(false);
					BuscarDoctor.setVisible(true);
					
					imPantalla.setText("");
					Cedula.setBounds(45, 185, 313, 47);
					BuscarDoctor.getContentPane().add(Cedula);
					Cedula.setText("Cedula");
					BuscarDoctor.getContentPane().add(imPantalla);
					BuscarDoctor.getContentPane().add(GuardaBuscar);
					BuscarDoctor.getContentPane().add(Volver);
					
					
					GuardaBuscar.setText("Buscar");
					Volver.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							frame.setVisible(true);
							AñadirDoctor.setVisible(false);
						}
					});
					GuardaBuscar.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							if (Cedula.getText() != "") {
								try {
									imPantalla.setText(H.buscarDoctor(Cedula.getText()).toString());
								} catch (ENoExiste e1) {
									e1.getMessage();
								}
							}
						}
					});
				}
				if (Opciones.getSelectedItem().equals("Añadir Paciente")) {
					Guardar = true;
					
					AñadirPaciente.setVisible(true);
					frame.setVisible(false);
					
					
					txtNombre.setText("Nombre");
					txtNombre.setBounds(45, 250, 215, 35);
					AñadirPaciente.getContentPane().add(txtNombre);

					txtEdad.setText("Edad");
					txtEdad.setBounds(270, 250, 215, 35);
					AñadirPaciente.getContentPane().add(txtEdad);

					txtCedula.setText("Cedula");
					txtCedula.setBounds(495, 250, 215, 35);
					AñadirPaciente.getContentPane().add(txtCedula);

					GuardaBuscar.setText("Guardar");
					AñadirPaciente.getContentPane().add(Volver);
					AñadirPaciente.getContentPane().add(GuardaBuscar);
					
					Volver.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							frame.setVisible(true);
							AñadirDoctor.setVisible(false);
						}
					});
					GuardaBuscar.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							if (txtCedula.getText() != "" && txtEdad.getText() != "" && txtEspecialidad.getText() != ""
									&& txtNombre.getText() != "" && Guardar) {
								H.addPaciente(txtNombre.getText(), Integer.parseInt(txtEdad.getText()),
										txtCedula.getText());
								Guardar = false;
							}
						}
					});

				}
				if (Opciones.getSelectedItem().equals("Añadir Doctor")) {
					
					AñadirDoctor.setVisible(true);
					frame.setVisible(false);
					Guardar = true;
					
					AñadirDoctor.getContentPane().add(GuardaBuscar);
					AñadirDoctor.getContentPane().add(Volver);
					
					txtNombre.setText("Nombre");
					txtNombre.setBounds(45, 250, 215, 35);
					AñadirDoctor.getContentPane().add(txtNombre);
					
					txtEdad.setText("Edad");
					txtEdad.setBounds(270, 250, 215, 35);
					AñadirDoctor.getContentPane().add(txtEdad);

					txtCedula.setText("Cedula");
					txtCedula.setBounds(495, 250, 215, 35);
					AñadirDoctor.getContentPane().add(txtCedula);

					txtEspecialidad.setText("Especialidad");
					txtEspecialidad.setBounds(45, 310, 215, 35);
					AñadirDoctor.getContentPane().add(txtEspecialidad);

					GuardaBuscar.setText("Guardar");
					
					Volver.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							frame.setVisible(true);
							AñadirDoctor.setVisible(false);
						}
					});
					GuardaBuscar.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {

							if (txtCedula.getText() != "" && txtEdad.getText() != "" && txtEspecialidad.getText() != ""
									&& txtNombre.getText() != "" && Guardar) {
								H.addDoctor(txtNombre.getText(), txtCedula.getText(),
										Integer.parseInt(txtEdad.getText()), txtEspecialidad.getText());
								Guardar = false;
							}
						}
					});
				}
				if (Opciones.getSelectedItem().equals("Programar Cita")) {
					ProgramarCita.setVisible(true);
					frame.setVisible(false);
					
					ProgramarCita.getContentPane().add(GuardaBuscar);
					ProgramarCita.getContentPane().add(Volver);
					
					for (Doctor D : H.getDoctores())
						DoctorBox.addItem(D.getNombre());

					for (Paciente P : H.getPacientes())
						PacienteBox.addItem(P.getNombre());

					DoctorBox.setBounds(30, 286, 186, 50);
					ProgramarCita.getContentPane().add(DoctorBox);

					PacienteBox.setBounds(30, 186, 186, 50);
					ProgramarCita.getContentPane().add(PacienteBox);

					Volver.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							frame.setVisible(true);
							AñadirDoctor.setVisible(false);
						}
					});
					GuardaBuscar.setText("Guardar");
					GuardaBuscar.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
						}
					});
				}
			}
		});
		Opciones.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Opciones.setModel(
				new DefaultComboBoxModel(new String[] { "", "Programar Cita", "Añadir Paciente", "Añadir Doctor" }));
		frame.getContentPane().add(Opciones);
		frame.getContentPane().add(GuardaBuscar);
		
	}
}
