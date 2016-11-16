import javax.swing.ImageIcon; //keeps track dimensions of the image and hold it 
import javax.swing.JButton;
import java.awt.event.ActionListener; //tree falls in empty forest paradigm
import java.awt.event.ActionEvent;

public class Button extends JButton implements ActionListener {
	ImageIcon X, O;

	public Button() {
		X = new ImageIcon(this.getClass().getResource("X1.png"));
		O = new ImageIcon(this.getClass().getResource("O1.png"));
		this.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {

	}
}
