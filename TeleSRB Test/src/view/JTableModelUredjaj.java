package view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Paket;
import model.Uredjaj;

public class JTableModelUredjaj extends AbstractTableModel {
	
	ArrayList<Uredjaj> lista = new ArrayList<>();

	public JTableModelUredjaj(ArrayList<Uredjaj> lista) {
		super();
		this.lista = lista;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public Object getValueAt(int r, int c) {
		Uredjaj u = lista.get(r);
		switch (c) {
		case 0:
			return u.getIdUredjaj();
		case 1:
			return u.getIdPaket();
		case 2:
			return u.getTip();
		case 3:
			return u.getNaziv();
		case 4:
			return u.getOpis();
		case 5:
			return u.getCena();
		default:
			return "Greska";
		}
	}
	
	@Override
	public String getColumnName(int c) {
		switch (c) {
		case 0:
			return "ID UREDJAJ";
		case 1:
			return "ID PAKET";
		case 2:
			return "TIP";
		case 3:
			return "NAZIV";
		case 4:
			return "OPIS";
		case 5:
			return "CENA";
		default:
			return "Greska";
		}
	}
	
	

}
