package gui;

import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JTextField;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import first.SequenceFSM;

public class MainMenu extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField txtSequence;
	public SequenceFSM sFSM;
	private JButton exitButton;

	/**
	 * Create the application.
	 */
	public MainMenu(SequenceFSM sFSM) {
		this.sFSM = sFSM;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{1356, 0};
		gridBagLayout.rowHeights = new int[]{186, 135, 0, 52, 0, 54, 44, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		txtSequence = new JTextField();
		txtSequence.setEditable(false);
		txtSequence.setHorizontalAlignment(SwingConstants.CENTER);
		txtSequence.setBackground(Color.WHITE);
		txtSequence.setFont(new Font("Tahoma", Font.BOLD, 40));
		txtSequence.setForeground(Color.BLUE);
		txtSequence.setText("SEQUENCE");
		txtSequence.setBorder(null);
		GridBagConstraints gbc_txtSequence = new GridBagConstraints();
		gbc_txtSequence.insets = new Insets(0, 0, 5, 0);
		gbc_txtSequence.gridx = 0;
		gbc_txtSequence.gridy = 0;
		frame.getContentPane().add(txtSequence, gbc_txtSequence);
		txtSequence.setColumns(10);
		
		//Creates the button to go to the game select frame
		JButton btnPlay = new JButton("PLAY");
		btnPlay.setBackground(Color.LIGHT_GRAY);
		btnPlay.setForeground(Color.BLUE);
		btnPlay.setFont(new Font("Tahoma", Font.BOLD, 14));
		//btnPlay.addActionListener(new ButtonListener(sFSM));
		btnPlay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				sFSM.startGameSelect(sFSM);
			}
		});
		GridBagConstraints gbc_btnPlay = new GridBagConstraints();
		gbc_btnPlay.insets = new Insets(0, 0, 5, 0);
		gbc_btnPlay.gridx = 0;
		gbc_btnPlay.gridy = 2;
		frame.getContentPane().add(btnPlay, gbc_btnPlay);
		
		//Creates the button to go to the rules frame
		JButton btnRulesOfThe = new JButton("RULES OF THE GAMES");
		btnRulesOfThe.setForeground(Color.BLUE);
		btnRulesOfThe.setBackground(Color.LIGHT_GRAY);
		btnRulesOfThe.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_btnRulesOfThe = new GridBagConstraints();
		gbc_btnRulesOfThe.insets = new Insets(0, 0, 5, 0);
		gbc_btnRulesOfThe.gridx = 0;
		gbc_btnRulesOfThe.gridy = 4;
		frame.getContentPane().add(btnRulesOfThe, gbc_btnRulesOfThe);
		
		//exit button to leave the game
		exitButton = new JButton("EXIT GAME");
		exitButton.setBackground(Color.LIGHT_GRAY);
		exitButton.setForeground(Color.BLUE);
		exitButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		GridBagConstraints gbc_exitButton = new GridBagConstraints();
		gbc_exitButton.gridx = 0;
		gbc_exitButton.gridy = 6;
		frame.getContentPane().add(exitButton, gbc_exitButton);

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
	}
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

}
