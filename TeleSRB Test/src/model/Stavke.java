package model;

public class Stavke {
	
	private int idStavke;
	private int idRacun;
	private int idPripaidDodatnaOprema;
	private int kolicina;
	
	public Stavke() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stavke(int idStavke, int idRacun, int idPripaidDodatnaOprema, int kolicina) {
		super();
		this.idStavke = idStavke;
		this.idRacun = idRacun;
		this.idPripaidDodatnaOprema = idPripaidDodatnaOprema;
		this.kolicina = kolicina;
	}
	public int getIdStavke() {
		return idStavke;
	}
	public void setIdStavke(int idStavke) {
		this.idStavke = idStavke;
	}
	public int getIdRacun() {
		return idRacun;
	}
	public void setIdRacun(int idRacun) {
		this.idRacun = idRacun;
	}
	public int getIdPripaidDodatnaOprema() {
		return idPripaidDodatnaOprema;
	}
	public void setIdPripaidDodatnaOprema(int idPripaidDodatnaOprema) {
		this.idPripaidDodatnaOprema = idPripaidDodatnaOprema;
	}
	public int getKolicina() {
		return kolicina;
	}
	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}
	@Override
	public String toString() {
		return idStavke + " " + idRacun + " " + idPripaidDodatnaOprema + " " + kolicina;
	}
	
}
