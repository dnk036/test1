package model;

public class PripaidIDodatnaOprema {
	
	private int idPripaidIDodatnaOprema;
	private String tip;
	private String naziv;
	private String opis;  // mozda umesto "String" TRENA "TEXT"
	private float cena;
	
	public PripaidIDodatnaOprema() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PripaidIDodatnaOprema(int idPripaidIDodatnaOprema, String tip, String naziv, String opis, float cena) {
		super();
		this.idPripaidIDodatnaOprema = idPripaidIDodatnaOprema;
		this.tip = tip;
		this.naziv = naziv;
		this.opis = opis;
		this.cena = cena;
	}
	
	
	public PripaidIDodatnaOprema(String tip, String naziv, String opis, float cena) {
		super();
		this.tip = tip;
		this.naziv = naziv;
		this.opis = opis;
		this.cena = cena;
	}
	public int getIdPripaidIDodatnaOprema() {
		return idPripaidIDodatnaOprema;
	}
	public void setIdPripaidDodatnaOprema(int idPripaidIDodatnaOprema) {
		this.idPripaidIDodatnaOprema = idPripaidIDodatnaOprema;
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
		return idPripaidIDodatnaOprema + "  " + tip + "  " + naziv + "  " + opis + "  " + cena;
	}
	
}
