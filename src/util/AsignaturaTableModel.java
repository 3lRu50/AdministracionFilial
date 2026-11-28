package util;

import javax.swing.table.DefaultTableModel;

public class AsignaturaTableModel extends DefaultTableModel {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public AsignaturaTableModel() {
		String[] columnas = {"Nombre", "Año", "Semestre", "Horas lectivas"};

		setColumnIdentifiers(columnas);
	}

	public void addAsignatura(String nombre,String anio, String semestre, String horasLectiva){
		Object[] datos = {nombre, anio, semestre, horasLectiva};

		addRow(datos);
	}

	public void deleteAsignatura(int pos){
		removeRow(pos);
	}

	public void editAsignatura(int pos, String nombre,String anio, String semestre, String horasLectivas){
		setValueAt(nombre, pos, 0);
		setValueAt(anio, pos, 1);
		setValueAt(semestre, pos, 2);
		setValueAt(horasLectivas, pos, 3);
	}


	@Override
	public boolean isCellEditable(int row, int column){
		return false;
	}

}
