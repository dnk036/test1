package kontroler;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOBrojeTelefona;
import dao.DAOPaket;
import dao.DAOPripaidIDodatnaOprema;
import dao.DAORacun;
import dao.DAOStavke;
import dao.DAOUgovorPostpaid;
import dao.DAOUredjaj;
import dao.DAOUser;
import model.BrojTelefona;
import model.Paket;
import model.PripaidIDodatnaOprema;
import model.Racun;
import model.Stavke;
import model.UgovorPostpaid;
import model.Uredjaj;
import model.User;

public class Kontroler {
	
	public static Kontroler kontroler;
	
	private Kontroler() {
	}
	
	public static Kontroler getInstance() {
		if (kontroler == null)
			kontroler = new Kontroler();
		return kontroler;
	}
	
	
	// Resavanje DAOUser
	
	public ArrayList<User> getUser() throws ClassNotFoundException, SQLException {
		DAOUser du = new DAOUser();
		ArrayList<User> lista = du.getUser();
		return lista;
	}
	
	public void insertUser(User u) throws SQLException, ClassNotFoundException {
		DAOUser du = new DAOUser();
		du.insertUser(u);
	}
	
	public void deleteUser(int idUser) throws SQLException, ClassNotFoundException {
		DAOUser du = new DAOUser();
		du.deleteUser(idUser);
	}
	
	public void updateUser(User u) throws SQLException, ClassNotFoundException {
		DAOUser du = new DAOUser();
		du.insertUser(u);
	}
	
	
	//Resavanje DAOPaket

	public ArrayList<Paket> getPaket() throws ClassNotFoundException, SQLException {
		DAOPaket dp = new DAOPaket();
		ArrayList<Paket> lista = dp.getPaket();
		return lista;
	}
	
	public void insertPaket(Paket p) throws ClassNotFoundException, SQLException {
		DAOPaket dp = new DAOPaket();
		dp.insertPaket(p);
	}
	
	public void deletePaket(int id_paket) throws SQLException, ClassNotFoundException {
		DAOPaket dp = new DAOPaket();
		dp.deletePaket(id_paket);
	}
	
	public void updatePaket(Paket p) throws SQLException, ClassNotFoundException {
		DAOPaket dp = new DAOPaket();
		dp.insertPaket(p);
	}
	
	
	//Resavanje DAOBrojTelefona
	
	public ArrayList<BrojTelefona> getBrojTelefona() throws ClassNotFoundException, SQLException {
		DAOBrojeTelefona dbt = new DAOBrojeTelefona();
		ArrayList<BrojTelefona> lista = dbt.getBrojTelefona();
		return lista;
	}
	
	public void insertBrojTelefona(BrojTelefona bt) throws SQLException, ClassNotFoundException {
		DAOBrojeTelefona dbt = new DAOBrojeTelefona();
		dbt.insertBrojTelefona(bt);
	}
	
	public void deleteBrojTelefona(int id_broj_telefona) throws SQLException, ClassNotFoundException {
		DAOBrojeTelefona dbt = new DAOBrojeTelefona();
		dbt.deleteBrojTelefona(id_broj_telefona);
	}
	
	public void updateBrojTelefona(BrojTelefona bt) throws SQLException, ClassNotFoundException {
		DAOBrojeTelefona dbt = new DAOBrojeTelefona();
		dbt.updateBrojTelefona(bt);
	}
	
	public void izmeniStatusBrojaTelefona(int id_broj_telefona, String status) throws ClassNotFoundException, SQLException{
		DAOBrojeTelefona dbt = new DAOBrojeTelefona();
		dbt.izmeniStatusBrojaTelefona(id_broj_telefona, status);
	}
	
	
	//Resavanje DAOUredjaj
	
	public ArrayList<Uredjaj> getUredjaj() throws ClassNotFoundException, SQLException {
		DAOUredjaj du = new DAOUredjaj();
		ArrayList<Uredjaj> lista =du.getUredjaj(); 
		return lista;
	}
	
	public void insertUredjaj(Uredjaj u) throws SQLException, ClassNotFoundException {
		DAOUredjaj du = new DAOUredjaj();
		du.insertUredjaj(u);
	}
	
	public void deleteUredjajt(int id_uredjaj) throws SQLException, ClassNotFoundException {
		DAOUredjaj du = new DAOUredjaj();
		du.deleteUredjajt(id_uredjaj);
	}
	
