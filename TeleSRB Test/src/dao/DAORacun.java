package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.Racun;



public class DAORacun {
	
	private Connection konekcija = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet rs = null;

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		konekcija = DriverManager.getConnection("jdbc:mysql://localhost/telesrb", "root", "");
	}

	public ArrayList<Racun> getRacun() throws ClassNotFoundException, SQLException {
		ArrayList<Racun> lista = new ArrayList<Racun>();

		connect();
		preparedStatement = konekcija.prepareStatement("select * from racun");
		preparedStatement.execute();

		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			int idRacun = rs.getInt("id_racun");
			Date datumRacun = rs.getDate("datum");
			int idUser = rs.getInt("id_user");
			int idUgovor = rs.getInt("id_ugovor");
			String statusRacuna = rs.getString("status_racuna");
			
			
			Racun r = new Racun(idRacun, datumRacun, idUser, idUgovor, statusRacuna);

			lista.add(r);
		}
		konekcija.close();
		return lista;

	}

	public int insertRacun(Racun r) throws ClassNotFoundException, SQLException {
		connect();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

		String datum = sdf.format(r.getDatumRacun());

		preparedStatement = konekcija.prepareStatement(
				"insert into nabavke(datum, id_user, id_ugovor, status_racuna) values (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

		preparedStatement.setString(1, datum);
		preparedStatement.setInt(2, r.getIdUser());
		preparedStatement.setInt(3, r.getIdUgovor());
		preparedStatement.setString(4, r.getStatusRacuna());

		preparedStatement.execute();

		int generisanId = -1;

		ResultSet rs = preparedStatement.getGeneratedKeys();
		if (rs.next()) {
			generisanId = rs.getInt(1);
		}

		konekcija.close();

		return generisanId;
	}
	
	public void deleteRacun(int id_racun) throws SQLException, ClassNotFoundException {
		connect();
		preparedStatement = konekcija.prepareStatement("delete from racun where id_racun = ?");

		preparedStatement.setInt(1, id_racun);
		
		preparedStatement.execute();
		
		konekcija.close();
		
	}
	
	public int updateRacun(Racun r) throws SQLException, ClassNotFoundException {
		connect();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

		String datum = sdf.format(r.getDatumRacun());
		
		preparedStatement = konekcija.prepareStatement("UPDATE racun SET datum = ?, id_user = ?, id_ugovor = ?, status_racuna = ? WHERE racun.id_racun = ?", Statement.RETURN_GENERATED_KEYS);
		
		preparedStatement.setString(1, datum);
		preparedStatement.setInt(2, r.getIdUser());
		preparedStatement.setInt(3, r.getIdUgovor());
		preparedStatement.setString(4, r.getStatusRacuna());
		preparedStatement.setInt(5, r.getIdRacun());
		
		preparedStatement.execute();
		
		int generisanId = -1;

		ResultSet rs = preparedStatement.getGeneratedKeys();
		if (rs.next()) {
			generisanId = rs.getInt(1);
		}

		konekcija.close();

		return generisanId;
		
	}
	
}
