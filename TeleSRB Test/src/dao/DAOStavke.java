package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Stavke;

public class DAOStavke {

	private Connection konekcija = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet rs = null;

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		konekcija = DriverManager.getConnection("jdbc:mysql://localhost/telesrb", "root", "");
	}
	
	public ArrayList<Stavke> getStavke() throws ClassNotFoundException, SQLException {
		ArrayList<Stavke> lista = new ArrayList<Stavke>();

		connect();
		preparedStatement = konekcija.prepareStatement("select * from stavke");

		preparedStatement.execute();
		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			int idStavke = rs.getInt("id_stavke");
			int idRacun = rs.getInt("id_racun");
			int idPripaidDodatnaOprema = rs.getInt("id_pripaid_oprema");
			int kolicina = rs.getInt("kolicina");
			
			

			Stavke s = new Stavke(idStavke, idRacun, idPripaidDodatnaOprema, kolicina);

			lista.add(s);
		}
		konekcija.close();
		return lista;
	}

	public void insertStavke(Stavke s) throws SQLException, ClassNotFoundException {
		connect();

		preparedStatement = konekcija
				.prepareStatement("INSERT INTO stavke (id_stavke, id_racun, id_pripaid_oprema, kolicina) VALUES (?, ?, ?, ?)");

		preparedStatement.setInt(1, s.getIdStavke());
		preparedStatement.setInt(2, s.getIdRacun());
		preparedStatement.setInt(3, s.getIdPripaidDodatnaOprema());
		preparedStatement.setInt(4, s.getKolicina());

		preparedStatement.execute();

		konekcija.close();
		
	}
	
	public void deleteStavke(int id_stavke) throws SQLException, ClassNotFoundException {
		connect();
		preparedStatement = konekcija.prepareStatement("delete from stavke where id_stavke = ?");

		preparedStatement.setInt(1, id_stavke);
		
		preparedStatement.execute();
		
		konekcija.close();
		
	}
	
	public void updateStavke(Stavke s) throws SQLException, ClassNotFoundException {
		connect();
		preparedStatement = konekcija.prepareStatement("UPDATE stavke SET id_racun = ?, id_pripaid_oprema = ?, kolicina = ? WHERE stavke.id_stavke = ?");

		preparedStatement.setInt(1, s.getIdRacun());
		preparedStatement.setInt(2, s.getIdPripaidDodatnaOprema());
		preparedStatement.setInt(3, s.getKolicina());
		preparedStatement.setInt(4, s.getIdStavke());
		
		preparedStatement.execute();
		
		konekcija.close();
		
	}
}
