package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.SystemColor;

public class AgregarAsignatura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textAnio;
	private JTextField textSemestre;
	private JTextField textHoras;

	
	public AgregarAsignatura() {
		
		
		setTitle("Agregar Asignatura");
        setBounds(100, 100, 900, 650);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(UIManager.getColor("textHighlightText"));
        
        
     // Configuración del panel principal
        contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        contentPanel.setBackground(SystemColor.menu);
        
        
     // Panel de título
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBounds(0, 0, 880, 50);
        panelTitulo.setBackground(SystemColor.textHighlight);
        panelTitulo.setLayout(new BorderLayout());
       

        JLabel lblTitulo = new JLabel("AGREGAR ASIGNATURA", SwingConstants.CENTER);
        lblTitulo.setBackground(SystemColor.text);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        panelTitulo.add(lblTitulo, BorderLayout.CENTER);
        contentPanel.add(panelTitulo);
        
     // Panel de asignatura
        JPanel panelDatos = new JPanel();
        panelDatos.setBounds(243, 155, 420, 292);
        panelDatos.setBackground(SystemColor.text);
        panelDatos.setBorder(BorderFactory.createTitledBorder(
                null, "Asignatura", TitledBorder.LEFT, TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 14)));
        panelDatos.setLayout(null);
        contentPanel.add(panelDatos);
        
        //nombre
        JLabel eNombre = new JLabel("Nombre:");
        eNombre.setFont(new Font("Arial", Font.PLAIN, 18));
        eNombre.setBounds(20, 70, 150, 20);
        panelDatos.add(eNombre);

        textNombre = new JTextField();
        textNombre.setBounds(97, 69, 180, 25);
        textNombre.setFont(new Font("Arial", Font.PLAIN, 12));
        panelDatos.add(textNombre);
        
        // Campo Total Guardias
        JLabel lblTotalDeGuardias = new JLabel("Total de Guardias:");
        lblTotalDeGuardias.setFont(new Font("Arial", Font.PLAIN, 12));
        lblTotalDeGuardias.setBounds(20, 70, 150, 20);
        panelAcademico.add(lblTotalDeGuardias);

        textTotalGuardias = new JTextField("0");
        textTotalGuardias.setBounds(180, 70, 180, 25);
        textTotalGuardias.setFont(new Font("Arial", Font.PLAIN, 12));
        panelAcademico.add(textTotalGuardias);

        // Campo Total Guardias
        JLabel lblTotalDeGuardias = new JLabel("Total de Guardias:");
        lblTotalDeGuardias.setFont(new Font("Arial", Font.PLAIN, 12));
        lblTotalDeGuardias.setBounds(20, 70, 150, 20);
        panelAcademico.add(lblTotalDeGuardias);

        textTotalGuardias = new JTextField("0");
        textTotalGuardias.setBounds(180, 70, 180, 25);
        textTotalGuardias.setFont(new Font("Arial", Font.PLAIN, 12));
        panelAcademico.add(textTotalGuardias);

        // Campo Total Guardias
        JLabel lblTotalDeGuardias = new JLabel("Total de Guardias:");
        lblTotalDeGuardias.setFont(new Font("Arial", Font.PLAIN, 12));
        lblTotalDeGuardias.setBounds(20, 70, 150, 20);
        panelAcademico.add(lblTotalDeGuardias);

        textTotalGuardias = new JTextField("0");
        textTotalGuardias.setBounds(180, 70, 180, 25);
        textTotalGuardias.setFont(new Font("Arial", Font.PLAIN, 12));
        panelAcademico.add(textTotalGuardias);

	}
}	
	


