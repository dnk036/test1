package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.BrojTelefona;
import model.Paket;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOBrojeTelefona {
	
	private Connection konekcija = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet rs = null;

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		konekcija = DriverManager.getConnection("jdbc:mysql://localhost/telesrb", "root", "");
	}
	
	public ArrayList<BrojTelefona> getBrojTelefona() throws ClassNotFoundException, SQLException {
		ArrayList<BrojTelefona> lista = new ArrayList<BrojTelefona>();

		connect();
		preparedStatement = konekcija.prepareStatement("select * from broj_telefona");

		preparedStatement.execute();
		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			int idBrojTelefona = rs.getInt("id_broj_telefona");
			String numeracija = rs.getString("numeracija");
			String status = rs.getString("status");
			

			BrojTelefona bt = new BrojTelefona(idBrojTelefona, numeracija, status);

			lista.add(bt);
		}
		konekcija.close();
		return lista;
	}

	public void insertBrojTelefona(BrojTelefona bt) throws SQLException, ClassNotFoundException {
		connect();

		preparedStatement = konekcija
				.prepareStatement("INSERT INTO broj_telefona (numeracija, status) VALUES (?, ?)");

		preparedStatement.setString(1, bt.getNumeracija());
		preparedStatement.setString(2, bt.getStatus());
		

		preparedStatement.execute();

		konekcija.close();
		
	}
	
	public void deleteBrojTelefona(int id_broj_telefona) throws SQLException, ClassNotFoundException {
		connect();
		preparedStatement = konekcija.prepareStatement("delete from broj_telefona where id_broj_telefona = ?");

		preparedStatement.setInt(1, id_broj_telefona);
		
		preparedStatement.execute();
		
		konekcija.close();
		
	}
	
	public void updateBrojTelefona(BrojTelefona bt) throws SQLException, ClassNotFoundException {
		connect();
		preparedStatement = konekcija.prepareStatement("UPDATE broj_telefona SET numeracija = ?, status = SLOBODAN WHERE broj_telefona.id_broj_telefona = ?");

		preparedStatement.setString(1, bt.getNumeracija());
		preparedStatement.setInt(2, bt.getIdBrojTelefona());
		
		
		preparedStatement.execute();
		
		konekcija.close();
		
	}
	
	public void izmeniStatusBrojaTelefona(int id_broj_telefona, String status) throws ClassNotFoundException, SQLException{
		connect();
		preparedStatement= konekcija.prepareStatement("update broj_telefona set status = ? where id_broj_telefona = ?");
		
		preparedStatement.setString(1, status);
		preparedStatement.setInt(2, id_broj_telefona);
		
		preparedStatement.execute();
		
		konekcija.close();
	}
	
	/*public void updateVrednostNabavke(int id, float vrednost) throws SQLException, ClassNotFoundException {
		connect();

		preparedStatement = konekcija
				.prepareStatement("UPDATE nabavke set vrednost = ?, status = 'ZAVRSENA' WHERE id = ?");

		preparedStatement.setFloat(1, vrednost);
		preparedStatement.setInt(2, id);

		preparedStatement.execute();

		konekcija.close();
		
	}*/
}
