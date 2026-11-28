package util;

import javax.swing.table.DefaultTableModel;

public class NoDocenteTableModel extends DefaultTableModel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public NoDocenteTableModel() {
		String[] columnas = {"Carnet de identidad", "Nombre", "Direccion", "Salario", "Area Laboral"};

		setColumnIdentifiers(columnas);
	}

	public void addNoDocente(String carnetId, String nombre, String direccion, String salario, String areaLaboral){
		Object[] datos = {carnetId, nombre, direccion, salario, areaLaboral};

		addRow(datos);
	}

	public void deleteNoDocente(int pos){
		removeRow(pos);
	}

	public void editNoDocente(int pos, String carnetId, String nombre,String direccion, String salario, String areaLaboral){
		setValueAt(carnetId, pos, 0);
		setValueAt(nombre, pos, 1);
		setValueAt(direccion, pos, 2);
		setValueAt(salario, pos, 3);
		setValueAt(areaLaboral, pos, 4);
	}


	@Override
	public boolean isCellEditable(int row, int column){
		return false;
	}

}
