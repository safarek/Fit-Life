package FitLife;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.sql.*;

public class DlgUnosTrenera extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldIme;
	private JTextField textFieldPrezime;
	private JTextField textFieldOib;
	private JTextField textFieldAdresa;
	private JTextField textFieldTelBroj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgUnosTrenera dialog = new DlgUnosTrenera();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgUnosTrenera() {
		setTitle("Unos Trenera");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblImeTrenera = new JLabel("Ime trenera");
		lblImeTrenera.setBounds(10, 11, 85, 27);
		contentPanel.add(lblImeTrenera);
		
		JLabel lblPrezimeTrenera = new JLabel("Prezime Trenera");
		lblPrezimeTrenera.setBounds(10, 49, 98, 27);
		contentPanel.add(lblPrezimeTrenera);
		
		JLabel lblOibTrenera = new JLabel("OIB Trenera");
		lblOibTrenera.setBounds(10, 93, 85, 14);
		contentPanel.add(lblOibTrenera);
		
		JLabel lblAdresaTrenera = new JLabel("Adresa Trenera");
		lblAdresaTrenera.setBounds(10, 118, 98, 27);
		contentPanel.add(lblAdresaTrenera);
		
		JLabel lblTelBroj = new JLabel("Tel Broj Trenera");
		lblTelBroj.setBounds(10, 155, 85, 27);
		contentPanel.add(lblTelBroj);
		
		textFieldIme = new JTextField();
		textFieldIme.setBounds(149, 14, 199, 20);
		contentPanel.add(textFieldIme);
		textFieldIme.setColumns(10);
		
		textFieldPrezime = new JTextField();
		textFieldPrezime.setBounds(149, 52, 199, 20);
		contentPanel.add(textFieldPrezime);
		textFieldPrezime.setColumns(10);
		
		textFieldOib = new JTextField();
		textFieldOib.setBounds(149, 90, 199, 20);
		contentPanel.add(textFieldOib);
		textFieldOib.setColumns(10);
		
		textFieldAdresa = new JTextField();
		textFieldAdresa.setBounds(149, 121, 199, 20);
		contentPanel.add(textFieldAdresa);
		textFieldAdresa.setColumns(10);
		
		textFieldTelBroj = new JTextField();
		textFieldTelBroj.setBounds(149, 158, 199, 20);
		contentPanel.add(textFieldTelBroj);
		textFieldTelBroj.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String ime_trenera = textFieldIme.getText();
						String prezime_trenera = textFieldPrezime.getText();
						String oib_trenera = textFieldOib.getText();
						String adresa_trenera = textFieldAdresa.getText();
						String tel_broj_trenera = textFieldTelBroj.getText();
						
						try {
							Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
							Connection conn = DriverManager.getConnection("jdbc:mysql://ucka.veleri.hr/muljanic?"+
								                                   "user=muljanic&password=11");
								                                   
						
							String sql = "INSERT INTO Trener VALUES(NULL,?,?,?,?,?);";
							PreparedStatement stmt = conn.prepareStatement(sql);
							
							stmt.setString(1,ime_trenera);
							stmt.setString(2, prezime_trenera);
							stmt.setString(3, oib_trenera);
							stmt.setString(4, adresa_trenera);
							stmt.setString(5, tel_broj_trenera);

							stmt.execute();
							
							conn.close();
							
							textFieldIme.setText("");
							textFieldPrezime.setText("");
							textFieldOib.setText("");
							textFieldAdresa.setText("");
							textFieldTelBroj.setText("");
						
							
						} catch(Exception ex) {
							JOptionPane.showMessageDialog(null, ex.getMessage(),"Greska", JOptionPane.ERROR_MESSAGE);
						}	
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
