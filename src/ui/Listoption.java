package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Choice;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.*;

public class Listoption extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Listoption frame = new Listoption();
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
	public Listoption() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("Choice Option");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(153, 50, 126, 20);
		contentPane.add(lblNewLabel);
		
		Choice choice = new Choice();
		choice.setBounds(113, 103, 214, 30);
	
		contentPane.add(choice);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBounds(170, 154, 89, 23);
		contentPane.add(btnNewButton);
	}
}
