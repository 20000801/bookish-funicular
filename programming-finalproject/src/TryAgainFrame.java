import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TryAgainFrame extends JFrame {
	final int FRAME_WIDTH = 600;
	final int FRAME_HEIGHT = 560;
	final int FIELD_WIDTH = 10;
	final int AREA_WIDTH = 90;
	final int AREA_HEIGHT = 10;
	private JButton button01;
	RegisterFrame register = new RegisterFrame();

	public TryAgainFrame() {
		setTitle("Lunch Date");
		add(createPanel());
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	public JPanel createPanel() {
		JLabel sign = new JLabel("Please fill it up again ~ ");
		JLabel sign2 = new JLabel("You miss some blanks!");
		Image mm = new ImageIcon(this.getClass().getResource("/wrong.jpg")).getImage();
		JLabel imageLabel = new JLabel();
		imageLabel.setIcon(new ImageIcon(mm));
		sign.setFont(new Font("DIALOG", Font.BOLD, 35));
		
		sign2.setFont(new Font("DIALOG", Font.BOLD, 45));
		sign2.setForeground(Color.red);
		button01 = new JButton("Try again");
		class goAction implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				RegisterFrame register = new RegisterFrame();
				register.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				register.setVisible(true);
				dispose();
			}
		}

		button01.addActionListener(new goAction());

		JPanel panel = new JPanel();
		panel.add(imageLabel);
		panel.add(sign);
		panel.add(sign2);
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(button01);
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		
		//panel2.add(imageLabel,BorderLayout.NORTH);
		panel2.add(panel,BorderLayout.CENTER);
		panel2.add(buttonPanel, BorderLayout.SOUTH);

		return panel2;
	}
}
