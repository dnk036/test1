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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class JFrameUnosPodataka extends JFrame {

	private JPanel contentPane;
	private JTable tableBrojTelefonaUnosPodataka;
	private JTextField textFieldNumeracijaUnosPodataka;
	private JTable tableOstaleTabeleUnosPodataka;
	private JTextField textFieldTipUnosPodataka;
	private JTextField textFieldNazivUnosPodataka;
	private JTextField textFieldUnosPodataka;

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
		panelUnosPodataka.setBounds(20, 20, 740, 500);
		contentPane.add(panelUnosPodataka);
		panelUnosPodataka.setLayout(null);
		
		JPanel panelBrojTelefonaUnosPodataka = new JPanel();
		panelBrojTelefonaUnosPodataka.setBorder(new TitledBorder(null, "Unos broja telefona", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBrojTelefonaUnosPodataka.setBounds(20, 20, 700, 160);
		panelUnosPodataka.add(panelBrojTelefonaUnosPodataka);
		panelBrojTelefonaUnosPodataka.setLayout(null);
		
		JScrollPane scrollPaneBrojTelefonaUnosPodataka = new JScrollPane();
		scrollPaneBrojTelefonaUnosPodataka.setBounds(20, 20, 350, 120);
		panelBrojTelefonaUnosPodataka.add(scrollPaneBrojTelefonaUnosPodataka);
		
		tableBrojTelefonaUnosPodataka = new JTable();
		scrollPaneBrojTelefonaUnosPodataka.setViewportView(tableBrojTelefonaUnosPodataka);
		
		JLabel lblNumeracijaUnosPodataka = new JLabel("Numeracija (unesite broj telefona)");
		lblNumeracijaUnosPodataka.setBounds(455, 20, 220, 15);
		panelBrojTelefonaUnosPodataka.add(lblNumeracijaUnosPodataka);
		
		textFieldNumeracijaUnosPodataka = new JTextField();
		textFieldNumeracijaUnosPodataka.setBounds(455, 35, 160, 25);
		panelBrojTelefonaUnosPodataka.add(textFieldNumeracijaUnosPodataka);
		textFieldNumeracijaUnosPodataka.setColumns(10);
		
		JComboBox comboBoxStatusUnosPodataka = new JComboBox();
		comboBoxStatusUnosPodataka.setBounds(455, 70, 160, 20);
		panelBrojTelefonaUnosPodataka.add(comboBoxStatusUnosPodataka);
		comboBoxStatusUnosPodataka.setModel(new DefaultComboBoxModel(new String[] {"Status broja telefona", "Slobodan", "Zauzet"}));
		
		JButton btnIzmeniBTUnosPodataka = new JButton("Izmeni");
		btnIzmeniBTUnosPodataka.setBounds(385, 110, 90, 25);
		panelBrojTelefonaUnosPodataka.add(btnIzmeniBTUnosPodataka);
		
		JButton btnObrisiBTUnosPodataka = new JButton("Obri\u0161i");
		btnObrisiBTUnosPodataka.setBounds(490, 110, 90, 25);
		panelBrojTelefonaUnosPodataka.add(btnObrisiBTUnosPodataka);
		
		JButton btnSauvajBTUnosPodataka = new JButton("Sa\u010Duvaj");
		btnSauvajBTUnosPodataka.setBounds(595, 110, 90, 25);
		panelBrojTelefonaUnosPodataka.add(btnSauvajBTUnosPodataka);
		
		JPanel panelOstalTabeleUnosPodataka = new JPanel();
		panelOstalTabeleUnosPodataka.setBorder(new TitledBorder(null, "Unos u ostale tabele", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelOstalTabeleUnosPodataka.setBounds(20, 200, 700, 280);
		panelUnosPodataka.add(panelOstalTabeleUnosPodataka);
		panelOstalTabeleUnosPodataka.setLayout(null);
		
		JLabel lblIzaberiteTabeluUnosPodataka = new JLabel("Izaberite tabelu koju \u017Eelite da uredjujete:");
		lblIzaberiteTabeluUnosPodataka.setBounds(50, 30, 220, 15);
		panelOstalTabeleUnosPodataka.add(lblIzaberiteTabeluUnosPodataka);
		
		JComboBox comboBoxIzaberiteTabeluUnosPodataka = new JComboBox();
		comboBoxIzaberiteTabeluUnosPodataka.setBounds(280, 25, 180, 25);
		panelOstalTabeleUnosPodataka.add(comboBoxIzaberiteTabeluUnosPodataka);
		
		JButton btnUcitajUnosPodataka = new JButton("U\u010Ditaj");
		btnUcitajUnosPodataka.setBounds(500, 25, 100, 25);
		panelOstalTabeleUnosPodataka.add(btnUcitajUnosPodataka);
		
		JScrollPane scrollPaneOstaleTabeleUnosPodataka = new JScrollPane();
		scrollPaneOstaleTabeleUnosPodataka.setBounds(20, 70, 350, 190);
		panelOstalTabeleUnosPodataka.add(scrollPaneOstaleTabeleUnosPodataka);
		
		tableOstaleTabeleUnosPodataka = new JTable();
		scrollPaneOstaleTabeleUnosPodataka.setViewportView(tableOstaleTabeleUnosPodataka);
		
		JLabel lblTipUnosPodataka = new JLabel("Tip");
		lblTipUnosPodataka.setBounds(385, 70, 45, 15);
		panelOstalTabeleUnosPodataka.add(lblTipUnosPodataka);
		
		textFieldTipUnosPodataka = new JTextField();
		textFieldTipUnosPodataka.setBounds(385, 90, 90, 20);
		panelOstalTabeleUnosPodataka.add(textFieldTipUnosPodataka);
		textFieldTipUnosPodataka.setColumns(10);
		
		JLabel lblNazivUnosPodataka = new JLabel("Naziv");
		lblNazivUnosPodataka.setBounds(490, 70, 46, 15);
		panelOstalTabeleUnosPodataka.add(lblNazivUnosPodataka);
		
		textFieldNazivUnosPodataka = new JTextField();
		textFieldNazivUnosPodataka.setBounds(490, 90, 100, 20);
		panelOstalTabeleUnosPodataka.add(textFieldNazivUnosPodataka);
		textFieldNazivUnosPodataka.setColumns(10);
		
		JLabel lblCenaUnosPodataka = new JLabel("Cena");
		lblCenaUnosPodataka.setBounds(600, 70, 46, 15);
		panelOstalTabeleUnosPodataka.add(lblCenaUnosPodataka);
		
		textFieldUnosPodataka = new JTextField();
		textFieldUnosPodataka.setBounds(600, 90, 80, 20);
		panelOstalTabeleUnosPodataka.add(textFieldUnosPodataka);
		textFieldUnosPodataka.setColumns(10);
		
		JLabel lblOpisUnosPodataka = new JLabel("Opis");
		lblOpisUnosPodataka.setBounds(385, 120, 46, 14);
		panelOstalTabeleUnosPodataka.add(lblOpisUnosPodataka);
		
		JScrollPane scrollPaneOpisUnosPodataka = new JScrollPane();
		scrollPaneOpisUnosPodataka.setBounds(385, 140, 300, 80);
		panelOstalTabeleUnosPodataka.add(scrollPaneOpisUnosPodataka);
		
		JTextArea textAreaOpisUnosPodataka = new JTextArea();
		scrollPaneOpisUnosPodataka.setViewportView(textAreaOpisUnosPodataka);
		
		JButton btnIzmeniOTUnosPodataka = new JButton("Izmeni");
		btnIzmeniOTUnosPodataka.setBounds(385, 230, 90, 25);
		panelOstalTabeleUnosPodataka.add(btnIzmeniOTUnosPodataka);
		
		JButton btnObrisiOTUnosPodataka = new JButton("Obri\u0161i");
		btnObrisiOTUnosPodataka.setBounds(490, 230, 90, 25);
		panelOstalTabeleUnosPodataka.add(btnObrisiOTUnosPodataka);
		
		JButton btnSacuvajOTUnosPodataka = new JButton("Sa\u010Duvaj");
		btnSacuvajOTUnosPodataka.setBounds(595, 230, 90, 25);
		panelOstalTabeleUnosPodataka.add(btnSacuvajOTUnosPodataka);
		
		JButton btnZatvori = new JButton("Zatvori");
		btnZatvori.setBounds(640, 540, 100, 25);
		contentPane.add(btnZatvori);
	}
}
