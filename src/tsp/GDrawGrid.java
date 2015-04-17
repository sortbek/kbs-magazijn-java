package tsp;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GDrawGrid extends JPanel {
	
	  private int columnCount;
      private int rowCount;
      private List<Rectangle> cells;
      private Point selectedCell;
      
      public void reDraw(int columnCount, int rowCount){
    	  this.columnCount = columnCount;
    	  this.rowCount = rowCount;
          cells = new ArrayList<>(columnCount * rowCount);
          mouseFix();
          repaint();
         
      }

      public GDrawGrid(int columnCount, int rowCount) {
    	  this.columnCount = columnCount;
    	  this.rowCount = rowCount;
          cells = new ArrayList<>(columnCount * rowCount); 
          mouseFix();
      }
      
      public void mouseFix(){
    	  MouseAdapter mouseHandler;
          mouseHandler = new MouseAdapter() {
              @Override
              public void mouseMoved(MouseEvent e) {
                  Point point = e.getPoint();

                  double width = getWidth();
                  double height = getHeight();

                  double cellWidth = width / columnCount;
                  double cellHeight = height / rowCount;

                  double column = e.getX() / cellWidth;
                  double row = e.getY() / cellHeight;

                  selectedCell = new Point((int)column, (int)row);
                  repaint();

              }
          };
          addMouseMotionListener(mouseHandler);
      }


      @Override
      public void invalidate() {
          cells.clear();
          selectedCell = null;
          super.invalidate();
      }

      @Override
      protected void paintComponent(Graphics g) {
          super.paintComponent(g);
          Graphics2D g2d = (Graphics2D) g.create();
          
          // Height & Width of panel

          double width = getWidth();
          double height = getHeight();
          
          // Heigth & Width of every cell

          double cellWidth = width/ columnCount;
          double cellHeight= height/ rowCount;
          
          // Begin of offset X & Y

          double xOffset = (width - (columnCount * cellWidth)) / 2;
          double yOffset = (height - (rowCount * cellHeight)) / 2;

          if (cells.isEmpty()) {
              for (int row = 0; row < rowCount; row++) {
                  for (int col = 0; col < columnCount; col++) {
                      Rectangle cell = new Rectangle(
                              (int)(xOffset + (col * cellWidth)),
                              (int)(yOffset + (row * cellHeight)),
                              (int)cellWidth,
                              (int)cellHeight);
                      cells.add(cell);
                  }
              }
          }

          if (selectedCell != null) {

              int index = selectedCell.x + (selectedCell.y * columnCount);
              try {
            	  Rectangle cell = cells.get(index);
            	  g2d.setColor(Color.BLUE);
                  g2d.fill(cell);
              } catch (IndexOutOfBoundsException ex) {
              }
              
              

          }

          g2d.setColor(Color.GRAY);
          for (Rectangle cell : cells) {
              g2d.draw(cell);
          }

          g2d.dispose();
      }
  }

