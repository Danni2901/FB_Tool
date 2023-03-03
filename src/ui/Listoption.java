package ui;

import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;

public class Listoption extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
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
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
		choice.add("Comment in group By ID");
		choice.add("Chat With GPT Bot");
	
		contentPane.add(choice);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (choice.getSelectedIndex()) {
			    case 0:
			        // xử lý lựa chọn 1
			    	setting st = new setting();
			    	st.setVisible(true);
			        break;
			    case 1:
			    	// xử lý lựa chọn 2
			        Chatwithbot chat = new Chatwithbot();
			        chat.setVisible(true);
			        break;
			    case 2:
			        // xử lý lựa chọn 3
			        break;
			    case 3:
			        // xử lý lựa chọn 4
			        break;
			    case 4:
			        // xử lý lựa chọn 5
			        break;
			    default:
			        // xử lý trường hợp không hợp lệ
			        break;
			}
				
			}
		});
		btnNewButton.setBounds(170, 154, 89, 23);
		contentPane.add(btnNewButton);
	}
}
