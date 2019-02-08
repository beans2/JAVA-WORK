package admin.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JRadioButton;

public class testUser extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			testUser dialog = new testUser();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public testUser() {
		setTitle("\uD68C\uC6D0\uAC00\uC785");
		setBounds(100, 100, 390, 744);
		getContentPane().setLayout(null);
		{
			JLabel label = new JLabel("\uC544\uC774\uB514");
			label.setBounds(32, 105, 80, 30);
			getContentPane().add(label);
		}
		{
			JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638");
			label.setBounds(32, 145, 80, 30);
			getContentPane().add(label);
		}
		{
			JLabel label = new JLabel("\uC774\uB984");
			label.setBounds(32, 226, 80, 30);
			getContentPane().add(label);
		}
		{
			JLabel label = new JLabel("\uC8FC\uBBFC\uBC88\uD638");
			label.setHorizontalAlignment(SwingConstants.LEFT);
			label.setBounds(32, 266, 80, 30);
			getContentPane().add(label);
		}
		{
			JLabel label = new JLabel("\uC5F0\uB77D\uCC98");
			label.setHorizontalAlignment(SwingConstants.LEFT);
			label.setBounds(32, 306, 80, 30);
			getContentPane().add(label);
		}
		{
			JLabel label = new JLabel("\uC8FC\uC18C");
			label.setHorizontalAlignment(SwingConstants.LEFT);
			label.setBounds(31, 388, 80, 30);
			getContentPane().add(label);
		}
		{
			JLabel label = new JLabel("\uC0C1\uC138\uC8FC\uC18C");
			label.setHorizontalAlignment(SwingConstants.LEFT);
			label.setBounds(30, 468, 80, 30);
			getContentPane().add(label);
		}
		{
			JLabel label = new JLabel("\uC774\uBA54\uC77C");
			label.setHorizontalAlignment(SwingConstants.LEFT);
			label.setBounds(31, 347, 80, 30);
			getContentPane().add(label);
		}
		{
			JLabel label = new JLabel("\uC778\uC99D\uC9C8\uBB38");
			label.setHorizontalAlignment(SwingConstants.LEFT);
			label.setBounds(31, 509, 80, 30);
			getContentPane().add(label);
		}
		{
			JLabel label = new JLabel("\uC9C8\uBB38\uB2F5");
			label.setHorizontalAlignment(SwingConstants.LEFT);
			label.setBounds(31, 548, 80, 30);
			getContentPane().add(label);
		}
		
		textField = new JTextField();
		textField.setBounds(123, 106, 200, 30);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(123, 146, 200, 30);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(123, 227, 200, 30);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(123, 267, 92, 30);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(231, 267, 92, 30);
		getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(123, 307, 200, 30);
		getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(123, 389, 102, 30);
		getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(123, 429, 200, 30);
		getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(123, 469, 200, 30);
		getContentPane().add(textField_8);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(123, 509, 200, 30);
		getContentPane().add(comboBox);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(123, 348, 200, 30);
		getContentPane().add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(123, 549, 200, 30);
		getContentPane().add(textField_10);
		
		JButton btnNewButton = new JButton("\uC8FC\uC18C\uAC80\uC0C9");
		btnNewButton.setBounds(231, 389, 92, 30);
		getContentPane().add(btnNewButton);
		
		JButton button_1 = new JButton("\uD68C\uC6D0\uAC00\uC785");
		button_1.setBounds(98, 625, 92, 30);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\uCDE8\uC18C");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setBounds(213, 625, 92, 30);
		getContentPane().add(button_2);
		
		JLabel slash = new JLabel("/");
		slash.setHorizontalAlignment(SwingConstants.LEFT);
		slash.setBounds(219, 267, 16, 30);
		getContentPane().add(slash);
		
		JLabel label = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		label.setFont(new Font("±¼¸²", Font.PLAIN, 25));
		label.setBounds(144, 20, 110, 50);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		label_1.setBounds(32, 186, 80, 30);
		getContentPane().add(label_1);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(123, 187, 200, 30);
		getContentPane().add(textField_11);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\uC77C\uBC18\uC0AC\uC6A9\uC790");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(69, 76, 121, 23);
		getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton radioButton = new JRadioButton("\uAE30\uC5C5\uC0AC\uC6A9\uC790");
		radioButton.setBounds(202, 76, 121, 23);
		getContentPane().add(radioButton);
	}
}
