package model;

public class BrojTelefona {
	
	private int idBrojTelefona;
	private String numeracija;
	private String status; //dal je "boolean" ili nesto drugo?
	
	public BrojTelefona() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BrojTelefona(int idBrojTelefona, String numeracija, String status) {
		super();
		this.idBrojTelefona = idBrojTelefona;
		this.numeracija = numeracija;
		this.status = status;
	}
	

	public BrojTelefona(String numeracija, String status) {
		super();
		this.numeracija = numeracija;
		this.status = status;
	}

	public int getIdBrojTelefona() {
		return idBrojTelefona;
	}

	public void setIdBrojTelefona(int idBrojTelefona) {
		this.idBrojTelefona = idBrojTelefona;
	}

	public String getNumeracija() {
		return numeracija;
	}

	public void setNumeracija(String numeracija) {
		this.numeracija = numeracija;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return idBrojTelefona + "  " + numeracija + " status " + status;
	}
	
}
