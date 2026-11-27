package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;

public class AgregarAsignatura extends JDialog {

	private final JPanel contentPanel = new JPanel();

	
	public AgregarAsignatura() {
		setBackground(UIManager.getColor("menu"));
		
		 setTitle("Agregar Estudiante");
	        setBounds(100, 100, 900, 650);
	        setLocationRelativeTo(null);
	        setResizable(false);
	     
	        
	}
}	
	


