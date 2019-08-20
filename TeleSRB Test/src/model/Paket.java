package model;

public class Paket {
	
	private int idPaket;
	private String tip;
	private String naziv;
	private String opis;  // mozda umesto "String" TRENA "TEXT"
	private float cena;
	
	public Paket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Paket(int idPaket, String tip, String naziv, String opis, float cena) {
		super();
		this.idPaket = idPaket;
		this.tip = tip;
		this.naziv = naziv;
		this.opis = opis;
		this.cena = cena;
	}
	
	public Paket(String tip, String naziv, String opis, float cena) {
		super();
		this.tip = tip;
		this.naziv = naziv;
		this.opis = opis;
		this.cena = cena;
	}
	public int getIdPaket() {
		return idPaket;
	}
	public void setIdPaket(int idPaket) {
		this.idPaket = idPaket;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public float getCena() {
		return cena;
	}
	public void setCena(float cena) {
		this.cena = cena;
	}
	@Override
	public String toString() {
		return idPaket + "  " + tip + "  " + naziv + "  " + opis + "  " + cena;
	}
	
}
