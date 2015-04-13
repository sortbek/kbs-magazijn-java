package tsp;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

/**
 * @author Kubilay Durmusoglu & Anouk van der Veer
 */
public class TSPSimulatorGUI extends JFrame {
	public TSPSimulatorGUI() {
		initComponents();
	}

	private void rowsSpinnerStateChanged(ChangeEvent e) {
		// TODO add your code here
		
	}

	private void columnsSpinnerStateChanged(ChangeEvent e) {
		// TODO add your code here
	}

	private void stopButtonActionPerformed(ActionEvent e) {
		// TODO add your code here
	}
	

	private void initComponents() {

		paintPanel = new JLayeredPane();
		tabbedPanel = new JTabbedPane();
		orderPanel = new JPanel();
		productsPanel = new JPanel();
		settingsPanel = new JPanel();
		label1 = new JLabel();
		label2 = new JLabel();
		rowsSpinner = new JSpinner();
		columnsSpinner = new JSpinner();
		scrollPanel = new JScrollPane();
		informationPanel = new JLayeredPane();
		standardLabel1 = new JLabel();
		customRowColumnLabel = new JLabel();
		reUseLabel1 = new JLabel();
		reUseLabel2 = new JLabel();
		customReUseNameLabel = new JLabel();
		customReUseAmountLabel = new JLabel();
		statusPanel = new JPanel();
		statusLabel = new JLabel();
		stopButton = new JButton();

		// ======== this ========
	
		setTitle("TSP-Simulator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		setIconImage(((ImageIcon) UIManager.getIcon("FileView.computerIcon"))
				.getImage());
		Container contentPane = getContentPane();

		// ======== paintPanel ========
		{
			paintPanel.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
		}

		// ======== tabbedPanel ========
		{

			// ======== orderPanel ========
			{

				// JFormDesigner evaluation mark
				orderPanel.setBorder(new javax.swing.border.CompoundBorder(
						new javax.swing.border.TitledBorder(
								new javax.swing.border.EmptyBorder(0, 0, 0, 0),
								"JFormDesigner Evaluation",
								javax.swing.border.TitledBorder.CENTER,
								javax.swing.border.TitledBorder.BOTTOM,
								new java.awt.Font("Dialog", java.awt.Font.BOLD,
										12), java.awt.Color.red), orderPanel
								.getBorder()));
				orderPanel
						.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
							public void propertyChange(
									java.beans.PropertyChangeEvent e) {
								if ("border".equals(e.getPropertyName()))
									throw new RuntimeException();
							}
						});

				GroupLayout orderPanelLayout = new GroupLayout(orderPanel);
				orderPanel.setLayout(orderPanelLayout);
				orderPanelLayout.setHorizontalGroup(orderPanelLayout
						.createParallelGroup().addGap(0, 258, Short.MAX_VALUE));
				orderPanelLayout.setVerticalGroup(orderPanelLayout
						.createParallelGroup().addGap(0, 242, Short.MAX_VALUE));
			}
			tabbedPanel.addTab("Order", orderPanel);
			tabbedPanel.setEnabledAt(0, false);

			// ======== productsPanel ========
			{

				GroupLayout productsPanelLayout = new GroupLayout(productsPanel);
				productsPanel.setLayout(productsPanelLayout);
				productsPanelLayout.setHorizontalGroup(productsPanelLayout
						.createParallelGroup().addGap(0, 258, Short.MAX_VALUE));
				productsPanelLayout.setVerticalGroup(productsPanelLayout
						.createParallelGroup().addGap(0, 242, Short.MAX_VALUE));
			}
			tabbedPanel.addTab("Products", productsPanel);
			tabbedPanel.setEnabledAt(1, false);

