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
	private Hospital H = new Hospital();
	private JFrame frame;
	private JFrame AñadirDoctor;
	private JFrame AñadirPaciente;
	private JFrame BuscarPaciente;
	private JFrame BuscarDoctor;
	private JFrame ProgramarCita;
	private JFrame Anadir;
	private JFrame AñadirMedicamento;
	private JComboBox Opciones;
	private JTextField Cedula;
	private JLabel PacienteL;
	private JTextField txtEdadP;
	private JTextField txtCedulaP;
	private JTextField txtNombreP;
	private JTextField txtEdad;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtEspecialidad;
	private JLabel imPantalla;
	private JButton BuscarDoc;
	private JButton BuscarPac;
	private JButton GuardaDoc;
	private JButton GuardaPac;
	private JButton Buscar;
	private JButton Volver;
	private JButton AnadirDoc;
	private JButton AnadirPac;

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
		txtCedulaP = new JTextField("Cedula");
		txtEdadP = new JTextField("Edad");
		txtNombreP = new JTextField("Nombre");
		txtCedula = new JTextField("Cedula");
		txtEdad = new JTextField("Edad");
		txtNombre = new JTextField("Nombre");
		txtEspecialidad = new JTextField("Especialidad");
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		AñadirMedicamento = new JFrame();
		AñadirMedicamento.getContentPane().setBackground(new Color(255, 255, 255));
		AñadirMedicamento.setBounds(100, 100, 800, 550);
		AñadirMedicamento.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AñadirMedicamento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AñadirMedicamento.setTitle("HOSPITAL");
		AñadirMedicamento.getContentPane().setLayout(null);
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		Anadir = new JFrame();
		Anadir.getContentPane().setBackground(new Color(255, 255, 255));
		Anadir.setBounds(100, 100, 800, 550);
		Anadir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Anadir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Anadir.setTitle("HOSPITAL");
		Anadir.getContentPane().setLayout(null);
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		Volver = new JButton("Volver");
		Volver.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Volver.setBounds(70, 425, 130, 42);
		BuscarDoc = new JButton("Guardar");
		BuscarDoc.setBounds(589, 425, 130, 42);
		BuscarDoc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		BuscarPac = new JButton("Guardar");
		BuscarPac.setBounds(589, 425, 130, 42);
		BuscarPac.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Buscar = new JButton("Guardar");
		Buscar.setBounds(589, 425, 130, 42);
		Buscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GuardaPac = new JButton("Guardar");
		GuardaPac.setBounds(589, 425, 130, 42);
		GuardaPac.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GuardaDoc = new JButton("Guardar");
		GuardaDoc.setBounds(589, 425, 130, 42);
		GuardaDoc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		AnadirDoc = new JButton("Añadir Doctor");
		AnadirDoc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		AnadirDoc.setBounds(80, 187, 180, 42);
		AnadirPac = new JButton("Añadir Paciente");
		AnadirPac.setFont(new Font("Tahoma", Font.PLAIN, 18));
		AnadirPac.setBounds(540, 187, 180, 42);

		Opciones = new JComboBox();
		Opciones.setBounds(235, 90, 313, 47);
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

				} else if (Opciones.getSelectedItem().equals("Buscar Paciente")) {

					frame.setVisible(false);
					BuscarPaciente.setVisible(true);

					BuscarPaciente.getContentPane().add(imPantalla);
					Cedula.setBounds(45, 185, 313, 47);
					BuscarPaciente.getContentPane().add(Cedula);
					Cedula.setText("Cedula");
					BuscarPaciente.getContentPane().add(BuscarPac);
					BuscarPaciente.getContentPane().add(Volver);
					BuscarPaciente.getContentPane().add(imPantalla);
					Cedula.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							Cedula.setText("");
						}
					});
					BuscarPac.setText("Buscar");
					BuscarPac.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							if (Cedula.getText() != "") {
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
				} else if (Opciones.getSelectedItem().equals("Buscar Doctor")) {

					frame.setVisible(false);
					BuscarDoctor.setVisible(true);

					imPantalla.setText("");
					Cedula.setBounds(45, 185, 313, 47);
					BuscarDoctor.getContentPane().add(Cedula);
					Cedula.setText("Cedula");
					BuscarDoctor.getContentPane().add(imPantalla);
					BuscarDoctor.getContentPane().add(BuscarDoc);
					BuscarDoctor.getContentPane().add(Volver);
					BuscarDoc.setText("Buscar");
					Volver.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							frame.setVisible(true);
							AñadirDoctor.setVisible(false);
						}
					});
					BuscarDoc.addMouseListener(new MouseAdapter() {
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

				else if (Opciones.getSelectedItem().equals("Añadir")) {

					Anadir.setVisible(true);
					frame.setVisible(false);

					Anadir.getContentPane().add(AnadirPac);
					Anadir.getContentPane().add(AnadirDoc);
					Anadir.getContentPane().add(Volver);

					Volver.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							frame.setVisible(true);
							AñadirDoctor.setVisible(false);
						}
					});
					AnadirDoc.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {

							AñadirDoctor.setVisible(true);
							Anadir.setVisible(false);
							Guardar = true;

							AñadirDoctor.getContentPane().add(GuardaDoc);
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

							Volver.addMouseListener(new MouseAdapter() {
								public void mouseClicked(MouseEvent e) {
									frame.setVisible(true);
									AñadirDoctor.setVisible(false);
								}
							});
							GuardaDoc.addMouseListener(new MouseAdapter() {
								public void mouseClicked(MouseEvent e) {

									if ((txtCedula.getText() != "" || !txtCedula.getText().equals("Cedula"))
											&& (txtEdad.getText() != "" || !txtEdad.getText().equals("Edad"))
											&& (txtEspecialidad.getText() != ""
													|| !txtEspecialidad.getText().equals("Especialidad"))
											&& (txtNombre.getText() != "" || !txtNombre.getText().equals("Nombre"))
											&& Guardar) {
										H.addDoctor(txtNombre.getText(), txtCedula.getText(),
												Integer.parseInt(txtEdad.getText()), txtEspecialidad.getText());
										Guardar = false;
									}
								}
							});
							txtNombre.setText("Nombre");
							txtEdad.setText("Edad");
							txtCedula.setText("Cedula");
							txtEspecialidad.setText("Especialidad");

						}
					});
					AnadirPac.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							Guardar = true;

							AñadirPaciente.setVisible(true);
							frame.setVisible(false);

							txtNombreP.setText("Nombre");
							txtNombreP.setBounds(45, 250, 215, 35);
							AñadirPaciente.getContentPane().add(txtNombreP);

							txtEdadP.setText("Edad");
							txtEdadP.setBounds(270, 250, 215, 35);
							AñadirPaciente.getContentPane().add(txtEdadP);

							txtCedulaP.setText("Cedula");
							txtCedulaP.setBounds(495, 250, 215, 35);
							AñadirPaciente.getContentPane().add(txtCedulaP);

							GuardaPac.setText("Guardar");
							AñadirPaciente.getContentPane().add(Volver);
							AñadirPaciente.getContentPane().add(GuardaPac);

							Volver.addMouseListener(new MouseAdapter() {
								public void mouseClicked(MouseEvent e) {
									frame.setVisible(true);
									AñadirPaciente.setVisible(false);
								}
							});
							GuardaPac.addMouseListener(new MouseAdapter() {
								public void mouseClicked(MouseEvent e) {
									if ((txtCedulaP.getText() != "" || !txtCedulaP.getText().equals("Cedula"))
											&& (txtEdadP.getText() != "" || !txtEdadP.getText().equals("Edad"))
											&& (txtNombreP.getText() != "" || !txtNombreP.getText().equals("Nombre"))
											&& Guardar) {
										H.addPaciente(txtNombreP.getText(), Integer.parseInt(txtEdadP.getText()),
												txtCedulaP.getText());
										Guardar = false;
									}
								}
							});
							txtNombreP.setText("Nombre");
							txtEdadP.setText("Edad");
							txtCedulaP.setText("Cedula");
						}
					});

				}
