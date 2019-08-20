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

public class JFrameSpisakRadnika extends JFrame {

	private JPanel contentPane;
	private JTable tableSpisakRadnika;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameSpisakRadnika frame = new JFrameSpisakRadnika();
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
	public JFrameSpisakRadnika() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelSpisakRadnika = new JPanel();
		panelSpisakRadnika.setBorder(new TitledBorder(null, "Spisa radnika", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSpisakRadnika.setBounds(30, 30, 650, 380);
		contentPane.add(panelSpisakRadnika);
		panelSpisakRadnika.setLayout(null);
		
		JScrollPane scrollPaneSpisakRadnika = new JScrollPane();
		scrollPaneSpisakRadnika.setBounds(20, 30, 610, 280);
		panelSpisakRadnika.add(scrollPaneSpisakRadnika);
		
		tableSpisakRadnika = new JTable();
		scrollPaneSpisakRadnika.setViewportView(tableSpisakRadnika);
		
		JButton btnObrisiSpisakRadnika = new JButton("Obrisi");
		btnObrisiSpisakRadnika.setBounds(40, 330, 100, 25);
		panelSpisakRadnika.add(btnObrisiSpisakRadnika);
		
		JButton btnNazadSpisakRadnika = new JButton("Nazad");
		btnNazadSpisakRadnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnNazadSpisakRadnika.setBounds(510, 330, 100, 25);
		panelSpisakRadnika.add(btnNazadSpisakRadnika);
	}
	
	//METODA KOJA ZATVARA TRENUTNI FRAJM
			public void close(){
				this.setVisible(false);
			}

}
