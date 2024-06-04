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

public class DlgUnosPlanova extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNaziv;
	private JTextField textFieldCijena;
	private JTextField textFieldBroj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgUnosPlanova dialog = new DlgUnosPlanova();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgUnosPlanova() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNazivPlana = new JLabel("Naziv Plana");
			lblNazivPlana.setBounds(32, 26, 77, 14);
			contentPanel.add(lblNazivPlana);
		}
		{
			JLabel lblCijenaPlana = new JLabel("Cijena Plana");
			lblCijenaPlana.setBounds(32, 72, 77, 14);
			contentPanel.add(lblCijenaPlana);
		}
		{
			JLabel lblBrojPolaznika = new JLabel("Broj Polaznika");
			lblBrojPolaznika.setBounds(32, 121, 99, 14);
			contentPanel.add(lblBrojPolaznika);
		}
		{
			textFieldNaziv = new JTextField();
			textFieldNaziv.setBounds(141, 23, 163, 20);
			contentPanel.add(textFieldNaziv);
			textFieldNaziv.setColumns(10);
		}
		{
			textFieldCijena = new JTextField();
			textFieldCijena.setColumns(10);
			textFieldCijena.setBounds(141, 69, 163, 20);
			contentPanel.add(textFieldCijena);
		}
		{
			textFieldBroj = new JTextField();
			textFieldBroj.setColumns(10);
			textFieldBroj.setBounds(141, 118, 163, 20);
			contentPanel.add(textFieldBroj);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							String naziv_plana = textFieldNaziv.getText();
							String cijena_plana = textFieldCijena.getText();
							String broj_polaznika = textFieldBroj.getText();
							
							try {
								Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
								Connection conn = DriverManager.getConnection("jdbc:mysql://ucka.veleri.hr/muljanic?"+
									                                   "user=muljanic&password=11");
									                                   
							
								String sql = "INSERT INTO Plan VALUES(NULL,?,?,?);";
								PreparedStatement stmt = conn.prepareStatement(sql);
								
								stmt.setString(1,naziv_plana);
								stmt.setString(2, cijena_plana);
								stmt.setString(3, broj_polaznika);

								stmt.execute();
								
								conn.close();
								
								textFieldNaziv.setText("");
								textFieldCijena.setText("");
								textFieldBroj.setText("");
							
								
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
