package model;

import java.util.Date;

public class UgovorPostpaid {
	
	private int idUgovor;
	private Date datumPocetka;
	private Date datumIsteka;
	private int idUredjaj;
	private int idPaket;
	private int idBrojTelefona;
	
	public UgovorPostpaid() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UgovorPostpaid(int idUgovor, Date datumPocetka, Date datumIsteka, int idUredjaj, int idPaket,
			int idBrojTelefona) {
		super();
		this.idUgovor = idUgovor;
		this.datumPocetka = datumPocetka;
		this.datumIsteka = datumIsteka;
		this.idUredjaj = idUredjaj;
		this.idPaket = idPaket;
		this.idBrojTelefona = idBrojTelefona;
	}

	public int getIdUgovor() {
		return idUgovor;
	}

	public void setIdUgovor(int idUgovor) {
		this.idUgovor = idUgovor;
	}

	public Date getDatumPocetka() {
		return datumPocetka;
	}

	public void setDatumPocetka(Date datumPocetka) {
		this.datumPocetka = datumPocetka;
	}

	public Date getDatumIsteka() {
		return datumIsteka;
	}

	public void setDatumIsteka(Date datumIsteka) {
		this.datumIsteka = datumIsteka;
	}

	public int getIdUredjaj() {
		return idUredjaj;
	}

	public void setIdUredjaj(int idUredjaj) {
		this.idUredjaj = idUredjaj;
	}

	public int getIdPaket() {
		return idPaket;
	}

	public void setIdPaket(int idPaket) {
		this.idPaket = idPaket;
	}

	public int getIdBrojTelefona() {
		return idBrojTelefona;
	}

	public void setIdBrojTelefona(int idBrojTelefona) {
		this.idBrojTelefona = idBrojTelefona;
	}

	@Override
	public String toString() {
		return idUgovor + " " + datumPocetka + " " + datumIsteka + " " + idUredjaj + " " + idPaket + " " + idBrojTelefona;
	}
	
}
