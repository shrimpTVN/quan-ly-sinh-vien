package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;

public class AboutMeView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public AboutMeView() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
		this.setTitle("About Me!");
		this.setSize(600,450);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrTnVnTm = new JTextArea();
		txtrTnVnTm.setBackground(new Color(192, 192, 192));
		txtrTnVnTm.setForeground(new Color(255, 255, 0));
		txtrTnVnTm.setFont(new Font("Monospaced", Font.PLAIN, 20));
		txtrTnVnTm.setText("      Văn Tôm - CTUer\n"
				+ "Sinh viên ngành kỹ thuật phần mềm k49 \n"
				+ "Software Engeneer (Thời gian tới)");
		txtrTnVnTm.setBounds(69, 105, 461, 91);
		contentPane.add(txtrTnVnTm);
		this.setVisible(true);
	}
}
