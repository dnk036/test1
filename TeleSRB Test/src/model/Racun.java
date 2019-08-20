package model;

import java.util.Date;

public class Racun {
	
	private int idRacun;
	private Date datumRacun;
	private int idUser;
	private int idUgovor;
	private String statusRacuna;
	
	public Racun() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Racun(int idRacun, Date datumRacun, int idUser, int idUgovor, String statusRacuna) {
		super();
		this.idRacun = idRacun;
		this.datumRacun = datumRacun;
		this.idUser = idUser;
		this.idUgovor = idUgovor;
		this.statusRacuna = statusRacuna;
	}
	public int getIdRacun() {
		return idRacun;
	}
	public void setIdRacun(int idRacun) {
		this.idRacun = idRacun;
	}
	public Date getDatumRacun() {
		return datumRacun;
	}
	public void setDatumRacun(Date datumRacun) {
		this.datumRacun = datumRacun;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdUgovor() {
		return idUgovor;
	}
	public void setIdUgovor(int idUgovor) {
		this.idUgovor = idUgovor;
	}
	public String getStatusRacuna() {
		return statusRacuna;
	}
	public void setStatusRacuna(String statusRacuna) {
		this.statusRacuna = statusRacuna;
	}
	@Override
	public String toString() {
		return idRacun + " " + datumRacun + " " + idUser + " " + idUgovor + " " + statusRacuna;
	}
	
}
