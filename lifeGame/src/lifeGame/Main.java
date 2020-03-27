package lifeGame;

import service.GameService;
import data.CellArray;
import data.CellState;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends JFrame {
	private JButton[][] btns;
	private JPanel p;
	private JPanel p1;
	private JPanel p2;
	private JPanel p3;
	private Container c;
	private int row = 20;
	private int col = 20;
	private CellArray cells;
	private CellArray cells1;
	private int generation = 0;

	//设置窗体
	public Main(String titile) {
		super(titile);

		setLocation(500, 200);
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();

	}

	//将细胞生命的变化以更加直观的方式显示
	public void initGUI() {
		p = new JPanel();
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p.setLayout(new BorderLayout(0, 0));
		p1.setLayout(new GridLayout(row, col, 0, 0));

		JLabel label = new JLabel("细胞组行数");
		JTextField textField = new JTextField(2);

		JLabel label1 = new JLabel("细胞组列数");
		JTextField textField1 = new JTextField(2);

		JButton b = new JButton("确定");

		final JLabel label2 = new JLabel("繁衍代数：0");
		p2.add(label);
		p2.add(textField);
		p2.add(label1);
		p2.add(textField1);
		p2.add(b);
		p3.add(label2);

		p.add(p3, BorderLayout.SOUTH);

		c.add(p, BorderLayout.NORTH);
		c.add(p1, BorderLayout.CENTER);

		btns = new JButton[row][col];

		cells = GameService.initMap(row, col);
		generation = 1;
		label2.setText("繁衍代数：" + generation);
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++) {
				btns[i][j] = new JButton();
				btns[i][j].setMargin(new Insets(0, 0, 0, 0));
				if (cells.getCell(i, j) == CellState.LIVE.getValue()) {

					btns[i][j].setBackground(Color.black);
					p1.add(btns[i][j]);

				} else {
					btns[i][j].setBackground(Color.white);
					p1.add(btns[i][j]);
				}
			}

		//细胞生命周期
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				cells = GameService.generate(cells);
				++generation;
				label2.setText("繁衍代数：" + generation);
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < col; j++) {
						if (cells.getCell(i, j) == CellState.LIVE.getValue()) {
							btns[i][j].setBackground(Color.black);

						} else {
							btns[i][j].setBackground(Color.white);

						}

					}

				}

			}
		}, 0, 500);
		setVisible(true);

	}


	public void initMap(JButton btns[][]) {

	}

	public void generate(JButton btns[][]) {

	}

	public static void main(String args[]) {
		Main main = new Main("生命游戏");
		main.initGUI();
	}

}
