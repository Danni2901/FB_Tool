package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import auto.comment;
import auto.test;

public class setting extends JFrame {

	private JPanel settingpanel;
	private JTextField fname;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField fidgroup;
	private JPasswordField fword;
	private JTextArea taCmt;
	private JTextField fcomment;
	private JComboBox numPost;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public setting() {
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 506);
		settingpanel = new JPanel();
		settingpanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(settingpanel);
		SpringLayout sl_settingpanel = new SpringLayout();
		settingpanel.setLayout(sl_settingpanel);

		JLabel lblNewLabel = new JLabel("Group Control ");
		sl_settingpanel.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, settingpanel);
		sl_settingpanel.putConstraint(SpringLayout.EAST, lblNewLabel, -138, SpringLayout.EAST, settingpanel);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		settingpanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Account Facebook :");
		settingpanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Password :");
		sl_settingpanel.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 17, SpringLayout.SOUTH, lblNewLabel_1);
		sl_settingpanel.putConstraint(SpringLayout.EAST, lblNewLabel_2, 0, SpringLayout.EAST, lblNewLabel_1);
		settingpanel.add(lblNewLabel_2);

		fname = new JTextField();
		sl_settingpanel.putConstraint(SpringLayout.WEST, fname, 171, SpringLayout.WEST, settingpanel);
		sl_settingpanel.putConstraint(SpringLayout.EAST, lblNewLabel_1, -6, SpringLayout.WEST, fname);
		sl_settingpanel.putConstraint(SpringLayout.EAST, fname, -107, SpringLayout.EAST, settingpanel);
		sl_settingpanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 5, SpringLayout.NORTH, fname);
		sl_settingpanel.putConstraint(SpringLayout.NORTH, fname, 6, SpringLayout.SOUTH, lblNewLabel);
		settingpanel.add(fname);
		fname.setColumns(10);

		fidgroup = new JTextField();
		sl_settingpanel.putConstraint(SpringLayout.NORTH, fidgroup, 105, SpringLayout.NORTH, settingpanel);
		sl_settingpanel.putConstraint(SpringLayout.WEST, fidgroup, 0, SpringLayout.WEST, fname);
		sl_settingpanel.putConstraint(SpringLayout.EAST, fidgroup, -107, SpringLayout.EAST, settingpanel);
		settingpanel.add(fidgroup);
		fidgroup.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("ID Group :");
		sl_settingpanel.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 3, SpringLayout.NORTH, fidgroup);
		sl_settingpanel.putConstraint(SpringLayout.EAST, lblNewLabel_3, 0, SpringLayout.EAST, lblNewLabel_1);
		settingpanel.add(lblNewLabel_3);

		fword = new JPasswordField();
		sl_settingpanel.putConstraint(SpringLayout.SOUTH, fword, 0, SpringLayout.SOUTH, lblNewLabel_2);
		fword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				fword.setText("");
			}
		});
		sl_settingpanel.putConstraint(SpringLayout.NORTH, fword, 9, SpringLayout.SOUTH, fname);
		sl_settingpanel.putConstraint(SpringLayout.WEST, fword, 171, SpringLayout.WEST, settingpanel);
		sl_settingpanel.putConstraint(SpringLayout.EAST, fword, -107, SpringLayout.EAST, settingpanel);
		settingpanel.add(fword);

		JRadioButton btcomment = new JRadioButton("Auto comment group");
		sl_settingpanel.putConstraint(SpringLayout.EAST, btcomment, 0, SpringLayout.EAST, lblNewLabel);
		settingpanel.add(btcomment);

		JRadioButton btaddfriend = new JRadioButton("Auto addfriend group");
		sl_settingpanel.putConstraint(SpringLayout.EAST, btaddfriend, -137, SpringLayout.EAST, settingpanel);
		settingpanel.add(btaddfriend);

		JLabel lblNewLabel_4 = new JLabel("Quantity Addfriend :");
		settingpanel.add(lblNewLabel_4);

		JComboBox nummem = new JComboBox();
		sl_settingpanel.putConstraint(SpringLayout.EAST, lblNewLabel_4, -17, SpringLayout.WEST, nummem);
		sl_settingpanel.putConstraint(SpringLayout.SOUTH, btaddfriend, -13, SpringLayout.NORTH, nummem);
		sl_settingpanel.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 4, SpringLayout.NORTH, nummem);
		sl_settingpanel.putConstraint(SpringLayout.WEST, nummem, 243, SpringLayout.WEST, settingpanel);
		sl_settingpanel.putConstraint(SpringLayout.EAST, nummem, 0, SpringLayout.EAST, fname);
		nummem.setModel(new DefaultComboBoxModel(new String[] {"30", "60", "90", "120", "240", "480", "960", "1290", "3840", "7680"}));
		nummem.setSelectedIndex(1);
		settingpanel.add(nummem);

		JComboBox delay = new JComboBox();
		sl_settingpanel.putConstraint(SpringLayout.NORTH, delay, 217, SpringLayout.NORTH, settingpanel);
		sl_settingpanel.putConstraint(SpringLayout.EAST, delay, -107, SpringLayout.EAST, settingpanel);
		sl_settingpanel.putConstraint(SpringLayout.SOUTH, nummem, -6, SpringLayout.NORTH, delay);
		delay.setModel(new DefaultComboBoxModel(new String[] {"1", "3", "5", "10", "20", "30", "60", "120", "480", "960"}));
		delay.setSelectedIndex(1);
		settingpanel.add(delay);

		JLabel lblNewLabel_7 = new JLabel("Comment content:");
		sl_settingpanel.putConstraint(SpringLayout.EAST, lblNewLabel_7, -315, SpringLayout.EAST, settingpanel);
		settingpanel.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("(Each comment is separated by a \"/\")");
		sl_settingpanel.putConstraint(SpringLayout.NORTH, lblNewLabel_8, 6, SpringLayout.SOUTH, lblNewLabel_7);
		settingpanel.add(lblNewLabel_8);

		fcomment = new JTextField();
		sl_settingpanel.putConstraint(SpringLayout.NORTH, fcomment, -5, SpringLayout.NORTH, lblNewLabel_7);
		sl_settingpanel.putConstraint(SpringLayout.WEST, fcomment, 0, SpringLayout.WEST, btcomment);
		settingpanel.add(fcomment);
		fcomment.setColumns(10);

		JComboBox numPost = new JComboBox();
		sl_settingpanel.putConstraint(SpringLayout.NORTH, numPost, 6, SpringLayout.SOUTH, lblNewLabel_8);
		sl_settingpanel.putConstraint(SpringLayout.WEST, numPost, 212, SpringLayout.WEST, settingpanel);
		sl_settingpanel.putConstraint(SpringLayout.EAST, numPost, -7, SpringLayout.EAST, lblNewLabel);
		numPost.setModel(new DefaultComboBoxModel(new String[] {"7", "14", "21", "28", "35", "42", "49", "56", "63", "70"}));
		settingpanel.add(numPost);

		JLabel lblNewLabel_5 = new JLabel("Delay Steps ( S ):");
		sl_settingpanel.putConstraint(SpringLayout.WEST, lblNewLabel_8, 0, SpringLayout.WEST, lblNewLabel_5);
		sl_settingpanel.putConstraint(SpringLayout.WEST, delay, 17, SpringLayout.EAST, lblNewLabel_5);
		sl_settingpanel.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 4, SpringLayout.NORTH, delay);
		sl_settingpanel.putConstraint(SpringLayout.EAST, lblNewLabel_5, 0, SpringLayout.EAST, lblNewLabel_4);
		settingpanel.add(lblNewLabel_5);

		JLabel lblNewLabel_9 = new JLabel("Number post :");
		sl_settingpanel.putConstraint(SpringLayout.NORTH, lblNewLabel_9, 10, SpringLayout.SOUTH, lblNewLabel_8);
		sl_settingpanel.putConstraint(SpringLayout.EAST, lblNewLabel_9, -46, SpringLayout.WEST, numPost);
		settingpanel.add(lblNewLabel_9);

		JLabel lblNewLabel_6 = new JLabel("_____________________________________________");
		sl_settingpanel.putConstraint(SpringLayout.EAST, fcomment, 56, SpringLayout.EAST, lblNewLabel_6);
		sl_settingpanel.putConstraint(SpringLayout.NORTH, lblNewLabel_7, 40, SpringLayout.SOUTH, lblNewLabel_6);
		sl_settingpanel.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 4, SpringLayout.SOUTH, delay);
		sl_settingpanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_6, -185, SpringLayout.SOUTH, settingpanel);
		sl_settingpanel.putConstraint(SpringLayout.NORTH, btcomment, 6, SpringLayout.SOUTH, lblNewLabel_6);
		sl_settingpanel.putConstraint(SpringLayout.EAST, lblNewLabel_6, -61, SpringLayout.EAST, settingpanel);
		settingpanel.add(lblNewLabel_6);

		JComboBox delaycmt = new JComboBox();
		sl_settingpanel.putConstraint(SpringLayout.NORTH, delaycmt, 34, SpringLayout.SOUTH, lblNewLabel_8);
		sl_settingpanel.putConstraint(SpringLayout.EAST, delaycmt, -138, SpringLayout.EAST, settingpanel);
		delaycmt.setModel(new DefaultComboBoxModel(new String[] {"1", "3", "5", "10", "30", "60", "120", "480", "960"}));
		delaycmt.setSelectedIndex(2);
		settingpanel.add(delaycmt);

		JLabel lblNewLabel_10 = new JLabel("Delay Steps (S) :");
		sl_settingpanel.putConstraint(SpringLayout.EAST, lblNewLabel_10, -241, SpringLayout.EAST, settingpanel);
		sl_settingpanel.putConstraint(SpringLayout.WEST, delaycmt, 6, SpringLayout.EAST, lblNewLabel_10);
		sl_settingpanel.putConstraint(SpringLayout.NORTH, lblNewLabel_10, 4, SpringLayout.NORTH, delaycmt);
		settingpanel.add(lblNewLabel_10);

		JButton btstart = new JButton("Start");
		sl_settingpanel.putConstraint(SpringLayout.WEST, btstart, 160, SpringLayout.WEST, settingpanel);
		sl_settingpanel.putConstraint(SpringLayout.SOUTH, btstart, -1, SpringLayout.SOUTH, settingpanel);
		sl_settingpanel.putConstraint(SpringLayout.EAST, btstart, 264, SpringLayout.WEST, settingpanel);
		btstart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// get value from swings
				String numP = numPost.getSelectedItem().toString();
				String funame = fname.getText();
				String fpword = fword.getText();
				String fid = fidgroup.getText();
				String numem = nummem.getSelectedItem().toString();
				String delaytime = delay.getSelectedItem().toString();
				String timecmt = delaycmt.getSelectedItem().toString();
				String cMent = fcomment.getText();
				// check null
				if (funame.equals("") || fpword.equals("")) {
					JOptionPane.showMessageDialog(null, "User and Password is not null !");
				} else if (fid.equals("")) {
					JOptionPane.showMessageDialog(null, "Id Group is not null !");
				} else if (btcomment.isSelected()) {

						if(fcomment.getText().equals(""))
						{
							JOptionPane.showMessageDialog(null, "Comment content is not null !");

						}else {

								//display comment panel
								try {
									comment.main(funame, fpword, fid, timecmt, cMent, numP);
								} catch (Exception e1) {
									System.out.println(e1.toString());
									JOptionPane.showMessageDialog(null, "Browser Closed !");
								}

						}

				} else if (btaddfriend.isSelected()) {
							//display add friend panel
							try {
								test.main(funame, fpword, fid, numem, delaytime);
							} catch (Exception e2) {
								System.out.println(e2.toString());
								JOptionPane.showMessageDialog(null, "Browser Closed !");
							}

				} else {
					JOptionPane.showMessageDialog(null, "Please choice action !");
				}
			}
		});
		settingpanel.add(btstart);


	}
}
