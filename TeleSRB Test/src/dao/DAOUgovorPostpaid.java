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
import model.UgovorPostpaid;

public class DAOUgovorPostpaid {

	private Connection konekcija = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet rs = null;

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		konekcija = DriverManager.getConnection("jdbc:mysql://localhost/telesrb", "root", "");
	}
	
	public ArrayList<UgovorPostpaid> getUgovorPostpaid() throws ClassNotFoundException, SQLException {
		ArrayList<UgovorPostpaid> lista = new ArrayList<UgovorPostpaid>();

		connect();
		preparedStatement = konekcija.prepareStatement("select * from ugovor_postpaid");

		preparedStatement.execute();
		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			int idUgovor = rs.getInt("id_ugovor");
			Date datumPocetka = rs.getDate("datun_pocetka");
			Date datumIsteka = rs.getDate("datum_isteka");
			int idUredjaj = rs.getInt("id_uredjaj");
			int idPaket = rs.getInt("id_paket");
			int idBrojTelefona = rs.getInt("id_broj_telefona");
			

			UgovorPostpaid up = new UgovorPostpaid(idUgovor, datumPocetka, datumIsteka, idUredjaj, idPaket, idBrojTelefona);

			lista.add(up);
		}
		konekcija.close();
		return lista;
	}

	// Neznam dal je dobro!!!! PROVERI
	public int insertUgovorPostpaid(UgovorPostpaid up) throws SQLException, ClassNotFoundException {
		connect();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

		String datumPocetka = sdf.format(up.getDatumPocetka());
		String datumIsteka = sdf.format(up.getDatumIsteka());

		preparedStatement = konekcija
				.prepareStatement("INSERT INTO ugovor_postpaid (datum_pocetka, datum_isteka, id_uredjaj, id_paket, id_broj_telefona) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

		
		preparedStatement.setString(1, datumPocetka);
		preparedStatement.setString(2, datumIsteka);
		preparedStatement.setInt(3, up.getIdUredjaj());
		preparedStatement.setInt(4, up.getIdPaket());
		preparedStatement.setInt(5, up.getIdBrojTelefona());
		

		preparedStatement.execute();
		
		int generisanId = -1;

		ResultSet rs = preparedStatement.getGeneratedKeys();
		if (rs.next()) {
			generisanId = rs.getInt(1);
		}

		konekcija.close();
		
		return generisanId;
	}
	
	public void deleteUgovorPostpaid(int id_ugovor) throws SQLException, ClassNotFoundException {
		connect();
		preparedStatement = konekcija.prepareStatement("delete from ugovor_postpaid where id_ugovor = ?");

		preparedStatement.setInt(1, id_ugovor);
		
		preparedStatement.execute();
		
		konekcija.close();
		
	}
	
	public int updateUgovorPostpaid(UgovorPostpaid up) throws SQLException, ClassNotFoundException {
		connect();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

		String datumPocetka = sdf.format(up.getDatumPocetka());
		String datumIsteka = sdf.format(up.getDatumIsteka());
		
		preparedStatement = konekcija.prepareStatement("UPDATE ugovor_postpaid SET datum_pocetka = ?, datum_isteka = ?, id_uredjaj = ?, id_paket = ?, id_broj_telefona = ? WHERE racun.id_ugovor = ?", Statement.RETURN_GENERATED_KEYS);
		
		preparedStatement.setString(1, datumPocetka);
		preparedStatement.setString(2, datumIsteka);
		preparedStatement.setInt(3, up.getIdUredjaj());
		preparedStatement.setInt(4, up.getIdPaket());
		preparedStatement.setInt(5, up.getIdBrojTelefona());
		preparedStatement.setInt(5, up.getIdUgovor());
		
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
