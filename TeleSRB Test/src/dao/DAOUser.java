package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.User;

public class DAOUser {
	
	private Connection konekcija = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet rs = null;

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		konekcija = DriverManager.getConnection("jdbc:mysql://localhost/telesrb", "root", "");
	}
	
	public ArrayList<User> getUser() throws ClassNotFoundException, SQLException {
		ArrayList<User> lista = new ArrayList<User>();

		connect();
		preparedStatement = konekcija.prepareStatement("select * from user");

		preparedStatement.execute();
		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			int idUser = rs.getInt("id_user");
			String ime = rs.getString("ime");
			String prezime = rs.getString("prezime");
			String brojTelefona = rs.getString("broj_telefona");
			String password = rs.getString("password");
			String email = rs.getString("email");
			String userTip = rs.getString("user_tip");
			String adresa = rs.getString("adresa");
			

			User u = new User(idUser, ime, prezime, brojTelefona, password, email, userTip, adresa);

			lista.add(u);
		}
		konekcija.close();
		return lista;
	}

	public void insertUser(User u) throws SQLException, ClassNotFoundException {
		connect();

		preparedStatement = konekcija
				.prepareStatement("INSERT INTO user (ime, prezime, broj_telefona, password, email, user_tip, adresa) VALUES (?, ?, ?, ?, ?, ?, ?)");

		preparedStatement.setString(1, u.getIme());
		preparedStatement.setString(2, u.getPrezime());
		preparedStatement.setString(3, u.getBrojTelefona());
		preparedStatement.setString(4, u.getPassword());
		preparedStatement.setString(5, u.getEmail());
		preparedStatement.setString(6, u.getUserTip());
		preparedStatement.setString(7, u.getAdresa());

		preparedStatement.execute();

		konekcija.close();
		
	}
	
	public void deleteUser(int idUser) throws SQLException, ClassNotFoundException {
		connect();
		preparedStatement = konekcija.prepareStatement("delete from user where id_user = ?");

		preparedStatement.setInt(1, idUser);
		
		preparedStatement.execute();
		
		konekcija.close();
		
	}
	
	public void updateUser(User u) throws SQLException, ClassNotFoundException {
		connect();
		preparedStatement = konekcija.prepareStatement("UPDATE user SET ime = ?, prezime = ?, broj_telefona = ?, password = ?, email = ?, user_tip = ?, adresa = ? WHERE user.id_user = ?");

		preparedStatement.setString(1, u.getIme());
		preparedStatement.setString(2, u.getPrezime());
		preparedStatement.setString(3, u.getBrojTelefona());
		preparedStatement.setString(4, u.getPassword());
		preparedStatement.setString(5, u.getEmail());
		preparedStatement.setString(6, u.getUserTip());
		preparedStatement.setString(7, u.getAdresa());
		preparedStatement.setInt(8, u.getIdUser());
		
		preparedStatement.execute();
		
		konekcija.close();
		
	}

}
