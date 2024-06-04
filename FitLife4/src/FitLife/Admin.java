package FitLife;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Admin dialog = new Admin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Admin() {
		setTitle("Main ");
		setBounds(100, 100, 545, 440);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 1);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JButton btnUnosClana = new JButton("Unos clana");
			btnUnosClana.setBounds(167, 10, 99, 25);
			btnUnosClana.setFont(new Font("Tahoma", Font.PLAIN, 14));
			contentPanel.add(btnUnosClana);
		}
		{
			JButton btnUnosClana = new JButton("Unos clana");
			btnUnosClana.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DlgUnosClana dlg = new DlgUnosClana();
					dlg.setVisible(true);
				}
			});
			btnUnosClana.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnUnosClana.setBounds(43, 59, 145, 67);
			getContentPane().add(btnUnosClana);
		}
		{
			JButton btnUnosTrenera = new JButton("Unos trenera");
			btnUnosTrenera.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DlgUnosTrenera dlg = new DlgUnosTrenera();
					dlg.setVisible(true);
				}
			});
			btnUnosTrenera.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnUnosTrenera.setBounds(43, 177, 145, 67);
			getContentPane().add(btnUnosTrenera);
		}
		{
			JButton btnUnosPlanova = new JButton("Unos planova");
			btnUnosPlanova.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DlgUnosPlanova dlg = new DlgUnosPlanova();
					dlg.setVisible(true);
				}
			});
			btnUnosPlanova.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnUnosPlanova.setBounds(43, 285, 145, 67);
			getContentPane().add(btnUnosPlanova);
		}
		{
			JButton btnPrikazClanova = new JButton("Prikaz clanova");
			btnPrikazClanova.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DlgPregledClana dlg = new DlgPregledClana();
					dlg.setVisible(true);
				}
			});
			btnPrikazClanova.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnPrikazClanova.setBounds(318, 59, 145, 67);
			getContentPane().add(btnPrikazClanova);
		}
		{
			JButton btnPrikazTrenera = new JButton("Prikaz trenera");
			btnPrikazTrenera.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DlgPregledTrenera dlg = new DlgPregledTrenera();
					dlg.setVisible(true);
				}
			});
			btnPrikazTrenera.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnPrikazTrenera.setBounds(318, 177, 145, 67);
			getContentPane().add(btnPrikazTrenera);
		}
		{
			JButton btnPrikazPlanova = new JButton("PrikazPlanova");
			btnPrikazPlanova.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DlgPregledPlana dlg = new DlgPregledPlana();
					dlg.setVisible(true);
				}
			});
			btnPrikazPlanova.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnPrikazPlanova.setBounds(318, 285, 145, 67);
			getContentPane().add(btnPrikazPlanova);
		}
	}
}
