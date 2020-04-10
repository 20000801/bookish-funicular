import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class LogInFrame extends JFrame {
	final int FRAME_WIDTH = 700;
	final int FRAME_HEIGHT = 250;
	final int FIELD_WIDTH = 10;
	final int AREA_WIDTH = 90;
	final int AREA_HEIGHT = 10;
	private JButton button01;

	public LogInFrame() {
		setTitle("Lunch Date");
		add(createPanel());
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	public JPanel createPanel() {
		JLabel logIn = new JLabel("Please log in again ! ");
		Image mm = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		JLabel imageLabel = new JLabel();
		imageLabel.setIcon(new ImageIcon(mm));
		logIn.setFont(new Font("DIALOG", Font.BOLD, 50));
		 button01 = new JButton("Log in");
		 class goAction implements ActionListener {
				public void actionPerformed(ActionEvent event) {
					//System.out.println("jhjbxhcbk");
					frame frame = new frame();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
					dispose();
				}
			}

			button01.addActionListener(new goAction());
		 
			
		JPanel panel=new JPanel();
		panel.add(imageLabel);
		panel.add(logIn);
		JPanel buttonPanel=new JPanel();
		buttonPanel.add(button01);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		panel2.add(panel,BorderLayout.NORTH);

		panel2.add(buttonPanel,BorderLayout.SOUTH);

	
	return panel2;
}
}