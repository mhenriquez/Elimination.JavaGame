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
		
		//Set size and lock it
		setSize(720, 250);
		setResizable(false);
		
		//Center window to screen
		setLocationRelativeTo(null);
		
		//Initialize UI
		initUserInterface();
		
		//Render JFrame
		setVisible(visible); //<== Must be added last to render JFrame components correctly
	}
	
	//Methods
	
	private void initUserInterface() {
		
		//set new border layout for JFrame
		setLayout(new BorderLayout());
		
		//ButtonGroup
		ButtonGroup BtnGroup = new ButtonGroup();
		BtnGroup.add(rdoWhite);
		BtnGroup.add(rdoGray);
		BtnGroup.add(rdoYellow);
		
		//Add components to north panel
		pnlNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		pnlNorth.add(lblDiceRoll);
		pnlNorth.add(lblDie1);
		pnlNorth.add(lblDie2);
		
		//Add components to west panel
		pnlWest.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
		pnlWest.setPreferredSize(new Dimension(120,200));
		pnlWest.add(lblLowScore);
		pnlWest.add(lblLowScoreNum);
		
		//Add components to east panel
		pnlEast.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
		pnlEast.setPreferredSize(new Dimension(120,200));
		pnlEast.add(lblCurrentScore);
		pnlEast.add(lblCurrentScoreNum);
		
		//Add components to center panel
		pnlCenter.setLayout(new GridLayout(2, 6));
		pnlCenter.setPreferredSize(new Dimension(450,200));
		pnlCenter.add(btn1);
		pnlCenter.add(btn2);
		pnlCenter.add(btn3);
		pnlCenter.add(btn4);
		pnlCenter.add(btn5);
		pnlCenter.add(btn6);
		pnlCenter.add(btn7);
		pnlCenter.add(btn8);
		pnlCenter.add(btn9);
		pnlCenter.add(btn10);
		pnlCenter.add(btn11);
		pnlCenter.add(btn12);
		
		//Add components to top of south panel
		pnlSouthTop.setLayout(new BoxLayout(pnlSouthTop, BoxLayout.LINE_AXIS));
		pnlSouthTop.add(rdoWhite);
		pnlSouthTop.add(Box.createRigidArea(new Dimension(100,43)));
		pnlSouthTop.add(rdoGray);
		pnlSouthTop.add(Box.createRigidArea(new Dimension(100,43)));
		pnlSouthTop.add(rdoYellow);
		
		//Add components to bottom of south panel
		pnlSouthBtm.setLayout(new BoxLayout(pnlSouthBtm, BoxLayout.LINE_AXIS));
		//
		pnlSouthBtm.add(btnRules);
		btnRules.addActionListener(this);
		//
		pnlSouthBtm.add(btnRoll);
		btnRoll.addActionListener(this);
		btnRoll.setToolTipText("Click to Roll Dice.");
		//
		pnlSouthBtm.add(btnReset);
		btnReset.addActionListener(this);
		btnReset.setEnabled(false);
		
		//Add top and bottom panels to south panel
		pnlSouth.setLayout(new BoxLayout(pnlSouth, BoxLayout.PAGE_AXIS));
		pnlSouth.setPreferredSize(new Dimension(0,80));
		pnlSouth.add(pnlSouthTop);
		pnlSouth.add(pnlSouthBtm);
		
		//Add JPanel elements to JFrame
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlEast, BorderLayout.EAST);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlWest, BorderLayout.WEST);
		add(pnlSouth, BorderLayout.SOUTH);
		
		disableGameButtons();
	}
	
	private void showGameRules(){
		JOptionPane.showMessageDialog(null, PLAY_RULES, "Rules For Playing", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void disableGameButtons(){
		btn1.setEnabled(false);
		btn2.setEnabled(false);
		btn3.setEnabled(false);
		btn4.setEnabled(false);
		btn5.setEnabled(false);
		btn6.setEnabled(false);
		btn7.setEnabled(false);
		btn8.setEnabled(false);
		btn9.setEnabled(false);
		btn10.setEnabled(false);
		btn11.setEnabled(false);
		btn12.setEnabled(false);
	}
	
	private void enableGameButtons(){
		btn1.setEnabled(true);
		btn2.setEnabled(true);
		btn3.setEnabled(true);
		btn4.setEnabled(true);
		btn5.setEnabled(true);
		btn6.setEnabled(true);
		btn7.setEnabled(true);
		btn8.setEnabled(true);
		btn9.setEnabled(true);
		btn10.setEnabled(true);
		btn11.setEnabled(true);
		btn12.setEnabled(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source instanceof JButton){
			if(source == btnRules){
				showGameRules();
			}else if(source == btnRoll){
				enableGameButtons();
				btnReset.setEnabled(true);
				//lblDie1.setText(String.format("%,d", Math.rint(die1)));
				//lblDie2.setText(String.format("%,d", Math.rint(die2)));
			}else if(source == btnReset){
				lblLowScoreNum.setText(String.format("%,d", lowestScore));
				lblCurrentScoreNum.setText(String.format("%,d", currentScore));
				lblDie1.setText(String.format("%,d", 6));
				lblDie2.setText(String.format("%,d", 6));
				lowestScore = 78;
				currentScore = 78;
				disableGameButtons();
				btnReset.setEnabled(false);
			}
		}
	}
	
}
