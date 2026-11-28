package util;


import javax.swing.table.DefaultTableModel;

public class EstudianteTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public EstudianteTableModel() {
		String[] columnas = {"Carnet de identidad", "Nombre", "Direccion", "Centro Laboral", "Organismo", "Primer arrastre", "Segundo arrastre"};

		setColumnIdentifiers(columnas);
	}

	public void addEstudiante(String carnetId, String nombre,String direccion, String centroLaboral, String organismo, String priArrastre, String segArrastre){
		Object[] datos = {carnetId, nombre, direccion, centroLaboral, organismo, priArrastre, segArrastre};

		addRow(datos);
	}

	public void deleteEstudiante(int pos){
		removeRow(pos);
	}

	public void editEstudiante(int pos, String carnetId, String nombre,String direccion, String centroLaboral, String organismo, String priArrastre, String segArrastre){
		setValueAt(carnetId, pos, 0);
		setValueAt(nombre, pos, 1);
		setValueAt(direccion, pos, 2);
		setValueAt(centroLaboral, pos, 3);
		setValueAt(organismo, pos, 4);
		setValueAt(priArrastre, pos, 5);
		setValueAt(segArrastre, pos, 6);
	}


	@Override
	public boolean isCellEditable(int row, int column){
		return false;
	}
}
