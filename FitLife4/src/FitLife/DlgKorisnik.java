package FitLife;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class DlgKorisnik extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgKorisnik dialog = new DlgKorisnik();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgKorisnik() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnPregledTrenera = new JButton("Pregled Trenera");
			btnPregledTrenera.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DlgPregledTrenera dlg = new DlgPregledTrenera();
					dlg.setVisible(true);
				}
			});
			btnPregledTrenera.setBounds(37, 97, 149, 46);
			contentPanel.add(btnPregledTrenera);
		}
		{
			JButton btnPregledPlanova = new JButton("Pregled Planova");
			btnPregledPlanova.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DlgPregledPlana dlg = new DlgPregledPlana();
					dlg.setVisible(true);
				}
			});
			btnPregledPlanova.setBounds(236, 97, 149, 46);
			contentPanel.add(btnPregledPlanova);
		}
		{
			JLabel lblDobrodisli = new JLabel("Dobrodo\u0161li u FitLife");
			lblDobrodisli.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblDobrodisli.setBounds(107, 11, 226, 56);
			contentPanel.add(lblDobrodisli);
		}
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
	}

}
