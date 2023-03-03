package ui;

import java.awt.EventQueue;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import OpenAI.ChatCompletionExample;
import OpenAI.TextToSpeech;

import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.TextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Chatwithbot extends JFrame {

	private JPanel contentPane;
	private JTextField txtAsk;
	private JButton btnCopy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chatwithbot frame = new Chatwithbot();
					frame.setVisible(true);
					frame.setResizable(false);
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Chatwithbot() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 759, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtAsk = new JTextField();
		txtAsk.setBounds(10, 401, 414, 23);
		contentPane.add(txtAsk);
		txtAsk.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(220, 11, -208, 100);
		contentPane.add(scrollPane);
		
		TextArea textAreaAnswer = new TextArea();
		textAreaAnswer.setBounds(10, 34, 723, 361);
		textAreaAnswer.setEditable(false);
		contentPane.add(textAreaAnswer);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputString = txtAsk.getText();
				String regex = "[\";+()\\\\/]";

				if (inputString.matches(".*" + regex + ".*")) {
				    System.out.println("Input string contains special character.");
				    JOptionPane.showMessageDialog(null, "This Question contains special characters !");
				} else {
				    System.out.println("Input string does not contain any special character.");
					ChatCompletionExample chat = new ChatCompletionExample();
					String result = "";
					String raw = chat.OpenAI(txtAsk.getText()).toString();
					String[] words = raw.split(" ");
					for (int i = 0; i < words.length; i++) {
					     if (words[i].endsWith(".")) {
					         result += "\n" + words[i];
					     } else {
					         result += " " + words[i];
					     }
					 }
					 textAreaAnswer.setText(result);
					 
					 TextToSpeech tts = new TextToSpeech();
					 try {
						tts.Speech(result);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				txtAsk.setText("");
			}
		});
		btnSubmit.setBounds(434, 401, 89, 23);
		contentPane.add(btnSubmit);
		
		btnCopy = new JButton("Copyto clipboard ");
		btnCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 StringSelection stringSelection = new StringSelection(textAreaAnswer.getText());
					Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
					clipboard.setContents(stringSelection, null);
					JOptionPane.showMessageDialog(null, "Saved");
			}
		});
		btnCopy.setBounds(521, 401, 134, 23);
		contentPane.add(btnCopy);
		
		JLabel lblNewLabel = new JLabel("Ask With GPT Bot");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(192, 192, 192));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(172, 0, 438, 37);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaAnswer.setText("");
			}
		});
		btnNewButton.setBounds(654, 401, 79, 23);
		contentPane.add(btnNewButton);
	}
}