			// ======== settingsPanel ========
			{

				// ---- label1 ----
				label1.setText("Rows:");
				label1.setHorizontalAlignment(SwingConstants.RIGHT);

				// ---- label2 ----
				label2.setText("Columns:");
				label2.setHorizontalAlignment(SwingConstants.RIGHT);

				// ---- rowsSpinner ----
				rowsSpinner.setModel(new SpinnerNumberModel(0, 0, null, 1));
				rowsSpinner.addChangeListener(e -> rowsSpinnerStateChanged(e));

				// ---- columnsSpinner ----
				columnsSpinner.setModel(new SpinnerNumberModel(0, 0, null, 1));
				columnsSpinner
						.addChangeListener(e -> columnsSpinnerStateChanged(e));

				GroupLayout settingsPanelLayout = new GroupLayout(settingsPanel);
				settingsPanel.setLayout(settingsPanelLayout);
				settingsPanelLayout
						.setHorizontalGroup(settingsPanelLayout
								.createParallelGroup()
								.addGroup(
										settingsPanelLayout
												.createSequentialGroup()
												.addGap(23, 23, 23)
												.addGroup(
														settingsPanelLayout
																.createParallelGroup(
																		GroupLayout.Alignment.LEADING,
																		false)
																.addComponent(
																		label2,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(
																		label1,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE))
												.addPreferredGap(
														LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(
														settingsPanelLayout
																.createParallelGroup()
																.addComponent(
																		rowsSpinner,
																		GroupLayout.PREFERRED_SIZE,
																		38,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(
																		columnsSpinner,
																		GroupLayout.PREFERRED_SIZE,
																		38,
																		GroupLayout.PREFERRED_SIZE))
												.addContainerGap(143,
														Short.MAX_VALUE)));
				settingsPanelLayout
						.setVerticalGroup(settingsPanelLayout
								.createParallelGroup()
								.addGroup(
										settingsPanelLayout
												.createSequentialGroup()
												.addGap(22, 22, 22)
												.addGroup(
														settingsPanelLayout
																.createParallelGroup(
																		GroupLayout.Alignment.BASELINE)
																.addComponent(
																		label1)
																.addComponent(
																		rowsSpinner,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(
														LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(
														settingsPanelLayout
																.createParallelGroup(
																		GroupLayout.Alignment.BASELINE)
																.addComponent(
																		label2)
																.addComponent(
																		columnsSpinner,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE))
												.addContainerGap()));
			}
			tabbedPanel.addTab("Settings", settingsPanel);

			tabbedPanel.setSelectedIndex(2);
		}

		// ======== scrollPanel ========
		{
			scrollPanel
					.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

			// ======== informationPanel ========
			{

				// ---- standardLabel1 ----
				standardLabel1.setText("Shelf contents:");
				standardLabel1.setFont(standardLabel1.getFont().deriveFont(
						standardLabel1.getFont().getStyle() | Font.BOLD,
						standardLabel1.getFont().getSize() + 3f));
				informationPanel
						.add(standardLabel1, JLayeredPane.DEFAULT_LAYER);
				standardLabel1.setBounds(5, 5, 115, 20);

				// ---- customRowColumnLabel ----
				customRowColumnLabel.setText("(ROW COLUM)");
				informationPanel.add(customRowColumnLabel,
						JLayeredPane.DEFAULT_LAYER);
				customRowColumnLabel.setBounds(115, 10, 95,
						customRowColumnLabel.getPreferredSize().height);

				// ---- reUseLabel1 ----
				reUseLabel1.setText("Product name:");
				reUseLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
				informationPanel.add(reUseLabel1, JLayeredPane.DEFAULT_LAYER);
				reUseLabel1.setBounds(25, 55, 95,
						reUseLabel1.getPreferredSize().height);

				// ---- reUseLabel2 ----
				reUseLabel2.setText("Amount:");
				reUseLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
				informationPanel.add(reUseLabel2, JLayeredPane.DEFAULT_LAYER);
				reUseLabel2.setBounds(25, 70, 95,
						reUseLabel2.getPreferredSize().height);

				// ---- customReUseNameLabel ----
				customReUseNameLabel.setText("Name");
				informationPanel.add(customReUseNameLabel,
						JLayeredPane.DEFAULT_LAYER);
				customReUseNameLabel.setBounds(125, 55, 105,
						customReUseNameLabel.getPreferredSize().height);

				// ---- customReUseAmountLabel ----
				customReUseAmountLabel.setText("Amount");
				informationPanel.add(customReUseAmountLabel,
						JLayeredPane.DEFAULT_LAYER);
				customReUseAmountLabel.setBounds(125, 70, 105,
						customReUseAmountLabel.getPreferredSize().height);
			}
			scrollPanel.setViewportView(informationPanel);
		}

		// ======== statusPanel ========
		{
			statusPanel.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
			statusPanel.setBackground(new Color(0, 255, 51));

			// ---- statusLabel ----
			statusLabel.setText("Status Label");
			statusLabel.setHorizontalAlignment(SwingConstants.CENTER);

			GroupLayout statusPanelLayout = new GroupLayout(statusPanel);
			statusPanel.setLayout(statusPanelLayout);
			statusPanelLayout
					.setHorizontalGroup(statusPanelLayout.createParallelGroup()
							.addGroup(
									statusPanelLayout
											.createSequentialGroup()
											.addContainerGap()
											.addComponent(statusLabel,
													GroupLayout.DEFAULT_SIZE,
													83, Short.MAX_VALUE)
											.addContainerGap()));
			statusPanelLayout.setVerticalGroup(statusPanelLayout
					.createParallelGroup().addGroup(
							statusPanelLayout
									.createSequentialGroup()
									.addContainerGap()
									.addComponent(statusLabel)
									.addContainerGap(GroupLayout.DEFAULT_SIZE,
											Short.MAX_VALUE)));
		}

		// ---- stopButton ----
		stopButton.setText("Stop the process");
		stopButton.addActionListener(e -> stopButtonActionPerformed(e));
		stopButton.setBackground(Color.RED);
		

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout
				.setHorizontalGroup(contentPaneLayout
						.createParallelGroup()
						.addGroup(
								contentPaneLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(paintPanel,
												GroupLayout.PREFERRED_SIZE,
												520, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												contentPaneLayout
														.createParallelGroup()
														.addComponent(
																tabbedPanel)
														.addGroup(
																contentPaneLayout
																		.createSequentialGroup()
																		.addComponent(
																				statusPanel,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				stopButton))
														.addComponent(
																scrollPanel))
										.addContainerGap()));
		contentPaneLayout
				.setVerticalGroup(contentPaneLayout
						.createParallelGroup()
						.addGroup(
								contentPaneLayout
										.createSequentialGroup()
										.addGap(23, 23, 23)
										.addGroup(
												contentPaneLayout
														.createParallelGroup()
														.addGroup(
																contentPaneLayout
																		.createSequentialGroup()
																		.addComponent(
																				tabbedPanel,
																				GroupLayout.PREFERRED_SIZE,
																				270,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				scrollPanel)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				contentPaneLayout
																						.createParallelGroup()
																						.addComponent(
																								statusPanel,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								stopButton,
																								GroupLayout.PREFERRED_SIZE,
																								42,
																								GroupLayout.PREFERRED_SIZE)))
														.addComponent(
																paintPanel,
																GroupLayout.PREFERRED_SIZE,
																520,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap(21, Short.MAX_VALUE)));
		setSize(825, 600);
		setLocationRelativeTo(getOwner());

	}

	// Variables declaration

	private JLayeredPane paintPanel;
	private JTabbedPane tabbedPanel;
	private JPanel orderPanel;
	private JPanel productsPanel;
	private JPanel settingsPanel;
	private JLabel label1;
	private JLabel label2;
	private JSpinner rowsSpinner;
	private JSpinner columnsSpinner;
	private JScrollPane scrollPanel;
	private JLayeredPane informationPanel;
	private JLabel standardLabel1;
	private JLabel customRowColumnLabel;
	private JLabel reUseLabel1;
	private JLabel reUseLabel2;
	private JLabel customReUseNameLabel;
	private JLabel customReUseAmountLabel;
	private JPanel statusPanel;
	private JLabel statusLabel;
	private JButton stopButton;

}
