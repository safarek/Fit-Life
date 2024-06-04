package FitLife;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.TextAction;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgPregledPlanova extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private AbstractButton textAreaPlan;
	JTextArea TextAreaPlan;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgPregledPlanova dialog = new DlgPregledPlanova();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgPregledPlanova() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 206);
		contentPanel.add(scrollPane);
		
		JTextArea textAreaPlan = new JTextArea();
		scrollPane.setViewportView(textAreaPlan);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
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
		selectPregledPlanova();
		}
	
		private void selectPregledPlanova() {
	
			try {
	  	  		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	  	  		Connection conn = 
	  	  			DriverManager.getConnection("jdbc:mysql://ucka.veleri.hr/muljanic?" +
	  	  	"user=muljanic&password=11");
		  
	  	  		String sql = "SELECT * FROM Plan";
	  	  		Statement stmt = conn.createStatement();
	  	  		ResultSet rs = stmt.executeQuery(sql);
	  	  		String tekst = "";
	  	  		while (rs.next()) {
	  	  			tekst += "Naziv: "+rs.getString("naziv_plana")+"\t";
	  	  			tekst += "Cijena: "+rs.getString("cijena_plana")+"\t";
	  	  			tekst += "Broj polaznika: "+rs.getString("broj_polaznika")+"\n";
	  	  		}	
	  	  		
	  	  		
	  	  		conn.close();
		
			} catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(),"Greska",
			JOptionPane.ERROR_MESSAGE);

			}
		}
	}
