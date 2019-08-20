package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.border.TitledBorder;

import dao.DAOUser;
import kontroler.Kontroler;
import model.BrojTelefona;
import model.User;

import javax.swing.JRadioButton;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class AppGlavna {

	private JFrame frmTelesrb;
	private JTextField textFieldBrojTelefonaLogIn;
	private JTextField textFieldLozinkaLogIn;
	private JTextField textFieldImeRK;
	private JTextField textFieldPrezimeRK;
	private JTextField textFieldBrojTelefonaRK;
	private JTextField textFieldSifraRK;
	private JTextField textFieldEmailRK;
	private JTextField textFieldAdresaRK;
	private JTextField textFieldImeRR;
	private JTextField textFieldPrezimeRR;
	private JTextField textFieldBrojTelefonaRR;
	private JTextField textFieldSifraRR;
	private JTextField textFieldEmailRR;
	private JTextField textFieldAdresaRR;
	private JTable tableKorpaKorisnik;
	
	private JPanel panelRegistracijaKorisnika;
	private JPanel panelLogIn;
	public User logedIn = null;
	private JPanel panelAdmin;
	private JPanel panelProdavac;
	private JPanel panelKorisnik;
	
	private JRadioButton rdbtnProdavacRR;
	private JRadioButton rdbtnAdminRR;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppGlavna window = new AppGlavna();
					window.frmTelesrb.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppGlavna() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelesrb = new JFrame();
		frmTelesrb.setTitle("TeleSRB");
		frmTelesrb.setBounds(100, 100, 709, 478);
		frmTelesrb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelesrb.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panelGlavna = new JPanel();
		frmTelesrb.getContentPane().add(panelGlavna, "name_8200961034962");
		panelGlavna.setLayout(null);
		
		JLabel lblTelesrbGlavna = new JLabel("TeleSRB");
		lblTelesrbGlavna.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTelesrbGlavna.setBounds(299, 11, 216, 25);
		panelGlavna.add(lblTelesrbGlavna);
		
		JButton btnNoviKorisnikGlavna = new JButton("Novi korisnik");
		btnNoviKorisnikGlavna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelGlavna.setVisible(false);
				panelRegistracijaKorisnika.setVisible(true);
			}
		});
		btnNoviKorisnikGlavna.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNoviKorisnikGlavna.setBounds(87, 108, 175, 44);
		panelGlavna.add(btnNoviKorisnikGlavna);
		
		JButton btnPostojeciKorisnikGlavna = new JButton("Postojeci korisnik");
		btnPostojeciKorisnikGlavna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelGlavna.setVisible(false);
				panelLogIn.setVisible(true);
			}
		});
		btnPostojeciKorisnikGlavna.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPostojeciKorisnikGlavna.setBounds(418, 108, 175, 44);
		panelGlavna.add(btnPostojeciKorisnikGlavna);
		
		JButton btnPripaidIDodatnaOpremaGlavna = new JButton("Pripaid i dodatna oprema");
		btnPripaidIDodatnaOpremaGlavna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFramePripaidIDodatnaOprema dopp = new JFramePripaidIDodatnaOprema();
				
				System.out.println();
				dopp.show();
			}
		});
		btnPripaidIDodatnaOpremaGlavna.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPripaidIDodatnaOpremaGlavna.setBounds(211, 256, 257, 44);
		panelGlavna.add(btnPripaidIDodatnaOpremaGlavna);
		
		panelLogIn = new JPanel();
		frmTelesrb.getContentPane().add(panelLogIn, "name_8206257333325");
		panelLogIn.setLayout(null);
		
		JPanel panelLogovanjeLogIn = new JPanel();
		panelLogovanjeLogIn.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Uloguj se", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelLogovanjeLogIn.setBounds(150, 70, 390, 300);
		panelLogIn.add(panelLogovanjeLogIn);
		panelLogovanjeLogIn.setLayout(null);
		
		JLabel lblBrojTelefonaLogIn = new JLabel("Broj mobilnog telefona:");
		lblBrojTelefonaLogIn.setBounds(100, 50, 150, 15);
		panelLogovanjeLogIn.add(lblBrojTelefonaLogIn);
		
		textFieldBrojTelefonaLogIn = new JTextField();
		textFieldBrojTelefonaLogIn.setBounds(100, 70, 190, 20);
		panelLogovanjeLogIn.add(textFieldBrojTelefonaLogIn);
		textFieldBrojTelefonaLogIn.setColumns(10);
		
		JLabel lblLozinkaLogIn = new JLabel("Lozinka:");
		lblLozinkaLogIn.setBounds(100, 110, 150, 15);
		panelLogovanjeLogIn.add(lblLozinkaLogIn);
		
		textFieldLozinkaLogIn = new JTextField();
		textFieldLozinkaLogIn.setBounds(100, 130, 190, 20);
		panelLogovanjeLogIn.add(textFieldLozinkaLogIn);
		textFieldLozinkaLogIn.setColumns(10);
		
		JButton btnPrijaviSeLogIn = new JButton("Prijavi se");
		btnPrijaviSeLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String brojTelefona = textFieldBrojTelefonaLogIn.getText().trim();
					String lozinka = textFieldLozinkaLogIn.getText().trim();
					
					ArrayList<User> user = Kontroler.getInstance().getUser();
					for (User u : user) {
						if(u.getBrojTelefona().equals(brojTelefona) && u.getPassword().equals(lozinka)) {
							if(u.getUserTip().equals("admin")) {
								System.out.println("ADMIN");
								logedIn = u;
								
								System.out.println(logedIn.getBrojTelefona());
								
								panelAdmin.setVisible(true);
								panelLogIn.setVisible(false);
								
							} else if (u.getUserTip().equals("prodavac")) {
								System.out.println("PRODAVAC");
								logedIn = u;
								
								System.out.println(logedIn.getBrojTelefona());
								
								panelLogIn.setVisible(false);
								panelProdavac.setVisible(true);
							
							} else if (u.getUserTip().equals("korisnik")) {
								System.out.println("KORISNIK");
								logedIn = u;
							
								System.out.println(logedIn.getBrojTelefona());
							
								panelLogIn.setVisible(false);
								panelKorisnik.setVisible(true);
							} else {
								JOptionPane.showMessageDialog(panelLogIn," Pogresan tip usera");
							}
							break;
						}
					}
					if(logedIn == null) {
						JOptionPane.showMessageDialog(panelLogIn, "Pogresan broj telefona ili lozinka");
					}
				
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnPrijaviSeLogIn.setBounds(145, 170, 100, 25);
		panelLogovanjeLogIn.add(btnPrijaviSeLogIn);
		
		JButton btnNazadLogIn = new JButton("Nazad");
		btnNazadLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLogIn.setVisible(false);
				panelGlavna.setVisible(true);
			}
		});
		btnNazadLogIn.setBounds(145, 225, 100, 25);
		panelLogovanjeLogIn.add(btnNazadLogIn);
		
		panelRegistracijaKorisnika = new JPanel();
		frmTelesrb.getContentPane().add(panelRegistracijaKorisnika, "name_8243365967442");
		panelRegistracijaKorisnika.setLayout(null);
		
		JPanel panelRegistracijaRK = new JPanel();
		panelRegistracijaRK.setBorder(new TitledBorder(null, "Registracija", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelRegistracijaRK.setBounds(70, 35, 550, 370);
		panelRegistracijaKorisnika.add(panelRegistracijaRK);
		panelRegistracijaRK.setLayout(null);
		
		JLabel lblImeRK = new JLabel("Ime");
		lblImeRK.setBounds(100, 35, 46, 14);
		panelRegistracijaRK.add(lblImeRK);
		
		textFieldImeRK = new JTextField();
		textFieldImeRK.setBounds(100, 50, 150, 20);
		panelRegistracijaRK.add(textFieldImeRK);
		textFieldImeRK.setColumns(10);
		
		JLabel lblPrezimeRK = new JLabel("Prezime");
		lblPrezimeRK.setBounds(100, 80, 83, 14);
		panelRegistracijaRK.add(lblPrezimeRK);
		
		textFieldPrezimeRK = new JTextField();
		textFieldPrezimeRK.setBounds(100, 95, 150, 20);
		panelRegistracijaRK.add(textFieldPrezimeRK);
		textFieldPrezimeRK.setColumns(10);
		
		JLabel lblBrojTelefonaRK = new JLabel("Broj telefona");
		lblBrojTelefonaRK.setBounds(100, 125, 118, 14);
		panelRegistracijaRK.add(lblBrojTelefonaRK);
		
		textFieldBrojTelefonaRK = new JTextField();
		textFieldBrojTelefonaRK.setBounds(100, 140, 150, 20);
		panelRegistracijaRK.add(textFieldBrojTelefonaRK);
		textFieldBrojTelefonaRK.setColumns(10);
		
		JLabel lblSifraRK = new JLabel("\u0160ifra");
		lblSifraRK.setBounds(100, 170, 118, 14);
		panelRegistracijaRK.add(lblSifraRK);
		
		textFieldSifraRK = new JTextField();
		textFieldSifraRK.setBounds(100, 185, 150, 20);
		panelRegistracijaRK.add(textFieldSifraRK);
		textFieldSifraRK.setColumns(10);
		
		JLabel lblEmailRK = new JLabel("e-mail");
		lblEmailRK.setBounds(100, 215, 46, 14);
		panelRegistracijaRK.add(lblEmailRK);
		
		textFieldEmailRK = new JTextField();
		textFieldEmailRK.setBounds(100, 230, 150, 20);
		panelRegistracijaRK.add(textFieldEmailRK);
		textFieldEmailRK.setColumns(10);
		
		JLabel lblAdresaRK = new JLabel("Adresa");
		lblAdresaRK.setBounds(100, 260, 46, 14);
		panelRegistracijaRK.add(lblAdresaRK);
		
		textFieldAdresaRK = new JTextField();
		textFieldAdresaRK.setBounds(100, 275, 150, 20);
		panelRegistracijaRK.add(textFieldAdresaRK);
		textFieldAdresaRK.setColumns(10);
		
		JButton btnRegistrujSeRK = new JButton("Registruj se");
		btnRegistrujSeRK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String ime = textFieldImeRK.getText();
					String prezime = textFieldPrezimeRK.getText();
					String brojTelefona = textFieldBrojTelefonaRK.getText();
					String password = textFieldSifraRK.getText();
					String email = textFieldEmailRK.getText();
					String userTip = "korisnik";
					String adresa = textFieldAdresaRK.getText();
					
					User u = new User(ime, prezime, brojTelefona, password, email, userTip, adresa);
					Kontroler.getInstance().insertUser(u);
					JOptionPane.showMessageDialog(panelRegistracijaKorisnika, "Uspesno ste se registrovali.");
					
					textFieldImeRK.setText("");
					textFieldPrezimeRK.setText("");
					textFieldBrojTelefonaRK.setText("");
					textFieldSifraRK.setText("");
					textFieldEmailRK.setText("");
					textFieldAdresaRK.setText("");
					
					panelRegistracijaKorisnika.setVisible(false);
					panelLogIn.setVisible(true);
					
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRegistrujSeRK.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRegistrujSeRK.setBounds(100, 320, 150, 25);
		panelRegistracijaRK.add(btnRegistrujSeRK);
		
		JButton btnNazadRK = new JButton("Nazad");
		btnNazadRK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelRegistracijaKorisnika.setVisible(false);
				panelGlavna.setVisible(true);
			}
		});
		btnNazadRK.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNazadRK.setBounds(350, 320, 100, 25);
		panelRegistracijaRK.add(btnNazadRK);
		
		
		
		JPanel panelRegistracijaRadnika = new JPanel();
		frmTelesrb.getContentPane().add(panelRegistracijaRadnika, "name_4758566232796");
		panelRegistracijaRadnika.setLayout(null);
		
		JPanel panelRegistrujaRR = new JPanel();
		panelRegistrujaRR.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Registracija radnika", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelRegistrujaRR.setBounds(75, 30, 550, 380);
		panelRegistracijaRadnika.add(panelRegistrujaRR);
		panelRegistrujaRR.setLayout(null);
		
		JLabel lblImeRR = new JLabel("Ime");
		lblImeRR.setBounds(100, 35, 150, 14);
		panelRegistrujaRR.add(lblImeRR);
		
		textFieldImeRR = new JTextField();
		textFieldImeRR.setBounds(100, 50, 150, 20);
		panelRegistrujaRR.add(textFieldImeRR);
		textFieldImeRR.setColumns(10);
		
		JLabel lblPrezimeRR = new JLabel("Prezime");
		lblPrezimeRR.setBounds(100, 80, 150, 14);
		panelRegistrujaRR.add(lblPrezimeRR);
		
		textFieldPrezimeRR = new JTextField();
		textFieldPrezimeRR.setBounds(100, 95, 150, 20);
		panelRegistrujaRR.add(textFieldPrezimeRR);
		textFieldPrezimeRR.setColumns(10);
		
		JLabel lblBrojTelefonaRR = new JLabel("Broj telefona");
		lblBrojTelefonaRR.setBounds(100, 125, 150, 14);
		panelRegistrujaRR.add(lblBrojTelefonaRR);
		
		textFieldBrojTelefonaRR = new JTextField();
		textFieldBrojTelefonaRR.setBounds(100, 140, 150, 20);
		panelRegistrujaRR.add(textFieldBrojTelefonaRR);
		textFieldBrojTelefonaRR.setColumns(10);
		
		JLabel lblSifraRR = new JLabel("\u0160ifra");
		lblSifraRR.setBounds(100, 170, 150, 14);
		panelRegistrujaRR.add(lblSifraRR);
		
		textFieldSifraRR = new JTextField();
		textFieldSifraRR.setBounds(100, 185, 150, 20);
		panelRegistrujaRR.add(textFieldSifraRR);
		textFieldSifraRR.setColumns(10);
		
		JLabel lblEmailRR = new JLabel("e-mail");
		lblEmailRR.setBounds(100, 215, 150, 14);
		panelRegistrujaRR.add(lblEmailRR);
		
		textFieldEmailRR = new JTextField();
		textFieldEmailRR.setBounds(100, 230, 150, 20);
		panelRegistrujaRR.add(textFieldEmailRR);
		textFieldEmailRR.setColumns(10);
		
		JLabel lblAdresaRR = new JLabel("Adresa");
		lblAdresaRR.setBounds(100, 260, 150, 14);
		panelRegistrujaRR.add(lblAdresaRR);
		
		textFieldAdresaRR = new JTextField();
		textFieldAdresaRR.setBounds(100, 275, 150, 20);
		panelRegistrujaRR.add(textFieldAdresaRR);
		textFieldAdresaRR.setColumns(10);
		
		rdbtnProdavacRR = new JRadioButton("Prodavac");
		rdbtnProdavacRR.setBounds(100, 305, 80, 23);
		panelRegistrujaRR.add(rdbtnProdavacRR);
		
		rdbtnAdminRR = new JRadioButton("Admin");
		rdbtnAdminRR.setBounds(190, 305, 70, 23);
		panelRegistrujaRR.add(rdbtnAdminRR);
		
		JButton btnRegistrujSeRR = new JButton("Registruj se");
		btnRegistrujSeRR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String ime = textFieldImeRR.getText();
					String prezime = textFieldPrezimeRR.getText();
					String brojTelefona = textFieldBrojTelefonaRR.getText();
					String password = textFieldSifraRR.getText();
					String email = textFieldEmailRR.getText();
					String adresa = textFieldAdresaRR.getText();
					
					String userTip = "";
					
					
					
					/*this.setSize(500, 500);
					
					this.setDefaultCloseOperation(EXIT_ON_CLOSE);
					getContentPane().setLayout(null);
					ButtonGroup zaposlen = new ButtonGroup();
					zaposlen.add(rdbtnAdminRR);
					zaposlen.add(rdbtnProdavacRR);
					
					this.setVisible(true);
					
					rdbtnAdminRR.addActionListener(new ActionListener());
					rdbtnProdavacRR.addActionListener(ActionListener);*/
					
					
					/*if (rdbtnAdminRR.isSelected()) {
						userTip = "admin";
					} else if (rdbtnProdavacRR.isSelected()) {
						userTip = "prodavac";
					}*/
					
					User u = new User(ime, prezime, brojTelefona, password, email, userTip, adresa);
					Kontroler.getInstance().insertUser(u);
					JOptionPane.showMessageDialog(panelRegistracijaRadnika, "Uspesno ste se registrovali.");
					
					textFieldImeRK.setText("");
					textFieldPrezimeRK.setText("");
					textFieldBrojTelefonaRK.setText("");
					textFieldSifraRK.setText("");
					textFieldEmailRK.setText("");
					textFieldAdresaRK.setText("");
					rdbtnAdminRR.setSelected(false);
					rdbtnProdavacRR.setSelected(false);
					
					panelRegistracijaRadnika.setVisible(false);
					panelLogIn.setVisible(true);
					
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRegistrujSeRR.setBounds(100, 335, 150, 25);
		panelRegistrujaRR.add(btnRegistrujSeRR);
		
		JButton btnNazadRR = new JButton("Nazad");
		btnNazadRR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAdmin.setVisible(true);
				panelRegistracijaRadnika.setVisible(false);
			}
		});
		btnNazadRR.setBounds(350, 335, 100, 25);
		panelRegistrujaRR.add(btnNazadRR);
		
		panelKorisnik = new JPanel();
		frmTelesrb.getContentPane().add(panelKorisnik, "name_7844590625328");
		panelKorisnik.setLayout(null);
		
		JPanel panelKorisnikK = new JPanel();
		panelKorisnikK.setBorder(new TitledBorder(null, "Korisnik", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelKorisnikK.setBounds(20, 20, 650, 400);
		panelKorisnik.add(panelKorisnikK);
		panelKorisnikK.setLayout(null);
		
		JButton btnPostpaidKorisnik = new JButton("PostPaid");
		btnPostpaidKorisnik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFramePostPaid pp = new JFramePostPaid();
				
				System.out.println();
				pp.show();
			}
		});
		btnPostpaidKorisnik.setBounds(100, 30, 200, 30);
		panelKorisnikK.add(btnPostpaidKorisnik);
		
		JButton btnPripaidIDodatnaOpremaKorisnik = new JButton("Pripaid i dodatna oprema");
		btnPripaidIDodatnaOpremaKorisnik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFramePripaidIDodatnaOprema pido = new JFramePripaidIDodatnaOprema();
				
				System.out.println();
				pido.show();
			}
		});
		btnPripaidIDodatnaOpremaKorisnik.setBounds(350, 30, 200, 30);
		panelKorisnikK.add(btnPripaidIDodatnaOpremaKorisnik);
		
		JButton btnIzlogujSeKorisnik = new JButton("Izloguj se");
		btnIzlogujSeKorisnik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLogIn.setVisible(true);
				panelKorisnik.setVisible(false);
				textFieldBrojTelefonaLogIn.setText("");
				textFieldLozinkaLogIn.setText("");
			}
		});
		btnIzlogujSeKorisnik.setBounds(480, 350, 150, 25);
		panelKorisnikK.add(btnIzlogujSeKorisnik);
		
		JPanel panelNarudjbinaKorisnik = new JPanel();
		panelNarudjbinaKorisnik.setBorder(new TitledBorder(null, "Korpa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelNarudjbinaKorisnik.setBounds(25, 70, 600, 260);
		panelKorisnikK.add(panelNarudjbinaKorisnik);
		panelNarudjbinaKorisnik.setLayout(null);
		
		JScrollPane scrollPaneKorpaKorisnik = new JScrollPane();
		scrollPaneKorpaKorisnik.setBounds(10, 20, 580, 150);
		panelNarudjbinaKorisnik.add(scrollPaneKorpaKorisnik);
		
		tableKorpaKorisnik = new JTable();
		scrollPaneKorpaKorisnik.setViewportView(tableKorpaKorisnik);
		
		JButton btnNaruciKorpaKorisnik = new JButton("Naru\u010Di");
		btnNaruciKorpaKorisnik.setBounds(400, 220, 150, 25);
		panelNarudjbinaKorisnik.add(btnNaruciKorpaKorisnik);
		
		JButton btnObrisiKorpaKorisnik = new JButton("Obri\u0161i");
		btnObrisiKorpaKorisnik.setBounds(200, 220, 150, 25);
		panelNarudjbinaKorisnik.add(btnObrisiKorpaKorisnik);
		
		JLabel lblUkupnaCenaKorpaKorisnik = new JLabel("Ukupna cena:");
		lblUkupnaCenaKorpaKorisnik.setBounds(400, 190, 104, 14);
		panelNarudjbinaKorisnik.add(lblUkupnaCenaKorpaKorisnik);
		
		JLabel labelCenaKorpaKorisnik = new JLabel("0");
		labelCenaKorpaKorisnik.setBounds(500, 190, 100, 14);
		panelNarudjbinaKorisnik.add(labelCenaKorpaKorisnik);
		
		panelProdavac = new JPanel();
		frmTelesrb.getContentPane().add(panelProdavac, "name_27468884341717");
		panelProdavac.setLayout(null);
		
		JPanel panelProdavacP = new JPanel();
		panelProdavacP.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Prodavac", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelProdavacP.setBounds(50, 50, 590, 340);
		panelProdavac.add(panelProdavacP);
		panelProdavacP.setLayout(null);
		
		JButton btnPostpaidProdavac = new JButton("PostPaid");
		btnPostpaidProdavac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFramePostPaid pp = new JFramePostPaid();
				
				System.out.println();
				pp.show();
			}
		});
		btnPostpaidProdavac.setBounds(50, 50, 250, 40);
		panelProdavacP.add(btnPostpaidProdavac);
		
		JButton btnPripaidIDodatnaOpremaProdavac = new JButton("Pripaid i dodatna oprema");
		btnPripaidIDodatnaOpremaProdavac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFramePripaidIDodatnaOprema dopp = new JFramePripaidIDodatnaOprema();
				
				System.out.println();
				dopp.show();
			}
		});
		btnPripaidIDodatnaOpremaProdavac.setBounds(50, 120, 250, 40);
		panelProdavacP.add(btnPripaidIDodatnaOpremaProdavac);
		
		JButton btnZahtevKorisnikaProdavac = new JButton("Zahtev Korisnika");
		btnZahtevKorisnikaProdavac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameZahtevKorisnika zk = new JFrameZahtevKorisnika();
				
				System.out.println();
				zk.show();
			}
		});
		btnZahtevKorisnikaProdavac.setBounds(50, 190, 250, 40);
		panelProdavacP.add(btnZahtevKorisnikaProdavac);
		
		JButton btnSpisakKorisnikaProdavac = new JButton("Spisak Korisnika");
		btnSpisakKorisnikaProdavac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFramaSpisakKorisnika sk = new JFramaSpisakKorisnika();
				
				System.out.println();
				sk.show();
			}
		});
		btnSpisakKorisnikaProdavac.setBounds(50, 260, 250, 40);
		panelProdavacP.add(btnSpisakKorisnikaProdavac);
		
		JButton btnIzlogujSeProdavac = new JButton("Izloguj se");
		btnIzlogujSeProdavac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLogIn.setVisible(true);
				panelProdavac.setVisible(false);
				textFieldBrojTelefonaLogIn.setText("");
				textFieldLozinkaLogIn.setText("");
			}
		});
		btnIzlogujSeProdavac.setBounds(460, 285, 100, 25);
		panelProdavacP.add(btnIzlogujSeProdavac);
		
		panelAdmin = new JPanel();
		panelAdmin.setBorder(null);
		frmTelesrb.getContentPane().add(panelAdmin, "name_10979612927143");
		panelAdmin.setLayout(null);
		
		JPanel panelAdminA = new JPanel();
		panelAdminA.setBorder(new TitledBorder(null, "Admin", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelAdminA.setBounds(50, 50, 590, 340);
		panelAdmin.add(panelAdminA);
		panelAdminA.setLayout(null);
		
		JButton btnPostpaidAdmin = new JButton("PostPaid");
		btnPostpaidAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFramePostPaid pp = new JFramePostPaid();
				
				System.out.println();
				pp.show();
			}
		});
		btnPostpaidAdmin.setBounds(60, 45, 200, 40);
		panelAdminA.add(btnPostpaidAdmin);
		
		JButton btnPripaidIDodatnaOpremaAdmin = new JButton("Pripaid i dodatn oprema");
		btnPripaidIDodatnaOpremaAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFramePripaidIDodatnaOprema dopp = new JFramePripaidIDodatnaOprema();
				
				System.out.println();
				dopp.show();
			}
		});
		btnPripaidIDodatnaOpremaAdmin.setBounds(330, 45, 200, 40);
		panelAdminA.add(btnPripaidIDodatnaOpremaAdmin);
		
		JButton btnZahtevKorisnikaAdmin = new JButton("Zahtev Korisnika");
		btnZahtevKorisnikaAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameZahtevKorisnika zk = new JFrameZahtevKorisnika();
				
				System.out.println();
				zk.show();
			}
		});
		btnZahtevKorisnikaAdmin.setBounds(330, 115, 200, 40);
		panelAdminA.add(btnZahtevKorisnikaAdmin);
		
		JButton btnRegistracijaRadnikaAdmin = new JButton("Registracija radnika");
		btnRegistracijaRadnikaAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelRegistracijaRadnika.setVisible(true);
				panelAdmin.setVisible(false);
			}
		});
		btnRegistracijaRadnikaAdmin.setBounds(60, 115, 200, 40);
		panelAdminA.add(btnRegistracijaRadnikaAdmin);
		
		JButton btnUnosPodatakaAdmin = new JButton("Unos podataka");
		btnUnosPodatakaAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameUnosPodataka up = new JFrameUnosPodataka();
				
				System.out.println();
				up.show();
				
			}
		});
		btnUnosPodatakaAdmin.setBounds(60, 255, 200, 40);
		panelAdminA.add(btnUnosPodatakaAdmin);
		
		JButton btnSpisakRadnikaAdmin = new JButton("Spisak radnika");
		btnSpisakRadnikaAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameSpisakRadnika up = new JFrameSpisakRadnika();
				
				System.out.println();
				up.show();
			}
		});
		btnSpisakRadnikaAdmin.setBounds(60, 185, 200, 40);
		panelAdminA.add(btnSpisakRadnikaAdmin);
		
		JButton btnSpisakKorisnikaAdmin = new JButton("Spisak Korisnika");
		btnSpisakKorisnikaAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFramaSpisakKorisnika sk = new JFramaSpisakKorisnika();
				
				System.out.println();
				sk.show();
			}
		});
		btnSpisakKorisnikaAdmin.setBounds(330, 185, 200, 40);
		panelAdminA.add(btnSpisakKorisnikaAdmin);
		
		JButton btnIzlogujSeAdmin = new JButton("Izloguj se");
		btnIzlogujSeAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLogIn.setVisible(true);
				panelAdmin.setVisible(false);
				textFieldBrojTelefonaLogIn.setText("");
				textFieldLozinkaLogIn.setText("");
			}
		});
		btnIzlogujSeAdmin.setBounds(460, 285, 100, 25);
		panelAdminA.add(btnIzlogujSeAdmin);
	}
	
	public void Grup() {
		String userTip = "";
				
		
		ButtonGroup zaposlen = new ButtonGroup();
		zaposlen.add(rdbtnAdminRR);
		zaposlen.add(rdbtnProdavacRR);
		
		//this.setVisible(true);
		
		//rdbtnAdminRR.addActionListener(new ActionListener());
		//rdbtnProdavacRR.addActionListener(ActionListener);
		
		
		if (rdbtnAdminRR.isSelected()) {
			userTip = "admin";
		} else if (rdbtnProdavacRR.isSelected()) {
			userTip = "prodavac";
		}
	}
	
	
	
}
