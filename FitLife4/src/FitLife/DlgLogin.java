package FitLife;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class DlgLogin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgLogin dialog = new DlgLogin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgLogin() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(141, 147, 113, 20);
		contentPanel.add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(141, 88, 113, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblKorisnickoIme = new JLabel("Korisnicko ime:");
		lblKorisnickoIme.setBounds(21, 91, 110, 14);
		contentPanel.add(lblKorisnickoIme);
		
		JLabel lblLozinka = new JLabel("Loinka:");
		lblLozinka.setBounds(21, 150, 87, 14);
		contentPanel.add(lblLozinka);
		
		JLabel lblFitlifeLogin = new JLabel("Fitlife Login");
		lblFitlifeLogin.setBounds(156, 11, 87, 14);
		contentPanel.add(lblFitlifeLogin);
		
		JButton btnNewPrijava = new JButton("Prijavi se");
		btnNewPrijava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin dlg = new Admin();
				dlg.setVisible(true);
			}
			
		});
		btnNewPrijava.setBounds(154, 194, 89, 23);
		contentPanel.add(btnNewPrijava);
		
		JLabel lblNewLabel = new JLabel("Administrator");
		lblNewLabel.setBounds(158, 63, 85, 14);
		contentPanel.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Korisnik");
				buttonPane.add(okButton);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DlgKorisnik dlg = new DlgKorisnik();
						dlg.setVisible(true);	
					}
				});
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