	public void updateUredjaj(Uredjaj u) throws SQLException, ClassNotFoundException {
		DAOUredjaj du = new DAOUredjaj();
		du.updateUredjaj(u);
	}
	
	
	//Resavanje DAOPripaidIDodatnaOprema
	
	public ArrayList<PripaidIDodatnaOprema> getPripaidIDodatnaOprema() throws ClassNotFoundException, SQLException {
		DAOPripaidIDodatnaOprema dpido = new DAOPripaidIDodatnaOprema();
		ArrayList<PripaidIDodatnaOprema> lista = dpido.getPripaidIDodatnaOprema();
		return lista;
	}
	
	public void insertPripaidIDodatnaOprema(PripaidIDodatnaOprema pido) throws SQLException, ClassNotFoundException {
		DAOPripaidIDodatnaOprema dpido = new DAOPripaidIDodatnaOprema();
		dpido.insertPripaidIDodatnaOprema(pido);
	}
	
	public void deletePripaidIDodatnaOprema(int id_pripaid_oprema) throws SQLException, ClassNotFoundException {
		DAOPripaidIDodatnaOprema dpido = new DAOPripaidIDodatnaOprema();
		dpido.deletePripaidIDodatnaOprema(id_pripaid_oprema);
	}
	
	public void updatePripaidIDodatnaOprema(PripaidIDodatnaOprema pido) throws SQLException, ClassNotFoundException {
		DAOPripaidIDodatnaOprema dpido = new DAOPripaidIDodatnaOprema();
		dpido.updatePripaidIDodatnaOprema(pido);
	}
	
	
	//Resavanje DAOStavke
	
	public ArrayList<Stavke> getStavke() throws ClassNotFoundException, SQLException {
		DAOStavke ds = new DAOStavke();
		ArrayList<Stavke> lista = ds.getStavke();
		return lista;
	}
	
	public void insertStavke(Stavke s) throws SQLException, ClassNotFoundException {
		DAOStavke ds = new DAOStavke();
		ds.insertStavke(s);
	}
	
	public void deleteStavke(int id_stavke) throws SQLException, ClassNotFoundException {
		DAOStavke ds = new DAOStavke();
		ds.deleteStavke(id_stavke);
	}
	
	public void updateStavke(Stavke s) throws SQLException, ClassNotFoundException {
		DAOStavke ds = new DAOStavke();
		ds.updateStavke(s);
	}
	
	//Resavanje DAOUgovorPostpaid
	
	public ArrayList<UgovorPostpaid> getUgovorPostpaid() throws ClassNotFoundException, SQLException {
		DAOUgovorPostpaid dup = new DAOUgovorPostpaid();
		ArrayList<UgovorPostpaid> lista = dup.getUgovorPostpaid();
		return lista;
	}
	
	public int insertUgovorPostpaid(UgovorPostpaid up) throws SQLException, ClassNotFoundException {
		DAOUgovorPostpaid dup = new DAOUgovorPostpaid();
		return dup.insertUgovorPostpaid(up);
	}
	
	public void deleteUgovorPostpaid(int id_ugovor) throws SQLException, ClassNotFoundException {
		DAOUgovorPostpaid dup = new DAOUgovorPostpaid();
		dup.deleteUgovorPostpaid(id_ugovor);
	}
	
	public int updateUgovorPostpaid(UgovorPostpaid up) throws SQLException, ClassNotFoundException {
		DAOUgovorPostpaid dup = new DAOUgovorPostpaid();
		return dup.updateUgovorPostpaid(up);
	}
	
	//Resavanje DAORacun
	
	public ArrayList<Racun> getRacun() throws ClassNotFoundException, SQLException {
		DAORacun dr = new DAORacun();
		ArrayList<Racun> lista = dr.getRacun();
		return lista;	
	}
	
	public int insertRacun(Racun r) throws ClassNotFoundException, SQLException {
		DAORacun dr = new DAORacun();
		return dr.insertRacun(r);
	}
	
	public void deleteRacun(int id_racun) throws SQLException, ClassNotFoundException {
		DAORacun dr = new DAORacun();
		dr.deleteRacun(id_racun);
	}
	
	public int updateRacun(Racun r) throws SQLException, ClassNotFoundException {
		DAORacun dr = new DAORacun();
		return dr.updateRacun(r);
	}
	
}
