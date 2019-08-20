package view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.PripaidIDodatnaOprema;

public class JTableModelPripaidIDodatnaOprema extends AbstractTableModel {
	
	ArrayList<PripaidIDodatnaOprema> lista = new ArrayList<>();

	public JTableModelPripaidIDodatnaOprema(ArrayList<PripaidIDodatnaOprema> lista) {
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
		PripaidIDodatnaOprema pido = lista.get(r);
		switch (c) {
		case 0:
			return pido.getIdPripaidIDodatnaOprema();
		case 1:
			return pido.getTip();
		case 2:
			return pido.getNaziv();
		case 3:
			return pido.getOpis();
		case 4:
			return pido.getCena();
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

}
