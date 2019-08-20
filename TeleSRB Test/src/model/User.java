package model;

public class User {
	
	private int idUser;
	private String ime;
	private String prezime;
	private String brojTelefona;
	private String password;
	private String email;
	private String userTip;
	private String adresa;
	
	

	public User(int idUser, String ime, String prezime, String brojTelefona, String password, String email, String userTip,
			String adresa) {
		super();
		this.idUser = idUser;
		this.ime = ime;
		this.prezime = prezime;
		this.brojTelefona = brojTelefona;
		this.password = password;
		this.email = email;
		this.userTip = userTip;
		this.adresa = adresa;
	}
	
	

	public User(String ime, String prezime, String brojTelefona, String password, String email, String userTip,
			String adresa) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.brojTelefona = brojTelefona;
		this.password = password;
		this.email = email;
		this.userTip = userTip;
		this.adresa = adresa;
	}



	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserTip() {
		return userTip;
	}

	public void setUserTip(String userTip) {
		this.userTip = userTip;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	@Override
	public String toString() {
		return idUser + " " + ime + " " + prezime + " " + brojTelefona + " " + password + " " + email + " " + userTip + " " + adresa;
	}
	
}
