package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Paket;
import model.User;

public class DAOPaket {
	
	private Connection konekcija = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet rs = null;

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		konekcija = DriverManager.getConnection("jdbc:mysql://localhost/telesrb", "root", "");
	}
	
	public ArrayList<Paket> getPaket() throws ClassNotFoundException, SQLException {
		ArrayList<Paket> lista = new ArrayList<Paket>();

		connect();
		preparedStatement = konekcija.prepareStatement("select * from paket");

		preparedStatement.execute();
		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			int idPaket = rs.getInt("id_paket");
			String tip = rs.getString("tip");
			String naziv = rs.getString("naziv");
			String opis = rs.getString("opis");
			float cena = rs.getFloat("cena");
			
			

			Paket p = new Paket(idPaket, tip, naziv, opis, cena);

			lista.add(p);
		}
		konekcija.close();
		return lista;
	}

	public void insertPaket(Paket p) throws SQLException, ClassNotFoundException {
		connect();

		preparedStatement = konekcija
				.prepareStatement("INSERT INTO paket (tip, naziv, opis, cena) VALUES (?, ?, ?, ?)");

		preparedStatement.setString(1, p.getTip());
		preparedStatement.setString(2, p.getNaziv());
		preparedStatement.setString(3, p.getOpis());
		preparedStatement.setFloat(4, p.getCena());
		

		preparedStatement.execute();

		konekcija.close();
		
	}
	
	public void deletePaket(int id_paket) throws SQLException, ClassNotFoundException {
		connect();
		preparedStatement = konekcija.prepareStatement("delete from paket where id_paket = ?");

		preparedStatement.setInt(1, id_paket);
		
		preparedStatement.execute();
		
		konekcija.close();
		
	}
	
	public void updatePaket(Paket p) throws SQLException, ClassNotFoundException {
		connect();
		preparedStatement = konekcija.prepareStatement("UPDATE paket SET tip = ?, naziv = ?, opis = ?, cena = ? WHERE paket.id_paket = ?");

		preparedStatement.setString(1, p.getTip());
		preparedStatement.setString(2, p.getNaziv());
		preparedStatement.setString(3, p.getOpis());
		preparedStatement.setFloat(4, p.getCena());
		preparedStatement.setInt(5, p.getIdPaket());
		
		preparedStatement.execute();
		
		konekcija.close();
		
	}

}
