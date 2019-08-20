package view;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import kontroler.Kontroler;
import model.BrojTelefona;

public class JTableModelBrojTelefona extends AbstractTableModel{
	
	ArrayList<BrojTelefona> lista = new ArrayList<>();

	public JTableModelBrojTelefona(ArrayList<BrojTelefona> lista) {
		super();
		this.lista = lista;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int r, int c) {
		BrojTelefona br = lista.get(r);
		switch (c) {
		case 0:
			return br.getIdBrojTelefona();
		case 1:
			return br.getNumeracija();
		case 2:
			return br.getStatus();
		default:
			return "Greska";
		}
	}
	
	@Override
	public String getColumnName(int c) {
		switch (c) {
		case 0:
			return "ID";
		case 1:
			return "NUMERACIJA";
		case 2:
			return "STATUS";
		default:
			return "Greska";
		}
	}

	public ArrayList<BrojTelefona> getLista() {
		return lista;
	}

	public void setLista(ArrayList<BrojTelefona> lista) {
		this.lista = lista;
	}
	
	public void removeRow(int row) {
		try {
			Kontroler.getInstance().deleteBrojTelefona(lista.get(row).getIdBrojTelefona());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lista.remove(row);
		fireTableDataChanged();
	}
	

}
