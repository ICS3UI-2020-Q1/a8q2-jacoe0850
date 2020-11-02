import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  
  JLabel firstLabel;
  JLabel secondLabel;
  JLabel thirdLabel;

  JButton additionButton;
  JButton subtractionButton;
  JButton multiplicationButton;
  JButton divisionButton;

  JTextField firstInput;
  JTextField secondInput;
  JTextField result;


  JPanel mainPanel;

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Basic Calculator");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
 
    //initialize the main JPanel
    mainPanel = new JPanel();
    //disable layout helpers
    mainPanel.setLayout(null);
    //make labels for the numbers
    firstLabel = new JLabel("First Number");
    secondLabel = new JLabel("Second Number");
    thirdLabel = new JLabel("Result");
    //give location and size of labels
    firstLabel.setBounds(170,225,150,20);
    secondLabel.setBounds(170,255,150,20);
    thirdLabel.setBounds(170,285,150,20);
    //puts labels on panel
    mainPanel.add(firstLabel);
    mainPanel.add(secondLabel);
    mainPanel.add(thirdLabel);
    //initialize buttons
    additionButton = new JButton("add");
    subtractionButton = new JButton("sub");
    multiplicationButton = new JButton("mult");
    divisionButton = new JButton("div");
    //set action command for the buttons
    additionButton.setActionCommand("add");
    subtractionButton.setActionCommand("sub");
    multiplicationButton.setActionCommand("mult");
    divisionButton.setActionCommand("div");
    //give location and size of buttons
    additionButton.setBounds(170,375,100,40);
    subtractionButton.setBounds(280,375,100,40);
    multiplicationButton.setBounds(390,375,100,40);
    divisionButton.setBounds(500,375,100,40);
    //give action listener to the buttons
    additionButton.addActionListener(this);
    subtractionButton.addActionListener(this);
    multiplicationButton.addActionListener(this);
    divisionButton.addActionListener(this);
    //add the buttons to the panel
    mainPanel.add(additionButton);
    mainPanel.add(subtractionButton);
    mainPanel.add(multiplicationButton);
    mainPanel.add(divisionButton);
    //create text fields
    firstInput = new JTextField();
    secondInput = new JTextField();
    result = new JTextField();
    //give location and size of textfield
    firstInput.setBounds(370,225,150,20);
    secondInput.setBounds(370,255,150,20);
    result.setBounds(370,285,150,20);
    //add the text fields to the panel
    mainPanel.add(firstInput);
    mainPanel.add(secondInput);
    mainPanel.add(result);
    //disable the result textfield
    result.setEnabled(false);
    frame.add(mainPanel);
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();
    //get the strings from the textfields
    String firstText = firstInput.getText();
    String secondText = secondInput.getText();
    //convert the strings into integers
    int firstNumber = Integer.parseInt(firstText);
    int secondNumber = Integer.parseInt(secondText);
    int answer;
    // calculations
    if(command.equals("add")){
      answer = firstNumber + secondNumber;
      result.setText("" + answer);
    }else if(command.equals("sub")){
      answer = firstNumber - secondNumber;
      result.setText("" + answer);
    }else if(command.equals("mult")){
      answer = firstNumber*secondNumber;
      result.setText("" + answer);
    }else if(command.equals("div")){
      answer = firstNumber/secondNumber;
      result.setText("" + answer);
    }
  }
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    SwingUtilities.invokeLater(gui);
  }
}
