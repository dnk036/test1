package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import kontroler.Kontroler;
import model.BrojTelefona;
import model.Paket;
import model.PripaidIDodatnaOprema;
import model.Uredjaj;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class JFrameUnosPodataka extends JFrame {

	private JPanel contentPane;
	private JTable tableBrojTelefonaUnosPodataka;
	private JTextField textFieldNumeracijaUnosPodataka;
	private JTable tableOstaleTabeleUnosPodataka;
	private JTextField textFieldTipUnosPodataka;
	private JTextField textFieldNazivUnosPodataka;
	private JTextField textFieldCenaUnosPodataka;
	
	private JButton btnPrikaziBrojeveTelefona;
	private JTextField textFieldUnesiteIdPaketZaUredjajUnosPodataka;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameUnosPodataka frame = new JFrameUnosPodataka();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameUnosPodataka() {
		setTitle("TeleSRB - Unos podataka");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelUnosPodataka = new JPanel();
		panelUnosPodataka.setBorder(new TitledBorder(null, "Unos podataka", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelUnosPodataka.setBounds(20, 20, 740, 510);
		contentPane.add(panelUnosPodataka);
		panelUnosPodataka.setLayout(null);
		
		JPanel panelBrojTelefonaUnosPodataka = new JPanel();
		panelBrojTelefonaUnosPodataka.setBorder(new TitledBorder(null, "Unos broja telefona", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBrojTelefonaUnosPodataka.setBounds(20, 20, 700, 170);
		panelUnosPodataka.add(panelBrojTelefonaUnosPodataka);
		panelBrojTelefonaUnosPodataka.setLayout(null);
		
		JScrollPane scrollPaneBrojTelefonaUnosPodataka = new JScrollPane();
		scrollPaneBrojTelefonaUnosPodataka.setBounds(20, 20, 350, 130);
		panelBrojTelefonaUnosPodataka.add(scrollPaneBrojTelefonaUnosPodataka);
		
		tableBrojTelefonaUnosPodataka = new JTable();
		scrollPaneBrojTelefonaUnosPodataka.setViewportView(tableBrojTelefonaUnosPodataka);
		
		JLabel lblNumeracijaUnosPodataka = new JLabel("Numeracija (unesite broj telefona):");
		lblNumeracijaUnosPodataka.setBounds(380, 60, 245, 15);
		panelBrojTelefonaUnosPodataka.add(lblNumeracijaUnosPodataka);
		
		textFieldNumeracijaUnosPodataka = new JTextField();
		textFieldNumeracijaUnosPodataka.setBounds(580, 55, 100, 23);
		panelBrojTelefonaUnosPodataka.add(textFieldNumeracijaUnosPodataka);
		textFieldNumeracijaUnosPodataka.setColumns(10);
		
		JComboBox comboBoxStatusUnosPodataka = new JComboBox();
		comboBoxStatusUnosPodataka.setBounds(560, 90, 120, 23);
		panelBrojTelefonaUnosPodataka.add(comboBoxStatusUnosPodataka);
		comboBoxStatusUnosPodataka.setModel(new DefaultComboBoxModel(new String[] {"Slobodan", "Zauzet"}));
		
		JButton btnIzmeniBTUnosPodataka = new JButton("Izmeni");
		btnIzmeniBTUnosPodataka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rbbt = tableBrojTelefonaUnosPodataka.getSelectedRow();
				int rb = (int) tableBrojTelefonaUnosPodataka.getModel().getValueAt(rbbt, 0);
				
				String status = comboBoxStatusUnosPodataka.getSelectedItem().toString();
				
				try {
					Kontroler.getInstance().izmeniStatusBrojaTelefona(rb, status);
					ArrayList<BrojTelefona> lista = Kontroler.getInstance().getBrojTelefona();
					postaviModelBT(lista, tableBrojTelefonaUnosPodataka);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnIzmeniBTUnosPodataka.setBounds(385, 130, 90, 25);
		panelBrojTelefonaUnosPodataka.add(btnIzmeniBTUnosPodataka);
		
		JButton btnObrisiBTUnosPodataka = new JButton("Obrisi");
		btnObrisiBTUnosPodataka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTableModelBrojTelefona model = (JTableModelBrojTelefona) tableBrojTelefonaUnosPodataka.getModel();
				
				int selektovanRed = tableOstaleTabeleUnosPodataka.getSelectedRow();
				if(selektovanRed >= 0) {
					model.removeRow(selektovanRed);
					JOptionPane.showMessageDialog(panelBrojTelefonaUnosPodataka, "Uspešno ste obrisali broj");
				} else {
					JOptionPane.showMessageDialog(panelBrojTelefonaUnosPodataka, "Morate selektovati red u tabeli!");
				}
			}
		});
		btnObrisiBTUnosPodataka.setBounds(490, 130, 90, 25);
		panelBrojTelefonaUnosPodataka.add(btnObrisiBTUnosPodataka);
		
		JButton btnSauvajBTUnosPodataka = new JButton("Sacuvaj");
		btnSauvajBTUnosPodataka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTableModelBrojTelefona model = (JTableModelBrojTelefona) tableBrojTelefonaUnosPodataka.getModel();
				try {
					String numeracija = textFieldNumeracijaUnosPodataka.getText();
					String status =  (String) comboBoxStatusUnosPodataka.getSelectedItem();
					
					BrojTelefona bt = new BrojTelefona(numeracija, status);
					
					Kontroler.getInstance().insertBrojTelefona(bt);
					
					JOptionPane.showMessageDialog(panelBrojTelefonaUnosPodataka, "Uspešno ste uneli broj telefona");
					
					textFieldNumeracijaUnosPodataka.setText("");
					
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
		btnSauvajBTUnosPodataka.setBounds(595, 130, 90, 25);
		panelBrojTelefonaUnosPodataka.add(btnSauvajBTUnosPodataka);
		
		JLabel lblStatusBrojaTelefona = new JLabel("Status broja telefona:");
		lblStatusBrojaTelefona.setBounds(380, 95, 175, 14);
		panelBrojTelefonaUnosPodataka.add(lblStatusBrojaTelefona);
		
		btnPrikaziBrojeveTelefona = new JButton("Prikazi brojeve telefona");
		btnPrikaziBrojeveTelefona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<BrojTelefona> lista = Kontroler.getInstance().getBrojTelefona();
					postaviModelBT(lista, tableBrojTelefonaUnosPodataka);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPrikaziBrojeveTelefona.setBounds(380, 20, 180, 23);
		panelBrojTelefonaUnosPodataka.add(btnPrikaziBrojeveTelefona);
		
		JPanel panelOstalTabeleUnosPodataka = new JPanel();
		panelOstalTabeleUnosPodataka.setBorder(new TitledBorder(null, "Unos u ostale tabele", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelOstalTabeleUnosPodataka.setBounds(20, 210, 700, 280);
		panelUnosPodataka.add(panelOstalTabeleUnosPodataka);
		panelOstalTabeleUnosPodataka.setLayout(null);
		
		JLabel lblIzaberiteTabeluUnosPodataka = new JLabel("Izaberite tabelu koju zelite da uredjujete:");
		lblIzaberiteTabeluUnosPodataka.setBounds(30, 30, 280, 15);
		panelOstalTabeleUnosPodataka.add(lblIzaberiteTabeluUnosPodataka);
		
		JComboBox comboBoxIzaberiteTabeluUnosPodataka = new JComboBox();
		comboBoxIzaberiteTabeluUnosPodataka.setModel(new DefaultComboBoxModel(new String[] {"paket", "uredjaj", "pripaid_dodatna_oprema"}));
		comboBoxIzaberiteTabeluUnosPodataka.setBounds(280, 25, 140, 25);
		panelOstalTabeleUnosPodataka.add(comboBoxIzaberiteTabeluUnosPodataka);
		
		JButton btnUcitajUnosPodataka = new JButton("Ucitaj");
		btnUcitajUnosPodataka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tabela = comboBoxIzaberiteTabeluUnosPodataka.getSelectedItem().toString();
				
				try {
					
					if (tabela.equals("paket")) {
					ArrayList<Paket> listaPaket = Kontroler.getInstance().getPaket();
					postaviModelPaket(listaPaket, tableOstaleTabeleUnosPodataka);
					} else if (tabela.equals("uredjaj")) {
					ArrayList<Uredjaj> listaUredjaj = Kontroler.getInstance().getUredjaj();
					postaviModelUredjaj(listaUredjaj, tableOstaleTabeleUnosPodataka);
					} else if (tabela.equals("pripaid_dodatna_oprema")) {
					ArrayList<PripaidIDodatnaOprema> listaPIDO = Kontroler.getInstance().getPripaidIDodatnaOprema();
					postaviModelPIDO(listaPIDO, tableOstaleTabeleUnosPodataka);
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnUcitajUnosPodataka.setBounds(450, 25, 100, 25);
		panelOstalTabeleUnosPodataka.add(btnUcitajUnosPodataka);
		
		JScrollPane scrollPaneOstaleTabeleUnosPodataka = new JScrollPane();
		scrollPaneOstaleTabeleUnosPodataka.setBounds(20, 70, 350, 190);
		panelOstalTabeleUnosPodataka.add(scrollPaneOstaleTabeleUnosPodataka);
		
		tableOstaleTabeleUnosPodataka = new JTable();
		scrollPaneOstaleTabeleUnosPodataka.setViewportView(tableOstaleTabeleUnosPodataka);
		
		JLabel lblTipUnosPodataka = new JLabel("Tip");
		lblTipUnosPodataka.setBounds(385, 65, 45, 15);
		panelOstalTabeleUnosPodataka.add(lblTipUnosPodataka);
		
		textFieldTipUnosPodataka = new JTextField();
		textFieldTipUnosPodataka.setBounds(385, 82, 90, 20);
		panelOstalTabeleUnosPodataka.add(textFieldTipUnosPodataka);
		textFieldTipUnosPodataka.setColumns(10);
		
		JLabel lblNazivUnosPodataka = new JLabel("Naziv");
		lblNazivUnosPodataka.setBounds(490, 65, 46, 15);
		panelOstalTabeleUnosPodataka.add(lblNazivUnosPodataka);
		
		textFieldNazivUnosPodataka = new JTextField();
		textFieldNazivUnosPodataka.setBounds(490, 82, 100, 20);
		panelOstalTabeleUnosPodataka.add(textFieldNazivUnosPodataka);
		textFieldNazivUnosPodataka.setColumns(10);
		
		JLabel lblCenaUnosPodataka = new JLabel("Cena");
		lblCenaUnosPodataka.setBounds(600, 65, 46, 15);
		panelOstalTabeleUnosPodataka.add(lblCenaUnosPodataka);
		
		textFieldCenaUnosPodataka = new JTextField();
		textFieldCenaUnosPodataka.setBounds(600, 82, 80, 20);
		panelOstalTabeleUnosPodataka.add(textFieldCenaUnosPodataka);
		textFieldCenaUnosPodataka.setColumns(10);
		
		JLabel lblOpisUnosPodataka = new JLabel("Opis");
		lblOpisUnosPodataka.setBounds(385, 110, 46, 14);
		panelOstalTabeleUnosPodataka.add(lblOpisUnosPodataka);
		
		JScrollPane scrollPaneOpisUnosPodataka = new JScrollPane();
		scrollPaneOpisUnosPodataka.setBounds(385, 127, 300, 70);
		panelOstalTabeleUnosPodataka.add(scrollPaneOpisUnosPodataka);
		
		JTextArea textAreaOpisUnosPodataka = new JTextArea();
		scrollPaneOpisUnosPodataka.setViewportView(textAreaOpisUnosPodataka);
		
		JButton btnIzmeniOTUnosPodataka = new JButton("Izmeni");
		btnIzmeniOTUnosPodataka.setBounds(385, 240, 90, 25);
		panelOstalTabeleUnosPodataka.add(btnIzmeniOTUnosPodataka);
		
		JButton btnObrisiOTUnosPodataka = new JButton("Obrisi");
		btnObrisiOTUnosPodataka.setBounds(490, 240, 90, 25);
		panelOstalTabeleUnosPodataka.add(btnObrisiOTUnosPodataka);
		
		JButton btnSacuvajOTUnosPodataka = new JButton("Sacuvaj");
		btnSacuvajOTUnosPodataka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tabela = comboBoxIzaberiteTabeluUnosPodataka.getSelectedItem().toString();
				
				String tip = textFieldTipUnosPodataka.getText();
				String naziv = textFieldNazivUnosPodataka.getText();
				String opis = textAreaOpisUnosPodataka.getText();
				float cena = Float.parseFloat(textFieldCenaUnosPodataka.getText().trim());
				
				try {
					if(tabela.equals("paket")) {
						Paket p = new Paket(tip, naziv, opis, cena);
						Kontroler.getInstance().insertPaket(p);
						JOptionPane.showMessageDialog(panelOstalTabeleUnosPodataka, "Uspesno ste uneli paket");
					} else if (tabela.equals("uredjaj")) {
						int idPaket = Integer.parseInt(textFieldUnesiteIdPaketZaUredjajUnosPodataka.getText().trim());
						Uredjaj u = new Uredjaj(idPaket, tip, naziv, opis, cena);
						Kontroler.getInstance().insertUredjaj(u);
						JOptionPane.showMessageDialog(panelOstalTabeleUnosPodataka, "Uspesno ste uneli uredjaj");
					} else if (tabela.equals("pripaid_dodatna_oprema")) {
						PripaidIDodatnaOprema pido = new PripaidIDodatnaOprema(tip, naziv, opis, cena);
						Kontroler.getInstance().insertPripaidIDodatnaOprema(pido);
						JOptionPane.showMessageDialog(panelOstalTabeleUnosPodataka, "Uspesno ste uneli pripaid ili dodatnu opremu");
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
					
				textFieldTipUnosPodataka.setText("");
				textFieldNazivUnosPodataka.setText("");
				textAreaOpisUnosPodataka.setText("");
				textFieldCenaUnosPodataka.setText("");
				textFieldUnesiteIdPaketZaUredjajUnosPodataka.setText("");
				
			}
		});
		btnSacuvajOTUnosPodataka.setBounds(595, 240, 90, 25);
		panelOstalTabeleUnosPodataka.add(btnSacuvajOTUnosPodataka);
		
		JLabel lblUnesiteIdPaketZaUredjajUnosPodataka = new JLabel("Unesite \"id paket\" za UREDJAJ:");
		lblUnesiteIdPaketZaUredjajUnosPodataka.setBounds(385, 210, 195, 14);
		panelOstalTabeleUnosPodataka.add(lblUnesiteIdPaketZaUredjajUnosPodataka);
		
		textFieldUnesiteIdPaketZaUredjajUnosPodataka = new JTextField();
		textFieldUnesiteIdPaketZaUredjajUnosPodataka.setBounds(580, 207, 80, 20);
		panelOstalTabeleUnosPodataka.add(textFieldUnesiteIdPaketZaUredjajUnosPodataka);
		textFieldUnesiteIdPaketZaUredjajUnosPodataka.setColumns(10);
		
		JButton btnNazadUnosPodataka = new JButton("Nazad");
		btnNazadUnosPodataka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnNazadUnosPodataka.setBounds(640, 540, 100, 25);
		contentPane.add(btnNazadUnosPodataka);
	}
	
	//METODA KOJA ZATVARA TRENUTNI FRAJM
		public void close(){
			this.setVisible(false);
		}
	
		private void postaviModelBT(ArrayList lista, JTable tbt) {
			JTableModelBrojTelefona model = new JTableModelBrojTelefona(lista);
			tbt.setModel(model);
		}
		
		private void postaviModelPaket(ArrayList lista, JTable p) {
			JTableModelPaket model = new JTableModelPaket(lista);
			p.setModel(model);
		}
		private void postaviModelUredjaj(ArrayList lista, JTable u) {
			JTableModelUredjaj model = new JTableModelUredjaj(lista);
			u.setModel(model);
		}
		private void postaviModelPIDO(ArrayList lista, JTable pido) {
			JTableModelPripaidIDodatnaOprema model = new JTableModelPripaidIDodatnaOprema(lista);
			pido.setModel(model);
		}
}
