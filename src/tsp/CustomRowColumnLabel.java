package tsp;


import javax.swing.JLabel;

public class CustomRowColumnLabel extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void setTextRC(int column, int row) {
		this.setText("<html>"+"<small>Row</small> <b>" +row+" <br><small> Column</small><b>	"+column+"</b></html>");
		 
	}

}
