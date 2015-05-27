package tsp;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Kubilay Durmusoglu & Anouk van der Veer
 */
public class TSPSimulatorGUI extends JFrame {
	public TSPSimulatorGUI() {
		initComponents();
	}

	private void testButtonActionPerformed(ActionEvent e) {
		// TODO add your code here
		panel1.testAlgorithms(enumBox.isSelected(), nearestBox.isSelected(), heldBox.isSelected(), (Integer)quantitySpinner.getValue(), (Integer)roundSpinner.getValue() );
		
		
	}

	private void startButtonActionPerformed(ActionEvent e) {
		// TODO add your code here
		panel1.calculatePath();
	}

	private void resetButtonActionPerformed(ActionEvent e) {
		// TODO add your code here
		panel1.resetList();
	}

	private void AddButtonActionPerformed(ActionEvent e) {
		// TODO add your code here
		panel1.addProductToList(Integer.parseInt(itemListBox.getSelectedItem()
				.toString()));
	}

	private void saveButtonActionPerformed(ActionEvent e) {
		// TODO add your code here

		int row = (Integer) rowSpinner.getValue();
		int column = (Integer) columnSpinner.getValue();
		int indexComboBox = comboBox.getSelectedIndex();

		panel1.reDraw(column, row, indexComboBox);
		
		JOptionPane.showMessageDialog(this,
			    "Settings has been saved.");

		repaint();

	}

	private void StopActionPerformed(ActionEvent e) {
		// TODO add your code here
		panel1.processStop();
	}

