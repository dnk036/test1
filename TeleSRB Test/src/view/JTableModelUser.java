package view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.User;

public class JTableModelUser extends AbstractTableModel {
	
	ArrayList<User> lista = new ArrayList<>();

	public JTableModelUser(ArrayList<User> lista) {
		super();
		this.lista = lista;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return 8;
	}

	@Override
	public Object getValueAt(int r, int c) {
		User u = lista.get(r);
		switch (c) {
		case 0:
			return u.getIdUser();
		case 1:
			return u.getIme();
		case 2:
			return u.getPrezime();
		case 3:
			return u.getBrojTelefona();
		case 4:
			return u.getPassword();
		case 5:
			return u.getEmail();
		case 6:
			return u.getUserTip();
		case 7:
			return u.getAdresa();
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
			return "IME";
		case 2:
			return "PREZIME";
		case 3:
			return "BROJ TELEFONA";
		case 4:
			return "ŠIFRA";
		case 5:
			return "E-MAIL";
		case 6:
			return "TIP";
		case 7:
			return "ADRESA";
		default:
			return "Greska";
		}
	}
	

}
