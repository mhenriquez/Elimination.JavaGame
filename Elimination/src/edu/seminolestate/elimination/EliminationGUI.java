package edu.seminolestate.elimination;

import java.awt.*;
import java.awt.event.*;
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
	private int lowestScore = 78;
	private int currentScore = 78;
	
	//Constants
	private static final String PLAY_RULES = "The object of Elimination is to eliminate as many of the numbered "
			+ "buttons to achieve as low a score as possible. Press \'Roll\' to roll the dice, then press "
			+ "the corresponding number buttons whether choosing the individual die values or the sum of "
			+ "the die values.";
	
	//JPanels
	private JPanel panelNorth = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
	private JPanel panelWest = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 5));
	private JPanel panelCenter = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
	private JPanel panelEast = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 5));
	private JPanel panelSouth1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
	private JPanel panelSouth2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
	
	//JButtons
	private JButton btn1 = new JButton("1");
	private JButton btn2 = new JButton("2");
	private JButton btn3 = new JButton("3");
	private JButton btn4 = new JButton("4");
	private JButton btn5 = new JButton("5");
	private JButton btn6 = new JButton("6");
	private JButton btn7 = new JButton("7");
	private JButton btn8 = new JButton("8");
	private JButton btn9 = new JButton("9");
	private JButton btn10 = new JButton("10");
	private JButton btn11 = new JButton("11");
	private JButton btn12 = new JButton("12");
	//
	private JButton btnRules = new JButton("Rules");
	private JButton btnRoll = new JButton("Roll");
	private JButton btnReset = new JButton("Reset");
	
	//JLabels
	private JLabel lblDiceRoll = new JLabel("Dice Roll: ");
	private JLabel lblDie1 = new JLabel(String.format("%,d", die1));
	private JLabel lblDie2 = new JLabel(String.format("%,d", die2));
	//
	private JLabel lblCurrentScore = new JLabel("Current Score");
	private JLabel lblCurrentScoreNum = new JLabel(String.format("%,d", currentScore));
	//
	private JLabel lblLowScore = new JLabel("Lowest Score");
	private JLabel lblLowScoreNum = new JLabel(String.format("%,d", lowestScore));
	
	//JRadioButtons
	private JRadioButton rdoWhite = new JRadioButton("White", false);
	private JRadioButton rdoGray = new JRadioButton("Gray", false);
	private JRadioButton rdoYellow = new JRadioButton("Yellow", false);
	
	//Default Constructor
	public EliminationGUI(String title, boolean visible) {
		super(title);
		setSize(690, 270);
		setResizable(false);
		initUserInterface();
		setVisible(visible); //<== Must be added last to render JFrame components correctly
	}
	
	//Methods
	
	private void initUserInterface() {
		//set new border layout
		setLayout(new BorderLayout());
		
		//Add components to north panel
		panelNorth.add(lblDiceRoll);
		panelNorth.add(lblDie1);
		panelNorth.add(lblDie2);
		
		//Add components to west panel
		panelWest.setPreferredSize(new Dimension(120, 200));
		panelWest.add(lblLowScore);
		panelWest.add(lblLowScoreNum);
		
		//Add components to east panel
		panelEast.setPreferredSize(new Dimension(120, 200));
		panelEast.add(lblCurrentScore);
		panelEast.add(lblCurrentScoreNum);
		
		//Add components to center panel
		panelCenter.add(btn1);
		panelCenter.add(btn2);
		panelCenter.add(btn3);
		panelCenter.add(btn4);
		panelCenter.add(btn5);
		panelCenter.add(btn6);
		panelCenter.add(btn7);
		panelCenter.add(btn8);
		panelCenter.add(btn9);
		panelCenter.add(btn10);
		panelCenter.add(btn11);
		panelCenter.add(btn12);
		
		//Add components to south panel
		//
		
		//Add elements to JFrame
		add(panelNorth, BorderLayout.NORTH);
		add(panelEast, BorderLayout.EAST);
		add(panelCenter, BorderLayout.CENTER);
		add(panelWest, BorderLayout.WEST);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source instanceof JButton){
			if(source == btnRules){
				JOptionPane.showMessageDialog(null, "Rules For Playing", PLAY_RULES, JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
}
