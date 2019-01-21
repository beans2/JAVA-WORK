import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;

public class FrameTest extends JFrame {
	private JTextField textField;
	private JTextField textField_1;

	public FrameTest() {
		getContentPane().setBackground(Color.GRAY);
		getContentPane().setLayout(null);
		
		JLabel jlbId = new JLabel("ID");
		jlbId.setForeground(Color.WHITE);
		jlbId.setFont(new Font("Dialog", Font.BOLD, 15));
		jlbId.setBounds(92, 101, 21, 30);
		getContentPane().add(jlbId);
		
		JLabel lblPass = new JLabel("Pass");
		lblPass.setForeground(Color.WHITE);
		lblPass.setFont(new Font("Dialog", Font.BOLD, 15));
		lblPass.setBounds(91, 173, 40, 30);
		getContentPane().add(lblPass);
		
		textField = new JTextField();
		textField.setBounds(143, 92, 186, 51);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(143, 164, 186, 51);
		getContentPane().add(textField_1);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 23));
		lblNewLabel.setBounds(198, 32, 82, 35);
		getContentPane().add(lblNewLabel);
		
	}
}
