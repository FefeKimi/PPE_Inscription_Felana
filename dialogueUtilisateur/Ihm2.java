package dialogueUtilisateur;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.util.Properties;

import javax.swing.JLayeredPane;
import javax.swing.JList;

import net.miginfocom.swing.MigLayout;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.sun.org.apache.xerces.internal.util.DatatypeMessageFormatter;
import javax.swing.JToolBar;
import javax.swing.JEditorPane;

public class Ihm2 {

	private JFrame frame;
	private JTextField dateClot;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ihm2 window = new Ihm2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ihm2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		/*fenêtre*/
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 482, 426);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFefe = new JLabel("Menu ");
		lblFefe.setBounds(190, 11, 46, 14);
		frame.getContentPane().add(lblFefe);
		
		/*onglets*/
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 36, 425, 340);
		frame.getContentPane().add(tabbedPane);
		
		/*competition*/
		
		/*Equipes*/
		JLayeredPane equipes = new JLayeredPane();
		tabbedPane.addTab("Equipes", null, equipes, null);
		
		JLabel lblEquipes = new JLabel("Equipes");
		lblEquipes.setBounds(10, 11, 46, 14);
		equipes.add(lblEquipes);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(20, 36, 65, 20);
		equipes.add(comboBox_1);
		
		JButton button = new JButton("Modifier");
		button.setBounds(110, 35, 72, 23);
		equipes.add(button);
		
		JButton button_1 = new JButton("Supprimer");
		button_1.setBounds(185, 35, 89, 23);
		equipes.add(button_1);
		
		JLabel label = new JLabel("Participe \u00E0 :");
		label.setBounds(10, 88, 75, 14);
		equipes.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 113, 205, 182);
		equipes.add(panel_1);
		
		JLabel lblAjouterUnequipe = new JLabel("Ajouter une \u00E9quipe");
		lblAjouterUnequipe.setBounds(232, 88, 123, 14);
		equipes.add(lblAjouterUnequipe);
		
		JLabel label_1 = new JLabel("Nom");
		label_1.setBounds(232, 113, 31, 14);
		equipes.add(label_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(273, 110, 109, 20);
		equipes.add(textField_4);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(258, 150, 89, 23);
		equipes.add(btnAjouter);
		
		/*Personnes*/
		JLayeredPane personne = new JLayeredPane();
		tabbedPane.addTab("Personnes", null, personne, null);
		
		JLabel lblNewLabel = new JLabel("Personne");
		lblNewLabel.setBounds(10, 11, 46, 14);
		personne.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(20, 35, 65, 20);
		personne.add(comboBox);
		
		JButton btnNewButton = new JButton("Modifier");
		btnNewButton.setBounds(121, 34, 72, 23);
		personne.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Supprimer");
		btnNewButton_1.setBounds(203, 34, 89, 23);
		personne.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Ajouter une personne");
		lblNewLabel_1.setBounds(225, 80, 123, 14);
		personne.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(277, 101, 109, 20);
		personne.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Participe \u00E0 :");
		lblNewLabel_2.setBounds(10, 80, 75, 14);
		personne.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 101, 205, 182);
		personne.add(panel);
		
		JLabel lblNewLabel_4 = new JLabel("Nom");
		lblNewLabel_4.setBounds(225, 105, 31, 14);
		personne.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Pr\u00E9nom");
		lblNewLabel_5.setBounds(225, 143, 36, 14);
		personne.add(lblNewLabel_5);
		
		textField_1 = new JTextField();
		textField_1.setBounds(277, 140, 109, 20);
		personne.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(225, 189, 31, 14);
		personne.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setBounds(277, 186, 109, 20);
		personne.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Ajouter");
		btnNewButton_2.setBounds(259, 240, 89, 23);
		personne.add(btnNewButton_2);
		JLayeredPane competition = new JLayeredPane();
		tabbedPane.addTab("Competitions", null, competition, null);
		
		JLabel lblComptitions = new JLabel("Comp\u00E9titions");
		lblComptitions.setBounds(10, 11, 99, 14);
		competition.add(lblComptitions);
		
		JComboBox competitions = new JComboBox();
		competitions.setBounds(10, 36, 76, 20);
		competition.add(competitions);
		
		JButton btnModifierCompet= new JButton("Modifier");
		btnModifierCompet.setBounds(127, 35, 89, 23);
		competition.add(btnModifierCompet);
		
		JButton btnSupprimerCompet = new JButton("Supprimer");
		btnSupprimerCompet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSupprimerCompet.setBounds(235, 35, 89, 23);
		competition.add(btnSupprimerCompet);
		
		JLabel lblCrerUneComptition = new JLabel("Nouvelle comp\u00E9tition");
		lblCrerUneComptition.setBackground(Color.LIGHT_GRAY);
		lblCrerUneComptition.setBounds(199, 79, 166, 14);
		competition.add(lblCrerUneComptition);
		
		JLabel nomCompetlbl = new JLabel("Nom ");
		nomCompetlbl.setForeground(Color.DARK_GRAY);
		nomCompetlbl.setBounds(199, 107, 24, 14);
		competition.add(nomCompetlbl);
		
		JLabel dateClotlbl = new JLabel("Date de cl\u00F4ture");
		dateClotlbl.setForeground(Color.DARK_GRAY);
		dateClotlbl.setBounds(199, 151, 99, 14);
		competition.add(dateClotlbl);
		JDatePickerImpl datePicker_1 = new JDatePickerImpl(datePanel, null); 
		datePicker_1.setBackground(Color.WHITE);
		competition.add(datePicker_1);
		
	
		
		
		JPanel candidats = new JPanel();
		candidats.setBounds(10, 102, 166, 144);
		competition.add(candidats);
		
		JLabel enEquipelbl = new JLabel("En \u00E9quipe ?");
		enEquipelbl.setForeground(Color.DARK_GRAY);
		enEquipelbl.setBounds(199, 253, 64, 14);
		competition.add(enEquipelbl);
		
		JRadioButton rdbtnOui = new JRadioButton("Oui");
		rdbtnOui.setBackground(Color.WHITE);
		rdbtnOui.setForeground(Color.BLACK);
		rdbtnOui.setBounds(269, 249, 41, 23);
		competition.add(rdbtnOui);
		
		JRadioButton rdbtnNon = new JRadioButton("Non");
		rdbtnNon.setBackground(Color.WHITE);
		rdbtnNon.setForeground(Color.BLACK);
		rdbtnNon.setBounds(312, 249, 45, 23);
		competition.add(rdbtnNon);
		
		JLabel lblNewLabel_3 = new JLabel("Candidats :");
		lblNewLabel_3.setBounds(10, 79, 64, 14);
		competition.add(lblNewLabel_3);
		
		JButton btnNewButton_3 = new JButton("Ajouter");
		btnNewButton_3.setBounds(199, 278, 89, 23);
		competition.add(btnNewButton_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(235, 104, 86, 20);
		competition.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(209, 172, 46, 14);
		competition.add(lblNewLabel_6);
	}
}
