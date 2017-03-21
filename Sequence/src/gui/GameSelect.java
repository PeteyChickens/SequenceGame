package gui;

import javax.swing.JFrame;
import javax.swing.SwingConstants;

import first.SequenceFSM;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import java.awt.Component;
import javax.swing.JButton;

public class GameSelect extends JFrame {

	private JFrame frame;
	public SequenceFSM sFSM;
	private JTextField selectGameText;
	private JTextField numPlayersText;
	private JTextField typeOfPlayerText;
	private JComboBox selectGameCB;
	private JComboBox numPlayerCB;
	private JComboBox typeOfPlayersCB;
	
	//creates Arrays of Strings for the type of players you would like to select.
	private String[] tpcb2P = {"Human vs Human", "Human vs AI"};
	private String[] tpcb3P = {"Human vs Human vs Human", "Human vs Human vs AI", "Human vs AI vs AI"};
	private String[] tpcb4P = {"Two Humans vs Two Humans", "Two Humans vs Two AI"};
	
	private JButton backButton;
	private JButton startGameBTN;
	
	/**
	 * Create the frame.
	 */
	public GameSelect(SequenceFSM sFSM) {
		this.sFSM = sFSM;
		initialize();
	}
	
	//Initialize the contents of the frame
	public void initialize() {
	
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{375, 1062, 359, 0};
		gbl_contentPane.rowHeights = new int[]{104, 48, 94, 71, 106, 60, 180, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gbl_contentPane);
		
		//creates select game text
		selectGameText = new JTextField();
		selectGameText.setBackground(Color.WHITE);
		selectGameText.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		selectGameText.setForeground(Color.BLUE);
		selectGameText.setEditable(false);
		selectGameText.setHorizontalAlignment(SwingConstants.CENTER);
		selectGameText.setBorder(null);
		selectGameText.setText("Select Game:");
		GridBagConstraints gbc_selectGame = new GridBagConstraints();
		gbc_selectGame.insets = new Insets(0, 0, 5, 5);
		gbc_selectGame.fill = GridBagConstraints.HORIZONTAL;
		gbc_selectGame.gridx = 1;
		gbc_selectGame.gridy = 0;
		selectGameText.setColumns(10);
		frame.getContentPane().add(selectGameText, gbc_selectGame);
		
		//creates the combobox to select which type of game you would like to play
		String[] sgcb = {"Classic", "Dice", "States & Capitals"};
		selectGameCB = new JComboBox(sgcb);
		selectGameCB.setForeground(new Color(255, 69, 0));
		selectGameCB.setFont(new Font("Tahoma", Font.ITALIC, 13));
		selectGameCB.setAlignmentX(Component.LEFT_ALIGNMENT);
		selectGameCB.setBorder(null);
		GridBagConstraints gbc_selectGameCB = new GridBagConstraints();
		gbc_selectGameCB.insets = new Insets(0, 0, 5, 5);
		gbc_selectGameCB.gridx = 1;
		gbc_selectGameCB.gridy = 1;
		frame.getContentPane().add(selectGameCB, gbc_selectGameCB);
		
		//creates text for the amount of players you would like
		numPlayersText = new JTextField();
		numPlayersText.setForeground(new Color(255, 215, 0));
		numPlayersText.setText("Number of Players:");
		numPlayersText.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		numPlayersText.setHorizontalAlignment(SwingConstants.CENTER);
		numPlayersText.setBorder(null);
		GridBagConstraints gbc_numPlayersText = new GridBagConstraints();
		gbc_numPlayersText.insets = new Insets(0, 0, 5, 5);
		gbc_numPlayersText.fill = GridBagConstraints.HORIZONTAL;
		gbc_numPlayersText.gridx = 1;
		gbc_numPlayersText.gridy = 2;
		numPlayersText.setColumns(10);
		frame.getContentPane().add(numPlayersText, gbc_numPlayersText);
		
		//creates the combobox to select the number of players you would like
		String[] npcb = {"Two", "Three", "Four"};
		numPlayerCB = new JComboBox(npcb);
		numPlayerCB.setForeground(new Color(255, 0, 255));
		numPlayerCB.setFont(new Font("Tahoma", Font.ITALIC, 13));
		numPlayerCB.setBackground(new Color(255, 255, 255));
		numPlayerCB.setAlignmentX(Component.LEFT_ALIGNMENT);
		numPlayerCB.setBorder(null);
		numPlayerCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeTypeOfPlayerCB(numPlayerCB.getSelectedItem().toString());
			}
		});
		GridBagConstraints gbc_numPlayerCB = new GridBagConstraints();
		gbc_numPlayerCB.insets = new Insets(0, 0, 5, 5);
		gbc_numPlayerCB.gridx = 1;
		gbc_numPlayerCB.gridy = 3;
		frame.getContentPane().add(numPlayerCB, gbc_numPlayerCB);
		
		//creates the text field for which types of player you would like
		typeOfPlayerText = new JTextField();
		typeOfPlayerText.setBackground(new Color(255, 255, 255));
		typeOfPlayerText.setHorizontalAlignment(SwingConstants.CENTER);
		typeOfPlayerText.setForeground(new Color(128, 0, 0));
		typeOfPlayerText.setFont(new Font("Tahoma", Font.ITALIC, 17));
		typeOfPlayerText.setEditable(false);
		typeOfPlayerText.setText("Human or AI:");
		typeOfPlayerText.setBorder(null);
		GridBagConstraints gbc_typeOfPlayerText = new GridBagConstraints();
		gbc_typeOfPlayerText.insets = new Insets(0, 0, 5, 5);
		gbc_typeOfPlayerText.fill = GridBagConstraints.HORIZONTAL;
		gbc_typeOfPlayerText.gridx = 1;
		gbc_typeOfPlayerText.gridy = 4;
		frame.getContentPane().add(typeOfPlayerText, gbc_typeOfPlayerText);
		typeOfPlayerText.setColumns(10);
		
		//creates the combobox to select the type of players you would like
		typeOfPlayersCB = new JComboBox(tpcb2P);
		typeOfPlayersCB.setFont(new Font("Tahoma", Font.ITALIC, 13));
		typeOfPlayersCB.setAlignmentX(Component.LEFT_ALIGNMENT);
		typeOfPlayersCB.setBorder(null);
		GridBagConstraints gbc_typeOfPlayersCB = new GridBagConstraints();
		gbc_typeOfPlayersCB.insets = new Insets(0, 0, 5, 5);
		gbc_typeOfPlayersCB.gridx = 1;
		gbc_typeOfPlayersCB.gridy = 5;
		frame.getContentPane().add(typeOfPlayersCB, gbc_typeOfPlayersCB);
		
		//creates the back button to return to the main menu
		backButton = new JButton("Back");
		backButton.setBackground(Color.BLACK);
		backButton.setForeground(Color.GRAY);
		backButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				sFSM.startMenu(sFSM);
			}
		});
		GridBagConstraints gbc_backButton = new GridBagConstraints();
		gbc_backButton.insets = new Insets(0, 0, 0, 5);
		gbc_backButton.gridx = 0;
		gbc_backButton.gridy = 6;
		frame.getContentPane().add(backButton, gbc_backButton);
		
		//creates the button to start the game you had selected
		startGameBTN = new JButton("Start Game");
		startGameBTN.setForeground(Color.RED);
		startGameBTN.setBackground(Color.BLACK);
		startGameBTN.setFont(new Font("Tahoma", Font.BOLD, 17));
		startGameBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				sFSM.beginNewGame(selectGameCB.getSelectedItem().toString(), numPlayerCB.getSelectedItem().toString(), typeOfPlayersCB.getSelectedItem().toString());
			}
		});
		GridBagConstraints gbc_startGameBTN = new GridBagConstraints();
		gbc_startGameBTN.gridx = 2;
		gbc_startGameBTN.gridy = 6;
		frame.getContentPane().add(startGameBTN, gbc_startGameBTN);
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
	}
	
	/*
	 * Param npSel: the number of players selected at that time.
	 * Changes what you can select for what type of players you would like to play with.
	 */
	public void changeTypeOfPlayerCB(String npSel) {
		typeOfPlayersCB.removeAllItems();
		if(npSel.equals("Two")) {
			for(int y = 0; y < tpcb2P.length; y++) {
				typeOfPlayersCB.addItem(tpcb2P[y]);
			}
		}else if(npSel.equals("Three")) {
			for(int y = 0; y < tpcb3P.length; y++) {
				typeOfPlayersCB.addItem(tpcb3P[y]);
			}
		}else if(npSel.equals("Four")) {
			for(int y = 0; y < tpcb4P.length; y++) {
				typeOfPlayersCB.addItem(tpcb4P[y]);
			}
		}
	}

}
