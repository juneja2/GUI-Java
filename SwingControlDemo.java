import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingControlDemo {

	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	

	public SwingControlDemo(){
		prepareGUI();
	}
	public static void main(String[] args){
		SwingControlDemo swingControlDemo = new SwingControlDemo();
		swingControlDemo.showEventDemo();
	}
	private void prepareGUI(){
		mainFrame = new JFrame("Java SWING Examples"); // This creates an outer frame inside which we can add things
		
		mainFrame.setSize(400,400); // width = 400, height = 400 in the respective order
		
		mainFrame.setLayout(new GridLayout(4, 1) ); // GridLayout creates a rectangular grid with 4 rows 1 column.
		// So you can only fit one component in a line and you can do that 4 or row times
		
		headerLabel = new JLabel("",JLabel.CENTER ); // We want a label that is in the center
		
		statusLabel = new JLabel("",JLabel.CENTER); // We want status label to be in the center too
		statusLabel.setSize(350,100); // statusLabel width = 350, height = 100
		
		
		mainFrame.addWindowListener(new WindowAdapter() {
								public void windowClosing(WindowEvent windowEvent){
									System.exit(0);
								}
		}); // Adds a Window Listener to mainFrame in order to recieve events in the Widndows
		// We are adding windowClosing method to recieve the window Closing event which is basically a window event
			// And whenever user hits the cross on the top right hand corner we do System.exit(0); which is basically exit
			// the program
			
		
		controlPanel = new JPanel(); // Create a new JPanel
		controlPanel.setLayout(new FlowLayout()); // Set it's layout to flow layout which means left to right
		// until you can't fit anymore on the line in which case we move to the next line
		
		
		// After we have created all the components we add them to the mainFrame so everything is displayed in the main frame
	
		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);
}
	private void showEventDemo(){
		headerLabel.setText("Control in action: Button"); // Set the text of the header label to 
		JButton okButton = new JButton("OK"); // creates a button
		JButton submitButton = new JButton("Submit");
		JButton cancelButton = new JButton("Cancel");
		JButton reverseButton = new JButton("Reverse");
		
		okButton.setActionCommand("OK"); // Whenever the button is clicked then this command is sent to the actionListener
		submitButton.setActionCommand("Submit");
		cancelButton.setActionCommand("Cancel");
		reverseButton.setActionCommand("Reverse");
		
		okButton.addActionListener(new ButtonClickListener()); // This is to add listener so when the button is clicked the command is caught
		submitButton.addActionListener(new ButtonClickListener());
		cancelButton.addActionListener(new ButtonClickListener());
		reverseButton.addActionListener(new ButtonClickListener());
		
		controlPanel.add(okButton);  // The buttons appear from left to right because of the flow layout
		controlPanel.add(submitButton);
		controlPanel.add(cancelButton);
		controlPanel.add(reverseButton);
		
		//controlPanel.setLayout(null);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 2));
		
	// Creating JLabel
		JLabel userLabel = new JLabel("User");
/* This method specifies the location and size
*  of component. setBounds(x, y, width, height)
*  here (x,y) are cordinates from the top left
*  corner and remaining two arguments are the width
*  and height of the component.
*/
		userLabel.setBounds(10,20,80,25); // Starting x = 10 and y coordinate = 20 and width = 80 and height = 25
		panel.add(userLabel);
/* Creating text field where user is supposed to


*  enter user name.
*/
	JTextField userText = new JTextField(20); 
	// Text Field is where you can get input from users, 20 is setting the length of the input
	userText.setBounds(50,20,165,25);
	panel.add(userText);
// Same process for password label and text field.
	JLabel passwordLabel = new JLabel("Password");
	passwordLabel.setBounds(50,50,80,25);
	panel.add(passwordLabel);
/*This is similar to text field but it hides the user
*  entered data and displays dots instead to protect
*  the password like we normally see on login screens.
*/
	JPasswordField passwordText = new JPasswordField(20);
	passwordText.setBounds(100,50,165,25);
	panel.add(passwordText);
// Creating login button

	
	JButton loginButton = new JButton("login");
	loginButton.setBounds(100, 80, 80, 25);
	loginButton.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e){
									String username = "Username: "+ userText.getText();
									String password = "Password: "+ passwordText.getText();
									statusLabel.setText(username + " " + password);
								}
							});
	panel.add(loginButton);
	
	mainFrame.add(panel);
	mainFrame.setVisible(true);		
		
}
	private class ButtonClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if( command.equals( "OK" ))  {
				statusLabel.setText("Ok Button clicked.");
			} else if( command.equals( "Submit" ) )  {
				statusLabel.setText("Submit Button clicked.");
			}
			else if( command.equals("Reverse")){
				statusLabel.setText("Reverse Button Clicked");
			} else {
				statusLabel.setText("Cancel Button clicked.");
			}  
		}
	}
}


