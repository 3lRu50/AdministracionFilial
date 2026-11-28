package util;

import javax.swing.table.DefaultTableModel;

public class ProfesorTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public ProfesorTableModel() {
		String[] columnas = {"Carnet de identidad", "Nombre", "Direccion", "Salario", "Categiría científica", "Categoría docente", "Centro laboral", "Organismo"};

		setColumnIdentifiers(columnas);
	}

	public void addProfesor(String carnetId, String nombre, String direccion, String salario, String catCientifica,String catDocente,
			String centroLaboral, String organismo){
		Object[] datos = {carnetId, nombre, direccion, salario, catCientifica, catDocente, centroLaboral, organismo};

		addRow(datos);
	}

	public void deleteProfesor(int pos){
		removeRow(pos);
	}

	public void editProfesor(int pos, String carnetId, String nombre,String direccion, String salario, String catCientifica, String catDocente, String centroLaboral, String organismo){
		setValueAt(carnetId, pos, 0);
		setValueAt(nombre, pos, 1);
		setValueAt(direccion, pos, 2);
		setValueAt(salario, pos, 3);
		setValueAt(catCientifica, pos, 4);
		setValueAt(catDocente, pos, 5);
		setValueAt(centroLaboral, pos, 6);
		setValueAt(organismo, pos, 7);
	}


	@Override
	public boolean isCellEditable(int row, int column){
		return false;
	}
}
