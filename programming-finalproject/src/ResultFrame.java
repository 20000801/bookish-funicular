import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.mysql.cj.xdevapi.Statement;

public class ResultFrame extends JFrame {
	private JTextArea text;
	private JTextField inputTextField;
	final int FRAME_WIDTH = 750;
	final int FRAME_HEIGHT = 450;
	final int FIELD_WIDTH = 10;
	final int AREA_WIDTH = 45;
	final int AREA_HEIGHT = 10;
	JTextArea firstArea;

	public ResultFrame() {
		setTitle("Lunch Date");
		add(createPanel());
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	public JPanel createPanel() {
		JPanel resultPanel = new JPanel();
		JLabel result = new JLabel("See the Result!     ");
		Image mm = new ImageIcon(this.getClass().getResource("/find.png")).getImage();
		JLabel aLabel = new JLabel();
		aLabel.setIcon(new ImageIcon(mm));
		result.setFont(new Font("DIALOG", Font.BOLD, 30));

		resultPanel.add(result);
		resultPanel.add(aLabel);
		JLabel firstLabel = new JLabel(" Suitable person: ");
		firstLabel.setFont(new Font("DIALOG", Font.PLAIN, 18));
		firstArea = new JTextArea(AREA_HEIGHT, AREA_WIDTH);
		firstArea.setEditable(false);
		JScrollPane scrollPane1 = new JScrollPane(firstArea);
		JButton backButton = new JButton("Back");
		JButton doneButton = new JButton("Done");
		JLabel contactLabel= new JLabel("Remember to contact one of the person! ");
		contactLabel.setFont(new Font("DIALOG", Font.BOLD, 25));
		contactLabel.setForeground(Color.blue);
		// JPanel inputPanel = new JPanel();
		// JLabel inputLabel = new JLabel(" 請輸入選擇的人的line ID: ");
		// inputTextField = new JTextField(FIELD_WIDTH);
		// inputPanel.add(inputLabel);
		// inputPanel.add(inputTextField);

		/*
		 * 
		 * class doneAction implements ActionListener { public void
		 * actionPerformed(ActionEvent event) { Scanner in = new
		 * Scanner(inputTextField.getText()); if (!in.hasNext()) { text = new
		 * JTextArea(); text.setEditable(false);
		 * text.setText("Please enter a person's line ID"); } else if (in.hasNext()) {
		 * try { Connection conn = Connect.getConnection(); java.sql.Statement stat =
		 * conn.createStatement();
		 * stat.execute("INSERT INTO MG04.mate(`Line_ID`) VALUES "+inputTextField.
		 * getText().toString()); } catch (SQLException e) { e.printStackTrace(); } }
		 * 
		 * }
		 * 
		 * }doneButton.addActionListener(new doneAction());
		 */

		class goAction implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				HomeFrame home = new HomeFrame();
				home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				home.setVisible(true);
				dispose();
			}
		}
		backButton.addActionListener(new goAction());

		class doneAction implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				dispose();
			}
		}
		doneButton.addActionListener(new doneAction());

		JPanel gridPanel = new JPanel();
		gridPanel.add(firstLabel);
		gridPanel.add(scrollPane1);
		gridPanel.add(contactLabel);
		// gridPanel.add(inputPanel);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(backButton);
		buttonPanel.add(doneButton);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(resultPanel, BorderLayout.NORTH);
		panel.add(gridPanel, BorderLayout.CENTER);
		panel.add(buttonPanel, BorderLayout.SOUTH);
		return panel;
	}

	public void textSet(String n) {
		firstArea.setText(n);
	}

}