//				} else if (Opciones.getSelectedItem().equals("Añadir Paciente")) {
//					Guardar = true;
//
//					AñadirPaciente.setVisible(true);
//					frame.setVisible(false);
//
//					txtNombreP.setText("Nombre");
//					txtNombreP.setBounds(45, 250, 215, 35);
//					AñadirPaciente.getContentPane().add(txtNombreP);
//
//					txtEdadP.setText("Edad");
//					txtEdadP.setBounds(270, 250, 215, 35);
//					AñadirPaciente.getContentPane().add(txtEdadP);
//
//					txtCedulaP.setText("Cedula");
//					txtCedulaP.setBounds(495, 250, 215, 35);
//					AñadirPaciente.getContentPane().add(txtCedulaP);
//
//					GuardaBuscar.setText("Guardar");
//					AñadirPaciente.getContentPane().add(Volver);
//					AñadirPaciente.getContentPane().add(GuardaBuscar);
//
//					Volver.addMouseListener(new MouseAdapter() {
//						public void mouseClicked(MouseEvent e) {
//							frame.setVisible(true);
//							AñadirDoctor.setVisible(false);
//						}
//					});
//					GuardaBuscar.addMouseListener(new MouseAdapter() {
//						public void mouseClicked(MouseEvent e) {
//							if ((txtCedulaP.getText() != "" || !txtCedulaP.getText().equals("Cedula"))
//									&& (txtEdadP.getText() != "" || !txtEdadP.getText().equals("Edad"))
//									&& (txtNombreP.getText() != "" || !txtNombreP.getText().equals("Nombre"))
//									&& Guardar) {
//								H.addPaciente(txtNombreP.getText(), Integer.parseInt(txtEdadP.getText()),
//										txtCedulaP.getText());
//								Guardar = false;
//							}
//						}
//					});
//					txtNombreP.setText("Nombre");
//					txtEdadP.setText("Edad");
//					txtCedulaP.setText("Cedula");
//
//				} else if (Opciones.getSelectedItem().equals("Añadir Doctor")) {
//
//					AñadirDoctor.setVisible(true);
//					frame.setVisible(false);
//					Guardar = true;
//
//					AñadirDoctor.getContentPane().add(GuardaBuscar);
//					AñadirDoctor.getContentPane().add(Volver);
//
//					txtNombre.setText("Nombre");
//					txtNombre.setBounds(45, 250, 215, 35);
//					AñadirDoctor.getContentPane().add(txtNombre);
//
//					txtEdad.setText("Edad");
//					txtEdad.setBounds(270, 250, 215, 35);
//					AñadirDoctor.getContentPane().add(txtEdad);
//
//					txtCedula.setText("Cedula");
//					txtCedula.setBounds(495, 250, 215, 35);
//					AñadirDoctor.getContentPane().add(txtCedula);
//
//					txtEspecialidad.setText("Especialidad");
//					txtEspecialidad.setBounds(45, 310, 215, 35);
//					AñadirDoctor.getContentPane().add(txtEspecialidad);
//
//					GuardaBuscar.setText("Guardar");
//
//					Volver.addMouseListener(new MouseAdapter() {
//						public void mouseClicked(MouseEvent e) {
//							frame.setVisible(true);
//							AñadirDoctor.setVisible(false);
//						}
//					});
//					GuardaBuscar.addMouseListener(new MouseAdapter() {
//						public void mouseClicked(MouseEvent e) {
//
//							if ((txtCedula.getText() != "" || !txtCedula.getText().equals("Cedula"))
//									&& (txtEdad.getText() != "" || !txtEdad.getText().equals("Edad"))
//									&& (txtEspecialidad.getText() != ""
//											|| !txtEspecialidad.getText().equals("Especialidad"))
//									&& (txtNombre.getText() != "" || !txtNombre.getText().equals("Nombre"))
//									&& Guardar) {
//								H.addDoctor(txtNombre.getText(), txtCedula.getText(),
//										Integer.parseInt(txtEdad.getText()), txtEspecialidad.getText());
//								Guardar = false;
//							}
//						}
//					});
//					txtNombre.setText("Nombre");
//					txtEdad.setText("Edad");
//					txtCedula.setText("Cedula");
//					txtEspecialidad.setText("Especialidad");
//				} else if (Opciones.getSelectedItem().equals("Añadir Medicamento")) {
				else if (Opciones.getSelectedItem().equals("Programar Cita")) {
					ProgramarCita.setVisible(true);
					frame.setVisible(false);

					ProgramarCita.getContentPane().add(Buscar);
					ProgramarCita.getContentPane().add(Volver);

					DoctorBox.removeAllItems();
					PacienteBox.removeAllItems();

					DoctorBox.addItem("Doctor");
					PacienteBox.addItem("Paciente");

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
					Buscar.setText("Guardar");
					Buscar.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
						}
					});
				}
			}
		});
		Opciones.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Opciones.setModel(
				new DefaultComboBoxModel(new String[] { "", "Programar Cita", "Añadir", "Añadir Medicamento" }));
		frame.getContentPane().add(Opciones);
		frame.getContentPane().add(Buscar);

	}
}
