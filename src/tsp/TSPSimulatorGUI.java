package tsp;

import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.border.*;
import javax.swing.event.*;


	
/**
 * @author Kubilay Durmusoglu & Anouk van der Veer
 */
public class TSPSimulatorGUI extends JFrame {
	public TSPSimulatorGUI() {
		
		initComponents();
	}


	private void stopButtonActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void paintPanelPropertyChange(PropertyChangeEvent e) {
		// TODO add your code here
	}

	private void applyButtonActionPerformed(ActionEvent e) {
		// drawGrid Heigth: 528, Width 526:
		
		int row = (Integer)rowsSpinner.getValue();
		int column = (Integer)columnsSpinner.getValue();
		drawGrid.invalidate();
		drawGrid.reDraw(column, row);
		repaint();
	}

	private void initComponents() {

		tabbedPanel = new JTabbedPane();
		orderPanel = new JPanel();
		productsPanel = new JPanel();
		settingsPanel = new JPanel();
		label1 = new JLabel();
		label2 = new JLabel();
		rowsSpinner = new JSpinner();
		columnsSpinner = new JSpinner();
		applyButton = new JButton();
		scrollPanel = new JScrollPane();
		informationPanel = new JPanel();
		standardLabel1 = new JLabel();
		customRowColumnLabel = new JLabel();
		reUseLabel1 = new JLabel();
		reUseLabel2 = new JLabel();
		customReUseNameLabel = new JLabel();
		customReUseAmountLabel = new JLabel();
		statusPanel = new JPanel();
		statusLabel = new JLabel();
		stopButton = new JButton();
		drawGrid = new GDrawGrid(5,5);
		
		
		

		//======== this ========
		setTitle("TSP-Simulator");
		setIconImage(((ImageIcon)UIManager.getIcon("FileView.computerIcon")).getImage());
		Container contentPane = getContentPane();
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



		//======== tabbedPanel ========
		{

			//======== orderPanel ========
			{

				// JFormDesigner evaluation mark
				orderPanel.setBorder(new javax.swing.border.CompoundBorder(
					new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
						"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
						javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
						java.awt.Color.red), orderPanel.getBorder())); orderPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


				GroupLayout orderPanelLayout = new GroupLayout(orderPanel);
				orderPanel.setLayout(orderPanelLayout);
				orderPanelLayout.setHorizontalGroup(
					orderPanelLayout.createParallelGroup()
						.addGap(0, 248, Short.MAX_VALUE)
				);
				orderPanelLayout.setVerticalGroup(
					orderPanelLayout.createParallelGroup()
						.addGap(0, 242, Short.MAX_VALUE)
				);
			}
			tabbedPanel.addTab("Order", orderPanel);
			tabbedPanel.setEnabledAt(0, false);

			//======== productsPanel ========
			{

				GroupLayout productsPanelLayout = new GroupLayout(productsPanel);
				productsPanel.setLayout(productsPanelLayout);
				productsPanelLayout.setHorizontalGroup(
					productsPanelLayout.createParallelGroup()
						.addGap(0, 248, Short.MAX_VALUE)
				);
				productsPanelLayout.setVerticalGroup(
					productsPanelLayout.createParallelGroup()
						.addGap(0, 242, Short.MAX_VALUE)
				);
			}
			tabbedPanel.addTab("Products", productsPanel);
			tabbedPanel.setEnabledAt(1, false);

			//======== settingsPanel ========
			{

				//---- label1 ----
				label1.setText("Rows:");
				label1.setHorizontalAlignment(SwingConstants.RIGHT);

				//---- label2 ----
				label2.setText("Columns:");
				label2.setHorizontalAlignment(SwingConstants.RIGHT);

				//---- rowsSpinner ----
				rowsSpinner.setModel(new SpinnerNumberModel(5, 0, null, 1));
	

				//---- columnsSpinner ----
				columnsSpinner.setModel(new SpinnerNumberModel(5, 0, null, 1));

				//---- applyButton ----
				applyButton.setText("Apply");
				applyButton.addActionListener(e -> applyButtonActionPerformed(e));

				GroupLayout settingsPanelLayout = new GroupLayout(settingsPanel);
				settingsPanel.setLayout(settingsPanelLayout);
				settingsPanelLayout.setHorizontalGroup(
					settingsPanelLayout.createParallelGroup()
						.addGroup(settingsPanelLayout.createSequentialGroup()
							.addGap(23, 23, 23)
							.addGroup(settingsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addGroup(settingsPanelLayout.createParallelGroup()
								.addComponent(rowsSpinner, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(columnsSpinner, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(133, Short.MAX_VALUE))
						.addGroup(GroupLayout.Alignment.TRAILING, settingsPanelLayout.createSequentialGroup()
							.addContainerGap(179, Short.MAX_VALUE)
							.addComponent(applyButton)
							.addContainerGap())
				);
				settingsPanelLayout.setVerticalGroup(
					settingsPanelLayout.createParallelGroup()
						.addGroup(settingsPanelLayout.createSequentialGroup()
							.addGap(22, 22, 22)
							.addGroup(settingsPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(label1)
								.addComponent(rowsSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(settingsPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(label2)
								.addComponent(columnsSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
							.addComponent(applyButton)
							.addContainerGap())
				);
			}
			tabbedPanel.addTab("Settings", settingsPanel);

			tabbedPanel.setSelectedIndex(2);
		}

		//======== scrollPanel ========
		{
			scrollPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

			//======== informationPanel ========
			{

				//---- standardLabel1 ----
				standardLabel1.setText("Shelf contents:");
				standardLabel1.setFont(standardLabel1.getFont().deriveFont(standardLabel1.getFont().getStyle() | Font.BOLD, standardLabel1.getFont().getSize() + 3f));

				//---- customRowColumnLabel ----
				customRowColumnLabel.setText("(ROW COLUM)");

				//---- reUseLabel1 ----
				reUseLabel1.setText("Product name:");
				reUseLabel1.setHorizontalAlignment(SwingConstants.RIGHT);

				//---- reUseLabel2 ----
				reUseLabel2.setText("Amount:");
				reUseLabel2.setHorizontalAlignment(SwingConstants.RIGHT);

				//---- customReUseNameLabel ----
				customReUseNameLabel.setText("Name");

				//---- customReUseAmountLabel ----
				customReUseAmountLabel.setText("Amount");

				GroupLayout informationPanelLayout = new GroupLayout(informationPanel);
				informationPanel.setLayout(informationPanelLayout);
				informationPanelLayout.setHorizontalGroup(
					informationPanelLayout.createParallelGroup()
						.addGroup(informationPanelLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(informationPanelLayout.createParallelGroup()
								.addGroup(informationPanelLayout.createSequentialGroup()
									.addGap(110, 110, 110)
									.addComponent(customRowColumnLabel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
								.addComponent(standardLabel1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
								.addGroup(informationPanelLayout.createSequentialGroup()
									.addGroup(informationPanelLayout.createParallelGroup()
										.addComponent(reUseLabel1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
										.addComponent(reUseLabel2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addGroup(informationPanelLayout.createParallelGroup()
										.addComponent(customReUseNameLabel, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
										.addComponent(customReUseAmountLabel, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))))
							.addContainerGap(41, Short.MAX_VALUE))
				);
				informationPanelLayout.setVerticalGroup(
					informationPanelLayout.createParallelGroup()
						.addGroup(informationPanelLayout.createSequentialGroup()
							.addGap(32, 32, 32)
							.addGroup(informationPanelLayout.createParallelGroup()
								.addGroup(informationPanelLayout.createSequentialGroup()
									.addGap(5, 5, 5)
									.addComponent(customRowColumnLabel))
								.addComponent(standardLabel1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addGap(30, 30, 30)
							.addGroup(informationPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(reUseLabel1)
								.addComponent(customReUseNameLabel))
							.addGap(1, 1, 1)
							.addGroup(informationPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(reUseLabel2)
								.addComponent(customReUseAmountLabel))
							.addContainerGap(83, Short.MAX_VALUE))
				);
			}
			scrollPanel.setViewportView(informationPanel);
		}

		//======== statusPanel ========
		{
			statusPanel.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
			statusPanel.setBackground(new Color(0, 255, 51));

			//---- statusLabel ----
			statusLabel.setText("Status Label");
			statusLabel.setHorizontalAlignment(SwingConstants.CENTER);

			GroupLayout statusPanelLayout = new GroupLayout(statusPanel);
			statusPanel.setLayout(statusPanelLayout);
			statusPanelLayout.setHorizontalGroup(
				statusPanelLayout.createParallelGroup()
					.addGroup(statusPanelLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(statusLabel, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
						.addContainerGap())
			);
			statusPanelLayout.setVerticalGroup(
				statusPanelLayout.createParallelGroup()
					.addGroup(statusPanelLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(statusLabel)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
		}

		//---- stopButton ----
		stopButton.setText("Stop the process");
		stopButton.addActionListener(e -> stopButtonActionPerformed(e));

		//======== paintPanel ========
		{
			drawGrid.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));

			GroupLayout paintPanelLayout = new GroupLayout(drawGrid);
			drawGrid.setLayout(paintPanelLayout);
			paintPanelLayout.setHorizontalGroup(
				paintPanelLayout.createParallelGroup()
					.addGap(0, 520, Short.MAX_VALUE)
			);
			paintPanelLayout.setVerticalGroup(
				paintPanelLayout.createParallelGroup()
					.addGap(0, 0, Short.MAX_VALUE)
			);
		}

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(drawGrid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addComponent(statusPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(stopButton))
						.addComponent(scrollPanel, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
						.addComponent(tabbedPanel, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
					.addContainerGap())
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(23, 23, 23)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addComponent(drawGrid, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addComponent(tabbedPanel, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(scrollPanel)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(contentPaneLayout.createParallelGroup()
								.addComponent(stopButton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
								.addComponent(statusPanel, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(21, 21, 21))
		);
		setSize(825, 600);
		setLocationRelativeTo(getOwner());
	}

	private JTabbedPane tabbedPanel;
	private JPanel orderPanel;
	private JPanel productsPanel;
	private JPanel settingsPanel;
	private JLabel label1;
	private JLabel label2;
	private JSpinner rowsSpinner;
	private JSpinner columnsSpinner;
	private JButton applyButton;
	private JScrollPane scrollPanel;
	private JPanel informationPanel;
	private JLabel standardLabel1;
	private JLabel customRowColumnLabel;
	private JLabel reUseLabel1;
	private JLabel reUseLabel2;
	private JLabel customReUseNameLabel;
	private JLabel customReUseAmountLabel;
	private JPanel statusPanel;
	private JLabel statusLabel;
	private JButton stopButton;
	private GDrawGrid drawGrid;

}
