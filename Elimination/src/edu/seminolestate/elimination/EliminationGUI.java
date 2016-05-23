package edu.seminolestate.elimination;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * 
 * @author Moises Henriquez
 * @date May 22, 2016
 *
 */
public class EliminationGUI extends JFrame implements ActionListener
{
	//Instance Variables
	private int die1 = 6;
	private int die2 = 6;
	private int choiceCount = 0;
	private int lowestScore = 78;
	private int currentScore = 78;
	private boolean buttonsEnabled = false;
	
	//Constants
	private static final int MAX_ATTEMPTS = 2;
	private static final String PLAY_RULES = "The object of Elimination is to eliminate as many of the numbered buttons to achieve \n"
			+ "as low a score as possible. Press \'Roll\' to roll the dice, then press the corresponding \n"
			+ "number buttons whether choosing the individual die values or the sum of the die values.";
	
	//JPanels
	private JPanel pnlNorth = new JPanel();
	private JPanel pnlWest = new JPanel();
	private JPanel pnlCenter = new JPanel();
	private JPanel pnlEast = new JPanel();
	private JPanel pnlSouth = new JPanel();
	//
	private JPanel pnlSouthTop = new JPanel();
	private JPanel pnlSouthBtm = new JPanel();
	
	//JButtons
	private JButton btn01 = new JButton("1");
	private JButton btn02 = new JButton("2");
	private JButton btn03 = new JButton("3");
	private JButton btn04 = new JButton("4");
	private JButton btn05 = new JButton("5");
	private JButton btn06 = new JButton("6");
	private JButton btn07 = new JButton("7");
	private JButton btn08 = new JButton("8");
	private JButton btn09 = new JButton("9");
	private JButton btn10 = new JButton("10");
	private JButton btn11 = new JButton("11");
	private JButton btn12 = new JButton("12");
	//
	private JButton btnRules = new JButton("Rules");
	private JButton btnRoll = new JButton("Roll");
	private JButton btnReset = new JButton("Reset");
	
	//JLabels
	private JLabel lblDiceRoll = new JLabel("Dice Roll: ");
	private JLabel lblDie1 = new JLabel("6");
	private JLabel lblDie2 = new JLabel("6");
	//
	private JLabel lblCurrentScore = new JLabel("Current Score");
	private JLabel lblCurrentScoreNum = new JLabel("78");
	//
	private JLabel lblLowScore = new JLabel("Lowest Score");
	private JLabel lblLowScoreNum = new JLabel("78");
	
	//JRadioButtons
	private JRadioButton rdoWhite = new JRadioButton("White", false);
	private JRadioButton rdoGray = new JRadioButton("Gray", false);
	private JRadioButton rdoYellow = new JRadioButton("Yellow", false);
	
	//Fonts
	Font font1 = new Font("Serif", Font.BOLD, 15);
	Font font2 = new Font("Arial", Font.ITALIC, 12);
	Font font3 = new Font("Arial", Font.BOLD, 23);
	
	//Default Constructor
	public EliminationGUI(String title, boolean visible) {
		super(title);
		
		//Set size and lock it
		setSize(779, 320);
		setResizable(false);
		
		//Center window to screen
		setLocationRelativeTo(null);
		
		//Initialize UI
		initUserInterface();
		
		//Render JFrame
		setVisible(visible); //<== Must be applied after UI is initialized to render components
		
		//Set focus to roll button
		btnRoll.requestFocusInWindow(); //<== Must be applied after JFrame is rendered (visible)
	}
	
	//Methods
	
