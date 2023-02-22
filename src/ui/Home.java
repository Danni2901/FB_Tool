package ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import auto.checkKey;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField keyvalue;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		checkKey ckey = new checkKey();
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					// Kiem tra phai lan dau nhap keys khong
					if (ckey.cUuid()) {

						  setting framesetting = new setting();
						  framesetting.setVisible(true);

					} else {
						Home frame = new Home();
						frame.setVisible(true);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 233);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JLabel lblNewLabel = new JLabel("Product Key");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 123, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, -120, SpringLayout.EAST, contentPane);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("SVN-A Love Of Thunder", Font.BOLD, 20));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Enter keys:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 71, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_1);

		keyvalue = new JTextField();

		keyvalue.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		keyvalue.setHorizontalAlignment(SwingConstants.CENTER);
		sl_contentPane.putConstraint(SpringLayout.NORTH, keyvalue, -3, SpringLayout.NORTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, keyvalue, 38, SpringLayout.EAST, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, keyvalue, -89, SpringLayout.EAST, contentPane);
		contentPane.add(keyvalue);
		keyvalue.setColumns(10);

		JButton submitbt = new JButton("Submit");
		sl_contentPane.putConstraint(SpringLayout.NORTH, submitbt, 31, SpringLayout.SOUTH, keyvalue);
		sl_contentPane.putConstraint(SpringLayout.EAST, submitbt, -168, SpringLayout.EAST, contentPane);
		submitbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkKey ckey = new checkKey();
				// Lay key nguoi dung nhap
				String vKey = keyvalue.getText();
				try {
					if(vKey.equals("")) {
						JOptionPane.showMessageDialog(null, "Key is null !");
					}else if(vKey.length() != 24) {
						JOptionPane.showMessageDialog(null, "Key must 24 character !");
					}else if (ckey.cKey(vKey)) {
						// display setting form
						try {
							setting framesetting = new setting();
							framesetting.setVisible(true);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "Key is valid !");
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(submitbt);
	}
}
