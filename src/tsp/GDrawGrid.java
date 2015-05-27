package tsp;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GDrawGrid extends JPanel {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private int columnCount;
	private int rowCount;
	private List<Rectangle> cells;
	private Point hoveredCell;
	private Point clickedCell;
	private Point initialCell;
	private double column;
	private double row;
	private ArrayList<Integer> addedItems;
	private CustomRowColumnLabel customRowColumnLabel;
	private ProductInfoLabel productInfoLabel;
	private Warehouse ware;
	private JComboBox itemListBox;
	private CustomRowColumnLabel label;
	private double width;
	private double height;
	private ArrayList<Point> circels;
	private Ball ball;
	private boolean start;
	private JLabel addedproductsLabel, label12;
	private int spinner, messageCount;
	private JButton resetButton, testButton, button2, button4, startButton,
			button3;
	private boolean procesStop = false;
	private JPanel panel6;
	private boolean drawBall = false;
	private long startBall, stopBall; 
	private boolean first = true;

	// /////////// INIT GRID && REDRAW /////////////

	public GDrawGrid(int columnCount, int rowCount,
			CustomRowColumnLabel customRowColumnLabel,
			ProductInfoLabel productInfoLabel, JComboBox itemListBox,
			JLabel addedproductsLabel, JButton resetButton, JButton testButton,
			JButton button2, JButton button4, JButton startButton,
			JButton button3, JPanel panel6, JLabel label12) {
		this.label12 = label12;
		this.panel6 = panel6;
		this.button3 = button3;
		this.startButton = startButton;
		this.testButton = testButton;
		this.button2 = button2;
		this.button4 = button4;
		this.resetButton = resetButton;
		this.columnCount = columnCount;
		this.rowCount = rowCount;
		this.itemListBox = itemListBox;
		this.addedproductsLabel = addedproductsLabel;
		this.ball = new Ball(0, 600, 0, 600);
		this.spinner = 0;
		button3.setEnabled(false);
		messageCount = 0;
		startBall = 0;
		stopBall = 0;
		start = false;
		addedItems = new ArrayList<Integer>();
		ball.setColor(Color.GREEN);
		panel6.setBackground(Color.GREEN);

		width = 600;
		height = 600;

		ware = new Warehouse(rowCount, columnCount, width, height);
		cells = ware.getShelf().getCells();

		this.customRowColumnLabel = customRowColumnLabel;
		this.productInfoLabel = productInfoLabel;
		updateComboBox();
		addMouse();

		// calculatePath(0);

	}

	public void reDraw(int columnCount, int rowCount, int spinner) {
		this.columnCount = columnCount;
		this.rowCount = rowCount;
		ball.setColor(Color.GREEN);
		panel6.setBackground(Color.GREEN);
		button3.setText("Stop process");
		this.spinner = spinner;
		drawBall = false;
		width = getWidth();
		height = getHeight();
		ware = new Warehouse(rowCount, columnCount, width, height);
		cells = ware.getShelf().getCells();
		updateComboBox();
		start = false;
		button3.setEnabled(false);
		repaint();

		// calculatePath(spinner);
	}

	// /////////// BEGIN PAINT /////////////

	double ballInitialX = -1;
	double ballInitialY = -1;
	int startI = 0;
	boolean go = true;

	public void resetBall() {
		ballInitialX = -1;
		ballInitialY = -1;
		startI = 0;
		go = true;
		ball.setColor(Color.GREEN);
		panel6.setBackground(Color.GREEN);
		label12.setText("Status");
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();

		// Height & Width of panel

		double width = getWidth();
		double height = getHeight();

		// Heigth & Width of every cell

		double cellWidth = width / columnCount;
		double cellHeight = height / rowCount;

		// Begin of offset X & Y

		double xOffset = (width - (columnCount * cellWidth)) / 2;
		double yOffset = (height - (rowCount * cellHeight)) / 2;

		if (cells.isEmpty()) {
			for (int row = 0; row < rowCount; row++) {
				for (int col = 0; col < columnCount; col++) {
					Rectangle cell = new Rectangle(
							(int) (xOffset + (col * cellWidth)),
							(int) (yOffset + (row * cellHeight)),
							(int) cellWidth, (int) cellHeight);
					cells.add(cell);
				}
			}
		}

		if (hoveredCell != null) {

			int index = hoveredCell.x + (hoveredCell.y * columnCount);
			try {
				Rectangle cell = cells.get(index);
				g2d.setColor(Color.BLUE);
				g2d.fill(cell);
			} catch (IndexOutOfBoundsException ex) {
			}

		}

		if (clickedCell != null) {
			int index = clickedCell.x + (clickedCell.y * columnCount);

			try {

				Rectangle cellPut = new Rectangle();
				cellPut = cells.get(index);

				g2d.setColor(Color.red);
				g2d.fill(cellPut);

			} catch (IndexOutOfBoundsException ex) {

			}

		}

		g2d.setColor(Color.GRAY);
		int count = 1;

		for (Rectangle cell : cells) {
			g2d.draw(cell);

			double rectWdth = cell.getWidth();
			double rectHgt = cell.getHeight();

			double sizeCount = rectHgt * 0.18;
			int fontSize = (int) sizeCount;

			Font font = new Font("Tahoma", Font.PLAIN, fontSize);
			g2d.setFont(font);

			FontMetrics metrics = g2d.getFontMetrics(font);

			int hgt = metrics.getHeight();

			// int wdth = metrics.stringWidth(Integer.toString(count));

			double padding = rectWdth * 0.05;
			double minX = cell.getMinX();
			double minY = cell.getMinY();
			g2d.setStroke(new BasicStroke(2));
			g2d.drawString(Integer.toString(count), (int) (minX + padding),
					(int) (minY + hgt));

			double widthCell = cell.getWidth();
			double heightCell = cell.getHeight();

			int x1 = -1;
			int y1 = -1;

			int x2 = -1;
			int y2 = -1;
			if (start == true) {
				for (Point circel : circels) {

					if (x1 == -1) {
						x1 = circel.x;
						y1 = circel.y;
					} else {

						x2 = circel.x;
						y2 = circel.y;

						g2d.drawLine(x1, y1, x2, y2);

						x1 = circel.x;
						y1 = circel.y;

					}

					int radius1 = (int) ((heightCell / 2) * 0.5);
					int radius2 = (int) ((widthCell / 2) * 0.5);

					int diameter1 = radius1 * 2;
					int diameter2 = radius2 * 2;

					g2d.fillOval(circel.x - radius2, circel.y - radius1,
							diameter2, diameter1);

				}
			}

			count++;

		}

		if (procesStop == false) {

			if (start == true) {

				if (ballInitialX == -1) {

					ballInitialX = circels.get(0).getX();
					ballInitialY = circels.get(0).getY();

					ball.setLocation(ballInitialX, ballInitialY);
				} else {

					if (go == true) {
						startI++;
						ball.setColor(Color.GREEN);
						panel6.setBackground(Color.GREEN);
						label12.setText("Moving");
						go = false;
					}

					if (circels.size() > startI) {
						ball.travel(0.05);
						ball.setSpeed(2);
						ball.headTowards((int) circels.get(startI).getX(),
								(int) circels.get(startI).getY());
						if (almostEqual(circels.get(startI).getX(),
								ball.getX(), 2)
								&& almostEqual(circels.get(startI).getY(),
										ball.getY(), 2)) {
							label12.setText("Busy");
							ball.setColor(Color.ORANGE);
							panel6.setBackground(Color.ORANGE);
							
							
							if(stopBall == 0 && startBall == 0){
								settingBal();
							}
							stopBall = System.currentTimeMillis();
						}
												
						long divert = stopBall - startBall;
						
						//System.out.println(divert);
						
						if (divert > 3000){
							stopBall = 0;
							startBall = 0;
							first = true;
							go = true;
						}
						
					} else {
						ball.travel(0);
						label12.setText("Done");
					
						startButton.setEnabled(true);
						resetButton.setEnabled(true);
						testButton.setEnabled(true);
						button4.setEnabled(true);
						button2.setEnabled(true);
						
					


					}

					/*
					 * System.out.println("Go to X: "+
					 * circels.get(startI).getX()+" Go to Y: "+
					 * circels.get(startI).getY());
					 * System.out.println("ball X: "+ ball.getX()+" ball Y: "+
					 * ball.getY());
					 */

					/*
					 * if() ball.headTowards((int)circels.getX(),
					 * (int)circels.getY());
					 */

				}

			}

		}

		if (drawBall == true) {
			ball.draw(g);
		}

		repaint();

		g2d.dispose();
	}

	// /////////// DRAW METHODS /////////////

	private void settingBal() {
		if(go == false && first == true){
			startBall = System.currentTimeMillis();
			first = false;
		}
		
	}
	
	private void showDialog() {
		if(go == false && first == true){
			startBall = System.currentTimeMillis();
			first = false;
		}
		
	}

	public static boolean almostEqual(double a, double b, double eps) {
		return Math.abs(a - b) < eps;
	}

	public void drawLeftAboveString(String s, int w, int h, Graphics g) {
		FontMetrics fm = g.getFontMetrics();
		int x = (w - fm.stringWidth(s));
		int y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())));
		g.drawString(s, x, y);
	}

	// /////////// BALL METHODS /////////////

	public void processStop() {

		if (procesStop == true) {

			button3.setText("Stop process");
			startButton.setEnabled(false);
			resetButton.setEnabled(false);
			testButton.setEnabled(false);
			button2.setEnabled(false);
			button4.setEnabled(false);

			procesStop = false;
			label12.setText("Moving");
			ball.setColor(Color.GREEN);
			panel6.setBackground(Color.GREEN);

		} else {

			startButton.setEnabled(true);
			resetButton.setEnabled(true);
			testButton.setEnabled(true);
			button4.setEnabled(true);
			button2.setEnabled(true);
			button3.setText("Resume process");

			procesStop = true;
			label12.setText("Stopped");
			ball.setColor(Color.red);
			panel6.setBackground(Color.RED);
		}

	}

	// /////////// MOUSE CONFIG /////////////

	public void addMouse() {
		MouseAdapter mouseHandler;
		mouseHandler = new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent evt) {

				locationFind(evt);

				// +1 omdat we bij 1 willen beginnen en niet 0;

				clickedCell = new Point((int) column, (int) row);

				customRowColumnLabel.setTextRC((int) (column + 1),
						(int) (row + 1));

				int index = clickedCell.x + (clickedCell.y * columnCount);
				Rectangle cellPut = new Rectangle();
				cellPut = cells.get(index);

				String input = "" + ware.getCache().get(cellPut);
				productInfoLabel.setTextLabel(input);
				// System.out.println("Center x: "+cellPut.getCenterX()+" Center Y: "+cellPut.getCenterY()+" index : "+(index+1));

				repaint();
			}

			public void mouseMoved(MouseEvent e) {
				locationFind(e);

				hoveredCell = new Point((int) column, (int) row);
				repaint();

			}

		};

		addMouseMotionListener(mouseHandler);
		addMouseListener(mouseHandler);
	}

	public void locationFind(MouseEvent e) {
		double width = ware.getWidth();
		double height = ware.getHeight();

		double cellWidth = width / ware.getColumns();
		double cellHeight = height / ware.getRows();

		column = e.getX() / cellWidth;
		row = e.getY() / cellHeight;

	}

	// /////////// INVALIDATION /////////////

	@Override
	public void invalidate() {
		// dodelijk
		// cells.clear();
		hoveredCell = null;
		clickedCell = null;
		super.invalidate();

	}

	// /////////// POINT FINDERS /////////////

	public Point findInitialPoint(double width, double height,
			List<Rectangle> cells) {
		Point pointCheck = new Point();
		pointCheck.setLocation(5, (height - 5));

		initialCell = new Point();

		for (Rectangle cell : cells) {

			if (cell.contains(pointCheck)) {
				initialCell.setLocation(cell.getCenterX(), cell.getCenterY());
			}
		}

		return initialCell;
	}

	// /////////// INIT && FIND PATH /////////////

	public void calculatePath() {

		if (addedItems.size() > 0) {
			resetBall();

			startButton.setEnabled(false);
			resetButton.setEnabled(false);
			testButton.setEnabled(false);
			button2.setEnabled(false);
			button4.setEnabled(false);

			repaint();

			int spinner = this.spinner;

			Algorithm algorithm;

			if (spinner == 0) {
				algorithm = Algorithm.Enumeratie;
			} else if (spinner == 1) {
				algorithm = Algorithm.Neighbour;
			} else {
				algorithm = Algorithm.third;
			}

			double size = cells.size();
			int forLoop = (int) (Math.round(size / 10));

			ArrayList<Point> coordinates;

			coordinates = new ArrayList<Point>();

			HashMap<Rectangle, List<Integer>> cache;
			cache = new HashMap<Rectangle, List<Integer>>();

			for (Integer inter : addedItems) {
				List<Integer> intink = new ArrayList<Integer>();
				intink.add(inter);
				for (Entry<Rectangle, List<Integer>> entry : ware.getCache()
						.entrySet()) {
					if (entry.getValue().equals(intink)) {
						coordinates.add(new Point((int) (entry.getKey()
								.getCenterX()), (int) (entry.getKey()
								.getCenterY())));
					}
				}
			}

			circels = algorithm.calculatePath(coordinates,
					findInitialPoint(this.width, this.height, cells));

			// System.out.println(circels);

			// begint met tekenen
			start = true;
			procesStop = false;
			button3.setText("Stop process");
			drawBall = true;

			// System.out.println(algorithm.toString());
		} else {
			drawBall = false;
			JOptionPane.showMessageDialog(this,
					" There must be atleast one product in the list.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		
		button3.setEnabled(true);

	}

	// /////////// COMBOBOX UPDATER /////////////

	public void updateComboBox() {

		itemListBox.removeAllItems();
		List<Integer> itemList = new ArrayList<Integer>();

		for (Rectangle rec : ware.getCache().keySet()) {
			for (Integer str : ware.getCache().get(rec)) {
				itemList.add(str);
			}

		}

		class MyIntComparable implements Comparator<Integer> {

			@Override
			public int compare(Integer o1, Integer o2) {
				return (o1 > o2 ? -1 : (o1 == o2 ? 0 : 1));
			}
		}
		Collections.sort(itemList, new MyIntComparable());
		for (Integer integer : itemList) {
			itemListBox.addItem(integer);
		}

	}

	// /////////// GETTERS && SETTERS /////////////

	public CustomRowColumnLabel getLabel() {
		return label;

	}

	public void setLabel(CustomRowColumnLabel label) {
		this.label = label;
	}

	public Warehouse getWare() {
		return ware;
	}

	public void setWare(Warehouse ware) {
		this.ware = ware;
	}

	public void resetList() {

		addedItems.clear();

		addedproductsLabel.setText("products");
		
		reDraw(columnCount, rowCount, spinner);
		
	}

	public void addProductToList(Integer inter) {
		// TODO Auto-generated method stub

		if (!addedItems.contains(inter)) {
			addedItems.add(inter);

			String input = "";

			int product = 0;

			for (Integer item : addedItems) {
				product++;
				input = input + product + ". product: " + item + "<br>";
			}
			input = "<html>" + input + "</html>";
			addedproductsLabel.setText(input);
		} else {
			JOptionPane.showMessageDialog(this, "Product " + inter
					+ " is already in the list.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public void testAlgorithms(boolean enumSelected, boolean nearestSelected,
			boolean heldSelected, Integer quant, Integer round) {

		boolean enumDo = false;
		boolean continueTest = true;
		boolean contineuRound = true;

		if (continueTest == true) {

			if (enumSelected == true || nearestSelected == true
					|| heldSelected == true) {

				if (round >= 5) {
					int n = JOptionPane
							.showConfirmDialog(
									this,
									"You've chosen "
											+ round
											+ " rounds, are you sure you want to continue? ",
									"Comple enumeration",
									JOptionPane.YES_NO_OPTION);
					if (n == 0) {
						contineuRound = true;
					} else {
						contineuRound = false;
					}
				}

				if (enumSelected == true && quant > 7 || enumSelected == true
						&& round > 1) {
					int n = JOptionPane
							.showConfirmDialog(
									this,
									"Complete enumeration takes a lof of time after \n7 "
											+ "products or more than 1 round, are you sure\n you want to continue?",
									"Comple enumeration",
									JOptionPane.YES_NO_OPTION);

					if (n == 0) {
						enumDo = true;
					} else {
						enumDo = false;
						continueTest = false;
					}

				} else {
					enumDo = true;
				}

				if (contineuRound == true && continueTest == true) {

					float distance1 = 0;
					float distance2 = 0;
					float distance3 = 0;

					long time1 = 0;
					long time2 = 0;
					long time3 = 0;

					ArrayList<Point> coordinates;

					coordinates = new ArrayList<Point>();

					double size = cells.size();

					ArrayList<Integer> integers = new ArrayList<Integer>();
					for (int j = 0; j < round; j++) {

						for (int i = 0; i < quant; i++) {

							Random rand = new Random();

							int n = rand.nextInt(((int) size));

							integers.add(n);

							while (integers.contains(n)) {
								n = rand.nextInt(((int) size));
							}

							Rectangle cell;
							try {
								cell = cells.get(n);
							} catch (IndexOutOfBoundsException io) {
								cell = cells.get(n - 1);
							}

							double x = cell.getCenterX();
							double y = cell.getCenterY();

							Point e = new Point();
							e.setLocation(x, y);

							coordinates.add(e);

						}
						Algorithm algorithm;

						ArrayList<Point> c1 = new ArrayList<Point>(coordinates);
						ArrayList<Point> c2 = new ArrayList<Point>(coordinates);
						ArrayList<Point> c3 = new ArrayList<Point>(coordinates);

						if (enumSelected == true && enumDo == true) {

							algorithm = Algorithm.Enumeratie;

							algorithm.calculatePath(
									c1,
									findInitialPoint(this.width, this.height,
											cells));
							// System.out.println("Enum: "+algorithm.returnDistance());
							distance1 = distance1 + algorithm.returnDistance();
							time1 = time1 + algorithm.returnTime();

						}
						if (nearestSelected == true) {

							algorithm = Algorithm.Neighbour;

							algorithm.calculatePath(
									c2,
									findInitialPoint(this.width, this.height,
											cells));
							// System.out.println("Nei: "+algorithm.returnDistance());
							distance2 = distance2 + algorithm.returnDistance();

							time2 = time2 + algorithm.returnTime();

						}

						if (heldSelected == true) {

							algorithm = Algorithm.third;
							algorithm.calculatePath(
									c3,
									findInitialPoint(this.width, this.height,
											cells));
							// System.out.println("3rd: "+algorithm.returnDistance());
							distance3 = distance3 + algorithm.returnDistance();
							time3 = time3 + algorithm.returnTime();
						}

					}

					String td1 = "";
					String td2 = "";
					String td3 = "";
					String td11 = "";
					String td12 = "";
					String td13 = "";
					String td21 = "";
					String td22 = "";
					String td23 = "";

					if (enumSelected == true) {
						if (round != 1) {
							distance1 = distance1 / round;
						}

						// System.out.println("distance1 :"+distance1);
						td1 = "<td>Complete enumeration</td>";
						td11 = "<td>" + distance1 + "</td>";
						td21 = "<td>" + time1 + "</td>";

					}
					if (nearestSelected == true) {
						if (round != 1) {
							distance2 = distance2 / round;
						}

						// System.out.println("distance2 :"+distance2);
						td2 = "<td>Nearest neighbour Algorithm</td>";
						td12 = "<td>" + distance2 + "</td>";
						td22 = "<td>" + time2 + "</td>";

					}
					if (heldSelected == true) {
						if (round != 1) {
							distance3 = distance3 / round;
						}
						// System.out.println("distance3 :"+distance3);
						td3 = "<td>3rd algorithm</td>";
						td13 = "<td>" + distance3 + "</td>";
						td23 = "<td>" + time3 + "</td>";

					}
					
					System.out.println(distance1+"("+time1+" ms)\n"+distance2+"("+time2+" ms)\n"+distance3+"("+time3+" ms)\n");

					JOptionPane.showMessageDialog(this, "<html>" + "<style>"
							+ "table, th, td {" + "border: 1px solid black;"
							+ "}" + "</style>" + "<tr>"
							+ "   <td>Algorithm</td>" + td1 + td2 + td3
							+ "</tr><tr>" + "    <td>Average distance</td>"
							+ td11 + td12 + td13 + "</tr><tr>"
							+ "    <td>Total calc. time</td>" + td21 + td22
							+ td23 + "</tr>" + "</table>"

							+ "</html>", "Output", JOptionPane.PLAIN_MESSAGE);
				

				}
				

				

			} else {
				JOptionPane.showMessageDialog(this,
						" You didn't select any algorithm", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
