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

public class DlgUnosClana extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldImeClana;
	private JTextField textFieldPrezimeClana;
	private JTextField textFieldOibClana;
	private JTextField textFieldAdresaClana;
	private JTextField textFieldTelefonskiBroj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgUnosClana dialog = new DlgUnosClana();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgUnosClana() {
		setTitle("Unos clana");
		setBounds(100, 100, 584, 399);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblImeClana = new JLabel("Ime clana");
		lblImeClana.setBounds(34, 43, 81, 29);
		contentPanel.add(lblImeClana);
		
		JLabel lblPrezimeClana = new JLabel("Prezime clana");
		lblPrezimeClana.setBounds(34, 83, 81, 29);
		contentPanel.add(lblPrezimeClana);
		
		JLabel lblOibClana = new JLabel("Oib clana");
		lblOibClana.setBounds(34, 123, 81, 29);
		contentPanel.add(lblOibClana);
		
		JLabel lblAdresaClana = new JLabel("Adresa clana");
		lblAdresaClana.setBounds(34, 163, 81, 29);
		contentPanel.add(lblAdresaClana);
		
		JLabel lblTelefonskiBroj = new JLabel("Telefonski broj");
		lblTelefonskiBroj.setBounds(34, 203, 81, 29);
		contentPanel.add(lblTelefonskiBroj);
		
		textFieldImeClana = new JTextField();
		textFieldImeClana.setBounds(206, 43, 281, 29);
		contentPanel.add(textFieldImeClana);
		textFieldImeClana.setColumns(10);
		
		textFieldPrezimeClana = new JTextField();
		textFieldPrezimeClana.setBounds(206, 83, 281, 29);
		contentPanel.add(textFieldPrezimeClana);
		textFieldPrezimeClana.setColumns(10);
		
		textFieldOibClana = new JTextField();
		textFieldOibClana.setColumns(10);
		textFieldOibClana.setBounds(206, 123, 281, 29);
		contentPanel.add(textFieldOibClana);
		
		textFieldAdresaClana = new JTextField();
		textFieldAdresaClana.setColumns(10);
		textFieldAdresaClana.setBounds(206, 163, 281, 29);
		contentPanel.add(textFieldAdresaClana);
		
		textFieldTelefonskiBroj = new JTextField();
		textFieldTelefonskiBroj.setColumns(10);
		textFieldTelefonskiBroj.setBounds(206, 203, 281, 29);
		contentPanel.add(textFieldTelefonskiBroj);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String ime_clana = textFieldImeClana.getText();
						String prezime_clana = textFieldPrezimeClana.getText();
						String oib_clana = textFieldOibClana.getText();
						String adresa_clana = textFieldAdresaClana.getText();
						String tel_broj_clana = textFieldTelefonskiBroj.getText();
						
						try {
							Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
							Connection conn = DriverManager.getConnection("jdbc:mysql://ucka.veleri.hr/muljanic?"+
								                                   "user=muljanic&password=11");
								                                   
							//ime_clana,prezime_clana,oib_clana,adresa_clana,tel_broj_clana
							String sql = "INSERT INTO Clan VALUES(NULL,?,?,?,?,?);";
							PreparedStatement stmt = conn.prepareStatement(sql);
							
							stmt.setString(1,ime_clana);
							stmt.setString(2, prezime_clana);
							stmt.setString(3, oib_clana);
							stmt.setString(4, adresa_clana);
							stmt.setString(5, tel_broj_clana);

							stmt.execute();
							
							conn.close();
							
							textFieldImeClana.setText("");
							textFieldPrezimeClana.setText("");
							textFieldOibClana.setText("");
							textFieldAdresaClana.setText("");
							textFieldTelefonskiBroj.setText("");
						
							
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
