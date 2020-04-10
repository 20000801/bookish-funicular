import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class HomeFrame extends JFrame {

	final int FRAME_WIDTH = 640;
	final int FRAME_HEIGHT = 380;
	final int FIELD_WIDTH = 10;
	final int AREA_WIDTH = 90;
	final int AREA_HEIGHT = 10;
	JRadioButton timeCheckBox11 = new JRadioButton("mon_lunch");
	JRadioButton timeCheckBox21 = new JRadioButton("tue_lunch");
	JRadioButton timeCheckBox31 = new JRadioButton("wed_lunch");
	JRadioButton timeCheckBox41 = new JRadioButton("thu_lunch");
	JRadioButton timeCheckBox51 = new JRadioButton("fri_lunch");
	JTextArea text = new JTextArea();

	RegisterFrame register = new RegisterFrame();
	JButton goBtn = new JButton("GO");
	ResultFrame result = new ResultFrame();

	public HomeFrame() {
		setTitle("Lunch Date");
		add(createPanel());
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	public JPanel createPanel() {
		JPanel imagePanel1 = new JPanel();
		JPanel imagePanel2 = new JPanel();
		JLabel bLabel = new JLabel(" Choose a time!  ");
		Image mm = new ImageIcon(this.getClass().getResource("/clock.png")).getImage();
		JLabel aLabel = new JLabel();
		aLabel.setIcon(new ImageIcon(mm));
		bLabel.setFont(new Font("DIALOG", Font.BOLD, 30));
		imagePanel1.add(aLabel);
		imagePanel2.add(bLabel);

		JRadioButton timeCheckBox11 = new JRadioButton("mon_lunch");
		JRadioButton timeCheckBox21 = new JRadioButton("tue_lunch");
		JRadioButton timeCheckBox31 = new JRadioButton("wed_lunch");
		JRadioButton timeCheckBox41 = new JRadioButton("thu_lunch");
		JRadioButton timeCheckBox51 = new JRadioButton("fri_lunch");
		JButton goBtn = new JButton("GO");
		ButtonGroup group = new ButtonGroup();
		JTextArea text = new JTextArea();
		group.add(timeCheckBox11);
		group.add(timeCheckBox21);
		group.add(timeCheckBox31);
		group.add(timeCheckBox41);
		group.add(timeCheckBox51);

		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(1, 5));
		panel1.add(timeCheckBox11);
		panel1.add(timeCheckBox21);
		panel1.add(timeCheckBox31);
		panel1.add(timeCheckBox41);
		panel1.add(timeCheckBox51);
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1, 5));
		panel2.add(text);

		class goAction implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				if (!timeCheckBox11.isSelected() && !timeCheckBox21.isSelected() && !timeCheckBox31.isSelected()
						&& !timeCheckBox41.isSelected() && !timeCheckBox51.isSelected()) {
					text.setText("Please choose a time!");
				} else {
					if (timeCheckBox11.isSelected()) {
						Connection conn;
						try {
							ResultFrame result = new ResultFrame();
							result.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							result.setVisible(true);
							setVisible(false);
							conn = Connect.getConnection();
							setVisible(false);
							String query = "SELECT `Name`,`Restaurant` ,`Phone_number`, `Account`, `Password`, `Gender`, `Grade`, `Line_ID`, `Interest`, `Mon_Lunch`,`Tue_Lunch`, `Wed_Lunch`, `Thu_Lunch`, `Fri_Lunch` ,`Department` FROM `member` WHERE `Mon_Lunch`=1 ";
							try {
								PreparedStatement s = conn.prepareStatement(query);
								try {
									ResultSet r = s.executeQuery();
									while (r.next()) {
										String name = r.getString("Name");
										String phone = r.getString("Phone_number");
										String line = r.getString("Line_ID");
										String interest = r.getString("Interest");
										String grade = r.getString("Grade");
										String department = r.getString("Department");
										String restaurant = r.getString("Restaurant");
										result.firstArea.append(" Name: " + name + " , " + " Phone: " + phone + " , "
												+ " Line id: " + line + " , " + " Department: " + department + " , "
												+ " Grade: " + grade + " , " + " Interest: " + interest + " , "
												+ " Favorite restaurant: " + restaurant + '\n');
									}
								} catch (SQLException e) {
									e.printStackTrace();
								}
							} catch (SQLException e) {
								e.printStackTrace();
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}

					}

					if (timeCheckBox21.isSelected()) {
						Connection conn;
						try {
							ResultFrame result = new ResultFrame();
							result.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							result.setVisible(true);
							setVisible(false);

							conn = Connect.getConnection();
							String query = "SELECT `Name`,`Restaurant`, `Department`,`Phone_number`, `Account`, `Password`, `Gender`, `Interest`, `Grade`, `Line_ID` FROM `member` WHERE `Tue_Lunch`=1 ";
							try {
								PreparedStatement s = conn.prepareStatement(query);
								try {
									ResultSet r = s.executeQuery();
									while (r.next()) {
										String name = r.getString("Name");
										String phone = r.getString("Phone_number");
										String line = r.getString("Line_ID");
										String interest = r.getString("Interest");
										String grade = r.getString("Grade");
										String department = r.getString("Department");
										String restaurant = r.getString("Restaurant");
										result.firstArea.append(" Name: " + name + " , " + " Phone: " + phone + " , "
												+ " Line id: " + line + " , " + " Department: " + department + " , "
												+ " Grade: " + grade + " , " + " Interest: " + interest + " , "
												+ " Favorite restaurant: " + restaurant + '\n');
									}
								} catch (SQLException e) {
									e.printStackTrace();
								}
							} catch (SQLException e) {
								e.printStackTrace();
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}

					}
					if (timeCheckBox31.isSelected()) {
						Connection conn;

						try {
							ResultFrame result = new ResultFrame();
							result.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							result.setVisible(true);
							setVisible(false);
							conn = Connect.getConnection();
							String query = "SELECT `Name`,`Restaurant`,`Department`, `Phone_number`, `Account`, `Password`, `Gender`, `Grade`, `Line_ID`, `Interest`, `Mon_Lunch`,`Tue_Lunch`, `Wed_Lunch`, `Thu_Lunch`, `Fri_Lunch` FROM `member` WHERE `Wed_Lunch`=1 ";
							try {
								PreparedStatement s = conn.prepareStatement(query);
								try {
									ResultSet r = s.executeQuery();
									while (r.next()) {
										String name = r.getString("Name");
										String phone = r.getString("Phone_number");
										String line = r.getString("Line_ID");
										String interest = r.getString("Interest");
										String grade = r.getString("Grade");
										String department = r.getString("Department");
										String restaurant = r.getString("Restaurant");
										result.firstArea.append(" Name: " + name + " , " + " Phone: " + phone + " , "
												+ " Line id: " + line + " , " + " Department: " + department + " , "
												+ " Grade: " + grade + " , " + " Interest: " + interest + " , "
												+ " Favorite restaurant: " + restaurant + '\n');
									}
								} catch (SQLException e) {
									e.printStackTrace();
								}
							} catch (SQLException e) {
								e.printStackTrace();
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}

					}
					if (timeCheckBox41.isSelected()) {
						Connection conn;
						try {
							ResultFrame result = new ResultFrame();
							result.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							result.setVisible(true);
							setVisible(false);
							conn = Connect.getConnection();
							String query = "SELECT `Name`,`Restaurant`, `Department`,`Phone_number`, `Account`, `Password`, `Interest`, `Gender`, `Grade`, `Line_ID` FROM `member` WHERE `Thu_Lunch`=1 ";
							try {
								PreparedStatement s = conn.prepareStatement(query);
								try {
									ResultSet r = s.executeQuery();
									while (r.next()) {
										String name = r.getString("Name");
										String gender = r.getString("Gender");
										String phone = r.getString("Phone_number");
										String line = r.getString("Line_ID");
										String interest = r.getString("Interest");
										String grade = r.getString("Grade");
										String department = r.getString("Department");
										String restaurant = r.getString("Restaurant");
										result.firstArea.append(" Name: " + name + " , " + " Phone: " + phone + " , "
												+ " Line id: " + line + " , " + " Department: " + department + " , "
												+ "Grade: " + grade + " , " + " Interest: " + interest + " , "
												+ " Favorite restaurant: " + restaurant + '\n');
									}
								} catch (SQLException e) {
									e.printStackTrace();
								}
							} catch (SQLException e) {
								e.printStackTrace();
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
					if (timeCheckBox51.isSelected()) {
						Connection conn;
						try {
							ResultFrame result = new ResultFrame();
							result.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							result.setVisible(true);
							setVisible(false);
							conn = Connect.getConnection();
							String query = "SELECT `Name`, `Restaurant`,`Department`,`Phone_number`, `Account`, `Password`, `Interest`, `Gender`, `Grade`, `Line_ID` FROM `member` WHERE `Fri_Lunch`=1 ";
							try {
								PreparedStatement s = conn.prepareStatement(query);
								try {
									ResultSet r = s.executeQuery();
									while (r.next()) {
										String name = r.getString("Name");
										String phone = r.getString("Phone_number");
										String line = r.getString("Line_ID");
										String interest = r.getString("Interest");
										String grade = r.getString("Grade");
										String department = r.getString("Department");
										String restaurant = r.getString("Restaurant");
										result.firstArea.append(" Name: " + name + " , " + " Phone: " + phone + " , "
												+ " Line id: " + line + " , " + " Department: " + department + " , "
												+ " Grade: " + grade + " , " + " Interest: " + interest + " , "
												+ " Favorite restaurant: " + restaurant + '\n');
									}
								} catch (SQLException e) {
									e.printStackTrace();
								}
							} catch (SQLException e) {
								e.printStackTrace();
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}

				}
			}
		}
		goBtn.addActionListener(new goAction());

		JPanel panel = new JPanel();
		panel.add(imagePanel1);
		panel.add(imagePanel2);

		panel.add(panel1);

		panel.add(goBtn);
		panel.add(panel2);

		return panel;
	}
}
