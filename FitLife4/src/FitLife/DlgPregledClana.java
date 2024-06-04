package FitLife;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DlgPregledClana extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	JTextArea textAreaPregled;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgPregledClana dialog = new DlgPregledClana();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgPregledClana() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 206);
		contentPanel.add(scrollPane);
		
		textAreaPregled = new JTextArea();
		scrollPane.setViewportView(textAreaPregled);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						}
				});

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
		selectPregledClana();
		}
		
		private void selectPregledClana() {
			
			try {
			  	  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				  Connection conn = 
						  DriverManager.getConnection("jdbc:mysql://ucka.veleri.hr/muljanic?" +
			 "user=muljanic&password=11");
				  
				  String sql = "SELECT * FROM Clan";
				  Statement stmt = conn.createStatement();
				  ResultSet rs = stmt.executeQuery(sql);
				  String tekst = "";
				  while (rs.next()) {
					tekst += "Ime: "+rs.getString("ime_clana")+"\t";				
					tekst += "Prezime: "+rs.getString("prezime_clana")+"\t";
					tekst += "OIB: "+rs.getString("oib_clana")+"\t";
					tekst += "Adresa: "+rs.getString("adresa_clana")+"\t";
					tekst += "Telefon: "+rs.getString("tel_broj_clana")+"\n";
				  }	
				  textAreaPregled.setText(tekst);
				  conn.close();
				
			} catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(),"Greška",
			 JOptionPane.ERROR_MESSAGE);

			}
		}
	}
