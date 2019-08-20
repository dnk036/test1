package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFramePostPaid extends JFrame {

	private JPanel contentPane;
	private JTable tablePaketPostPaid;
	private JTable tableUredjajPostPaid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFramePostPaid frame = new JFramePostPaid();
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
	public JFramePostPaid() {
		setTitle("TeleSRB - PostPaid");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 591);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelPostPaidPP = new JPanel();
		panelPostPaidPP.setBorder(new TitledBorder(null, "PostPaid", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPostPaidPP.setBounds(20, 20, 740, 510);
		contentPane.add(panelPostPaidPP);
		panelPostPaidPP.setLayout(null);
		
		JLabel lblBrojTelefonaPostPaid = new JLabel("Broj telefona:");
		lblBrojTelefonaPostPaid.setBounds(70, 30, 90, 15);
		panelPostPaidPP.add(lblBrojTelefonaPostPaid);
		
		JComboBox comboBoxBrojTelefonaPostPaid = new JComboBox();
		comboBoxBrojTelefonaPostPaid.setBounds(170, 25, 150, 25);
		panelPostPaidPP.add(comboBoxBrojTelefonaPostPaid);
		
		JPanel panelPaketPostPaid = new JPanel();
		panelPaketPostPaid.setBorder(new TitledBorder(null, "Paket", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPaketPostPaid.setBounds(30, 70, 680, 150);
		panelPostPaidPP.add(panelPaketPostPaid);
		panelPaketPostPaid.setLayout(null);
		
		JScrollPane scrollPanePaketPostPaid = new JScrollPane();
		scrollPanePaketPostPaid.setBounds(20, 20, 460, 110);
		panelPaketPostPaid.add(scrollPanePaketPostPaid);
		
		tablePaketPostPaid = new JTable();
		scrollPanePaketPostPaid.setViewportView(tablePaketPostPaid);
		
		JComboBox comboBoxIzaberitePaketPostPaid = new JComboBox();
		comboBoxIzaberitePaketPostPaid.setBounds(500, 100, 160, 25);
		panelPaketPostPaid.add(comboBoxIzaberitePaketPostPaid);
		
		JLabel lblIzaberitePaketPostPaid = new JLabel("Izaberite paket:");
		lblIzaberitePaketPostPaid.setBounds(510, 80, 120, 15);
		panelPaketPostPaid.add(lblIzaberitePaketPostPaid);
		
		JPanel panelUredjajPostPaid = new JPanel();
		panelUredjajPostPaid.setBorder(new TitledBorder(null, "Uredjaj", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelUredjajPostPaid.setBounds(30, 230, 680, 150);
		panelPostPaidPP.add(panelUredjajPostPaid);
		panelUredjajPostPaid.setLayout(null);
		
		JScrollPane scrollPaneUredjajPostPaid = new JScrollPane();
		scrollPaneUredjajPostPaid.setBounds(20, 20, 460, 110);
		panelUredjajPostPaid.add(scrollPaneUredjajPostPaid);
		
		tableUredjajPostPaid = new JTable();
		scrollPaneUredjajPostPaid.setViewportView(tableUredjajPostPaid);
		
		JLabel lblDaLiZeliteUredjajPostPaid = new JLabel("Da li \u017Eelite uredjaj?");
		lblDaLiZeliteUredjajPostPaid.setBounds(510, 20, 120, 15);
		panelUredjajPostPaid.add(lblDaLiZeliteUredjajPostPaid);
		
		JRadioButton rdbtnDaUredjajPostPaid = new JRadioButton("DA");
		rdbtnDaUredjajPostPaid.setBounds(510, 40, 55, 25);
		panelUredjajPostPaid.add(rdbtnDaUredjajPostPaid);
		
		JRadioButton rdbtnNe = new JRadioButton("NE");
		rdbtnNe.setBounds(570, 40, 55, 25);
		panelUredjajPostPaid.add(rdbtnNe);
		
		JLabel lblIzaberiteUredjajPostPaid = new JLabel("Izaberite uredjaj:");
		lblIzaberiteUredjajPostPaid.setBounds(510, 80, 120, 15);
		panelUredjajPostPaid.add(lblIzaberiteUredjajPostPaid);
		
		JComboBox comboBoxIzaberiteUredjajPostPaid = new JComboBox();
		comboBoxIzaberiteUredjajPostPaid.setBounds(500, 100, 160, 25);
		panelUredjajPostPaid.add(comboBoxIzaberiteUredjajPostPaid);
		
		JLabel lblTrajanjeUgovoraOdPostPaid = new JLabel("Trajanje ugovora od:");
		lblTrajanjeUgovoraOdPostPaid.setBounds(250, 390, 110, 15);
		panelPostPaidPP.add(lblTrajanjeUgovoraOdPostPaid);
		
		JDateChooser dateChooserTrajanjeUgovoraOdPostPaid = new JDateChooser();
		dateChooserTrajanjeUgovoraOdPostPaid.setBounds(370, 387, 110, 20);
		panelPostPaidPP.add(dateChooserTrajanjeUgovoraOdPostPaid);
		
		JLabel lblTrajanjeUgovoraDoPostPaid = new JLabel("do:");
		lblTrajanjeUgovoraDoPostPaid.setBounds(495, 390, 25, 15);
		panelPostPaidPP.add(lblTrajanjeUgovoraDoPostPaid);
		
		JDateChooser dateChooserTrajanjeUgovoraDoPostPaid = new JDateChooser();
		dateChooserTrajanjeUgovoraDoPostPaid.setBounds(530, 387, 110, 20);
		panelPostPaidPP.add(dateChooserTrajanjeUgovoraDoPostPaid);
		
		JButton btnDidajUKorpuPostPaid = new JButton("Didaj u korpu");
		btnDidajUKorpuPostPaid.setBounds(600, 427, 110, 25);
		panelPostPaidPP.add(btnDidajUKorpuPostPaid);
		
		JButton btnNazadPostPaid = new JButton("Nazad");
		btnNazadPostPaid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnNazadPostPaid.setBounds(600, 467, 110, 25);
		panelPostPaidPP.add(btnNazadPostPaid);
		
		JLabel lblBrojRataPostPaid = new JLabel("Broj rata:");
		lblBrojRataPostPaid.setBounds(50, 390, 50, 15);
		panelPostPaidPP.add(lblBrojRataPostPaid);
		
		JComboBox comboBoxBrojRataPostPaid = new JComboBox();
		comboBoxBrojRataPostPaid.setModel(new DefaultComboBoxModel(new String[] {"...", "12", "24"}));
		comboBoxBrojRataPostPaid.setBounds(110, 387, 80, 20);
		panelPostPaidPP.add(comboBoxBrojRataPostPaid);
		
		JLabel lblMesecnaRataPostPaid = new JLabel("Mese\u010Dna rata:");
		lblMesecnaRataPostPaid.setBounds(317, 430, 90, 15);
		panelPostPaidPP.add(lblMesecnaRataPostPaid);
		
		JLabel labelMesecnaRataPostPaid = new JLabel("0");
		labelMesecnaRataPostPaid.setBounds(410, 430, 70, 15);
		panelPostPaidPP.add(labelMesecnaRataPostPaid);
	}
	
	//METODA KOJA ZATVARA TRENUTNI FRAJM
			public void close(){
				this.setVisible(false);
			}
}
