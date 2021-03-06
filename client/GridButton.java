/** This class represents a button in a Battleship grid
	@author Jacob Smith
*/
import javax.swing.*;

public class GridButton extends JButton{
	
	/** The location of the button*/
	private String coordinate;
	
	/** */
	private boolean hit;
	
	/** Constructs a grid button
		@param row the row number of the button
		@param col the column number of the button
	*/
	public GridButton(int row, int col){
		this.coordinate = "" + (char)(col+65) + (row+1);
		hit = false;
	}
	
	/** Returns the location of the button in the grid
		@return the button location on the grid
	*/
	public String getCoordinate(){ return coordinate; }
	
	public void setHit(boolean hit){ this.hit = hit; }
	
	public boolean isHit(){ return hit; }
}
