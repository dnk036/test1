package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameZahtevKorisnika extends JFrame {

	private JPanel contentPane;
	private JTable tableRacun;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameZahtevKorisnika frame = new JFrameZahtevKorisnika();
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
	public JFrameZahtevKorisnika() {
		setTitle("TeleSRB - Zahtev korisnika");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelRacun = new JPanel();
		panelRacun.setBorder(new TitledBorder(null, "Ra\u010Dun", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelRacun.setToolTipText("");
		panelRacun.setBounds(20, 20, 740, 400);
		contentPane.add(panelRacun);
		panelRacun.setLayout(null);
		
		JScrollPane scrollPaneRacun = new JScrollPane();
		scrollPaneRacun.setBounds(20, 30, 700, 150);
		panelRacun.add(scrollPaneRacun);
		
		tableRacun = new JTable();
		scrollPaneRacun.setViewportView(tableRacun);
		
		JLabel lblDodajRacun = new JLabel("Dodaj:");
		lblDodajRacun.setBounds(40, 200, 40, 15);
		panelRacun.add(lblDodajRacun);
		
		JButton btnPripaidIDodatnaOpremaRacun = new JButton("Pripaid i dodatna oprema");
		btnPripaidIDodatnaOpremaRacun.setBounds(90, 195, 200, 23);
		panelRacun.add(btnPripaidIDodatnaOpremaRacun);
		
		JLabel lblObrisiStavkuRacun = new JLabel("Obrisi stavku:");
		lblObrisiStavkuRacun.setBounds(400, 200, 80, 15);
		panelRacun.add(lblObrisiStavkuRacun);
		
		JButton btnObrisiRacun = new JButton("Obrisi");
		btnObrisiRacun.setBounds(490, 196, 90, 23);
		panelRacun.add(btnObrisiRacun);
		
		JLabel lblIzmeniStatusBrojaTelefonaRacun = new JLabel("Izmeni status broja telefona:");
		lblIzmeniStatusBrojaTelefonaRacun.setBounds(40, 240, 150, 15);
		panelRacun.add(lblIzmeniStatusBrojaTelefonaRacun);
		
		JComboBox comboBoxStatusRacun = new JComboBox();
		comboBoxStatusRacun.setModel(new DefaultComboBoxModel(new String[] {"SLOBODAN", "ZAUZET"}));
		comboBoxStatusRacun.setToolTipText("");
		comboBoxStatusRacun.setBounds(200, 236, 120, 23);
		panelRacun.add(comboBoxStatusRacun);
		
		JLabel lblDatumPotpisivanjaUgovoraRacun = new JLabel("Datum potpisivanja ugovora:");
		lblDatumPotpisivanjaUgovoraRacun.setBounds(40, 280, 150, 15);
		panelRacun.add(lblDatumPotpisivanjaUgovoraRacun);
		
		JDateChooser dateChooserDatumPotpisivanjaUgovoraRacun = new JDateChooser();
		dateChooserDatumPotpisivanjaUgovoraRacun.setBounds(200, 280, 120, 20);
		panelRacun.add(dateChooserDatumPotpisivanjaUgovoraRacun);
		
		JLabel lblUkupnaCenaRacun = new JLabel("Ukupna cena:");
		lblUkupnaCenaRacun.setBounds(40, 320, 75, 15);
		panelRacun.add(lblUkupnaCenaRacun);
		
		JLabel labelUkupnaCenaRacun = new JLabel("0");
		labelUkupnaCenaRacun.setBounds(120, 320, 80, 15);
		panelRacun.add(labelUkupnaCenaRacun);
		
		JLabel lblMesecnaRataRacun = new JLabel("Mesecna rata:");
		lblMesecnaRataRacun.setBounds(220, 320, 75, 15);
		panelRacun.add(lblMesecnaRataRacun);
		
		JLabel labelMesecnaRataRacun = new JLabel("0");
		labelMesecnaRataRacun.setBounds(300, 320, 46, 14);
		panelRacun.add(labelMesecnaRataRacun);
		
		JButton btnStampajRacun = new JButton("Stampaj");
		btnStampajRacun.setBounds(550, 310, 100, 25);
		panelRacun.add(btnStampajRacun);
		
		JButton btnSacuvajIzmenuStatusa = new JButton("Sacuvaj izmenu statusa");
		btnSacuvajIzmenuStatusa.setBounds(340, 235, 150, 25);
		panelRacun.add(btnSacuvajIzmenuStatusa);
		
		JButton btnNazad = new JButton("Nazad");
		btnNazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnNazad.setBounds(620, 360, 100, 25);
		panelRacun.add(btnNazad);
	}
	
	//METODA KOJA ZATVARA TRENUTNI FRAJM
	public void close(){
		this.setVisible(false);
	}
}
