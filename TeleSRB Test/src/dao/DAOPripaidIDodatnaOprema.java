package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Paket;
import model.PripaidIDodatnaOprema;

public class DAOPripaidIDodatnaOprema {

	private Connection konekcija = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet rs = null;

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		konekcija = DriverManager.getConnection("jdbc:mysql://localhost/telesrb", "root", "");
	}
	
	public ArrayList<PripaidIDodatnaOprema> getPripaidIDodatnaOprema() throws ClassNotFoundException, SQLException {
		ArrayList<PripaidIDodatnaOprema> lista = new ArrayList<PripaidIDodatnaOprema>();

		connect();
		preparedStatement = konekcija.prepareStatement("select * from pripaid_dodatna_oprema");

		preparedStatement.execute();
		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			int idPripaidIDodatnaOprema = rs.getInt("id_pripaid_oprema");
			String tip = rs.getString("tip");
			String naziv = rs.getString("naziv");
			String opis = rs.getString("opis");
			float cena = rs.getFloat("cena");
			
			

			PripaidIDodatnaOprema pido = new PripaidIDodatnaOprema(idPripaidIDodatnaOprema, tip, naziv, opis, cena);

			lista.add(pido);
		}
		konekcija.close();
		return lista;
	}

	public void insertPripaidIDodatnaOprema(PripaidIDodatnaOprema pido) throws SQLException, ClassNotFoundException {
		connect();

		preparedStatement = konekcija
				.prepareStatement("INSERT INTO pripaid_dodatna_oprema (tip, naziv, opis, cena) VALUES (?, ?, ?, ?)");

		preparedStatement.setString(1, pido.getTip());
		preparedStatement.setString(2, pido.getNaziv());
		preparedStatement.setString(3, pido.getOpis());
		preparedStatement.setFloat(4, pido.getCena());
		

		preparedStatement.execute();

		konekcija.close();
		
	}
	
	public void deletePripaidIDodatnaOprema(int id_pripaid_oprema) throws SQLException, ClassNotFoundException {
		connect();
		preparedStatement = konekcija.prepareStatement("delete from pripaid_dodatna_oprema where id_pripaid_oprema = ?");

		preparedStatement.setInt(1, id_pripaid_oprema);
		
		preparedStatement.execute();
		
		konekcija.close();
		
	}
	
	public void updatePripaidIDodatnaOprema(PripaidIDodatnaOprema pido) throws SQLException, ClassNotFoundException {
		connect();
		preparedStatement = konekcija.prepareStatement("UPDATE pripaid_dodatna_oprema SET tip = ?, naziv = ?, opis = ?, cena = ? WHERE pripaid_dodatna_oprema.id_pripaid_oprema = ?");

		preparedStatement.setString(1, pido.getTip());
		preparedStatement.setString(2, pido.getNaziv());
		preparedStatement.setString(3, pido.getOpis());
		preparedStatement.setFloat(4, pido.getCena());
		preparedStatement.setInt(5, pido.getIdPripaidIDodatnaOprema());
		
		preparedStatement.execute();
		
		konekcija.close();
		
	}
}
