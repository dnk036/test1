package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Paket;
import model.Uredjaj;

public class DAOUredjaj {
	
	private Connection konekcija = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet rs = null;

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		konekcija = DriverManager.getConnection("jdbc:mysql://localhost/telesrb", "root", "");
	}
	
	public ArrayList<Uredjaj> getUredjaj() throws ClassNotFoundException, SQLException {
		ArrayList<Uredjaj> lista = new ArrayList<Uredjaj>();

		connect();
		preparedStatement = konekcija.prepareStatement("select * from uredjaj");

		preparedStatement.execute();
		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			int idUredjaj = rs.getInt("id_uredjaj");
			int idPaket = rs.getInt("id_paket");
			String tip = rs.getString("tip");
			String naziv = rs.getString("naziv");
			String opis = rs.getString("opis");
			float cena = rs.getFloat("cena");
			
			

			Uredjaj u = new Uredjaj(idUredjaj, idPaket, tip, naziv, opis, cena);

			lista.add(u);
		}
		konekcija.close();
		return lista;
	}

	public void insertUredjaj(Uredjaj u) throws SQLException, ClassNotFoundException {
		connect();

		preparedStatement = konekcija
				.prepareStatement("INSERT INTO uredjaj (id_paket, tip, naziv, opis, cena) VALUES (?, ?, ?, ?, ?)");

		preparedStatement.setInt(1, u.getIdPaket());
		preparedStatement.setString(2, u.getTip());
		preparedStatement.setString(3, u.getNaziv());
		preparedStatement.setString(4, u.getOpis());
		preparedStatement.setFloat(5, u.getCena());
		

		preparedStatement.execute();

		konekcija.close();
		
	}
	
	public void deleteUredjajt(int id_uredjaj) throws SQLException, ClassNotFoundException {
		connect();
		preparedStatement = konekcija.prepareStatement("delete from paket where id_uredjaj = ?");

		preparedStatement.setInt(1, id_uredjaj);
		
		preparedStatement.execute();
		
		konekcija.close();
		
	}
	
	public void updateUredjaj(Uredjaj u) throws SQLException, ClassNotFoundException {
		connect();
		preparedStatement = konekcija.prepareStatement("UPDATE uredjaj SET id_paket = ?, tip = ?, naziv = ?, opis = ?, cena = ? WHERE uredjaj.id_uredjaj = ?");

		preparedStatement.setInt(1, u.getIdPaket());
		preparedStatement.setString(2, u.getTip());
		preparedStatement.setString(3, u.getNaziv());
		preparedStatement.setString(4, u.getOpis());
		preparedStatement.setFloat(5, u.getCena());
		preparedStatement.setInt(6, u.getIdUredjaj());
		
		preparedStatement.execute();
		
		konekcija.close();
		
	}
}
