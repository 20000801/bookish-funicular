import java.awt.BorderLayout;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RegisterFrame extends JFrame {

	final int FRAME_WIDTH = 640;
	final int FRAME_HEIGHT = 660;
	final int FIELD_WIDTH = 10;
	final int AREA_WIDTH = 90;
	final int AREA_HEIGHT = 10;

	private JLabel accountLabel;
	private JLabel passwordLabel;
	private JTextField accountField;
	private JTextField passwordField;
	private JTextField nameTextField;
	private JTextField departmentTextField;
	private JTextField phoneTextField;
	private JTextField idTextField;

	private ButtonGroup groupInterest;
	private JCheckBox timeCheckBox11;
	private JCheckBox timeCheckBox21;
	private JCheckBox timeCheckBox31;
	private JCheckBox timeCheckBox41;
	private JCheckBox timeCheckBox51;

	private JTextField grade;
	private JRadioButton maleRadioButton;
	private JRadioButton femaleRadioButton;
	private JComboBox<String> Combo;
	private JComboBox<String> storeCombo;
	private JTextArea text;
	private JLabel idLabel;
	LogInFrame home = new LogInFrame();
	private JButton fin1Btn;

	public RegisterFrame() {
		// TODO Auto-generated constructor stub
		add(createPanel());
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setTitle("Lunch Date");

	}

	public JPanel createPanel() {
		JLabel imageLabel = new JLabel("   Register a new account!  ");
		imageLabel.setFont(new Font("DIALOG", Font.BOLD, 30));
		Image mm = new ImageIcon(this.getClass().getResource("/dinner.png")).getImage();
		JLabel aLabel = new JLabel();
		aLabel.setIcon(new ImageIcon(mm));
		JPanel imagePanel = new JPanel();
		imagePanel.add(aLabel);
		imagePanel.add(imageLabel);
		JPanel accPanel = new JPanel();
		accountLabel = new JLabel("Account: ");
		accountField = new JTextField(FIELD_WIDTH);
		accPanel.add(accountLabel);
		accPanel.add(accountField);

		JPanel passwordPanel = new JPanel();
		passwordLabel = new JLabel("Password: ");
		passwordField = new JTextField(FIELD_WIDTH);
		passwordPanel.add(passwordLabel);
		passwordPanel.add(passwordField);

		JPanel namePanel = new JPanel();
		JLabel nameLabel = new JLabel("Name: ");
		nameTextField = new JTextField(FIELD_WIDTH);
		namePanel.add(nameLabel);
		namePanel.add(nameTextField);

		JPanel genderPanel = new JPanel();
		JLabel genderLabel = new JLabel("Gender: ");
		maleRadioButton = new JRadioButton("Male");
		femaleRadioButton = new JRadioButton("Female");
		ButtonGroup groupGender = new ButtonGroup();// 為何不能直接add group，因為不然的話會不知道那些是同一群radiobutton(有太多群了)，group表示單選
		groupGender.add(maleRadioButton);
		groupGender.add(femaleRadioButton);
		genderPanel.add(genderLabel);
		JPanel genderPanel1 = new JPanel();
		genderPanel1.setLayout(new GridLayout(1, 2));
		genderPanel1.add(maleRadioButton);
		genderPanel1.add(femaleRadioButton);
		genderPanel.add(genderPanel1);

		JPanel departmentPanel = new JPanel();
		JLabel departmentLabel = new JLabel("Department: ");
		departmentTextField = new JTextField(FIELD_WIDTH);
		departmentPanel.add(departmentLabel);
		departmentPanel.add(departmentTextField);

		JPanel gradePanel = new JPanel();
		JLabel gradeLabel = new JLabel("Grade: ");
		grade = new JTextField(FIELD_WIDTH);

		gradePanel.add(gradeLabel);
		gradePanel.add(grade);

		JPanel phonePanel = new JPanel();
		JLabel phoneLabel = new JLabel("Phone: ");
		phoneTextField = new JTextField(FIELD_WIDTH);
		phonePanel.add(phoneLabel);
		phonePanel.add(phoneTextField);

		JPanel idPanel = new JPanel();
		idLabel = new JLabel("FB / Line ID :");
		idTextField = new JTextField(FIELD_WIDTH);
		idPanel.add(idLabel);
		idPanel.add(idTextField);

		JPanel timePanel = new JPanel();
		JLabel timelLabel = new JLabel("Available time: ");
		timeCheckBox11 = new JCheckBox("mon_lunch");
		timeCheckBox21 = new JCheckBox("tue_lunch");
		timeCheckBox31 = new JCheckBox("wed_lunch");
		timeCheckBox41 = new JCheckBox("thu_lunch");
		timeCheckBox51 = new JCheckBox("fri_lunch");
		timePanel.add(timelLabel);
		JPanel timePanel1 = new JPanel();
		timePanel1.setLayout(new GridLayout(1, 5));
		timePanel1.add(timeCheckBox11);
		timePanel1.add(timeCheckBox21);
		timePanel1.add(timeCheckBox31);
		timePanel1.add(timeCheckBox41);
		timePanel1.add(timeCheckBox51);
		timePanel.add(timePanel1);

		JPanel interestPanel = new JPanel();
		JLabel interestLabel = new JLabel("Interest: ");
		Combo = new JComboBox<String>();
		Combo.addItem("Sports");
		Combo.addItem("Art");
		Combo.addItem("Music");
		Combo.addItem("Reading");
		Combo.addItem("Online game");
		Combo.addItem("Sleep");
		Combo.addItem("Movies");
		Combo.addItem("Other");

		interestPanel.add(interestLabel);
		interestPanel.add(Combo);

		JPanel storePanel = new JPanel();
		JLabel storeLabel = new JLabel("Restaurant: ");
		storeCombo = new JComboBox<String>();
		storePanel.add(storeLabel);
		storePanel.add(storeCombo);
		storeCombo.addItem("Japaneses food");
		storeCombo.addItem("Korean food");
		storeCombo.addItem("Chinese food");
		storeCombo.addItem("Italian food");
		storeCombo.addItem("Thai food");
		storeCombo.addItem("Juicy Bun");
		storeCombo.addItem("Macdonolds");
		storeCombo.addItem("mos burger");
		storeCombo.addItem("urban monsters");
		storeCombo.addItem("popochiachia");

		storeCombo.setEditable(true);

		fin1Btn = new JButton("DONE");
		text = new JTextArea();
		text.setEditable(false);

		class finAction implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				Scanner in_1 = new Scanner(accountField.getText());
				Scanner in_2 = new Scanner(passwordField.getText());
				Scanner in_3 = new Scanner(nameTextField.getText());
				Scanner in_4 = new Scanner(phoneTextField.getText());
				Scanner in_5 = new Scanner(idTextField.getText());
				Scanner in_6 = new Scanner(grade.getText());
				Scanner in_7 = new Scanner(departmentTextField.getText());
				if (in_1.hasNext() && in_2.hasNext() && in_3.hasNext() && in_4.hasNext() && in_5.hasNext()
						&& in_6.hasNext() && in_7.hasNext()) {
					in_1.close();
					in_2.close();
					in_3.close();
					in_4.close();
					in_5.close();
					in_6.close();
					in_7.close();
					doooing();
				} else if (in_1.hasNext() == false || in_2.hasNext() == false || in_3.hasNext() == false
						|| in_4.hasNext() == false || in_5.hasNext() == false || in_6.hasNext() == false
						|| in_7.hasNext() == false) {
					{
						TryAgainFrame frame = new TryAgainFrame();
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setVisible(true);
						dispose();
					}
				}
			}
		}
		fin1Btn.addActionListener(new finAction());

		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(11, 1));
		gridPanel.add(accPanel);
		gridPanel.add(passwordPanel);
		gridPanel.add(namePanel);
		gridPanel.add(genderPanel);
		gridPanel.add(departmentPanel);
		gridPanel.add(gradePanel);
		gridPanel.add(phonePanel);
		gridPanel.add(idPanel);
		gridPanel.add(timePanel);
		gridPanel.add(interestPanel);
		gridPanel.add(storePanel);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(imagePanel, BorderLayout.NORTH);
		panel.add(gridPanel);
		JPanel aJPanel = new JPanel();
		aJPanel.add(fin1Btn);
		panel.add(aJPanel, BorderLayout.SOUTH);

		return panel;
	}

	public void create() throws SQLException {
		Connection conn = Connect.getConnection();
		String query = "INSERT INTO MG04.member(`Name`,`Phone_number`,`Account`,`Password`,`Gender`,`Department`,`Grade`,`Line_ID`,`Interest`,`Restaurant`,`Mon_Lunch`,`Tue_Lunch`,`Wed_Lunch`,`Thu_Lunch`,`Fri_Lunch`)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(query);

		pst.setString(1, nameTextField.getText());
		pst.setString(2, phoneTextField.getText());
		pst.setString(3, accountField.getText());
		pst.setString(4, passwordField.getText());
		pst.setString(5, maleRadioButton.isSelected() ? "Male" : "Female");
		pst.setString(6, departmentTextField.getText());
		pst.setInt(7, Integer.parseInt(grade.getText()));
		pst.setString(8, idTextField.getText());
		pst.setString(9, Combo.getSelectedItem().toString());
		pst.setString(10, storeCombo.getSelectedItem().toString());
		pst.setString(11, timeCheckBox11.isSelected() ? "1" : "0");
		pst.setString(12, timeCheckBox21.isSelected() ? "1" : "0");
		pst.setString(13, timeCheckBox31.isSelected() ? "1" : "0");
		pst.setString(14, timeCheckBox41.isSelected() ? "1" : "0");
		pst.setString(15, timeCheckBox51.isSelected() ? "1" : "0");
		int resultSet = pst.executeUpdate();
		conn.close();

	}

	public void doooing() {
		try {
			create();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		LogInFrame frame = new LogInFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		dispose();
	}

}
