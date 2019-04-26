/**
 * This class is responsible for building the GUI and responding to user input
 * It'll implement actionlistener and mouselistener which handles the clicks on button and plot area
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class Window extends JFrame implements ActionListener, MouseListener {
	private JButton openButton, closeButton, goButton;
	private PlotComponent plotComponent; //plot area
	private JLabel title; // section between open and close button, to display file name
	private TextField results; //display area for mouse click
	private String[] x, y;  // Strings to go in x and y  combo box respectively
	private JComboBox xAxis, yAxis;  // combo boxes to display x-axis and y-axis selections
	private ArrayList<BondTrade> bondTrades = new ArrayList<BondTrade>();  // arraylist of bond trades, each object contains yield, daystomaturity and amountCHF values
	private ArrayList<String> columnHeaders = new ArrayList<String>(); // arraylist to contain headers as strings
	private ArrayList<Points> pointsList = new ArrayList<Points>(); // arraylist of points, each object contains the x and y values, calculated as % diff of the max and min of a selected column, radius value
																													// corresponding yield, daystomaturity and amountCHF for display purposes
	private ArrayList<StringList> fileContents = new ArrayList<StringList>(); // arraylist of string which will contain the initial data from reading the file and await to be converted to numerical form after

	public Window() {
		this.setLayout(new BorderLayout()); // set this window to adopt border layout, separate flowlayout jpanels will be added to this
		this.setSize(1000,1000); //set default size of window
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set to close if red cross button pressed
		setup();
		this.setVisible(true);
		this.setTitle("Bond Trade Viewer"); // set window title
	}

	// Setting up the GUI
	public void setup() {
		//create topPanel to house open button, title bar and quit button
		JPanel topPanel = new JPanel(new FlowLayout()); 
		this.openButton = new JButton("Open");  
		this.openButton.addActionListener(this);
		this.openButton.setPreferredSize(new Dimension(125, 50));
		this.title = new JLabel("Bond Trades", SwingConstants.CENTER);  //set default title to bond trades and centre
		this.title.setPreferredSize(new Dimension(300, 50));
		Border border = BorderFactory.createLineBorder(Color.GRAY, 2); 
		this.title.setBorder(border);
		this.closeButton = new JButton("Quit");
		this.closeButton.addActionListener(this);
		this.closeButton.setPreferredSize(new Dimension(125, 50));
		topPanel.add(openButton);
		topPanel.add(title);
		topPanel.add(closeButton);
		//create bottomPanel which will house combo boxes, show button and textfield that'll display the trade associated with a clicked plot point
		JPanel bottomPanel = new JPanel(new FlowLayout());
		this.x = new String[] {"x-axis"}; // array of strings to contain column headers that'll go in x-axis jcombo box
		this.	y = new String[] {"y-axis"}; // array of strings to contain column headers that'll go in y-axis jcombo box
		this.xAxis = new JComboBox(x); //left jcombo box for displaying x - axis
		this.xAxis.setPreferredSize(new Dimension(150, 50));
		this.yAxis = new JComboBox(y); // right jcombo box for displaying y-axis
		this.yAxis.setPreferredSize(new Dimension(150, 50));
		this.goButton = new JButton("Show"); // show graph once x and y axis options selected
		this.goButton.addActionListener(this);
		this.goButton.setPreferredSize(new Dimension(100, 50));
		this.results = new TextField((int) (0.07*this.getWidth()));  // display area for a bond trade when a dot on the graph is picked
		this.results.setBackground(Color.WHITE);
		this.results.setEditable(false); //ensures textfield can't be manually overwritten by the user
		bottomPanel.add(xAxis);
		bottomPanel.add(yAxis);
		bottomPanel.add(goButton);
		bottomPanel.add(results);
		this.plotComponent = new PlotComponent();
		this.plotComponent.addMouseListener(this);
		this.add(topPanel, BorderLayout.NORTH);
		this.add(plotComponent, BorderLayout.CENTER); //plot area goes in the middle
		this.add(bottomPanel, BorderLayout.SOUTH);	
	}
	//running the program
	public static void main(String[] args) {
		new Window();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.openButton) { // if open button pressed, open up the JFile Chooser Dialog box
			JFileChooser jfc = new JFileChooser();
			File workingDirectory = new File(System.getProperty("user.dir")); //set folder to start from current working directory where code is
			jfc.setCurrentDirectory(workingDirectory);
			int returnValue = jfc.showOpenDialog(null); 
			File selectedFile = null;  // initiate file
			String fileName = null;  // initiate string
			Scanner reader = null; // initiate scanner reader
			String[] array = new String[2]; //initiate string array
			try {

				if (returnValue == JFileChooser.APPROVE_OPTION) {
					selectedFile = jfc.getSelectedFile();
					fileName = selectedFile.getName(); 
				} 

				if (!(fileName.endsWith(".csv"))){ // tests whether user has tried to open a csv file
					throw new IncorrectFileException("Incorrect file chosen (" + fileName.substring(fileName.lastIndexOf('.')) + ")  \nFile must be of type .csv.");  // if they do choose an incorrect type, throw an exception
				} else {																						
					readFile(reader, array, selectedFile); // try and read the file
					createBondTradeArray(); // convert read data to numerical form bond trades
					clearComboBox();  // clear combo boxes in case files loaded previously
					populateComboBox(); // populate combo boxes using data from read file
					this.xAxis.setSelectedIndex(0); //setting left jcombo box (X-Axis) to default to first header
					this.yAxis.setSelectedIndex(1); //setting right jcombo box (Y-Axis) to default to second header

				}
				this.title.setText(fileName); // renames the jlabel in the centre of the top panel to the file name
			} catch (IncorrectFileException exception) { //  a dialog box will display a message showing the file type that was selected and ask that they try again 
				JOptionPane.showMessageDialog(this, exception.getMessage(),  "Incorrect file chosen",
						JOptionPane.WARNING_MESSAGE);
			}
			catch (Exception exception) { // if user clicks on open button but then doesn't select a file, don't display anything, program just handles the null point exception
			}
		}
		
		else if (e.getSource() == this.goButton) {
			try {
				this.results.setText("A selected bond trade will be displayed here");
				double radius = 20; // radius size for each point
				this.plotComponent.clear();  //overwrites the graph area
				this.plotComponent.addxaxis(calculateMin(this.bondTrades, this.xAxis.getSelectedIndex()));
				// for the purposes of calculating ticks along x-axis, adds the minimum of the chosen column first
				this.plotComponent.addxaxis(calculateMax(this.bondTrades, this.xAxis.getSelectedIndex()));
				// for the purposes of calculating ticks along x-axis, adds the maximum of the chosen column last
				this.plotComponent.addyaxis(calculateMin(this.bondTrades, this.yAxis.getSelectedIndex()));  
				// for the purposes of calculating ticks along  y-axis, adds the minimum of the chosen column first
				this.plotComponent.addyaxis(calculateMax(this.bondTrades, this.yAxis.getSelectedIndex())); 
				// for the purposes of calculating ticks along y-axis, adds the maximum of the chosen column last
				this.plotComponent.addHeader(this.columnHeaders.get(this.xAxis.getSelectedIndex())); 
				// for the purposes of labelling axis, add the one that'll go along x - axis first
				this.plotComponent.addHeader(this.columnHeaders.get(this.yAxis.getSelectedIndex())); 
				// for the purposes of labelling axis, add the one that'll go along y - axis last
				if (!(this.xAxis.getSelectedIndex() == this.yAxis.getSelectedIndex())) {
					// if the user hasn't made the same selection for both axes
					for (int l = 0; l<this.bondTrades.size(); l++) {
						// for each trade, calculate relative % change of values for supposed x and y coordinate
						// iterate through the list of bond trade and pull the data from the column based on the 
						// combo box selection
						double x = calcX(this.bondTrades.get(l).getValue(this.xAxis.getSelectedIndex()), this.xAxis.getSelectedIndex());
						double y = calcY(this.bondTrades.get(l).getValue(this.yAxis.getSelectedIndex()), this.yAxis.getSelectedIndex());
						Points p = new Points(x, y, radius, this.bondTrades.get(l).getFirstValueOfaTrade(), this.bondTrades.get(l).getSecondValueOfaTrade(), this.bondTrades.get(l).getThirdValueOfaTrade());
						this.pointsList.add(p);
						this.	plotComponent.addPoint(p);
						this.plotComponent.revalidate();
						this.plotComponent.repaint();		
					}
				}
				else { // display dialog box should user select same option for both axes
					JOptionPane.showMessageDialog(this, "X-axis and y-axis selections must be different",  "Selection error", 
							JOptionPane.WARNING_MESSAGE);
				}
			} catch (Exception exception) { // display dialog box should user click show button without opening file
				JOptionPane.showMessageDialog(this, "Please open a file.",  "No file chosen",
						JOptionPane.WARNING_MESSAGE);	
			}
		}
		else if (e.getSource() == this.closeButton) { // if close button clicked, program terminates.
			System.exit(0);
		}
	}
	
	public void readFile(Scanner reader, String[] array, File file) {
		this.plotComponent.clear(); 
		this.plotComponent.repaint(); // clears and repaints the graph
		this.columnHeaders.clear(); // need to clear when opening new files otherwise program will 'remember' and incorrectly display it in graph of new file
		this.fileContents.clear();  // need to clear when opening new files otherwise program will 'remember' and incorrectly display it in graph of new file
		this.bondTrades.clear(); // clear list of bond trades if user opens a new file
		this.results.setText(""); // clear the text field when any new file loaded
		try {
			reader = new Scanner(file);
			reader.useDelimiter("\\n, ");
			array = reader.nextLine().split(","); // reading the first line of the csv
			this.columnHeaders.add(array[0]); // splitting the three values and adding each one to the list for header columns
			this.columnHeaders.add(array[1]);
			this.columnHeaders.add(array[2]);
			while (reader.hasNextLine()) {
				array = reader.nextLine().split(","); // reading each line and splitting up into 3 components
				this.fileContents.add(new StringList(array[0], array[1], array[2])); // adding each of these components as an index in
			} // an arraylist of Point(s) that are strings
		}
		catch (Exception d) {
			d.printStackTrace();
		} finally {
			try {
				reader.close();
			}catch(Throwable e) {
				e.printStackTrace();
			}
		}
	}
	// Create list of bond trades by converting read file (which is initially in string format) to numerical, double, format
	public void createBondTradeArray() {
		this.bondTrades.clear(); // necessary in case user wishes to load another csv file loaded 
		for (int i = 0; i<this.fileContents.size(); i++) { //changing the strings to double values for plotting graph
			this.bondTrades.add(new BondTrade(Double.parseDouble(this.fileContents.get(i).getFirstValue()), Double.parseDouble(this.fileContents.get(i).getSecondValue()), Double.parseDouble(this.fileContents.get(i).getThirdValue())));
		}
	}
	
	// Remove items in combo boxes before re-populating with names of columns once file read
	public void clearComboBox() {
		if (this.xAxis.getItemCount() > 0 && this.yAxis.getItemCount() > 0) {
			this.xAxis.removeAllItems();
			this.yAxis.removeAllItems();
		}
	}
	
	// Populate combo boxes using headers from read file
	public void populateComboBox() {
		for (String s:  this.columnHeaders) { //adding headings to both jcombo box
			this.xAxis.addItem(s);
			this.yAxis.addItem(s);
		}
	}
	/**
	 * @param arraylist of bondtrades
	 * @param an integer used to discern if to retrieve the value in column 1, 2 or 3 determined by selection
	 * in combo box
	 * @return the lowest value in a column based on selection in jcombo box
	 */
	public double calculateMin(ArrayList<BondTrade> bondTrades, int comboBoxIndex) {
		double min = 0;
		min = bondTrades.get(0).getValue(comboBoxIndex); // set min to first value within a column
		for (BondTrade x : bondTrades) {
			if (x.getValue(comboBoxIndex) <= min) {
				// if a value is lower or equal to min, overwrite it.
				min = x.getValue(comboBoxIndex);
			}
		}
		return min;
	}
	
	/**
	 * @param bondtrades arraylist of bondtrades
	 * @param a integer used to discern if to retrieve the value in column 1, 2 or 3 determined by selection
	 * in combo box
	 * @return the highest values of values in a column based on selection in the jcombo box
	 */
	public double calculateMax(ArrayList<BondTrade> bondTrades, int comboBoxIndex) {
		double max = 0;
		max = bondTrades.get(0).getValue(comboBoxIndex); // set max to first value within a column
		for (BondTrade x : bondTrades) {
			if (x.getValue(comboBoxIndex) >= max) {
				max = x.getValue(comboBoxIndex);
			}
		}
		return max;
	}
	//a combo box option is chosen which selects a column of data to be used for the x value for each point
	//this method calculates the % diff of each value in this column between min and max values
	// which will then be manipulated with plotting area size to fit on graph
	public double calcX(double x_value, int comboBoxIndex ) {
		double min = calculateMin(this.bondTrades, comboBoxIndex);
		double max = calculateMax(this.bondTrades, comboBoxIndex);
		double value =  ((x_value - min) / (max - min));
		return value;
	}
	//a combo box option is chosen which selects a column of data to be used for the y value for each point
	//this method calculates the % diff of each value in this column between min and max values
	// which will then be manipulated with plotting area size to fit on graph
	public double calcY(double y_value, int comboBoxIndex) {
		double min = calculateMin(this.bondTrades, comboBoxIndex);
		double max = calculateMax(this.bondTrades, comboBoxIndex);
		double value =  ((y_value - min) / (max - min));
		return value;
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 * when if (x,y) coordinates of mouse click matches with the calculated x,y of an associated bond trade, the results will display
	 * the yield, days to maturity and amountCHF for that trade 
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == plotComponent) {
			for (int i = 0; i < this.pointsList.size(); i++) {  // calculations by working out by edges of dots on screen
				if ((e.getX() <= plotComponent.calculateXCoordinate(this.pointsList.get(i).getX(), this.pointsList.get(i).getRadius()) + this.pointsList.get(i).getRadius()) && e.getX() >= plotComponent.calculateXCoordinate(this.pointsList.get(i).getX(), this.pointsList.get(i).getRadius()) && 
						(e.getY() <= plotComponent.calculateYCoordinate(this.pointsList.get(i).getY(), this.pointsList.get(i).getRadius()) + this.pointsList.get(i).getRadius()) && e.getY() >= plotComponent.calculateYCoordinate(this.pointsList.get(i).getY(), this.pointsList.get(i).getRadius())) {
					results.setText((this.columnHeaders.get(0) + ": " + this.pointsList.get(i).getFirstValueOfaTrade() + ", " + this.columnHeaders.get(1) + ": " + this.pointsList.get(i).getSecondValueOfaTrade() + ", " + this.columnHeaders.get(2) + ": "+ this.pointsList.get(i).getThirdValueOfaTrade()));
					// return a string of values associated with a selected dot
					i = this.pointsList.size()-1; //just to ensure that results textfield will not be overwritten unless a click is registered elsewhere on the window area
				}	else {
					results.setText("Choose again"); 
				}
			}
		}
	}
	/**
	 * Implementing the rest of the methods as implementing interfaces
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		return;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		return;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		return;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		return;
	}
}