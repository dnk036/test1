package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFramaSpisakKorisnika extends JFrame {

	private JPanel contentPane;
	private JTable tableSpisakKorisnika;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFramaSpisakKorisnika frame = new JFramaSpisakKorisnika();
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
	public JFramaSpisakKorisnika() {
		setTitle("TeleSRB - SpisakKorisnika");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelSpisakKorisnika = new JPanel();
		panelSpisakKorisnika.setBorder(new TitledBorder(null, "Spisak korisnika", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSpisakKorisnika.setBounds(30, 30, 650, 380);
		contentPane.add(panelSpisakKorisnika);
		panelSpisakKorisnika.setLayout(null);
		
		JScrollPane scrollPaneSpisakKorisnika = new JScrollPane();
		scrollPaneSpisakKorisnika.setBounds(20, 30, 610, 280);
		panelSpisakKorisnika.add(scrollPaneSpisakKorisnika);
		
		tableSpisakKorisnika = new JTable();
		scrollPaneSpisakKorisnika.setViewportView(tableSpisakKorisnika);
		
		JButton btnObrisiSpisakKorisnika = new JButton("Obrisi");
		btnObrisiSpisakKorisnika.setBounds(40, 330, 100, 25);
		panelSpisakKorisnika.add(btnObrisiSpisakKorisnika);
		
		JButton btnNazadSpisakKorisnika = new JButton("Nazad");
		btnNazadSpisakKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnNazadSpisakKorisnika.setBounds(510, 330, 100, 25);
		panelSpisakKorisnika.add(btnNazadSpisakKorisnika);
	}
	
	//METODA KOJA ZATVARA TRENUTNI FRAJM
			public void close(){
				this.setVisible(false);
			}
}
