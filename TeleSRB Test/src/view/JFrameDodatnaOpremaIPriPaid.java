package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

public class JFrameDodatnaOpremaIPriPaid extends JFrame {

	private JPanel contentPane;
	private JTable tableDodatnaOpremaIPriPaid;
	private JTextField textFieldKolicinaDodatnaOpremaIPriPaid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameDodatnaOpremaIPriPaid frame = new JFrameDodatnaOpremaIPriPaid();
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
	public JFrameDodatnaOpremaIPriPaid() {
		setTitle("TeleSRB - Dodatna oprema i PriPaid");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelDOIPPDodatnaOpremaIPriPaid = new JPanel();
		panelDOIPPDodatnaOpremaIPriPaid.setBorder(new TitledBorder(null, "Dodatna oprema i PriPaid", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDOIPPDodatnaOpremaIPriPaid.setBounds(50, 50, 680, 325);
		contentPane.add(panelDOIPPDodatnaOpremaIPriPaid);
		panelDOIPPDodatnaOpremaIPriPaid.setLayout(null);
		
		JScrollPane scrollPaneDodatnaOpremaIPriPaid = new JScrollPane();
		scrollPaneDodatnaOpremaIPriPaid.setBounds(30, 30, 620, 200);
		panelDOIPPDodatnaOpremaIPriPaid.add(scrollPaneDodatnaOpremaIPriPaid);
		
		tableDodatnaOpremaIPriPaid = new JTable();
		scrollPaneDodatnaOpremaIPriPaid.setViewportView(tableDodatnaOpremaIPriPaid);
		
		JLabel lblNazivDodatnaOpremaIPriPaid = new JLabel("Naziv");
		lblNazivDodatnaOpremaIPriPaid.setBounds(50, 250, 100, 15);
		panelDOIPPDodatnaOpremaIPriPaid.add(lblNazivDodatnaOpremaIPriPaid);
		
		JComboBox comboBoxNazivDodatnaOpremaIPriPaid = new JComboBox();
		comboBoxNazivDodatnaOpremaIPriPaid.setBounds(50, 270, 150, 25);
		panelDOIPPDodatnaOpremaIPriPaid.add(comboBoxNazivDodatnaOpremaIPriPaid);
		
		JLabel lblKolicinaDodatnaOpremaIPriPaid = new JLabel("Kolicina:");
		lblKolicinaDodatnaOpremaIPriPaid.setBounds(250, 250, 100, 15);
		panelDOIPPDodatnaOpremaIPriPaid.add(lblKolicinaDodatnaOpremaIPriPaid);
		
		textFieldKolicinaDodatnaOpremaIPriPaid = new JTextField();
		textFieldKolicinaDodatnaOpremaIPriPaid.setBounds(250, 270, 100, 25);
		panelDOIPPDodatnaOpremaIPriPaid.add(textFieldKolicinaDodatnaOpremaIPriPaid);
		textFieldKolicinaDodatnaOpremaIPriPaid.setColumns(10);
		
		JButton btnDodajUKorpuDodatnaOpremaIPriPaid = new JButton("Dodaj u korpu");
		btnDodajUKorpuDodatnaOpremaIPriPaid.setBounds(400, 270, 120, 25);
		panelDOIPPDodatnaOpremaIPriPaid.add(btnDodajUKorpuDodatnaOpremaIPriPaid);
		
		JButton btnNazadDodatnaOpremaIPriPaid = new JButton("Nazad");
		btnNazadDodatnaOpremaIPriPaid.setBounds(610, 410, 100, 25);
		contentPane.add(btnNazadDodatnaOpremaIPriPaid);
	}
}
