package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMain = new JMenu("Main");
		menuBar.add(mnMain);
		
		JMenu mnAos = new JMenu("A\u00F1os");
		menuBar.add(mnAos);
		
		JMenu mnPrimerAo = new JMenu("Primer a\u00F1o");
		mnAos.add(mnPrimerAo);
		
		JMenuItem mntmPlanificacinDocente = new JMenuItem("Planificaci\u00F3n docente");
		mnPrimerAo.add(mntmPlanificacinDocente);
		
		JMenuItem mntmVerGrupos_1 = new JMenuItem("Ver grupos");
		mnPrimerAo.add(mntmVerGrupos_1);
		
		JMenu mnSegundoAo = new JMenu("Segundo a\u00F1o");
		mnAos.add(mnSegundoAo);
		
		JMenuItem mntmPlanificacinDocente_1 = new JMenuItem("Planificaci\u00F3n docente");
		mnSegundoAo.add(mntmPlanificacinDocente_1);
		
		JMenuItem mntmVerGrupos = new JMenuItem("Ver grupos");
		mnSegundoAo.add(mntmVerGrupos);
		
		JMenu mnTercerAo = new JMenu("Tercer a\u00F1o");
		mnAos.add(mnTercerAo);
		
		JMenuItem mntmPlanificacinDocente_2 = new JMenuItem("Planificaci\u00F3n docente");
		mnTercerAo.add(mntmPlanificacinDocente_2);
		
		JMenuItem mntmVerGrupos_2 = new JMenuItem("Ver grupos");
		mnTercerAo.add(mntmVerGrupos_2);
		
		JMenu mnCuartoAo = new JMenu("Cuarto a\u00F1o");
		mnAos.add(mnCuartoAo);
		
		JMenuItem mntmPlanificacinDocente_3 = new JMenuItem("Planificaci\u00F3n docente");
		mnCuartoAo.add(mntmPlanificacinDocente_3);
		
		JMenuItem mntmVerGrupos_3 = new JMenuItem("Ver grupos");
		mnCuartoAo.add(mntmVerGrupos_3);
		
		JMenu mnQuintoAo = new JMenu("Quinto a\u00F1o");
		mnAos.add(mnQuintoAo);
		
		JMenuItem mntmPlanificacinDocente_4 = new JMenuItem("Planificaci\u00F3n docente");
		mnQuintoAo.add(mntmPlanificacinDocente_4);
		
		JMenuItem mntmVerGrupos_5 = new JMenuItem("Ver grupos");
		mnQuintoAo.add(mntmVerGrupos_5);
		
		JMenu mnSextoAo = new JMenu("Sexto a\u00F1o");
		mnAos.add(mnSextoAo);
		
		JMenuItem mntmPlanificacinDocente_5 = new JMenuItem("Planificaci\u00F3n docente");
		mnSextoAo.add(mntmPlanificacinDocente_5);
		
		JMenuItem mntmVerGrupos_4 = new JMenuItem("Ver grupos");
		mnSextoAo.add(mntmVerGrupos_4);
		
		JMenu mnColectivoDeTrabajadores = new JMenu("Colectivo de trabajadores");
		menuBar.add(mnColectivoDeTrabajadores);
		
		JMenu mnProfesores = new JMenu("Profesores");
		mnColectivoDeTrabajadores.add(mnProfesores);
		
		JMenuItem mntmAgregarProfesor = new JMenuItem("Agregar profesor");
		mnProfesores.add(mntmAgregarProfesor);
		
		JMenuItem mntmVerProfesores = new JMenuItem("Ver profesores");
		mnProfesores.add(mntmVerProfesores);
		
		JMenu mnNoDocentes = new JMenu("No docentes");
		mnColectivoDeTrabajadores.add(mnNoDocentes);
		
		JMenuItem mntmVerNoDocentes = new JMenuItem("Ver no docentes");
		mnNoDocentes.add(mntmVerNoDocentes);
		
		JMenuItem mntmAgregarNoDocente = new JMenuItem("Agregar no docente");
		mnNoDocentes.add(mntmAgregarNoDocente);
		
		JMenu mnPlanDeEstudio = new JMenu("Plan de Estudio");
		menuBar.add(mnPlanDeEstudio);
		
		JMenuItem mntmAgregarAsignatura = new JMenuItem("Agregar asignatura");
		mnPlanDeEstudio.add(mntmAgregarAsignatura);
		
		JMenuItem mntmVerAsignaturas = new JMenuItem("Ver asignaturas");
		mnPlanDeEstudio.add(mntmVerAsignaturas);
		
		JMenu mnEstadsticas = new JMenu("Estad\u00EDsticas");
		menuBar.add(mnEstadsticas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
