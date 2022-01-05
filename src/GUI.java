import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import java.awt.ComponentOrientation;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class GUI extends JFrame 
{
	public GUI() 
	{
		Image gayIcon;
		Image biIcon;
		Image pressedGayIcon;
		Image pressedBiIcon;
		try {
			
			gayIcon = ImageIO.read(new File ("GayIcon.png"));
			biIcon = ImageIO.read(new File ("BiIcon.png"));
			pressedGayIcon = ImageIO.read(new File ("GayIcon_Pressed.png"));
			pressedBiIcon = ImageIO.read(new File ("BiIcon_Pressed.png"));
		
		setMinimumSize(new Dimension(800, 660));
		setPreferredSize(new Dimension(800, 660));
		getContentPane().setBackground(new Color(255, 192, 203));
		getContentPane().setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		GameBoard game_board = new GameBoard();
		game_board.setPreferredSize(new Dimension(600, 600));
		game_board.setMinimumSize(new Dimension(600, 600));
		game_board.setSize(new Dimension(600, 600));
		game_board.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		GridBagConstraints gbc_game_board = new GridBagConstraints();
		gbc_game_board.gridheight = 3;
		gbc_game_board.insets = new Insets(0, 0, 5, 5);
		gbc_game_board.fill = GridBagConstraints.BOTH;
		gbc_game_board.gridx = 0;
		gbc_game_board.gridy = 0;
		getContentPane().add(game_board, gbc_game_board);
		game_board.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel info_pane = new JPanel();
		info_pane.setBackground(new Color(255, 192, 203));
		info_pane.setSize(new Dimension(200, 600));
		info_pane.setPreferredSize(new Dimension(200, 600));
		info_pane.setMinimumSize(new Dimension(200, 600));
		GridBagConstraints gbc_info_pane = new GridBagConstraints();
		gbc_info_pane.gridheight = 0;
		gbc_info_pane.fill = GridBagConstraints.BOTH;
		gbc_info_pane.gridx = 1;
		gbc_info_pane.gridy = 0;
		getContentPane().add(info_pane, gbc_info_pane);
		GridBagLayout gbl_info_pane = new GridBagLayout();
		gbl_info_pane.columnWidths = new int[]{93, 93, 0};
		gbl_info_pane.rowHeights = new int[]{91, 91, 91, 91, 91, 91, 0};
		gbl_info_pane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_info_pane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		info_pane.setLayout(gbl_info_pane);
		
		JLabel lblNewLabel = new JLabel("Health:");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		info_pane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel healthPanel = new JLabel("100");
		healthPanel.setForeground(new Color(255, 255, 0));
		healthPanel.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 20));
		GridBagConstraints gbc_healthPanel = new GridBagConstraints();
		gbc_healthPanel.fill = GridBagConstraints.BOTH;
		gbc_healthPanel.insets = new Insets(0, 0, 5, 0);
		gbc_healthPanel.gridx = 1;
		gbc_healthPanel.gridy = 0;
		info_pane.add(healthPanel, gbc_healthPanel);
		
		JLabel lblNewLabel_1 = new JLabel("Money:");
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setAlignmentY(Component.TOP_ALIGNMENT);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		info_pane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel moneyPanel = new JLabel("100");	//how to update this...
		moneyPanel.setForeground(new Color(255, 255, 0));
		moneyPanel.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 20));
		GridBagConstraints gbc_moneyPanel = new GridBagConstraints();
		gbc_moneyPanel.fill = GridBagConstraints.BOTH;
		gbc_moneyPanel.insets = new Insets(0, 0, 5, 0);
		gbc_moneyPanel.gridx = 1;
		gbc_moneyPanel.gridy = 1;
		info_pane.add(moneyPanel, gbc_moneyPanel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(gayIcon));
		btnNewButton.setPressedIcon(new ImageIcon (pressedGayIcon));
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				((GameBoard) game_board).setActiveGay(true);
				game_board.repaint();
				game_board.giveMText(moneyPanel);
			}
		});
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(153, 204, 255), new Color(30, 144, 255), new Color(30, 144, 255), new Color(0, 102, 204)));
		btnNewButton.setBackground(new Color(30, 144, 255));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 2;
		info_pane.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(biIcon));
		btnNewButton_1.setPressedIcon(new ImageIcon (pressedBiIcon));
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				((GameBoard) game_board).setActiveBi(true);
				game_board.repaint();
				game_board.giveMText(moneyPanel);
				
			}
		});
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(153, 204, 255), new Color(30, 144, 255), new Color(30, 144, 255), new Color(0, 102, 204)));
		btnNewButton_1.setBackground(new Color(30, 144, 255));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 2;
		info_pane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(153, 204, 255), new Color(30, 144, 255), new Color(30, 144, 255), new Color(0, 102, 204)));
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setBackground(new Color(102, 153, 204));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 3;
		info_pane.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(153, 204, 255), new Color(30, 144, 255), new Color(30, 144, 255), new Color(0, 102, 204)));
		btnNewButton_3.setEnabled(false);
		btnNewButton_3.setBackground(new Color(102, 153, 204));
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 1;
		gbc_btnNewButton_3.gridy = 3;
		info_pane.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(153, 204, 255), new Color(30, 144, 255), new Color(30, 144, 255), new Color(0, 102, 204)));
		btnNewButton_4.setEnabled(false);
		btnNewButton_4.setBackground(new Color(102, 153, 204));
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 0;
		gbc_btnNewButton_4.gridy = 4;
		info_pane.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(153, 204, 255), new Color(30, 144, 255), new Color(30, 144, 255), new Color(0, 102, 204)));
		btnNewButton_5.setEnabled(false);
		btnNewButton_5.setBackground(new Color(102, 153, 204));
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_5.gridx = 1;
		gbc_btnNewButton_5.gridy = 4;
		info_pane.add(btnNewButton_5, gbc_btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("START");
		btnNewButton_6.setForeground(new Color(255, 255, 0));
		btnNewButton_6.setBackground(new Color(30, 144, 255));
		btnNewButton_6.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				((GameBoard) game_board).setStart(true);
				game_board.repaint();
				game_board.giveText(healthPanel);
			}
		});
		btnNewButton_6.setFont(new Font("MV Boli", Font.BOLD, 25));
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.gridwidth = 2;
		gbc_btnNewButton_6.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_6.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_6.gridx = 0;
		gbc_btnNewButton_6.gridy = 5;
		info_pane.add(btnNewButton_6, gbc_btnNewButton_6);
		
		setLocation(new Point(200, 200));
		setTitle("Gay Tower Defense");
		setSize(new Dimension(800, 660));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setVisible(true);
	}

	public static void main(String[] args) 
	{new GUI();}
}
