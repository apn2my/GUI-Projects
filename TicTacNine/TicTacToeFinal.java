import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout; //part of the Swing class
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TicTacToeFinal extends JFrame implements ActionListener {
	JPanel p = new JPanel();
	public static int count = 0;
	public boolean oWin = false;
	public int tieTrack = 0;
	Button buttons[] = new Button[121]; // 9 boxes by 9 cells slots
	ImageIcon X, O, DEFAULT;
	protected static ArrayList<Object> intx = new ArrayList<>();
	protected static ArrayList<Object> into = new ArrayList<>();
	protected static ArrayList<Integer> xCount = new ArrayList<>();
	protected static ArrayList<Integer> yCount = new ArrayList<>();
	//protected static ArrayList<Integer> xTurns = new ArrayList<>();
	//protected static ArrayList<Integer> oTurns = new ArrayList<>();
	int boardCount = 0;
	public static void main(String args[]) {
		new TicTacToeFinal();
	}

	public TicTacToeFinal() { // constructor
		super("TicTacToe");

		X = new ImageIcon(this.getClass().getResource("X1.png"));
		O = new ImageIcon(this.getClass().getResource("O1.png"));
		//DEFAULT = new ImageIcon(this.getClass().getResource("defaultButton.png"));
		setSize(600, 600);
		setResizable(false); // no changes in size
		setDefaultCloseOperation(EXIT_ON_CLOSE); // ensures program actually
													// closes when window is
													// closed
		// set layout
		p.setLayout(new GridLayout(11, 11));

		for (int i = 0; i < 121; i++) {
			buttons[i] = new Button();
			buttons[i].setBackground(Color.gray);
			p.add(buttons[i]);
			buttons[i].addActionListener(this);
		}

		for (int i = 0; i < 121; i++) {
			JButton temp = buttons[i];
			int pos = i;
			temp.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					// TODO Auto-generated method stub
					count++;
					if (!oWin) {
						if (count % 2 != 0) {
							temp.setIcon(X);
							temp.setEnabled(false);
							temp.setBackground(Color.blue);
							intx.add(pos);
							System.out.println(intx);
						} else if (count % 2 == 0) {
							temp.setIcon(O);
							temp.setEnabled(false);
							temp.setBackground(Color.ORANGE);
							into.add(pos);
							System.out.println(into);
						}
					} else {
						if (count % 2 != 0) {
							temp.setIcon(O);
							temp.setEnabled(false);
							temp.setBackground(Color.ORANGE);
							into.add(pos);
							System.out.println(into);
						} else if (count % 2 == 0) {
							temp.setIcon(X);
							temp.setEnabled(false);
							temp.setBackground(Color.blue);
							intx.add(pos);
							System.out.println(intx);
						}
					}

					// BOX 1
					int nums[] = { 0, 1, 2, 11, 12, 13, 22, 23, 24 };
					int x = 0;
					for (int i = 0; i < 121; i++) {
						for (int j = 0; j < nums.length; j++) {
							x = nums[j];
							if (e.getSource() == buttons[x]) {
								if (i != 0 && i != 1 && i != 2 && i != 11
										&& i != 12 && i != 13 && i != 22
										&& i != 23 && i != 24) {
									buttons[i].setEnabled(false);
								}
							}
						}
					}
					if ((intx.contains(0) && intx.contains(1)
							&& intx.contains(2) || intx.contains(0)
							&& intx.contains(11) && intx.contains(22)
							|| intx.contains(1) && intx.contains(12)
							&& intx.contains(23) || intx.contains(2)
							&& intx.contains(13) && intx.contains(24)
							|| intx.contains(11) && intx.contains(12)
							&& intx.contains(13) || intx.contains(22)
							&& intx.contains(23) && intx.contains(24)
							|| intx.contains(0) && intx.contains(12)
							&& intx.contains(24) || intx.contains(2)
							&& intx.contains(12) && intx.contains(22))) {
						//JDialog dia = new JDialog();
						//JLabel label = new JLabel("X is the winner!",
								//SwingConstants.CENTER);
						boardCount++;
						xCount.add(1);
						oWin = false;
						buttons[0].setBackground(Color.blue);
						buttons[1].setBackground(Color.white);
						buttons[2].setBackground(Color.blue);
						buttons[11].setBackground(Color.white);
						buttons[12].setBackground(Color.blue);
						buttons[13].setBackground(Color.white);
						buttons[22].setBackground(Color.blue);
						buttons[23].setBackground(Color.white);
						buttons[24].setBackground(Color.blue);
						buttons[0].setEnabled(false);
						buttons[1].setEnabled(false);
						buttons[2].setEnabled(false);
						buttons[11].setEnabled(false);
						buttons[12].setEnabled(false);
						buttons[13].setEnabled(false);
						buttons[22].setEnabled(false);
						buttons[23].setEnabled(false);
						buttons[24].setEnabled(false);
						//dia.add(label);
						//dia.setSize(200, 200);
						//dia.setVisible(true);
						intx.clear();
						into.clear();
						count = 0;
						for (int i = 0; i < 121; i++) {
							if ((i != 0 && i != 1 && i != 2 && i != 11
									&& i != 12 && i != 13 && i != 22 && i != 23 && i != 24)
									&& (!buttons[i].getBackground().equals(
											buttons[3].getBackground()))) {
								if (buttons[i].getBackground().equals(
										Color.gray)) {
									buttons[i].setEnabled(true);
								} else
									buttons[i].setEnabled(false);
							}
						}

					}

					if ((into.contains(0) && into.contains(1)
							&& into.contains(2) || into.contains(0)
							&& into.contains(11) && into.contains(22)
							|| into.contains(1) && into.contains(12)
							&& into.contains(23) || into.contains(2)
							&& into.contains(13) && into.contains(24)
							|| into.contains(11) && into.contains(12)
							&& into.contains(13) || into.contains(22)
							&& into.contains(23) && into.contains(24)
							|| into.contains(0) && into.contains(12)
							&& into.contains(24) || into.contains(2)
							&& into.contains(12) && into.contains(22))) {
						//JDialog dia = new JDialog();
						//JLabel label = new JLabel("O is the winner!",
								//SwingConstants.CENTER);
						yCount.add(1);
						boardCount++;
						oWin = true;
						buttons[0].setBackground(Color.orange);
						buttons[1].setBackground(Color.orange);
						buttons[2].setBackground(Color.orange);
						buttons[11].setBackground(Color.orange);
						buttons[12].setBackground(Color.white);
						buttons[13].setBackground(Color.orange);
						buttons[22].setBackground(Color.orange);
						buttons[23].setBackground(Color.orange);
						buttons[24].setBackground(Color.orange);
						buttons[0].setEnabled(false);
						buttons[1].setEnabled(false);
						buttons[2].setEnabled(false);
						buttons[11].setEnabled(false);
						buttons[12].setEnabled(false);
						buttons[13].setEnabled(false);
						buttons[22].setEnabled(false);
						buttons[23].setEnabled(false);
						buttons[24].setEnabled(false);
						//dia.add(label);
						//dia.setSize(200, 200);
						//dia.setVisible(true);
						intx.clear();
						into.clear();
						count = 0;
						for (int i = 0; i < 121; i++) {
							if ((i != 0 && i != 1 && i != 2 && i != 11
									&& i != 12 && i != 13 && i != 22 && i != 23 && i != 24)
									&& (!buttons[i].getBackground().equals(
											buttons[3].getBackground()))) {
								if (buttons[i].getBackground().equals(
										Color.gray)) {
									buttons[i].setEnabled(true);
								} else
									buttons[i].setEnabled(false);
							}
						}
					}

					// BOX 2
					int nums2[] = { 4, 5, 6, 15, 16, 17, 26, 27, 28 };
					int x2 = 0;
					for (int i = 0; i < 121; i++) {
						for (int j = 0; j < nums2.length; j++) {
							x2 = nums2[j];
							if (e.getSource() == buttons[x2]) {
								if (i != 4 && i != 5 && i != 6 && i != 15
										&& i != 16 && i != 17 && i != 26
										&& i != 27 && i != 28) {
									buttons[i].setEnabled(false);
								}
							}
						}
					}

					if (intx.contains(4) && intx.contains(5)
							&& intx.contains(6) || intx.contains(15)
							&& intx.contains(16) && intx.contains(17)
							|| intx.contains(26) && intx.contains(27)
							&& intx.contains(28) || intx.contains(4)
							&& intx.contains(15) && intx.contains(26)
							|| intx.contains(5) && intx.contains(16)
							&& intx.contains(27) || intx.contains(6)
							&& intx.contains(17) && intx.contains(28)
							|| intx.contains(4) && intx.contains(16)
							&& intx.contains(28) || intx.contains(6)
							&& intx.contains(16) && intx.contains(26)) {
						//JDialog dia = new JDialog();
						//JLabel label = new JLabel("X is the winner!",
								//SwingConstants.CENTER);
						xCount.add(2);
						boardCount++;
						oWin = false;
						buttons[4].setBackground(Color.blue);
						buttons[5].setBackground(Color.white);
						buttons[6].setBackground(Color.blue);
						buttons[15].setBackground(Color.white);
						buttons[16].setBackground(Color.blue);
						buttons[17].setBackground(Color.white);
						buttons[26].setBackground(Color.blue);
						buttons[27].setBackground(Color.white);
						buttons[28].setBackground(Color.blue);
						buttons[4].setEnabled(false);
						buttons[5].setEnabled(false);
						buttons[6].setEnabled(false);
						buttons[15].setEnabled(false);
						buttons[16].setEnabled(false);
						buttons[17].setEnabled(false);
						buttons[26].setEnabled(false);
						buttons[27].setEnabled(false);
						buttons[28].setEnabled(false);
						//dia.add(label);
						//dia.setSize(200, 200);
						//dia.setVisible(true);
						intx.clear();
						into.clear();
						count = 0;
						for (int i = 0; i < 121; i++) {
							if ((i != 4 && i != 5 && i != 6 && i != 15
									&& i != 16 && i != 17 && i != 26 && i != 27 && i != 28)
									&& (!buttons[i].getBackground().equals(
											buttons[3].getBackground()))) {
								if (buttons[i].getBackground().equals(
										Color.gray)) {
									buttons[i].setEnabled(true);
								} else
									buttons[i].setEnabled(false);
							}
						}

					}
					if (into.contains(4) && into.contains(5)
							&& into.contains(6) || into.contains(15)
							&& into.contains(16) && into.contains(17)
							|| into.contains(26) && into.contains(27)
							&& into.contains(28) || into.contains(4)
							&& into.contains(15) && into.contains(26)
							|| into.contains(5) && into.contains(16)
							&& into.contains(27) || into.contains(6)
							&& into.contains(17) && into.contains(28)
							|| into.contains(4) && into.contains(16)
							&& into.contains(28) || into.contains(6)
							&& into.contains(16) && into.contains(26)) {
						//JDialog dia = new JDialog();
						//JLabel label = new JLabel("O is the winner!",
							//	SwingConstants.CENTER);
						yCount.add(2);
						boardCount++;
						oWin = true;
						buttons[4].setBackground(Color.orange);
						buttons[5].setBackground(Color.orange);
						buttons[6].setBackground(Color.orange);
						buttons[15].setBackground(Color.orange);
						buttons[16].setBackground(Color.white);
						buttons[17].setBackground(Color.orange);
						buttons[26].setBackground(Color.orange);
						buttons[27].setBackground(Color.orange);
						buttons[28].setBackground(Color.orange);
						buttons[4].setEnabled(false);
						buttons[5].setEnabled(false);
						buttons[6].setEnabled(false);
						buttons[15].setEnabled(false);
						buttons[16].setEnabled(false);
						buttons[17].setEnabled(false);
						buttons[26].setEnabled(false);
						buttons[27].setEnabled(false);
						buttons[28].setEnabled(false);
						//dia.add(label);
						//dia.setSize(200, 200);
						//dia.setVisible(true);
						intx.clear();
						into.clear();
						count = 0;
						for (int i = 0; i < 121; i++) {
							if ((i != 4 && i != 5 && i != 6 && i != 15
									&& i != 16 && i != 17 && i != 26 && i != 27 && i != 28)
									&& (!buttons[i].getBackground().equals(
											buttons[3].getBackground()))) {
								if (buttons[i].getBackground().equals(
										Color.gray)) {
									buttons[i].setEnabled(true);
								} else
									buttons[i].setEnabled(false);
							}
						}
					}

					// BOX 3
					int nums3[] = { 8, 9, 10, 19, 20, 21, 30, 31, 32 };
					int x3 = 0;
					for (int i = 0; i < 121; i++) {
						for (int j = 0; j < nums3.length; j++) {
							x3 = nums3[j];
							if (e.getSource() == buttons[x3]) {
								if (i != 8 && i != 9 && i != 10 && i != 19
										&& i != 20 && i != 21 && i != 30
										&& i != 31 && i != 32) {
									buttons[i].setEnabled(false);
								}
							}
						}
					}

					if (intx.contains(8) && intx.contains(9)
							&& intx.contains(10) || intx.contains(19)
							&& intx.contains(20) && intx.contains(21)
							|| intx.contains(30) && intx.contains(31)
							&& intx.contains(32) || intx.contains(8)
							&& intx.contains(19) && intx.contains(30)
							|| intx.contains(9) && intx.contains(20)
							&& intx.contains(31) || intx.contains(10)
							&& intx.contains(21) && intx.contains(32)
							|| intx.contains(8) && intx.contains(20)
							&& intx.contains(32) || intx.contains(10)
							&& intx.contains(20) && intx.contains(30)) {
						//JDialog dia = new JDialog();
						//JLabel label = new JLabel("X is the winner!",
							//	SwingConstants.CENTER);
						xCount.add(3);
						boardCount++;
						oWin = false;
						buttons[8].setBackground(Color.blue);
						buttons[9].setBackground(Color.white);
						buttons[10].setBackground(Color.blue);
						buttons[19].setBackground(Color.white);
						buttons[20].setBackground(Color.blue);
						buttons[21].setBackground(Color.white);
						buttons[30].setBackground(Color.blue);
						buttons[31].setBackground(Color.white);
						buttons[32].setBackground(Color.blue);
						buttons[8].setEnabled(false);
						buttons[9].setEnabled(false);
						buttons[10].setEnabled(false);
						buttons[19].setEnabled(false);
						buttons[20].setEnabled(false);
						buttons[21].setEnabled(false);
						buttons[30].setEnabled(false);
						buttons[31].setEnabled(false);
						buttons[32].setEnabled(false);
						//dia.add(label);
						//dia.setSize(200, 200);
						//dia.setVisible(true);
						intx.clear();
						into.clear();
						count = 0;
						for (int i = 0; i < 121; i++) {
							if ((i != 8 && i != 9 && i != 10 && i != 19
									&& i != 20 && i != 21 && i != 30 && i != 31 && i != 32)
									&& (!buttons[i].getBackground().equals(
											buttons[3].getBackground()))) {
								if (buttons[i].getBackground().equals(
										Color.gray)) {
									buttons[i].setEnabled(true);
								} else
									buttons[i].setEnabled(false);
							}
						}
					}
					if (into.contains(8) && into.contains(9)
							&& into.contains(10) || into.contains(19)
							&& into.contains(20) && into.contains(21)
							|| into.contains(30) && into.contains(31)
							&& into.contains(32) || into.contains(8)
							&& into.contains(19) && into.contains(30)
							|| into.contains(9) && into.contains(20)
							&& into.contains(31) || into.contains(10)
							&& into.contains(21) && into.contains(32)
							|| into.contains(8) && into.contains(20)
							&& into.contains(32) || into.contains(10)
							&& into.contains(20) && into.contains(30)) {
						//JDialog dia = new JDialog();
						//JLabel label = new JLabel("O is the winner!",
							//	SwingConstants.CENTER);
						yCount.add(3);
						boardCount++;
						oWin = true;
						buttons[8].setBackground(Color.orange);
						buttons[9].setBackground(Color.orange);
						buttons[10].setBackground(Color.orange);
						buttons[19].setBackground(Color.orange);
						buttons[20].setBackground(Color.white);
						buttons[21].setBackground(Color.orange);
						buttons[30].setBackground(Color.orange);
						buttons[31].setBackground(Color.orange);
						buttons[32].setBackground(Color.orange);
						buttons[8].setEnabled(false);
						buttons[9].setEnabled(false);
						buttons[10].setEnabled(false);
						buttons[19].setEnabled(false);
						buttons[20].setEnabled(false);
						buttons[21].setEnabled(false);
						buttons[30].setEnabled(false);
						buttons[31].setEnabled(false);
						buttons[32].setEnabled(false);
						//dia.add(label);
						//dia.setSize(200, 200);
						//dia.setVisible(true);
						intx.clear();
						into.clear();
						count = 0;
						for (int i = 0; i < 121; i++) {
							if ((i != 8 && i != 9 && i != 10 && i != 19
									&& i != 20 && i != 21 && i != 30 && i != 31 && i != 32)
									&& (!buttons[i].getBackground().equals(
											buttons[3].getBackground()))) {
								if (buttons[i].getBackground().equals(
										Color.gray)) {
									buttons[i].setEnabled(true);
								} else
									buttons[i].setEnabled(false);
							}
						}
					}

					// Box 4
					int nums4[] = { 44, 45, 46, 55, 56, 57, 66, 67, 68 };
					int x4 = 0;
					for (int i = 0; i < 121; i++) {
						for (int j = 0; j < nums4.length; j++) {
							x4 = nums4[j];
							if (e.getSource() == buttons[x4]) {
								if (i != 44 && i != 45 && i != 46 && i != 55
										&& i != 56 && i != 57 && i != 66
										&& i != 67 && i != 68) {
									buttons[i].setEnabled(false);
								}
							}
						}
					}
					if (intx.contains(44) && intx.contains(45)
							&& intx.contains(46) || intx.contains(55)
							&& intx.contains(56) && intx.contains(57)
							|| intx.contains(66) && intx.contains(67)
							&& intx.contains(68) || intx.contains(44)
							&& intx.contains(55) && intx.contains(66)
							|| intx.contains(45) && intx.contains(56)
							&& intx.contains(67) || intx.contains(46)
							&& intx.contains(57) && intx.contains(68)
							|| intx.contains(44) && intx.contains(56)
							&& intx.contains(68) || intx.contains(46)
							&& intx.contains(56) && intx.contains(66)) {
						//Jlog dia = new JDialog();
						//JLabel label = new JLabel("X is the winner!",
								//SwingConstants.CENTER);
						xCount.add(4);
						boardCount++;
						oWin = false;
						//dia.add(label);
						//dia.setSize(200, 200);
						//dia.setVisible(true);
						intx.clear();
						into.clear();
						count = 0;
						buttons[44].setBackground(Color.blue);
						buttons[45].setBackground(Color.white);
						buttons[46].setBackground(Color.blue);
						buttons[55].setBackground(Color.white);
						buttons[56].setBackground(Color.blue);
						buttons[57].setBackground(Color.white);
						buttons[66].setBackground(Color.blue);
						buttons[67].setBackground(Color.white);
						buttons[68].setBackground(Color.blue);
						buttons[44].setEnabled(false);
						buttons[45].setEnabled(false);
						buttons[46].setEnabled(false);
						buttons[55].setEnabled(false);
						buttons[56].setEnabled(false);
						buttons[57].setEnabled(false);
						buttons[66].setEnabled(false);
						buttons[67].setEnabled(false);
						buttons[68].setEnabled(false);
						for (int i = 0; i < 121; i++) {
							if ((i != 44 && i != 45 && i != 46 && i != 55
									&& i != 56 && i != 57 && i != 66 && i != 67 && i != 68)
									&& (!buttons[i].getBackground().equals(
											buttons[3].getBackground()))) {
								if (buttons[i].getBackground().equals(
										Color.gray)) {
									buttons[i].setEnabled(true);
								} else
									buttons[i].setEnabled(false);
							}
						}

					}
					if (into.contains(44) && into.contains(45)
							&& into.contains(46) || into.contains(55)
							&& into.contains(56) && into.contains(57)
							|| into.contains(66) && into.contains(67)
							&& into.contains(68) || into.contains(44)
							&& into.contains(55) && into.contains(66)
							|| into.contains(45) && into.contains(56)
							&& into.contains(67) || into.contains(46)
							&& into.contains(57) && into.contains(68)
							|| into.contains(44) && into.contains(56)
							&& into.contains(68) || into.contains(46)
							&& into.contains(56) && into.contains(66)) {
						//JDialog dia = new JDialog();
						//JLabel label = new JLabel("O is the winner!",
								//SwingConstants.CENTER);
						yCount.add(4);
						boardCount++;
						oWin = true;
						//dia.add(label);
						//dia.setSize(200, 200);
						//dia.setVisible(true);
						intx.clear();
						into.clear();
						count = 0;
						buttons[44].setBackground(Color.orange);
						buttons[45].setBackground(Color.orange);
						buttons[46].setBackground(Color.orange);
						buttons[55].setBackground(Color.orange);
						buttons[56].setBackground(Color.white);
						buttons[57].setBackground(Color.orange);
						buttons[66].setBackground(Color.orange);
						buttons[67].setBackground(Color.orange);
						buttons[68].setBackground(Color.orange);
						buttons[44].setEnabled(false);
						buttons[45].setEnabled(false);
						buttons[46].setEnabled(false);
						buttons[55].setEnabled(false);
						buttons[56].setEnabled(false);
						buttons[57].setEnabled(false);
						buttons[66].setEnabled(false);
						buttons[67].setEnabled(false);
						buttons[68].setEnabled(false);
						for (int i = 0; i < 121; i++) {
							if ((i != 44 && i != 45 && i != 46 && i != 55
									&& i != 56 && i != 57 && i != 66 && i != 67 && i != 68)
									&& (!buttons[i].getBackground().equals(
											buttons[3].getBackground()))) {
								if (buttons[i].getBackground().equals(
										Color.gray)) {
									buttons[i].setEnabled(true);
								} else
									buttons[i].setEnabled(false);
							}
						}

					}
					// Box 5
					int nums5[] = { 48, 49, 50, 59, 60, 61, 70, 71, 72 };
					int x5 = 0;
					for (int i = 0; i < 121; i++) {
						for (int j = 0; j < nums5.length; j++) {
							x5 = nums5[j];
							if (e.getSource() == buttons[x5]) {
								if (i != 48 && i != 49 && i != 50 && i != 59
										&& i != 60 && i != 61 && i != 70
										&& i != 71 && i != 72) {
									buttons[i].setEnabled(false);
								}
							}
						}
					}
					if (intx.contains(48) && intx.contains(49)
							&& intx.contains(50) || intx.contains(59)
							&& intx.contains(60) && intx.contains(61)
							|| intx.contains(70) && intx.contains(71)
							&& intx.contains(72) || intx.contains(48)
							&& intx.contains(59) && intx.contains(70)
							|| intx.contains(49) && intx.contains(60)
							&& intx.contains(71) || intx.contains(50)
							&& intx.contains(61) && intx.contains(72)
							|| intx.contains(48) && intx.contains(60)
							&& intx.contains(72) || intx.contains(50)
							&& intx.contains(60) && intx.contains(70)) {

						//JDialog dia = new JDialog();
						//JLabel label = new JLabel("X is the winner!",
							//	SwingConstants.CENTER);
						xCount.add(5);
						boardCount++;
						oWin = false;
						//dia.add(label);
						//dia.setSize(200, 200);
						//dia.setVisible(true);
						intx.clear();
						into.clear();
						count = 0;
						buttons[48].setBackground(Color.blue);
						buttons[49].setBackground(Color.white);
						buttons[50].setBackground(Color.blue);
						buttons[59].setBackground(Color.white);
						buttons[60].setBackground(Color.blue);
						buttons[61].setBackground(Color.white);
						buttons[70].setBackground(Color.blue);
						buttons[71].setBackground(Color.white);
						buttons[72].setBackground(Color.blue);
						buttons[48].setEnabled(false);
						buttons[49].setEnabled(false);
						buttons[50].setEnabled(false);
						buttons[59].setEnabled(false);
						buttons[60].setEnabled(false);
						buttons[61].setEnabled(false);
						buttons[70].setEnabled(false);
						buttons[71].setEnabled(false);
						buttons[72].setEnabled(false);
						for (int i = 0; i < 121; i++) {
							if ((i != 48 && i != 49 && i != 50 && i != 59
									&& i != 60 && i != 61 && i != 70 && i != 71 && i != 72)
									&& (!buttons[i].getBackground().equals(
											buttons[3].getBackground()))) {
								if (buttons[i].getBackground().equals(
										Color.gray)) {
									buttons[i].setEnabled(true);
								} else
									buttons[i].setEnabled(false);
							}
						}
					}
					if (into.contains(48) && into.contains(49)
							&& into.contains(50) || into.contains(59)
							&& into.contains(60) && into.contains(61)
							|| into.contains(70) && into.contains(71)
							&& into.contains(72) || into.contains(48)
							&& into.contains(59) && into.contains(70)
							|| into.contains(49) && into.contains(60)
							&& into.contains(71) || into.contains(50)
							&& into.contains(61) && into.contains(72)
							|| into.contains(48) && into.contains(60)
							&& into.contains(72) || into.contains(50)
							&& into.contains(60) && into.contains(70)) {

						//JDialog dia = new JDialog();
						//JLabel label = new JLabel("O is the winner!",
							//	SwingConstants.CENTER);
						yCount.add(5);
						boardCount++;
						oWin = true;
						//dia.add(label);
						//dia.setSize(200, 200);
						//dia.setVisible(true);
						intx.clear();
						into.clear();
						count = 0;
						buttons[48].setBackground(Color.orange);
						buttons[49].setBackground(Color.orange);
						buttons[50].setBackground(Color.orange);
						buttons[59].setBackground(Color.orange);
						buttons[60].setBackground(Color.white);
						buttons[61].setBackground(Color.orange);
						buttons[70].setBackground(Color.orange);
						buttons[71].setBackground(Color.orange);
						buttons[72].setBackground(Color.orange);
						buttons[48].setEnabled(false);
						buttons[49].setEnabled(false);
						buttons[50].setEnabled(false);
						buttons[59].setEnabled(false);
						buttons[60].setEnabled(false);
						buttons[61].setEnabled(false);
						buttons[70].setEnabled(false);
						buttons[71].setEnabled(false);
						buttons[72].setEnabled(false);
						for (int i = 0; i < 121; i++) {
							if ((i != 48 && i != 49 && i != 50 && i != 59
									&& i != 60 && i != 61 && i != 70 && i != 71 && i != 72)
									&& (!buttons[i].getBackground().equals(
											buttons[3].getBackground()))) {
								if (buttons[i].getBackground().equals(
										Color.gray)) {
									buttons[i].setEnabled(true);
								} else
									buttons[i].setEnabled(false);
							}
						}
					}

					// Box 6
					int nums6[] = { 52, 53, 54, 63, 64, 65, 74, 75, 76 };
					int x6 = 0;
					for (int i = 0; i < 121; i++) {
						for (int j = 0; j < nums6.length; j++) {
							x6 = nums6[j];
							if (e.getSource() == buttons[x6]) {
								if (i != 52 && i != 53 && i != 54 && i != 63
										&& i != 64 && i != 65 && i != 74
										&& i != 75 && i != 76) {
									buttons[i].setEnabled(false);
								}
							}
						}
					}
					if (intx.contains(52) && intx.contains(53)
							&& intx.contains(54) || intx.contains(63)
							&& intx.contains(64) && intx.contains(65)
							|| intx.contains(74) && intx.contains(75)
							&& intx.contains(76) || intx.contains(52)
							&& intx.contains(63) && intx.contains(74)
							|| intx.contains(53) && intx.contains(64)
							&& intx.contains(75) || intx.contains(54)
							&& intx.contains(65) && intx.contains(76)
							|| intx.contains(52) && intx.contains(64)
							&& intx.contains(76) || intx.contains(54)
							&& intx.contains(64) && intx.contains(74)) {

						//JDialog dia = new JDialog();
						//JLabel label = new JLabel("X is the winner!",
								//SwingConstants.CENTER);
						xCount.add(6);
						boardCount++;
						oWin = false;
						//dia.add(label);
						//dia.setSize(200, 200);
						//dia.setVisible(true);
						intx.clear();
						into.clear();
						count = 0;
						buttons[52].setBackground(Color.blue);
						buttons[53].setBackground(Color.white);
						buttons[54].setBackground(Color.blue);
						buttons[63].setBackground(Color.white);
						buttons[64].setBackground(Color.blue);
						buttons[65].setBackground(Color.white);
						buttons[74].setBackground(Color.blue);
						buttons[75].setBackground(Color.white);
						buttons[76].setBackground(Color.blue);
						buttons[52].setEnabled(false);
						buttons[53].setEnabled(false);
						buttons[54].setEnabled(false);
						buttons[63].setEnabled(false);
						buttons[64].setEnabled(false);
						buttons[65].setEnabled(false);
						buttons[74].setEnabled(false);
						buttons[75].setEnabled(false);
						buttons[76].setEnabled(false);
						for (int i = 0; i < 121; i++) {
							if ((i != 52 && i != 53 && i != 54 && i != 63
									&& i != 64 && i != 65 && i != 74 && i != 75 && i != 76)
									&& (!buttons[i].getBackground().equals(
											buttons[3].getBackground()))) {
								if (buttons[i].getBackground().equals(
										Color.gray)) {
									buttons[i].setEnabled(true);
								} else
									buttons[i].setEnabled(false);
							}
						}
					}
					if (into.contains(52) && into.contains(53)
							&& into.contains(54) || into.contains(63)
							&& into.contains(64) && into.contains(65)
							|| into.contains(74) && into.contains(75)
							&& into.contains(76) || into.contains(52)
							&& into.contains(63) && into.contains(74)
							|| into.contains(53) && into.contains(64)
							&& into.contains(75) || into.contains(54)
							&& into.contains(65) && into.contains(76)
							|| into.contains(52) && into.contains(64)
							&& into.contains(76) || into.contains(54)
							&& into.contains(64) && into.contains(74)) {

						//JDialog dia = new JDialog();
						//JLabel label = new JLabel("O is the winner!",
							//	SwingConstants.CENTER);
						yCount.add(6);
						boardCount++;
						oWin = true;
						//dia.add(label);
						//dia.setSize(200, 200);
						//dia.setVisible(true);
						intx.clear();
						into.clear();
						count = 0;
						buttons[52].setBackground(Color.orange);
						buttons[53].setBackground(Color.orange);
						buttons[54].setBackground(Color.orange);
						buttons[63].setBackground(Color.orange);
						buttons[64].setBackground(Color.white);
						buttons[65].setBackground(Color.orange);
						buttons[74].setBackground(Color.orange);
						buttons[75].setBackground(Color.orange);
						buttons[76].setBackground(Color.orange);
						buttons[52].setEnabled(false);
						buttons[53].setEnabled(false);
						buttons[54].setEnabled(false);
						buttons[63].setEnabled(false);
						buttons[64].setEnabled(false);
						buttons[65].setEnabled(false);
						buttons[74].setEnabled(false);
						buttons[75].setEnabled(false);
						buttons[76].setEnabled(false);
						for (int i = 0; i < 121; i++) {
							if ((i != 52 && i != 53 && i != 54 && i != 63
									&& i != 64 && i != 65 && i != 74 && i != 75 && i != 76)
									&& (!buttons[i].getBackground().equals(
											buttons[3].getBackground()))) {
								if (buttons[i].getBackground().equals(
										Color.gray)) {
									buttons[i].setEnabled(true);
								} else
									buttons[i].setEnabled(false);
							}
						}
					}
					// Box 7
					int nums7[] = { 88,89,90,99,100,101,110,111,112 };
					int x7 = 0;
					for (int i = 0; i < 121; i++) {
						for (int j = 0; j < nums7.length; j++) {
							x7 = nums7[j];
							if (e.getSource() == buttons[x7]) {
								if (i != 88 && i != 89 && i != 90 && i != 99
										&& i != 100 && i != 101 && i != 110
										&& i != 111 && i != 112) {
									buttons[i].setEnabled(false);
								}
							}
						}
					}
					if (intx.contains(88) && intx.contains(89)
							&& intx.contains(90) || intx.contains(99)
							&& intx.contains(100) && intx.contains(101)
							|| intx.contains(110) && intx.contains(111)
							&& intx.contains(112) || intx.contains(88)
							&& intx.contains(99) && intx.contains(110)
							|| intx.contains(89) && intx.contains(100)
							&& intx.contains(111) || intx.contains(90)
							&& intx.contains(101) && intx.contains(112)
							|| intx.contains(88) && intx.contains(100)
							&& intx.contains(112) || intx.contains(90)
							&& intx.contains(100) && intx.contains(110)) {

						//JDialog dia = new JDialog();
						//JLabel label = new JLabel("X is the winner!",
								//SwingConstants.CENTER);
						xCount.add(7);
						boardCount++;
						oWin = false;
						//dia.add(label);
						//dia.setSize(200, 200);
						//dia.setVisible(true);
						intx.clear();
						into.clear();
						count = 0;
						buttons[88].setBackground(Color.blue);
						buttons[89].setBackground(Color.white);
						buttons[90].setBackground(Color.blue);
						buttons[99].setBackground(Color.white);
						buttons[100].setBackground(Color.blue);
						buttons[101].setBackground(Color.white);
						buttons[110].setBackground(Color.blue);
						buttons[111].setBackground(Color.white);
						buttons[112].setBackground(Color.blue);
						buttons[88].setEnabled(false);
						buttons[89].setEnabled(false);
						buttons[90].setEnabled(false);
						buttons[99].setEnabled(false);
						buttons[100].setEnabled(false);
						buttons[101].setEnabled(false);
						buttons[110].setEnabled(false);
						buttons[111].setEnabled(false);
						buttons[112].setEnabled(false);
						for (int i = 0; i < 121; i++) {
							if ((i != 88 && i != 89 && i != 90 && i != 99
									&& i != 100 && i != 101 && i != 110
									&& i != 111 && i != 112)
									&& (!buttons[i].getBackground().equals(
											buttons[3].getBackground()))) {
								if (buttons[i].getBackground().equals(
										Color.gray)) {
									buttons[i].setEnabled(true);
								} else
									buttons[i].setEnabled(false);
							}
						}
					}
					if (into.contains(88) && into.contains(89)
							&& into.contains(90) || into.contains(99)
							&& into.contains(100) && into.contains(101)
							|| into.contains(110) && into.contains(111)
							&& into.contains(112) || into.contains(88)
							&& into.contains(99) && into.contains(110)
							|| into.contains(89) && into.contains(100)
							&& into.contains(111) || into.contains(90)
							&& into.contains(101) && into.contains(112)
							|| into.contains(88) && into.contains(100)
							&& into.contains(112) || into.contains(90)
							&& into.contains(100) && into.contains(110)) {

						//JDialog dia = new JDialog();
						//JLabel label = new JLabel("O is the winner!",
								//SwingConstants.CENTER);
						yCount.add(7);
						boardCount++;
						oWin = true;
						//dia.add(label);
						//dia.setSize(200, 200);
						//dia.setVisible(true);
						intx.clear();
						into.clear();
						count = 0;
						buttons[88].setBackground(Color.orange);
						buttons[89].setBackground(Color.orange);
						buttons[90].setBackground(Color.orange);
						buttons[99].setBackground(Color.orange);
						buttons[100].setBackground(Color.white);
						buttons[101].setBackground(Color.orange);
						buttons[110].setBackground(Color.orange);
						buttons[111].setBackground(Color.orange);
						buttons[112].setBackground(Color.orange);
						buttons[88].setEnabled(false);
						buttons[89].setEnabled(false);
						buttons[90].setEnabled(false);
						buttons[99].setEnabled(false);
						buttons[100].setEnabled(false);
						buttons[101].setEnabled(false);
						buttons[110].setEnabled(false);
						buttons[111].setEnabled(false);
						buttons[112].setEnabled(false);
						for (int i = 0; i < 121; i++) {
							if ((i != 88 && i != 89 && i != 90 && i != 99
									&& i != 100 && i != 101 && i != 110
									&& i != 111 && i != 112)
									&& (!buttons[i].getBackground().equals(
											buttons[3].getBackground()))) {
								if (buttons[i].getBackground().equals(
										Color.gray)) {
									buttons[i].setEnabled(true);
								} else
									buttons[i].setEnabled(false);
							}
						}
					}

					// Box 8
					int nums8[] = { 92, 93, 94, 103, 104, 105, 114, 115, 116 };
					int x8 = 0;
					for (int i = 0; i < 121; i++) {
						for (int j = 0; j < nums8.length; j++) {
							x8 = nums8[j];
							if (e.getSource() == buttons[x8]) {
								if (i != 92 && i != 93 && i != 94 && i != 103
										&& i != 104 && i != 105 && i != 114
										&& i != 115 && i != 116) {
									buttons[i].setEnabled(false);
								}
							}
						}
					}
					if (intx.contains(92) && intx.contains(93)
							&& intx.contains(94) || intx.contains(103)
							&& intx.contains(104) && intx.contains(105)
							|| intx.contains(114) && intx.contains(115)
							&& intx.contains(116) || intx.contains(92)
							&& intx.contains(103) && intx.contains(114)
							|| intx.contains(93) && intx.contains(104)
							&& intx.contains(115) || intx.contains(94)
							&& intx.contains(105) && intx.contains(116)
							|| intx.contains(92) && intx.contains(104)
							&& intx.contains(116) || intx.contains(94)
							&& intx.contains(104) && intx.contains(114)) {

						//JDialog dia = new JDialog();
						//JLabel label = new JLabel("X is the winner!",
							//	SwingConstants.CENTER);
						xCount.add(8);
						boardCount++;
						oWin = false;
						//dia.add(label);
						//dia.setSize(200, 200);
						//dia.setVisible(true);
						intx.clear();
						into.clear();
						count = 0;
						buttons[92].setBackground(Color.blue);
						buttons[93].setBackground(Color.white);
						buttons[94].setBackground(Color.blue);
						buttons[103].setBackground(Color.white);
						buttons[104].setBackground(Color.blue);
						buttons[105].setBackground(Color.white);
						buttons[114].setBackground(Color.blue);
						buttons[115].setBackground(Color.white);
						buttons[116].setBackground(Color.blue);
						buttons[92].setEnabled(false);
						buttons[93].setEnabled(false);
						buttons[94].setEnabled(false);
						buttons[103].setEnabled(false);
						buttons[104].setEnabled(false);
						buttons[105].setEnabled(false);
						buttons[114].setEnabled(false);
						buttons[115].setEnabled(false);
						buttons[116].setEnabled(false);
						for (int i = 0; i < 121; i++) {
							if ((i != 92 && i != 93 && i != 94 && i != 103
									&& i != 104 && i != 105 && i != 114
									&& i != 115 && i != 116)
									&& (!buttons[i].getBackground().equals(
											buttons[3].getBackground()))) {
								if (buttons[i].getBackground().equals(
										Color.gray)) {
									buttons[i].setEnabled(true);
								} else
									buttons[i].setEnabled(false);
							}
						}
					}
					if (into.contains(92) && into.contains(93)
							&& into.contains(94) || into.contains(103)
							&& into.contains(104) && into.contains(105)
							|| into.contains(114) && into.contains(115)
							&& into.contains(116) || into.contains(92)
							&& into.contains(103) && into.contains(114)
							|| into.contains(93) && into.contains(104)
							&& into.contains(115) || into.contains(94)
							&& into.contains(105) && into.contains(116)
							|| into.contains(92) && into.contains(104)
							&& into.contains(116) || into.contains(94)
							&& into.contains(104) && into.contains(114)) {

						//JDialog dia = new JDialog();
						//JLabel label = new JLabel("O is the winner!",
								//SwingConstants.CENTER);
						yCount.add(8);
						boardCount++;
						oWin = true;
						//dia.add(label);
						//dia.setSize(200, 200);
						//dia.setVisible(true);
						intx.clear();
						into.clear();
						count = 0;
						buttons[92].setBackground(Color.orange);
						buttons[93].setBackground(Color.orange);
						buttons[94].setBackground(Color.orange);
						buttons[103].setBackground(Color.orange);
						buttons[104].setBackground(Color.white);
						buttons[105].setBackground(Color.orange);
						buttons[114].setBackground(Color.orange);
						buttons[115].setBackground(Color.orange);
						buttons[116].setBackground(Color.orange);
						buttons[92].setEnabled(false);
						buttons[93].setEnabled(false);
						buttons[94].setEnabled(false);
						buttons[103].setEnabled(false);
						buttons[104].setEnabled(false);
						buttons[105].setEnabled(false);
						buttons[114].setEnabled(false);
						buttons[115].setEnabled(false);
						buttons[116].setEnabled(false);
						for (int i = 0; i < 121; i++) {
							if ((i != 92 && i != 93 && i != 94 && i != 103
									&& i != 104 && i != 105 && i != 114
									&& i != 115 && i != 116)
									&& (!buttons[i].getBackground().equals(
											buttons[3].getBackground()))) {
								if (buttons[i].getBackground().equals(
										Color.gray)) {
									buttons[i].setEnabled(true);
								} else
									buttons[i].setEnabled(false);
							}
						}
					}
					// Box 9
					int nums9[] = { 96, 97, 98, 107, 108, 109, 118, 119, 120 };
					int x9 = 0;
					for (int i = 0; i < 121; i++) {
						for (int j = 0; j < nums9.length; j++) {
							x9 = nums9[j];
							if (e.getSource() == buttons[x9]) {
								if ((i != 96 && i != 97 && i != 98 && i != 107
										&& i != 108 && i != 109 && i != 118
										&& i != 119 && i != 120)
										&& (!buttons[i].getBackground().equals(
												buttons[3].getBackground()))) {
									buttons[i].setEnabled(false);
								}
							}
						}
					}
					if (intx.contains(96) && intx.contains(97)
							&& intx.contains(98) || intx.contains(107)
							&& intx.contains(108) && intx.contains(109)
							|| intx.contains(118) && intx.contains(119)
							&& intx.contains(120) || intx.contains(96)
							&& intx.contains(107) && intx.contains(118)
							|| intx.contains(97) && intx.contains(108)
							&& intx.contains(119) || intx.contains(98)
							&& intx.contains(109) && intx.contains(120)
							|| intx.contains(96) && intx.contains(108)
							&& intx.contains(120) || intx.contains(98)
							&& intx.contains(108) && intx.contains(118)) {

						//JDialog dia = new JDialog();
						//JLabel label = new JLabel("X is the winner!",
								//SwingConstants.CENTER);
						xCount.add(9);
						boardCount++;
						oWin = false;
						//dia.add(label);
						//dia.setSize(200, 200);
						//dia.setVisible(true);
						intx.clear();
						into.clear();
						count = 0;
						buttons[96].setBackground(Color.blue);
						buttons[97].setBackground(Color.white);
						buttons[98].setBackground(Color.blue);
						buttons[107].setBackground(Color.white);
						buttons[108].setBackground(Color.blue);
						buttons[109].setBackground(Color.white);
						buttons[118].setBackground(Color.blue);
						buttons[119].setBackground(Color.white);
						buttons[120].setBackground(Color.blue);
						buttons[96].setEnabled(false);
						buttons[97].setEnabled(false);
						buttons[98].setEnabled(false);
						buttons[107].setEnabled(false);
						buttons[108].setEnabled(false);
						buttons[109].setEnabled(false);
						buttons[118].setEnabled(false);
						buttons[119].setEnabled(false);
						buttons[120].setEnabled(false);
						for (int i = 0; i < 121; i++) {
							if ((i != 96 && i != 97 && i != 98 && i != 107
									&& i != 108 && i != 109 && i != 118
									&& i != 119 && i != 120)
									&& (!buttons[i].getBackground().equals(
											buttons[3].getBackground()))) {
								if (buttons[i].getBackground().equals(
										Color.gray)) {
									buttons[i].setEnabled(true);
								} else
									buttons[i].setEnabled(false);
							}
						}
					}
					if (into.contains(96) && into.contains(97)
							&& into.contains(98) || into.contains(107)
							&& into.contains(108) && into.contains(109)
							|| into.contains(118) && into.contains(119)
							&& into.contains(120) || into.contains(96)
							&& into.contains(107) && into.contains(118)
							|| into.contains(97) && into.contains(108)
							&& into.contains(119) || into.contains(98)
							&& into.contains(109) && into.contains(120)
							|| into.contains(96) && into.contains(108)
							&& into.contains(120) || into.contains(98)
							&& into.contains(108) && into.contains(118)) {

						//JDialog dia = new JDialog();
						//JLabel label = new JLabel("O is the winner!",
								//SwingConstants.CENTER);
						yCount.add(9);
						boardCount++;
						oWin = true;
						//dia.add(label);
						//dia.setSize(200, 200);
						//dia.setVisible(true);
						intx.clear();
						into.clear();
						count = 0;
						buttons[96].setBackground(Color.orange);
						buttons[97].setBackground(Color.orange);
						buttons[98].setBackground(Color.orange);
						buttons[107].setBackground(Color.orange);
						buttons[108].setBackground(Color.white);
						buttons[109].setBackground(Color.orange);
						buttons[118].setBackground(Color.orange);
						buttons[119].setBackground(Color.orange);
						buttons[120].setBackground(Color.orange);
						buttons[96].setEnabled(false);
						buttons[97].setEnabled(false);
						buttons[98].setEnabled(false);
						buttons[107].setEnabled(false);
						buttons[108].setEnabled(false);
						buttons[109].setEnabled(false);
						buttons[118].setEnabled(false);
						buttons[119].setEnabled(false);
						buttons[120].setEnabled(false);
						for (int i = 0; i < 121; i++) {
							if (i != 96 && i != 97 && i != 98 && i != 107
									&& i != 108 && i != 109 && i != 118
									&& i != 119 && i != 120) {
								if (buttons[i].getBackground().equals(
										Color.gray)) {
									buttons[i].setEnabled(true);
								} else
									buttons[i].setEnabled(false);
							}
						}
					}

					// TIE CASE
					else if (count >= 9) {
						JDialog dia = new JDialog();
						JLabel label = new JLabel("Tie :-(",
								SwingConstants.CENTER);
						dia.add(label);
						dia.setSize(200, 300);
						dia.setVisible(true);
						count = 0;
						boardCount++;
						for (int i = 0; i < 121; i++) {
							if (buttons[i].getBackground().equals(Color.gray)) {
								buttons[i].setEnabled(true);
							} else
								buttons[i].setEnabled(false);
						}
					}

					// OVERALL 9x9 winnings
					// X is winner
					if (xCount.contains(1)
							&& xCount.contains(2)
							&& xCount.contains(3)
							|| (xCount.contains(4)
									&& xCount.contains(5)
									&& xCount.contains(6)
									|| (xCount.contains(7)
											&& xCount.contains(8) && xCount
												.contains(9))
									|| xCount.contains(1) && xCount.contains(4)
									&& xCount.contains(7) || xCount.contains(2)
									&& xCount.contains(5) && xCount.contains(8)
									|| xCount.contains(3) && xCount.contains(6)
									&& xCount.contains(9) || xCount.contains(1)
									&& xCount.contains(5) && xCount.contains(9) || xCount
									.contains(3)
									&& xCount.contains(5)
									&& xCount.contains(7))) {
						// Clearing all the lists
						count = 0;
						intx.clear();
						into.clear();
						xCount.clear();
						yCount.clear();
						temp.removeAll();

						// Pop up Dialog
						JDialog dia = new JDialog();
						dia.setSize(400, 400);
						JButton b = new JButton("GAME OVER!          "
								+ "X WINS          "
								+ "       Click to RESTART");
						b.setVisible(true);
						dia.add(b);
						dia.setVisible(true);
						
						// Re enabling board --> clearing the board
						b.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								TicTacToeFinal.this.dispose();
								new TicTacToeFinal();
								if (b.isEnabled()) {
									dia.setVisible(false);
								}
							}
						}); 
					} //*******closes the if statement 

					// O is winner
					if (yCount.contains(1)
							&& yCount.contains(2)
							&& yCount.contains(3)
							|| (yCount.contains(4)
									&& yCount.contains(5)
									&& yCount.contains(6)
									|| (yCount.contains(7)
											&& yCount.contains(8) && yCount
												.contains(9))
									|| yCount.contains(1) && yCount.contains(4)
									&& yCount.contains(7) || yCount.contains(2)
									&& yCount.contains(5) && yCount.contains(8)
									|| yCount.contains(3) && yCount.contains(6)
									&& yCount.contains(9) || yCount.contains(1)
									&& yCount.contains(5) && yCount.contains(9) || yCount
									.contains(3)
									&& yCount.contains(5)
									&& yCount.contains(7))) {
						// Clearing all the lists
						count = 0;
						intx.clear();
						into.clear();
						xCount.clear();
						yCount.clear();
						temp.removeAll();

						JDialog dia = new JDialog();
						dia.setSize(400, 400);
						JButton b = new JButton("GAME OVER!          "
								+ "O WINS          "
								+ "       Click to RESTART");
						b.setVisible(true);
						b.setBounds(10, 10, 40, 40);
						dia.add(b);
						dia.setVisible(true);
						b.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								TicTacToeFinal.this.dispose();
								new TicTacToeFinal();
								if (b.isEnabled()) {
									dia.setVisible(false);
								}
							}
						});
					} //****closes the if statement 
					
					//OVERALL TIE CASE 
					
					else if(boardCount >= 9) {
						// Clearing all the lists
						//count = 0;
						intx.clear();
						into.clear();
						xCount.clear();
						yCount.clear();
						temp.removeAll();

						JDialog dia = new JDialog();
						dia.setSize(400, 400);
						JButton b = new JButton("GAME OVER!          "
								+ "ULTIMATE TIE - NO WINS          "
								+ "       Click to RESTART");
						b.setVisible(true);
						b.setBounds(10, 10, 40, 40);
						dia.add(b);
						dia.setVisible(true);
						b.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								TicTacToeFinal.this.dispose();
								new TicTacToeFinal();
								if (b.isEnabled()) {
									dia.setVisible(false);
								}
							}
						});
						
					}
				}
			});
		}

		// LAYOUT CONSTRUCTION
		for (int i = 0; i < 121; i++) {
			if (i >= 33 && i <= 43) {
				buttons[i].setVisible(false);
				buttons[i].setBackground(Color.white);
			}
			if (i >= 77 && i <= 87) {
				buttons[i].setVisible(false);
				buttons[i].setBackground(Color.white);
			}
		}

		buttons[3].setVisible(false);
		buttons[3].setBackground(Color.white);
		buttons[7].setVisible(false);
		buttons[7].setBackground(Color.white);
		buttons[14].setVisible(false);
		buttons[14].setBackground(Color.white);
		buttons[18].setVisible(false);
		buttons[18].setBackground(Color.white);
		buttons[25].setVisible(false);
		buttons[25].setBackground(Color.white);
		buttons[29].setVisible(false);
		buttons[29].setBackground(Color.white);
		buttons[43].setVisible(false);
		buttons[43].setBackground(Color.white);
		buttons[47].setVisible(false);
		buttons[47].setBackground(Color.white);
		buttons[51].setVisible(false);
		buttons[51].setBackground(Color.white);
		buttons[58].setVisible(false);
		buttons[58].setBackground(Color.white);
		buttons[62].setVisible(false);
		buttons[62].setBackground(Color.white);
		buttons[69].setVisible(false);
		buttons[69].setBackground(Color.white);
		buttons[73].setVisible(false);
		buttons[73].setBackground(Color.white);
		buttons[80].setVisible(false);
		buttons[80].setBackground(Color.white);
		buttons[84].setVisible(false);
		buttons[84].setBackground(Color.white);
		buttons[91].setVisible(false);
		buttons[91].setBackground(Color.white);
		buttons[95].setVisible(false);
		buttons[95].setBackground(Color.white);
		buttons[102].setVisible(false);
		buttons[102].setBackground(Color.white);
		buttons[106].setVisible(false);
		buttons[106].setBackground(Color.white);
		buttons[113].setVisible(false);
		buttons[113].setBackground(Color.white);
		buttons[117].setVisible(false);
		buttons[117].setBackground(Color.white);
		add(p);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}