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
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFramePripaidIDodatnaOprema extends JFrame {

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
					JFramePripaidIDodatnaOprema frame = new JFramePripaidIDodatnaOprema();
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
	public JFramePripaidIDodatnaOprema() {
		setTitle("TeleSRB - Pripaid i dodatna oprema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelPIDOPPripaidIDodatnaOprema = new JPanel();
		panelPIDOPPripaidIDodatnaOprema.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pripaid i dodatna oprema", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPIDOPPripaidIDodatnaOprema.setBounds(50, 50, 680, 325);
		contentPane.add(panelPIDOPPripaidIDodatnaOprema);
		panelPIDOPPripaidIDodatnaOprema.setLayout(null);
		
		JScrollPane scrollPaneDodatnaOpremaIPriPaid = new JScrollPane();
		scrollPaneDodatnaOpremaIPriPaid.setBounds(30, 30, 620, 200);
		panelPIDOPPripaidIDodatnaOprema.add(scrollPaneDodatnaOpremaIPriPaid);
		
		tableDodatnaOpremaIPriPaid = new JTable();
		scrollPaneDodatnaOpremaIPriPaid.setViewportView(tableDodatnaOpremaIPriPaid);
		
		JLabel lblNazivDodatnaOpremaIPriPaid = new JLabel("Naziv");
		lblNazivDodatnaOpremaIPriPaid.setBounds(50, 250, 100, 15);
		panelPIDOPPripaidIDodatnaOprema.add(lblNazivDodatnaOpremaIPriPaid);
		
		JComboBox comboBoxNazivDodatnaOpremaIPriPaid = new JComboBox();
		comboBoxNazivDodatnaOpremaIPriPaid.setBounds(50, 270, 150, 25);
		panelPIDOPPripaidIDodatnaOprema.add(comboBoxNazivDodatnaOpremaIPriPaid);
		
		JLabel lblKolicinaDodatnaOpremaIPriPaid = new JLabel("Kolicina:");
		lblKolicinaDodatnaOpremaIPriPaid.setBounds(250, 250, 100, 15);
		panelPIDOPPripaidIDodatnaOprema.add(lblKolicinaDodatnaOpremaIPriPaid);
		
		textFieldKolicinaDodatnaOpremaIPriPaid = new JTextField();
		textFieldKolicinaDodatnaOpremaIPriPaid.setBounds(250, 270, 100, 25);
		panelPIDOPPripaidIDodatnaOprema.add(textFieldKolicinaDodatnaOpremaIPriPaid);
		textFieldKolicinaDodatnaOpremaIPriPaid.setColumns(10);
		
		JButton btnDodajUKorpuDodatnaOpremaIPriPaid = new JButton("Dodaj u korpu");
		btnDodajUKorpuDodatnaOpremaIPriPaid.setBounds(400, 270, 120, 25);
		panelPIDOPPripaidIDodatnaOprema.add(btnDodajUKorpuDodatnaOpremaIPriPaid);
		
		JButton btnZatvorNazadOpremaIPriPaid = new JButton("Nazad");
		btnZatvorNazadOpremaIPriPaid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnZatvorNazadOpremaIPriPaid.setBounds(610, 410, 100, 25);
		contentPane.add(btnZatvorNazadOpremaIPriPaid);
	}
	
	//METODA KOJA ZATVARA TRENUTNI FRAJM
		public void close(){
			this.setVisible(false);
		}
}
