package swingcalculatorapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Matthias Fried, Charles Berlin
 *
 */
public class Calculator extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;
    private static Font fontLarge;
    Display display;
    JPanel buttons;
	double xValue; //keeps track of primary stored value
	double yValue; //keeps track of secondary stored value
	int hitCount; //keeps track how many times the "Hitman" button is pressed
	int buttonCount; //keeps track how many times the red button labeled "" is pressed.
	Operation operator;
	enum Operation{PLUS, MINUS, TIMES, DIV, EQUALS, POW}
	public static boolean numKey; //keep track if button pressed is a number
    
   
    public Calculator() {
    	numKey = false; 
    	operator = Operation.EQUALS;
    	hitCount = 0; 
        Font font = getFont();
        fontLarge = font.deriveFont((float) (2.5*font.getSize2D()));
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(new Color(64,64,128),5,true));
        display=new Display();
        display.setFont(fontLarge);
        
        add(display,BorderLayout.PAGE_START);
        buttons = new JPanel(new GridLayout(11,4,5,5));

        addButton("sin");
        addButton("cos");
        addButton("tan");
        addButton("^2");
        
        addButton("sin^-1");
        addButton("cos^-1");
        addButton("tan^-1");
        addButton("sqrt");
        
        addButton("STO <=");
        addButton("e");
        addButton("pi");
        addButton("C");
        
        addButton("STO =>");
        addButton("e^x");
        addButton("EE");
        addButton("CE");

        addButton("%");
        addButton("ln");
        addButton("log");
        addButton("<X");
        
        addButton("^");
        addButton("1/x");
        addButton("GW");
        addButton("/"); 
        
        addButton("7");
        addButton("8");
        addButton("9");
        addButton("x");
        
        addButton("4");
        addButton("5");
        addButton("6");
        addButton("-");
        
        addButton("1");
        addButton("2");
        addButton("3");
        addButton("+");
        
        addButton("+/-");       
        addButton("0");
        addButton(".");
        addButton("=");
        
        addButton("");
        addButton("Hitman");
        addButton("GPS");
        addButton("Credits");
                
        add(buttons,BorderLayout.PAGE_END);
    }
    
    /**
     * Creates buttons. Sets background colors for different sets of buttons.
     * @param name String label on each button
     */
    private void addButton(String name) {
        JButton button = new JButton(name);
        if("Hitman GPS Credits".contains(name)){
        	button.setBackground(new Color(41,85,0));
        	if(name.equals("Hitman")){
        		button.setToolTipText("Calls in an assassination");
        	}
        	if(name.equals("GPS")){
        		button.setToolTipText("Pinpoints your exact location");
        	}
        }
        if("^2 sqrt".contains(name)){
        	button.setBackground(Color.PINK);
        	if(name.equals("^2")){
        		button.setToolTipText("Squares display value");
        	}
        	if(name.equals("sqrt")){
        		button.setToolTipText("Finds square root of display value");
        	}
        }
        if("STO <= STO =>".contains(name)){
        	button.setBackground(new Color(112,11,46));
        	if(name.equals("STO <=")){
        		button.setToolTipText("Assigns a value to memory");
        	}
        	if(name.equals("STO =>")){
        		button.setToolTipText("Retrives value from memory");
        	}
        }
        if("sin^-1cos^-1tan^-1".contains(name)){
        	button.setBackground(new Color(172,157,246));
        	if(name.equals("sin")){
        		button.setToolTipText("Finds sine of display value");
        	}
        	if(name.equals("cos")){
        		button.setToolTipText("Finds cosine of display value");
        	}
        	if(name.equals("tan")){
        		button.setToolTipText("Finds tangent of display value");
        	}
        	if(name.equals("sin^-1")){
        		button.setToolTipText("Finds inverse sine of display value");
        	}
        	if(name.equals("cos^-1")){
        		button.setToolTipText("Finds inverse cosine of display value");
        	}
        	if(name.equals("tan^-1")){
        		button.setToolTipText("Finds inverse tangent of display value");
        	}
        	
        }
        if("e e^x ln EE log 1/x % ^ pi +/- .".contains(name)){
        	button.setBackground(Color.DARK_GRAY);
        	if(name.equals("e")){
        		button.setToolTipText("Euler's number constant");
        	}
        	if(name.equals("e^x")){
        		button.setToolTipText("Raises e to power of display value");
        	}
        	if(name.equals("EE")){
        		button.setToolTipText("Scientfic Notation");
        	}
        	if(name.equals("ln")){
        		button.setToolTipText("Natural log");
        	}
        	if(name.equals("log")){
        		button.setToolTipText("log base 10");
        	}
        	if(name.equals("1/x")){
        		button.setToolTipText("Reciprocal");
        	}
        	if(name.equals("%")){
        		button.setToolTipText("Converts to percentage");
        	}
        	if(name.equals("^")){
        		button.setToolTipText("Raises first value to power of second value");
        	}
        	if(name.equals("pi")){
        		button.setToolTipText("Constant of pie");
        	}
        	if(name.equals("+/-")){
        		button.setToolTipText("Changes sign of display value to postive or negative");
        	}
        	
        }
        if("0123456789".contains(name)){
        	button.setBackground(new Color(49,196,240));
        }
        if("+ - / x =".contains(name)){
        	button.setBackground(new Color(253,140,15));
        	if(name.equals("+")){
        		button.setToolTipText("Addition");
        	}
        	if(name.equals("-")){
        		button.setToolTipText("Subtraction");
        	}
        	if(name.equals("/")){
        		button.setToolTipText("Division");
        	}
        	if(name.equals("x")){
        		button.setToolTipText("Multiplication");
        	}
        }
        if("GW".contains(name)){
        	button.setBackground(new Color(70,156,23));
        	if(name.equals("GW")){
        		button.setToolTipText("Solves problem of global warming");
        	}
        }
        if("CE <X".contains(name)){
        	button.setBackground(new Color(1,54,145));
        	if(name.equals("C")){
        		button.setToolTipText("Clears display and memory");
        	}
        	if(name.equals("CE")){
        		button.setToolTipText("Clears display");
        	}
        	if(name.equals("<X")){
        		button.setToolTipText("Backspace");
        	}
        	
        }
        if(name == ""){
        	button.setBackground(Color.RED);
        	if(name.equals("")){
        		button.setToolTipText("Big Red Button. Do NOT push!");
        		
        	}
        }

    	button.setForeground(Color.WHITE);
        button.setFont(fontLarge);
        button.addActionListener(this);
        button.setActionCommand(name);
        buttons.add(button);
    }
    
    /**
     * Get action for buttons 0,1,2,3,4,5,6,7,8,9 and .
     * @param e Action Event
     * @param str String labels of "0","1","2","3","4","5","6","7","8","9" and "."
     */
    public void getAction(ActionEvent e, String str){
    	if(str.equals(e.getActionCommand())){
    		if(numKey==false){
    			if(operator == Operation.EQUALS){
    				xValue = 0;
    				}
    			display.setValue(0);
    			display.addString(str);
    			numKey = true;
    		}
    		else{
    			display.addString(str);
    		}
    	}
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    	getAction(e, ".");
    	getAction(e, "0");
    	getAction(e, "1");
    	getAction(e, "2");
    	getAction(e, "3");
    	getAction(e, "4");
    	getAction(e, "5");
    	getAction(e, "6");
    	getAction(e, "7");
    	getAction(e, "8");
    	getAction(e, "9");

		if(".".equals(e.getActionCommand())){
			display.addString(".");
		}
		
		if("EE".equals(e.getActionCommand())){
				display.addString("E");
		}
		
        if("+/-".equals(e.getActionCommand())){
        	display.addString("-");
        }
        if("CE".equals(e.getActionCommand())){
        	display.setValue(0.0);
        	numKey = false;
        }
        if("C".equals(e.getActionCommand())){
        	display.setValue(0.0);
        	numKey = false;
        	operator = Operation.EQUALS;
        	xValue = 0;
        }

        if("<X".equals(e.getActionCommand())){
        	if(numKey == true){
        		display.addString("<X");
        	}
        }

        if("+".equals(e.getActionCommand())){
        	operation(operator);
        	numKey = false;
        	operator = Operation.PLUS;
        }
        
        if("-".equals(e.getActionCommand())){
        	operation(operator);
        	numKey = false;
        	operator = Operation.MINUS;
        }

        if("x".equals(e.getActionCommand())){
        	operation(operator);
        	operator = Operation.TIMES;
        	numKey = false;
        }

        if("/".equals(e.getActionCommand())){
        	operation(operator);
    		operator = Operation.DIV;
    		numKey = false;
        }
        
        if("=".equals(e.getActionCommand())){
        	operation(operator);
        	xValue = 0;
        	operator = Operation.EQUALS;
        }
        if("^2".equals(e.getActionCommand())){
    		xValue = display.getValue()*display.getValue();
    		display.setValue(xValue);
        	numKey=false;
        	operator = Operation.EQUALS;
        }
        if("sqrt".equals(e.getActionCommand())){
    		xValue = Math.sqrt(display.getValue());
    		display.setValue(xValue);
        	numKey=false;
        	operator = Operation.EQUALS;
        }
        if("%".equals(e.getActionCommand())){
    		xValue = display.getValue()*.01;
    		display.setValue(xValue);
        	numKey=false;
        	operator = Operation.EQUALS;
        }
        if("^".equals(e.getActionCommand())){
        	operation(operator);
        	operator = Operation.POW;
        	numKey=false;
        }
        if("1/x".equals(e.getActionCommand())){
        	xValue = 1/display.getValue();
        	display.setValue(xValue);
        	numKey=false;
        	operator = Operation.EQUALS;
        }
        if("sin".equals(e.getActionCommand())){
    		xValue = Math.sin(display.getValue());
    		display.setValue(xValue);
        	numKey=false;
        	operator = Operation.EQUALS;
        }
        if("cos".equals(e.getActionCommand())){
    		xValue = Math.cos(display.getValue());
    		display.setValue(xValue);
        	numKey=false;
        	operator = Operation.EQUALS;
        }
        if("tan".equals(e.getActionCommand())){
    		xValue = Math.tan(display.getValue());
    		display.setValue(xValue);
        	numKey=false;
        	operator = Operation.EQUALS;
        }
        if("pi".equals(e.getActionCommand())){
    		display.setValue(Math.PI);
        	numKey=false;
        }
        if("e".equals(e.getActionCommand())){
    		display.setValue(Math.E);
        	numKey=false;
        }
        if("sin^-1".equals(e.getActionCommand())){
    		xValue = Math.asin(display.getValue());
    		display.setValue(xValue);
        	numKey=false;
        	operator = Operation.EQUALS;
        }
        if("cos^-1".equals(e.getActionCommand())){
    		xValue = Math.acos(display.getValue());
    		display.setValue(xValue);
        	numKey=false;
        	operator = Operation.EQUALS;
        }
        if("tan^-1".equals(e.getActionCommand())){
    		xValue = Math.atan(display.getValue());
    		display.setValue(xValue);
        	numKey=false;
        	operator = Operation.EQUALS;
        }
        if("log".equals(e.getActionCommand())){
    		xValue = Math.log10(display.getValue());
    		display.setValue(xValue);
        	numKey=false;
        	operator = Operation.EQUALS;
        }
        if("ln".equals(e.getActionCommand())){
    		xValue = Math.log(display.getValue());
    		display.setValue(xValue);
        	numKey=false;
        	operator = Operation.EQUALS;
        }
        if("STO =>".equals(e.getActionCommand())){
    		display.setValue(yValue);
        	numKey=false;
        	operator = Operation.EQUALS;
        }
        if("STO <=".equals(e.getActionCommand())){
    		yValue = display.getValue();
    		display.setValue(0);
        	numKey=false;
        	operator = Operation.EQUALS;
        }
        if("e^x".equals(e.getActionCommand())){
    		xValue = Math.exp(display.getValue());
    		display.setValue(xValue);
        	numKey=false;
        	operator = Operation.EQUALS;
        }
        if("ln".equals(e.getActionCommand())){
    		xValue = Math.log(display.getValue());
    		display.setValue(xValue);
        	numKey=false;
        	operator = Operation.EQUALS;
        }
        if("GW".equals(e.getActionCommand())){;
    		display.setValue(0);
    		display.setText("Global Warming Solved!");
        	numKey=false;
        	operator = Operation.EQUALS;
        }
        if("Hitman".equals(e.getActionCommand())){;
    		display.setValue(0);
    		if(hitCount == 0){
    			display.setText("Hit ordered.");
    			hitCount +=1;
    		}
    		else if(hitCount == 1){
        		display.setText("Operation in progress.");
        		hitCount +=1;
        	}
    		else if(hitCount == 2){
            	display.setText("It is done.");
            	hitCount +=1;
    		} else{ display.setText("The target has already been eliminated.");}
        	numKey=false;
        	operator = Operation.EQUALS;
        }
        if("GPS".equals(e.getActionCommand())){;
    		display.setValue(0);
    		display.setText("You are here!");
        	numKey=false;
        	operator = Operation.EQUALS;
        }
        if("Credits".equals(e.getActionCommand())){;
    		display.setValue(0);
    		display.setText("By Charles Berlin and Matthias Fried");
        	numKey=false;
        	operator = Operation.EQUALS;
        }
        if("".equals(e.getActionCommand())){;
    		display.setValue(0);
    		if(buttonCount == 0){
    			display.setText("Please do not push.");
    			buttonCount +=1;
    		}
    		else if(buttonCount == 1){
        		display.setText("We got a wise guy over here!");
        		buttonCount +=1;
        	}
    		else if(buttonCount>1 && buttonCount<5){
            	display.setText("This is why we can't have nice things.");
            	buttonCount +=1;
    		}else{
    			display.setText("This is why we can't have nice things.");
    		}
        	numKey=false;
        	operator = Operation.EQUALS;
        }
        
    }
    
    /**
     * Method that handles different operations.
     * @param operator
     */
    public void operation(Operation operator){
    	numKey = false;
    	if(operator == Operation.EQUALS){
    		xValue = display.getValue();
    		if(display.getText().contains("E")){
    			display.setValue(xValue);
    		}
    	}
    	if(operator == Operation.PLUS){
    		xValue += display.getValue();
    		display.setValue(xValue);
    	}
    	if(operator == Operation.MINUS){
    		xValue = xValue - display.getValue();
    		display.setValue(xValue);
    	}
    	if(operator == Operation.TIMES){
    		xValue *= display.getValue();
    		display.setValue(xValue);
    	}
    	if(operator == Operation.DIV){
    			xValue = xValue/display.getValue();
    			display.setValue(xValue);
    	}
    	if(operator == Operation.POW){
    		xValue = Math.pow(xValue, display.getValue());
    		display.setValue(xValue);
    	}
    	
    }
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Java Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Calculator());
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {             
                createAndShowGUI();
            }
        });

    }

}