	private void initUserInterface() {
		//set new border layout for JFrame
		setLayout(new BorderLayout());
		
		//Add components to north panel
		pnlNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		pnlNorth.setBorder(BorderFactory.createTitledBorder(""));
		pnlNorth.add(lblDiceRoll);
		pnlNorth.add(lblDie1);
		lblDie1.setFont(font3);
		pnlNorth.add(lblDie2);
		lblDie2.setFont(font3);
		
		//Add components to west panel
		pnlWest.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
		pnlWest.setBorder(BorderFactory.createTitledBorder(""));
		pnlWest.setPreferredSize(new Dimension(120,200));
		pnlWest.add(lblLowScore);
		lblLowScore.setFont(font1);
		pnlWest.add(lblLowScoreNum);
		lblLowScoreNum.setFont(font3);
		
		//Add components to east panel
		pnlEast.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
		pnlEast.setBorder(BorderFactory.createTitledBorder(""));
		pnlEast.setPreferredSize(new Dimension(120,200));
		pnlEast.add(lblCurrentScore);
		lblCurrentScore.setFont(font1);
		pnlEast.add(lblCurrentScoreNum);
		lblCurrentScoreNum.setFont(font3);
		
		//Add components to center panel
		pnlCenter.setLayout(new GridLayout(2,6));
		pnlCenter.setPreferredSize(new Dimension(430,0));
		pnlCenter.setBorder(BorderFactory.createTitledBorder(""));
		//Add buttons
		pnlCenter.add(btn01);
		pnlCenter.add(btn02);
		pnlCenter.add(btn03);
		pnlCenter.add(btn04);
		pnlCenter.add(btn05);
		pnlCenter.add(btn06);
		pnlCenter.add(btn07);
		pnlCenter.add(btn08);
		pnlCenter.add(btn09);
		pnlCenter.add(btn10);
		pnlCenter.add(btn11);
		pnlCenter.add(btn12);
		//
		//Add action listeners and tool tips to number buttons
		btn01.addActionListener(this);
		btn01.setToolTipText("Click to use the value on the button.");
		btn02.addActionListener(this);
		btn02.setToolTipText("Click to use the value on the button.");
		btn03.addActionListener(this);
		btn03.setToolTipText("Click to use the value on the button.");
		btn04.addActionListener(this);
		btn04.setToolTipText("Click to use the value on the button.");
		btn05.addActionListener(this);
		btn05.setToolTipText("Click to use the value on the button.");
		btn06.addActionListener(this);
		btn06.setToolTipText("Click to use the value on the button.");
		btn07.addActionListener(this);
		btn07.setToolTipText("Click to use the value on the button.");
		btn08.addActionListener(this);
		btn08.setToolTipText("Click to use the value on the button.");
		btn09.addActionListener(this);
		btn09.setToolTipText("Click to use the value on the button.");
		btn10.addActionListener(this);
		btn10.setToolTipText("Click to use the value on the button.");
		btn11.addActionListener(this);
		btn11.setToolTipText("Click to use the value on the button.");
		btn12.addActionListener(this);
		btn12.setToolTipText("Click to use the value on the button.");
		
		//RadioButton Group
		ButtonGroup rdoButtonGroup = new ButtonGroup();
		rdoButtonGroup.add(rdoWhite);
		rdoButtonGroup.add(rdoGray);
		rdoButtonGroup.add(rdoYellow);
				
		//Add components to top of south panel
		pnlSouthTop.setLayout(new BoxLayout(pnlSouthTop, BoxLayout.LINE_AXIS));
		pnlSouthTop.setBorder(BorderFactory.createTitledBorder("Background Color"));
		pnlSouthTop.add(Box.createRigidArea(new Dimension(50,40)));
		pnlSouthTop.add(rdoWhite);
		pnlSouthTop.add(Box.createRigidArea(new Dimension(100,0)));
		pnlSouthTop.add(rdoGray);
		pnlSouthTop.add(Box.createRigidArea(new Dimension(100,0)));
		pnlSouthTop.add(rdoYellow);
		pnlSouthTop.add(Box.createRigidArea(new Dimension(50,40)));
		
		//Add components to bottom of south panel
		pnlSouthBtm.setLayout(new BoxLayout(pnlSouthBtm, BoxLayout.LINE_AXIS));
		pnlSouthBtm.add(Box.createRigidArea(new Dimension(0,50)));
		//Rules button
		pnlSouthBtm.add(btnRules);
		btnRules.addActionListener(this);
		btnRules.setToolTipText("Click to Show Rules.");
		//Roll button
		pnlSouthBtm.add(btnRoll);
		btnRoll.addActionListener(this);
		btnRoll.setToolTipText("Click to Roll Dice.");
		//Reset button
		pnlSouthBtm.add(btnReset);
		btnReset.addActionListener(this);
		btnReset.setToolTipText("Click to Reset Game.");
		btnReset.setEnabled(false);
		btnReset.setFont(font2);
		
		//Add top and bottom panels to south panel
		pnlSouth.setLayout(new BoxLayout(pnlSouth, BoxLayout.PAGE_AXIS));
		pnlSouth.setBorder(BorderFactory.createTitledBorder(""));
		pnlSouth.setPreferredSize(new Dimension(0,120));
		pnlSouth.add(pnlSouthTop);
		pnlSouth.add(pnlSouthBtm);
		
		//Add JPanel elements to JFrame
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlEast, BorderLayout.EAST);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlWest, BorderLayout.WEST);
		add(pnlSouth, BorderLayout.SOUTH);
		
		//Start with number buttons disabled
		disableGameButtons();
	}
	
	//Show message with rules information
	private void showGameRules(){
		JOptionPane.showMessageDialog(null, PLAY_RULES, "Rules For Playing", JOptionPane.INFORMATION_MESSAGE);
	}
	
	//Disable all number buttons
	private void disableGameButtons(){
		btn01.setEnabled(false);
		btn02.setEnabled(false);
		btn03.setEnabled(false);
		btn04.setEnabled(false);
		btn05.setEnabled(false);
		btn06.setEnabled(false);
		btn07.setEnabled(false);
		btn08.setEnabled(false);
		btn09.setEnabled(false);
		btn10.setEnabled(false);
		btn11.setEnabled(false);
		btn12.setEnabled(false);
		buttonsEnabled = false;
	}
	
	//Enable all number buttons
	private void enableGameButtons(){
		btn01.setEnabled(true);
		btn02.setEnabled(true);
		btn03.setEnabled(true);
		btn04.setEnabled(true);
		btn05.setEnabled(true);
		btn06.setEnabled(true);
		btn07.setEnabled(true);
		btn08.setEnabled(true);
		btn09.setEnabled(true);
		btn10.setEnabled(true);
		btn11.setEnabled(true);
		btn12.setEnabled(true);
		buttonsEnabled = true;
	}
	
	//Roll a die
	private int rollTheDie(){
		Random rand = new Random();
		return rand.nextInt(6)+1;
	}
	
	//Check if button clicked matches any of the dice
	private boolean isValidNumber(int key){
		if(choiceCount < MAX_ATTEMPTS){
			if(die1 == die2 || die1 + die2 == key){
				if(choiceCount == 0){
					if(die1 == die2){
						if((die1 + die2) == key){
							//Reduce the current score by key amount
							//and end turn (ends game)
							currentScore = currentScore - key;
							lblCurrentScoreNum.setText(String.format("%,d", currentScore));
							choiceCount +=2;
							
							if(choiceCount == 2){
								btnRoll.setEnabled(true);
							}
							return true;
						}
					} else if(die1 + die2 == key){
						//Reduce the current score by key amount
						//and end turn (ends game)
						currentScore = currentScore - key;
						lblCurrentScoreNum.setText(String.format("%,d", currentScore));
						choiceCount +=2;
						
						if(choiceCount == 2){
							btnRoll.setEnabled(true);
						}
						return true;
					}
				}
			} else if(die1 == key || die2 == key){
				//Reduce the current score by key amount 
				//and end turn (one turn left)
				currentScore = currentScore - key;
				lblCurrentScoreNum.setText(String.format("%,d", currentScore));
				choiceCount +=1;
				
				if(choiceCount == 2){
					btnRoll.setEnabled(true);
				}
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source instanceof JButton){
			if(source == btn01){
				if(isValidNumber(1) == true){
					btn01.setEnabled(false);
				}
			} else if(source == btn02){
				if(isValidNumber(2) == true){
					btn02.setEnabled(false);
				}
			} else if(source == btn03){
				if(isValidNumber(3) == true){
					btn03.setEnabled(false);
				}
			} else if(source == btn04){
				if(isValidNumber(4) == true){
					btn04.setEnabled(false);
				}
			} else if(source == btn05){
				if(isValidNumber(5) == true){
					btn05.setEnabled(false);
				}
			} else if(source == btn06){
				if(isValidNumber(6) == true){
					btn06.setEnabled(false);
				}
			} else if(source == btn07){
				if(isValidNumber(7) == true){
					btn07.setEnabled(false);
				}
			} else if(source == btn08){
				if(isValidNumber(8) == true){
					btn08.setEnabled(false);
				}
			} else if(source == btn09){
				if(isValidNumber(9) == true){
					btn09.setEnabled(false);
				}
			} else if(source == btn10){
				if(isValidNumber(10) == true){
					btn10.setEnabled(false);
				}
			} else if(source == btn11){
				if(isValidNumber(11) == true){
					btn11.setEnabled(false);
				}
			} else if(source == btn12){
				if(isValidNumber(12) == true){
					btn12.setEnabled(false);
				}
			} else if(source == btnRules){
				showGameRules();
			} else if(source == btnRoll){
				
				//TODO:
				//Check if there are any moves available
				//private void checkMovesAvailable(int die1, int die2){}
				//JOptionPane.showMessageDialog(null, "Game Over Dude, Game Over", "Game Over", JOptionPane.INFORMATION_MESSAGE);
				
				//int btn1 = Integer.parseInt(btn01.getText());
				
				
				//Reset selection count to 0 if not set to 0
				if(choiceCount != 0){
					choiceCount = 0;
				}
				
				//Check if the number buttons are enabled, 
				//enable them if they're not enabled
				if(buttonsEnabled == false){
					enableGameButtons();
					btnReset.setEnabled(true);
				}
				
				//Roll the dice and show results
				die1 = rollTheDie();
				lblDie1.setText(String.format("%,d", die1));
				die2 = rollTheDie();
				lblDie2.setText(String.format("%,d", die2));
				
				//Disable button
				btnRoll.setEnabled(false);
				
				//Set focus on reset button
				btnReset.requestFocusInWindow();
				
			} else if(source == btnReset){
				//Ask user if they want to end game
				int dialogResult = JOptionPane.showConfirmDialog(null, "Do you really want to start a new game?", "", JOptionPane.YES_NO_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION){
					
					//Reset buttons state
					disableGameButtons();
					btnRoll.setEnabled(true);
					btnReset.setEnabled(false);
					
					//Reset label values
					lblDie1.setText("6");
					lblDie2.setText("6");
					lblCurrentScoreNum.setText("78");
					
					//If achieved: Replace current low score with new lower score
					if(currentScore < lowestScore){
						lblLowScoreNum.setText(String.format("%,d", currentScore));
					}
					//Reset current score
					currentScore = 78;
					
					//Set focus on roll button
					btnRoll.requestFocusInWindow();
				}
			}
		}
	}
}