	private void initComponents() {

		productsLabel = new ProductInfoLabel();
		rcLabel = new CustomRowColumnLabel();
		itemListBox = new JComboBox();
		addedproductsLabel = new JLabel();
		tabbedPane1 = new JTabbedPane();
		testPanel = new JPanel();
		enumBox = new JCheckBox();
		nearestBox = new JCheckBox();
		heldBox = new JCheckBox();
		label1 = new JLabel();
		testButton = new JButton();
		label2 = new JLabel();
		quantitySpinner = new JSpinner();
		label3 = new JLabel();
		roundSpinner = new JSpinner();
		customPanel = new JPanel();
		startButton = new JButton();
		resetButton = new JButton();
		button4 = new JButton();
		scrollPane2 = new JScrollPane();
		panel7 = new JPanel();
		label13 = new JLabel();
		settingsPanel = new JPanel();
		button2 = new JButton();
		label9 = new JLabel();
		label10 = new JLabel();
		rowSpinner = new JSpinner();
		columnSpinner = new JSpinner();
		label11 = new JLabel();
		comboBox = new JComboBox<>();
		scrollPane1 = new JScrollPane();
		panel5 = new JPanel();
		label5 = new JLabel();
		label7 = new JLabel();
		button3 = new JButton();
		panel6 = new JPanel();
		label12 = new JLabel();
		panel1 = new GDrawGrid(5, 5, rcLabel, productsLabel, itemListBox,
				addedproductsLabel, resetButton, testButton, button2, button4,startButton,button3, panel6, label12);
	

		// ======== this ========
		setTitle("TSP-Simulator");
		setIconImage(((ImageIcon) UIManager.getIcon("FileView.computerIcon"))
				.getImage());
		setResizable(false);
		Container contentPane = getContentPane();

		// ======== panel1 ========
		{
			panel1.setBorder(new CompoundBorder(new BevelBorder(
					BevelBorder.LOWERED), null));

			GroupLayout panel1Layout = new GroupLayout(panel1);
			panel1.setLayout(panel1Layout);
			panel1Layout.setHorizontalGroup(panel1Layout.createParallelGroup()
					.addGap(0, 596, Short.MAX_VALUE));
			panel1Layout.setVerticalGroup(panel1Layout.createParallelGroup()
					.addGap(0, 596, Short.MAX_VALUE));
		}

		// ======== tabbedPane1 ========
		{

			// ======== testPanel ========
			{

				// ---- enumBox ----
				enumBox.setText("Complete Enumeration");

				// ---- NearestBox ----
				nearestBox.setText("Nearest Neighbour Algorithm");

				// ---- heldBox ----
				heldBox.setText("3rd Algorithm");

				// ---- label1 ----
				label1.setText("Algorithms:");

				// ---- testButton ----
				testButton.setText("Test");
				testButton.addActionListener(e -> testButtonActionPerformed(e));

				// ---- label2 ----
				label2.setText("Quantity of products:");

				// ---- quantitySpinner ----
				quantitySpinner.setModel(new SpinnerNumberModel(1, 1, null, 1));

				// ---- label3 ----
				label3.setText("Rounds:");

				// ---- RoundSpinner ----
				roundSpinner.setModel(new SpinnerNumberModel(1, 1, null, 1));

				GroupLayout testPanelLayout = new GroupLayout(testPanel);
				testPanel.setLayout(testPanelLayout);
				testPanelLayout
						.setHorizontalGroup(testPanelLayout
								.createParallelGroup()
								.addGroup(
										testPanelLayout
												.createSequentialGroup()
												.addContainerGap()
												.addGroup(
														testPanelLayout
																.createParallelGroup()
																.addComponent(
																		heldBox)
																.addComponent(
																		nearestBox)
																.addComponent(
																		enumBox)
																.addComponent(
																		label1)
																.addGroup(
																		testPanelLayout
																				.createSequentialGroup()
																				.addGroup(
																						testPanelLayout
																								.createParallelGroup()
																								.addComponent(
																										label2)
																								.addComponent(
																										label3))
																				.addPreferredGap(
																						LayoutStyle.ComponentPlacement.UNRELATED)
																				.addGroup(
																						testPanelLayout
																								.createParallelGroup()
																								.addComponent(
																										quantitySpinner,
																										GroupLayout.PREFERRED_SIZE,
																										44,
																										GroupLayout.PREFERRED_SIZE)
																								.addComponent(
																										roundSpinner,
																										GroupLayout.PREFERRED_SIZE,
																										44,
																										GroupLayout.PREFERRED_SIZE))))
												.addContainerGap(31,
														Short.MAX_VALUE))
								.addGroup(
										GroupLayout.Alignment.TRAILING,
										testPanelLayout
												.createSequentialGroup()
												.addContainerGap(141,
														Short.MAX_VALUE)
												.addComponent(testButton)
												.addContainerGap()));
				testPanelLayout
						.setVerticalGroup(testPanelLayout
								.createParallelGroup()
								.addGroup(
										testPanelLayout
												.createSequentialGroup()
												.addGap(15, 15, 15)
												.addComponent(label1)
												.addPreferredGap(
														LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(enumBox)
												.addPreferredGap(
														LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(nearestBox)
												.addPreferredGap(
														LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(heldBox)
												.addGap(18, 18, 18)
												.addGroup(
														testPanelLayout
																.createParallelGroup(
																		GroupLayout.Alignment.BASELINE)
																.addComponent(
																		label2)
																.addComponent(
																		quantitySpinner,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(
														LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(
														testPanelLayout
																.createParallelGroup(
																		GroupLayout.Alignment.BASELINE)
																.addComponent(
																		label3)
																.addComponent(
																		roundSpinner,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(
														LayoutStyle.ComponentPlacement.RELATED,
														43, Short.MAX_VALUE)
												.addComponent(testButton)
												.addContainerGap()));
			}
			tabbedPane1.addTab("Test Algorithms", testPanel);

			// ======== customPanel ========
			{

				// ---- startButton ----
				startButton.setText("Start");
				startButton
						.addActionListener(e -> startButtonActionPerformed(e));

				// ---- resetButton ----
				resetButton.setText("Reset");
				resetButton
						.addActionListener(e -> resetButtonActionPerformed(e));

				// ---- button4 ----
				button4.setText("Add");
				button4.addActionListener(e -> AddButtonActionPerformed(e));

				// ======== scrollPane2 ========
				{
					scrollPane2
							.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

					// ======== panel7 ========
					{

						// ---- label13 ----
						label13.setText("Added product(s):");
						label13.setFont(label13.getFont().deriveFont(
								label13.getFont().getStyle() | Font.BOLD,
								label13.getFont().getSize() + 1f));

						// ---- addedproductsLabel ----
						addedproductsLabel.setText("products");

						GroupLayout panel7Layout = new GroupLayout(panel7);
						panel7.setLayout(panel7Layout);
						panel7Layout
								.setHorizontalGroup(panel7Layout
										.createParallelGroup()
										.addGroup(
												panel7Layout
														.createSequentialGroup()
														.addContainerGap()
														.addGroup(
																panel7Layout
																		.createParallelGroup()
																		.addComponent(
																				label13)
																		.addComponent(
																				addedproductsLabel))
														.addContainerGap(152,
																Short.MAX_VALUE)));
						panel7Layout
								.setVerticalGroup(panel7Layout
										.createParallelGroup()
										.addGroup(
												panel7Layout
														.createSequentialGroup()
														.addContainerGap()
														.addComponent(label13)
														.addPreferredGap(
																LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(
																addedproductsLabel)
														.addContainerGap(105,
																Short.MAX_VALUE)));
					}
					scrollPane2.setViewportView(panel7);
				}

				GroupLayout customPanelLayout = new GroupLayout(customPanel);
				customPanel.setLayout(customPanelLayout);
				customPanelLayout
						.setHorizontalGroup(customPanelLayout
								.createParallelGroup()
								.addGroup(
										customPanelLayout
												.createSequentialGroup()
												.addContainerGap()
												.addGroup(
														customPanelLayout
																.createParallelGroup()
																.addComponent(
																		scrollPane2,
																		GroupLayout.PREFERRED_SIZE,
																		184,
																		GroupLayout.PREFERRED_SIZE)
																.addGroup(
																		customPanelLayout
																				.createSequentialGroup()
																				.addGroup(
																						customPanelLayout
																								.createParallelGroup(
																										GroupLayout.Alignment.TRAILING)
																								.addComponent(
																										itemListBox,
																										GroupLayout.Alignment.LEADING)
																								.addGroup(
																										customPanelLayout
																												.createSequentialGroup()
																												.addGap(0,
																														0,
																														Short.MAX_VALUE)
																												.addComponent(
																														resetButton)))
																				.addPreferredGap(
																						LayoutStyle.ComponentPlacement.RELATED)
																				.addGroup(
																						customPanelLayout
																								.createParallelGroup(
																										GroupLayout.Alignment.LEADING,
																										false)
																								.addComponent(
																										startButton,
																										GroupLayout.DEFAULT_SIZE,
																										GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)
																								.addComponent(
																										button4,
																										GroupLayout.DEFAULT_SIZE,
																										GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE))))
												.addContainerGap()));
				customPanelLayout
						.setVerticalGroup(customPanelLayout
								.createParallelGroup()
								.addGroup(
										GroupLayout.Alignment.TRAILING,
										customPanelLayout
												.createSequentialGroup()
												.addContainerGap()
												.addGroup(
														customPanelLayout
																.createParallelGroup(
																		GroupLayout.Alignment.BASELINE)
																.addComponent(
																		itemListBox,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(
																		button4))
												.addPreferredGap(
														LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(
														scrollPane2,
														GroupLayout.DEFAULT_SIZE,
														157, Short.MAX_VALUE)
												.addPreferredGap(
														LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(
														customPanelLayout
																.createParallelGroup(
																		GroupLayout.Alignment.BASELINE)
																.addComponent(
																		startButton)
																.addComponent(
																		resetButton))
												.addContainerGap()));
			}
			tabbedPane1.addTab("Custom Order", customPanel);

			// ======== settingsPanel ========
			{

				// ---- button2 ----
				button2.setText("Save");
				button2.addActionListener(e -> saveButtonActionPerformed(e));

				// ---- label9 ----
				label9.setText("Rows:");
				label9.setHorizontalAlignment(SwingConstants.RIGHT);
				label9.setFont(label9.getFont().deriveFont(
						label9.getFont().getStyle() | Font.BOLD,
						label9.getFont().getSize() + 1f));

				// ---- label10 ----
				label10.setText("Columns:");
				label10.setHorizontalAlignment(SwingConstants.RIGHT);
				label10.setFont(label10.getFont().deriveFont(
						label10.getFont().getStyle() | Font.BOLD,
						label10.getFont().getSize() + 1f));

				// ---- rowSpinner ----
				rowSpinner.setModel(new SpinnerNumberModel(5, 5, null, 1));

				// ---- columnsLabel ----
				columnSpinner.setModel(new SpinnerNumberModel(5, 5, null, 1));

				// ---- label11 ----
				label11.setText("Algorithm:");
				label11.setFont(label11.getFont().deriveFont(
						label11.getFont().getStyle() | Font.BOLD,
						label11.getFont().getSize() + 1f));

				// ---- comboBox ----
				comboBox.setMaximumRowCount(3);
				comboBox.setModel(new DefaultComboBoxModel<>(new String[] {
						"Complete enumeration", "Nearest neighbour Algorithm",
						"3rd Algorithm" }));

				GroupLayout settingsPanelLayout = new GroupLayout(settingsPanel);
				settingsPanel.setLayout(settingsPanelLayout);
				settingsPanelLayout
						.setHorizontalGroup(settingsPanelLayout
								.createParallelGroup()
								.addGroup(
										settingsPanelLayout
												.createSequentialGroup()
												.addContainerGap()
												.addGroup(
														settingsPanelLayout
																.createParallelGroup()
																.addGroup(
																		GroupLayout.Alignment.TRAILING,
																		settingsPanelLayout
																				.createSequentialGroup()
																				.addGap(0,
																						127,
																						Short.MAX_VALUE)
																				.addComponent(
																						button2))
																.addGroup(
																		settingsPanelLayout
																				.createSequentialGroup()
																				.addGroup(
																						settingsPanelLayout
																								.createParallelGroup()
																								.addGroup(
																										settingsPanelLayout
																												.createSequentialGroup()
																												.addGroup(
																														settingsPanelLayout
																																.createParallelGroup()
																																.addComponent(
																																		label9,
																																		GroupLayout.PREFERRED_SIZE,
																																		56,
																																		GroupLayout.PREFERRED_SIZE)
																																.addComponent(
																																		label10,
																																		GroupLayout.Alignment.TRAILING)
																																.addComponent(
																																		label11,
																																		GroupLayout.Alignment.TRAILING))
																												.addPreferredGap(
																														LayoutStyle.ComponentPlacement.UNRELATED)
																												.addGroup(
																														settingsPanelLayout
																																.createParallelGroup()
																																.addComponent(
																																		rowSpinner,
																																		GroupLayout.PREFERRED_SIZE,
																																		40,
																																		GroupLayout.PREFERRED_SIZE)
																																.addComponent(
																																		columnSpinner,
																																		GroupLayout.PREFERRED_SIZE,
																																		40,
																																		GroupLayout.PREFERRED_SIZE)))
																								.addComponent(
																										comboBox,
																										GroupLayout.PREFERRED_SIZE,
																										148,
																										GroupLayout.PREFERRED_SIZE))
																				.addGap(0,
																						36,
																						Short.MAX_VALUE)))
												.addContainerGap()));
				settingsPanelLayout
						.setVerticalGroup(settingsPanelLayout
								.createParallelGroup()
								.addGroup(
										GroupLayout.Alignment.TRAILING,
										settingsPanelLayout
												.createSequentialGroup()
												.addGap(27, 27, 27)
												.addGroup(
														settingsPanelLayout
																.createParallelGroup(
																		GroupLayout.Alignment.BASELINE)
																.addComponent(
																		label9)
																.addComponent(
																		rowSpinner,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(
														LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(
														settingsPanelLayout
																.createParallelGroup(
																		GroupLayout.Alignment.BASELINE)
																.addComponent(
																		columnSpinner,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(
																		label10))
												.addGap(18, 18, 18)
												.addComponent(label11)
												.addPreferredGap(
														LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(
														comboBox,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(
														LayoutStyle.ComponentPlacement.RELATED,
														76, Short.MAX_VALUE)
												.addComponent(button2)
												.addContainerGap()));
			}
			tabbedPane1.addTab("Settings", settingsPanel);

			tabbedPane1.setSelectedIndex(1);
		}

		// ======== scrollPane1 ========
		{
			scrollPane1
					.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

			// ======== panel5 ========
			{

				// ---- label5 ----
				label5.setText("Shelf contents:");
				label5.setFont(label5.getFont().deriveFont(
						label5.getFont().getStyle() | Font.BOLD,
						label5.getFont().getSize() + 4f));

				// ---- rcLabel ----
				rcLabel.setText("Row & Column");

				// ---- label7 ----
				label7.setText("Product(s):");
				label7.setFont(label7.getFont().deriveFont(
						label7.getFont().getStyle() | Font.BOLD,
						label7.getFont().getSize() + 4f));

				// ---- productsLabel ----
				productsLabel.setText("products");

				GroupLayout panel5Layout = new GroupLayout(panel5);
				panel5.setLayout(panel5Layout);
				panel5Layout
						.setHorizontalGroup(panel5Layout
								.createParallelGroup()
								.addGroup(
										panel5Layout
												.createSequentialGroup()
												.addContainerGap()
												.addGroup(
														panel5Layout
																.createParallelGroup()
																.addComponent(
																		label5)
																.addComponent(
																		rcLabel)
																.addComponent(
																		label7)
																.addComponent(
																		productsLabel))
												.addContainerGap(201,
														Short.MAX_VALUE)));
				panel5Layout
						.setVerticalGroup(panel5Layout
								.createParallelGroup()
								.addGroup(
										panel5Layout
												.createSequentialGroup()
												.addContainerGap()
												.addComponent(label5)
												.addPreferredGap(
														LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(rcLabel)
												.addGap(34, 34, 34)
												.addComponent(label7)
												.addPreferredGap(
														LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(productsLabel)
												.addContainerGap(137,
														Short.MAX_VALUE)));
			}
			scrollPane1.setViewportView(panel5);
		}

		// ---- button3 ----
		button3.setText("Stop process");
		button3.addActionListener(e -> StopActionPerformed(e));

		// ======== panel6 ========
		{
			panel6.setBackground(new Color(51, 255, 51));

			// ---- label12 ----
			label12.setText("Status");
			label12.setHorizontalAlignment(SwingConstants.CENTER);

			GroupLayout panel6Layout = new GroupLayout(panel6);
			panel6.setLayout(panel6Layout);
			panel6Layout.setHorizontalGroup(panel6Layout.createParallelGroup()
					.addComponent(label12, GroupLayout.DEFAULT_SIZE,
							GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
			panel6Layout.setVerticalGroup(panel6Layout.createParallelGroup()
					.addComponent(label12, GroupLayout.Alignment.TRAILING,
							GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE));
		}

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout
				.setHorizontalGroup(contentPaneLayout
						.createParallelGroup()
						.addGroup(
								GroupLayout.Alignment.TRAILING,
								contentPaneLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(panel1,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												contentPaneLayout
														.createParallelGroup()
														.addGroup(
																contentPaneLayout
																		.createSequentialGroup()
																		.addComponent(
																				button3)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				panel6,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE))
														.addComponent(
																tabbedPane1,
																GroupLayout.PREFERRED_SIZE,
																209,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																scrollPane1,
																GroupLayout.PREFERRED_SIZE,
																209,
																GroupLayout.PREFERRED_SIZE))
										.addGap(4, 14, Short.MAX_VALUE)));
		contentPaneLayout
				.setVerticalGroup(contentPaneLayout
						.createParallelGroup()
						.addGroup(
								contentPaneLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												contentPaneLayout
														.createParallelGroup()
														.addGroup(
																contentPaneLayout
																		.createSequentialGroup()
																		.addComponent(
																				tabbedPane1,
																				GroupLayout.PREFERRED_SIZE,
																				291,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				scrollPane1,
																				GroupLayout.PREFERRED_SIZE,
																				252,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				contentPaneLayout
																						.createParallelGroup()
																						.addComponent(
																								button3,
																								GroupLayout.PREFERRED_SIZE,
																								45,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								panel6,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)))
														.addComponent(
																panel1,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap(8, Short.MAX_VALUE)));
		pack();
		setLocationRelativeTo(getOwner());

	}

	private GDrawGrid panel1;
	private JTabbedPane tabbedPane1;
	private JPanel testPanel;
	private JCheckBox enumBox;
	private JCheckBox nearestBox;
	private JCheckBox heldBox;
	private JLabel label1;
	private JButton testButton;
	private JLabel label2;
	private JSpinner quantitySpinner;
	private JLabel label3;
	private JSpinner roundSpinner;
	private JPanel customPanel;
	private JButton startButton;
	private JButton resetButton;
	private JComboBox itemListBox;
	private JButton button4;
	private JScrollPane scrollPane2;
	private JPanel panel7;
	private JLabel label13;
	private JLabel addedproductsLabel;
	private JPanel settingsPanel;
	private JButton button2;
	private JLabel label9;
	private JLabel label10;
	private JSpinner rowSpinner;
	private JSpinner columnSpinner;
	private JLabel label11;
	private JComboBox<String> comboBox;
	private JScrollPane scrollPane1;
	private JPanel panel5;
	private JLabel label5;
	private CustomRowColumnLabel rcLabel;
	private JLabel label7;
	private ProductInfoLabel productsLabel;
	private JButton button3;
	private JPanel panel6;
	private JLabel label12;
	// JFormDesigner - End of variables declaration //GEN-END:variables
}
