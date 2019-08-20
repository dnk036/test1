package view;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import kontroler.Kontroler;
import model.Paket;

public class JTableModelPaket extends AbstractTableModel {
	
	ArrayList<Paket> lista = new ArrayList<>();

	public JTableModelPaket(ArrayList<Paket> lista) {
		super();
		this.lista = lista;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public Object getValueAt(int r, int c) {
		Paket p = lista.get(r);
		switch (c) {
		case 0:
			return p.getIdPaket();
		case 1:
			return p.getTip();
		case 2:
			return p.getNaziv();
		case 3:
			return p.getOpis();
		case 4:
			return p.getCena();
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
			return "TIP";
		case 2:
			return "NAZIV";
		case 3:
			return "OPIS";
		case 4:
			return "CENA";
		default:
			return "Greska";
		}
	}
	
	public ArrayList<Paket> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Paket> lista) {
		this.lista = lista;
	}
	
	public void removeRow(int row) {
		
		try {
			Kontroler.getInstance().deletePaket(lista.get(row).getIdPaket());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		lista.remove(row);
		fireTableDataChanged();

	}
	
}
