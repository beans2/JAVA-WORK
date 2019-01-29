package admin.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import javax.swing.JProgressBar;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class test extends JFrame {

	private JPanel pane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
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
	public test() {
		getContentPane().setEnabled(false);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.PINK);
		setTitle("1949-\uB85C\uADF8\uC778");
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\uC544\uC774\uB514");
		label.setBounds(27, 200, 40, 30);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(91, 200, 232, 30);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label_1.setBounds(27, 250, 50, 30);
		getContentPane().add(label_1);
		
		JButton btnNewButton = new JButton("\uB85C\uADF8\uC778");
		btnNewButton.setBounds(335, 200, 94, 79);
		getContentPane().add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(91, 250, 232, 30);
		getContentPane().add(textField_1);
		
		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(221, 309, 50, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uBE44\uBC00\uBC88\uD638\uAC00 \uAE30\uC5B5\uB098\uC9C0 \uC54A\uC73C\uC138\uC694?");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBounds(168, 330, 180, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\owner\\Desktop\\\uC640\uC6B0\uCC21\uAE0B.gif"));
		lblNewLabel_2.setBounds(27, 10, 344, 177);
		getContentPane().add(lblNewLabel_2);


	}
}
