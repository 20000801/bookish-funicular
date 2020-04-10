import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class frame extends JFrame {
	final int FRAME_WIDTH = 640;
	final int FRAME_HEIGHT = 380;
	final int FIELD_WIDTH = 10;
	final int AREA_WIDTH = 90;
	final int AREA_HEIGHT = 10;

	private JLabel accountLabel;
	private JLabel passwordLabel;
	private JTextField accountField;
	private JTextField passwordField;
	private JButton noBtn;
	private JButton goBtn;
	private JTextArea text;

	HomeFrame home = new HomeFrame();
	RegisterFrame register = new RegisterFrame();
	//ResultFrame result = new ResultFrame();

	public frame() {
		add(createMainPanel());
		setTitle("Lunch Date");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);

	}

	public JPanel createMainPanel() {
		JLabel lunch = new JLabel("Lunch  ");
		Image mm = new ImageIcon(this.getClass().getResource("/dish.png")).getImage();
		JLabel aLabel = new JLabel();
		aLabel.setIcon(new ImageIcon(mm));
		JLabel date = new JLabel("  Date");
		lunch.setFont(new Font("DIALOG", Font.BOLD, 50));
		date.setFont(new Font("DIALOG", Font.BOLD, 50));
		JPanel lunchPanel = new JPanel();
		lunchPanel.add(lunch);
		lunchPanel.add(aLabel);
		lunchPanel.add(date);
		accountLabel = new JLabel("account:");
		accountField = new JTextField(FIELD_WIDTH);
		passwordLabel = new JLabel("password:");
		passwordField = new JTextField(FIELD_WIDTH);
		noBtn = new JButton("create an account");
		goBtn = new JButton("GO");
		text = new JTextArea();
		text.setEditable(false);

		class goAction implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				Scanner in = new Scanner(accountField.getText());
			Scanner input = new Scanner(passwordField.getText());
			if (in.hasNext() && input.hasNext()) {
			in.close();
			input.close();
					dooo();

		} else if (in.hasNext() == false || input.hasNext() == false) {
					text.setText("Please enter password or accounts!" + '\n' + "Try again!" + '\n');

			}
			}
		}goBtn.addActionListener(new goAction());
		class noAction implements ActionListener {
			public void actionPerformed(ActionEvent event) {

				RegisterFrame register = new RegisterFrame();
				register.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				register.setVisible(true);
				dispose();
			}
		}
		noBtn.addActionListener(new noAction());

		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(2, 2));
		gridPanel.add(accountLabel);
		gridPanel.add(accountField);
		gridPanel.add(passwordLabel);
		gridPanel.add(passwordField);

		JPanel btnPanel = new JPanel();

		btnPanel.add(noBtn);
		btnPanel.add(goBtn);
		JPanel textpanel = new JPanel();
		textpanel.setLayout(new GridLayout(1 / 2, 1));
		textpanel.add(text);
		JPanel ppanel = new JPanel();
		ppanel.add(gridPanel);
		ppanel.add(textpanel);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(lunchPanel, BorderLayout.NORTH);
		panel.add(ppanel, BorderLayout.CENTER);
		panel.add(btnPanel, BorderLayout.SOUTH);

		return panel;
	}

	public void dooo() {
		try {
			check();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/**
	public void maching() {
		try {

			match();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	public String getAccName() {
		return this.accountField.getText();
	}

	public void check() throws SQLException {
		Connection conn = Connect.getConnection();
		String query = "SELECT `Password` FROM MG04.member WHERE `Account`=?";
		PreparedStatement accStatement = conn.prepareStatement(query);
		accStatement.setString(1, accountField.getText());
		ResultSet resultChoose = accStatement.executeQuery();
		//while (resultChoose.next()) {
		//if (resultChoose.getString("Account").equals(accountField.getText())&& resultChoose.getString("Password").equals(passwordField.getText())) {
			if (resultChoose.next()&&resultChoose.getString("Password").equals(passwordField.getText())) {
			HomeFrame home = new HomeFrame();
				home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				home.setVisible(true);
				dispose();

			} else {
				text.setText("Please enter correct password or accounts!" + '\n' + "Try again!" + '\n');
				accountField.setText("");
				passwordField.setText("");
			}
		//	break;
		
		conn.close();
	}
	/**
	public void match() throws SQLException {
		Connection conn = Connect.getConnection();
		String query = "SELECT `Name`, `Phone_number`, `Account`, `Password`, `Gender`, `Grade`, `Line_ID`, `Interest`, `Mon_Lunch`, `Mon_Dinner`, `Tue_Lunch`, `Tue_Dinner`, `Wed_Lunch`, `Wed_Dinner`, `Thu_Lunch`, `Thu_Dinner`, `Fri_Lunch`, `Fri_Dinner` FROM `member` WHERE `Account`= ?";
		PreparedStatement accStatement = conn.prepareStatement(query);
		accStatement.setString(1, accountField.getText());
		ResultSet resultChoose = accStatement.executeQuery();
		if (resultChoose.next()) {
			int mon1 = resultChoose.getInt("Mon_Lunch");
		}

		conn.close();
	}
	*/

}
