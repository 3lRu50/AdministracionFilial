package interfaz;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.SystemColor;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import logica.PlanEstudio;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class AgregarAsignatura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private PlanEstudio plan;
	private Principal padre;
	private JTextField textHoras;
	private JComboBox<String> comboBoxSemestre;
	private JComboBox<String> comboBoxAnios;
	private JTextField textNombre;
	private String nombre;
	private int anio = -1;
	private int semestre = -1;
	private int horas;

	public static void main(String[] args){
	try {
		AgregarAsignatura dialog = new AgregarAsignatura(principal, PlanEstudio.getInstancia());
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	} catch (Exception e) {
		e.printStackTrace();
	}
	}	
	
	
	public AgregarAsignatura(Principal pric, PlanEstudio p) {
		super(princ,true);
		padre = princ;
		plan = p;
		setTitle("Agregar Asignatura");
        setBounds(100, 100, 500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(UIManager.getColor("textHighlightText"));
        
        
     // Configuración del panel principal
        contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setBackground(SystemColor.menu);
        contentPanel.setLayout(null);
        
        
     // Panel de título
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBounds(0, 0, 500, 50);
        panelTitulo.setBackground(SystemColor.textHighlight);
        panelTitulo.setLayout(new BorderLayout());
       

        JLabel lblTitulo = new JLabel("AGREGAR ASIGNATURA", SwingConstants.CENTER);
        lblTitulo.setBackground(SystemColor.text);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        panelTitulo.add(lblTitulo, BorderLayout.CENTER);
        contentPanel.add(panelTitulo);
        
     // Panel de asignatura
        JPanel panelDatos = new JPanel();
        panelDatos.setBounds(29, 102, 420, 292);
        panelDatos.setBackground(SystemColor.text);
        panelDatos.setBorder(BorderFactory.createTitledBorder(
                null, "Asignatura", TitledBorder.LEFT, TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 14)));
        panelDatos.setLayout(null);
        contentPanel.add(panelDatos);
        
        //nombre
        JLabel eNombre = new JLabel("Nombre:");
        eNombre.setFont(new Font("Arial", Font.PLAIN, 18));
        eNombre.setBounds(20, 47, 73, 20);
        panelDatos.add(eNombre);

        textNombre = new JTextField();
        textNombre.setBounds(103, 46, 218, 25);
        textNombre.setFont(new Font("Arial", Font.PLAIN, 12));
        panelDatos.add(textNombre);
        
        // Semestre
        JLabel lblSemestre = new JLabel("Semestre:");
        lblSemestre.setFont(new Font("Arial", Font.PLAIN, 18));
        lblSemestre.setBounds(188, 82, 90, 20);
        panelDatos.add(lblSemestre);

        comboBoxSemestre = new JComboBox<String>();
        comboBoxSemestre.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2"}));
        comboBoxSemestre.setSelectedIndex(-1);
        semestre = -1;
        
        comboBoxSemestre.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent arg0) {
        		if (arg0.getStateChange() == ItemEvent.SELECTED) {
                     semestre = Integer.parseInt(
                        (String) comboBoxSemestre.getSelectedItem()
                    );
                }
        	}
        });
        
        comboBoxSemestre.setBounds(271, 82, 99, 20);
        comboBoxSemestre.setSelectedIndex(-1);
        panelDatos.add(comboBoxSemestre);

        
        // Anio
        JLabel lblAnio = new JLabel("Año:");
        lblAnio.setFont(new Font("Arial", Font.PLAIN, 18));
        lblAnio.setBounds(20, 81, 39, 20);
        panelDatos.add(lblAnio);
        
        comboBoxAnios = new JComboBox<String>();
        comboBoxAnios.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6"}));
        comboBoxAnios.setSelectedIndex(-1);
        anio = -1;
        
        comboBoxAnios.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent arg0) {
        		if (arg0.getStateChange() == ItemEvent.SELECTED) {
                    anio = Integer.parseInt(
                        (String) comboBoxAnios.getSelectedItem()
                    );
                }
        	}
        });
       
        comboBoxAnios.setBounds(69, 83, 64, 20);
        panelDatos.add(comboBoxAnios);
        
     // Cant Horas
        JLabel lblHoras = new JLabel("Horas Lectivas:");
        lblHoras.setFont(new Font("Arial", Font.PLAIN, 18));
        lblHoras.setBounds(69, 126, 147, 20);
        panelDatos.add(lblHoras);

        textHoras = new JTextField(" ");
        textHoras.setBounds(69, 157, 123, 25);
        textHoras.setFont(new Font("Arial", Font.PLAIN, 12));
        panelDatos.add(textHoras);
        
        //cancelar
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		dispose();
        	}
        });
        btnCancelar.setToolTipText("cancelar");
        btnCancelar.setBounds(69, 213, 115, 37);
        panelDatos.add(btnCancelar);
        
        //agregar
        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		agregarAsignatura();
        	}
        });
        btnAgregar.setToolTipText("agregar");
        btnAgregar.setBounds(216, 213, 115, 37);
        panelDatos.add(btnAgregar);

        
	}


private void agregarAsignatura(){
	
	boolean validacionExitosa = true;
	nombre = textNombre.getText().trim();
	String horasTxt = textHoras.getText().trim();
	horas = 0;
	
	if(nombre.isEmpty()){
		JOptionPane.showMessageDialog(this,
	            "El campo 'Nombre' no puede estar vacío",
	            "Error", JOptionPane.ERROR_MESSAGE);
	        textNombre.requestFocusInWindow();
	        validacionExitosa = false;
	}else if(anio == -1){
		JOptionPane.showMessageDialog(this,
	            "El campo 'Año' no puede estar vacío",
	            "Error", JOptionPane.ERROR_MESSAGE);
	        comboBoxAnios.requestFocusInWindow();
	        validacionExitosa = false;
	}else if(semestre == -1){
		JOptionPane.showMessageDialog(this,
	            "El campo 'Semestre' no puede estar vacío",
	            "Error", JOptionPane.ERROR_MESSAGE);
	        comboBoxSemestre.requestFocusInWindow();
	        validacionExitosa = false;
	}else{
		   try {
	            horas = Integer.parseInt(horasTxt);
	            if (horas <= 0) {
	                throw new NumberFormatException();
	            }
	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(this,
	                "Las horas deben ser un número mayor a 0",
	                "Error", JOptionPane.ERROR_MESSAGE);
	            textHoras.requestFocusInWindow();
	            validacionExitosa = false;
	        }
	}
	if(validacionExitosa){
		
		  try {
	            plan.agregarAsignatura(nombre, anio, semestre, horas);
	            JOptionPane.showMessageDialog(this, "Asignatura agregada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();

	        } catch (IllegalArgumentException ex) {
	            JOptionPane.showMessageDialog(this, "Error al crear la Asignatura: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        }
		
	}
	
}



private void limpiarCampos() {
    textNombre.setText("");
    comboBoxSemestre.setSelectedIndex(-1);
    comboBoxAnios.setSelectedIndex(-1);
    textHoras.setText("");
}

}	


