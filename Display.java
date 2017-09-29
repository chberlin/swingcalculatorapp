package swingcalculatorapp;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

/**
 * @author Matthias Fried, Charles Berlin
 *
 */
public class Display extends JLabel {
	private static final long serialVersionUID = 1L;
	private double value;
	private String numString;
	
	public Display() {
		super();
		setOpaque(true);
		setHorizontalAlignment(JLabel.RIGHT);
		setBackground(Color.BLACK);
		setForeground(new Color(240,240,240));
		setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		setValue(0);
	}

	/**
	 * Gets value on display
	 * @return double value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Method that handles adding numbers to appear on the display screen.
	 * Also has specific instructions to handle decimal points, E, negatives, and the undo command.
	 * @param digit the number to write
	 */
	public void addString(String digit){
		if(digit == "."){
			if (!numString.contains(".")&&!numString.contains("E")){
				if(value == 0){
					numString = "0.";
				} else{
					numString = numString + ".";
				}
				value = Double.parseDouble(numString + "0");
				setText(numString);
			} else{ setText(numString + "");}
		}else if(digit == "E"){
			if(!numString.contains("E")){
				if(value == 0){
					numString = "0";
				} else{
					numString = numString + "E";
				}
				value = Double.parseDouble(numString.replace("E", ""));
				setText(numString);
			} else{ setText(numString + "");}
		} else if(digit == "-"){
				if(!numString.contains("-") && value != 0){
					numString = "-" + numString;
				} else{
					numString = numString.replace("-", "");
				}
			value = Double.parseDouble(numString);
			setText(numString);
		} else if(digit == "<X"){
			if(numString.length() == 1){
				numString = "0";
			} else if(numString.length() == 2 && numString.contains("-")){
				numString = "0";
			} else if(numString.length()>1){
				numString = numString.substring(0, numString.length()-1);
				if(numString == "-"){
					numString = "0";
				}
			}
			value = Double.parseDouble(numString);
			setText(numString);					
		} else {
			if (value == 0 && !numString.contains(".")){
				numString = digit;
			} else{ 
				numString = numString + digit;
			}
			value = Double.parseDouble(numString);
			setText(numString);
		}
	}
	
	/**
	 * Method to set value
	 * @param value
	 */
	public void setValue(double value) {
		this.value = value;
		if (this.value==-0) this.value=0;
		numString = Double.toString(value);
		if(value == 0.0){numString = "0";}
		setText(numString);
	}

}
